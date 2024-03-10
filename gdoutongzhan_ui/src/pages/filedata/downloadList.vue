
<template>
  <div class="app-container">
    <!-- 添加按钮 -->
    <el-button type="primary" size="small" @click="dialogVisible=true">添加</el-button>

    <!-- 添加对话框 -->
    <el-dialog title="添加" :visible.sync="dialogVisible" width="65%" :show-close="false">
      <h2 style="text-align: center">添加文件</h2>

      <el-form label-width="120px" style="marginTop:15px">

        <el-form-item label="文件名称" prop="title">
          <el-input v-model="fileData.name" placeholder="填写文件名" />
        </el-form-item>

        <el-form-item label="添加文件">
          <el-upload ref="upload" 
            :on-remove="handleRemove" 
            :on-change="handleChange"
            :data="fileData" 
            :auto-upload="false" 
            class="upload-demo" 
            drag action="http://localhost:9104/servicefile/filedownload/file/upload" 
            multiple>
            <i class="el-icon-upload" />
            <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
          </el-upload>
        <!-- :on-preview="handlePictureCardPreview"  -->
        </el-form-item>

      </el-form>
      <!-- 底部 -->
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveOrUpdate()">确 定</el-button>
      </span>
    </el-dialog>

    <!-- 文件列表 -->
    <el-table :data="list" :border=true style="width:100%;marginTop:15px">

      <el-table-column label="序号" width="150" align="center">
        <template slot-scope="scope">
          {{ (p.current - 1) * p.number + scope.$index + 1 }}
        </template>
      </el-table-column>

      <el-table-column prop="title" label="文件名称" width="700" align="center"  />

      <el-table-column prop="releaseTime" label="添加时间" align="center"/>

      <el-table-column label="操作" align="center" >
        <template slot-scope="scope">
          <el-button type="danger" size="mini" icon="el-icon-delete" @click="removeDataById(scope.row, scope.$index)">删除文件</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <!-- 分页器 -->
    <el-pagination 
        layout="prev, pager, next,jumper" 
        :total="total" 
        :current-page="p.current" 
        :page-size="p.number" 
        @current-change="handleCurrentChange">
    </el-pagination>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name:"DownloadList",
  data() {
    return {
      list: [],
      total: 0, // 数据库中的总记录数
      p:{current:1,number:8},
      dialogVisible: false,   //添加对话框显示
      fileData: { name: '', info: '' } //文件信息
    }
  },
  methods: {
    getDownloadList() {
      axios({
        methods: 'get',
        url: 'http://localhost:9104/servicefile/filedownload/file/fileSelectByPage',
        params: {
          current: this.p.current,
          number:this.p.number
        }
      }).then(value => {
        let result = value.data.t
        this.list = result.files
        this.total=result.totalNum
      }).catch(error => {
        console.log('查找下载专区资源失败');
      })
    },
    saveOrUpdate() {
      this.$refs.upload.submit()
      this.dialogVisible=false
      alert('添加成功')
      this.p.current=1
      this.getDownloadList()
      this.$refs.upload.clearFiles()  //清空上一次的文件列表
      this.fileData = { name: '', info: '' }
    },
    // 根据id删除数据
    removeDataById(item, index) {
      this.$axios.post('http://localhost:9104/servicefile/filedownload/file/deleteById', {id: item.id}).then(res => {
        alert('删除成功')
        this.p.current=1
        this.getDownloadList()
        })
    },
    handleChange(file) {
      this.fileData.imgName = file.name
      console.log(this.fileData);
    },
    // 文件列表移除文件时的钩子
    handleRemove(file, fileList) {
      console.log(file, fileList)
    },
    //分页切换
    handleCurrentChange(pager) {
      this.p.current = pager
      this.getDownloadList()
    }
  },
  mounted() {
    this.getDownloadList()
  }
}
</script>

<style scoped>
  ::v-deep  .el-pagination{
  position: absolute;
  top: 650px;
  left: 45%;
}
</style>

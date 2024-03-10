1<template>
  <div class="app-container">
    <!-- 添加按钮   v-if="hasPerm('role.add')"原先button属性"-->
    <el-button  type="primary" size="small" @click="AddPictureVisible=true">添加</el-button>

    <!-- 添加对话框 -->
    <el-dialog title="添加" :visible.sync="AddPictureVisible" :show-close="false" width="65%" >
      <h2 style="text-align: center">添加轮播图</h2>

      <el-form ref="ban" label-width="120px" style="marginTop:15px">
        <el-form-item label="轮播图名称" prop="title">
          <el-input v-model="fileData.name" placeholder="请填写轮播图名称" />
        </el-form-item>
        <el-form-item label="轮播图素材">
          <el-upload 
            ref="upload" 
            :on-preview="handlePictureCardPreview" 
            :on-remove="handleRemove" 
            :on-change="handleChange" 
            :data="fileData" 
            :auto-upload="false" 
            class="upload-demo" 
            action="http://localhost:9103/lunbotuservice/lunbotu/lunBoTu/upload" 
            list-type="picture-card"
          >
            <i slot="default" class="el-icon-plus" />
          </el-upload>
          <!-- 图片预览放大功能 -->
          <el-dialog :visible.sync="dialogVisible" :modal="false" :center="true" >
            <img :src="dialogImageUrl" width="85%" alt="" />
          </el-dialog> 
        </el-form-item>
        <el-form-item label="轮播图说明">
          <el-input v-model="fileData.info" placeholder="填写轮播图说明" />
        </el-form-item>
      </el-form>

      <!-- 底部 -->
      <span slot="footer" class="dialog-footer">
        <el-button @click="AddPictureVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveOrUpdate">确 定</el-button>
      </span>
    </el-dialog>

    <!-- 列表展示区 -->
    <el-table :data="list" :border=true  style="width: 100%;marginTop:15px" >

      <el-table-column label="序号" width="150" align="center">
        <template slot-scope="scope">
          {{ (p.current - 1) * p.number + scope.$index + 1 }}
        </template>
      </el-table-column>

      <el-table-column prop="name" label="名称" align="center" width="300" />

      <el-table-column prop="imgUrl" label="压缩图" align="center" width="350">
        <template slot-scope="scope">
          <img :src="scope.row.imgUrl" width="100" height="80" />
        </template>
      </el-table-column>

      <el-table-column prop="info" label="说明" width="300" align="center" />

      <el-table-column label="操作" align="center">
        <template slot-scope="scope">
          <el-button type="danger" size="mini" icon="el-icon-delete" @click="removeDataById(scope.row, scope.$index)" />
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
import axios from 'axios'
export default {
  name:'PictureList',
  data() {
    return {
      list: [],
      total: 0, // 数据库中的总记录数
      p:{current:1,number:4},
      fileData: { name: '', info: '' },   //轮播图信息
      dialogImageUrl: '',
      dialogVisible: false,         //图片预览放大功能
      AddPictureVisible: false,    //添加对话框是否打开
      disabled: false,
    }
  },
  methods: {
    // 获取所有轮播图
    getPictureList() {
      axios({
        methods: 'GET',
        url: 'http://localhost:9103/lunbotuservice/lunbotu/lunbotu/selectByPage',
        params: {
          current: this.p.current,
          number:this.p.number
        }
      }).then(value => {
        let result = value.data.t
        this.list = result.lunbotus
        this.total=result.totalNum
      }).catch(error => {
        console.log('查找轮播图资源失败');
      })
    },
    // 确认上传轮播图
    saveOrUpdate() {
      this.$refs.upload.submit()
      this.AddPictureVisible = false
      alert('添加成功')
      this.p.current=1
      this.getPictureList()
      this.$refs.upload.clearFiles()  //清空上一次的图片列表
      this.fileData = { name: '', info: '' }     //清空上一次的图片信息
      this.dialogImageUrl=''
    },
    // 根据id删除轮播图
    removeDataById(item, index) {
      this.$axios.post('http://localhost:9103/lunbotuservice/lunbotu/lunBoTu/delete', { id: item.id }).then(res => {
          this.p.current=1
          this.getPictureList()
          alert('删除成功')
        })
      this.getPictureList()
    },
    handleChange(file) {
        this.fileData.imgName = file.name
      },
    handleRemove(file, fileList) {
        console.log(file, fileList)
      },
    handlePictureCardPreview(file) {
        this.dialogImageUrl = file.url
        this.dialogVisible = true
    },
    // 分页器
    handleCurrentChange(pager) {
      this.p.current = pager
      this.getPictureList()
    }
  },
  mounted() {
    this.getPictureList()
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

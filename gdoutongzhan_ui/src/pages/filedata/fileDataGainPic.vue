<template>
  <div>
    <!-- 添加轮播图功能 -->
    <el-button  type="primary" size="small" @click="AddPictureVisible=true">添加</el-button>
    <el-dialog title="添加" :visible.sync="AddPictureVisible" :show-close="false" width="65%" >
      <h2 style="text-align: center">添加轮播图</h2>
      <el-form  label-width="120px" style="marginTop:15px">
        <el-form-item label="轮播图名称" prop="title">
          <el-input v-model="fileData.title" placeholder="请填写轮播图名称" />
        </el-form-item>
        <el-form-item label="轮播图类型"  style="marginTop:10px;">
          <el-select v-model="fileData.type" clearable placeholder="请选择文章所属类型" >
            <el-option
              v-for="item in typeOption"
              :key="item.id"
              :label="item.type"
              :value="item.id">
            </el-option>
          </el-select> 
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
            action="http://localhost:9108/servicefile/AchievementOfPhoto/upload" 
            list-type="picture-card"
          >
            <i slot="default" class="el-icon-plus" />
          </el-upload>
          <!-- 图片预览放大功能 -->
          <el-dialog :visible.sync="dialogVisible" :modal="false" :center="true" >
            <img :src="dialogImageUrl" width="85%" alt="" />
          </el-dialog> 
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="AddPictureVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveOrUpdate">确 定</el-button>
      </span>
    </el-dialog>

    <!-- 选择器查询功能 -->
    <template>
      <el-select v-model="searchTypeValue" clearable placeholder="请选择分类"  style="marginLeft:10px" size="small" >
        <el-option
          v-for="item in typeOption"
          :key="item.id"
          :label="item.type"
          :value="item.id">
        </el-option>
      </el-select>
      <el-button type="primary" style="marginLeft:10px" size="small" @click="searchPic"> 
          <i class="el-icon-search" style="marginright:5px"></i>查询
      </el-button>
      <el-button style="marginLeft:10px" size="small" @click="reset"> 查询所有</el-button>
    </template>

    <!-- 列表展示区 -->
    <el-table :data="list" :border=true  style="width: 100%;marginTop:15px" >
      <el-table-column prop="title" label="名称" align="center" />
      <el-table-column prop="imgUrl" label="压缩图" align="center" width="300">
        <template slot-scope="scope">
          <img :src="scope.row.imgUrl" width="100" height="80" />
        </template>
      </el-table-column>
      <el-table-column prop="type" label="分类" align="center" width="200" />
      <el-table-column label="操作" align="center"  width="200">
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
import {reqPicType,reqGetAllPic,reqGetTypePic,reqRemovePic} from "@/api/fileData/gainPic"

export default {
  name: 'fileDataGainPic',
  data() {
    return {
      AddPictureVisible: false,//添加对话框是否打开
      dialogVisible:false,//图片预览放大功能
      fileData: { title: "",type:""},//轮播图信息
      searchTypeValue:"",//查询参数
      dialogImageUrl: "",//图片URL
      typeOption: [],
      list:[],
      p: {
      current: 1,
      number:4
      },
      total: 0,
      flag:true          //分页是查询还是获取数据的标志
      }
  },
  watch: {
    searchTypeValue:{
      deep: true,
      handler(newVal, oldVal) {
       this.p.current=1
      }
    }
  },
  methods: {
    //获取图片类型
    async getPicType() {
      try {
        let { t : res} = await reqPicType()
        this.typeOption = res
      }catch(error){
        console.log(error);
      }
    },
    //获取所有图片
    async getAllPic() {
      try {
        let result = await reqGetAllPic(this.p)
        console.log(result);
        this.list = result.t.list
        this.total = result.t.total
      } catch (error) {
        console.log(error);
      }
    },
    handlePictureCardPreview(file) { 
      this.dialogImageUrl = file.url
      this.dialogVisible = true
    },
    handleRemove(file, fileList) { 
      console.log(file, fileList)
    },
    handleChange(file) {
      this.fileData.imgName = file.name
    },
    //保存上传图片
    saveOrUpdate() {
      this.$refs.upload.submit()
      this.AddPictureVisible = false
      alert('添加成功')
      this.p.current=1
      this.getAllPic()
      this.$refs.upload.clearFiles()  //清空上一次的图片列表
      this.fileData = { title: '', type: '' }     //清空上一次的图片信息
      this.dialogImageUrl=''
    },
    //按类别查询图片
    async searchPic() { 
      if (this.searchTypeValue) {
        try {
        let result = await reqGetTypePic(this.searchTypeValue, this.p)
        this.list = result.list
        this.total = result.total
        this.flag=false
      } catch (error) {
        console.log(error);
      }  
      } else {
        alert("请输入查询分类")
      }
      
    },
    //查询全部图片
    reset() {
      this.searchTypeValue = ""
      this.p.current = 1
      this.flag=true
      this.getAllPic()
    },
    //删除图片
    async removeDataById(item,index) { 
      try {
        await reqRemovePic(item.id, item.imgName)
        this.p.current = 1
        this.getAllPic()
        alert("删除成功")
      } catch (error) {
        console.log(error);
      }
    },
    //分页器切换页数
    handleCurrentChange(pager) {
      this.p.current = pager
      if (this.flag) {
        this.getAllPic()
      } else {
        this.searchPic()
      }
    }
  },
  mounted() {
    this.getPicType()
    this.getAllPic()
  }
}
</script>

<style scoped>
.cell{
  text-align: center;
}

::v-deep  .el-pagination{
  position: absolute;
  top: 650px;
  left: 45%;
}
</style>
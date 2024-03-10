<template>
  <div>
    <!-- 发布文章功能 -->
    <el-button type="primary" size="small" @click="dialogFormVisible = true">发布</el-button>
    <el-dialog title="发布文章" 
        :visible.sync="dialogFormVisible" 
        :show-close="false" 
        width="1200px"
        top="3vh"
    >
      <h2 style="textAlign:center">文章发布</h2>
      <el-form :inline="true"  class="demo-form-inline" >
        <el-form-item label="文章标题"  style="marginTop:10px; marginLeft:120px">
          <el-input v-model="uploadData.articleTitle" placeholder="请输入文章标题" style="width:300px">
          </el-input>
        </el-form-item>
        <el-form-item label="文章类型"  style="marginTop:10px; marginLeft:200px">
          <el-select v-model="uploadData.typeValue" clearable placeholder="请选择文章所属类型" style="marginLeft:20px">
            <el-option
              v-for="item in uploadTypeOption"
              :key="item.id"
              :label="item.type"
              :value="item.id">
            </el-option>
          </el-select> 
        </el-form-item>
        <el-form-item label="文章作者"  style="marginTop:10px; marginLeft:120px" >
          <el-input v-model="uploadData.articleAuth" placeholder="请输入文章作者" style="width:300px"></el-input>
        </el-form-item>
        <el-form-item label="文章内容"  >
          <quill-editor v-model="uploadData.content" ref="myQuillEditor"></quill-editor>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer" >
        <el-button @click="dialogVisible">取 消</el-button>
        <el-button type="primary"  @click="saveAdd">确 定</el-button>
      </div>

    </el-dialog>

    <!-- 选择器查询功能 -->
    <template>
      <el-select v-model="searchTypeValue" clearable placeholder="请选择分类"  style="marginLeft:10px" size="small" >
        <el-option
          v-for="item in uploadTypeOption"
          :key="item.id"
          :label="item.type"
          :value="item.id">
        </el-option>
      </el-select>
      <el-button type="primary" style="marginLeft:10px" size="small" @click="searchArticl"> 
          <i class="el-icon-search" style="marginright:5px"></i>查询
      </el-button>
      <el-button style="marginLeft:10px" size="small" @click="reset"> 查询所有</el-button>
    </template>

    <!-- 修改文章功能 -->
    <el-button size="small" style="marginLeft:10px" @click="updataNumberFormVisible">修改</el-button>
    <el-dialog title="修改文章" 
      :visible.sync="updataFormVisible" 
      :show-close="false" 
      width="1200px"
      top="3vh"
    >
      <h2 style="textAlign:center">修改文章</h2>
      <el-form :inline="true"  class="demo-form-inline" ref="updataArtForm">
        <el-form-item label="文章标题"  style="marginTop:10px; marginLeft:120px">
            <el-input v-model="updataData.articleTitle" placeholder="请输入文章标题" style="width:300px"></el-input>
        </el-form-item>
        <el-form-item label="文章类型"  style="marginTop:10px; marginLeft:200px">
          <el-select v-model="updataData.typeValue" clearable placeholder="请选择所属类型" style="marginLeft:20px">
            <el-option
              v-for="item in updataTypeOption"
              :key="item.id"
              :label="item.type"
              :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="文章作者"  style="marginTop:10px; marginLeft:120px" >
          <el-input v-model="updataData.articleAuth" placeholder="请输入文章作者" style="width:300px"></el-input>
        </el-form-item>
        <el-form-item label="文章内容"  >
          <quill-editor v-model="updataData.content" ref="myQuillEditor"></quill-editor>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer" >
        <el-button @click="updataVisible">取 消</el-button>
        <el-button type="primary"  @click="saveUpdata">确 定</el-button>
      </div>  
    </el-dialog>

    <!-- 删除功能 -->
    <el-button  type="danger" size="small" style="marginLeft:10px" @click="removeArt">删除</el-button> 

    <!-- 展示区 -->
    <el-table 
      :data="list"
      :border='true'
      :total="total"
      style="width:100%;margin-top: 10px;"
      @selection-change="handleSelectionChange" 
    >
    <el-table-column label="勾选" width="55px" type="selection" align="center"></el-table-column>
    <el-table-column prop="title" label="文章名称" align="center"></el-table-column>
    <el-table-column prop="type" label="文章分类"  align="center"></el-table-column>
    <el-table-column prop="updateTime" label="添加日期" width="200px" align="center"></el-table-column>
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
import {reqArtType,reqAllArt,reqAddArt,reqSearchTypeArt,reqRemoveArt,reqUpdataArt,reqGetArticleToUpdata} from "@/api/fileData/gainArt"
export default {
  name: "fileDataGainArt",
  data() {
    return {
      dialogFormVisible: false,//上传对话框变量
      updataFormVisible: false,//修改对话框变量
      uploadData: { articleTitle: "", articleAuth: "", typeValue: "", content: "" },//上传新增变量
      updataData: { articleTitle: "", articleAuth: "", typeValue: "", content: "" },//修改文章变量
      uploadTypeOption: [],
      searchTypeValue: "",//查询种类
      list: [],//文章列表
      total: 0,//获取文章总数
      p: {                //发起查询的参数
        current: 1,
        number: 6,
      },
      flag:true
    }
  },
  computed: {
    id() {
      return this.$store.state.gainArt.id
    },
    updataTypeOption() {
      return this.uploadTypeOption
    },
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
    //搜索特定种类文章
    async searchArticl() {
      if (this.searchTypeValue) {
        try {
          let result = await reqSearchTypeArt(this.searchTypeValue, this.p)
          this.total = result.t.total
          this.list = result.t.list
          this.flag=false
      } catch (error) {
        console.log("error.message");
      }
      } else {
        alert("请选择查询分类")
      }
    },
    //搜索全部文章
    reset() {
      this.searchTypeValue = ""
      this.p.current = 1
      this.flag=true
      this.getAllArt()
    },
    //确认上传
    async saveAdd() {
      try {
        if (this.uploadData.articleTitle.trim()
          && this.uploadData.typeValue
          && this.uploadData.articleAuth.trim()
          && this.uploadData.content){
          const res = await reqAddArt(this.uploadData)
          this.searchTypeValue = ''
          this.flag = true
          alert("发布成功")
          this.getAllArt()
          this.dialogVisible()
        } else {
          alert("请输入完整信息")
        }
      } catch (error) {
        alert("发布失败")
      }
    },
    //修改文章
    async saveUpdata() {
      try {
        if (this.updataData.articleTitle.trim()
          && this.updataData.typeValue
          && this.updataData.articleAuth.trim()
          && this.updataData.content) {
          console.log();
          const result = await reqUpdataArt(this.id[0],this.updataData)
          this.searchTypeValue = ""
          this.p.current = 1
          this.flag = true
          alert("修改成功")
          this.getAllArt()
          this.updataVisible()
        } else {
          alert("请输入完整内容")
        }
      }
      catch (error) { 
        alert("修改文章失败",error.message)
      }
    },
    //关闭上传对话框 重置表单
    dialogVisible() {
      this.uploadData.articleTitle=""
      this.uploadData.typeValue=""
      this.uploadData.content=""
      this.uploadData.articleAuth=""
      this.dialogFormVisible = false;
    },
    //关闭修改对话框 重置表单
    updataVisible() {
      this.updataData.articleTitle=""
      this.updataData.typeValue=""
      this.updataData.content=""
      this.updataData.articleAuth=""
      this.updataFormVisible = false;
    },
    //判断当前勾选个数，修改文章一次只能修改一个
    async updataNumberFormVisible() {
      if (this.id.length === 0) {
        alert("请勾选修改的内容")
      } else if (this.id.length === 1) {
        // 展示当前内容，方便用户修改
        const result = await reqGetArticleToUpdata(this.id[0])
        this.updataData.articleAuth = result.t.author
        this.updataData.articleTitle = result.t.title
        this.updataData.typeValue = result.t.type
        this.updataData.content = result.t.content
        this.updataFormVisible=true
      } else if (this.id.length > 1) {
        alert("至多修改一篇文章")
      }
    },
    //删除文章
    async removeArt() {
      if (this.id.length !== 0) {
        try {
          for (let i = 0; i < this.id.length; i++) {
            let result = await reqRemoveArt(this.id[i])
          }
          this.searchTypeValue=""
          this.p.current = 1
          this.flag = true
          alert('删除成功')
          this.getAllArt()
      } catch (error) {
        alert(error.message)
      }
      } else {
        alert("未选择任何项")
      }
    },
    //展示选中以后
    handleSelectionChange(msg) {
      let idArr = []
      msg.forEach((item) => {
        idArr.push(item.id)
      })
      this.$store.dispatch("gainArt/SelectionChange", idArr)
    },
    //展示选中的页面
    handleCurrentChange(pager) {
      this.p.current = pager
      if (this.flag) {
        this.getAllArt()
      } else {
        this.getArticleType()
      }
    },
    //获取文章类别
    async getArticleType() {
      try {
        let result = await reqArtType()
        this.uploadTypeOption=result.t
      } catch (error) {
        console.log(error);
      }
    },
    //获取所有文章
    async getAllArt() {
      try {
        let result = await reqAllArt(this.p)
        this.list = result.t.list
        this.total=result.t.total
      } catch (error) {
        console.log(error);
      }
    }
  },
  mounted() {
    this.getArticleType()
    this.getAllArt()
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
::v-deep .ql-editor{
  min-height: 250px;
}
</style>
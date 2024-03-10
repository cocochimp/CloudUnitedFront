<template>
  <div>
    <!-- 发布功能 --> 
      <el-button type="primary" size="small" @click="dialogFormVisible = true">发布</el-button>
      <el-dialog title="发布文章" 
        :visible.sync="dialogFormVisible" 
        :show-close="false" 
        width="1200px"
        top="3vh"
      >
        <h2 style="textAlign:center">文章发布</h2>

        <el-form :inline="true"  class="demo-form-inline" ref="addArtForm">
          <el-form-item label="文章标题"  style="marginTop:10px; marginLeft:120px">
            <el-input v-model="uploadData.articleTitle" placeholder="请输入文章标题" style="width:300px"></el-input>
          </el-form-item>

          <el-form-item label="文章类型"  style="marginTop:10px; marginLeft:200px">
            <el-select v-model="uploadData.typeValue" clearable placeholder="请选择所属类型" style="marginLeft:20px">
              <el-option
                v-for="item in typeOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
                
          <el-form-item label="文章作者"  style="marginTop:10px; marginLeft:120px" >
            <el-input v-model="uploadData.articleAuth" placeholder="请输入文章作者" style="width:300px"></el-input>
          </el-form-item>

          <el-form-item label="文章位置"  style="marginTop:10px; marginLeft:200px">
            <el-select v-model="uploadData.pubValue" clearable placeholder="请选择文章发布的位置" style="marginLeft:20px">
              <el-option
                v-for="item in pubOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
                
          <el-form-item label="文章内容"  >
            <quill-editor v-model="uploadData.content" ref="myQuillEditor"></quill-editor>
          </el-form-item>
        </el-form>

        <div slot="footer" class="dialog-footer" >
          <el-button @click="dialogVisible">取 消</el-button>
          <el-button type="primary"  @click="saveAdd()">确 定</el-button>
        </div>

      </el-dialog>
    
    <!-- 选择器查询功能 -->
      <template>
        <el-select v-model="showTable.searchValue" clearable placeholder="请选择分类"  style="marginLeft:10px" size="small" >
          <el-option
            v-for="item in typeOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>

        <el-button type="primary" style="marginLeft:10px" size="small" @click="searchArticl"> 
          <i class="el-icon-search" style="marginright:5px"></i>查询
        </el-button>

        <el-button style="marginLeft:10px" size="small" @click="reset"> 查询所有</el-button>
      </template>
      
    <!-- 修改功能 -->
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
                :key="item.value"
                :label="item.label"
                :value="item.value">
               </el-option>
            </el-select>
          </el-form-item>
                  
          <el-form-item label="文章作者"  style="marginTop:10px; marginLeft:120px" >
            <el-input v-model="updataData.articleAuth" placeholder="请输入文章标题" style="width:300px"></el-input>
          </el-form-item>

          <el-form-item label="文章位置"  style="marginTop:10px; marginLeft:200px">
            <el-select v-model="updataData.pubValue" clearable placeholder="请选择文章发布的位置" style="marginLeft:20px">
              <el-option
                v-for="item in updataPubOption"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
                  
          <el-form-item label="文章内容"  >
            <quill-editor v-model="updataData.content" ref="myQuillEditor"></quill-editor>
          </el-form-item>
        </el-form>

        <div slot="footer" class="dialog-footer" >
          <el-button @click="updataVisible">取 消</el-button>
          <el-button type="primary"  @click="saveUpdata()">确 定</el-button>
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
        <el-table-column prop="type" label="所属党派"  align="center"></el-table-column>
        <el-table-column prop="position" label="位置" align="center" ></el-table-column>
        <el-table-column prop="releaseTime" label="添加日期" width="200px" align="center"></el-table-column>
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
import { reqGetArticle, reqAddArticle, reqRemoveArticle, reqUpdataArticle,reqSearchArticle,reqGetArticleToUpdata } from "@/api/fileData/politics"

export default {
  name: "politics",
  data() {
    return {
      typeOptions: [
        {
        value: "通知公告",
        label: "通知公告"
      }, {
        value: "统战动态",
        label: "统战动态"
      }, {
        value: "党派园地",
        label:"党派园地"
        },{
        value: "民革",
        label: "民革"
        },{
        value: "民盟",
        label: "民盟"
        },{
        value: "民建",
        label: "民建"
        },{
        value: "民进",
        label: "民进"
        }, {
        value: "农工",
        label:"农工"
        },{
        value: "致公",
        label: "致公"
        }, {
        value: "九三",
        label:"九三"
        },{
        value: "非党派",
        label: "非党派"
        },{
        value: "人大代表",
        label:"人大代表"
        },{
        value: "政协委员",
        label:"政协委员"
        },{
        value: "其他党派人士",
        label:"其他党派人士"
        }],
      pubOptions: [{
        value: "首页",
        label:"首页"
      }, 
        {
        value: "民主党派",
        label:"民主党派"
      },{
        value: "无党派人士",
        label:"无党派人士"
      },{
        value: "参政议政",
        label:"参政议政"
      }
      ],
      list:[],
      dialogFormVisible: false,
      updataFormVisible:false,
      showTable:{
        searchValue: "",
      },
      uploadData: { articleTitle: "", articleAuth: "", typeValue: "", pubValue: "",content:""},
      updataData: { id:"",articleTitle: "", articleAuth: "", typeValue: "", pubValue: "",content:""},
      p: {                //发起查询的参数
        current: 1,
        number: 6,
      },
      total: 0,
      flag:true          //分页是查询还是获取数据的标志
    }
  },
  computed: {
    pid() {
      return this.$store.state.politics.pid
    },
    updataTypeOption() {
      return this.typeOptions
    },
    updataPubOption() {
      return this.pubOptions
    }
  },
  watch: {
    showTable:{
      deep: true,
      handler(newVal, oldVal) {
       this.p.current=1
      }
    }
  },
  methods: {
    // 获取数据
    async getArticeleData() {
        try { 
          let result = await reqGetArticle(this.p)
          this.list = result.Article
          this.total = result.totalNum
        }catch(error){}
    },

    //展示选中的页面
    handleCurrentChange(pager) {
      this.p.current = pager
      if (this.flag) {
        this.getArticeleData()
      } else {
        this.searchArticl()
      }
    },

    //展示选中以后
    handleSelectionChange(msg) {
      let idArr = []
      msg.forEach((item) => {
        idArr.push(item.id)
      })
      this.$store.dispatch("politics/SelectionChange", idArr)
    },

    //判断当前勾选个数，修改文章一次只能修改一个
    async updataNumberFormVisible() {
      if (this.pid.length === 0) {
        alert("请勾选修改的内容")
      } else if (this.pid.length === 1) {
        // 展示当前内容，方便用户修改
        const result = await reqGetArticleToUpdata(this.pid[0])
        this.updataData.articleAuth = result.author
        this.updataData.articleTitle = result.title
        this.updataData.typeValue = result.type
        this.updataData.pubValue = result.position
        this.updataData.content = result.content
        this.updataFormVisible=true
      } else if (this.pid.length > 1) {
        alert("至多修改一篇文章")
      }
    },

    //修改文章
    async saveUpdata() {
      try {
        if (this.updataData.articleTitle.trim()
          && this.updataData.typeValue
          && this.updataData.pubValue
          && this.updataData.articleAuth.trim()
          && this.updataData.content) {
          const fd = new FormData()
          this.updataData.id=this.pid[0]
          fd.append('id', this.updataData.id)
          fd.append('title', this.updataData.articleTitle)
          fd.append('type', this.updataData.typeValue)
          fd.append('position', this.updataData.pubValue)
          fd.append('content', this.updataData.content)
          fd.append('author', this.updataData.articleAuth)
          const result = await reqUpdataArticle(fd)
          this.showTable.searchValue = ""
          this.p.current = 1
          this.flag = true
          alert("修改成功")
          this.getArticeleData()
          this.updataVisible()
        } else {
          alert("请输入完整内容")
        }
      }
      catch (error) { 
        alert("修改文章失败",error.message)
      }
    },
    
    //删除文章
    async removeArt() {
      if (this.pid.length !== 0) {
        try {
          for (let i = 0; i < this.pid.length; i++) {
            let result = await reqRemoveArticle(this.pid[i])
          }
          this.showTable.searchValue = ""
          this.p.current = 1
          this.flag = true
          alert('删除成功')
          this.getArticeleData()
      } catch (error) {
        alert(error.message)
      }
      } else {
        alert("未选择任何项")
      }
    },

    //查询指定
    async searchArticl() {
      if (this.showTable.searchValue) {
        try {
        let result = await reqSearchArticle(this.showTable, this.p)
        console.log(result)
        this.total = result.totalNum
        this.list = result.Article
        this.flag=false
      } catch (error) {
        console.log("error.message");
      }
      } else {
        alert("请选择查询分类")
      }
    },

    //查询所有
    reset() {
      this.showTable.searchValue = ""
      this.p.current = 1
      this.flag=true
      this.getArticeleData()
    },

    //确认上传
    async saveAdd() {
      try {
        if (this.uploadData.articleTitle.trim()
          && this.uploadData.typeValue
          && this.uploadData.pubValue
          && this.uploadData.articleAuth.trim()
          && this.uploadData.content) {
            const  fd = new FormData()
            fd.append('title', this.uploadData.articleTitle)
            fd.append('type', this.uploadData.typeValue)
            fd.append('position', this.uploadData.pubValue)
            fd.append('content', this.uploadData.content)
            fd.append('author',this.uploadData.articleAuth)
            const res = await reqAddArticle(fd)
            this.showTable.searchValue = ''
            this.flag=true
            alert("发布成功")
            this.getArticeleData()
            this.dialogVisible()
        } else {
            alert("请输入完整信息")
          }
      } catch (error) {
        alert("发布失败")
      }
    },

    //关闭上传对话框 重置表单
    dialogVisible() {
      this.uploadData.articleTitle=""
      this.uploadData.typeValue=""
      this.uploadData.pubValue=""
      this.uploadData.content=""
      this.uploadData.articleAuth=""
      this.dialogFormVisible = false;
    },

    //关闭修改对话框 重置表单
    updataVisible() {
      this.updataData.articleTitle=""
      this.updataData.typeValue=""
      this.updataData.pubValue=""
      this.updataData.content=""
      this.updataData.articleAuth=""
      this.updataFormVisible = false;
    }
  },
  created() {
    this.getArticeleData()
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
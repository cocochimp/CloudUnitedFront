<template>
  <div>
  <!-- 新增上传 -->
    <el-button type="primary" @click="addDialogVisible()" size="small">资料上传</el-button>
    <el-dialog title="新增上传" :visible.sync="dialogFormVisible" :show-close="false" >

      <h2 style="textAlign:center;marginBottom:10px">资料上传</h2>

      <el-form label-width="120px" >
          <el-form-item label="获奖人" prop="people">
            <el-input v-model="fileData.name" placeholder="请填写获奖人" @blur="getPersonId" />
          </el-form-item>

          <el-form-item label="奖励名称" prop="title">
            <el-input v-model="fileData.pPriceName" placeholder="请填写具体名称" />
          </el-form-item>

          <el-form-item label="奖励等级"  style="marginTop:10px" >
            <el-select v-model="fileData.pLevel" clearable placeholder="请选择奖励等级" >
                      <el-option
                      v-for="item in levOptions"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
            </el-select>
          </el-form-item>
          
          <el-form-item label="添加文件">
            <el-upload ref="upload"          
              :auto-upload="false" 
              :http-request="fileUpload"
              :file-list="fileList" 
              :on-remove="handleRemove" 
              
              class="upload-demo" 
              action="#"
              drag  
              multiple>
            <i class="el-icon-upload" />
            <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
            <div slot="tip" class="el-upload__tip" style="color:red">支持PDF,Word等文件</div>
            </el-upload>
          </el-form-item>
      </el-form>
      
      <div slot="footer" class="dialog-footer">
        <el-button  @click="dialogVisible()">取 消</el-button>
        <el-button type="primary"  @click="saveAdd()">确 定</el-button>
      </div>
    </el-dialog>

  <!-- 修改功能 -->
    <el-button size="small" style="marginLeft:10px" @click="alterReward()" >修改</el-button>
    <el-dialog title="修改信息" :visible.sync="alterFormVisible" :show-close="false">

      <h2 style="textAlign:center">修改信息</h2>

      <el-form label-width="120px">
          <el-form-item label="获奖人" prop="people">
            <el-input v-model="fileData.name" placeholder="请填写获奖人" @blur="getPersonId"/>
          </el-form-item>

          <el-form-item label="奖励名称" prop="title">
            <el-input v-model="fileData.pPriceName" placeholder="请填写具体名称" />
          </el-form-item>

          <el-form-item label="奖励等级"  style="marginTop:10px" >
            <el-select v-model="fileData.pLevel" clearable placeholder="请选择奖励等级" >
                      <el-option
                      v-for="item in levOptions"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="添加文件">
            <el-upload ref="update"          
              :auto-upload="false"
              :http-request="fileUpload"
              :file-list="fileList"
              :on-remove="handleRemove"
              class="upload-demo" 
              action="#"
              drag  
              multiple>
            <i class="el-icon-upload" />
            <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
            <div slot="tip" class="el-upload__tip" style="color:red">支持PDF,Word等文件</div>
            </el-upload>
          </el-form-item>
      </el-form>

      <div slot="footer" class="dialog-footer">
        <el-button  @click="alterClose()">取 消</el-button>
        <el-button type="primary"  @click="saveUpdate()">确 定</el-button>
      </div>
    </el-dialog>
  
  <!-- 删除功能 -->
    <el-button  type="danger" size="small" style="marginLeft:10px" @click="removeData">删除</el-button>

  <!-- 查询功能 -->
    <template>
    <el-form :inline="true"  class="demo-form-inline">
      <el-form-item label="获奖人员"  style="marginTop:10px">
        <el-input v-model=" searchMsg.searchPerson" placeholder="请输入获奖人名" size="small"></el-input>
      </el-form-item>
      <el-form-item label="获奖名称" style="marginTop:10px">
        <el-input  v-model=" searchMsg.searchReward" placeholder="请输入获奖名称" size="small"></el-input>
      </el-form-item>
      <el-form-item>
      <el-button type="primary"  size="small" style="marginTop:14px" @click="searchReward">查询</el-button>
      <el-button style="marginLeft:10px" size="small" @click="reset">查询所有</el-button>
      </el-form-item>
    </el-form>
    </template>

  <!-- 展示区 -->
    <el-table :data="rewardData" style="width:100%" :border=true  @selection-change="handleSelectionChange">
      <el-table-column label="勾选" width="55px" type="selection" align="center">
      </el-table-column>
      <el-table-column prop="name" label="获奖人" align="center" >
      </el-table-column>
      <el-table-column prop="ppriceName" label="获奖名称" align="center">
      </el-table-column>
      <el-table-column prop="puploadTime" label="日期" align="center">
      </el-table-column>    
    </el-table>
   
  <!-- 分页器 -->
    <el-pagination 
      layout="prev,pager,next,jumper"
      :total="total"
      :current-current.sync="p.current" 
      :page-size="p.number" 
      @current-change="handleCurrentChange">
    </el-pagination> 
    <!-- style="marginTop:100px; textAlign:center"  -->
    </div>
</template>

<script>
import { reqRewardData, reqRewardAddMsg, reqRewardRemove, reqRewardUpdataMsg, reqRewardSearch, reqRewardFile, reqPersonId,reqRewardId } from "@/api/fileData/reward"

export default {
  name: "reward",
  data() {
    return {
      fileData: {
        id: "",
        name: "",
        pPriceName: "",
        pLevel: "",
      },
      fileList:[],
      dialogFormVisible: false, //上传功能对话框
      alterFormVisible:false,   //修改功能对话框
      multipleSelection: [],
      levOptions: [{
        value: "省级",
        label:"省级"
      }, {
        value: "国家级",
        label:"国家级"
      }],
      searchMsg: {        //查询需要用的变量
        searchReward: null,
        searchPerson: null,
      },
      rewardData: [],
      p: {                //发起查询的参数
        current: 1,
        number: 6
      },
      total: 0,
      flag:true
    }
  },
  computed: {
    pid() {
      return this.$store.state.reward.pid
    },
  },
  watch: {
    searchMsg: {
      deep: true,
      handler(newVal, oldVal) {
        this.p.current=1
      }
    }
  },
  methods: {
    async fileUpload(info) {
      const {file} =info
      const fd = new FormData()
      fd.append("file", file);
      fd.append("pid",this.fileData.id)
      try { 
        let result = await reqRewardFile(fd)
        this.fileList=[]
      } catch (error) {
        alert(error.message)
      }
    },
    handleRemove(file,fileList) {
      console.log(file,fileList);
    },

    //页码框获取相应页数的数据
    handleCurrentChange(pager) {
      this.p.current = pager
      if (this.flag) {
        this.getRewardData()
      } else {
        this.searchReward()
      }
    },

    //展示选中以后
    handleSelectionChange(msg) {
      let idArr = []
      msg.forEach((item) => {
        idArr.push(item.pid)
      })
      this.$store.dispatch("reward/SelectionChange", idArr)
    },


    //判断勾选按钮的个数，修改功能只能勾选一个
    async alterReward() {
        if (this.pid.length === 0) {
        alert("请勾选修改的内容")
      } else if(this.pid.length === 1){
          this.alterFormVisible = true
          const result = await reqRewardId(this.pid[0])
          this.fileData.name = result.data.name
          this.fileData.pLevel = result.data.plevel
          this.fileData.pPriceName = result.data.ppriceName
      } else if (this.pid.length > 1) {
        alert("至多修改一条信息")
      }
    },

    //关闭新增上传功能对话框
    dialogVisible() {
      this.fileData.id = ""
      this.fileData.name = ""
      this.fileData.pPriceName = ""
      this.fileData.pLevel = ""
      this.dialogFormVisible=false
    },

    //打开新增上传功能对话框
    addDialogVisible() {
      this.fileData.id = ""
      this.fileData.name = ""
      this.fileData.pPriceName = ""
      this.fileData.pLevel = ""
      this.dialogFormVisible=true
    },

    //修改功能对话框
    alterClose() {
      this.fileData.id = ""
      this.fileData.name = ""
      this.fileData.pPriceName = ""
      this.fileData.pLevel = ""
      this.alterFormVisible = false
    },

    //获取用户数据
    async getRewardData() {
      try {
        const result = await reqRewardData(this.p)
        console.log(result);
        result.data.prices.forEach((item) => {
          item.puploadTime = item.puploadTime.slice(0, 10)
        })
        this.rewardData = result.data.prices
        this.total = result.data.total
      } catch (error) {
        alert(error.message)
      }
    },

    //获取用户ID
    async getPersonId() {
      if (this.fileData.name) {
        let result = await reqPersonId(this.fileData.name)
        if (result.data.length) {
          this.fileData.id = result.data[0].id
        } else {
          this.fileData.name=""
          alert("当前系统无数据，请输入正确姓名");
        }
      }
    },

    //新增上传提交
    async saveAdd() {
      if (this.fileData.name && this.fileData.pPriceName.trim() && this.fileData.pLevel) {
        //调用上传文件信息
        try {
          let result = await reqRewardAddMsg(this.fileData)
          this.$refs.upload.submit();
          this.fileData.id = ""
          this.fileData.name = ""
          this.fileData.pPriceName = ""
          this.fileData.pLevel = ""
          this.dialogFormVisible = false
          this.getRewardData()
          alert("上传成功")
        } catch (error) {
          alert("上传连接失败")
        }  
      } else {
        alert("请输入完整的获奖信息")
      }
    },

    //修改提交
    async saveUpdate() {
      if (this.fileData.name && this.fileData.pPriceName.trim()  && this.fileData.pLevel) {
        const updataMsg = {
          id: this.fileData.id,
          pid: this.pid[0],
          name: this.fileData.name,
          pPriceName: this.fileData.pPriceName,
          pLevel:this.fileData.pLevel
        }
        let result = await reqRewardUpdataMsg(updataMsg)
        this.$refs.update.submit();
        this.fileData.id = ""
        this.fileData.name = ""
        this.fileData.pPriceName = ""
        this.fileData.pLevel = ""
        this.alterFormVisible = false
        this.getRewardData()
        alert("修改成功")
      } else {
        alert("请输入完整的获奖信息")
      }
    },

     //删除功能
    async removeData() {
      if (this.pid.length !== 0) {
        try {
          for (let i = 0; i < this.pid.length; i++) {
            let result = await reqRewardRemove(this.pid[i])
          }
          this.getRewardData()
        } catch (error) {
          // alert(error.message)
        }
      } else {
        alert("未选择任何项")
      }
    },

    //查询文章  
    async searchReward() {
      if (this.searchMsg.searchReward || this.searchMsg.searchPerson) {
        try {    
          let result = await reqRewardSearch(this.searchMsg,this.p)
          result.data.prices.forEach(item => {
              item.puploadTime = item.puploadTime.slice(0, 10)
          })
          this.searchMsg.searchPerson=null
          this.searchMsg.searchReward=null
          this.rewardData = result.data.prices
          this.total = result.data.total
          this.flag = false
        }catch (error) {
          alert(error.message)
        }
      } else {
        alert("请输入查询内容")
      }
    },

    //查询所有
    reset() {
      this.searchMsg.searchPerson=null
      this.searchMsg.searchReward = null
      this.p.current=1
      this.flag=true
      this.getRewardData()
    }
  },
  created() {
    //获取获奖数据
    this.getRewardData()
  }
}
</script>

<style scoped>
::v-deep  .el-pagination{
  position: absolute;
  top: 650px;
  left: 45%;
}
.cell{
  text-align: center;
}

</style>

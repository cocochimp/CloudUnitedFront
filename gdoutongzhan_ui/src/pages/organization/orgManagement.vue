<template>
  <div>
    <!--按钮-->
    <div class="button-row">
      <el-button type="primary" @click="addData()">添加</el-button>
      <el-button @click="updateData()">修改</el-button>
      <el-button type="danger" @click="removeSome">删除</el-button>
    </div>
    <!--搜索框，从表格中搜索信息-->
    <div class="search-row">
      <el-form :inline="true" class="demo-form-inline">
        <el-form-item>
          <el-input v-model="searchMsg.name" placeholder="组织名称" @keyup.native.enter="searchSome()" clearable />
        </el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="searchSome()">查询</el-button>
      </el-form>
    </div>

    <!--展示表格-->
    <div class="table-row">
      <el-table ref="multipleTable" :row-key="getRowKey" :data="list" tooltip-effect="dark" style="width: 100%"
        :border="true" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" :reserve-selection="true">
        </el-table-column>

        <el-table-column type="index" :index="indexAdd" label="序号" width="160">
        </el-table-column>

        <el-table-column prop="department" label="组织名" width="width">
        </el-table-column>

        <el-table-column prop="sum" label="总人数" width="width">
        </el-table-column>

      </el-table>
      <!--分页器-->
      <el-pagination :current-page="page" :page-sizes="[3, 5, 8]" :page-size="limit"
        @current-change="handleCurrentChange" @size-change="handleSizeChange"
        layout="  prev, pager, next, jumper,->,sizes,total" :total=this.total style="text-align: center">
      </el-pagination>
    </div>
   
   <!--添加弹窗-->
    <el-dialog title="添加信息" :visible.sync="dialogFormVisible" width="80%">
      <!--form表单 :model属性：这个属性的作用是，把表单的数据收集到那个对象上，将来进行表单验证，也需要这个属性-->
      <el-form style="width: 100%" :inline="true" v-model="addForm">
        <el-form-item label="组织类型:" label-width="120px">
          <el-select autocomplete="off" placeholder="请选择学院部门" v-model="addForm.type">
            <el-option value="department" label="基层统战" />
            <el-option value="party" label="民主党派" />
            <el-option value="otherParty" label="群团组织" />
            <el-option value="category" label="参政议政" />
          </el-select>
        </el-form-item>
        <el-form-item label="组织名称:" label-width="120px">
          <el-input autocomplete="off" placeholder="请填入组织名称" v-model="addForm.orgName"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible()">取 消</el-button>
        <el-button type="primary" @click="addDetermine()">确 定</el-button>
      </div>
    </el-dialog>

    <!--修改弹窗-->
    <el-dialog title="修改信息" :visible.sync="alterFormVisible" width="80%">
      <!--form表单 :model属性：这个属性的作用是，把表单的数据收集到那个对象上，将来进行表单验证，也需要这个属性-->
      <el-form style="width: 100%" :inline="true" v-model="updataForm">
        <el-form-item label="组织类型:" label-width="120px">
          <el-select autocomplete="off" placeholder="请选择学院部门" v-model="updataForm.type">
            <el-option value="department" label="基层统战" />
            <el-option value="party" label="民主党派" />
            <el-option value="otherParty" label="群团组织" />
            <el-option value="category" label="参政议政" />
          </el-select>
        </el-form-item>
        <el-form-item label="组织名称:" label-width="120px">
          <el-input autocomplete="off" placeholder="请填入组织名称" v-model="updataForm.orgName"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="alertVisible()">取 消</el-button>
        <el-button type="primary" @click="updataDetermine()">确 定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
import axios from 'axios';
import { get } from "js-cookie";
export default {
  name: "orgManagement",
  data() {
    return {
      multipleSelection: [],
      //代表本页面的二级党组织
      //代表当前分页数第几页
      page: 1,
      //当前页数展示数据条数
      limit: 5,
      //总共展示的数据
      total: 0,
      //查询需要用到的变量
      searchMsg: {
        name: "",
      },
      //列表展示的数据
      list: [],
      //删除勾选的数据
      removeMsg: [],
      //添加对话框显示与隐藏控制的属性
      dialogFormVisible: false,
      //修改对话框显示与隐藏控制的属性
      alterFormVisible:false,
      addForm: {
        type: "",
        orgName: "",
      },
      updataForm:{
        type: "",
        orgName: "",
      }
    };
  },
  methods: {
    //使序号自增
    indexAdd(index) {
      return index + 1 + (this.page - 1) * this.limit;
    },
    //搜索后表格勾选不取消
    getRowKey(row) {
      return row.id
    },
    //获取列表信息
    async getPageList() {
      //解构出参数
      const { page, limit } = this;
      axios
        .get(
          `http://localhost:9109/Organization/ZuZhi/queryAll/${page}/${limit}`,
        )
        .then((res) => {
          this.list = res.data.data.info
          this.total = res.data.data.total
          console.log(this.list)
        })
    },
    //通过点击分页器获取数据
    handleCurrentChange(pager) {
      this.page = pager;
      if(this.searchMsg.name == ""){
        this.getPageList();
      }else{
        this.searchSome();
      }
    },
    //通过改变每页展示的数据重新拉取数据
    handleSizeChange: function (limit) {
      this.limit = limit;
      this.page = 1;
      if(this.searchMsg.name == ""){
        this.getPageList();
      }else{
        this.searchSome();
      }
    },

    //添加按钮，添加信息|
    addData() {
      this.dialogFormVisible = true

    },
    //添加确认按钮
    addDetermine() {
      //外部if判断信息是否都填写完整了，如果信息没有填写完整则会弹窗提示
      if (this.addForm.type
        && this.addForm.orgName) {
          //内部if判断选择的组织类型，然后根据回传的组织类型调用不同的接口
        if (this.addForm.type == "department") {
          var department = this.addForm.orgName
          axios.post("http://localhost:9109/Organization/ZuZhi/Department/insert",
            {
              department
            }
          )
            .then((res) => {
              this.getPageList()
              this.$message({
                message:'基层统战修改成功！！',
                type:'success'
              });
            })
          this.dialogVisible()
        }
        else if (this.addForm.type == "party") {
          var party = this.addForm.orgName
          axios.post("http://localhost:9109/Organization/ZuZhi/Party/insert",
            {
              party
            }
          )
            .then((res) => {
              this.getPageList()  
              this.$message({
                message:'民主党派修改成功！！',
                type:'success'
              });
            })
          this.dialogVisible()
        }
        else if (this.addForm.type == "otherParty") {
          var otherParty = this.addForm.orgName
          axios.post("http://localhost:9109/Organization/ZuZhi/PartyOther/insert",
            {
              otherParty
            }
          )
            .then((res) => {
          this.getPageList()
          this.$message({
                message:'群团组织修改成功！！',
                type:'success'
              });
            })
          this.dialogVisible()
        }
        else if (this.addForm.type == "category") {
          var category = this.addForm.orgName
          axios.post("http://localhost:9109/Organization/ZuZhi/Political/insert",
            {
              category
            }
          )
            .then((res) => {
              this.getPageList()
              this.$message({
                message:'参政议政添加成功！！',
                type:'success'
              });
            })
          this.dialogVisible()
        }
      } else {
        alert("请输入完整信息")
      }
    },
    //关闭添加对话框
    dialogVisible() {
      this.dialogFormVisible = false;
      //清除数据
      this.addForm = {
        type: "",
        orgName: ""
      };
    },

    //点击修改按钮
    updateData() {
      //显示对话框
       if (this.multipleSelection.length === 0) {
        alert("请勾选修改的内容")
      } else if(this.multipleSelection.length === 1){
        this.alterFormVisible=true;
        this.updataForm={
          type:"",
          orgName:this.multipleSelection[0].title
          }
      } else if (this.multipleSelection.length > 1) {
        alert("至多修改一个组织的信息")
      } 
    },
    //修改确认按钮
    updataDetermine(){
       //外部if判断信息是否都填写完整了，如果信息没有填写完整则会弹窗提示
      if (this.updataForm.type
        && this.updataForm.orgName) {
          //内部if判断选择的组织类型，然后根据回传的组织类型调用不同的接口
        if (this.updataForm.type == "department") {
          var department = this.updataForm.orgName
          var id = this.multipleSelection[0].id
          axios.post("http://localhost:9109/Organization/ZuZhi/Department/update",
            {
              id,
              department
            }
          )
            .then((res) => {
              this.getPageList()
              this.$message({
                message:'基层统战修改成功！！！',
                type:'success'
              });
            })
          this.alertVisible()
        }
        else if (this.updataForm.type == "party") {
          var party = this.updataForm.orgName
          var id = this.multipleSelection[0].id
          axios.post("http://localhost:9109/Organization/ZuZhi/Party/update",
            {
              party,
              id
            }
          )
            .then((res) => {
              this.getPageList()
              this.$message({
                message:'民主党派修改成功！！',
                type:'success'
              });
            })
          this.alertVisible()
        }
        else if (this.updataForm.type == "otherParty") {
          var otherParty = this.updataForm.orgName
          var id = this.multipleSelection[0].id
          axios.post("http://localhost:9109/Organization/ZuZhi/PartyOther/update",
            {
              otherParty,
              id
            }
          )
            .then((res) => {
          this.getPageList()
          this.$message({
                message:'群团组织修改成功！！',
                type:'success'
              });
            })
          this.alertVisible()
        }
        else if (this.updataForm.type == "category") {
          var category = this.updataForm.orgName
          var id = this.multipleSelection[0].id
          axios.post("http://localhost:9109/Organization/ZuZhi/Political/update",
            {
              category,
              id
            }
          )
            .then((res) => {
          this.getPageList()
          this.$message({
                message:'参政议政修改成功！！',
                type:'success'
              });
            })
          this.alertVisible()
        }
      } else {
        alert("请输入完整信息")
      }

    },
     //关闭修改对话框
    alertVisible() {
      this.alterFormVisible = false;
      //清除数据
      this.updataForm = {
        type: "",
        orgName: ""
      };
    },

    //勾选时触发
    handleSelectionChange(val) {
      this.multipleSelection = val; //拿到选中数据
      console.log(this.multipleSelection)
    },

      //查询按钮功能
    //只输入了姓名
     searchSome() {
      const { page, limit } = this;
      axios
      .get(
        `http://localhost:9109/Organization/ZuZhi/queryZuZhiMoHu/${this.searchMsg.name}/${page}/${limit}`
      )
      .then((res)=>{
          console.log(res)  
          this.total = res.data.data.total
          this.list = res.data.data.info
        })
    },

    //多选删除功能
    removeSome() {
      for(let i=0;i<this.multipleSelection.length;i++){
        var id = this.multipleSelection[i].id
        axios.post("http://localhost:9109/Organization/ZuZhi/Department/delete",
        {
          id
        })
        .then((res)=>{
          this.getPageList()
        }),
        axios.post("http://localhost:9109/Organization/ZuZhi/Party/delete",
        {
          id
        })
        .then((res)=>{
          this.getPageList()
        }),
        axios.post("http://localhost:9109/Organization/ZuZhi/PartyOthers/delete",
        {
          id
        })
        .then((res)=>{
          this.getPageList()
        }),
        axios.post("http://localhost:9109/Organization/ZuZhi/Political/delete",
        {
          id
        })
        .then((res)=>{
          this.getPageList()
        })
      }
    },
  },

  mounted() {
    this.getPageList();
  },
};
</script>

<style>
.button-row {
  margin-bottom: 15px;
}

.search-row {
  margin-bottom: 15px;
}
</style>
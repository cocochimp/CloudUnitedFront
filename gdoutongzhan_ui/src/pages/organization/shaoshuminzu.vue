<template>
  <div>
    <!--按钮-->
    <div class="button-row">
      <el-button @click="updatedata()">修改</el-button>
      <el-button type="danger" @click="removeSome">删除</el-button>
    </div>
    <!--搜索框，从表格中搜索信息-->
    <div class="search-row">
      <el-form :inline="true" class="demo-form-inline">
        <el-form-item>
          <el-input v-model="searchMsg.name" placeholder="成员名" @keyup.native.enter="searchSome()" clearable/>
        </el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="searchSome()">查询</el-button>
      </el-form>
    </div>
    <!--
      表格组件
      data:表格组件将来需要展示的数据------数组类型
      border:是给表格添加边框
      column属性：
      label：设置表格显示的标题
      width: 对应列的宽度
      algin：标题的对齐方式
      prop：对应列内容的字段名
    -->
    <div class="table-row">
      <el-table ref="multipleTable" :row-key="getRowKey" :data="list" tooltip-effect="dark" style="width: 100%"
        :border="true" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" :reserve-selection="true">
        </el-table-column>

        <el-table-column type="index" :index="indexAdd" label="序号" width="160">
        </el-table-column>

        <el-table-column prop="department" label="学院单位" width="180">
        </el-table-column>

        <el-table-column prop="party" label="所属党派" width="160">
        </el-table-column>

        <el-table-column prop="name" label="主要负责人" width="180">
        </el-table-column>

        <el-table-column prop="phone" label="联系方式" width="200">
        </el-table-column>

        <el-table-column prop="nativePlace" label="地址" width="width">
        </el-table-column>

        <el-table-column prop="o_identity" label="所属组织身份" width="width">
        </el-table-column>

        <el-table-column prop="joinPartyDate" label="参加党派时间" width="width">
        </el-table-column>
      </el-table>
      <!--分页器
          current-page：当前第几页
          total：数据总条数    
          page-size：每一页展示的条数
          latout:实现分页器的布局
          pager-count：按钮的数量
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      -->
      <el-pagination :current-page="page" :page-sizes="[3, 5, 8]" :page-size="limit"
        @current-change="handleCurrentChange" @size-change="handleSizeChange"
        layout="  prev, pager, next, jumper,->,sizes,total" :total=this.total style="text-align: center">
      </el-pagination>
    </div>
    <!--对话框
    :visible.sync:控制对话框显示与隐藏用的
    -->
    <el-dialog title="修改信息" :visible.sync="dialogFormVisible" width="80%">
      <!--form表单 :model属性：这个属性的作用是，把表单的数据收集到那个对象上，将来进行表单验证，也需要这个属性-->
      <el-form style="width: 100%" :inline="true" v-model="modifyForm">
        <el-form-item label="党派类型:" label-width="120px">
          <el-select autocomplete="off" placeholder="请选择党派类型" v-model="modifyForm.partyId">
            <el-option value="6948211641926422539" label="民革" />
            <el-option value="6948211641926422545" label="九三" />
            <el-option value="6948211641926422543" label="农工" />
            <el-option value="6948211641926422541" label="民建" />
            <el-option value="6948211641926422540" label="民盟" />
            <el-option value="6948211641926422542" label="民进" />
            <el-option value="6948211641926422544" label="致公" />
          </el-select>
        </el-form-item>
         <el-form-item label="学院部门:" label-width="120px">
          <el-select autocomplete="off" placeholder="请选择学院部门" v-model="modifyForm.departmentId">
            <el-option value="6948211641926422547" label="水产学院党委" />
            <el-option value="6948211641926422548" label="食品科技学院党委" />
            <el-option value="6948211641926422549" label="海洋与气象学院党委" />
            <el-option value="6948211641926422550" label="滨海农业学院党委" />
            <el-option value="6948211641926422551" label="机械工程学院党委" />
            <el-option value="6948211641926422552" label="海洋工程与能源学院党委" />
            <el-option value="6948211641926422553" label="马克思主义学院党委" />
            <el-option value="6948211641926422554" label="经济学院党委" />
            <el-option value="6948211641926422555" label="管理学院党委" />
            <el-option value="6948211641926422556" label="数学与计算机学院党委" />
            <el-option value="6948211641926422557" label="电子与信息工程学院党委" />
            <el-option value="6948211641926422558" label="化学与环境学院党委" />
            <el-option value="6948211641926422559" label="船舶与海运学院党委" />
            <el-option value="6948231731526897664" label="文学与新闻传播学院党委" />
            <el-option value="6948231731531091968" label="法政学院党委" />
            <el-option value="6948231731531091969" label="外国语学院党委" />
            <el-option value="6948231731531091970" label="中歌艺术学院党委" />
            <el-option value="6948231731531091971" label="体育与休闲学院党委" />
            <el-option value="6948231731531091972" label="机关党委" />
            <el-option value="6948231731531091973" label="离退休干部党委" />
            <el-option value="6948231731531091974" label="教辅单位党委" />
            <el-option value="6948231731531091975" label="后勤与产业党委" />
            <el-option value="6948231731531091976" label="阳江校区党委" />
             <el-option value="6948308286462627903" label="（未说明）" />
          </el-select>
        </el-form-item>
        <el-form-item label="组织身份:" label-width="120px">
          <el-select autocomplete="off" placeholder="请选择党派类型" v-model="modifyForm.organizationId">
            <el-option value="6948307500875666111" label="管理员" />
            <el-option value="6948307500875666112" label="普通成员" />
          </el-select>
        </el-form-item>
        <el-form-item label="主要负责人:" label-width="120px">
          <el-input autocomplete="off" placeholder="请填入姓名" v-model="modifyForm.name"></el-input>
        </el-form-item>
        <el-form-item label="联系方式:" label-width="120px">
          <el-input autocomplete="off" placeholder="请填写手机号" v-model="modifyForm.phone"></el-input>
        </el-form-item>
        <el-form-item label="地址:" label-width="120px">
          <el-input autocomplete="off" placeholder="请填写常住地址" v-model="modifyForm.nativePlace"></el-input>
        </el-form-item>
        <el-form-item label="参加党派时间:" label-width="120px">
          <el-date-picker v-model="modifyForm.joinPartyDate" type="month" placeholder="选择年月" value-format="yyyy-MM">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible()">取 消</el-button>
        <el-button type="primary" @click="addData()">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import axios from 'axios';
import { get } from "js-cookie";
export default {
  name: "WaiGuoYv",
  data() {
    return {
      multipleSelection: [],
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
      modifyForm: {
        partyId: '',
        name: '',
        phone: '',
        nativePlace: '',
        joinPartyDate: '',
        departmentId:'',
        organizationId:''
      },

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
          `http://localhost:9109/Organization/RenWu/National/${page}/${limit}`,
        )
        .then((res)=>{
          //console.log(res)
          this.list=res.data.data.info
          this.total=res.data.data.total
        })
    },
    //通过点击分页器获取数据
    handleCurrentChange(pager) {
      this.page = pager;
      this.getPageList();
    },
    //通过改变每页展示的数据重新拉取数据
    handleSizeChange: function (limit) {
      this.limit = limit;
      this.page = 1;
      this.getPageList();
    },
    //点击修改按钮
    updatedata() {
      //显示对话框
       if (this.multipleSelection.length === 0) {
        alert("请勾选修改的内容")
      } else if(this.multipleSelection.length === 1){
        this.dialogFormVisible=true;
        this.modifyForm = {
        departmentid:'',
        partyid:'',
        organizationId:'',
        name: this.multipleSelection[0].name,
        phone: this.multipleSelection[0].phone,
        nativePlace: this.multipleSelection[0].nativePlace,
        joinPartyDate: this.multipleSelection[0].joinPartyDate,
      };
      } else if (this.multipleSelection.length > 1) {
        alert("至多修改一为成员信息")
      } 
    },
    //修改确认按钮
     addData() {
     if(this.modifyForm.partyId
        &&this.modifyForm.name.trim()
        &&this.modifyForm.phone
        &&this.modifyForm.nativePlace.trim()
        &&this.modifyForm.joinPartyDate
        &&this.modifyForm.departmentId
        &&this.modifyForm.organizationId){
        var id = this.multipleSelection[0].id
        var name = this.modifyForm.name
        var phone = this.modifyForm.phone
        var nativePlace = this.modifyForm.nativePlace
        var joinPartyDate = this.modifyForm.joinPartyDate
        var departmentId = this.modifyForm.departmentId
        var organizationId = this.modifyForm.organizationId
        var partyId = this.modifyForm.partyId
          axios.post("http://localhost:9109/Organization/RenWu/update",
            {
             id,
             name,
             phone,
             nativePlace,
             joinPartyDate,
             departmentId,
             organizationId,
             partyId
            }
      ) 
      .then((res)=>{
        this.getPageList()
        this.$message({
                message:'用户信息修改成功！！！',
                type:'success'
              });
      })
          this.dialogVisible()
        }    
        else{
          alert("请输入完整信息")
        }
    },
    //关闭修改对话框
    dialogVisible() {
      this.dialogFormVisible = false;
      //清除数据
      this.modifyForm = {
        partyid: '',
        name: '',
        phone: '',
        native_place: '',
        join_party_date: '',
        departmentid:''
      };
    },



    //查询按钮功能
    //只输入了姓名
     searchSome() {
      const { page, limit } = this;
      axios
      .get(
        `http://localhost:9109/Organization/RenWu/National/${this.searchMsg.name}/${page}/${limit}`
      )
      .then((res)=>{
        console.log(res)
        this.total = res.data.data.total
        this.list = res.data.data.info
      })
    },

    //勾选时触发
    handleSelectionChange(val) {
      this.multipleSelection = val; //拿到选中数据
      console.log(this.multipleSelection)
    },

    //多选删除功能
   removeSome() {
       for(let i=0;i<this.multipleSelection.length;i++){
        this.removeMsg.push(this.multipleSelection[i].id);
        //const result = await this.$API.Party.reqDelDepartment(this.removeMsg[i]);
        //console.log(`"`+this.removeMsg[i]+`"`); 
      axios
        .get(
          `http://localhost:9109/Organization/RenWu/delete/${this.removeMsg[i]}`
        )
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
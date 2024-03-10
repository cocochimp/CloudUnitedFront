<template>
  <div class="app-container">
    成员列表
    <!--查询表单-->
    <el-form :inline="true"
             class="demo-form-inline"
             :model="searchList"
             :rules="sendData.searchListRules">
      <el-form-item>
        <el-input v-model="searchList.name"
                  placeholder="成员名"
                  style="width: 100%" />
      </el-form-item>

      <el-form-item>
        <el-select v-model="searchList.party"
                   clearable
                   placeholder="党派"
                   style="width: 100%">
          <el-option v-for="item in partyDataAxis"
                     :key="item.value"
                     :label="item.label"
                     :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-select v-model="searchList.otherParty"
                   clearable
                   placeholder="非民主党派"
                   style="width: 100%">
          <el-option v-for="item in otherPartyDataAxis"
                     :key="item.value"
                     :label="item.label"
                     :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-select v-model="searchList.department"
                   clearable
                   placeholder="学院"
                   style="width: 100%">
          <el-option v-for="item in departmentDataAxis"
                     :key="item.value"
                     :label="item.label"
                     :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>

      <el-button type="primary"
                 icon="el-icon-search"
                 @click="toQuery">查询</el-button>
      <!-- <el-button type="default" @click="resetData()">清空</el-button> -->
      <el-button type="default"
                 @click="showDetail">查询所有</el-button>
    </el-form>

    <!-- 表格 -->
    <el-table v-loading="listLoading"
              :data="list"
              border
              fit
              highlight-current-row
              stripe
              height="500">
      <!-- <el-table-column label="序号" width="150" align="center">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column> -->
      <el-table-column type="index"
                       :index="indexMethod"
                       label="#">
      </el-table-column>

      <el-table-column prop="name"
                       label="姓名"
                       width="150"
                       align="center" />

      <el-table-column prop="department"
                       label="学院/部门"
                       width="200"
                       align="center" />

      <el-table-column label="职务"
                       align="center"
                       prop="currentPosition">
      </el-table-column>

      <el-table-column prop="party"
                       label="党派"
                       align="center" />

      <el-table-column prop="phone"
                       label="手机号码"
                       width="200"
                       align="center" />

      <el-table-column prop="title"
                       label="职称"
                       width="350"
                       align="center" />

      <el-table-column label="操作"
                       align="center">
        <template slot-scope="scope">
          <!-- <router-link :to="'/teacher/edit/' + scope.row.id">
            <el-button type="primary" size="mini" icon="el-icon-edit"
              >修改</el-button
            >
          </router-link> -->
          <el-button type="primary"
                     size="mini"
                     icon="el-icon-edit"
                     @click="showEditDialog(scope.row)">
            修改
          </el-button>
          <el-button type="danger"
                     size="mini"
                     icon="el-icon-delete"
                     @click="removeDataById(scope.row, scope.$index)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页 -->
    <el-pagination v-if="isShow"
                   background
                   layout="prev, pager, next"
                   :page-size="20"
                   :total="total"
                   @current-change="pageChange">
    </el-pagination>

    <!--修改用户的对话框  -->
    <el-dialog title="修改用户信息"
               :visible.sync="editDialogVisible"
               width="50%"
               @close="editDialogClosed">
      <el-form ref="editFormRef"
               :model="editForm"
               label-width="100px">
        <!-- prop是绑定验证规则的属性 -->
        <el-form-item label="头像"
                      prop="imgUrl">

          <div class="user-header">
            <input type="file"
                   accept="image/*"
                   @change='onchangeImgFun'
                   class="header-upload-btn user-header-com">
            <img alt=""
                 :src='editForm.imgUrl'
                 class=" user-header-com">
          </div>
        </el-form-item>
        <el-form-item label="姓名"
                      prop="name">
          <el-input v-model="editForm.name"
                    placeholder="请输入成员姓名"></el-input>
        </el-form-item>

        <el-form-item label="性别"
                      prop="sex">
          <el-input v-model="editForm.sex"
                    placeholder="请输入成员性别"></el-input>
        </el-form-item>
        <el-form-item label="民族"
                      prop="nationId">
          <el-select v-model="editForm.nationId"
                     placeholder="请选择">
            <el-option v-for="item in nationDataAxis"
                       :key="item.value"
                       :label="item.label"
                       :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="出生日期"
                      prop="birth">
          <el-date-picker v-model="editForm.birth"
                          type="month"
                          format="yyyy 年 MM 月"
                          value-format="yyyy-MM"
                          placeholder="请选择年-月" />
        </el-form-item>

        <el-form-item label="政治面貌"
                      prop="politicsId">
          <el-select v-model="editForm.politicsId"
                     placeholder="请选择">
            <el-option v-for="item in politicalPositionAxis"
                       :key="item.value"
                       :label="item.label"
                       :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="加入时间"
                      prop="joinPartyDate">
          <el-date-picker v-model="editForm.joinPartyDate"
                          type="month"
                          format="yyyy 年 MM 月"
                          value-format="yyyy-MM"
                          placeholder="请选择年-月" />
        </el-form-item>
        <el-form-item label="学位"
                      prop="bachelorId">
          <el-select v-model="editForm.bachelorId"
                     placeholder="请选择">
            <el-option v-for="item in bachelorAxis"
                       :key="item.value"
                       :label="item.label"
                       :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="全日制学历"
                      prop="fulltimedegreeId">
          <el-select v-model="editForm.fulltimedegreeId"
                     placeholder="请选择">
            <el-option v-for="item in fulltimedegreeDataAxis"
                       :key="item.value"
                       :label="item.label"
                       :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="职称"
                      prop="titleId">
          <el-select v-model="editForm.titleId"
                     placeholder="请选择">
            <el-option v-for="item in titleDataAxis"
                       :key="item.value"
                       :label="item.label"
                       :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="学院/部门"
                      prop="departmentId">
          <el-select v-model="editForm.departmentId"
                     placeholder="请选择">
            <el-option v-for="item in departmentDataAxis"
                       :key="item.value"
                       :label="item.label"
                       :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="教职工类别"
                      prop="currentPositionData">
          <el-select v-model="editForm.currentPositionData"
                     placeholder="请选择">
            <el-option v-for="item in currentPositionDataAxis"
                       :key="item.value"
                       :label="item.label"
                       :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="校区"
                      prop="campusId">
          <el-select v-model="editForm.campusId"
                     placeholder="请选择">
            <el-option v-for="item in campusAxis"
                       :key="item.value"
                       :label="item.label"
                       :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="民主党派"
                      prop="partyId">
          <el-select v-model="editForm.partyId"
                     placeholder="请选择">
            <el-option v-for="item in partyDataAxis"
                       :key="item.value"
                       :label="item.label"
                       :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="非民主党派"
                      prop="otherPartyId">
          <el-select v-model="editForm.otherPartyId"
                     placeholder="请选择">
            <el-option v-for="item in otherPartyDataAxis"
                       :key="item.value"
                       :label="item.label"
                       :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="政治安排"
                      prop="politicalPositionId">
          <el-select v-model="editForm.politicalPositionId"
                     placeholder="请选择">
            <el-option v-for="item in politicalPositionAxis"
                       :key="item.value"
                       :label="item.label"
                       :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="区域"
                      prop="areaId">
          <el-select v-model="editForm.areaId"
                     placeholder="请选择">
            <el-option v-for="item in areaDataAxis"
                       :key="item.value"
                       :label="item.label"
                       :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="组织身份"
                      prop="organizationId">
          <el-select v-model="editForm.organizationId"
                     placeholder="请选择">
            <el-option v-for="item in identityAxis"
                       :key="item.value"
                       :label="item.label"
                       :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="手机号码"
                      prop="phone">
          <el-input v-model="editForm.phone"
                    placeholder="请输入成员手机号码"></el-input>
        </el-form-item>
        <el-form-item label="任职轴"
                      prop="positionAxis">
          <el-input type="textarea"
                    clearable
                    v-model="editForm.positionAxis"
                    style="width:50%;"
                    placeholder="请输入成员任职轴">
          </el-input>
        </el-form-item>
        <el-form-item label="活动轴"
                      prop="activeAxis">
          <el-input type="textarea"
                    clearable
                    v-model="editForm.activeAxis"
                    style="width:50%;"
                    placeholder="请输入成员活动轴">
          </el-input>
        </el-form-item>
        <el-form-item label="获奖轴"
                      prop="awardAxis">
          <el-input type="textarea"
                    clearable
                    v-model="editForm.awardAxis"
                    style="width:50%;"
                    placeholder="请输入成员获奖轴">
          </el-input>
        </el-form-item>
        <el-form-item label="籍贯"
                      prop="nativePlace">
          <el-input v-model="editForm.nativePlace"
                    placeholder="请输入成员籍贯"></el-input>
        </el-form-item>
        <el-form-item label="职务"
                      prop="job">
          <el-input v-model="editForm.job"
                    placeholder="请输入成员职务"></el-input>
        </el-form-item>
        <el-form-item label="职位级别"
                      prop="jobLevelId">
          <el-select v-model="editForm.jobLevelId"
                     placeholder="请选择">
            <el-option v-for="item in jobLevelAxis"
                       :key="item.value"
                       :label="item.label"
                       :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>

        <!-- <el-form-item label="参加工作">
          <el-date-picker v-model="editForm.startWorkingDate"
                          type="month"
                          format="yyyy 年 MM 月"
                          value-format="yyyy-MM"
                          placeholder="请选择年-月" />
        </el-form-item> -->

        <!-- <el-form-item label="信教情况"
                      prop="email">
          <el-select v-model="editForm.religion"
                     placeholder="请选择">
            <el-option v-for="item in religionDataAxis"
                       :key="item.value"
                       :label="item.label"
                       :value="item.value">
            </el-option>
          </el-select>
        </el-form-item> -->

        <!-- <el-form-item label="留学情况"
                      prop="email">
          <el-select v-model="editForm.isAbroad"
                     placeholder="请选择">
            <el-option v-for="item in aboardList"
                       :key="item.value"
                       :label="item.label"
                       :value="item.value">
            </el-option>
          </el-select>
        </el-form-item> -->

      </el-form>
      <span slot="footer"
            class="dialog-footer">
        <el-button @click="editDialogVisible = false">取 消</el-button>
        <el-button type="primary"
                   @click="saveRoleInfo">确 定</el-button>
        <!-- @click="editUserInfo" -->
      </span>
    </el-dialog>

  </div>
</template>

<script>
import teacher from "@/pages/teacher/teacher.js";

export default {
  // 代码核心方法

  data () {
    // 定义变量和函数值
    var validatePass = (rule, value, callback) => {
      if (this.searchList.party !== '') {
        callback(new Error('不能同时输入民主党派和非民主党派'));
      }
      callback();

    };
    return {
      file: '',
      imgStr: null,
      listLoading: true, // 数据是否正在加载
      isShow: true,
      list: null, // 查询之后接口放回的集合
      // page: 1, // 开始页
      // limit: 10, // 每页记录数
      total: 0, // 总记录数
      listQuery: {
        current: 0,
        limit: 9999,
        name: "",
        party: "",
        department: "",
        title: "",

      }, // 查询条件
      editDialogVisible: false,//修改弹出框的显示与隐藏
      editForm: [],
      searchList: {
        file: '',
        name: '',
        party: '',
        otherParty: '',
        department: ''
      },
      abroadTimeAxis: [],
      abroadTimeDataAxis: [],
      abroadTime: '',
      abroadTimeData: [],
      abroadTimeDataAxis: [],
      abroadTime: '',
      departmentData: [],
      departmentDataAxis: [],
      department: '',
      partyData: [],
      partyDataAxis: [],
      party: '',
      politicalArrangement: '',
      politicalArrangementData: [],
      politicalArrangementAxis: [],
      otherPartyData: [],
      otherPartyDataAxis: [],
      otherParty: '',
      nationData: [],
      nationDataAxis: [],
      fulltimedegreeData: [],
      fulltimedegreeDataAxis: [],
      bachelorAxis: [],
      bachelor: [],
      areaData: [],
      areaDataAxis: [],
      religionData: [],
      religionDataAxis: [],
      currentPositionData: [],
      currentPositionDataAxis: [],
      titleData: [],
      titleDataAxis: [],
      politicalPosition: [],
      politicalPositionAxis: [],
      jobLevel: [],
      jobLevelAxis: [],
      identity: [],
      identityAxis: [],
      committee: [],
      committeeAxis: [],
      campus: [],
      campusAxis: [],
      aboardList: [
        {
          value: 0,
          label: '留学'
        },
        {
          value: 1,
          label: '未留学'
        }
      ],
      sendData: {
        positionAxis: '',
        activeAxis: '',
        awardAxis: '',
        name: '',
        sex: '',
        departmentId: '',
        currentPositionId: '',
        religionId: '',
        currentJob: '',
        allParty: '',
        nationId: '',
        birth: '',
        nativePlace: '',
        fulltimedegreeId: '',
        titleId: '',
        startWorkingDate: '',
        stateOfRetire: '',
        joinPartyDate: '',
        phone: '',
        email: '',
        isabroad: '',
        remark: '',
        currentZhiTime: '',
        currentJiTime: '',
        idCard: '',
        partyId: '',
        otherPartyId: '',
        position: '',
        areaId: '',
        politicalPositionId: '',
        jobLevelId: '',
        organizationId: '',
        committeeId: '',
        campusId: '',
        file: '',
        searchListRules: {
          pass: [
            { validator: validatePass, trigger: 'blur' }
          ],
        }
      },
    };
  },

  created () {
    // 页面渲染之前执行，一般调用methods中的方法
    // this.getList()
    this.$axios
      .get("http://localhost:9106/service/renwuku/queryallpeople")
      .then((res) => {
        this.total = res.data.t.length;
        this.list = res.data.t.slice(0, 20);
        this.listLoading = false;
      });

    // this.showname()
    this.getDepartment()
    console.log(this.editForm);
    console.log(11);
  },
  methods: {
    onchangeImgFun (e) {
      console.log(e.target.files[0]);
      this.editForm.imgUrl = window.URL.createObjectURL(e.target.files[0])
      console.log(window.URL.createObjectURL(e.target.files[0])) // 获取当前文件的信息
      this.file = e.target.files[0]
      console.log(this.file);
      console.log(this.editForm.imgUrl);

    },
    async getDepartment () {
      // 学位
      let { data: res15 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryBachelor")
      res15.t.map(item => {
        this.bachelor = JSON.parse(JSON.stringify(item).replace('bachelorId', 'value').replace('bachelor', 'label'))
        this.bachelorAxis.push(this.bachelor)
      })
      // 职位级别
      let { data: res11 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryAllJobLevel")
      res11.t.map(item => {
        this.jobLevel = JSON.parse(JSON.stringify(item).replace('jobLevelId', 'value').replace('jobLevel', 'label'))
        this.jobLevelAxis.push(this.jobLevel)
      })
      // 学院/部门
      let { data: res5 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryAllDept")
      res5.t.map(item => {
        this.departmentData = JSON.parse(JSON.stringify(item).replace('departmentId', 'value').replace('department', 'label'))
        this.departmentDataAxis.push(this.departmentData)
      })
      //非民主党派
      let { data: res9 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryAllPartyOthers")
      res9.t.map(item => {
        this.otherPartyData = JSON.parse(JSON.stringify(item).replace('pid', 'value').replace('otherParty', 'label'))
        this.otherPartyDataAxis.push(this.otherPartyData)
      })

      // 政治面貌
      let { data: res10 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryPolitics")
      res10.t.map(item => {
        this.politicalPosition = JSON.parse(JSON.stringify(item).replace('politicsId', 'value').replace('politics', 'label'))
        this.politicalPositionAxis.push(this.politicalPosition)
      })
      // 民族
      let { data: res1 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryAllNations")
      res1.t.map(item => {
        this.nationData = JSON.parse(JSON.stringify(item).replace('nationId', 'value').replace('nation', 'label'))
        this.nationDataAxis.push(this.nationData)
      })
      //校区
      let { data: res14 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryAllCampuses")
      res14.t.map(item => {
        this.campus = JSON.parse(JSON.stringify(item).replace('campusId', 'value').replace('campus', 'label'))
        this.campusAxis.push(this.campus)
      })
      //组织身份
      let { data: res12 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryAllOrganizationIdentity")
      res12.t.map(item => {
        this.identity = JSON.parse(JSON.stringify(item).replace('oidentity', 'label').replace('oid', 'value'))
        this.identityAxis.push(this.identity)
      })
      // 全日制学历
      let { data: res2 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryAllFullTimeDegree")
      res2.t.map(item => {
        this.fulltimedegreeData = JSON.parse(JSON.stringify(item).replace('fulltimedegreeId', 'value').replace('fulltimedegree', 'label'))
        this.fulltimedegreeDataAxis.push(this.fulltimedegreeData)
      })
      // 职称
      let { data: res7 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryAllTitle")
      res7.t.map(item => {
        this.titleData = JSON.parse(JSON.stringify(item).replace('titleId', 'value').replace('title', 'label'))
        this.titleDataAxis.push(this.titleData)
      })

      //民主党派
      let { data: res8 } = await this.$axios.post("http://localhost:9106/service/party/queryAllParty")
      res8.t.map(item => {
        this.partyData = JSON.parse(JSON.stringify(item).replace('partyId', 'value').replace('party', 'label'))
        this.partyDataAxis.push(this.partyData)
      })

      //政治安排
      let { data: res17 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryAllPolitical")
      res17.t.map(item => {
        this.politicalArrangement = JSON.parse(JSON.stringify(item).replace('politicalPositionId', 'value').replace('position', 'label'))
        this.politicalArrangementAxis.push(this.politicalArrangement)
      })
      //区域
      let { data: res3 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryAllAreas")
      res3.t.map(item => {
        this.areaData = JSON.parse(JSON.stringify(item).replace('areaId', 'value').replace('area', 'label'))
        this.areaDataAxis.push(this.areaData)
      })



      // 教职工类别
      let { data: res6 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryAllCurrentPosition")
      res6.t.map(item => {
        this.currentPositionData = JSON.parse(JSON.stringify(item).replace('currentPositionId', 'value').replace('currentPosition', 'label'))
        this.currentPositionDataAxis.push(this.currentPositionData)
      })
      //留学时间
      let { data: res16 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryAbroadTime")
      res16.t.map(item => {
        this.abroadTime = JSON.parse(JSON.stringify(item).replace('abroadTimeId', 'value').replace('time', 'label'))
        this.abroadTimeAxis.push(this.abroadTime)
      })
    },

    // 创建具体的方法，调用teacher.js定义的方法
    getList (page = 1) {
      this.page = page;
      teacher
        .getTeacherListPage(this.page, this.limit, this.teachQuery)
        .then((response) => {
          // 请求成功，response接口返回的数据
          this.list = response.data.rows;
          console.log(this.list); // 返回数据集合
          this.total = response.data.total;
          console.log(this.total); // 总记录数
          this.listLoading = false;
        })
        .catch((error) => {
          console.log(error);
        }); // 请求失败
    },
    resetData () {
      // 清空的方法
      // 双向绑定输入框的数据清空
      this.teachQuery = {};
      this.getList();
    },
    removeDataById (data, index) {
      this.$confirm("此操作将永久删除讲师记录, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {

        this.$axios
          .post(
            `http://localhost:9106/service/renwuku/deletePeople/${data.id}`
          )
          .then((res) => {
            console.log(res);
            this.list.splice(index, 1);
            alert("删除成功！");
          });
      }).catch(() => {
        this.$message.info('已取消删除');
      }); // 点击取消，执行catch方法


    },
    indexMethod (index) {
      return index + 1;
    },
    pageChange (currentPage) {
      this.$axios
        .get("http://localhost:9106/service/renwuku/queryallpeople")
        .then((res) => {
          this.list = res.data.t.slice(
            (currentPage - 1) * 20,
            currentPage * 20
          );
          this.indexMethod = function (index) {
            return index + 1 + (currentPage - 1) * 20;
          };
        });
    },
    // 查询
    toQuery () {
      this.$axios
        .get(
          `http://localhost:9106/service/renwuku/queryPeopleByCondition?name=${this.searchList.name}&partyId=${this.searchList.party}&departmentId=${this.searchList.department}&otherPartyId=${this.searchList.otherParty}`,
        )
        .then((res) => {
          this.list = res.data.t;
          this.isShow = false;
        });
    },
    // 查询所有
    showDetail () {
      this.$axios
        .get("http://localhost:9106/service/renwuku/queryallpeople")
        .then((res) => {
          this.total = res.data.t.length;
          this.list = res.data.t.slice(0, 20);
          this.isShow = true;
        });
    },
    //展示编辑用户的对话框
    async showEditDialog (row) {

      this.editForm = row
      this.editDialogVisible = true
      console.log(this.editForm);
    },
    //监听修改用户对话框的关闭事件
    editDialogClosed () {
      this.$refs.editFormRef.resetFields()
    },
    //修改信息
    async saveRoleInfo () {

      this.$axios.post('http://localhost:9106/service/renwuku/updatePeople', this.editForm, { headers: { 'content-type': 'multipart/form-data' } }).then(res => {
        alert('修改成功！')
        console.log(res);
        // 回到列表页面，路由跳转
        this.editDialogVisible = false
        // if (!res.ok) {
        //   return this.$message.error('更新角色失败！')
        // }
      })



      this.editDialogVisible = false
    },


  },
};
</script>

<style scoped>
.app-main {
  min-height: 100%;
}

.app-container {
  padding: 20px;
}
.el-date-picker,
.el-select,
.el-input {
  width: 50%;
}

.user-header {
  position: relative;
  display: inline-block;
}
.user-header-com {
  width: 144px;
  height: 144px;
  display: inline-block;
}
.header-upload-btn {
  position: absolute;
  left: 0;
  top: 0;
  opacity: 0;
  /* 通过定位把input放在img标签上面，通过不透明度隐藏 */
}
</style>

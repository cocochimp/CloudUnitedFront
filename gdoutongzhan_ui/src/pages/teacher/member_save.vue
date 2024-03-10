<template>
  <div class="app-container">
    <h2 style="text-align: center">添加成员</h2>
    <h4 style="margin-top: 10px">必填选项</h4>
    <!-- 必填选项 -->
    <div class=" pleft1  ptop1rem i1">
      <el-form>
        <!-- 头像部分 -->
        <div class="headBox">
          <span>头像</span>
          <div class="add">+</div>
        </div>
        <div class="user-header">
          <input type="file"
                 accept="image/*"
                 @change='onchangeImgFun'
                 class="header-upload-btn user-header-com">
          <img alt=""
               :src='imgStr'
               class=" user-header-com">

        </div>

        <!-- input 的accept属性可以用来解决格式筛选问题 -->
      </el-form>
    </div>
    <div class=" pleft1  ptop1rem i1">
      <el-form :inline="true"
               class="demo-form-inline">

        <!-- 姓名 -->
        <el-form-item prop="must">
          <!-- @blur="checkInput(index)" -->

          <el-input :placeholder="input_item[0].inputinfo"
                    v-model="input_item[0].input1"
                    clearable
                    @input="updateView($event, index)">
            <template slot="prepend">{{ input_item[0].inputname }}</template>
          </el-input>
        </el-form-item>
        <!-- 性别 -->
        <el-form-item prop="must">
          <el-input :placeholder="input_item[5].inputinfo"
                    v-model="input_item[5].input1"
                    clearable
                    @input="updateView($event, index)">
            <template slot="prepend">{{ input_item[5].inputname }}</template>
          </el-input>
        </el-form-item>
        <!-- 民族 -->
        <el-form-item>
          <div class="selectBox  s1">
            <span>{{ select_item[1].selectname }}</span>

            <el-select v-model="select_item[1].id"
                       :placeholder="select_item[1].selectinfo"
                       clearable>
              <el-option v-for="v in select_item[1].sel"
                         :key="v.value"
                         :label="v.label"
                         :value="v.value" />
            </el-select>
          </div>
        </el-form-item>

        <!-- 出生日期 -->
        <el-form-item>
          <div class="dateBox s1 ">
            <span>{{ date_item[0].datename}}</span>
            <el-date-picker v-model="date_item[0].value"
                            type="month"
                            format="yyyy 年 MM 月"
                            value-format="yyyy-MM"
                            placeholder="请选择年-月" />
          </div>
        </el-form-item>
        <!-- 政治面貌 -->
        <el-form-item>
          <div class="selectBox  s1">
            <span>{{ select_item[3].selectname }}</span>

            <el-select v-model="select_item[3].id"
                       :placeholder="select_item[3].selectinfo"
                       clearable>
              <el-option v-for="v in select_item[3].sel"
                         :key="v.value"
                         :label="v.label"
                         :value="v.value" />
            </el-select>
          </div>
        </el-form-item>
        <!-- 加入时间 -->
        <el-form-item>
          <div class="dateBox s1 ">
            <span>{{ date_item[2].datename}}</span>
            <el-date-picker v-model="date_item[2].value"
                            type="month"
                            format="yyyy 年 MM 月"
                            value-format="yyyy-MM"
                            placeholder="请选择年-月" />
          </div>
        </el-form-item>
        <!-- 学位 -->
        <el-form-item prop="must">
          <div class="selectBox  s1">
            <span>{{ select_item[7].selectname }}</span>

            <el-select v-model="select_item[7].id"
                       :placeholder="select_item[7].selectinfo"
                       clearable>
              <el-option v-for="v in select_item[7].sel"
                         :key="v.value"
                         :label="v.label"
                         :value="v.value" />
            </el-select>
          </div>
        </el-form-item>
        <!-- 全日制学历 -->
        <el-form-item>
          <div class="selectBox  s1">
            <span>{{ select_item[10].selectname }}</span>

            <el-select v-model="select_item[10].id"
                       :placeholder="select_item[10].selectinfo"
                       clearable>
              <el-option v-for="v in select_item[10].sel"
                         :key="v.value"
                         :label="v.label"
                         :value="v.value" />
            </el-select>
          </div>
        </el-form-item>
        <!-- 职称 -->
        <el-form-item>
          <div class="selectBox  s1">
            <span>{{ select_item[4].selectname }}</span>

            <el-select v-model="select_item[4].id"
                       :placeholder="select_item[4].selectinfo"
                       clearable>
              <el-option v-for="v in select_item[4].sel"
                         :key="v.value"
                         :label="v.label"
                         :value="v.value" />
            </el-select>
          </div>
        </el-form-item>
        <!-- 学院/部门 -->
        <el-form-item>
          <div class="selectBox  s1">
            <span>{{ select_item[8].selectname }}</span>

            <el-select v-model="select_item[8].id"
                       :placeholder="select_item[8].selectinfo"
                       clearable>
              <el-option v-for="v in select_item[8].sel"
                         :key="v.value"
                         :label="v.label"
                         :value="v.value" />
            </el-select>
          </div>
        </el-form-item>
        <!-- 教职工类别 -->
        <el-form-item>
          <div class="selectBox  s1">
            <span>{{ select_item[9].selectname }}</span>

            <el-select v-model="select_item[9].id"
                       :placeholder="select_item[9].selectinfo"
                       clearable>
              <el-option v-for="v in select_item[9].sel"
                         :key="v.value"
                         :label="v.label"
                         :value="v.value" />
            </el-select>
          </div>
        </el-form-item>
        <!-- 校区 -->
        <el-form-item prop="must">
          <div class="selectBox  s1">
            <span>{{ select_item[15].selectname }}</span>

            <el-select v-model="select_item[15].id"
                       :placeholder="select_item[15].selectinfo"
                       clearable>
              <el-option v-for="v in select_item[15].sel"
                         :key="v.value"
                         :label="v.label"
                         :value="v.value" />
            </el-select>
          </div>
        </el-form-item>
        <!-- 民主党派 -->
        <el-form-item prop="must">
          <div class="selectBox  s1">
            <span>{{ select_item[17].selectname }}</span>

            <el-select v-model="select_item[17].id"
                       :placeholder="select_item[17].selectinfo"
                       clearable>
              <el-option v-for="v in select_item[17].sel"
                         :key="v.value"
                         :label="v.label"
                         :value="v.value" />
            </el-select>
          </div>
        </el-form-item>
        <!-- 非民主党派 -->
        <el-form-item prop="must">
          <div class="selectBox  s1">
            <span>{{ select_item[2].selectname }}</span>

            <el-select v-model="select_item[2].id"
                       :placeholder="select_item[2].selectinfo"
                       clearable>
              <el-option v-for="v in select_item[2].sel"
                         :key="v.value"
                         :label="v.label"
                         :value="v.value" />
            </el-select>
          </div>
        </el-form-item>
        <!-- 政治安排 -->
        <el-form-item prop="must">
          <div class="selectBox  s1">
            <span>{{ select_item[11].selectname }}</span>

            <el-select v-model="select_item[11].id"
                       :placeholder="select_item[11].selectinfo"
                       clearable>
              <el-option v-for="v in select_item[11].sel"
                         :key="v.value"
                         :label="v.label"
                         :value="v.value" />
            </el-select>
          </div>
        </el-form-item>
        <!-- 区域 -->
        <el-form-item prop="must">
          <div class="selectBox  s1">
            <span>{{ select_item[6].selectname }}</span>

            <el-select v-model="select_item[6].id"
                       :placeholder="select_item[6].selectinfo"
                       clearable>
              <el-option v-for="v in select_item[6].sel"
                         :key="v.value"
                         :label="v.label"
                         :value="v.value" />
            </el-select>
          </div>
        </el-form-item>
        <!-- 组织身份 -->
        <el-form-item prop="must">
          <div class="selectBox  s1">
            <span>{{ select_item[13].selectname }}</span>

            <el-select v-model="select_item[13].id"
                       :placeholder="select_item[13].selectinfo"
                       clearable>
              <el-option v-for="v in select_item[13].sel"
                         :key="v.value"
                         :label="v.label"
                         :value="v.value" />
            </el-select>
          </div>
        </el-form-item>
        <!-- 手机号码 -->
        <el-form-item prop="must">
          <el-input :placeholder="input_item[1].inputinfo"
                    v-model="input_item[1].input1"
                    clearable
                    @input="updateView($event, index)">
            <template slot="prepend">{{ input_item[1].inputname }}</template>
          </el-input>
        </el-form-item>
        <!-- 任职轴 -->
        <el-form-item prop="must">
          <div class="rodBox s1">
            <span>{{input_item[8].inputname}}</span>
            <el-input type="textarea"
                      @input="updateView($event, index)"
                      clearable
                      v-model="input_item[8].input1"
                      style="width:1074px;margin-left: 7rem;"
                      :placeholder="input_item[8].inputinfo">
            </el-input>
          </div>
        </el-form-item>
        <!-- 活动轴 -->
        <el-form-item prop="must">
          <div class="rodBox s1">
            <span>{{input_item[9].inputname}}</span>
            <el-input type="textarea"
                      @input="updateView($event, index)"
                      clearable
                      v-model="input_item[9].input1"
                      style="width:1074px;margin-left: 7rem;"
                      :placeholder="input_item[9].inputinfo">
            </el-input>
          </div>
        </el-form-item>
        <!-- 获奖轴 -->
        <el-form-item prop="must">
          <div class="rodBox s1">
            <span>{{input_item[10].inputname}}</span>
            <el-input type="textarea"
                      @input="updateView($event, index)"
                      clearable
                      v-model="input_item[10].input1"
                      style="width:1074px;margin-left: 7rem;"
                      :placeholder="input_item[10].inputinfo">
            </el-input>
          </div>
        </el-form-item>
      </el-form>
      <!-- <el-input>{{input_item[0].inputname}}
</el-input> -->
    </div>
    <h4 style="margin-top: 10px">选填选项</h4>
    <div class="pleft1 ptop1rem i1">
      <el-form :inline="true"
               class="demo-form-inline">
        <!-- 籍贯 -->
        <el-form-item prop="must">
          <el-input :placeholder="input_item[4].inputinfo"
                    v-model="input_item[4].input1"
                    clearable
                    @input="updateView($event, index)">
            <template slot="prepend">{{ input_item[4].inputname }}</template>
          </el-input>
        </el-form-item>
        <!-- 职务 -->
        <el-form-item prop="must">
          <el-input :placeholder="input_item[7].inputinfo"
                    v-model="input_item[7].input1"
                    clearable
                    @input="updateView($event, index)">
            <template slot="prepend">{{ input_item[7].inputname }}</template>
          </el-input>
        </el-form-item>

        <!-- 职位级别 -->
        <el-form-item>
          <div class="selectBox s1">
            <span>{{ select_item[0].selectname }}</span>

            <el-select v-model="select_item[0].id"
                       :placeholder="select_item[0].selectinfo"
                       clearable>
              <el-option v-for="v in select_item[0].sel"
                         :key="v.value"
                         :label="v.label"
                         :value="v.value" />
            </el-select>
          </div>
        </el-form-item>
        <!-- 留学情况 -->
        <!-- <el-form-item>
          <div class="selectBox s1">
            <span>{{ select_item[12].selectname }}</span>

            <el-select v-model="select_item[12].id"
                       :placeholder="select_item[12].selectinfo"
                       clearable>
              <el-option v-for="v in select_item[12].sel"
                         :key="v.value"
                         :label="v.label"
                         :value="v.value" />
            </el-select>
          </div>
        </el-form-item> -->
        <!-- 留学时间 -->
        <!-- <el-form-item>
          <div class="selectBox s1">
            <span>{{ select_item[16].selectname }}</span>

            <el-select v-model="select_item[16].id"
                       :placeholder="select_item[16].selectinfo"
                       clearable>
              <el-option v-for="v in select_item[16].sel"
                         :key="v.value"
                         :label="v.label"
                         :value="v.value" />
            </el-select>
          </div>
        </el-form-item> -->
      </el-form>
    </div>
    <!-- <div class="inputBox pleft1 w25rem ptop1rem i1 clear" style="width: 98%">
      <el-input v-model="myInput.input2" placeholder="请输入备注情况" clearable @input="updateView($event)">
        <template slot="prepend">备注</template>
      </el-input>
    </div> -->
    <div class="foot-button pleft1 clear">
      <el-button type="primary"
                 @click="saveData">保存</el-button>
      <!-- <el-button style="background: #fff; color: #606266" @click="empty">重置</el-button> -->
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'AdPeopleDetail',
  data () {
    return {
      imgStr: null,
      errorSrt: '',
      file: '1',
      imageUrl: '',
      selectData: [],
      nationData: [],
      nationDataAxis: [],
      fulltimedegreeData: [],
      fulltimedegreeDataAxis: [],
      areaData: [],
      areaDataAxis: [],
      religionData: [],
      religionDataAxis: [],
      departmentData: [],
      departmentDataAxis: [],
      currentPositionData: [],
      currentPositionDataAxis: [],
      titleData: [],
      titleDataAxis: [],
      partyData: [],
      partyDataAxis: [],
      otherPartyData: [],
      otherPartyDataAxis: [],
      politicalPosition: [],
      politicalPositionAxis: [],
      politicalArrangement: [],
      politicalArrangementAxis: [],
      jobLevel: [],
      jobLevelAxis: [],
      identity: [],
      identityAxis: [],
      committee: [],
      committeeAxis: [],
      campus: [],
      campusAxis: [],
      bachelor: [],
      bachelorAxis: [],
      abroadTime: [],
      abroadTimeAxis: [],
      sendData: {
        positionAxis: '',
        activeAxis: '',
        awardAxis: '',
        name: '',
        sex: '',
        imgUrl: '',
        phone: '',
        job: '',
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
        // isAbroad: '',
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
        bachelorId: '',
        // abroadTimeId: '',
        politicalArrangementId: '',
        positionRod: '',
        activityRod: '',
        awardRod: '',
        politicsId: '',
        // imgUrl: '',
        photo: ''
      },

      date_item: [
        {
          id: 1,
          dateid: 2,
          datename: '出生日期',
          value: ''
        },
        {
          id: 2,
          dateid: 2,
          datename: '参加工作',
          value: ''
        },
        {
          id: 3,
          dateid: 3,
          datename: '加入时间',
          value: ''
        }
      ],
      input_item: [
        {
          id: 1,
          inputname: '姓名',
          inputinfo: '请输入成员姓名',
          input1: ''
        },
        {
          id: 2,
          inputname: '手机号码',
          inputinfo: '请输入成员手机号码',
          input1: ''
        },
        {
          id: 3,
          inputname: '电子邮箱',
          inputinfo: '请输入成员电子邮箱',
          input1: ''
        },

        {
          id: 4,
          inputname: '身份证',
          inputinfo: '请输入身份证号',
          input1: ''
        },

        {
          id: 5,
          inputname: '籍贯',
          inputinfo: '请输入省市',
          input1: ''
        },
        {
          id: 6,
          inputname: '性别',
          inputinfo: '请输入男或女',
          input1: ''
        },
        {
          id: 7,
          inputname: '学位',
          inputinfo: '请输入成员学位',
          input1: ''
        },
        {
          id: 8,
          inputname: '职务',
          inputinfo: '请输入成员职务',
          input1: ''
        },
        {
          id: 9,
          inputname: '任职轴',
          inputinfo: '请输入成员任职内容',
          input1: ''
        },
        {
          id: 10,
          inputname: '活动轴',
          inputinfo: '请输入成员活动内容',
          input1: ''
        },
        {
          id: 11,
          inputname: '获奖轴',
          inputinfo: '请输入成员获奖内容',
          input1: ''
        },
      ],
      select_item:
        [
          {
            id: '',
            subid: 1,
            selectname: '职位级别',
            selectinfo: '请选择',
            sel: [
            ]
          },
          {
            id: '',
            subid: 2,
            selectname: '民族',
            selectinfo: '请选择',
            sel: []
          },
          {
            id: '',
            subid: 3,
            selectname: '非民主党派',
            selectinfo: '请选择',
            sel: []
          },
          {
            id: '',
            subid: 3,
            selectname: '政治面貌',
            selectinfo: '请选择',
            sel: []
          },
          {
            id: '',
            subid: 1,
            selectname: '职称',
            selectinfo: '请选择',
            sel: []
          },
          {
            id: '',
            subid: 1,
            selectname: '退休',
            selectinfo: '请选择',
            sel: [
              {
                value: 0,
                label: '否'
              },
              {
                value: 1,
                label: '是'
              }
            ]
          },
          {
            id: '',
            subid: 4,
            selectname: '区域',
            selectinfo: '请选择',
            sel: []
          },
          {
            id: '',
            selectname: '学位',
            selectinfo: '请选择',
            sel: []
          },
          {
            id: '',
            subid: 4,
            selectname: '学院/部门',
            selectinfo: '请选择',
            sel: []
          },
          {
            id: '',
            subid: 6,
            selectname: '教职工类别',
            selectinfo: '请选择',
            sel: []
          },
          {
            id: '',
            subid: 6,
            selectname: '全日制学历',
            selectinfo: '请选择',
            sel: []
          },

          {
            id: '',
            subid: 4,
            selectname: '政治安排',
            selectinfo: '请选择',
            sel: []
          },
          {
            id: '',
            subid: 5,
            selectname: '留学情况',
            selectinfo: '请选择',
            sel: [
              {
                value: 1,
                label: '留学'
              },
              {
                value: 0,
                label: '未留学'
              }
            ]
          },
          {
            id: '',
            subid: 5,
            selectname: '组织身份',
            selectinfo: '请选择',
            sel: []
          },
          {
            id: '',
            subid: 6,
            selectname: '委员会',
            selectinfo: '请选择',
            sel: []
          },
          {
            id: '',
            selectname: '校区',
            selectinfo: '请选择',
            sel: []
          },
          {
            id: '',
            selectname: '留学时间',
            selectinfo: '请选择',
            sel: []
          },
          {
            id: '',
            subid: 3,
            selectname: '民主党派',
            selectinfo: '请选择',
            sel: []
          },
        ],
      rules: {
        index: [{ required: true, message: '请选择活动资源', trigger: 'blur' }]
      }
    }
  },
  computed: {

  },
  watch: {

  },
  created () {
    this.getSelectData()
  },
  methods: {
    async getSelectData () {
      // 民族
      let { data: res1 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryAllNations")
      res1.t.map(item => {
        this.nationData = JSON.parse(JSON.stringify(item).replace('nationId', 'value').replace('nation', 'label'))
        this.nationDataAxis.push(this.nationData)
      })
      this.select_item[1].sel = this.nationDataAxis
      // 政治面貌
      let { data: res10 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryPolitics")
      res10.t.map(item => {
        this.politicalPosition = JSON.parse(JSON.stringify(item).replace('politicsId', 'value').replace('politics', 'label'))
        this.politicalPositionAxis.push(this.politicalPosition)
      })
      this.select_item[3].sel = this.politicalPositionAxis
      //学位
      let { data: res15 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryBachelor")
      res15.t.map(item => {
        this.bachelor = JSON.parse(JSON.stringify(item).replace('bachelorId', 'value').replace('bachelor', 'label'))
        this.bachelorAxis.push(this.bachelor)
      })
      this.select_item[7].sel = this.bachelorAxis
      // 全日制学历
      let { data: res2 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryAllFullTimeDegree")
      res2.t.map(item => {
        this.fulltimedegreeData = JSON.parse(JSON.stringify(item).replace('fulltimedegreeId', 'value').replace('fulltimedegree', 'label'))
        this.fulltimedegreeDataAxis.push(this.fulltimedegreeData)
      })
      this.select_item[10].sel = this.fulltimedegreeDataAxis
      // 职称
      let { data: res7 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryAllTitle")
      res7.t.map(item => {
        this.titleData = JSON.parse(JSON.stringify(item).replace('titleId', 'value').replace('title', 'label'))
        this.titleDataAxis.push(this.titleData)
      })
      this.select_item[4].sel = this.titleDataAxis
      //校区
      let { data: res14 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryAllCampuses")
      res14.t.map(item => {
        this.campus = JSON.parse(JSON.stringify(item).replace('campusId', 'value').replace('campus', 'label'))
        this.campusAxis.push(this.campus)
      })
      this.select_item[15].sel = this.campusAxis
      //民主党派
      let { data: res8 } = await this.$axios.post("http://localhost:9106/service/party/queryAllParty")
      res8.t.map(item => {
        this.partyData = JSON.parse(JSON.stringify(item).replace('partyId', 'value').replace('party', 'label'))
        this.partyDataAxis.push(this.partyData)
      })
      this.select_item[17].sel = this.partyDataAxis
      //非民主党派
      let { data: res9 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryAllPartyOthers")
      res9.t.map(item => {
        this.otherPartyData = JSON.parse(JSON.stringify(item).replace('pid', 'value').replace('otherParty', 'label'))
        this.otherPartyDataAxis.push(this.otherPartyData)
      })
      this.select_item[2].sel = this.otherPartyDataAxis
      //政治安排
      let { data: res17 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryAllPolitical")
      res17.t.map(item => {
        this.politicalArrangement = JSON.parse(JSON.stringify(item).replace('politicalPositionId', 'value').replace('position', 'label'))
        this.politicalArrangementAxis.push(this.politicalArrangement)
      })
      this.select_item[11].sel = this.politicalArrangementAxis
      //区域
      let { data: res3 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryAllAreas")
      res3.t.map(item => {
        this.areaData = JSON.parse(JSON.stringify(item).replace('areaId', 'value').replace('area', 'label'))
        this.areaDataAxis.push(this.areaData)
      })
      this.select_item[6].sel = this.areaDataAxis
      //组织身份
      let { data: res12 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryAllOrganizationIdentity")
      res12.t.map(item => {
        this.identity = JSON.parse(JSON.stringify(item).replace('oidentity', 'label').replace('oid', 'value'))
        this.identityAxis.push(this.identity)
      })
      this.select_item[13].sel = this.identityAxis
      // 学院/部门
      let { data: res5 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryAllDept")
      res5.t.map(item => {
        this.departmentData = JSON.parse(JSON.stringify(item).replace('departmentId', 'value').replace('department', 'label'))
        this.departmentDataAxis.push(this.departmentData)
      })
      this.select_item[8].sel = this.departmentDataAxis
      // 职位级别
      let { data: res11 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryAllJobLevel")
      res11.t.map(item => {
        this.jobLevel = JSON.parse(JSON.stringify(item).replace('jobLevelId', 'value').replace('jobLevel', 'label'))
        this.jobLevelAxis.push(this.jobLevel)
      })
      this.select_item[0].sel = this.jobLevelAxis
      // 教职工类别
      let { data: res6 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryAllCurrentPosition")
      res6.t.map(item => {
        this.currentPositionData = JSON.parse(JSON.stringify(item).replace('currentPositionId', 'value').replace('currentPosition', 'label'))
        this.currentPositionDataAxis.push(this.currentPositionData)
      })
      this.select_item[9].sel = this.currentPositionDataAxis
      //留学时间
      let { data: res16 } = await this.$axios.post("http://localhost:9106/service/renwuku/queryAbroadTime")
      res16.t.map(item => {
        this.abroadTime = JSON.parse(JSON.stringify(item).replace('abroadTimeId', 'value').replace('time', 'label'))
        this.abroadTimeAxis.push(this.abroadTime)
      })
      this.select_item[16].sel = this.abroadTimeAxis
    },
    onchangeImgFun (e) {
      console.log(e.target.files[0]);
      // console.log(this.file);
      // let file = new FormData();
      // this.file = e.target.files[0]
      // console.log(e.target.files[0]);
      // console.log(this.file);
      // var file =
      this.imgStr = window.URL.createObjectURL(e.target.files[0])
      console.log(window.URL.createObjectURL(e.target.files[0])) // 获取当前文件的信息
      this.file = e.target.files[0]
      console.log(this.file);
      // // 获取图片的大小，做大小限制有用
      // let imgSize = file.size
      // console.log(imgSize)
      // var _this = this // this指向问题，所以在外面先定义
      // // 比如上传头像限制5M大小，这里获取的大小单位是b

      // if (true) {
      //   // 合格
      //   _this.errorStr = ''
      //   console.log('大小合适')
      // 开始渲染选择的图片
      // 本地路径方法 1
      // this.imgStr = window.URL.createObjectURL(e.target.files[0])
      // console.log(window.URL.createObjectURL(e.target.files[0])) // 获取当前文件的信息

      // base64方法 2
      // var reader = new FileReader()
      // reader.readAsDataURL(file) // 读出 base64
      //   reader.onloadend = function () {
      //     // 图片的 base64 格式, 可以直接当成 img 的 src 属性值
      //     // var dataURL = reader.result
      //     console.log(dataURL)
      //     _this.imgStr = reader.result
      //     // 下面逻辑处理
      //   }
      // } else {
      //   console.log('大小不合适')
      //   _this.errorStr = '图片大小超出范围'
      // }
    },



    updateView (e, index) {
      this.$forceUpdate()
    },
    prev () {
      this.$router.back()
    },
    empty () {
      this.myInput.input2 = ''
      for (let i = 0; i < this.input_item.length; i++) {
        this.input_item[i].input1 = ''
      }
      for (let j = 0; j < this.select_item.length; j++) {
        this.select_item[j].id = j + 1
      }
    },

    saveData () {

      // if (this.input_item[0].input1 === '' || this.input_item[1].input1 === '' || this.input_item[5].input1 === '' || this.date_item[0].value === ''
      //   || this.date_item[2].value === '' || this.select_item[1].id === '' || this.select_item[3].id === ''
      //   || this.select_item[4].id === '' || this.select_item[6].id === '' || this.select_item[7].id === '' || this.select_item[8].id === '' || this.select_item[9].id === ''
      //   || this.select_item[10].id === '' || this.select_item[11].id === '' || this.select_item[13].id === '' || this.select_item[15].id === '') {
      //   alert('存在必填选项未填')
      //   return
      // }
      // if (this.select_item[2].id == '' && this.select_item[17].id == '') {
      //   alert('存在必填选项未填')
      //   return
      // }
      if (this.select_item[2].id !== '' && this.select_item[17].id !== '') {
        alert('民主党派和非民主党派不可以同时填写')
        return
      }
      // if (this.select_item[12].id === 0 && this.select_item[16].id !== '') {
      //   alert('未留学不可填写留学时间')
      //   return
      // }
      // if (this.input_item[4].input1 === '') {
      //   alert('存在必填选项未填')
      //   return
      // }
      this.sendData.name = this.input_item[0].input1
      this.sendData.phone = this.input_item[1].input1
      this.sendData.nativePlace = this.input_item[4].input1
      this.sendData.sex = this.input_item[5].input1
      this.sendData.job = this.input_item[7].input1
      this.sendData.birth = this.date_item[0].value
      this.sendData.joinPartyDate = this.date_item[2].value
      this.sendData.jobLevelId = this.select_item[0].id
      this.sendData.nationId = this.select_item[1].id
      this.sendData.otherPartyId = this.select_item[2].id
      this.sendData.politicsId = this.select_item[3].id
      this.sendData.titleId = this.select_item[4].id
      this.sendData.areaId = this.select_item[6].id
      this.sendData.bachelorId = this.select_item[7].id
      this.sendData.departmentId = this.select_item[8].id
      this.sendData.currentPositionId = this.select_item[9].id
      this.sendData.fulltimedegreeId = this.select_item[10].id
      this.sendData.politicalPositionId = this.select_item[11].id
      // this.sendData.isAbroad = this.select_item[12].id
      this.sendData.organizationId = this.select_item[13].id
      this.sendData.campusId = this.select_item[15].id
      // this.sendData.abroadTimeId = this.select_item[16].id
      this.sendData.partyId = this.select_item[17].id
      this.sendData.photo = this.file
      this.sendData.positionAxis = this.input_item[8].inputname
      this.sendData.activeAxis = this.input_item[9].inputname
      this.sendData.awardAxis = this.input_item[10].inputname
      // axios.post(`http://localhost:9106/service/renwuku/addPeople`, this.sendData).then(res => {
      //   console.log(res);
      // })
      this.$axios
        .post(
          `http://localhost:9106/service/renwuku/addPeople`, this.sendData, { headers: { 'content-type': 'multipart/form-data' } }
        )
        .then(res => {
          console.log(res);
          console.log(res.t);
          console.log(res.data);
          console.log(this.file);
          alert('添加成功！')
          // 回到列表页面，路由跳转
          console.log(this.file);
          // this.$router.push({ path: '/2-3' })
        }).catch(err => {
          console.log("请求失败", err);
        })
      // this.$axios({
      //   methods: 'POST',
      //   url: 'http://localhost:9106/service/renwuku/addPeople',
      //   data: this.sendData,
      //   // headers: { 'Content-Type': 'multipart/form-data' }
      // })
    }
  }
}
</script>

<style scoped>
.pleft1 {
  padding-left: 1%;
}
.w25rem {
  width: 25rem;
}
.ptop1rem {
  padding-top: 1rem;
}
.clear {
  clear: both;
}
.foot-button {
  display: flex;
  padding-top: 2rem;
}
.show-middle {
  width: 100%;
  margin: 0rem auto;
}
.show-middle span {
  display: inline-block;
  height: 36px;
  line-height: 36px;
  font-weight: bold;
}
::v-deep .inputBox {
  float: left;
}
::v-deep .selectBox,
.dateBox,
.headBox {
  display: inline-block;
  float: left;
  position: relative;
  font-size: 0;
}
.headBox .add {
  position: absolute;
  height: 50px;
  width: 50px;
  font-size: 100px;
  color: #909399;
  left: 169px;
  top: 20px;
}
::v-deep .el-input-group__prepend {
  width: 7rem;
  text-align: center;
}
::v-deep .selectBox > span,
.dateBox > span {
  display: inline-block;
  white-space: nowrap;
  background-color: #f5f7fa;
  width: 7rem;
  height: 2.5rem;
  text-align: center;
  line-height: 38px;
  vertical-align: middle;
  font-size: 14px;
  color: #909399;
  border: 1px solid #dcdfe6;
  border-right: 0;
  border-radius: 4px;
  border-top-right-radius: 0;
  border-bottom-right-radius: 0;
}
.headBox > span {
  display: inline-block;
  white-space: nowrap;
  background-color: #f5f7fa;
  width: 7rem;
  height: 2.5rem;
  text-align: center;
  line-height: 38px;
  vertical-align: middle;
  font-size: 14px;
  color: #909399;
  border: 1px solid #dcdfe6;
  border-radius: 4px;
}
.rodBox > span {
  position: absolute;
  top: 0;
  display: inline-block;
  white-space: nowrap;
  background-color: #f5f7fa;
  width: 7rem;
  height: 2.5rem;
  text-align: center;
  line-height: 38px;
  vertical-align: middle;
  font-size: 14px;
  color: #909399;
  border: 1px solid #dcdfe6;
  border-right: 0;
  border-radius: 4px;
  border-top-right-radius: 0;
  border-bottom-right-radius: 0;
}
::v-deep .el-select,
.el-date-editor.el-input {
  vertical-align: middle;
  width: 68%;
}

::v-deep .el-input__inner {
  width: 17rem;
  border-top-left-radius: 0;
  border-bottom-left-radius: 0;
}

.el-form-item {
  margin-bottom: 16px;
  margin-right: 16px;
}
::v-deep .el-textarea > .el-textarea__inner {
  height: 38px;
  border-radius: 0 4px 4px 0;
  padding: 0 30px 0 15px;
  line-height: 38px;
}
::v-deep .avatar-uploader {
  width: 100px;
  height: 100px;
  display: inline-block;
  margin: 0 700px 16px 16px;
}
::v-deep .avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  height: 100px;
  width: 100px;
}
::v-deep .avatar-uploader .el-upload:hover {
  border-color: #409eff;
}
::v-deep .avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 100px;
  height: 100px;
  line-height: 100px;
  text-align: center;
}
::v-deep .avatar {
  width: 178px;
  height: 178px;
  display: block;
}
.user-header {
  position: relative;
  display: inline-block;
}

.header-upload-btn {
  position: absolute;
  left: 0px;
  top: 0;
  opacity: 0;
  /* 通过定位把input放在img标签上面，通过不透明度隐藏 */
}
.user-header-com {
  margin-left: 13px;
  width: 144px;
  height: 144px;
  display: inline-block;
  border: 1px solid #dcdfe6;
}
</style>

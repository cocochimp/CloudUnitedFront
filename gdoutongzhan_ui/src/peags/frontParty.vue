<template>
  <div class="mainbox content">
    <ul class="clearfix nav1">
      <!-- 知联会 -->
      <li style="width: 26%">
        <el-menu class="el-menu-demo"
                 mode="horizontal"
                 text-color="#fff"
                 active-text-color="#f4e925">
          <el-menu-item index="1">知联会(总数:{{sum1}})</el-menu-item>
        </el-menu>
        <!-- 性别分布 -->
        <div class="box l-box"
             style="margin-right:0.4%; width:38.1%">
          <div class="tit">性别分布</div>
          <div class="boxnav"
               style="height: 117px;">
            <div style="width: 100%; height: 140px;"
                 id="echart8"></div>
          </div>
        </div>
        <!-- 年龄分布 -->
        <div class="box l-box"
             style="margin-left:0.4%; width:58.1%; float: right;">
          <div class="tit">年龄分布</div>
          <div class="boxnav"
               style="height: 117px;">
            <div style="width: 100%; height: 140px"
                 id="echart9"></div>
          </div>
        </div>
        <!-- 年龄分布 -->
        <div class="box l-box">
          <div class="tit">学历分布</div>
          <div class="boxnav"
               style="height: 117px;">
            <div style="width: 100%; height: 140px"
                 id="echart10"></div>
          </div>
        </div>
        <!-- 职称分布 -->
        <div class="box l-box">
          <div class="tit">职称分布</div>
          <div class="boxnav"
               style="height: 117px;">
            <div style="width: 100%; height: 140px"
                 id="echart11"></div>

          </div>
        </div>

      </li>
      <!-- 地图 -->
      <li style="width: 42%">
        <div class="box">
          <div class="boxnav mapc"
               style="height: 648px; position: relative">
            <div class="map"
                 id="map">
              <SchoolMap />
            </div>
          </div>
        </div>
      </li>
      <!-- 无党派和留学归国人员 -->
      <el-menu class="el-menu-demo"
               mode="horizontal"
               text-color="#fff"
               active-text-color="#f4e925"
               default-active="1">
        <el-menu-item index="1"
                      @click="frontPartySort">无党派人士(总数:{{sum2}})</el-menu-item>
        <el-menu-item index="3"
                      @click="overseasSort">留学归国人员(总数:{{sum3}})</el-menu-item>
      </el-menu>
      <!-- 性别分布 -->
      <li style="width: 16%"
          class="right">
        <div class="box">
          <div class="tit">性别分布</div>
          <div class="boxnav"
               style="height: 150px">
            <div style="float: left; width: 100%; height: 140px"
                 id="echart5"></div>
          </div>
        </div>
      </li>
      <!-- 年龄分布 -->
      <li style="width: 16%"
          class="right">
        <div class="box">
          <div class="tit">年龄分布</div>
          <div class="boxnav"
               style="height: 150px">
            <div style="float: left; width: 100%; height: 140px"
                 id="echart6"></div>
          </div>
        </div>
      </li>
      <!-- 学历分布 -->
      <li style="width: 16%"
          class="right">
        <div class="box">
          <div class="tit">学历分布</div>
          <div class="boxnav"
               style="height: 150px">
            <div style="float: left; width: 100%; height: 140px"
                 id="echart4"></div>
          </div>
        </div>
      </li>
      <!-- 职称分布 -->
      <li style="width: 16%"
          class="right">
        <div class="box">
          <div class="tit">职称分布</div>
          <div class="boxnav"
               style="height: 150px">
            <div style="float: left; width: 100%; height: 140px"
                 id="echart7"></div>
          </div>
        </div>
      </li>
      <li style="width: 32%"
          class="right">
        <!-- 级别分布 -->
        <div class="box"
             v-show="showbox">
          <div class="tit">级别分布</div>
          <div class="boxnav"
               style="height: 150px">
            <div style="float: left; width: 450px; height: 140px"
                 id="echart12"></div>
          </div>
        </div>
        <!-- 留学时间分布 -->
        <div class="box"
             v-show="!showbox">
          <div class="tit">留学时间分布</div>
          <div class="boxnav"
               style="height: 150px">
            <div style="float:left; width: 450px; height: 140px"
                 id="echart13"></div>
          </div>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
import { callDepartment } from "../api/college/frontParty"
import SchoolMap from './schoolMap.vue';

export default {
  name: "frontParty",
  data () {
    return {
      sum1: 27,
      sum2: 2,
      sum3: 266,
      //控制留学和无党派切换
      gradeOrAbroad: '',
      showbox: true,
      //发送的sort标识(无党派人士、留学归国人员)
      sort: '',
      //无党派和留学归国人员学历分布
      echart4List: [],
      echart4data: [],
      echart4dataAxis: [],
      //无党派和留学归国人员性别分布
      echart5List: [],
      echart5data: [],
      echart5dataAxis: [],
      //无党派和留学归国人员年龄分布
      echart6List: [],
      echart6data: [],
      echart6dataAxis: [],
      //无党派和留学归国人员职称分布
      echart7List: [],
      echart7data: [],
      echart7dataAxis: [],
      //知联会性别分布
      echart8List: [],
      echart8data: [],
      echart8dataAxis: [],
      //知联会年龄分布
      echart9List: [],
      echart9data: [],
      echart9dataAxis: [],
      //知联会学历分布
      echart10List: [],
      echart10data: [],
      echart10dataAxis: [],
      //知联会职称分布
      echart11List: [],
      echart11data: [],
      echart11dataAxis: [],
      //级别分布
      echart12List: [],
      echart12data: [],
      echart12dataAxis: [],
      //留学时间分布
      echart13List: [],
      echart13data: [],
      echart13dataAxis: [],
    };
  },
  watch: {
    $route (to, from) {
      window.location.reload
    },
    // 无党派和留学归国人员学历分布
    echart4data: {
      deep: true,
      handler (newVal, oldVal) {
        this.init_myChart4();
      },
    },
    echart4dataAxis: {
      deep: true,
      handler () {
        this.init_myChart4();
      }
    },
    //无党派和留学归国人员性别分布
    echart5data: {
      deep: true,
      handler (newVal, oldVal) {
        this.init_myChart5();
      }
    },
    echart5dataAxis: {
      deep: true,
      handler () {
        this.init_myChart5();
      }
    },
    // 无党派和留学归国人员年龄分布
    echart6data: {
      deep: true,
      handler (newVal, oldVal) {
        this.init_myChart6();
      }
    },
    echart6dataAxis: {
      deep: true,
      handler () {
        this.init_myChart6();
      }
    },
    // 无党派和留学归国人员职称分布
    echart7data: {
      deep: true,
      handler (newVal, oldVal) {
        this.init_myChart7();
      }
    },
    echart7dataAxis: {
      deep: true,
      handler () {
        this.init_myChart7();
      }
    },
    //知联会性别分布
    echart8data: {
      deep: true,
      handler (newVal, oldVal) {
        this.init_myChart8();
      }
    },
    echart8dataAxis: {
      deep: true,
      handler () {
        this.init_myChart8();
      }
    },
    //知联会年龄分布
    echart9data: {
      deep: true,
      handler (newVal, oldVal) {
        this.init_myChart9();
      }
    },
    echart9dataAxis: {
      deep: true,
      handler () {
        this.init_myChart9();
      }
    },
    //知联会学历分布
    echart10data: {
      deep: true,
      handler (newVal, oldVal) {
        this.init_myChart10();
      }
    },
    echart10dataAxis: {
      deep: true,
      handler () {
        this.init_myChart10();
      }
    },
    // 知联会职称分布
    echart11data: {
      deep: true,
      handler (newVal, oldVal) {
        this.init_myChart11();
      }
    },
    echart11dataAxis: {
      deep: true,
      handler () {
        this.init_myChart11();
      }
    },
    // 级别分布
    echart12data: {
      deep: true,
      handler (newVal, oldVal) {
        this.init_myChart12();
      }
    },
    echart12dataAxis: {
      deep: true,
      handler () {
        this.init_myChart12();
      }
    },
    // 留学时间分布
    echart13data: {
      deep: true,
      handler (newVal, oldVal) {
        this.init_myChart13();
      }
    },
    echart13dataAxis: {
      deep: true,
      handler () {
        this.init_myChart13();
      }
    },
  },
  created () {
    window.sessionStorage.removeItem("department");
    this.frontPartySort()
  },
  mounted () {
    this.init_myChart8();
    this.init_myChart9();
    this.init_myChart10();
    this.init_myChart11();
    this.init_myChart4();
    this.init_myChart5();
    this.init_myChart6();
    this.init_myChart7();
    this.init_myChart12();
    this.init_myChart13();

    this.$bus.$on("wenxue", this.frontParty)      //文学与新闻传播学院党委
    this.$bus.$on("shiping", this.frontParty)      //食品科技学院党委
    this.$bus.$on("qixiang", this.frontParty)      //海洋与气象学院党委
    this.$bus.$on("houqin", this.frontParty)      //后勤与产业党委
    this.$bus.$on("jixie", this.frontParty)      //机械工程学院党委
    this.$bus.$on("guanli", this.frontParty)      //管理学院党委
    this.$bus.$on("makesi", this.frontParty)      //马克思主义学院党委
    this.$bus.$on("jingji", this.frontParty)      //经济学院党委 
    this.$bus.$on("nengyuan", this.frontParty)     //海洋工程与能源学院党委
    this.$bus.$on("jisuanji", this.frontParty)     //数学与计算机学院党委
    this.$bus.$on("dianzi", this.frontParty)       //电子与信息工程学院党委
    this.$bus.$on("huaxue", this.frontParty)      //化学与环境学院党委
    this.$bus.$on("nongye", this.frontParty)      //滨海农业学院党委
    this.$bus.$on("shuichan", this.frontParty)     //水产学院党委
    this.$bus.$on("fazhen", this.frontParty)      //法政学院党委
    this.$bus.$on("waiguoyu", this.frontParty)     //外国语学院党委
    this.$bus.$on("zhongge", this.frontParty)      //中歌艺术学院党委
    this.$bus.$on("tiyu", this.frontParty)         //体育与休闲学院党委
    this.$bus.$on("jiguan", this.frontParty)       //机关党委
    this.$bus.$on("tuixiu", this.frontParty)       //离退休干部党委
    this.$bus.$on("jiaofu", this.frontParty)      //教辅单位党委
  },
  methods: {
    //对单一学院进行切换
    frontParty (department) {
      callDepartment(department).then(res => {
        let result = res
        //无党派和留学归国人员学历分布
        this.echart4data = []
        this.echart4dataAxis = []
        this.echart4List = result.res4.t
        this.echart4List.forEach((item) => this.echart4data.push(item.total))
        this.echart4List.forEach((item) => this.echart4dataAxis.push(item.degree))
        //无党派和留学归国人员性别分布
        this.echart5data = []
        this.echart5dataAxis = []
        this.echart5List = result.res5.t
        this.echart5List.forEach((item) => this.echart5data.push(item.total))
        this.echart5List.forEach((item) => this.echart5dataAxis.push(item.sex))
        //无党派和留学归国人员年龄分布
        this.echart6data = []
        this.echart6dataAxis = []
        this.echart6List = result.res6.t
        this.echart6data = result.res6.t.value
        this.echart6dataAxis = result.res6.t.age
        //无党派和留学归国人员职称分布
        this.echart7data = []
        this.echart7dataAxis = []
        this.echart7List = result.res7.t
        this.echart7List.forEach((item) => this.echart7data.push(item.count))
        this.echart7List.forEach((item) => this.echart7dataAxis.push(item.LEVEL))
        //    this.echart7List.map(item => {
        //    this.echart7data = JSON.parse(JSON.stringify(item).replace('total', 'value').replace('title', 'name'))
        //     this.echart7dataAxis.push(this.echart7data)
        //     console.log(this.echart7dataAxis);
        //    this.echart7dataAxis= this.echart7dataAxis.filter(item=>item.value>0)
        // })   
        //知联会性别分布
        this.echart8data = []
        this.echart8dataAxis = []
        this.echart8List = result.res8.t
        this.echart8List.forEach((item) => this.echart8data.push(item.total))
        this.echart8List.forEach((item) => this.echart8dataAxis.push(item.sex))
        //知联会年龄分布
        this.echart9data = []
        this.echart9dataAxis = []
        this.echart9List = result.res9.t
        this.echart9data = result.res9.t.value
        this.echart9dataAxis = result.res9.t.age
        //知联会学历分布
        this.echart10data = []
        this.echart10dataAxis = []
        this.echart10List = result.res10.t
        this.echart10List.forEach((item) => this.echart10data.push(item.total))
        this.echart10List.forEach((item) => this.echart10dataAxis.push(item.degree))
        //知联会职称分布
        this.echart11data = []
        this.echart11dataAxis = []
        this.echart11List = result.res11.t
        this.echart11List.forEach((item) => this.echart11data.push(item.count))
        this.echart11List.forEach((item) => this.echart11dataAxis.push(item.LEVEL))
        //留学时间分布
        this.echart13data = []
        this.echart13dataAxis = []

        this.echart13List = result.res13.t

        this.echart13List.forEach((item) => this.echart13data.push(item['一年以内']))
        this.echart13List.forEach((item) => this.echart13dataAxis.push(item['一年以上']))
      })
    },
    //对总体进行切换
    async overseasSort () {
      this.gradeOrAbroad = '留学时间分布',
        this.showbox = false
      window.sessionStorage.setItem("sort", "留学归国人员");
      this.sort = window.sessionStorage.getItem("sort")
      this.department = window.sessionStorage.getItem("department")

      if (this.department) {
        this.frontParty(this.department)
      } else {
        let { data: res1 } = await this.$axios.post("http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryDegreeOfAboard")
        let { data: res2 } = await this.$axios.post("http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/querySexOfAboard")
        let { data: res3 } = await this.$axios.post("http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryAgeOfAboard")
        let { data: res4 } = await this.$axios.post("http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryTitleOfAboard")
        let { data: res13 } = await this.$axios.post("http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryTimeOfAboard")


        //无党派和留学归国人员职称分布
        this.echart7data = []
        this.echart7dataAxis = []
        this.echart7List = res4.t
        this.echart7List.forEach((item) => this.echart7data.push(item.count))
        this.echart7List.forEach((item) => this.echart7dataAxis.push(item.LEVEL))
        //无党派和留学归国人员学历分布
        // this.echart4data = []
        // this.echart4dataAxis = []
        // this.echart4List = res1.t
        // this.echart4List.forEach((item) => this.echart4data.push(item.total))
        // this.echart4List.forEach((item) => this.echart4dataAxis.push(item.degree))
        // alert(res4.t[0].count)

        //无党派和留学归国人员性别分布
        this.echart5data = []
        this.echart5dataAxis = []
        this.echart5List = res2.t
        this.echart5List.forEach((item) => this.echart5data.push(item.total))
        this.echart5List.forEach((item) => this.echart5dataAxis.push(item.sex))

        //无党派和留学归国人员年龄分布
        // this.echart6data = []
        // this.echart6dataAxis = []
        // this.echart6List = res3.t
        // this.echart6data = res3.t.value
        // this.echart6dataAxis = res3.t.age
        //留学时间分布
        this.echart13data = []
        this.echart13dataAxis = []
        this.echart13List = res13.t
        this.echart13List.forEach((item) => this.echart13data.push(item['一年以内']))
        this.echart13List.forEach((item) => this.echart13dataAxis.push(item['一年以上']))



        window.sessionStorage.setItem("sort", "知联会");
        this.sort = window.sessionStorage.getItem("sort")

        let { data: res8 } = await this.$axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/querySex/${this.sort}`)
        let { data: res9 } = await this.$axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryAge/${this.sort}`)
        let { data: res10 } = await this.$axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryDegree/${this.sort}`)
        let { data: res11 } = await this.$axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryTitle/${this.sort}`)
        window.sessionStorage.setItem("sort", "留学归国人员");

        //知联会性别分布
        this.echart8data = []
        this.echart8dataAxis = []
        this.echart8List = res8.t
        this.echart8List.forEach((item) => this.echart8data.push(item.total))
        this.echart8List.forEach((item) => this.echart8dataAxis.push(item.sex))
        //知联会年龄分布
        this.echart9List = res9.t
        this.echart9data = res9.t.value
        this.echart9dataAxis = res9.t.age
        //知联会学历分布
        this.echart10List = res10.t
        this.echart10List.forEach((item) => this.echart10data.push(item.total))
        this.echart10List.forEach((item) => this.echart10dataAxis.push(item.degree))
        //知联会职称分布
        this.echart11List = res11.t
        this.echart11List.forEach((item) => this.echart11data.push(item.count))
        this.echart11List.forEach((item) => this.echart11dataAxis.push(item.LEVEL))

      }
    },

    async frontPartySort () {
      this.gradeOrAbroad = '级别分布',
        this.showbox = true
      window.sessionStorage.setItem("sort", "无党派人士");
      this.sort = window.sessionStorage.getItem("sort")
      this.department = window.sessionStorage.getItem("department")
      this.aa = false;
      if (this.department) {
        this.frontParty(this.department)
        console.log(this.sort);
      } else {
        let { data: res1 } = await this.$axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryDegree/${this.sort}`)
        let { data: res2 } = await this.$axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/querySex/${this.sort}`)
        let { data: res3 } = await this.$axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryAge/${this.sort}`)
        let { data: res4 } = await this.$axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryTitle/${this.sort}`)
        //无党派和留学归国人员性别分布
        this.echart5data = []
        this.echart5dataAxis = []
        this.echart5List = res2.t
        this.echart5List.forEach((item) => this.echart5data.push(item.total))
        this.echart5List.forEach((item) => this.echart5dataAxis.push(item.sex))
        //无党派和留学归国人员年龄分布
        this.echart6data = []
        this.echart6dataAxis = []
        this.echart6List = res3.t
        this.echart6data = res3.t.value
        this.echart6dataAxis = res3.t.age
        //无党派和留学归国人员学历分布
        this.echart4data = []
        this.echart4dataAxis = []
        this.echart4List = res1.t
        this.echart4List.forEach((item) => this.echart4data.push(item.total))
        this.echart4List.forEach((item) => this.echart4dataAxis.push(item.degree))
        //无党派和留学归国人员职称分布
        this.echart7data = []
        this.echart7dataAxis = []
        this.echart7List = res4.t
        this.echart7List.forEach((item) => this.echart7data.push(item.count))
        this.echart7List.forEach((item) => this.echart7dataAxis.push(item.LEVEL))

        window.sessionStorage.setItem("sort", "知联会");
        this.sort = window.sessionStorage.getItem("sort")
        let { data: res8 } = await this.$axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/querySex/${this.sort}`)
        let { data: res9 } = await this.$axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryAge/${this.sort}`)
        let { data: res10 } = await this.$axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryDegree/${this.sort}`)
        let { data: res11 } = await this.$axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryTitle/${this.sort}`)
        window.sessionStorage.setItem("sort", "无党派人士");

        //知联会性别分布
        this.echart8data = []
        this.echart8dataAxis = []
        this.echart8List = res8.t
        this.echart8List.forEach((item) => this.echart8data.push(item.total))
        this.echart8List.forEach((item) => this.echart8dataAxis.push(item.sex))
        //知联会年龄分布
        this.echart9List = res9.t
        this.echart9data = res9.t.value
        this.echart9dataAxis = res9.t.age
        //知联会学历分布
        this.echart10List = res10.t
        this.echart10List.forEach((item) => this.echart10data.push(item.total))
        this.echart10List.forEach((item) => this.echart10dataAxis.push(item.degree))
        //知联会职称分布
        this.echart11List = res11.t
        this.echart11List.forEach((item) => this.echart11data.push(item.count))
        this.echart11List.forEach((item) => this.echart11dataAxis.push(item.LEVEL))

      }
    },

    //echarts们
    init_myChart7 () {
      // 无党派和留学归国人员职称分布
      var myChart7 = this.$echarts.init(document.getElementById("echart7"));
      var option = {
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b}: {c} ({d}%)",
        },
        legend: {
          orient: "vertical",
          top: "0%",
          left: "0",
          itemWidth: 10,
          itemHeight: 10,
          textStyle: {
            color: "rgba(255,255,255,.5)",
            fontSize: "10",
          },
        },
        series: [
          {
            name: "职称分布",
            type: "pie",
            radius: ["60%", "75%"],
            center: ["70%", "45%"],
            color: [
              "#62c98d",
              "#2f89cf",
              "#4cb9cf",
              "#e0c828",
              "#e58c00",
              "#008080",
              "#eb295b",
              "#9932CC",
              "#37A2FF",
              "#00DDFF",
            ],
            label: { show: false, position: "center" },
            emphasis: {
              scale: true,
              scaleSize: 7,
              label: {
                show: true,
                fontSize: "10",
                fontWeight: "bold",
                color: "white",
              },
            },
            labelLine: { show: false },
            data: [
              { value: this.echart7data[0], name: this.echart7dataAxis[0] },
              { value: this.echart7data[1], name: this.echart7dataAxis[1] },
              { value: this.echart7data[2], name: this.echart7dataAxis[2] },
              { value: this.echart7data[3], name: this.echart7dataAxis[3] },
              { value: this.echart7data[4], name: this.echart7dataAxis[4] },
            ]
          },
        ],
      };

      //学生年级分布
      option && myChart7.setOption(option);
      window.addEventListener("resize", function () {
        myChart7.resize();
      });
    },
    // 无党派和留学归国人员年龄分布
    init_myChart6 () {
      let data = this.echart6data;
      let dataAxis = [
        "35岁以下",
        "35-45岁",
        "46-55岁",
        "55岁以上",
      ];
      var myChart6 = this.$echarts.init(document.getElementById("echart6"));
      var option = {
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "line",
            z: -1,
            lineStyle: {
              type: "soild",
              width: 24,
              color: "#2f89cf",
            },
          },
        },
        grid: {
          width: "80%",
          height: "100%",
          bottom: "0%",
          left: "5%",
          containLabel: true,
        },
        xAxis: {
          splitLine: {
            //网格线
            show: false,
          },
          type: "value",
          axisLine: {
            show: true,
            color: "white",
          },
          axisTick: {
            show: true,
          },
          axisLabel: {
            show: true,
            color: "#999",
          },
        },
        yAxis: {
          type: "category",
          data: dataAxis,
          axisLabel: {
            inside: false,
            color: "#fff",
          },
          axisTick: {
            show: false,
          },
          axisLine: {
            show: true,
          },
          z: 10,
        },
        series: [
          {
            type: "bar",
            barWidth: 14,
            label: {
              show: true,
              position: "right",
              color: "white",
            },
            itemStyle: {
              color: this.$echarts.graphic.LinearGradient(0, 0, 1, 0, [
                { offset: 0, color: "#83bff6" },
                { offset: 0.5, color: "#188df0" },
                { offset: 1, color: "#188df0" },
              ]),
              barBorderRadius: [0, 12, 12, 0],
            },
            emphasis: {
              itemStyle: {},
            },
            data: [data[0], data[2], data[1], data[3]],
          },
        ],
      };
      option && myChart6.setOption(option);
      window.addEventListener("resize", function () {
        myChart6.resize();
      });
    },

    // 无党派和留学归国人员学历分布
    init_myChart4 () {
      let data = this.echart4data
      let dataAxis = this.echart4dataAxis
      var myChart4 = this.$echarts.init(document.getElementById("echart4"));
      var option = {
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b}: {c} ({d}%)",
        },
        legend: {
          orient: "vertical",
          top: "0%",
          left: "0",
          itemWidth: 10,
          itemHeight: 10,
          textStyle: {
            color: "rgba(255,255,255,.5)",
            fontSize: "10",
          },
        },
        series: [
          {
            name: "学历分布",
            type: "pie",
            radius: ["60%", "75%"],
            center: ["70%", "45%"],
            color: [
              "#62c98d",
              "#2f89cf",
              "#4cb9cf",
              "#e0c828",
              "#e58c00",
              "#008080",
              "#eb295b",
              "#9932CC",
              "#37A2FF",
              "#00DDFF",
            ],
            label: { show: false, position: "center" },
            emphasis: {
              scale: true,
              scaleSize: 7,
              label: {
                show: true,
                fontSize: "10",
                fontWeight: "bold",
                color: "white",
              },
            },
            labelLine: { show: false },
            data: [
              { value: this.echart4data[0], name: this.echart4dataAxis[0] },
              { value: this.echart4data[1], name: this.echart4dataAxis[1] },
              { value: this.echart4data[2], name: this.echart4dataAxis[2] },
              { value: this.echart4data[3], name: this.echart4dataAxis[3] },
            ]
          },
        ],
      };
      //使用刚指定的配置项和数据显示图标
      option && myChart4.setOption(option);
      window.addEventListener("resize", function () {
        myChart4.resize();
      });
    },
    //无党派和留学归国人员性别分布
    init_myChart5 () {
      let data = this.echart5data
      let dataAxis = this.echart5dataAxis
      var myChart5 = this.$echarts.init(document.getElementById("echart5"));
      var option = {
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "line",
            z: -1,
            lineStyle: {
              type: "soild",
              width: 10,
              color: "#2f89cf",
            },
          },
        },
        grid: {
          width: "90%",
          height: "56%",
          bottom: "30%",
          left: "5%",
        },
        xAxis: {
          type: "category",
          data: dataAxis,
          axisLabel: {
            fontSize: 10,
            inside: false,
            color: "#fff",
          },
          axisTick: {
            show: false,
          },
          axisLine: {
            show: false,
          },
          z: 10,
        },
        yAxis: {
          splitLine: {
            //网格线
            show: false,
          },
          type: "value",
          axisLine: {
            show: false,
            color: "white",
          },
          axisTick: {
            show: false,
          },
          axisLabel: {
            show: false,
            color: "#999",
          },
        },
        series: [
          {
            type: "bar",
            barWidth: 10,
            label: {
              show: true,
              position: "top",
              color: "white",
            },
            itemStyle: {
              color: this.$echarts.graphic.LinearGradient(0, 0, 0, 1, [
                { offset: 0, color: "#2378f7" },
                { offset: 0.5, color: "#2378f7" },
                { offset: 1, color: "#83bff6" }
              ]),
              barBorderRadius: [5, 5, 0, 0],
            },
            emphasis: {
              itemStyle: {},
            },
            data: [
              { value: this.echart5data[0], name: this.echart5dataAxis[0] },
              { value: this.echart5data[1], name: this.echart5dataAxis[1] },
            ],
          },
        ],
      };
      //使用刚指定的配置项和数据显示图标
      option && myChart5.setOption(option);
      window.addEventListener("resize", function () {
        myChart5.resize();
      });
    },
    // 知联会性别分布
    init_myChart8 () {
      let data = this.echart8data;
      let dataAxis = this.echart8dataAxis;
      var myChart8 = this.$echarts.init(document.getElementById("echart8"));
      var option = {
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "line",
            z: -1,
            lineStyle: {
              type: "soild",
              width: 10,
              color: "#2f89cf",
            },
          },
        },
        grid: {
          width: "90%",
          height: "56%",
          bottom: "30%",
          left: "5%",
        },
        xAxis: {
          type: "category",
          data: dataAxis,
          axisLabel: {
            fontSize: 10,
            inside: false,
            color: "#fff",
          },
          axisTick: {
            show: false,
          },
          axisLine: {
            show: false,
          },
          z: 10,
        },
        yAxis: {
          splitLine: {
            //网格线
            show: false,
          },
          type: "value",
          axisLine: {
            show: false,
            color: "white",
          },
          axisTick: {
            show: false,
          },
          axisLabel: {
            show: false,
            color: "#999",
          },
        },
        series: [
          {
            type: "bar",
            barWidth: 10,
            label: {
              show: true,
              position: "top",
              color: "white",
            },
            itemStyle: {
              color: this.$echarts.graphic.LinearGradient(0, 0, 0, 1, [
                { offset: 0, color: "#2378f7" },
                { offset: 0.5, color: "#2378f7" },
                { offset: 1, color: "#83bff6" }
              ]),
              barBorderRadius: [5, 5, 0, 0],
            },
            emphasis: {
              itemStyle: {},
            },
            data: data,
          },
        ],
      };
      //使用刚指定的配置项和数据显示图标
      option && myChart8.setOption(option);
      window.addEventListener("resize", function () {
        myChart8.resize();
      });
    },
    //知联会年龄分布
    init_myChart9 () {
      let data = this.echart9data;
      let dataAxis = [
        "35岁以下",
        "35-45岁",
        "46-55岁",
        "55岁以上",
      ];
      var myChart9 = this.$echarts.init(document.getElementById("echart9"));
      var option = {
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "line",
            z: -1,
            lineStyle: {
              type: "soild",
              width: 24,
              color: "#2f89cf",
            },
          },
        },
        grid: {
          width: "80%",
          height: "100%",
          bottom: "0%",
          left: "5%",
          containLabel: true,
        },
        xAxis: {
          splitLine: {
            //网格线
            show: false,
          },
          type: "value",
          axisLine: {
            show: true,
            color: "white",
          },
          axisTick: {
            show: true,
          },
          axisLabel: {
            show: true,
            color: "#999",
          },
        },
        yAxis: {
          type: "category",
          data: dataAxis,
          axisLabel: {
            inside: false,
            color: "#fff",
          },
          axisTick: {
            show: false,
          },
          axisLine: {
            show: true,
          },
          z: 10,
        },
        series: [
          {
            type: "bar",
            barWidth: 14,
            label: {
              show: true,
              position: "right",
              color: "white",
            },
            itemStyle: {
              color: this.$echarts.graphic.LinearGradient(0, 0, 1, 0, [
                { offset: 0, color: "#83bff6" },
                { offset: 0.5, color: "#188df0" },
                { offset: 1, color: "#188df0" },
              ]),
              barBorderRadius: [0, 12, 12, 0],
            },
            emphasis: {
              itemStyle: {},
            },
            data: [data[0], data[2], data[1], data[3]],
          },
        ],
      };
      //使用刚指定的配置项和数据显示图标
      option && myChart9.setOption(option);
      window.addEventListener("resize", function () {
        myChart9.resize();
      });
    },
    // 知联会学历分布
    init_myChart10 () {
      let data = this.echart10dataAxis;
      var myChart10 = this.$echarts.init(document.getElementById("echart10"));
      var option = {
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b}: {c} ({d}%)",
        },
        legend: {
          orient: "vertical",
          top: "0%",
          left: "0",
          itemWidth: 10,
          itemHeight: 10,
          textStyle: {
            color: "rgba(255,255,255,.5)",
            fontSize: "10",
          },
        },
        series: [
          {
            name: "学历分布",
            type: "pie",
            radius: ["60%", "75%"],
            center: ["70%", "45%"],
            color: [
              "#62c98d",
              "#2f89cf",
              "#4cb9cf",
              "#e0c828",
              "#e58c00",
              "#008080",
              "#eb295b",
              "#9932CC",
              "#37A2FF",
              "#00DDFF",
            ],
            label: { show: false, position: "center" },
            emphasis: {
              scale: true,
              scaleSize: 7,
              label: {
                show: true,
                fontSize: "10",
                fontWeight: "bold",
                color: "white",
              },
            },
            labelLine: { show: false },
            data: [
              { value: this.echart10data[0], name: this.echart10dataAxis[0] },
              { value: this.echart10data[1], name: this.echart10dataAxis[1] },
              { value: this.echart10data[2], name: this.echart10dataAxis[2] },
              { value: this.echart10data[3], name: this.echart10dataAxis[3] },
              { value: this.echart10data[4], name: this.echart10dataAxis[4] },
              { value: this.echart10data[5], name: this.echart10dataAxis[5] },
            ]
          },
        ],
      };
      //使用刚指定的配置项和数据显示图标
      option && myChart10.setOption(option);
      window.addEventListener("resize", function () {
        myChart10.resize();
      });
    },
    // 知联会职称分布
    init_myChart11 () {
      var myChart11 = this.$echarts.init(document.getElementById("echart11"));
      var option = {
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b}: {c} ({d}%)",
        },
        legend: {
          orient: "vertical",
          top: "0%",
          left: "0",
          itemWidth: 10,
          itemHeight: 10,
          textStyle: {
            color: "rgba(255,255,255,.5)",
            fontSize: "10",
          },
        },
        series: [
          {
            name: "职称分布",
            type: "pie",
            radius: ["60%", "75%"],
            center: ["70%", "45%"],
            color: [
              "#62c98d",
              "#2f89cf",
              "#4cb9cf",
              "#e0c828",
              "#e58c00",
              "#008080",
              "#eb295b",
              "#9932CC",
              "#37A2FF",
              "#00DDFF",
            ],
            label: { show: false, position: "center" },
            emphasis: {
              scale: true,
              scaleSize: 7,
              label: {
                show: true,
                fontSize: "10",
                fontWeight: "bold",
                color: "white",
              },
            },
            labelLine: { show: false },
            data: [
              { value: this.echart11data[0], name: this.echart11dataAxis[0] },
              { value: this.echart11data[1], name: this.echart11dataAxis[1] },
              { value: this.echart11data[2], name: this.echart11dataAxis[2] },
              { value: this.echart11data[3], name: this.echart11dataAxis[3] },
              { value: this.echart11data[4], name: this.echart11dataAxis[4] },
              { value: this.echart11data[5], name: this.echart11dataAxis[5] },
            ],
          },
        ],
      };

      //使用刚指定的配置项和数据显示图标
      option && myChart11.setOption(option);
      window.addEventListener("resize", function () {
        myChart11.resize();
      });
    },
    // 级别分布
    init_myChart12 () {
      let dataAxis = [{ name: '省级', value: '11' },
      { name: '市级', value: '11' },
      { name: '校级', value: '22' }]
      var myChart12 = this.$echarts.init(document.getElementById("echart12"));
      var option = {
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b}: {c} ({d}%)",
        },
        legend: {
          orient: "vertical",
          top: "0%",
          left: "0",
          itemWidth: 10,
          itemHeight: 10,
          textStyle: {
            color: "rgba(255,255,255,.5)",
            fontSize: "10",
          },
        },
        series: [
          {
            name: "职称分布",
            type: "pie",
            radius: ["60%", "75%"],
            center: ["70%", "45%"],
            color: [
              "#62c98d",
              "#2f89cf",
              "#4cb9cf",
              "#e0c828",
              "#e58c00",
              "#008080",
              "#eb295b",
              "#9932CC",
              "#37A2FF",
              "#00DDFF",
            ],
            label: { show: false, position: "center" },
            emphasis: {
              scale: true,
              scaleSize: 7,
              label: {
                show: true,
                fontSize: "10",
                fontWeight: "bold",
                color: "white",
              },
            },
            labelLine: { show: false },
            data: dataAxis
          },
        ],
      };

      //使用刚指定的配置项和数据显示图标
      option && myChart12.setOption(option);
      window.addEventListener("resize", function () {
        myChart12.resize();
      });
    },
    // 留学时间分布
    init_myChart13 () {
      var myChart13 = this.$echarts.init(document.getElementById("echart13"));
      var option = {
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b}: {c} ({d}%)",
        },
        legend: {
          orient: "vertical",
          top: "0%",
          left: "0",
          itemWidth: 10,
          itemHeight: 10,
          textStyle: {
            color: "rgba(255,255,255,.5)",
            fontSize: "10",
          },
        },
        series: [
          {
            name: "留学时间",
            type: "pie",
            radius: ["60%", "75%"],
            center: ["70%", "45%"],
            color: [
              "#62c98d",
              "#2f89cf",
              "#4cb9cf",
              "#e0c828",
              "#e58c00",
              "#008080",
              "#eb295b",
              "#9932CC",
              "#37A2FF",
              "#00DDFF",
            ],
            label: { show: false, position: "center" },
            emphasis: {
              scale: true,
              scaleSize: 7,
              label: {
                show: true,
                fontSize: "10",
                fontWeight: "bold",
                color: "white",
              },
            },
            labelLine: { show: false },
            data: [
              { value: this.echart13data[0], name: '一年以内' },
              { value: this.echart13dataAxis[0], name: '一年以上' },

            ],
          },
        ],
      };

      //使用刚指定的配置项和数据显示图标
      option && myChart13.setOption(option);
      window.addEventListener("resize", function () {
        myChart13.resize();
      });
    },
  },
  beforeDestroy () {
    this.myChart8.clear()
    this.myChart9.clear()
    this.myChart10.clear()
    this.myChart11.clear()
    this.myChart12.clear()
    this.myChart4.clear()
    this.myChart5.clear()
    this.myChart6.clear()
    this.myChart7.clear()
    this.myChart13.clear()
  },
  components: { SchoolMap }
}
</script>

<style scoped>
* {
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
}

*,
body {
  padding: 0px;
  margin: 0px;
  font-family: '微软雅黑';
  color: #fff;
}

body {
  font-size: 16px;
  background: #033c76;
  background: radial-gradient(
    50% 35%,
    farthest-corner,
    #034f8e,
    #034987,
    #02366d,
    #002353
  );
  background: -webkit-radial-gradient(
    50% 35%,
    farthest-corner,
    #034f8e,
    #034987,
    #02366d,
    #002353
  );
}

html,
body {
  height: 100%;
  width: 100%;
}

li {
  list-style-type: none;
}

i {
  margin: 0px;
  padding: 0px;
  text-indent: 0px;
}

img {
  border: none;
  max-width: 100%;
}

a {
  text-decoration: none;
  color: #fff;
}

a.active,
a:focus {
  outline: none !important;
  text-decoration: none;
}

ol,
ul,
p,
h1,
h2,
h3,
h4,
h5,
h6 {
  padding: 0;
  margin: 0;
}

a:hover {
  color: #06c;
  text-decoration: none !important;
}
.content {
  /* background: url(../assets/img/地图界面.gif) no-repeat; */
  background: url(../assets/img/地图界面.gif) no-repeat center center;
  background-size: cover;
}

.clearfix:after,
.clearfix:before {
  display: table;
  content: ' ';
}

.clearfix:after {
  clear: both;
}

.pulll_left {
  float: left;
}

.pulll_right {
  float: right;
}

i {
  font-style: normal;
}

.text-w {
  color: #ffe400;
}

.text-d {
  color: #ff6316;
}

.text-s {
  color: #14e144;
}

.text-b {
  color: #07e5ff;
}

.head {
  position: relative;
  height: 90px;
  margin: 0 15px;
  padding-right: 60px;
}

.head h1 {
  font-size: 30px;
  letter-spacing: -2px;
  text-align: center;
  line-height: 90px;
  padding-right: 55px;
  color: #daf9ff;
}

.head .menu ul {
  font-size: 0;
}

.head .menu li {
  display: inline-block;
  position: relative;
  margin: 25px 15px;
}

.head .menu li a {
  display: block;
  font-size: 18px;
  color: #fff;
  line-height: 40px;
  padding: 0 15px;
}
.class {
  margin-top: 100px;
}
.menu li:before,
.menu li:after {
  position: absolute;
  width: 10px;
  height: 5px;
  opacity: 0.4;
  content: '';
  border-top: 2px solid #02a6b5;
  top: -1px;
  border-radius: 2px;
}

.menu li:before,
.menu li a:before {
  border-left: 2px solid #02a6b5;
  left: -1px;
}

.menu li:after,
.menu li a:after {
  border-right: 2px solid #02a6b5;
  right: -1px;
}

.menu li a {
  position: relative;
}

.menu li a:before,
.menu li a:after {
  position: absolute;
  width: 10px;
  height: 5px;
  opacity: 0.4;
  content: '';
  border-bottom: 2px solid #02a6b5;
  bottom: -1px;
  border-radius: 2px;
}

.head .menu li a:hover {
  color: #f4e925;
}

.menu li a:hover:before,
.menu li a:hover:after,
.menu li:hover:before,
.menu li:hover:after {
  border-color: #f4e925;
  opacity: 1;
}

.mainbox {
  padding: 0px 10px;
}

.nav1 {
  margin-left: -6px;
  margin-right: -6px;
}

.nav1 > li {
  padding: 0 6px;
  float: left;
}

.box {
  border: 1px solid rgba(7, 118, 181, 0.5);
  box-shadow: inset 0 0 10px rgba(7, 118, 181, 0.4);
  margin-bottom: 12px;
  position: relative;
}
.l-box {
  height: 189.5px;
  float: left;
  width: 100%;
}
.tit {
  padding: 10px 10px 10px 25px;
  border-bottom: 1px solid rgba(7, 118, 181, 0.7);
  font-size: 16px;
  font-weight: 500;
  position: relative;
}

.tit:before,
.tit01:before {
  position: absolute;
  content: '';
  width: 6px;
  height: 6px;
  background: rgba(22, 214, 255, 0.9);
  box-shadow: 0 0 5px rgba(22, 214, 255, 0.9);
  border-radius: 10px;
  left: 10px;
  top: 18px;
}

.tit:after,
.box:before {
  width: 100%;
  height: 1px;
  content: '';
  position: absolute;
  left: 0;
  bottom: -1px;
  background: linear-gradient(to right, #076ead, #4ba6e0, #076ead);
  box-shadow: 0 0 5px rgba(131, 189, 227, 1);
  opacity: 0.6;
}

.box:before {
  top: -1px;
}

.boxnav {
  padding: 10px;
}

.nav2 > li:first-child {
  border: none;
}

.nav2 > li {
  float: left;
  border-left: 1px solid rgba(7, 118, 181, 0.2);
  height: 240px;
  padding: 0 10px 10px 10px;
}

.tit01 {
  font-size: 16px;
  font-weight: 500;
  position: relative;
  padding-left: 15px;
}

.tit01:before {
  left: 3px;
  top: 8px;
}

.ftechart {
  height: 200px;
}

.table1 th {
  border-bottom: 1px solid #407abd;
  font-size: 14px;
  text-align: center;
  padding: 6px 0;
  color: rgba(255, 255, 255, 0.8);
}

.table1 td {
  border-bottom: 1px dotted#407abd;
  font-size: 12px;
  padding: 6px 0;
  text-align: center;
  color: rgba(255, 255, 255, 0.6);
}

.table1 tr:last-child td {
  border: none;
}

.mapc {
  background: url(../assets/img/bg3.png) no-repeat center center;
  background-size: 100% 100%;
}

.map {
  position: relative;
  height: 100%;
  padding-left: 0%;
}

.mapnav {
  position: absolute;
  z-index: 10;
}

.mapnav div {
  background: url(../assets/img/bg1.png) no-repeat;
  background-size: 100% auto;
  width: 110px;
  text-align: center;
  padding: 20px 0;
  line-height: 120%;
}

.mapnav div span {
  font-size: 14px;
  opacity: 0.6;
}

.mapnav div p {
  font-size: 20px;
  font-weight: bold;
  padding-top: 5px;
}

.mapnav li {
  float: left;
  margin-right: 6px;
}

.leidanav {
  margin-top: -5px;
}

.leidanav li {
  float: left;
  width: 20%;
  text-align: center;
  border-left: 1px solid rgba(255, 255, 255, 0.1);
}

.leidanav2 li {
  width: 33.3333%;
}

.leidanav3 li {
  width: 25%;
}

.leidanav li:first-child {
  border-left: none;
}

.leidanav span {
  font-size: 12px;
  opacity: 0.6;
}

.leidanav p {
  font-size: 18px;
  color: #26a6ff;
}

.mapnav2 {
  position: absolute;
  left: 10px;
  bottom: 0px;
  width: 40%;
  z-index: 10;
}

.ybp {
  width: 100%;
}

.ybp li {
  float: left;
  width: 50%;
  height: 120px;
}

.duibi li {
  float: left;
  width: 25%;
  height: 200px;
  padding: 0;
  border: none;
}

.btn {
  position: absolute;
  border-radius: 2px;
  padding: 4px 20px;
  opacity: 0.8;
}

.btn1 {
  border: 1px solid rgba(255, 255, 255, 0.5);
  background: #388665;
  left: 35%;
  top: 30%;
}

.btn2 {
  border: 1px solid rgba(255, 255, 255, 0.5);
  background: #297cc7;
  right: 32%;
  top: 60%;
}

.btn:hover {
  color: #fff;
  opacity: 1;
}

.btn1:before,
.btn2:before {
  position: absolute;
  content: '';
  width: 50px;
  height: 1px;
  background: #fff;
}

.btn1:before {
  transform: rotate(30deg);
  right: -65%;
  top: 100%;
}

.btn2:before {
  transform: rotate(30deg);
  left: -65%;
  top: -10%;
}

.tit02 {
  font-size: 14px;
  padding: 10px 0;
}

.tagcloud {
  width: 100%;
  height: 90% !important;
  overflow: hidden;
  position: relative;
}

.tagcloud a {
  display: block;
  border-radius: 50%;
  color: #fff;
  font-weight: bold;
  font-size: 14px;
  text-decoration: none;
  text-align: center;
  display: flex;
  align-items: center;
  justify-content: center;
}

.b01 {
  width: 50px;
  height: 50px;
}

.b02 {
  width: 80px;
  height: 80px;
}

.b03 {
  width: 60px;
  height: 60px;
}

.b04 {
  width: 70px;
  height: 70px;
}

.co01 {
  border: 2px solid rgba(5, 118, 254, 1);
  box-shadow: inset 0 0 20px rgba(5, 118, 254, 1);
}

.co02 {
  border: 2px solid rgba(238, 255, 65, 1);
  box-shadow: inset 0 0 20px rgba(238, 255, 65, 1);
}

.co03 {
  border: 2px solid rgba(26, 121, 181, 1);
  box-shadow: inset 0 0 20px rgba(26, 121, 181, 1);
}

.co04 {
  border: 2px solid rgba(1, 187, 181, 1);
  box-shadow: inset 0 0 20px rgba(1, 187, 181, 1);
}

.co05 {
  border: 2px solid rgba(255, 138, 0, 1);
  box-shadow: inset 0 0 20px rgba(255, 138, 0, 1);
}

.huati {
  padding-top: 20px;
}

.huati li {
  font-size: 12px;
  line-height: 230%;
}

.wancheng {
  display: flex;
  align-items: center;
  justify-content: center;
}

.wancheng span {
  font-size: 14px;
  color: #fff;
}

.wancheng h3 {
  font-size: 20px;
  color: #00b4ff;
}

.wancheng h3 i {
  font-size: 12px;
  color: #fff;
}

.yuan {
  padding: 5px;
  border-radius: 100%;
  margin-left: 10px;
  border: 2px solid rgba(0, 99, 169, 0.8);
}

.yuan span {
  width: 60px;
  height: 60px;
  border-radius: 100%;
  background: rgba(0, 99, 169, 0.8);
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 20px;
}

/* 杨政恒 */
.el-menu-demo {
  display: flex;
  justify-content: space-between;
  background-color: #032654;
}

::v-deep .el-menu-item:hover {
  background-color: #626f8b69 !important;
}

::v-deep .el-menu-item:active,
::v-deep .el-menu-item:focus {
  background-color: #626f8b69 !important;
}
</style>
<template>
  <div class="mainbox content">
    <ul class="clearfix nav1">
      <!-- 学生 -->
      <li style="width: 22%">
        <el-menu class="el-menu-demo"
                 mode="horizontal"
                 text-color="#fff"
                 active-text-color="#f4e925">
          <el-menu-item index="1"
                        style="margin: 0 auto">学生少数民族分布情况</el-menu-item>
        </el-menu>
        <!-- 学生民族分布 -->
        <div class="box">
          <div class="tit">民族分布(总数:{{ sum_s }})</div>
          <div class="boxnav"
               style="height: 150px">
            <div style="float: left; width: 100%; height: 140px"
                 id="echart3"></div>
          </div>
        </div>

        <div class="box">
          <div class="tit">性别分布(总数:{{ sum_s }})</div>
          <div class="boxnav"
               style="height: 150px">
            <div style="float: left; width: 100%; height: 150px"
                 id="echart1"></div>
          </div>
        </div>

        <div class="box">
          <div class="tit">学院分布(总数:{{ sum_s }})</div>
          <div class="boxnav"
               style="height: 150px">
            <div style="float: left; width: 100%; height: 140px"
                 id="echart2"></div>
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
      <!-- 教师 -->
      <el-menu class="el-menu-demo"
               mode="horizontal"
               text-color="#fff"
               active-text-color="#f4e925">
        <el-menu-item index="1"
                      style="margin: 0 auto">教师少数民族分布情况</el-menu-item>
      </el-menu>
      <li style="width: 18%"
          class="right">
        <div class="box">
          <div class="tit">民族分布(总数:{{ sum_t }})</div>
          <div class="boxnav"
               style="height: 150px">
            <div style="float: left; width: 100%; height: 140px"
                 id="echart6"></div>
          </div>
        </div>
      </li>
      <li style="width: 18%"
          class="right">
        <div class="box">
          <div class="tit">性别分布(总数:{{ sum_t }})</div>
          <div class="boxnav"
               style="height: 150px">
            <div style="float: left; width: 100%; height: 150px"
                 id="echart5"></div>
          </div>
        </div>
      </li>
      <li style="width: 18%"
          class="right">
        <div class="box">
          <div class="tit">学历分布(总数:{{ sum_t }})</div>
          <div class="boxnav"
               style="height: 150px">
            <div style="float: left; width: 100%; height: 150px"
                 id="echart4"></div>
          </div>
        </div>
      </li>

      <li style="width: 18%"
          class="right">
        <div class="box">
          <div class="tit">职称分布(总数:{{ sum_t }})</div>
          <div class="boxnav"
               style="height: 150px">
            <div style="float: left; width: 100%; height: 150px"
                 id="echart8"></div>
          </div>
        </div>
      </li>
      <li style="width: 36%"
          class="right">
        <div class="box">
          <div class="tit">学院分布(总数:{{ sum_t }})</div>
          <div class="boxnav"
               style="height: 150px">
            <div style="float: left; width: 100%; height: 140px"
                 id="echart9"></div>
          </div>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
import { callDepartment } from "../api/college/minNationality";
//引入swiper
import Swiper from "swiper";
import "swiper/swiper-bundle.css";
import SwiperCore, {
  Autoplay,
  EffectFade,
  Pagination,
  Navigation,
} from "swiper";
import SchoolMap from "./schoolMap.vue";
SwiperCore.use([Autoplay, EffectFade, Pagination, Navigation]);

export default {
  name: "minNationality",
  data () {
    return {
      sum_s: "",
      sum_t: "",

      //echart1
      echart1List: [],
      echart1data: [],
      echart1dataAxis: [],
      //echart2
      echart2List: [],
      echart2data: [],
      echart2dataAxis: [],
      //echart3
      echart3List: [],
      echart3data: [],
      echart3dataAxis: [],
      //echart4
      echart4List: [],
      echart4data: [],
      echart4dataAxis: [],
      //echart5
      echart5List: [],
      echart5data: [],
      echart5dataAxis: [],
      //echart6
      echart6List: [],
      echart6data: [],
      echart6dataAxis: [],
      //echart7
      echart7List: [],
      echart7data: [],
      echart7dataAxis: [],
      //echart8
      echart8List: [],
      echart8data: [],
      echart8dataAxis: [],
      //echart9
      echart9List: [],
      echart9data: [],
      echart9dataAxis: [],
    };
  },
  created () {
    this.showWorkObject();
  },
  watch: {
    echart1List: {
      deep: true,
      handler (newVal, oldVal) {
        this.init_myChart1();
      },
    },
    echart2data: {
      deep: true,
      handler (newVal, oldVal) {
        this.init_myChart2();
      },
    },
    echart2dataAxis: {
      deep: true,
      handler () {
        this.init_myChart2();
      },
    },
    echart3data: {
      deep: true,
      handler (newVal, oldVal) {
        this.init_myChart3();
      },
    },
    echart3dataAxis: {
      deep: true,
      handler () {
        this.init_myChart3();
      },
    },
    echart4List: {
      deep: true,
      handler (newVal, oldVal) {
        this.init_myChart4();
      },
    },
    echart7data: {
      deep: true,
      handler (newVal, oldVal) {
        this.init_myChart7_1();
        this.init_myChart7_2();
        this.init_myChart7_3();
      },
    },
    echart7dataAxis: {
      deep: true,
      handler (newVal, oldVal) {
        this.init_myChart7_1();
        this.init_myChart7_2();
        this.init_myChart7_3();
      },
    },

    echart5data: {
      deep: true,
      handler (newVal, oldVal) {
        this.init_myChart5();
      },
    },
    echart5dataAxis: {
      deep: true,
      handler () {
        this.init_myChart5();
      },
    },
    echart6data: {
      deep: true,
      handler (newVal, oldVal) {
        this.init_myChart6();
      },
    },
    echart6dataAxis: {
      deep: true,
      handler () {
        this.init_myChart6();
      },
    },
    echart8List: {
      deep: true,
      handler (newVal, oldVal) {
        this.init_myChart8();
      },
    },
    echart9List: {
      deep: true,
      handler (newVal, oldVal) {
        this.init_myChart9();
      },
    },
    sum_t: {
      deep: true,
      handler () {
        this.sum_t;
      },
    },
    sum_s: {
      deep: true,
      handler () {
        this.sum_s;
      },
    },
  },
  mounted () {
    this.$bus.$on("wenxue", this.minNationality); //文学与新闻传播学院党委
    this.$bus.$on("shiping", this.minNationality); //食品科技学院党委
    this.$bus.$on("qixiang", this.minNationality); //海洋与气象学院党委
    this.$bus.$on("houqin", this.minNationality); //后勤与产业党委
    this.$bus.$on("jixie", this.minNationality); //机械工程学院党委
    this.$bus.$on("guanli", this.minNationality); //管理学院党委
    this.$bus.$on("makesi", this.minNationality); //马克思主义学院党委
    this.$bus.$on("jingji", this.minNationality); //经济学院党委
    this.$bus.$on("nengyuan", this.minNationality); //海洋工程与能源学院党委
    this.$bus.$on("jisuanji", this.minNationality); //数学与计算机学院党委
    this.$bus.$on("dianzi", this.minNationality); //电子与信息工程学院党委
    this.$bus.$on("huaxue", this.minNationality); //化学与环境学院党委
    this.$bus.$on("nongye", this.minNationality); //滨海农业学院党委
    this.$bus.$on("shuichan", this.minNationality); //水产学院党委
    this.$bus.$on("fazhen", this.minNationality); //法政学院党委
    this.$bus.$on("waiguoyu", this.minNationality); //外国语学院党委
    this.$bus.$on("zhongge", this.minNationality); //中歌艺术学院党委
    this.$bus.$on("tiyu", this.minNationality); //体育与休闲学院党委
    this.$bus.$on("jiguan", this.minNationality); //机关党委
    this.$bus.$on("tuixiu", this.minNationality); //离退休干部党委
    this.$bus.$on("jiaofu", this.minNationality); //教辅单位党委init_myChart9
    this.init_myChart8();
    this.init_myChart1();
    this.init_myChart2();
    this.init_myChart3();
    this.init_myChart9();

    //    this.init_myChart4();
    this.init_myChart6();
    this.init_myChart7_1();
    this.init_myChart7_2();
    this.init_myChart7_3();
    // this.init_myChart7_4();

    new Swiper(".scroll-container", {
      loop: false,
      speed: 1000,
      autoplay: {
        delay: 2000,
        stopOnLastSlide: false,
        disableOnInteraction: false,
        pauseOnMouseEnter: true,
      },
    });
  },
  methods: {
    //对单一学院进行切换
    minNationality (department) {
      callDepartment(department).then((res) => {
        let result = res;
        //echart1
        this.echart1data = [];
        this.echart1dataAxis = [];
        this.echart1List = result.res1.t;
        this.echart1List.forEach((item) => this.echart1data.push(item.total));
        this.echart1List.forEach((item) =>
          this.echart1dataAxis.push(item.sex)
        );

        // echart3
        this.echart3data = [];
        this.echart3dataAxis = [];
        this.echart3List = result.res3.t;
        this.echart3List.map((item) => {
          this.echart3data = JSON.parse(
            JSON.stringify(item)
              .replace("total", "value")
              .replace("nation", "name")
          );
          this.echart3dataAxis.push(this.echart3data);
          // console.log(this.echart3dataAxis);
          this.echart3dataAxis = this.echart3dataAxis.filter(
            (item) => item.value > 0
          );
        });
        //echart4
        this.echart4data = [];
        this.echart4dataAxis = [];
        this.echart4List = result.res4.t;
        this.echart4List.forEach((item) => this.echart4data.push(item.total));
        this.echart4List.forEach((item) =>
          this.echart4dataAxis.push(item.degree)
        );
        //echart5
        this.echart5data = [];
        this.echart5dataAxis = [];
        this.echart5List = result.res5.t;
        this.echart5List.forEach((item) => this.echart5data.push(item.total));
        this.echart5List.forEach((item) => this.echart5dataAxis.push(item.sex));
        //echart6
        this.echart6data = [];
        this.echart6dataAxis = [];
        this.echart6List = result.res6.t;
        this.echart6List.map((item) => {
          this.echart6data = JSON.parse(
            JSON.stringify(item)
              .replace("total", "value")
              .replace("nation", "name")
          );
          this.echart6dataAxis.push(this.echart6data);
          // console.log(this.echart6dataAxis);
          this.echart6dataAxis = this.echart6dataAxis.filter(
            (item) => item.value > 0
          );
        });
        //echart8

        this.echart8data = [];
        this.echart8dataAxis = [];
        this.echart8List = result.res8.t;
        this.echart8List.forEach((item) => this.echart8data.push(item.count));
        this.echart8List.forEach((item) =>
          this.echart8dataAxis.push(item.LEVEL)
        );
        //  sum_t教师人数
        this.sum_t = "";
        this.sum_t = result.res0.t;
        //  sum_s学生人数
        this.sum_s = "";
        this.sum_s = result.res10.t;
      });
    },

    async showWorkObject () {
      let { data: res1 } = await this.$axios.post(
        "http://localhost:9107/service/servicedecisioncenter/ShaoShuMinZu/queryDegree"
      );
      let { data: res2 } = await this.$axios.post(
        "http://localhost:9107/service/servicedecisioncenter/ShaoShuMinZu/querySex"
      );
      let { data: res3 } = await this.$axios.post(
        "http://localhost:9107/service/servicedecisioncenter/ShaoShuMinZu/queryNational"
      );
      //echart8
      // let  res4  = await this.$API.minNationality.abcde()
      let { data: res4 } = await this.$axios.post(
        "http://localhost:9107/service/servicedecisioncenter/ShaoShuMinZu/queryTitle"
      );
      //echart7
      // let  res5  = await this.$API.minNationality.abc()
      let { data: res5 } = await this.$axios.post(
        "http://localhost:9107/service/servicedecisioncenter/ShaoShuMinZu/queryDepartment"
      );
      // echart3
      let { data: res6 } = await this.$axios.post(
        "http://localhost:9107/service/servicedecisioncenter/ShaoShuMinZu/queryNationalOfStudent"
      );
      // echart1
      let { data: res7 } = await this.$axios.post(
        "http://localhost:9107/service/servicedecisioncenter/ShaoShuMinZu/querySexOfStudent"
      );
      // echart2
      let { data: res8 } = await this.$axios.post(
        "http://localhost:9107/service/servicedecisioncenter/ShaoShuMinZu/queryByDepartmentOfStudent"
      );
      let { data: res9 } = await this.$axios.post(
        "http://localhost:9107/service/servicedecisioncenter/ShaoShuMinZu/queryDepartment"
      );

      let { data: res0 } = await this.$axios.post(
        "http://localhost:9107/service/servicedecisioncenter/ShaoShuMinZu/queryCountOfTeacher"
      );
      let { data: res10 } = await this.$axios.post(
        "http://localhost:9107/service/servicedecisioncenter/ShaoShuMinZu/queryCountOfStudentByDepartment"
      );

      this.sum_t = res0.t;
      this.sum_s = res10.t;
      //echart1
      this.echart1List = res7.t;
      this.echart1List.forEach((item) => this.echart1data.push(item.total));
      this.echart1List.forEach((item) =>
        this.echart1dataAxis.push(item.sex)
      );
      // echart2
      this.echart2List = res8.t;
      this.echart2List.map((item) => {
        this.echart2data = JSON.parse(
          JSON.stringify(item)
            .replace("total", "value")
            .replace("department", "name")
        );
        this.echart2dataAxis.push(this.echart2data);
        this.echart2dataAxis = this.echart2dataAxis.filter(
          (item) => item.value > 0
        );
      });
      // echart3
      this.echart3List = res6.t;
      this.echart3List.map((item) => {
        this.echart3data = JSON.parse(
          JSON.stringify(item)
            .replace("total", "value")
            .replace("nation", "name")
        );
        this.echart3dataAxis.push(this.echart3data);
        // console.log(this.echart3dataAxis);
        this.echart3dataAxis = this.echart3dataAxis.filter(
          (item) => item.value > 0
        );
      });
      console.log('11111', this.echart3dataAxis);
      //echart4
      this.echart4List = res1.t;
      this.echart4List.forEach((item) => this.echart4data.push(item.total));
      this.echart4List.forEach((item) =>
        this.echart4dataAxis.push(item.degree)
      );
      //echart5
      this.echart5List = res2.t;
      this.echart5List.forEach((item) => this.echart5data.push(item.total));
      this.echart5List.forEach((item) => this.echart5dataAxis.push(item.sex));
      //echart6
      this.echart6List = res3.t;
      this.echart6List.map((item) => {
        this.echart6data = JSON.parse(
          JSON.stringify(item)
            .replace("total", "value")
            .replace("nation", "name")
        );
        this.echart6dataAxis.push(this.echart6data);
        // console.log(this.echart6dataAxis);
        this.echart6dataAxis = this.echart6dataAxis.filter(
          (item) => item.value > 0
        );
      });
      //echart8
      this.echart8List = res4.t;
      this.echart8List.forEach((item) => this.echart8data.push(item.count));
      this.echart8List.forEach((item) => this.echart8dataAxis.push(item.LEVEL));
      //echart7
      this.echart7data = [];
      this.echart7dataAxis = [];
      this.echart7List = res5.t;
      this.echart7List.forEach((item) => this.echart7data.push(item.total));
      this.echart7List.forEach((item) =>
        this.echart7dataAxis.push(item.department)
      );
      //echart9
      this.echart9List = res9.t;
      this.echart9List.map((item) => {
        this.echart9data = JSON.parse(
          JSON.stringify(item)
            .replace("total", "value")
            .replace("department", "name")
        );
        this.echart9dataAxis.push(this.echart9data);
        this.echart9dataAxis = this.echart9dataAxis.filter(
          (item) => item.value > 0
        );
      });
      // 总数
    },

    init_myChart1 () {
      let data = this.echart1data;
      let dataAxis = this.echart1dataAxis;
      var myChart1 = this.$echarts.init(document.getElementById("echart1"));
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
          height: "60%",
          bottom: "27%",
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
                { offset: 1, color: "#83bff6" },
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
      option && myChart1.setOption(option);
      window.addEventListener("resize", function () {
        myChart1.resize();
      });
    },
    init_myChart6 () {
      let data = this.echart6dataAxis;
      console.log(data);
      var myChart6 = this.$echarts.init(document.getElementById("echart6"));
      var option = {
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b}: {c} ({d}%)",
        },
        legend: {
          type: "scroll",
          orient: "vertical",
          top: "0",
          left: "0",
          itemWidth: 11,
          itemHeight: 11,
          textStyle: {
            color: "rgba(255,255,255,.5)",
            fontSize: "10",
          },
        },
        series: [
          {
            name: "民族分布",
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
            data: this.echart6dataAxis,
          },
        ],
      };
      //使用刚指定的配置项和数据显示图标
      option && myChart6.setOption(option);
      console.log(option);
      window.addEventListener("resize", function () {
        myChart6.resize();
      });
    },
    init_myChart2 () {
      var myChart2 = this.$echarts.init(document.getElementById("echart2"));
      var option = {
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b}: {c} ({d}%)",
          position: function (p) {
            //其中p为当前鼠标的位置
            return [p[0] + 10, p[1] - 10];
          },
        },
        legend: {
          type: "scroll",
          orient: "vertical",
          top: "0",
          left: "0",
          itemWidth: 11,
          itemHeight: 11,
          textStyle: {
            color: "rgba(255,255,255,.5)",
            fontSize: "11",
          },
        },
        series: [
          {
            name: "学院分布",
            type: "pie",
            radius: ["55%", "70%"],
            center: ["80%", "45%"],
            color: [
              "#62c98d",
              "#2f89cf",
              "#4cb9cf",
              "#e0c828",
              "#e58c00",
              "#eb295b",
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
              "#b21ab4",
              "#6f0099",
              "#2a2073",
              "#0b5ea8",
              "#17aecc",
              "#b3b3ff",
              "#eb99ff",
              "#fae6ff",
              "#e6f2ff",
              "#eeeeee",
            ],
            label: { show: false, position: "center" },
            emphasis: {
              scale: true,
              scaleSize: 15,
              label: {
                show: true,
                fontSize: "11",
                fontWeight: "bold",
                color: "white",
              },
            },
            labelLine: { show: false },
            data: this.echart2dataAxis,
          },
        ],
      };
      //使用刚指定的配置项和数据显示图标
      option && myChart2.setOption(option);
      window.addEventListener("resize", function () {
        myChart2.resize();
      });
    },
    // 学生民族分布 
    init_myChart3 () {
      var myChart3 = this.$echarts.init(document.getElementById("echart3"));
      var option = {
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b}: {c} ({d}%)",
        },
        legend: {
          type: "scroll",
          orient: "vertical",
          top: "0",
          left: "0",
          itemWidth: 11,
          itemHeight: 11,
          textStyle: {
            color: "rgba(255,255,255,.5)",
            fontSize: "10",
          },
        },
        series: [
          {
            name: "民族分布",
            type: "pie",
            radius: ["60%", "75%"],
            center: ["70%", "45%"],
            color: [
              "#62c98d",
              "#2f89cf",
              "#4cb9cf",
              "#e0c828",
              "#e58c00",
              "#eb295b",
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
              "#b21ab4",
              "#6f0099",
              "#2a2073",
              "#0b5ea8",
              "#17aecc",
              "#b3b3ff",
              "#eb99ff",
              "#fae6ff",
              "#e6f2ff",
              "#eeeeee",
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
            data: this.echart3dataAxis,
          },
        ],
      };
      //使用刚指定的配置项和数据显示图标
      option && myChart3.setOption(option);
      window.addEventListener("resize", function () {
        myChart3.resize();
      });
    },
    init_myChart8 () {
      // 成员数量echart图
      let numberChar = this.$echarts.init(document.getElementById("echart8"));
      var numberOption = {
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
          height: "60%",
          bottom: "27%",
          left: "5%",
        },
        xAxis: {
          type: "category",
          data: this.echart8dataAxis,
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
                { offset: 1, color: "#83bff6" },
              ]),
              barBorderRadius: [5, 5, 0, 0],
            },
            emphasis: {
              itemStyle: {},
            },
            data: this.echart8data,
          },
        ],
      };
      numberChar.setOption(numberOption);
      window.addEventListener("resize", function () {
        numberChar.resize();
      });
    },
    init_myChart4 () {
      let data = this.echart4data;
      let dataAxis = this.echart4dataAxis;
      var myChart4 = this.$echarts.init(document.getElementById("echart4"));
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
          height: "60%",
          bottom: "27%",
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
                { offset: 1, color: "#83bff6" },
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
      option && myChart4.setOption(option);
      window.addEventListener("resize", function () {
        myChart4.resize();
      });
    },
    init_myChart5 () {
      var myChart5 = this.$echarts.init(document.getElementById("echart5"));
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
            name: "性别分布",
            type: "pie",
            radius: ["60%", "75%"],
            center: ["70%", "45%"],
            color: ["#62c98d", "#2f89cf"],
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
    init_myChart7_1 () {
      var myChart7_1 = this.$echarts.init(document.querySelector(".main7-1"));
      //var XData=["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"];
      //var yData=[1243,2315,1164,3021,3521,4121,2001,1983,2541,2612,2331,1992];
      var XData = this.echart7dataAxis.slice(0, 8);
      var yData = this.echart7data.slice(0, 8);
      var option = {
        backgroundColor: "",
        xAxis: {
          axisTick: {
            show: false,
          },
          splitLine: {
            show: false,
          },
          splitArea: {
            show: false,
          },
          data: XData,
          axisLabel: {
            formatter: function (value) {
              var ret = ""; //拼接加\n返回的类目项
              var maxLength = 4; //每项显示文字个数
              var valLength = value.length; //X轴类目项的文字个数
              var rowN = Math.ceil(valLength / maxLength); //类目项需要换行的行数
              if (rowN > 1) {
                //如果类目项的文字大于3,
                for (var i = 0; i < rowN; i++) {
                  var temp = ""; //每次截取的字符串
                  var start = i * maxLength; //开始截取的位置
                  var end = start + maxLength; //结束截取的位置
                  //这里也可以加一个是否是最后一行的判断，但是不加也没有影响，那就不加吧
                  temp = value.substring(start, end) + "\n";
                  ret += temp; //凭借最终的字符串
                }
                return ret;
              } else {
                return value;
              }
            },
            interval: 0,
            fontSize: 10,
            fontWeight: 100,
            textStyle: {
              color: "#9faeb5",
            },
          },
          axisLine: {
            lineStyle: {
              color: "#4d4d4d",
            },
          },
        },
        yAxis: {
          axisTick: {
            show: false,
          },
          splitLine: {
            show: false,
          },
          splitArea: {
            show: false,
          },
          axisLabel: {
            textStyle: {
              color: "#9faeb5",
              fontSize: 16,
            },
          },
          axisLine: {
            show: true,
            lineStyle: {
              color: "#4d4d4d",
            },
          },
        },
        tooltip: {
          trigger: "axis",
          transitionDuration: 0,
          // backgroundColor: "rgba(83,93,105,0.8)",
          // borderColor: "#535b69",
          // borderRadius: 8,
          // borderWidth: 2,
          // padding: [5, 10],
          formatter: function (params, ticket, callback) {
            var res = "";
            for (var i = 0, l = params.length; i < l; i++) {
              res +=
                "" + params[i].seriesName + " : " + params[i].value + "<br>";
            }
            return res;
          },
          axisPointer: {
            type: "line",
            lineStyle: {
              type: "dashed",
              color: "#ffff00",
            },
          },
        },
        series: [
          {
            name: "人数(柱状图)",
            type: "bar",
            itemStyle: {
              normal: {
                color: {
                  type: "linear",
                  x: 0,
                  y: 0,
                  x2: 0,
                  y2: 1,
                  colorStops: [
                    {
                      offset: 0,
                      color: "#00d386", // 0% 处的颜色
                    },
                    {
                      offset: 1,
                      color: "#0076fc", // 100% 处的颜色
                    },
                  ],
                  globalCoord: false, // 缺省为 false
                },
                barBorderRadius: 15,
              },
            },
            label: {
              normal: {
                show: true,
                position: "top",
                textStyle: {
                  color: "#ffc72b",
                  fontSize: 10,
                },
              },
            },
            data: yData,
            barWidth: 16,
          },
          {
            name: "人数(折线图)",
            type: "line",
            itemStyle: {
              /*设置折线颜色*/
              normal: {
                /* color:'#c4cddc'*/
              },
            },
            data: yData,
          },
        ],
      };
      option && myChart7_1.setOption(option);
      window.addEventListener("resize", function () {
        myChart7_1.resize();
      });
    },
    init_myChart7_2 () {
      var myChart7_2 = this.$echarts.init(document.querySelector(".main7-2"));
      //var XData=["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"];
      //var yData=[1243,2315,1164,3021,3521,4121,2001,1983,2541,2612,2331,1992];

      var XData = this.echart7dataAxis.slice(8, 16);
      var yData = this.echart7data.slice(8, 16);
      var option = {
        backgroundColor: "",
        xAxis: {
          axisTick: {
            show: false,
          },
          splitLine: {
            show: false,
          },
          splitArea: {
            show: false,
          },
          data: XData,
          axisLabel: {
            formatter: function (value) {
              var ret = ""; //拼接加\n返回的类目项
              var maxLength = 4; //每项显示文字个数
              var valLength = value.length; //X轴类目项的文字个数
              var rowN = Math.ceil(valLength / maxLength); //类目项需要换行的行数
              if (rowN > 1) {
                //如果类目项的文字大于3,
                for (var i = 0; i < rowN; i++) {
                  var temp = ""; //每次截取的字符串
                  var start = i * maxLength; //开始截取的位置
                  var end = start + maxLength; //结束截取的位置
                  //这里也可以加一个是否是最后一行的判断，但是不加也没有影响，那就不加吧
                  temp = value.substring(start, end) + "\n";
                  ret += temp; //凭借最终的字符串
                }
                return ret;
              } else {
                return value;
              }
            },
            interval: 0,
            fontSize: 10,
            fontWeight: 100,
            textStyle: {
              color: "#9faeb5",
            },
          },
          axisLine: {
            lineStyle: {
              color: "#4d4d4d",
            },
          },
        },
        yAxis: {
          axisTick: {
            show: false,
          },
          splitLine: {
            show: false,
          },
          splitArea: {
            show: false,
          },
          axisLabel: {
            textStyle: {
              color: "#9faeb5",
              fontSize: 16,
            },
          },
          axisLine: {
            show: true,
            lineStyle: {
              color: "#4d4d4d",
            },
          },
        },
        tooltip: {
          trigger: "axis",
          transitionDuration: 0,
          // backgroundColor: "rgba(83,93,105,0.8)",
          // borderColor: "#535b69",
          // borderRadius: 8,
          // borderWidth: 2,
          // padding: [5, 10],
          formatter: function (params, ticket, callback) {
            var res = "";
            for (var i = 0, l = params.length; i < l; i++) {
              res +=
                "" + params[i].seriesName + " : " + params[i].value + "<br>";
            }
            return res;
          },
          axisPointer: {
            type: "line",
            lineStyle: {
              type: "dashed",
              color: "#ffff00",
            },
          },
        },
        series: [
          {
            name: "人数(柱状图)",
            type: "bar",
            itemStyle: {
              normal: {
                color: {
                  type: "linear",
                  x: 0,
                  y: 0,
                  x2: 0,
                  y2: 1,
                  colorStops: [
                    {
                      offset: 0,
                      color: "#00d386", // 0% 处的颜色
                    },
                    {
                      offset: 1,
                      color: "#0076fc", // 100% 处的颜色
                    },
                  ],
                  globalCoord: false, // 缺省为 false
                },
                barBorderRadius: 15,
              },
            },
            label: {
              normal: {
                show: true,
                position: "top",
                textStyle: {
                  color: "#ffc72b",
                  fontSize: 10,
                },
              },
            },
            data: yData,
            barWidth: 16,
          },
          {
            name: "人数(折线图)",
            type: "line",
            itemStyle: {
              /*设置折线颜色*/
              normal: {
                /* color:'#c4cddc'*/
              },
            },
            data: yData,
          },
        ],
      };
      option && myChart7_2.setOption(option);
      window.addEventListener("resize", function () {
        myChart7_2.resize();
      });
    },
    init_myChart7_3 () {
      var myChart7_3 = this.$echarts.init(document.querySelector(".main7-3"));
      //var XData=["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"];
      //var yData=[1243,2315,1164,3021,3521,4121,2001,1983,2541,2612,2331,1992];

      var XData = this.echart7dataAxis.slice(16, 24);
      var yData = this.echart7data.slice(16, 24);
      console.log(XData);
      var option = {
        backgroundColor: "",
        xAxis: {
          axisTick: {
            show: false,
          },
          splitLine: {
            show: false,
          },
          splitArea: {
            show: false,
          },
          data: XData,
          axisLabel: {
            formatter: function (value) {
              var ret = ""; //拼接加\n返回的类目项
              var maxLength = 4; //每项显示文字个数
              var valLength = value.length; //X轴类目项的文字个数
              var rowN = Math.ceil(valLength / maxLength); //类目项需要换行的行数
              if (rowN > 1) {
                //如果类目项的文字大于3,
                for (var i = 0; i < rowN; i++) {
                  var temp = ""; //每次截取的字符串
                  var start = i * maxLength; //开始截取的位置
                  var end = start + maxLength; //结束截取的位置
                  //这里也可以加一个是否是最后一行的判断，但是不加也没有影响，那就不加吧
                  temp = value.substring(start, end) + "\n";
                  ret += temp; //凭借最终的字符串
                }
                return ret;
              } else {
                return value;
              }
            },
            interval: 0,
            fontSize: 10,
            fontWeight: 100,
            textStyle: {
              color: "#9faeb5",
            },
          },
          axisLine: {
            lineStyle: {
              color: "#4d4d4d",
            },
          },
        },
        yAxis: {
          axisTick: {
            show: false,
          },
          splitLine: {
            show: false,
          },
          splitArea: {
            show: false,
          },
          axisLabel: {
            textStyle: {
              color: "#9faeb5",
              fontSize: 16,
            },
          },
          axisLine: {
            show: true,
            lineStyle: {
              color: "#4d4d4d",
            },
          },
        },
        tooltip: {
          trigger: "axis",
          transitionDuration: 0,
          // backgroundColor: "rgba(83,93,105,0.8)",
          // borderColor: "#535b69",
          // borderRadius: 8,
          // borderWidth: 2,
          // padding: [5, 10],
          formatter: function (params, ticket, callback) {
            var res = "";
            for (var i = 0, l = params.length; i < l; i++) {
              res +=
                "" + params[i].seriesName + " : " + params[i].value + "<br>";
            }
            return res;
          },
          axisPointer: {
            type: "line",
            lineStyle: {
              type: "dashed",
              color: "#ffff00",
            },
          },
        },
        series: [
          {
            name: "人数(柱状图)",
            type: "bar",
            itemStyle: {
              normal: {
                color: {
                  type: "linear",
                  x: 0,
                  y: 0,
                  x2: 0,
                  y2: 1,
                  colorStops: [
                    {
                      offset: 0,
                      color: "#00d386", // 0% 处的颜色
                    },
                    {
                      offset: 1,
                      color: "#0076fc", // 100% 处的颜色
                    },
                  ],
                  globalCoord: false, // 缺省为 false
                },
                barBorderRadius: 15,
              },
            },
            label: {
              normal: {
                show: true,
                position: "top",
                textStyle: {
                  color: "#ffc72b",
                  fontSize: 10,
                },
              },
            },
            data: yData,
            barWidth: 16,
          },
          {
            name: "人数(折线图)",
            type: "line",
            itemStyle: {
              /*设置折线颜色*/
              normal: {
                /* color:'#c4cddc'*/
              },
            },
            data: yData,
          },
        ],
      };
      option && myChart7_3.setOption(option);
      window.addEventListener("resize", function () {
        myChart7_3.resize();
      });
    },
    init_myChart7_4 () {
      var myChart7_4 = this.$echarts.init(document.querySelector(".main7-4"));
      //var XData=["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"];
      //var yData=[1243,2315,1164,3021,3521,4121,2001,1983,2541,2612,2331,1992];
      var XData = ["一", "二"];
      var yData = [0, 0];

      // var XData = this.collegememberx.slice(24, 32);
      // var yData = this.collegemembery.slice(24, 32);
      var option = {
        backgroundColor: "",
        xAxis: {
          axisTick: {
            show: false,
          },
          splitLine: {
            show: false,
          },
          splitArea: {
            show: false,
          },
          data: XData,
          axisLabel: {
            formatter: function (value) {
              var ret = ""; //拼接加\n返回的类目项
              var maxLength = 4; //每项显示文字个数
              var valLength = value.length; //X轴类目项的文字个数
              var rowN = Math.ceil(valLength / maxLength); //类目项需要换行的行数
              if (rowN > 1) {
                //如果类目项的文字大于3,
                for (var i = 0; i < rowN; i++) {
                  var temp = ""; //每次截取的字符串
                  var start = i * maxLength; //开始截取的位置
                  var end = start + maxLength; //结束截取的位置
                  //这里也可以加一个是否是最后一行的判断，但是不加也没有影响，那就不加吧
                  temp = value.substring(start, end) + "\n";
                  ret += temp; //凭借最终的字符串
                }
                return ret;
              } else {
                return value;
              }
            },
            interval: 0,
            fontSize: 14,
            fontWeight: 100,
            textStyle: {
              color: "#9faeb5",
            },
          },
          axisLine: {
            lineStyle: {
              color: "#4d4d4d",
            },
          },
        },
        yAxis: {
          axisTick: {
            show: false,
          },
          splitLine: {
            show: false,
          },
          splitArea: {
            show: false,
          },
          axisLabel: {
            textStyle: {
              color: "#9faeb5",
              fontSize: 16,
            },
          },
          axisLine: {
            show: true,
            lineStyle: {
              color: "#4d4d4d",
            },
          },
        },
        tooltip: {
          trigger: "axis",
          transitionDuration: 0,
          // backgroundColor: "rgba(83,93,105,0.8)",
          // borderColor: "#535b69",
          // borderRadius: 8,
          // borderWidth: 2,
          // padding: [5, 10],
          formatter: function (params, ticket, callback) {
            var res = "";
            for (var i = 0, l = params.length; i < l; i++) {
              res +=
                "" + params[i].seriesName + " : " + params[i].value + "<br>";
            }
            return res;
          },
          axisPointer: {
            type: "line",
            lineStyle: {
              type: "dashed",
              color: "#ffff00",
            },
          },
        },
        series: [
          {
            name: "人数(柱状图)",
            type: "bar",
            itemStyle: {
              normal: {
                color: {
                  type: "linear",
                  x: 0,
                  y: 0,
                  x2: 0,
                  y2: 1,
                  colorStops: [
                    {
                      offset: 0,
                      color: "#00d386", // 0% 处的颜色
                    },
                    {
                      offset: 1,
                      color: "#0076fc", // 100% 处的颜色
                    },
                  ],
                  globalCoord: false, // 缺省为 false
                },
                barBorderRadius: 15,
              },
            },
            label: {
              normal: {
                show: true,
                position: "top",
                textStyle: {
                  color: "#ffc72b",
                  fontSize: 10,
                },
              },
            },
            data: yData,
            barWidth: 16,
          },
          {
            name: "人数(折线图)",
            type: "line",
            itemStyle: {
              /*设置折线颜色*/
              normal: {
                /* color:'#c4cddc'*/
              },
            },
            data: yData,
          },
        ],
      };
      option && myChart7_4.setOption(option);
      window.addEventListener("resize", function () {
        myChart7_4.resize();
      });
    },
    init_myChart9 () {
      let data = this.echart9dataAxis;

      var myChart9 = this.$echarts.init(document.getElementById("echart9"));
      var option = {
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b}: {c} ({d}%)",
          position: function (p) {
            //其中p为当前鼠标的位置
            return [p[0] - 190, p[1] - 40];
          },
        },
        legend: {
          type: "scroll",
          orient: "vertical",
          top: "0",
          left: "10px",
          itemWidth: 11,
          itemHeight: 11,
          textStyle: {
            color: "rgba(255,255,255,.5)",
            fontSize: "11",
          },
        },
        series: [
          {
            name: "学院分布",
            type: "pie",
            radius: ["70%", "90%"],
            center: ["80%", "50%"],
            color: [
              "#62c98d",
              "#2f89cf",
              "#4cb9cf",
              "#e0c828",
              "#e58c00",
              "#eb295b",
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
              "#b21ab4",
              "#6f0099",
              "#2a2073",
              "#0b5ea8",
              "#17aecc",
              "#b3b3ff",
              "#eb99ff",
              "#fae6ff",
              "#e6f2ff",
              "#eeeeee",
            ],
            label: { show: false, position: "center" },
            emphasis: {
              scale: true,
              scaleSize: 15,
              label: {
                show: true,
                fontSize: "11",
                fontWeight: "bold",
                color: "white",
              },
            },
            labelLine: { show: false },
            data: this.echart9dataAxis,
          },
        ],
      };
      //使用刚指定的配置项和数据显示图标
      option && myChart9.setOption(option);
      window.addEventListener("resize", function () {
        myChart9.resize();
      });
    },
  },
  components: { SchoolMap },
};
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
  background-color: #032654;
}

::v-deep .el-menu-item:hover {
  background-color: #626f8b69 !important;
}

::v-deep .el-menu-item:active,
::v-deep .el-menu-item:focus {
  background-color: #626f8b69 !important;
}

.scroll-container {
  position: relative;
  width: 100%;
  height: 100%;
  overflow: hidden;
}
</style>
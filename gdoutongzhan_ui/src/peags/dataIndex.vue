<template>
    <div class="mainbox content">
      <ul class="clearfix nav1">
        <li style="width: 22%">
          <div class="box">
            <div class="tit">统战工作对象</div>
            <div class="boxnav" style="height: 307px">
              <div style="float: left; width: 100%; height: 305px" ref="echart1"></div>
            </div>
          </div>
          <div class="box">
            <div class="tit">党外干部(总数:{{this.sum2}})</div>
            <div class="boxnav" style="height: 260px">
              <div style="float: left; width: 100%; height: 260px" id="echart2"></div>
            </div>
          </div>
        </li>
        <li style="width: 42%">
          <div class="box">
            <div class="boxnav mapc" style="height: 655px; position: relative">
              <div class="map" id="map">
                <SchoolMap />
              </div>
            </div>
          </div>
        </li>
        <li style="width: 18%">
          <div class="box">
            <div class="tit">民主党派(总数:{{this.sum3}})</div>
            <div class="boxnav" style="height: 172px">
              <div style="float: left; width: 100%; height: 174px" id="echart3"></div>
            </div>
          </div>
          <div class="box">
            <div class="tit">少数民族(总数:{{this.sum5}})</div>
            <div class="boxnav" style="height: 172px">
              <div style="float: left; width: 100%; height: 164px" id="echart5"></div>
            </div>
          </div>
          <div class="box">
            <div class="tit">无党派、留学人员(总数:{{this.sum4}})</div>
            <div class="boxnav" style="height: 172px">
              <div style="float: left; width: 100%; height: 164px" id="echart4"></div>
            </div>
            <!--<div class="boxnav" style="height: 172px">
              <ul style="display: flex; flex-wrap: wrap;height: 100%;">
                <li style="height: 50%; width: 48%; text-align: center;">
                  <div class="minibox color1">
                    <span>{{this.nonmemberShip[1]?.other_party}}</span>
                    <p>{{this.nonmemberShip[1]?.count}}</p>
                  </div>
                </li>
                <li style="height: 50%;width: 48%;margin-left: 4%;text-align: center;">
                  <div class="minibox color2">
                    <span>{{this.nonmemberShip[2]?.other_party}}</span>
                    <p>{{this.nonmemberShip[2]?.count}}</p>
                  </div>
                </li>
                <li style="height: 50%;width: 100%;text-align: center;">
                  <div class="minibox color4">
                    <span>{{this.nonmemberShip[0]?.other_party}}</span>
                    <p>{{this.nonmemberShip[0]?.count}}</p>
                  </div>
                </li>
              </ul>
            </div>-->
          </div>
        </li>
        <li style="width: 18%">
          <div class="box">
            <div class="tit">两代表一委员(总数:{{this.sum8}})</div>
            <div class="boxnav" style="height: 172px;">
              <ul style="display: flex; flex-wrap: wrap;height: 100%;">
                <li style="height: 50%; width: 48%; text-align: center">
                  <div style="padding:5px 0" class="minibox color1">
                    <span>全国人大代表:</span>
                    <p>{{ npcCount }}</p>
                    <p>{{ npcArr }}</p>
                  </div>
                </li>
                <li style="height: 50%; width: 48%; margin-left: 4%; text-align: center">
                  <div style="padding:5px 0" class="minibox color1">
                    <span>市人大代表:</span>
                    <p>{{ mpcCount}}</p>
                    <p>{{ mpcArr }}</p>
                  </div>
                </li>
                <li style=" height: 50%; width: 48%;text-align: center;">
                  <div style="padding:5px 0" class="minibox color4">
                    <span>省级政协委员:</span>
                    <p>{{ PcpccCount }}</p>
                    <p>{{ PcpccArr }}</p>
                  </div>
                </li>
                <li style="height: 50%; width: 48%; margin-left: 4%; text-align: center">
                  <div style="padding:5px 0" class="minibox color2">
                    <span>市级政协委员:</span>
                    <p>{{ McpccCount }}</p>
                    <p> {{  McpccArr}}</p>
                  </div>
                </li>
              </ul>
            </div>
          </div>
          <div class="box">
            <div class="tit">获奖情况(总数:{{this.sum9}})</div>
            <div class="boxnav" style="height: 172px">
              <ul style="display: flex; flex-wrap: wrap;height: 100%;">
                <li style="height: 50%; width: 100%; text-align: center">
                  <div class="minibox color1">
                    <span>国家级</span>
                    <div>{{this.AwardCountryLevel[0]}}</div>
                  </div>
                </li>
                <li style="height: 50%; width: 100%; text-align: center">
                  <div class="minibox color4">
                    <span>省级</span>
                    <div>{{this.AwardProvincialLevel[0]}}</div>
                  </div>
                </li>
              </ul>
            </div>
          </div>
          <div class="box">
            <div class="tit">参政议政情况(总数:{{this.sum10}})</div>
            <div class="boxnav" style="height: 172px">
              <div style="float: left; width: 100%; height: 172px" id="echart10"></div>
            </div>
          </div>

          <!--<div class="box">
            <div class="tit">港澳台(总数:{{this.sum7}})</div>
            <div class="boxnav" style="height: 142px">
              <div style="float: left; width: 100%; height: 142px" id="echart7"></div>
            </div>
          </div>-->
        </li>
      </ul>
    </div>
</template>

<script>
import SchoolMap from "./schoolMap.vue";
import { callDepartment,callAll } from '../api/college/dataIndex';
export default {
  name: "myDataIndex",
  components: { SchoolMap },
  data(){
    return{
      //统战工作对象数组
        myChart1:null,
        workArr:[],
        objects:[],
        workObejct:[],    
      //党外干部数组
        myChart2:null,
        nonPartyInfo:[],
        sum2:null,
      //民主党派数组
        myChart3:null,
        parties:[],
        memberShip:[],
        sum3:null,
        //无党派数组
        myChart4:null,
        nonmemberShip:[],        
        sum4:null,
        //少数民族数组
        myChart5:null,
        nationalShip:[],
        sum5:null,
        //港澳台数组
        /* 
          myChart7:null,
          area:[],
          areatotal:[],
          sum7:null,
          */
      //两代表一委员数组
        myChart8:null,
        liangDaiBiao:[],
        sum8:null,
        //npc全国人大代表 mpc市人大代表  PCPCC 省政协 MCPCC市政协
        npc:[],
        npcCount:null,
        npcArr:'',
        mpc:[],
        mpcCount:null,
        mpcArr:'',
        Pcpcc:[],
        PcpccCount:null,
        PcpccArr:'',
        Mcpcc:[],
        McpccCount:null,
        McpccArr:'',
        //获奖情况数组
        myChart9:null,
        AwardCountryLevel:[],
        AwardProvincialLevel:[],
        sum9:null,
        //参政议政情况
        sum10:null  ,
        countList:[],
        yearList:[],
    }
  },

  watch:{
    //监听事件对象
    objects:{
      deep:true,
      handler(){
        this.init_myChart1();
      }
    },
    workObejct:{
      deep:true,
      handler(){
          this.init_myChart1();
      }
    },
    nonPartyInfo:{
      deep:true,
      handler(newVal, oldVal){
        this.init_myChart2();
      }
    },
    nonmemberShip:{
      deep:true,
      handler(newVal, oldVal){
        this.init_myChart4();
      }

    },
    nationalShip:{
      deep:true,
      handler(newVal, oldVal){
        this.init_myChart5();
      }
    },
    parties:{
      deep:true,
      handler(){
          this.init_myChart3();
      }
    },
    memberShip:{
      deep:true,
      handler(){
          this.init_myChart3();
      }
    },
     /*area:{
      deep:true,
      handler(){
          this.init_myChart7();
      }
    },
     areatotal:{
      deep:true,
      handler(){
          this.init_myChart7();
      }
    },*/
     countList:{
      deep:true,
      handler(){
          this.init_myChart10();
      }
    },
    yearList:{
      deep:true,
      handler(){
          this.init_myChart10();
      }
    },
  },

  methods: {
    //统战工作对象图表
    init_myChart1() {
      this.myChart1 = this.$echarts.init(this.$refs.echart1);   
    },
    get_myChart1Data(){
      this.updata_myChart1()
    },
    updata_myChart1(){
      const option = {
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
          height: "90%",
          bottom: "10%",
          left: "10%",
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
          data: ["民主党派","少数民族","知联会","留学归国人员","无党派人士"],
          axisLabel: {
            inside: true,
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
            barWidth: 24,
            label: {
              show: true,
              position: "left",
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
            data: this.workArr,
          },
        ],
      };
        this.myChart1.setOption(option);
    },

    //党外干部图表
    init_myChart2() { 
      this.myChart2 = this.$echarts.init(document.getElementById("echart2"));
    },
    get_myChart2Data(){ 
        let arr = this.nonPartyInfo
        this.nonPartyInfo=[]
      //处理返回的数组中每一个对象的key
        arr.map(item => {
        let _item = JSON.parse(JSON.stringify(item).replace('count', 'value').replace('joblevel', 'name'))
        this.nonPartyInfo.push(_item)
      })
      this.updata_myChart2()
    },
    updata_myChart2(){
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
          orient: "vertical",
          top: "30%",
          left: "0",
          textStyle: {
            color: "rgba(255,255,255,.5)",
            fontSize: "12",
          },
        },
        series: [
          {
            name: "职称分布",
            type: "pie",
            radius: ["65%", "75%"],
            center: ["60%", "45%"],
            color: [
              "#62c98d",
              "#2f89cf",
              "#4cb9cf",
              "#e0c828",
              "#e58c00",
              "#eb295b",
            ],
            label: { show: false, position: "center" },
            emphasis: {
              scale: true,
              scaleSize: 15,
              label: {
                show: true,
                fontSize: "25",
                fontWeight: "bold",
              },
            },
            labelLine: { show: false },
            data: this.nonPartyInfo,
          },
        ],
      };
      //使用刚指定的配置项和数据显示图标
      option &&this.myChart2.setOption(option);
    },

    //民主党派图表
    init_myChart3() {
      this.myChart3 = this.$echarts.init(document.getElementById("echart3"));
    },
    get_myChart3Data(){
      this.updata_myChart3()
    },
    updata_myChart3(){
      var option = {
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "line",
            z: -1,
            lineStyle: {
              type: "soild",
              width: 22,
              color: "#2f89cf",
            },
          },
        },
        grid: {
          width: "95%",
          height: "58%",
          bottom: "27%",
          left: "0%",
        },
        xAxis: {
          type: "category",
          data: this.parties,
          axisLabel: {
            fontSize: 10,
            inside: false,
            color: "#fff",
            interval:0,
            rotate:0
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
            barWidth: 22,
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
            data: this.memberShip,
          },
        ],
      };
      //使用刚指定的配置项和数据显示图标
      option &&this.myChart3.setOption(option);
    },

    //无党派，留学归国人员图表
    init_myChart4(){
      this.myChart4 = this.$echarts.init(document.getElementById("echart4"));
    },
    get_myChart4Data(){
      let arr = this.nonmemberShip
       //console.log(arr);
       this.nonmemberShip=[]
      //处理返回的数组中每一个对象的key  count
        arr.map(item => {
        let _item = JSON.parse(JSON.stringify(item).replace('count', 'value').replace('other_party', 'name'))
        this.nonmemberShip.push(_item)
        this.nonmemberShip= this.nonmemberShip.filter(item=>item.value>0)
      })
      this.updata_myChart4()

    },
    updata_myChart4(){
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
            name: "党派分布",
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
            data: this.nonmemberShip,
          },
        ],
      };
      //使用刚指定的配置项和数据显示图标
      option && this.myChart4.setOption(option);
 },

     //少数民族图表
    init_myChart5() {
      this.myChart5 = this.$echarts.init(document.getElementById("echart5"));
    },
    get_myChart5Data(){
      let arr = this.nationalShip
       //console.log(arr);
       this.nationalShip=[]
      //处理返回的数组中每一个对象的key  count
        arr.map(item => {
        let _item = JSON.parse(JSON.stringify(item).replace('totalOfStudent', 'value').replace('type', 'name').replace('totalOfTeacher','value'))
        this.nationalShip.push(_item)
        this.nationalShip= this.nationalShip.filter(item=>item.value>0)
      })
      this.updata_myChart5()
    },
    updata_myChart5(){
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
            data: this.nationalShip,
          },
        ],
      };
      //使用刚指定的配置项和数据显示图标
      option && this.myChart5.setOption(option);
  },

    //港澳台图表
    init_myChart7() {
      this.myChart7 = this.$echarts.init(document.getElementById("echart7"));
    },
    get_myChart7Data(){
      this.updata_myChart7()
    },
    updata_myChart7(){
      var option = {
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "line",
            z: -1,
            lineStyle: {
              type: "soild",
              width: 30,
              color: "#2f89cf",
            },
          },
        },
        grid: {
          width: "100%",
          height: "58%",
          bottom: "27%",
          left: "0%",
        },
        xAxis: {
          type: "category",
          data: this.area,
          axisLabel: {
            fontSize:9,
            inside: false,
            color: "#fff",
            interval:0,
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
            barWidth: 30,
            label: {
              show: true,
              position: "top",
              color: "white",
            },
            itemStyle: {
              color: "#4cb9cf",
              barBorderRadius: [5, 5, 0, 0],
            },
            emphasis: {
              itemStyle: {},
            },
            data: this.areatotal,
          },
        ],
      };
      //使用刚指定的配置项和数据显示图标
      option &&this.myChart7.setOption(option);
    },

    //参政议政图表
    get_8Data(){
    },
    get_9Data(){
    },
    init_myChart10() {
      let data =this.countList;
      let dataAxis = this.yearList;
      var myChart10 = this.$echarts.init(document.getElementById("echart10"));
      var option = {
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "line",
            z: -1,
            lineStyle: {
              type: "soild",
              width: 30,
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
            barWidth: 30,
            label: {
              show: true,
              position: "top",
              color: "white",
            },
            itemStyle: {
              color: "#37A2FF",
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
      option && myChart10.setOption(option);
      window.addEventListener("resize", function () {
        myChart10.resize();
      });
    },

      //对点击单一的学院的数据进行处理
    doCallDepartmentData(department) {
      callDepartment(department).then(res => {
        let result = res
        this.workArr=[],
        this.workObejct=result.res1.t
        for (let i in this.workObejct){
        this.workArr.push(this.workObejct[i])
      }
        this.get_myChart1Data()
        this.nonPartyInfo = result.res2.t
        this.sum2 = result.res2.t[3]?.total
        this.get_myChart2Data()
        this.parties = result.res3.t.parties
        this.memberShip = result.res3.t.memberShip
        this.sum3 = result.res3.t.count
        this.get_myChart3Data()
        this.nonmemberShip = result.res4.t
        this.sum4 = result.res4.t[3]?.count
        this.get_myChart4Data()
        this.nationalShip = result.res5.t
        this.sum5 = result.res5.t[this.nationalShip.length-1]?.total
        this.get_myChart5Data()
        /*this.area = result.res6.t.area
        this.areatotal = result.res6.t.total
        this.sum7 =result.res6.t.count[0]
        this.get_myChart7Data()*/
        this.liangDaiBiao = result.res7.t
        this.get_8Data()
      })    
    }
  },

    mounted() {
    this.init_myChart1();
    this.init_myChart2();
    this.init_myChart3();
    this.init_myChart4();
    this.init_myChart5();
    //this.init_myChart7();
    this.init_myChart10();
  
      callAll().then(res => {
      let result = res
      //图表1--统战工作对象
      this.workObejct = result.res1.t   
      for (let i in this.workObejct){
        this.workArr.push(this.workObejct[i])
      }
      this.get_myChart1Data()
      //图表2--党外干部
      this.nonPartyInfo = result.res2.t
      this.sum2 = result.res2.t[3]?.total
      this.get_myChart2Data()
      //图表3--民主党派
      this.parties = result.res3.t.parties
      this.memberShip = result.res3.t.memberShip
      this.sum3 = result.res3.t.count
      this.get_myChart3Data()
      //图表4--无党派
      this.nonmemberShip = result.res4.t
      this.sum4 = result.res4.t[3]?.total
      this.get_myChart4Data()
      //图表5--少数民族 
      this.nationalShip = result.res5.t
      this.sum5 = result.res5.t[this.nationalShip.length-1]?.total
      this.get_myChart5Data()
      //图表6--港澳台
      /*this.area = result.res6.t.area
      this.areatotal = result.res6.t.total
      this.sum7 =result.res6.t.count[0]
      this.get_myChart7Data()*/
      //图表7--两代表
      this.liangDaiBiao = result.res7.t
      this.sum8=this.liangDaiBiao.count[0]
      this.npcCount = this.liangDaiBiao.count[1]
      this.mpcCount = this.liangDaiBiao.count[2]
      this.PcpccCount = this.liangDaiBiao.count[3]
      this.McpccCount = this.liangDaiBiao.count[4]
      this.npc = this.liangDaiBiao.全国人大代表
      for(var i=0;i<this.npcCount;i++){
        this.npcArr += this.npc[i]+' ';
      }
      this.mpc = this.liangDaiBiao.市人大代表
      for(var i=0;i<this.mpcCount;i++){
        this.mpcArr += this.mpc[i]+' ';
      }
      this.Pcpcc = this.liangDaiBiao.省政协委员
      for(var i=0;i<this.PcpccCount;i++){
        this.PcpccArr += this.Pcpcc[i]+' ';
      }
      this.Mcpcc = this.liangDaiBiao.市政协委员
      for(var i=0;i<this.McpccCount;i++){
        this.McpccArr += this.Mcpcc[i]+' ';
      }
      this.get_8Data()
      //--图表8--获奖情况
      this.AwardProvincialLevel = result.res8.t.AwardProvincialLevel
      this.AwardCountryLevel = result.res8.t.AwardCountryLevel
      this.sum9 = result.res8.t.count?.[0]
      this.get_9Data()
      //图表9--参政议政
      this.countList = result.res9.t.countList
      this.yearList = result.res9.t.yearList
      this.sum10 = result.res9.t.count?.[0]
    })


    this.$bus.$on("wenxue", this.doCallDepartmentData)      //文学与新闻传播学院党委
    this.$bus.$on("shiping",this.doCallDepartmentData)      //食品科技学院党委
    this.$bus.$on("qixiang",this.doCallDepartmentData)      //海洋与气象学院党委
    this.$bus.$on("houqin", this.doCallDepartmentData)      //后勤与产业党委
    this.$bus.$on("jixie",  this.doCallDepartmentData)      //机械工程学院党委
    this.$bus.$on("guanli", this.doCallDepartmentData)      //管理学院党委
    this.$bus.$on("makesi", this.doCallDepartmentData)      //马克思主义学院党委
    this.$bus.$on("jingji", this.doCallDepartmentData)      //经济学院党委 
    this.$bus.$on("nengyuan",this.doCallDepartmentData)     //海洋工程与能源学院党委
    this.$bus.$on("jisuanji",this.doCallDepartmentData)     //数学与计算机学院党委
    this.$bus.$on("dianzi",this.doCallDepartmentData)       //电子与信息工程学院党委
    this.$bus.$on("huaxue", this.doCallDepartmentData)      //化学与环境学院党委
    this.$bus.$on("nongye", this.doCallDepartmentData)      //滨海农业学院党委
    this.$bus.$on("shuichan",this.doCallDepartmentData)     //水产学院党委
    this.$bus.$on("fazhen", this.doCallDepartmentData)      //法政学院党委
    this.$bus.$on("waiguoyu",this.doCallDepartmentData)     //外国语学院党委
    this.$bus.$on("zhongge",this.doCallDepartmentData)      //中歌艺术学院党委
    this.$bus.$on("tiyu",this.doCallDepartmentData)         //体育与休闲学院党委
    this.$bus.$on("jiguan",this.doCallDepartmentData)       //机关党委
    this.$bus.$on("tuixiu",this.doCallDepartmentData)       //离退休干部党委
    this.$bus.$on("jiaofu", this.doCallDepartmentData)      //教辅单位党委
    this.$bus.$on("haiyun", this.doCallDepartmentData)      //船舶与海运学院党委
    this.$bus.$on("yangjiang", this.doCallDepartmentData)      //阳江校区党委
  },
  beforeDestroy () {
  this.myChart1.clear()
  this.myChart2.clear()
  this.myChart3.clear()
  this.myChart4.clear()
  this.myChart5.clear()
  this.myChart7.clear()
  this.myChart8.clear()
  this.myChart9.clear()
  this.myChart10.clear()
  }

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
  font-family: "微软雅黑";
  color: #fff;
}

body {
  font-size: 16px;
  background-size: 100% 200%;
}

html,
body {
  height: 100%;
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

.clearfix:after,
.clearfix:before {
  display: table;
  content: " ";
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

/*  */
.mainbox {
  padding: 0px 10px;
}

.nav1 {
  margin-left: -6px;
  margin-right: -6px;
}

.nav1>li {
  padding: 0 6px;
  float: left;
}

.box {
  border: 1px solid rgba(7, 118, 181, 0.5);
  box-shadow: inset 0 0 10px rgba(7, 118, 181, 0.4);
  margin-bottom: 12px;
  position: relative;
}

.minibox {
  margin-bottom: 6px;
  position: relative;
}

.color1 {
  border: 1px solid rgba(159, 213, 9, 0.5);
  box-shadow: inset 0 0 10px rgba(159, 213, 9, 0.4);
}

.color2 {
  border: 1px solid rgba(9, 213, 189, 0.5);
  box-shadow: inset 0 0 10px rgba(9, 213, 189, 0.4);
}

.color3 {
  border: 1px solid rgba(213, 101, 9, 0.5);
  box-shadow: inset 0 0 10px rgba(213, 101, 9, 0.4);
}

.color4 {
  border: 1px solid rgba(9, 213, 40, 0.5);
  box-shadow: inset 0 0 10px rgba(9, 213, 40, 0.4);
}

.tit {
  padding: 10px 10px 10px 25px;
  border-bottom: 1px solid rgba(7, 118, 181, 0.7);
  font-size: 16px;
  font-weight: 500;
  position: relative;
}

.tit:before {
  position: absolute;
  content: "";
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
  content: "";
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

.mapc {
  background: url(../assets/img/bg3.png) no-repeat center center;
  background-size: 100% 100%;
}

.map {
  position: relative;
  height: 100%;
}

.content {
 /* background: url(../assets/img/地图界面.gif) no-repeat center center;
  background-size: cover;
  */
  background-color:  rgba(106, 86, 86, 0.727)
}
</style>
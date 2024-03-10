<template>
  <div class="mainbox content">
    <ul class="clearfix nav1">
      <li style="width: 18%">
        <div class="box" >
          <div class="tit">成员数量(总数:{{numberCount}})</div>
          <div class="boxnav" style="height: 170px;">
            <div style="height: 170px" ref="number"></div>
          </div>
        </div>
        <div class="box" >
          <div class="tit">年龄分布</div>
          <div class="boxnav" style="height: 170px;">
            <div style="height: 170px" ref="age" id="age"></div>
          </div>
        </div>
        <div class="box" >
          <div class="tit">学历分布</div>
          <div class="boxnav" style="height: 170px;">
            <div style="height: 170px" ref="edu"></div>
          </div>
        </div>
      </li>
      <li style="width: 18%">
        <div class="box">
          <div class="tit">新发展成员数量(总数:{{newNumCount}})</div>
          <div class="boxnav" style="height: 170px;">
            <div style="height: 170px;width:100%" ref="newMember"></div>
          </div>
        </div>
        <div class="box">
          <div class="tit">性别分布</div>
          <div class="boxnav" style="height: 170px;">
            <div  style="height: 170px;width:100%" ref="sex"></div>
          </div>
        </div>
        <div class="box">
          <div class="tit">职称分布</div>
          <div class="boxnav" style="height: 170px;">
            <div  style="height: 170px;width:100%" ref="job"></div>
          </div>
        </div>
        
      </li>
      <li style="width: 42%">
        <div class="box">
          <!--855px-->
          <div class="boxnav mapc" style="height:648px; position: relative">
            <!-- 放置地图 -->
             <div class="map" id="map">
              <SchoolMap/>
             </div>
          </div>
        </div>
      </li>
      <li style="width: 22%">
        <div class="box">
          <div class="tit">各学院人员数量</div>
          <div class="boxnav" style="height: 285px;">
          <div class="boxnav" ref="merbers" style="height: 285px;"></div>
          </div>
        </div>
        <div class="box">
          <div class="tit">参政议政</div>
          <div class="boxnav" style="height: 275px;">
          <div class="boxnav" ref="politics" style="height: 275px;">
          </div>
          </div>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
import {callAll,callDepartment} from "../api/college/democrat"
import SchoolMap from './schoolMap.vue';
export default {
  name: "Democrate",
  data() {
    return {
      //成员数量echart变量
      numberEchartInstance: null,
      numberEchartData: [],
      numberCount: 0,
      numberFlag:true,
      

      //年龄分布echart变量
      ageEchartInstance: null,
      ageEchartData: [],
      ageCount: 0,
      ageFlag:true,

      //学历分布echart变量
      eduEchartInstance: null,
      eduEchartData:[],
      arr: [],
      eduFlag:true,
      eduCount:0,
      
      //性别分布echart变量
      sexEchartInstance: null,
      sexEchartData: [],
      sexCount:0,
      sexFlag: true,
      
      //新发展成员echart变量
      newNumEchartInstance: null,
      newNumEchartData: [],
      newNumCount: 0,
      newNumFlag:true,

      //职称分布echart变量
      jobEcharInstance: null,
      jobEcharData: [],
      jobCount: 0,
      jobFlag:true,

      //各学院人员分布echart变量
      merbersEchartInstance: null,
      merbersEchartData: [],
      currentMerbersPage: 1,
      totoalMerbersPage: 0,
      timeMerbersID: null,
      merbersCount:0,

      //参政议政分布echart变量
      politicsEchartInstance: null,
      politicsEchartData: [],
      polCount:0
    };
  },
  //initxxxChat为初始化xxxechart实例对象
  //getxxxData对获取到的数据进行处理
  //updataxxxChar为更新xxx图标
  watch: {
    numberEchartData: {
      deep: true,
      handler(newVal, oldVal) {
        this.initNumberChar()      
      }
    },
    ageEchartData: {
      deep: true,
      handler(newVal, oldVal) {
        this.initAgeChar()
      }
    },
    eduEchartData: {
      deep: true,
      handler(newVal, oldVal) {
        this.initEduChar()
      }
    },
    sexEchartData: {
      deep: true,
      handler(newVal, oldVal) {
        this.initSexChar()
      }
    },
    newNumEchartData: {
      deep: true,
      handler(newVal, oldVal) {
        this.initNewNumChar()
      }
    },
    jobEcharData: {
      deep: true,
      handler(newVal, oldVal) {
        this.initJobChar()
      }
    },
    politicsEchartData: {
      deep: true,
      handler(newVal, oldVal) {
        this.initPolChat()
      }
    },
    merbersEchartData: {
      deep: true,
      handler(newValue, oldValue) {
        this.initMerbersChar()
      }
    }
  },
  methods: {
    //成员数量echart方法
    initNumberChar() {
      this.numberEchartInstance = this.$echarts.init(this.$refs.number)
    },
    getNumberData() {
      if (this.numberFlag) {
        this.numberEchartData.memberShip.forEach(item => {
        item=parseInt(item)
        this.numberCount += item
        })
        this.numberFlag=false
      }
      this.updataNumberChar()
    },
    updataNumberChar() {      
      const option = {
        textStyle: {
          color: "white"
        },
        tooltip: {
          trigger: "axis"
        },
        xAxis: {
          type: "category",
          axisTick: { show: false },
          axisLabel: { interval: 0 },
          data: this.numberEchartData.parties
        },
        yAxis: {
          type: "value",
          splitLine: { show: false },
          axisLabel: { show: false }
        },
        series: {
          type: "bar",
          data: this.numberEchartData.memberShip,
          itemStyle: {
            normal: {
              color: new this.$echarts.graphic.LinearGradient(0, 1, 0, 0, [{
                offset: 0,
                color: "#eecbf0" // 0% 处的颜色
              }, {
                offset: 0.6,
                color: "#d3d8f6" // 60% 处的颜色
              }, {
                offset: 1,
                color: "#bce6fc" // 100% 处的颜色
              }]),
              barBorderRadius: [5, 5, 0, 0]
            },
            
          }
        },
        grid: {
          x: -6,
          y: 40,
          x2: 7,
          y2: 40
        },
        label: {
          show: true,
          position: "top",
          color: "white"
        },
      }
      this.numberEchartInstance.setOption(option)
    },

    //年龄分布echart方法
    initAgeChar() {
      this.ageEchartInstance = this.$echarts.init(this.$refs.age)
    },
    getAgeData() {
      if (this.ageFlag) {
        Object.values(this.ageEchartData).forEach(item => {
          this.ageCount+=item
        });
        this.ageFlag=false
      }
      this.updataAgeChar()
    },
    updataAgeChar() {   
      const option = {
        textStyle: {
          color: "white"
        },
        tooltip: {
          trigger: "axis"
        },
        xAxis: {
          type: "value",
          splitLine: { show: false },
          axisLabel: { show: false },
        },
        yAxis: {
          type: "category",
          data: ["35岁及以下", "35-45岁", "45-50岁", "55岁及以上"],
          axisLabel: {
            // inside: true,
            color: "#fff",
            // margin:0
          },
          axisTick: { show: false },
          axisLine: { show: false },
          z: 10
        },
        series: {
          type: "bar",
          data: [this.ageEchartData["age<=35"], this.ageEchartData["35<=age<=45"], this.ageEchartData["45<=age<=50"],this.ageEchartData["age>55"]],
          right: 70,
          itemStyle: {
            barWidth:"60%",
            normal: {
              color: new this.$echarts.graphic.LinearGradient(0, 0, 1, 0, [
                { offset: 0, color: "#3d85c6" },
                { offset: 0.5, color: "#83cbe6" },
                { offset: 1, color: "#8ddae2" },]),
              barBorderRadius: [0, 5, 5, 0]
            },
          }
        },
        label: {
          show: true,
          position: "right",
          color: "white"
        },
        grid: {
          show: false,
          x: 70,
          y: 10,
          x2: 20,
          y2: 20
        },
        color: "#2378f7"
      }
      this.ageEchartInstance.setOption(option)
    },

    //学历分布echart方法
    initEduChar() {
      this.eduEchartInstance = this.$echarts.init(this.$refs.edu)
    },
    getEduData() {
      this.arr = this.eduEchartData
        this.eduEchartData = []
        this.arr.map(item => {
          let _item = JSON.parse(JSON.stringify(item).replace('degree', 'name').replace('total', 'value'))
          this.eduEchartData.push(_item)
        })
        if (this.eduFlag) {
          this.eduEchartData.forEach(item => {
          this.eduCount+=item.value
          })
          this.eduFlag=false
        }
        this.updataEduChar()
    },
    updataEduChar() {
      const option= {
        tooltip: {
          trriger: "item",
        },
        series: {
          type: "pie",
          data: this.eduEchartData,
          radius: ["60%", "70%"],
          itemStyle: {
            normal: {
              label: { show: false },
              labelLine: { show: false }
            }
          },
          center: ["70%", "50%"]
        },
        legend: {           //这里就不处理，按照接口返回数组来
          data: ["博士", "硕士", "本科", "其他"],
          orient: "vertical",
          x: 5,
          y: 5,
          textStyle: {
            color: "#fff"
          }
        },
      }
      this.eduEchartInstance.setOption(option)
    },

    //新发展成员echart方法
    initNewNumChar() {
      this.newNumEchartInstance = this.$echarts.init(this.$refs.newMember)
    },
    getNewNumData() {
      this.updataNewNumChar()
      if (this.newNumFlag) {
        this.newNumEchartData.increaseCount.forEach(item => {
        item=parseInt(item)
        this.newNumCount += item
        })
        this.newNumFlag=false
      }
    },
    updataNewNumChar() {
      const option = {
        textStyle: {
          color: "white"
        },
        tooltip: {
          trigger: "axis"
        },
        xAxis: {
          type: "category",
          axisTick: { show: false },
          data: this.newNumEchartData.parties,
          axisLabel: { interval: 0 },
        },
        yAxis: {
          type: "value",
          splitLine: { show: false },
          axisLabel: { show: false }
        },
        series: {
          type: "bar",
          data: this.newNumEchartData.increaseCount,
          legendHoverLink: true,
          itemStyle: {
            normal: {
              color: new this.$echarts.graphic.LinearGradient(0, 1, 0, 0, [
                { offset: 0, color: "#a4c2f4" },
                { offset: 0.6, color: "#9fc5e8" },
                { offset: 1, color: "#83bff6" }
              ]),
              barBorderRadius: [5, 5, 0, 0]
            },
          }
        },
        grid: {
          x: -6,
          y: 40,
          x2: 7,
          y2: 40
        },
        label: {
          show: true,
          position: "top",
          color: "white"
        },
      }
      this.newNumEchartInstance.setOption(option)
    },

    //性别分布echart方法
    initSexChar() {
      this.sexEchartInstance = this.$echarts.init(this.$refs.sex)
    },
    getSexData() {
      this.updataSexChar()
      if (this.sexFlag) {
        this.sexCount=this.sexEchartData[1].total+this.sexEchartData[0].total 
        this.sexFlag=false
      }
    },
    updataSexChar() {
      const option = {
        tooltip: {
          trriger: "item",
        },
        series: {
          type: "pie",
          data: [
            { name: this.sexEchartData[1].sex, value: this.sexEchartData[1].total },
            { name: this.sexEchartData[0].sex, value: this.sexEchartData[0].total }],
          radius: ["60%", "70%"],
          itemStyle: {
            normal: {
              label: {
                show: false //隐藏标示文字
              },
              labelLine: {
                show: false //隐藏标示线
              }
            }
          },
          center: ["60%", "50%"]
        },
        legend: {
          data: [this.sexEchartData[1].sex, this.sexEchartData[0].sex],
          // orient: "vertical",
          x: 0,
          y: 0,
          textStyle: {
            color: "#fff"
          }
        },
        color: ["#6b76dd", "#f4cccc"]
      }
      this.sexEchartInstance.setOption(option)
    },

    //职称分布echart方法
    initJobChar() { 
      this.jobEcharInstance = this.$echarts.init(this.$refs.job)
    },
    getJobData() { 
      if (this.jobFlag) {
          this.jobEcharData.forEach((item) => {
          this.jobCount+=item.count
          })
        this.jobFlag=false   
      }
      this.updataJobChar()
    },
    updataJobChar() { 
        let level = []
        let count = []
        this.jobEcharData.forEach((item) => {
          level.unshift(item.LEVEL);
          count.unshift(item.count)
        })
      const option = {
        textStyle: {
          color: "white"
        },
        tooltip: {
          trigger: "axis"
        },
        xAxis: {
          type: "value",
          splitLine: { show: false },
          axisLabel: { show: false },      
        },
        yAxis: {
          type: "category",
          data:level,
          axisTick: { show: false },  
          axisLabel: {
            color: "#fff",
          },
          z:10
        },
        series: {
          type: "bar",
          data: count,
          itemStyle: {
            normal: {
              color: new this.$echarts.graphic.LinearGradient(0, 0, 1, 0, [
                {
                  offset: 0,
                  color: "#2378f7", // 0% 处的颜色
                },
                {
                  offset: 0.6,
                  color: "#2378f7", // 60% 处的颜色
                },
                {
                  offset: 1,
                  color: "#83bff6", // 100% 处的颜色
                },]),
              barBorderRadius: [0, 5, 5, 0]
            },
          }
        },
        label: {
          show: true,
          position: "right",
          color: "white"
        },
        grid: {
          show: false,
          x: 50,
          y: 20,
          x2: 20,
          y2: 20
        }
      }
      this.jobEcharInstance.setOption(option)
    },

    //各学院人员分布echart方法
    initMerbersChar() { 
      this.merbersEchartInstance = this.$echarts.init(this.$refs.merbers)
      this.merbersEchartInstance.on('mouseover', () => {
        clearInterval(this.timeMerbersID)
      })
      this.merbersEchartInstance.on('mouseout', () => {
        this.startMerbersInterval()
      })
    },
    getMerbersData() {
      this.updataMerbersChar()
      this.startMerbersInterval()
      this.merbersEchartData.forEach(item => {
        this.merbersCount+=Object.values(item)[0]
      })
    },
    updataMerbersChar() {
      //制作轮播图
      const merbersTitle = this.merbersEchartData.map(item =>item.department)
      const merbersTotal = this.merbersEchartData.map(item => item.count)
      this.totoalMerbersPage = this.merbersEchartData.length %8  === 0 ? this.merbersEchartData.length / 8 : this.merbersEchartData.length / 8 + 1;
      const start = (this.currentMerbersPage - 1) * 8
      const end = this.currentMerbersPage * 8
      const showmerbersTotal = merbersTotal.slice(start, end)
      const showmerbersTitle = merbersTitle.slice(start, end)
      const option = {
        textStyle: {
          color: "white"
        },
        tooltip: {
          trigger: "axis"
        },
        xAxis: {
          type: "value",
          splitLine: { show: false },
          axisLabel: { show: false },      
        },
        yAxis: {
          type: "category",
          data:showmerbersTitle,
          axisTick: { show: false },  
          axisLabel: {
            // inside: true,
            color: "#fff",
          },
          z:10
        },
        series: {
          type: "bar",
          data: showmerbersTotal,
          itemStyle: {
            normal: {
              color: new this.$echarts.graphic.LinearGradient(0, 0, 1, 0, [
                {
                  offset: 0,
                  color: "#2378f7", // 0% 处的颜色
                },
                {
                  offset: 0.6,
                  color: "#2378f7", // 60% 处的颜色
                },
                {
                  offset: 1,
                  color: "#83bff6", // 100% 处的颜色
                },]),
              barBorderRadius: [0, 5, 5, 0]
            },
          }
        },
        label: {
          show: true,
          position: "right",
          color: "white"
        },
        grid: {
          show: false,
          x: 140,
          y: 0,
          x2: 20,
          y2: 0
        }
      }
      this.merbersEchartInstance.setOption(option)
    },
    startMerbersInterval() {
      if (this.timeMerbersID) {
        clearInterval(this.timeMerbersID)
      }
      this.timeMerbersID = setInterval(() => {
        this.currentMerbersPage++
          if (this.currentMerbersPage > this.totoalMerbersPage) {
            this.currentMerbersPage = 1
          }
          this.updataMerbersChar()
      }, 4000)
    },

    //参政议政分布echart方法
    initPolChat() {
      this.politicsEchartInstance=this.$echarts.init(this.$refs.politics)
    },
    getPolData() {
      this.updataPolChar()
    },
    updataPolChar() {
      // 参政议政人员总数求和
      Object.values(this.politicsEchartData).forEach(item => {
        item.forEach(val => {
          if (val < 2000) {  //去掉年份
            this.polCount+=val
          }
        })
      })

      const option =  {
        textStyle: {
          color: "white"
        },
        grid: {
          x: 10,
          y: 60,
          x2: 10,
          y2: 25
        },
        xAxis: {
          type: "category",
          axisTick: { show: false },
          data: this.politicsEchartData['年份']
        },
        yAxis: {
          type: "value",
          splitLine: {
            show: false
          },
          axisLabel: {
            show: false
          }
        },
        series: [{
          name: "民革",
          type: "bar",
          barGap: 0,
          emphasis: {
            focus: "series"
          },
          itemStyle: {
            normal: {
              barBorderRadius: [5, 5, 0, 0]
            },
          },
          data: this.politicsEchartData['民革']
        }, {
          name: "民盟",
          type: "bar",
          barGap: 0,
          emphasis: {
            focus: "series"
          },
          itemStyle: {
            normal: {
              barBorderRadius: [5, 5, 0, 0]
            },
          },
          data: this.politicsEchartData['民盟']
        }, {
          name: "民建",
          type: "bar",
          barGap: 0,
          emphasis: {
            focus: "series"
          },
          itemStyle: {
            normal: {
              barBorderRadius: [5, 5, 0, 0]
            },
          },
          data: this.politicsEchartData['民建']
        }, {
          name: "民进",
          type: "bar",
          barGap: 0,
          emphasis: {
            focus: "series"
          },
          itemStyle: {
            normal: {
              barBorderRadius: [5, 5, 0, 0]
            },
          },
          data: this.politicsEchartData['民进']
        }, {
          name: "农工",
          type: "bar",
          barGap: 0,
          emphasis: {
            focus: "series"
          },
          itemStyle: {
            normal: {
              barBorderRadius: [5, 5, 0, 0]
            },
          },
          data:this.politicsEchartData['农工']
        }, {
          name: "致公",
          type: "bar",
          barGap: 0,
          emphasis: {
            focus: "series"
          },
          itemStyle: {
            normal: {
              barBorderRadius: [5, 5, 0, 0]
            },
          },
          data: this.politicsEchartData['致公']
        }, {
          name: "九三学社",
          type: "bar",
          barGap: 0,
          emphasis: {
            focus: "series"
          },
          itemStyle: {
            normal: {
              barBorderRadius: [5, 5, 0, 0]
            },
          },
          data: this.politicsEchartData['九三学社']
        }],
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "shadow"
          },
        },
        legend: {
          data: ["民革", "民盟", "民建", "民进", "农工", "致公", "九三学社"],
          icon: "circle",
          itemGap: 20,
          textStyle: {
            color: "white"
          },
          top: 0
        },
        label: {
          show: true,
          position: "top",
          color: "white"
        },
      }
      this.politicsEchartInstance.setOption(option)
    },

    //对点击单一的学院的数据进行处理
    doCallDepartmentData(department) {
      callDepartment(department).then(res => {
        let result = res
        this.numberEchartData = result.res1.t
        this.getNumberData()
        this.ageEchartData = result.res2.t
        this.getAgeData()
        this.eduEchartData = result.res3.t
        this.getEduData()
        this.newNumEchartData = result.res4.t
        this.getNewNumData()
        this.sexEchartData = result.res5.t
        this.getSexData()
        this.jobEcharData = result.res6.t
        this.getJobData()
      })    
    },
    //页面挂载所有echarts图
    callAllEchart() {
      callAll().then(res => {
      let result = res
      this.numberEchartData = result.res1.t
      this.getNumberData()
      this.ageEchartData = result.res2.t
      this.getAgeData()
      this.eduEchartData = result.res3.t
      this.getEduData()
      this.newNumEchartData = result.res4.t
      this.getNewNumData()
      this.sexEchartData = result.res5.t
      this.getSexData()
      this.jobEcharData = result.res6.t
      this.getJobData()
      this.politicsEchartData = result.res7.t
      this.getPolData()
      this.merbersEchartData = result.res8.t
      this.getMerbersData()
      }).catch(error => {
      console.log(error.message);
    })
    }
  },
  mounted() {
    this.initNumberChar()    //成员列表echart
    this.initAgeChar()       //年龄分布echart
    this.initEduChar()       //学历分布echart
    this.initNewNumChar()    //新发展成员echart
    this.initSexChar()       //性别分布echart
    this.initJobChar()         //职称分布echart
    this.initMerbersChar()     //各学院人员数量echart
    this.initPolChat()         //参政议政echart
    this.initMerbersChar()     //各学院人员数量echart
    this.callAllEchart()       //页面挂载所有echarts图
    
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
  },
  beforeDestroyed(){
    clearInterval(this.timeMerbersID)
},
  components: { SchoolMap },
}

</script>

<style scoped>
* {
    box-sizing: border-box
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
    outline: none!important;
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
    margin: 0
}

a:hover {
    color: #06c;
    text-decoration: none!important
}

.clearfix:after,
.clearfix:before {
    display: table;
    content: " "
}

.clearfix:after {
    clear: both
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
    color: #ffe400
}

.text-d {
    color: #ff6316
}

.text-s {
    color: #14e144
}

.text-b {
    color: #07e5ff
}
/*  */
  .mainbox{
    padding: 0px 10px;
}

  .nav1{
    margin-left: -6px;
    margin-right:-6px;
}

  .nav1>li{
    padding:0 6px;
    float: left;
}

  .clearfix:after,
  .clearfix:before{
    display: table;
    content: " "
}

  .clearfix:after {
    clear: both
}

  .box{ 
    border:1px solid rgba(7,118,181,.5);
    box-shadow:inset 0 0 10px rgba(7,118,181,.4);
    margin-bottom: 12px;
    position: relative;
}

  .box:before{
    top: -1px;
}

  .tit{
    padding: 10px 10px 10px 25px;
    border-bottom:1px solid rgba(7,118,181,.7);
    font-size: 16px;
    font-weight: 500;
    position: relative;
}

  .tit:before,
  .tit01:before{
    position: absolute;
    content: "";
    width: 6px;
    height: 6px;
    background: rgba(22,214,255,.9);
    box-shadow: 0 0 5px rgba(22,214,255,.9);
    border-radius: 10px; left: 10px; top: 18px;
}

  .boxnav{
    padding: 10px;
}

  .mapc{
    background: url(../assets/img/bg3.png) no-repeat center center; 
    background-size: 100% 100%
}

.map {
  position: relative;
  height: 100%;
}
.content{
    background: url(../assets/img/地图界面.gif) no-repeat center center;
  /* background: url(../assets/img/大数据界面2.gif) no-repeat center center; */

    background-size: cover;
}


</style>
<template>
  <adapter>
    <div class="mainbox content">
      <ul class="clearfix nav1">
        <li style="width: 24%">
          <div class="box">
            <div class="tit">
              人员检索
              <el-input clearable style="width:85%" v-model="searchMsg" @focus="blurSearchFor()" @blur="blurSear" :placeholder="placeholder" @keyup.native.enter="searchPersonList(searchMsg)"></el-input>
              <el-button size="medium" icon="el-icon-search" @click="searchPersonList(searchMsg)"></el-button>
            </div>
            <div class="boxnav" style="height: 565px">
              <el-scrollbar wrap-class="scrollbar-wrapper">
                <el-menu default-active="2" class="el-menu-vertical-demo"
                  :unique-opened="false">
                  <el-submenu index="1">
                    <template slot="title">
                      <span>人员检索结果</span>
                    </template>
                    <el-menu-item-group>
                      <el-menu-item v-for="(item) in this.searchList" :key="item.id" @click="getInformationList(item.id)">{{item.name}}</el-menu-item>
                    </el-menu-item-group>
                  </el-submenu>
                  <el-submenu index="2">
                    <template slot="title">
                      <span>民主党派成员</span>
                    </template>
                    <el-menu-item-group>
                      <el-menu-item v-for="(item) in this.partyList" :key="item.id" @click="getInformationList(item.id)">{{item.name}}</el-menu-item>
                    </el-menu-item-group>
                  </el-submenu>
                  <el-submenu index="3">
                    <template slot="title">
                      <span>无党派人士</span>
                    </template>
                    <el-menu-item-group>
                      <el-menu-item v-for="(item) in this.nonPartyList" :key="item.id" @click="getInformationList(item.id)">{{item.name}}</el-menu-item>
                    </el-menu-item-group>
                  </el-submenu>
                </el-menu>
              </el-scrollbar>
            </div>
          </div>
        </li>
        <li style="width: 76%">
          <div class="box">
            <div class="boxnav mapc" style="height: 648px; position: relative">
              <div class="map" id="map">
                <!--人物照片和个人信息展示-->
                <div class="box personInformation">
                  <div class="person">
                    <img style="height:125px;width:125px" :src=" info.imgUrl"/>
                  </div>
                  <ul class="information">
                    <li>姓名:{{info.name }}</li>
                    <li>性别：{{info.sex }}</li>
                    <li>民族：{{info.nation }}</li>
                    <li>出生年月：{{info.birth }}</li>
                    <li>籍贯：{{info.naticePlace }}</li>
                    <li>政治面貌：{{info.party}}</li>
                    <li>党派职务：{{info.partyPosition }}</li>
                    <li>岗位职务：{{info.title }}</li>
                  </ul>
                </div>
                <!--获奖次数展示-->
                <ul class="block">
                  <li class="minibox color1">
                    <span>培训次数</span>
                    <p>{{ info.trainingTimes }}</p>
                  </li>
                  <li class="minibox color3">
                    <span>参政议政次数</span>
                    <p>{{ info.politicalParticipationTimes }}</p>
                  </li>
                  <li class="minibox color2">
                    <span>获奖次数</span>
                    <p>{{ info.priceNumber }}</p>
                  </li>
                </ul>
                <!--成长轨迹-->
                <div class="track">
                  <h4>成长轨迹</h4>
                  <div class="appointment">
                    <h3>任职轴</h3>
                    <el-divider></el-divider>
                    <div class="middlebox color5">{{ info.positionAxis }}</div>
                  </div>
                  <div class="activity">
                    <h3>活动轴</h3>
                    <el-divider></el-divider>
                    <div class="middlebox color5">{{ info.activeAxis }}</div>
                  </div>
                  <div class="award">
                    <h3>获奖轴</h3>
                    <el-divider></el-divider>
                    <div class="middlebox color5">{{ info.awardAxis }}</div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </li>
      </ul>
    </div>
  </adapter>
</template>

<script>
import { post} from 'http';
import axios from 'axios';

export default {
  name: "portrait",
  data() {
    return {
      input: "",
      placeholder: "请输入成员姓名",
      fit:"contain",
      info:{
      imgUrl: "",
      name: "",
      sex: "",
      nation: "",
      birth: "",
      naticePlace: "",
      partyPosition: "",
      party: "",
      title: "",
      socialPosition: "",
      trainingTimes: '',
      politicalParticipationTimes: '',
      priceNumber: '',
      awardAxis:'',
      activeAxis:'',
      positionAxis:'',
      },
      searchMsg:'',
      searchList:[],
      partyList:[],
      nonPartyList:[]
    };
  },
  methods: {
    /* handleOpen(key, keyPath) {
       console.log(key, keyPath);
     },
     handleClose(key, keyPath) {
       console.log(key, keyPath);
     },*/

    //获取焦点时触发
    blurSearchFor() {
      if (this.placeholder == "请输入成员姓名") {
        this.placeholder = "";
      }
    },
    //失去焦点时触发
    blurSear() {
      this.placeholder = "请输入成员姓名";
    },

  //获取民主党派人员列表
   getPartyList(){
     axios
     .post("http://localhost:9107/service/servicedecisioncenter/portrain/queryDemocraticParties")
     .then((res)=>{
        //console.log(res)
       this.partyList = res.data.t
     })
    /*let result1 = await this.$API.Portrait.getDemocraticParties()
      console.log("result1:",result1)
      if(result1.ok == true){
        this.partyList =result1.t
        //console.log(this.partyList)
      }*/
    },

  //获取无党派人士人员列表
   getNonPartyList(){
    axios
     .post("http://localhost:9107/service/servicedecisioncenter/portrain/queryNonPartisan")
     .then((res)=>{
       //console.log(res)
       this.nonPartyList = res.data.t
     })
    /*let result2 = await this.$API.Portrait.getNonPartisan() 
        console.log("result2:",result2)
    if(result2.ok == true){
      this.nonPartyList = result.t
      console.log(this.nonPartyList)
    }*/
  },

  //点击展示人员信息
   getInformationList(id){
    axios
     .post(
        "http://localhost:9107/service/servicedecisioncenter/portrain/queryPeopleInfoByid",
        {
          id
        }
      )
     .then((res)=>{
       this.info= res.data.t
     })
    /*let result3 = await this.$API.Portrait.getInformation(id)
    console.log("result3:",result3)*/
  },

  //搜查查询人员
  searchPersonList(name){
    axios
      .get(
        'http://localhost:9107/service/servicedecisioncenter/portrain/fuzzyQueryByName',{
        params:{
          name
        }
  })
      .then((res)=>{
        console.log(res)
        this.searchList = res.data.t
      })
  }
  },

  mounted(){
    this.getPartyList(),
    this.getNonPartyList()
  }
};
</script >

<style scoped>
* {
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
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
  color: #fff;
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
  margin: 0
}

a:hover {
  color: #06c;
  text-decoration: none !important
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
  background-color: rgba(159, 213, 9, 0.25);
}

.color2 {
  border: 1px solid rgba(9, 213, 189, 0.5);
  box-shadow: inset 0 0 10px rgba(9, 213, 189, 0.4);
  background-color: rgba(9, 213, 189, 0.25);
}

.color3 {
  border: 1px solid rgba(227, 61, 185, 0.5);
  box-shadow: inset 0 0 10px rgba(227, 61, 185, 0.4);
  background-color: rgba(227, 61, 185, 0.25);
}

.color4 {
  border: 1px solid rgba(9, 213, 40, 0.5);
  box-shadow: inset 0 0 10px rgba(9, 213, 40, 0.4);
  background-color: rgba(9, 213, 40, 0.25);
}

.color5 {
  border: 1px solid rgba(7, 118, 181, 0.5);
  box-shadow: inset 0 0 10px rgba(7, 118, 181, 0.4);
  background-color: rgba(7, 118, 181, 0.3);
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
  /* background: url(../assets/img/地图界面.gif) no-repeat center center; */
  background: url(../assets/img/地图界面.gif) no-repeat center center;

  background-size: cover
}

/*---------------------------------------------------------------*/
/*element-ui 样式加了scoped后要用深度选择器>>>、/deep/或::v-deep才能生效 */
::v-deep .el-input {
  margin-top: 5px;
}

::v-deep .el-input__inner {
  background-color: transparent !important;
  color: white !important;
  border: 1px solid rgba(9, 128, 213, 0.5) !important;
  box-shadow: inset 0 0 20px rgba(9, 128, 213, 0.4);
}

::v-deep .el-button{
  background-color: transparent !important;
  border: 1px solid rgba(9, 128, 213, 0.5) !important;
  box-shadow: inset 0 0 20px rgba(9, 128, 213, 0.4);
  margin-top: 5px;
  height: 40px;
  width: 40px;
  margin-left: 2%;
}

::v-deep .scrollbar-wrapper {
  max-height: 500px;
}

::v-deep .el-scrollbar-wrap {
  overflow-x: hidden;
}

::v-deep .el-submenu__title span,
::v-deep .el-submenu__title i {
  color: white;
}

::v-deep .el-menu {
  background-color: transparent !important;
}

::v-deep .el-menu li {
  color: white;
}

::v-deep .el-submenu__title:hover,
::v-deep .el-menu-item:hover {
  background-color: #626f8b69 !important;
}

::v-deep .el-menu-item:active,
::v-deep .el-menu-item:focus {
  background-color: #626f8b69 !important;
}

.el-divider--horizontal {
  margin: 24px 0;
}

.personInformation {
  display: inline-block;
  margin-left: 5%;
  margin-right: 5%;
  margin-bottom: 2%;
  width: 90%;
  height: 20%;
}

.person {
  float: left;
  margin-right: 70px;
}

.information {
  display: flex;
  flex-wrap: wrap;
  height: 100%;
}

.information li {
  display: inline-block;
  width: 33%;
  height: 33%;
}

.block {
  display: flex;
  justify-content: space-between;
  margin-left: 5%;
  margin-right: 5%;
  margin-bottom: 2%;
  width: 90%;
  height: 10%;
}

.block li {
  width: 25%;
  justify-content: space-around;
  align-items: center;
  display: flex;
  flex-direction: column;
}


.track {
  height: 66%;
}

.el-divider--horizontal{
     margin: 8px 0;
     background: 0 0;
     border-top: 1px solid #e8eaec;
 } 

.appointment,
.activity,
.award{
  margin-top: 1%;
  height: 30%;
}

.track .middlebox {
  height: 60%;
}
</style>
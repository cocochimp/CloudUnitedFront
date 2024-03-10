<template>
  <div>
    <div class="content">
      <div class="head clearfix">
        <img class="logo" src="../assets/img/logo.png">
        <h1 class="pulll_left">领导决策中心</h1>
        <div class="menu menu2 pulll_left">
          <ul>
            <router-link class="li" to="/metadata/dataIndex">首页</router-link>
            <router-link class="li" to="/metadata/democrat">民主党派</router-link>
            <router-link class="li" to="/metadata/frontParty">无党派、留学人员</router-link>
            <router-link class="li" to="/metadata/minNationality">少数民族</router-link>
            <!-- <router-link class="li" to="/metadata/specialRegions">港澳台</router-link> -->
              <router-link class="li" to="/metadata/gain">统战成果展示</router-link>
            <router-link class="li" to="/metadata/portrait">人物画像</router-link>
          </ul>
        </div>
        <router-link class="li logout" to="/appMainIndex">
          <img src="../assets/img/bigSummary/退出.png">
          退出
        </router-link>
      </div>
    </div>
       
        <router-view></router-view>
  
  
  </div>
</template>

<script>
export default {
  neme:'metadata',
  methods:{
    buttonClick(){
      var btnList = document.querySelectorAll('.li')
      for(let i=0;i<btnList.length;i++){
        btnList[i].addEventListener('click',function(){
          for(let j=0;i<btnList.length;j++){
            btnList[j].style='color:white'
          }
          btnList[i].style='color:#f4e925'
        })
      }
    },
    buttonMove(){
    var btnList = document.querySelectorAll('.li')
    for(let i=0;i<btnList.length;i++){
      btnList[i].addEventListener('mousemove',function(){
        for(let j=0;i<btnList.length;j++){
          btnList[j].style='color:white'
        }
        btnList[i].style='color:#f4e925'
      })
    }
  }
  }
  
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
  font-family: "微软雅黑";
}

body {
  color: #fff;
  font-size: 16px;
  background: #033c76;
  background: radial-gradient(50% 35%,
      farthest-corner,
      #034f8e,
      #034987,
      #02366d,
      #002353);
  background: -webkit-radial-gradient(50% 35%,
      farthest-corner,
      #034f8e,
      #034987,
      #02366d,
      #002353);
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

/* .content{
  background: url(../assets/img/地图界面.gif) no-repeat;
  
} */

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


i {
  font-style: normal;
}


.head {
  position: relative;
  height: 90px;
  margin: 0 15px;
  padding-right: 60px;
}

.head h1 {
  font-size: 36px;
  letter-spacing: -2px;
  text-align: center;
  line-height: 90px;
  padding-right: 35px;
  color: #daf9ff;
  padding-left: 20px;
}

.head .logout{
  font-size: 22px;
  line-height: 90px;
  color: white;
  text-align: center;
}

.logout img{
  height: 22px;
}

.head .menu ul {
  font-size: 0;
  display: flex;
}

.head .menu .li {
  display: inline-block;
  position: relative;
  margin: 25px 15px;
}

.head .menu .li {
  display: block;
  font-size: 18px;
  color: #fff;
  line-height: 40px;
  padding: 0 15px;
}

.menu .li:before,
.menu .li:after {
  position: absolute;
  width: 10px;
  height: 20px;
  opacity: 0.4;
  content: "";
  border-top: 2px solid #02a6b5;
  top: -1px;
  border-radius: 2px;
}

.menu .li:before,
.menu .li:before {
  border-left: 2px solid #02a6b5;
  left: -1px;
}

.menu .li:after,
.menu .li:after {
  border-right: 2px solid #02a6b5;
  right: -1px;
}

.menu .li {
  position: relative;
}

.menu .li:before,
.menu .li:after {
  position: absolute;
  width: 10px;
  height: 40px;
  opacity: 0.4;
  content: "";
  border-bottom: 2px solid #02a6b5;
  bottom: -1px;
  border-radius: 2px;
}


.menu .li:hover {
  color: #f4e925;
}

.menu .li:hover:before,
.menu .li:hover:after {
  border-color: #f4e925;
  opacity: 1;
}
.router-link-active{
  color: #f4e925 !important;
}
.router-link-active::before,
.router-link-active::after{
  border-color: #f4e925 !important;
  opacity: 1 !important;
}

.logout{
  float: right;
  display: block;
}

.mapc {
  background: url(../assets/img/bg3.png) no-repeat center center;
  background-size: 100% 100%;
}

.map {
  position: relative;
  height: 100%;
  padding-left: 10%;
}
.content{
   background: url(../assets/img/地图界面.gif) no-repeat;
    background-size: cover;
    
    /*background-color: #011328*/
}

.logo{
  float: left;
  height: 70px;
  margin-top: 8px;
}
</style>
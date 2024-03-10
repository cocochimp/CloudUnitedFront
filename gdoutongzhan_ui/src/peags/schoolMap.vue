<template>
  <div class="schooldMap">
    <div class="colum">
      <h3>截止{{ year }}-{{ month }}-{{ day }},全校共有{{ people }}人</h3>
    </div>
    <button @click="showAll" class="showAll">
      <p>查看全部</p>
    </button>
    <ul class="optionsBar">
      <button @click="switch1(1)" class="option" :class="nav_id===1?'nav-active':''">湖光校区</button>
      <button @click="switch1(2)" class="option" :class="nav_id===2?'nav-active':''">海滨校区</button>
      <button @click="switch1(3)" class="option" :class="nav_id===3?'nav-active':''">阳江校区</button>
    </ul>
    <div v-show="(map==1)" class="Campus">
      <img class="huguangMap" src="../assets/img/SchoolMap/huguangSchoolMap.png" />
      <ul class="dotList">
        <li class="wenxue" @click="wenxue">
          <img src="../assets/img/SchoolMap/wenxue3.png" />
        </li>
        <li class="shiping" @click="shiping">
          <img src="../assets/img/SchoolMap/shiping3.png" />
        </li>
        <li class="haiqi" @click="qixiang">
          <img src="../assets/img/SchoolMap/haiqi3.png" />
        </li>
        <li class="houqing" @click="houqin">
          <img src="../assets/img/SchoolMap/houqing3.png" />
        </li>
        <li class="jixie" @click="jixie">
          <img src="../assets/img/SchoolMap/jixie3.png" />
        </li>
        <li class="guanli" @click="guanli">
          <img src="../assets/img/SchoolMap/guanli3.png" />
        </li>
        <li class="masi" @click="makesi">
          <img src="../assets/img/SchoolMap/masi3.png" />
        </li>
        <li class="jinji" @click="jingji">
          <img src="../assets/img/SchoolMap/jinji3.png" />
        </li>
        <li class="haigong" @click="nengyuan">
          <img src="../assets/img/SchoolMap/haigong3.png" />
        </li>
        <li class="shuji" @click="jisuanji">
          <img src="../assets/img/SchoolMap/shuji3.png" />
        </li>
        <li class="dianzi" @click="dianzi">
          <img src="../assets/img/SchoolMap/dianzi3.png" />
        </li>
        <li class="huaxue" @click="huaxue">
          <img src="../assets/img/SchoolMap/huahuan3.png" />
        </li>
        <li class="nongye" @click="nongye">
          <img src="../assets/img/SchoolMap/binhai3.png" />
        </li>
        <li class="shuichan" @click="shuichan">
          <img src="../assets/img/SchoolMap/shuichan3.png" />
        </li>
        <li class="fazheng" @click="fazhen">
          <img src="../assets/img/SchoolMap/fazheng3.png" />
        </li>
        <li class="waiguoyv" @click="waiguoyu">
          <img src="../assets/img/SchoolMap/waiguoyv3.png" />
        </li>
        <li class="zhongge" @click="zhongge">
          <img src="../assets/img/SchoolMap/zhongge3.png" />
        </li>
        <li class="tiyv" @click="tiyu">
          <img src="../assets/img/SchoolMap/tiyv3.png" />
        </li>
        <li class="jiguan" @click="jiguan">
          <img src="../assets/img/SchoolMap/jiguan3.png" />
        </li>
        <li class="tuixiu" @click="tuixiu">
          <img src="../assets/img/SchoolMap/tuixiu3.png" />
        </li>
        <li class="jiaofu" @click="jiaofu">
          <img src="../assets/img/SchoolMap/jiaofu3.png" />
        </li>
      </ul>
      <ul class="routeList">
        <li class="wenxue2">
          <img src="../assets/img/SchoolMap/wenxue4.png" />
        </li>
        <li class="shiping2">
          <img src="../assets/img/SchoolMap/shiping4.png" />
        </li>
        <li class="haiqi2">
          <img src="../assets/img/SchoolMap/haiqi4.png" />
        </li>
        <li class="houqing2">
          <img src="../assets/img/SchoolMap/houqing4.png" />
        </li>
        <li class="jixie2">
          <img src="../assets/img/SchoolMap/jixie4.png" />
        </li>
        <li class="guanli2">
          <img src="../assets/img/SchoolMap/guanli4.png" />
        </li>
        <li class="masi2"><img src="../assets/img/SchoolMap/masi4.png" /></li>
        <li class="jinji2"><img src="../assets/img/SchoolMap/jinji4.png" /></li>
        <li class="haigong2">
          <img src="../assets/img/SchoolMap/haigong4.png" />
        </li>
        <li class="shuji2">
          <img src="../assets/img/SchoolMap/shuji4.png" />
        </li>
        <li class="dianzi2">
          <img src="../assets/img/SchoolMap/dianzi4.png" />
        </li>
        <li class="huaxue2">
          <img src="../assets/img/SchoolMap/huahuan4.png" />
        </li>
        <li class="binhai2">
          <img src="../assets/img/SchoolMap/binhai4.png" />
        </li>
        <li class="shuichan2">
          <img src="../assets/img/SchoolMap/shuichan4.png" />
        </li>
        <li class="fazheng2">
          <img src="../assets/img/SchoolMap/fazheng4.png" />
        </li>
        <li class="waiguoyv2">
          <img src="../assets/img/SchoolMap/waiguoyv4.png" />
        </li>
        <li class="zhongge2">
          <img src="../assets/img/SchoolMap/zhongge4.png" />
        </li>
        <li class="tiyv2"><img src="../assets/img/SchoolMap/tiyv4.png" /></li>
        <li class="jiguan2">
          <img src="../assets/img/SchoolMap/jiguan4.png" />
        </li>
        <li class="tuixiu2">
          <img src="../assets/img/SchoolMap/tuixiu4.png" />
        </li>
        <li class="jiaofu2">
          <img src="../assets/img/SchoolMap/jiaofu4.png" />
        </li>
      </ul>
    </div>
    <div v-show="(map==2)" class="Campus">
      <img class="haibinMap" src="../assets/img/SchoolMap/haibinSchoolMap.png"/>
      <ul class="dotList">
        <li class="haiyun" @click="haiyun">
          <img  src="../assets/img/SchoolMap/haiyun3.png" >
        </li>
      </ul>
      <ul class="routeList">
        <li class="haiyun2">
          <img  src="../assets/img/SchoolMap/haiyun4.png" >
        </li>
      </ul>
    </div>
    <div v-show="(map==3)" class="Campus">  
      <img class="yangjiangMap" src="../assets/img/SchoolMap/yangjiangSchoolMap.png"/>
      <ul class="dotList">
        <li class="yangjiang" @click="yangjiang">
          <img src="../assets/img/SchoolMap/yangjiang3.png" >
        </li>
      </ul>
      <ul class="routeList">
        <li class="yangjiang2">
          <img src="../assets/img/SchoolMap/yangjiang4.png" >
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      nav_id:1,
      map:1,
      year: new Date().getFullYear(),
      month: new Date().getMonth() + 1,
      day: new Date().getDate(),
      people: "",
    };
  },
  mounted() {
    this.click();
    this.totalCount();
  },
  methods: {
    //获取全校统战总人数
    totalCount() {
      axios
        .post(
          "http://localhost:9107/service/servicedecisioncenter/FrontPage/totalCount"
        )
        .then((res) => {
          this.people = res.data.t;
        });
    },
    //刷新展示全部数据
    showAll() {
      window.location.reload();
      // this.totalCount();
    },
    //点击切换校园
    switch1(e){
      this.map=e
      this.nav_id=e
      console.log(this.nav_id)
    },
    click() {
      var dotArr = document.querySelectorAll(".dotList > li");
      var routeArr = document.querySelectorAll(".routeList > li");
      for (let i = 0; i < dotArr.length; i++) {
        dotArr[i].addEventListener("click", function () {
          for (let j = 0; j < routeArr.length; j++) {
            routeArr[j].style = "display:none";
          }
          routeArr[i].style = "display:block";
        });
      }
    },
    wenxue() {
      window.sessionStorage.setItem("department", "文学与新闻传播学院党委");
      this.$bus.$emit("wenxue", "文学与新闻传播学院党委");
    },
    shiping() {
      window.sessionStorage.setItem("department", "食品科技学院党委");
      this.$bus.$emit("shiping", "食品科技学院党委");
    },
    qixiang() {
      window.sessionStorage.setItem("department", "海洋与气象学院党委");
      this.$bus.$emit("qixiang", "海洋与气象学院党委");
    },
    houqin() {
      window.sessionStorage.setItem("department", "后勤与产业党委");
      this.$bus.$emit("houqin", "后勤与产业党委");
    },
    jixie() {
      window.sessionStorage.setItem("department", "机械工程学院党委");
      this.$bus.$emit("jixie", "机械工程学院党委");
    },
    guanli() {
      window.sessionStorage.setItem("department", "管理学院党委");
      this.$bus.$emit("guanli", "管理学院党委");
    },
    makesi() {
      window.sessionStorage.setItem("department", "马克思主义学院党委");
      this.$bus.$emit("makesi", "马克思主义学院党委");
    },
    jingji() {
      window.sessionStorage.setItem("department", "经济学院党委");
      this.$bus.$emit("jingji", "经济学院党委");
    },
    nengyuan() {
      window.sessionStorage.setItem("department", "海洋工程与能源学院党委");
      this.$bus.$emit("nengyuan", "海洋工程与能源学院党委");
    },
    jisuanji() {
      window.sessionStorage.setItem("department", "数学与计算机学院党委");
      this.$bus.$emit("jisuanji", "数学与计算机学院党委");
    },
    dianzi() {
      window.sessionStorage.setItem("department", "电子与信息工程学院党委");
      this.$bus.$emit("dianzi", "电子与信息工程学院党委");
    },
    huaxue() {
      window.sessionStorage.setItem("department", "化学与环境学院党委");
      this.$bus.$emit("huaxue", "化学与环境学院党委");
    },
    nongye() {
      window.sessionStorage.setItem("department", "滨海农业学院党委");
      this.$bus.$emit("nongye", "滨海农业学院党委");
    },
    shuichan() {
      window.sessionStorage.setItem("department", "水产学院党委");
      this.$bus.$emit("shuichan", "水产学院党委");
    },
    fazhen() {
      window.sessionStorage.setItem("department", "法政学院党委");
      this.$bus.$emit("fazhen", "法政学院党委");
    },
    waiguoyu() {
      window.sessionStorage.setItem("department", "外国语学院党委");
      this.$bus.$emit("waiguoyu", "外国语学院党委");
    },
    zhongge() {
      window.sessionStorage.setItem("department", "中歌艺术学院党委");
      this.$bus.$emit("zhongge", "中歌艺术学院党委");
    },
    tiyu() {
      window.sessionStorage.setItem("department", "体育与休闲学院党委");
      this.$bus.$emit("tiyu", "体育与休闲学院党委");
    },
    jiguan() {
      window.sessionStorage.setItem("department", "机关党委");
      this.$bus.$emit("jiguan", "机关党委");
    },
    tuixiu() {
      window.sessionStorage.setItem("department", "离退休干部党委");
      this.$bus.$emit("tuixiu", "离退休干部党委");
    },
    jiaofu() {
      window.sessionStorage.setItem("department", "教辅单位党委");
      this.$bus.$emit("jiaofu", "教辅单位党委");
    },
    haiyun(){
      window.sessionStorage.setItem("department", "船舶与海运学院党委");
      this.$bus.$emit("jiaofu", "船舶与海运学院党委");
    },
    yangjiang(){
      window.sessionStorage.setItem("department", "阳江校区党委");
      this.$bus.$emit("jiaofu", "阳江校区党委");
    }
  },
};
</script>

<style>
/*-------------校园地图-------------- */
.schooldMap {
  display: flex;
  flex-wrap: wrap;
  flex-direction: row;
  position: relative;
  height: 100%;
}

.colum {
  order: 1;
  height: 7%;
  width: 80%;
  background: url(../assets/img/SchoolMap/title.png) no-repeat;
  background-size: 100%;
}

.showAll {
  background-color: transparent;
  order: 1;
  width: 15%;
  height: 30px;
  margin-top: 10px;
  border: 1px solid rgba(9, 159, 213, 0.5);
  box-shadow: inset 0 0 10px rgba(9, 159, 213, 0.5);
}

.showAll p {
  color: white;
  font-weight: 600;
  text-align: center;
  line-height: 30px;
}

.optionsBar{
  display: flex;
  justify-content: space-around;
  order: 2;
  height: 5%;
  width: 100%;
}

.option{
  background-color: transparent;
  width: 20%;
  border: 1px solid rgba(9, 213, 135, 0.5);
  box-shadow: inset 0 0 20px rgba(9, 213, 135, 0.5);
}

.option {
  color: white;
  font-weight: 600;
  text-align: center;
  line-height: 30px;
}

.option:hover{
  color: #f4e925;
}

.nav-active{
  color: #f4e925;
}

.Campus {
  order: 3;
  position: relative;
  height: 85%;
  width: 100%;
}

.colum h3 {
  margin-top: 15px;
  text-align: center;
}

.huguangMap {
  position: absolute;
  height: 100%;
  /*filter:contrast(20%);*/
}

.haibinMap{
  position: absolute;
  height: 100%;
  left: -28%;
}

.yangjiangMap{
  position: absolute;
  width: 100%;
  top:10%
}

.dotList li {
  position: absolute;
}

.routeList li {
  display: none;
  z-index: 999;
}

.routeList li img,
.dotList li img {
  height: 20px;
}

/*left+100px,height+4px */
.jinji2,
.jinji {
  position: absolute;
  left: 56%;
  top: 39.5%;
}

.shiping2,
.shiping {
  position: absolute;
  left: 48%;
  top: 73%;
}

.haiqi2,
.haiqi {
  position: absolute;
  left: 46%;
  top: 41%;
}

.guanli2,
.guanli {
  position: absolute;
  left: 73.5%;
  top: 58%;
}

.jixie2,
.jixie {
  position: absolute;
  left: 52%;
  top: 52.5%;
}

.houqing2,
.houqing {
  position: absolute;
  left: 66%;
  top: 62%;
}

.masi2,
.masi {
  position: absolute;
  left: 40%;
  top: 57%;
}

.wenxue2,
.wenxue {
  position: absolute;
  left: 45%; /*161px */
  top: 30%; /*130px */
}

.haigong2,
.haigong {
  position: absolute;
  left: 18%;
  top: 50.5%;
}

.shuji2,
.shuji {
  position: absolute;
  left: 30%;
  top: 56%;
}

.dianzi2,
.dianzi {
  position: absolute;
  left: 58%;
  top: 57%;
}

.huaxue2,
.huaxue {
  position: absolute;
  left: 46%;
  top: 69%;
}

.binhai2,
.nongye {
  position: absolute;
  left: 34.5%;
  top: 77%;
}

.shuichan2,
.shuichan {
  position: absolute;
  left: 62%;
  top: 78%;
}

.jiguan2,
.jiguan {
  position: absolute;
  left: 60%;
  top: 33%;
}

.waiguoyv2,
.waiguoyv {
  position: absolute;
  left: 32%;
  top: 68%;
}

.zhongge2,
.zhongge {
  position: absolute;
  left: 23%;
  top: 43%;
}

.tiyv2,
.tiyv {
  position: absolute;
  left: 68%;
  top: 53%;
}

.fazheng2,
.fazheng {
  position: absolute;
  left: 65%;
  top: 42%;
}

.tuixiu2,
.tuixiu {
  position: absolute;
  left: 53%;
  top: 82%;
}

.jiaofu2,
.jiaofu {
  position: absolute;
  left: 44%;
  top: 84%;
}

/*海滨校区*/
.haiyun,
.haiyun2{
  position: absolute;
  left: 35%;
  top: 55%;
}

/*阳江校区*/
.yangjiang,
.yangjiang2{
  position: absolute;
  left: 46%;
  top: 32%;
}

</style>
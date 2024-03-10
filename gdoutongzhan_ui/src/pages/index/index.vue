<template>
  <div class="container">
    <!-- 头部 -->
    <div class="header">
      <indexhead></indexhead>
    </div>
    <!-- /头部 -->

    <!-- 内容 -->
    <div class="content">
      <div class="date-search">
        <div class="date">
          <p>{{ year }}年{{ month }}月{{ date }}日 {{ week }}</p>
        </div>
        <div class="search">
          <p>站内搜索:</p>
          <el-input placeholder="请输入" v-model="input"> </el-input>
          <button class="searchBtn"  @click="sendInput">搜索</button>
        </div>
      </div>
      <div class="box">
        <!-- 轮播图 -->
        <div class="scroll-container">
          <indexScroll style="width: 65%" :content="photoList"></indexScroll>
          <div class="card">
            <index-card :content="typeList.s1" title="统战动态"></index-card>
          </div>
          <div class="inter-card">
            <router-link to="/login" target="_blank">
              <img
                style="width: 80%"
                src="../../assets/img/IndexImg/入口.png"
              />
            </router-link>
          </div>
        </div>
        <div style="width: 100%">
          <img
            src="../../assets/img/IndexImg/10003.png"
            alt=""
            style="width: 100%"
          />
        </div>
        <!-- 小框 -->
        <div class="card-box">
          <div class="card">
            <index-card :content="typeList.s2" title="时政理论"></index-card>
          </div>
          <div class="card">
            <index-card :content="typeList.s3" title="通知公告"></index-card>
          </div>
        </div>
        <!-- 不忘初心牢记使命 -->
        <div style="width: 100%">
          <img
            src="../../assets/img/IndexImg/10001.png"
            alt=""
            style="width: 100%"
          />
        </div>
        <!--友情链接-->
        <div class="friendlink">
          <div class="left">
            <div>友情</div>
            <div>链接</div>
          </div>
          <div class="right">
            <ul>
              <li><a href="javascript:;">中共中央统一战线工作部 </a></li>
              <li><a href="javascript:;">全国人民代表大会 </a></li>
              <li>
                <a href="javascript:;">中国人民政治协商会议全国委员会 </a>
              </li>
              <li><a href="javascript:;">中国国民党革命委员会 </a></li>
              <li><a href="javascript:;"> 中国民主同盟 </a></li>
              <li><a href="javascript:;">中国民主建国会 </a></li>
              <li><a href="javascript:;"> 中国民主促进会 </a></li>
              <li><a href="javascript:;"> 中国农工民主党</a></li>
              <li><a href="javascript:;">中国致公党 </a></li>
              <li><a href="javascript:;">九三学社 </a></li>
              <li><a href="javascript:;">中共广东省委统一战线工作部 </a></li>
              <li><a href="javascript:;">中共湛江市委统战部 </a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <!-- /内容 -->

    <!-- 底部 -->
    <div class="footer">
      <indexfoot></indexfoot>
    </div>
    <!-- /底部 -->

    <!--<div class="fd">
      <ul class="news_list clearfix">
        <li class="news n1 clearfix">
          <div class="news_title">
            <span class="t">
              <router-link to="/test6" target="_blank">大数据可视化</router-link>
            
            </span>
          </div>
        </li>
      </ul>
    </div>-->
  </div>
</template>

<script>
import indexhead from "../../components/index/index_Header.vue";
import indexfoot from "../../components/index/index_footer.vue";
import indexScroll from "../../components/index/index_Scroll.vue";
import indexCard from "../../components/index/index_Card.vue";

export default {
  components: {
    indexhead,
    indexfoot,
    indexScroll,
    indexCard,
  },
  data() {
    return {
      articleList: [],
      photoList: [],
      year: new Date().getFullYear(),
      month: new Date().getMonth() + 1,
      date: new Date().getDate(),
      day: new Date().getDay(),
      week:'',
      input:'',
      typeList: {
        s1: [], //统战动态
        s2: [], //通知公告
        s3: [], //党派园地
        s4: [], //参政议政
      },
    };
  },
  async created() {
    const { data: res } = await this.$axios.get(
      "http://localhost:9102/servicearticle/article/article/queryAllArticles"
    );
    this.articleList = res.t;
    const { data: photo } = await this.$axios.get(
      "http://localhost:9103/lunbotuservice/lunbotu/lunBoTu/list"
    );
    this.photoList = photo.t;

    this.makeType();
    // console.log(this.articleList);
    this.getWeek();
  },
  methods: {
    makeType() {
      for (let i = 0; i < this.articleList.length; i++) {
        if (this.articleList[i].type === "统战动态") {
          this.typeList.s1 = this.typeList.s1.concat(this.articleList[i]);
        }
        if (this.articleList[i].type === "通知公告") {
          this.typeList.s2 = this.typeList.s2.concat(this.articleList[i]);
        }
        if (this.articleList[i].type === "党派园地") {
          this.typeList.s3 = this.typeList.s3.concat(this.articleList[i]);
        }
        if (this.articleList[i].type === "参政议政") {
          this.typeList.s4 = this.typeList.s4.concat(this.articleList[i]);
        }
      }
    },
    getWeek() {
      var week;
      switch (this.day) {
        case 1:
          this.week = "星期一";
          break;
        case 2:
        this.week = "星期二";
          break;
        case 3:
        this.week = "星期三";
          break;
        case 4:
        this.week = "星期四";
          break;
        case 5:
        this.week = "星期五";
          break;
        case 6:
        this.week = "星期六";
          break;
        case 0:
        this.week = "星期日";
          break;
      }
    },
    sendInput() {
      if (this.input === "") {
        alert("请输入搜索关键词");
        return;
      }
      this.$router.push("/searchPage?search=" + this.input);
    },
  },
};
</script>

<style scoped>
.content {
  width: 100%;
}
.content .box {
  width: 1150px;
  margin: 0 auto;
  padding: 25px;
  background-color: #fff;
  margin-bottom: 30px;
}

.content .date-search {
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 1150px;
  height: 60px;
  margin: 15px auto;
  padding: 0px 2%;
  background-color: #fff;
  border-radius: 15px;
  box-shadow: 0px 0px 6px #b8b8b8;
}

.date-search .search{
  display: flex;
  align-items: center;
  justify-content: center;
}

.date-search .search p{
  width: 120px;
  margin-right: 15px;
  font-weight: 550;
  color: #861600;
}
::v-deep .el-input__inner{
  border: 1px solid #861600 !important;
  color: #2b2929;
  border-radius: 12px;
}

::v-deep .el-input{
  margin-right: 10px;
}

.searchBtn{
  font-size: 18px;
  width: 120px;
  height: 40px;
  background-color: #861600;
  color: #fff;
  border: none;
  border-radius: 10px;
}

.date-search .date p{
  font-size: 24px;
  font-weight: 600; 
  color: #861600;
}

.scroll-container {
  width: 678px;
  height: 285px;
  margin-bottom: 20px;
  display: -webkit-box;
}

.card-box {
  display: flex;
  justify-content: space-around;
  margin: 20px 0;
}

.card {
  width: 380px;
  min-height: 285px;
}

.inter-card {
  margin-left: 20px;
}

.inter-card img {
  height: 280px;
  width: 250px !important;
}
.divided {
  width: 100%;
  height: 20px;
  background-color: rgb(232, 232, 232);
  margin-bottom: 20px;
}
.fd {
  position: fixed;
  right: 0px;
  top: 40%;
  text-align: center;
}
.news_list li.news {
  width: 100px;
  height: 100px;
  background: #ffffff;
  margin-bottom: 5px;
}
.news_title {
  padding: 10px;
  height: 80px;
}
.t {
  display: block;
  height: 100%;
  width: 100%;
  background: #e8e8e8;
}
.news_title a {
  display: block;
  font-size: 20px;
  padding: 20px 10px;
  color: #af090b;
  font-weight: 700;
}

.friendlink {
  width: 100%;
  display: flex;
  padding: 10px;
}

.friendlink .left {
  min-width: 90px;
  min-height: 90px;
  background: #cd0401;
  border-top-left-radius: 5px;
  border-bottom-left-radius: 5px;
  box-shadow: 0 5px 15px 0 rgb(0 0 0 / 15%);
  display: flex;
  justify-content: center;
  align-items: center;
}

.friendlink .left div {
  color: white;
  font-size: 24px;
  font-weight: 700;
  text-align: center;
}

.friendlink .right {
  background: white;
  box-shadow: 0 5px 15px 0 rgb(0 0 0 / 15%);
  padding: 10px;
  flex: auto;
  border-top-right-radius: 5px;
  border-bottom-right-radius: 5px;
  display: flex;
  align-items: center;
}

.friendlink .right ul {
  margin-bottom: 0px !important;
}

.friendlink .right ul li {
  float: left;
  padding: 5px 10px;
  display: list-item;
}

.friendlink .right ul a {
  color: black;
  font-size: 15px;
  text-align: left;
}

a:link {
  text-decoration: none;
  color: #262626;
}

.friendlink .right ul a:hover {
  color: #e60012;
}
</style>

<template>
  <div class="container">
    <!-- 头部 -->
    <div class="header">
      <fachead></fachead>
    </div>
    <!-- /头部 -->

    <!--院系统战-->
    <div class="content">
      <div class="box">
        <div class="left">
          <div class="left_title">
            <span>无党派人士</span>
          </div>
        </div>
        <div class="right">
          <group :item="wudangpai" />
        </div>
      </div>
    </div>
    <!--底部内容-->
    <foot />
  </div>
</template>

<script>
import fachead from "../../components/index/index_Header.vue";
import group from "../../components/faculty/faculty_united_front_group";
import foot from "../../components/index/index_footer";
import front from "../../components/faculty/faculty_united_front";
import navigator from "../../components/faculty/faculty_college_navigator";
import scroll from "../../components/index/index_Scroll.vue";

export default {
  name: "faculty",
  data() {
    return {
      wudangpai: [],
    };
  },
  components: { group, foot, front, navigator, fachead, scroll },
  methods: {
    getArticle(data) {
      // console.log('无党派人士页面的数据')
      // console.log(data)
    },
  },
  created() {
    // console.log('无党派数据')

    // this.wudangpai = this.$route.query.wudangpai
    this.$axios
      .get(
        "http://localhost:9102/servicearticle/article/article/queryArticleByPosition?position=无党派人士"
      )
      .then((res) => {
        this.wudangpai = res.data.t;
      });
  },
};
</script>

<style scoped>
.scroll-container {
  position: relative;
  width: 50rem;
  height: 20rem;
  padding-top: 1rem;
}
.left {
  float: left;
  width: 14rem;
}

.left_title {
  border: #99a9bf solid 2px;
  width: 14rem;
  background: #861600;
}
.left_title > span {
  padding-left: 2.5rem;
  font-size: 20px;
  height: 50px;
  line-height: 50px;
  color: white;
}
.box {
  width: 1150px;
  margin: 0 auto;
  padding: 25px;
  background-color: #fff;
  margin-bottom: 30px;
}
.left {
  float: left;
  width: 14rem;
  height: 40rem;
}
.right {
  margin-left: 16.5rem;
  width: 50rem;
  height: 40rem;
}
</style>

<template>
  <div class="container">
    <!-- 头部 -->
    <div class="header">
      <articlehead></articlehead>
    </div>

    <!-- 内容 -->
    <div class="content">
      <div class="box">
        <h1 class="articleTitle">{{ articleTitle }}</h1>
        <p class="arti_metas">
          <span>作者：{{ author }}</span>
          <span>发布时间：{{ releaseTime }}</span>
          <span>浏览次数：{{ total }}</span>
        </p>
        <div class="articlePage ql-editor" v-html="article"></div>
      </div>
    </div>

    <!-- 底部 -->
    <div class="footer">
      <articlefoot></articlefoot>
    </div>
  </div>
</template>

<script>
import articlehead from "../../components/index/index_Header.vue";
import articlefoot from "../../components/index/index_footer.vue";

export default {
  components: {
    articlehead,
    articlefoot,
  },
  data() {
    return {
      article: "",
      articleTitle: "",
      releaseTime: "",
      total: 0,
      author: "",
    };
  },
  created() {
    this.$axios.post("http://localhost:9102/servicearticle/article/article/queryArticleById",
      { id: this.$route.query.id }).then((res) => {
        this.article = res.data.t.content;
        this.articleTitle = res.data.t.title;
        this.releaseTime = res.data.t.releaseTime;
        this.author = res.data.t.author;
        this.total = res.data.t.totalPv;
      });
  },
};
</script>

<style scoped>
.content .box {
  width: 1200px;
  margin: 0 auto;
  padding: 25px;
  background-color: #fff;
  margin-bottom: 30px;
  min-height: 73vh;
}

.scroll-container {
  width: 900px;
  height: 350px;
  margin: auto;
  margin-bottom: 20px;
}

.card-box {
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
}

.card {
  width: 450px;
}

.divided {
  width: 100%;
  height: 20px;
  background-color: rgb(232, 232, 232);
  margin-bottom: 20px;
}

.articleTitle {
  line-height: 1.7;
  font-family: "Microsoft YaHei";
  font-size: 22px;
  text-align: center;
  color: #9b0d14;
  margin-bottom: 5px;
}

.articlePage {
  margin-top: 20px;
  white-space:pre-wrap
}

.articleTime {
  display: block;
  text-align: center;
  margin-top: 15px;
  color: gray;
}

.arti_metas {
  padding: 10px;
  text-align: center;
  background: #f5f5f5;
  border-top: 1px solid #ececec;
}
.arti_metas span {
  font-size: 14px;
  margin: 0 10px;
}
</style>

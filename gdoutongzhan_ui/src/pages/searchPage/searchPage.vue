<template>
  <div>
    <!-- 头部 -->
    <div class="header">
      <indexhead></indexhead>
    </div>
    <!-- /头部 -->

    <!-- 内容 -->
    <div class="content">
      <div class="box">
        <div class="search-header">
          <h2>搜索结果</h2>
          <router-link to="/index">首页</router-link>
        </div>
        <div class="result">
          <search-result :content="searchList"></search-result>
        </div>
      </div>
    </div>
    <!-- /内容 -->

    <div class="footer">
      <indexfoot></indexfoot>
    </div>
  </div>
</template>

<script>
import indexhead from '../../components/index/index_Header.vue'
import indexfoot from '../../components/index/index_footer.vue'
import searchResult from '../../components/searchPage/search_result.vue'

export default {
  data() {
    return {
      search: '',
      searchList: [],
    }
  },
  components: {
    indexhead,
    indexfoot,
    searchResult,
  },
  created() {
    this.search = this.$route.query.search
    this.$axios.get('http://localhost:9102/servicearticle/article/article/indexQueryArticle?title=' + this.search).then((res) => {
      this.searchList = res.data.t
    })
  },
}
</script>

<style scoped>
.search-header {
  width: 1000px;
  height: 50px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  border-bottom: #d5d5d5 solid 1px;
  margin-top: 20px;
  margin-left: auto;
  margin-right: auto;
}
.search-header a {
  color: #428bca;
  text-decoration: none;
}
.result {
  width: 1000px;
  margin: 0 auto;
}
.content .box {
  width: 1150px;
  min-height: 40rem;
  max-height: 100%;
  margin: 0 auto;
  padding: 25px;
  background-color: #fff;
  margin-bottom: 30px;
}

.scroll-container {
  width: 678px;
  height: 402px;
  margin-bottom: 20px;
  display: -webkit-box;
}

.card-box {
  display: flex;
  justify-content: space-around;
  margin: 20px 0;
}

.card {
  width: 450px;
  min-height: 402px;
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
</style>

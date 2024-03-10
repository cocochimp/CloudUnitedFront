<template>
  <div class="container">
    <!-- 头部 -->
    <div class="header">
      <dowhead></dowhead>
    </div>
    <!-- /头部 -->

    <!-- 子网页内容开始 -->
    <div class="content">
      <div class="box">
        <!-- 左侧导航栏 -->
        <div class="left">
          <span>下载专区</span>
        </div>
        <!-- /左侧导航栏 -->

        <!-- 右侧内容栏 -->
        <div class="right">
          <downew :item="download" />
        </div>
      </div>
    </div>
    <!-- /子网页内容结束 -->

    <!-- 底部 -->
    <div class="footer">
      <dowfoot></dowfoot>
    </div>
    <!-- /底部 -->
  </div>
</template>

<script>
import dowhead from "../../components/index/index_Header.vue";
import dowfoot from "../../components/index/index_footer.vue";
import downew from "../../components/faculty/faculty_united_front_group.vue";

export default {
  data() {
    return {
      download: [],
    };
  },
  components: {
    dowhead,
    dowfoot,
    downew,
  },
  created() {
    // console.log('接收下载专区的内容')
    // console.log(this.$route.query.download)
    // this.download = this.$route.query.download
    this.$axios
      .get("http://localhost:9104/servicefile/filedownload/file/fileselectAll")
      .then((res) => {
        this.download = res.data;
        // console.log('请求下载文件')
        console.log(res);
      });
  },
};
</script>

<style scoped>
.box {
  width: 1150px;
  margin: 0 auto;
  padding: 25px;
  background-color: #fff;
  margin-bottom: 30px;
}
.left {
  float: left;
  margin-bottom: 1.5rem;
  border: #99a9bf solid 2px;
  width: 14rem;
  color: white;
  background: #861600;
}
.left > span {
  padding-left: 2.5rem;
  font-size: 20px;
  height: 50px;
  line-height: 50px;
}
.right {
  margin-left: 16.5rem;
  width: 50rem;
  height: 40rem;
}
</style>

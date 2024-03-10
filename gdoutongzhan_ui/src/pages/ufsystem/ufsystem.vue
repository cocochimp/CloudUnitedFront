<template>
  <div class="container">
    <!-- 头部 -->
    <div class="header">
      <demphead></demphead>
    </div>
    <!-- /头部 -->

    <!-- 子网页内容开始 -->
    <div class="content">
      <div class="box">
        <!-- 左侧导航栏 -->
        <div class="left">
          <dempnavigator @shareLeader="getLeader" @shareList="getShare" />
        </div>
        <!-- /左侧导航栏 -->

        <!-- 右侧内容栏 -->
        <div class="right">
          <!-- <group v-if="$route.query.content" /> -->

          <!-- 渲染grop这个组件比渲染leadership这个组件快，因为grop在前面，渲染它时，
          shareData为一个默认的空对象，因为leadership这个组件还没开始渲染，
          并没有把shareData置为空，等它渲染后才开始置空，所以才会出现瞬时出现消失
          的情况
          -->
          <group v-if="shareData" :item="shareData" />

          <leader-ship v-else :leaderShip="shareLeader"></leader-ship>
        </div>
      </div>
    </div>
    <!-- /子网页内容结束 -->

    <!-- 底部 -->
    <dempfoot></dempfoot>
    <!-- /底部 -->
  </div>
</template>

<script>
import group from "../../components/faculty/faculty_united_front_group.vue";
import demphead from "../../components/index/index_Header.vue";
import dempfoot from "../../components/index/index_footer.vue";
import dempleadership from "../../components/parties/parties_Leadership";
import dempintroduction from "../../components/ufsystem/ufsystem_Introduction.vue";
import dempnavigator from "../../components/ufsystem/ufstream_navigator";
import leaderShip from "../../components/ufsystem/ufsystem_Leadership.vue";

export default {
  components: {
    leaderShip,
    demphead,
    dempfoot,
    dempleadership,
    group,
    dempintroduction,
    dempnavigator,
  },
  data() {
    return {
      shareData: "",
      shareLeader: [],
    };
  },
  mounted() {
    this.getShare()
    this.getLeader()
  },
  methods: {
    getShare(res) {
      this.shareData = res;
    },
    getLeader(res) {
      this.shareLeader = res;
    },
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
  /*width: 14rem;*/
  /*height: 40rem;*/
}
.right {
  margin-left: 16.5rem;
  width: 50rem;
  height: 40rem;
}
</style>

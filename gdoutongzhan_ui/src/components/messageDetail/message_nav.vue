<template>
  <div class="container">
    <!-- 头部 -->
    <div class="header">
      <parthead></parthead>
    </div>
    <!-- /头部 -->

    <!-- 子网页内容开始 -->
    <div class="content">
      <div class="box">
        <!-- 左侧导航栏 -->
        <div class="left">
          <div class="left_title">
            <span>参政议政</span>
          </div>
          <ul class="sub_nav">
            <li
              class="sub_navli"
              v-for="(item, index) in representative"
              :key="index"
            >
              <router-link
                :to="{
                  path: '/partpolitics/content',
                  query: {
                    content: item.content,
                    name: item.name,
                  },
                }"
              >
                <p>{{ item.standard }}</p>
              </router-link>
            </li>
          </ul>
        </div>
        <!-- /左侧导航栏 -->

        <!-- 右侧内容栏 -->
        <div class="right">
          <partnew />
          <!--          <router-view></router-view>-->
        </div>
        <!-- /右侧内容栏 -->
      </div>
    </div>
    <!-- /子网页内容结束 -->

    <!-- 底部 -->
    <div class="footer">
      <partfoot></partfoot>
    </div>
    <!-- /底部 -->
  </div>
</template>

<script>
import parthead from "../../components/index/index_Header.vue";
import partfoot from "../../components/index/index_footer.vue";
import partnew from "../../components/faculty/faculty_united_front_group.vue";

export default {
  data() {
    return {
      representative: [
        {
          name: "人大代表",
          standard: "人大代表",
          content: [
            {
              title: "人大代表XXXXXXXXXXXX",
              time: "2022/4/23",
            },
            {
              title: "人大代表XXXXXXXXXXXX",
              time: "2022/4/23",
            },
            {
              title: "人大代表XXXXXXXXXXXX",
              time: "2022/4/23",
            },
          ],
        },
        {
          name: "政协委员",
          standard: "政协委员",
          content: [
            {
              title: "政协委员XXXXXXXXXXXX",
              time: "2022/4/23",
            },
            {
              title: "政协委员XXXXXXXXXXXX",
              time: "2022/4/23",
            },
            {
              title: "政协委员XXXXXXXXXXXX",
              time: "2022/4/23",
            },
          ],
        },
        {
          name: "其他代表人士",
          standard: "其他代表人士",
          content: [
            {
              title: "其他代表人士XXXXXXXXXXXX",
              time: "2022/4/23",
            },
            {
              title: "其他代表人士XXXXXXXXXXXX",
              time: "2022/4/23",
            },
            {
              title: "其他代表人士XXXXXXXXXXXX",
              time: "2022/4/23",
            },
          ],
        },
      ],
    };
  },
  components: {
    parthead,
    partfoot,
    partnew,
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
  width: 14rem;
  height: 40rem;
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
.right {
  margin-left: 16.5rem;
  width: 50rem;
  height: 40rem;
}
.warpper {
  border: 1px solid #ddd;
}

.sub_nav {
  width: 14rem;
  border: 2px solid #ddd;
  border-top: 0;
  border-bottom: 0;
}
.left .sub_nav li {
  position: relative;
}
.sub_nav li {
  border-bottom: 1px solid #ddd;
}
.sub_nav li p:hover {
  color: #861600;
  background-color: #eeeeee;
}
.sub_nav li p {
  font-size: 16px;
  display: block;
  padding: 0.7rem 0;
  padding-left: 0.6rem;
  text-indent: 30px;
  transition: all 0.4s ease-in-out;
}
.sub_sub_nav {
  display: none;
  left: 0;
  height: 7rem;
  max-height: 7rem;
  line-height: 2.5rem;
  overflow: auto;
  overflow-x: hidden;
  background: #f5f5f5;
  padding-left: 1rem;
}
</style>

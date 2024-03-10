<template>
  <div class="card-container">
    <div class="header">
      <h2>{{ title }}</h2>
      <!--      <div class="size-icon">-->
      <!--        <i class="el-icon-arrow-right"></i>-->
      <!--      </div>-->
      <router-link
        :to="{
          path: '/messageDetail',
          query: {
            content: { position: '首页' },
            name: '通知公告',
          },
        }"
      >
        <div class="showMore">
          <p>更多+</p>
        </div>
      </router-link>

      <div class="line">
        <div class="line_short"></div>
      </div>
    </div>

    <div class="card-ul">
      <ul>
        <template v-for="(item, index) in content">
          <li @click="toArticle(item, item.id)" :key="index" v-if="index < 11">
            <!-- <div class="little"></div> -->
            <router-link :to="'/article?id=' + item.id">
              <p>{{ item.title }}</p>
            </router-link>
            <div class="date">
              <p>{{ item.releaseTime }}</p>
            </div>
          </li>
        </template>
      </ul>
    </div>
  </div>
</template>

<script>
import bus from '../../eventBus/eventBus.js'

export default {
  props: {
    title: {
      type: String,
      default: '统战动态',
    },
    content: {
      type: Array,
      default() {
        return [
          {
            title: '文章标题',
            url: '#',
            releaseTime: '2022/3/31',
          },
          {
            title: '文章标题',
            url: '#',
            releaseTime: '2022/3/31',
          },
          {
            title: '文章标题',
            url: '#',
            releaseTime: '2022/3/31',
          },
          {
            title: '文章标题',
            url: '#',
            releaseTime: '2022/3/31',
          },
          {
            title: '文章标题',
            url: '#',
            releaseTime: '2022/3/31',
          },
        ]
      },
    },
  },
  data() {
    return {}
  },
  methods: {
    // toArticle(item, index) {
    //   this.$axios
    //     .post(
    //       "http://localhost:9102/servicearticle/article/article/queryArticleById",
    //       { id: index }
    //     )
    //     .then((res) => {
    //       // console.log('dsds', res)
    //       bus.$emit("share", res.data.t);
    //     });
    // },
  },
}
</script>

<style scoped>
p {
  color: black;
  font-size: 16px;
  font-weight: normal;
  padding-top: 0;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  width: 250px;
}

.line {
  background: #96a0a9;
  height: 4px;
  position: relative;
  width: 100%;
}
.line_short {
  background: #af090b;
  height: 4px;
  width: 150px;
  /*border: solid 2px palevioletred;*/
  position: absolute;
  top: 0;
  left: 0;
}
.card-container {
  width: 100%;
  height: 100%;
  position: relative;
  /*border: 1px solid rgb(212, 48, 48);*/
}

.header {
  /*background: url("../../assets/img/IndexImg/小三角.png") no-repeat;*/
  background-size: cover;
  height: 50px;
  /*border-bottom: 1px solid rgb(212, 48, 48);*/
  /*padding-left: 5px;*/
  line-height: 50px;
  /*border: solid 1px black;*/
  padding-left: 15px;
}

.header h2 {
  display: inline-block;
  margin-left: 25px;
  color: rgb(154, 58, 65);
}

.size-icon {
  float: right;
  font-size: 30px;
  color: rgb(194, 32, 49);
  margin-right: 20px;
}

.card-ul {
  padding: 10px;
}

.card-ul ul li {
  display: flex;
  align-items: center;
  width: 100%;
  height: 30px;
  line-height: 30px;
  border-bottom: 1px solid rgb(223, 223, 223);
}

.card-ul ul li p {
  margin-left: 15px;
}

.little {
  position: absolute;
  width: 10px;
  height: 10px;
  background-color: rgb(194, 31, 48);
}

.date {
  margin-left: auto;
}

.date p{
  width:95px;
}
.showMore {
  display: flex;
  align-items: center;
  position: absolute;
  width: 50px;
  right: 0;
  top: 0;
}
.showMore p {
  color: #555555;
}
.showMore p:hover {
  color: rgb(154, 58, 65);
}
</style>

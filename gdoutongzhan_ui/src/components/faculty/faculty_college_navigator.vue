<template>
  <div class="facNav-container">
    <div>
      <div class="title1"><span>院系统战</span></div>
      <div class="nav">
        <ul class="nav_ul">
          <li v-for="item in items" :key="item.id" class="item">
            <router-link
              :to="{
                path: '/faculty/content',
                query: {
                  content: item.content,
                  name: item.name,
                },
              }"
            >
              <p @click="showToggle(item)">{{ item.name }}</p>
            </router-link>
          </li>
        </ul>
      </div>
    </div>
    <!-- <div class="content">
      <router-view />
    </div> -->
  </div>
</template>

<script>

export default {
  name: 'navigator',
  data() {
    return {
      items: [
        {
          name: '水产学院',
          isSubShow: false,
          content: [
            {
              title: '1水产学院XXXXXXXXXXXXXXXX',
              time: '2022/4/23',
            },
            {
              title: '2水产学院XXXXXXXXXXXXXXXX',
              time: '2022/4/23',
            },
            {
              title: '3水产学院XXXXXXXXXXXXXXXX',
              time: '2022/4/23',
            },
            {
              title: '4水产学院XXXXXXXXXXXXXXXX',
              time: '2022/4/23',
            },
          ],
        },
        {
          mess: [
            {
              title: '你是',
              time: 'ww',
            },
            {
              title: 'sd',
              time: 'sd',
            },
          ],
          name: '食品科技学院',
          isSubShow: false,
          content1: '223',
          title: 'dg',

          content: [
            {
              title: '1食品科技学院XXXXXXXXXXXXXXXX',
              time: '2022/4/23',
            },
            {
              title: '2食品科技学院XXXXXXXXXXXXXXXX',
              time: '2022/4/23',
            },
            {
              title: '3食品科技学院XXXXXXXXXXXXXXXX',
              time: '2022/4/23',
            },
            {
              title: '4食品科技学院XXXXXXXXXXXXXXXX',
              time: '2022/4/23',
            },
          ],
        },
        {
          name: '海洋与气象学院',
          isSubShow: false,
          content: [
            {
              title: '1海洋与气象学院XXXXXXXXXXXXXXXX',
              time: '2022/4/23',
            },
            {
              title: '2海洋与气象学院XXXXXXXXXXXXXXXX',
              time: '2022/4/23',
            },
            {
              title: '3海洋与气象学院XXXXXXXXXXXXXXXX',
              time: '2022/4/23',
            },
            {
              title: '4海洋与气象学院XXXXXXXXXXXXXXXX',
              time: '2022/4/23',
            },
          ],
        },
        {
          name: '食品科技学院',
          isSubShow: false,
          content: [
            {
              title: '1食品科技学院XXXXXXXXXXXXXXXX',
              time: '2022/4/23',
            },
            {
              title: '2食品科技学院XXXXXXXXXXXXXXXX',
              time: '2022/4/23',
            },
            {
              title: '3食品科技学院XXXXXXXXXXXXXXXX',
              time: '2022/4/23',
            },
            {
              title: '4食品科技学院XXXXXXXXXXXXXXXX',
              time: '2022/4/23',
            },
          ],
        },
        {
          name: '滨海农业学院',
          isSubShow: false,
          content: [
            {
              title: '1滨海农业学院XXXXXXXXXXXXXXXX',
              time: '2022/4/23',
            },
            {
              title: '2滨海农业学院XXXXXXXXXXXXXXXX',
              time: '2022/4/23',
            },
            {
              title: '3滨海农业学院XXXXXXXXXXXXXXXX',
              time: '2022/4/23',
            },
            {
              title: '4滨海农业学院XXXXXXXXXXXXXXXX',
              time: '2022/4/23',
            },
          ],
        },
        {
          name: '机械与动力工程学院',
          isSubShow: false,
        },
        {
          name: '海洋工程学院',
          isSubShow: false,
        },
        {
          name: '马克思主义学院',
          isSubShow: false,
        },
        {
          name: '经济学院',
          isSubShow: false,
        },
        {
          name: '管理学院',
          isSubShow: false,
        },
        {
          name: '数学与计算机学院',
          isSubShow: false,
        },
        {
          name: '电子与信息工程学院',
          isSubShow: false,
        },
        {
          name: '化学与环境学院',
          isSubShow: false,
        },
        {
          name: '海运学院',
          isSubShow: false,
        },
        {
          name: '文学与新闻传播学院',
          isSubShow: false,
        },
        {
          name: '法政学院',
          isSubShow: false,
        },
        {
          name: '外国语学院',
          isSubShow: false,
        },
        {
          name: '中歌艺术学院',
          isSubShow: false,
        },
        {
          name: '体育与休闲学院',
          isSubShow: false,
        },
        {
          name: '继续教育学院',
          isSubShow: false,
        },
        {
          name: '寸金学院',
          isSubShow: false,
        },
        {
          name: '研究生院',
          isSubShow: false,
        },
        {
          name: '科研机构',
          isSubShow: false,
        },
        {
          name: '教辅机构',
          isSubShow: false,
        },
        {
          name: '后勤机构',
          isSubShow: false,
        },
      ],
    }
  },
  methods: {
    showToggle: function (item) {
      item.isSubShow = !item.isSubShow
    },
    visual(a, b) {
      if (b == 2) {
        // 传递参数
        let routerJump = this.$router.resolve({ path: '/visual' })
        window.open(routerJump.href, '_black')
      }
    },
  },
}
</script>

<style scoped>
.facNav-container {
  display: flex;
}
.content {
  width: 800px;
  margin-left: 50px;
}
.title1 {
  border: #99a9bf solid 2px;
  width: 14rem;
  color: white;
  background: #861600;
}
.title1 > span {
  padding-left: 2.5rem;
  font-size: 20px;
  height: 50px;
  line-height: 50px;
}
p:hover {
  color: #861600;
  background-color: #eeeeee;
}
.nav {
  width: 14rem;
  height: 35rem;
  border: 2px solid #ddd;
  overflow: scroll;
  overflow-x: hidden;
}
ul {
  height: auto;
}
.nav .nav_ul p {
  border: 1px solid #fff;
  padding: 0.7rem 0;
  padding-left: 0.6rem;
  text-indent: 30px;
}
.nav .nav_ul .nav_ul_ul p {
  text-indent: 50px;
}
.subItem:hover {
  background: #eeeeee;
}
.item {
  border-bottom: #ddd solid 1px;
}
</style>

<template>
  <div class="container">
    <!-- 头部 -->
    <div class="header">
      <parthead></parthead>
    </div>

    <div class="content">
      <div class="box">
        <!-- 左侧导航栏 -->
        <div class="left">
          <div class="left_title">
            <span>首页</span>
          </div>
          <ul class="sub_nav">
            <li class="sub_navli" v-for="(item, index) in representative" :key="index" @click="toChange(item.name)">
              <router-link
                :to="{
                  path: '/messageDetail/content',
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

        <!-- 右侧内容栏 -->
        <div class="right">
          <group :item="list" />
        </div>
      </div>
    </div>

    <!-- 底部 -->
    <div class="footer">
      <partfoot></partfoot>
    </div>
    <!-- /底部 -->
  </div>
</template>

<script>
import parthead from '../../components/index/index_Header.vue'
import partfoot from '../../components/index/index_footer.vue'
import partnew from '../../components/faculty/faculty_united_front_group.vue'
import group from '../../components/faculty/faculty_united_front_group.vue'

import{reqSearchArticle,reqGetArticle} from '@/api/fileData/politics'
export default {
  data() {
    return {
      representative: [
        {
          name: '通知公告',
          standard: '通知公告',
          content: [
            {
              title: '通知公告',
              time: '2022/4/23',
            },
            {
              title: '通知公告',
              time: '2022/4/23',
            },
            {
              title: '通知公告',
              time: '2022/4/23',
            },
          ],
        },
        {
          name: '统战动态',
          standard: '统战动态',
          content: [
            {
              title: '统战动态',
              time: '2022/4/23',
            },
            {
              title: '政协委员XXXXXXXXXXXX',
              time: '2022/4/23',
            },
            {
              title: '政协委员XXXXXXXXXXXX',
              time: '2022/4/23',
            },
          ],
        },
        {
          name: '党派园地',
          standard: '党派园地',
          content: [
            {
              title: '其他代表人士XXXXXXXXXXXX',
              time: '2022/4/23',
            },
            {
              title: '其他代表人士XXXXXXXXXXXX',
              time: '2022/4/23',
            },
            {
              title: '其他代表人士XXXXXXXXXXXX',
              time: '2022/4/23',
            },
          ],
        },
      ],
      list: [],
      // 页码
      p: {
        current: 1,
        number:13
      },
      //查询类型
      showTable:{
        searchValue:''
      }
    }
  },
  components: {
    parthead,
    partfoot,
    partnew,
    group,
  },
  methods: {
    /*
     * 这里获取所有的文章的目的是获得全部文章的数量并作为默认请求的数量
     * 原因：之前后端人员返回数据中未返回 相应文章总数
     * 
     */
    async getAllArticle() {
      try {
        let result = await reqGetArticle(this.p)
        this.p.number=result.totalNum
      } catch (error) {
        console.log(error);
      }
    },
    //默认获取获取通知公告文章
    async getSearchArticle() {
      try {
        this.showTable.searchValue='通知公告'
        let result = await reqSearchArticle(this.showTable, this.p)
        this.list=result.Article
      } catch (error) {
        console.log(error);
      }
    },
    //获取对应模块的文章
    async toChange(name) {
      try {
        this.showTable.searchValue = name
        let result=await reqSearchArticle(this.showTable, this.p)
        this.list=result.Article
      } catch (error) {
       console.log(error); 
      }
    },
  },
  mounted() {
    this.getAllArticle()
    this.getSearchArticle()
  },
}
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

<template>
  <div class="header_container">
    <div class="wrapper_header">
      <div class="inner">
        <div class=" clearfix">
            <!--<div class="head-left">            
            <div class="searchBox" portletmode="search">
              <div class="wp-search clearfix">
                <el-input placeholder="站内搜索" v-model="input"> </el-input>
                <el-button
                  icon="el-icon-search"
                  circle
                  @click="sendInput"
                ></el-button>
              </div>
            </div>
          </div>-->
        </div>
      </div>
    </div>

    <!-- 导航栏 -->
    <div class="nav clear">
      <div class="wrapper">
        <ul class="nav-menu" role="nav" aria-label="导航">
          <li class="menu-item">
            <a href="https://www.gdou.edu.cn/" target="_blank"><span class="spanlink">学校官网</span></a>
          </li>
          <li class="menu-item">
            <router-link to="/index"
              ><span class="spanlink">首页</span></router-link
            >
          </li>
          <li class="menu-item i">
            <router-link
              :to="{
                path: '/depintroduction',
                query: {
                  content: departintro[0].content,
                  name: departintro[0].name,
                },
              }"
            >
              <a href="#" class="spanlink">部门介绍</a>
            </router-link>
            <!-- <ul class="sub-menu" style="display: none">
              <li class="sub-item" v-for="item in departintro">
                <router-link
                  :to="{
                    path: '/depintroduction',
                    query: {
                      content: item.content,
                      name: item.name,
                    },
                  }"
                >
                  <span>{{ item.name }}</span>
                </router-link>
              </li>
            </ul> -->
          </li>
          <li class="menu-item i">
            <router-link
              :to="{
                path: '/ufsystem',
                query: {
                  content: democratic[0].content,
                  name: democratic[0].name,
                  regimen: democratic[0].regimen,
                  brief: democratic[0].brief,
                },
              }"
            >
              <a href="#" class="spanlink" target="_self" @mouseover="hover"
                >民主党派<em class="menu-switch-arrow"></em
              ></a>
            </router-link>

            <!-- <ul class="sub-menu" style="display: none">
              <li class="sub-item" v-for="item in democratic">
                <router-link
                  :to="{
                    path: '/ufsystem',
                    query: {
                      content: item.content,
                      name: item.name,
                    },
                  }"
                  ><span>{{ item.name }}</span>
                </router-link>
              </li>
            </ul> -->
          </li>
          <li class="menu-item">
            <router-link
              :to="{
                path: '/faculty',
                query: {
                  content: independents,
                  name: name1,
                  wudangpai: wudangpai,
                },
              }"
            >
              <a href="#" class="spanlink">无党派人士</a>
            </router-link>
          </li>
         <!-- <li class="menu-item i">
             <router-link
              :to="{
                path: '/partpolitics',
                query: {
                  content: politics[0].content,
                  name: politics[0].name,
                  partpolitics: partpolitics,
                },
              }"
            >
              <a href="#" class="spanlink">参政议政</a>
            </router-link>
            <ul class="sub-menu" style="display: none">
              <li class="sub-item" v-for="item in politics">
                <router-link
                  :to="{
                    path: '/partpolitics',
                    query: {
                      content: item.content,
                      name: item.name,
                    },
                  }"
                >
                  <span>{{ item.name }}</span>
                </router-link>
              </li>
            </ul> 
          </li>-->
          <!--<li class="menu-item">
            <router-link to="/knowledge">
              <a href="#" class="spanlink">统战知识</a>
            </router-link>
          </li>-->
          <li class="menu-item">
            <router-link
              :to="{
                path: '/download',
                query: {
                  download: download,
                  name: name0,
                },
              }"
            >
              <a href="#" class="spanlink" style="border-right: 1px solid #fff"
                >下载专区</a
              >
            </router-link>
          </li>
        </ul>
      </div>
    </div>
    <!-- /导航栏 -->
  </div>
</template>

<script>
export default {
  data() {
    return {
      name0: "下载专区",
      name1: "无党派人士",
      name2: "部门介绍",
      wudangpai: [],
      download: [],
      partpolitics: [],
      independents: [
        {
          title: "南京市委统战部已认定的南京大学无党派代表人士",
          releaseTime: "2022-4-24",
        },
        {
          title: "江苏省委统战部认定的南京大学无党派代表人士",
          releaseTime: "2022-4-24",
        },
        {
          title: "关于无党派人士是如何界定的?",
          releaseTime: "2022-4-24",
        },
      ],
      democratic: [
        {
          name: "中国国民党革命委员会",
          content: [
            {
              title: "中国国民党革命委员会XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "中国国民党革命委员会XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "中国国民党革命委员会XXXXXXXXXXXX",
              time: "2022-4-23",
            },
          ],
          regimen:
            "民革上海交通大学委员会的前身是民革上海交通大学支部，是民革上海市委的直属支部。支部建立前有2名党员：郑家俊和凌霜。1986年4月9日建立民革上海交大支部，至2012年9月已换届7次。\n       第一届（1986年）支委会由凌霜任主委。委员：毛增滇。当时支部成员5人，即凌霜、何绍诗、毛增滇、顾婉华与郑怡红；\n       第二届（1990年-1993年）支部委员3人，主任委员：毛增滇，委员：马波、何晋璋，当时支部成员13人；\n       第三届（1993年-1996年）支部委员3人，主任委员：毛增滇，委员：何晋璋、梁美训，当时支部成员16人；\n       第四届（1996年-2000年）支部委员3人，主任委员：毛人杰，委员：梁美训、罗次申，当时支部成员19人；\n       第五届（2000年-2003年）支部委员4人，主任委员：毛人杰，副主任委员：梁美训，委员罗次申、沈璋华，当时支部成员22人；\n       第六届（2003年2月-2012年9月）支部委员4人，主任委员罗次申，副主任委员沈璋华，委员黄飚、林涛，当时支部成员28人；",
          brief:
            "中国国民党革命委员会（简称“民革”）是具有政治联盟性质的、致力于建设中国特色社会主义和祖国统一事业的政党，是中国共产党领导的多党合作和政治协商制度中的中国特色社会主义参政党，由原中国国民党民主派和其他爱国人士所创建，于1948年1月1日在香港成立。",
        },
        {
          name: "中国民主同盟会",
          content: [
            {
              title: "中国民主同盟XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "中国民主同盟XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "中国民主同盟XXXXXXXXXXXX",
              time: "2022-4-23",
            },
          ],
        },
        {
          name: "中国民主建国会",
          content: [
            {
              title: "中国民主建国会XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "中国民主建国会XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "中国民主建国会XXXXXXXXXXXX",
              time: "2022-4-23",
            },
          ],
        },
        {
          name: "中国民主促进会",
          content: [
            {
              title: "中国民主促进会XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "中国民主促进会XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "中国民主促进会XXXXXXXXXXXX",
              time: "2022-4-23",
            },
          ],
        },
        {
          name: "中国农工民主党",
          content: [
            {
              title: "中国农工民主党XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "中国农工民主党XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "中国农工民主党XXXXXXXXXXXX",
              time: "2022-4-23",
            },
          ],
        },
        {
          name: "中国致公党",
          content: [
            {
              title: "中国致公党XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "中国致公党XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "中国致公党XXXXXXXXXXXX",
              time: "2022-4-23",
            },
          ],
        },
        {
          name: "九三学社",
          content: [
            {
              title: "九三学社XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "九三学社XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "九三学社XXXXXXXXXXXX",
              time: "2022-4-23",
            },
          ],
        },
      ],
      politics: [
        {
          name: "人大代表",
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
      departintro: [
        {
          name: "部门概述",
          content:
            "统战部是学校党委主管统战工作的职能部门, 主要负责党的统一战线方针政策在学校的贯彻落实，履行了解情况、掌握政策、调整关系、安排人事、增进共识、加强团结职能，联系和团结校内广大党外人士，围绕党的中心工作和学校事业发展大局，开展统一战线各领域工作。",
        },
        {
          name: "主要职责",
          content:
            "主要职责：\n       1．在学校党委领导下，学习宣传和贯彻落实党的统一战线工作方针、政策，提出开展全校统战工作的意见和建议；建立健全学校统一战线工作机制，完善工作制度；统筹协调全校统战工作，加强对基层统战工作的指导和督促检查。\n       2．协助建立和落实学校党员领导干部与党外人士联谊交友制度，配合学校党委召开校情通报会、双月座谈会等, 听取党外代表人士对学校工作的意见和建议，鼓励他们为国家和学校的发展建言献策。\n       3．指导、支持各民主党派和统战团体加强思想、组织、制度和领导班子建设，鼓励他们围绕学校中心工作，独立自主地开展工作；发挥民主党派、无党派人士参政议政和参与民主管理、民主监督的作用。\n       4．做好党外知识分子思想政治工作，重点做好有影响、有代表性的党外知识分子凝聚、引导、服务等工作。\n       5．做好党外后备干部和党外代表人士培养、选拔、推荐工作，做好党外代表人士的政治安排、实职安排和挂职锻炼工作，扎实推进党外代表人士队伍建设。",
        },
        {
          name: "机构设置",
          content:
            "统战部是学校党委主管统战工作的职能部门，主要负责党的统一战线方针政策在学校的贯彻落实，履行了解情况、掌握政策、调整关系、安排人事、增进共识、加强团结职能，联系和团结校内广大党外人士，围绕党的中心工作和学校事业发展大局，开展统一战线各领域工作。",
        },
      ],
      input: "",
    };
  },
  methods: {
    hover() {
      this.$nextTick(() => {
        let liTags = document.querySelectorAll(".wrapper > ul > .i");
        for (let i = 0; i < liTags.length; i++) {
          liTags[i].onmouseover = function (e) {
            let li = e.currentTarget;
            li.classList.add("hover");
            // this.getElementsByClassName('sub-menu')[0].style.display = 'block'
          };
          liTags[i].onmouseout = function (e) {
            let li = e.currentTarget;
            li.classList.remove("hover");
            // this.getElementsByClassName('sub-menu')[0].style.display = 'none'
          };
        }
      });
    },
    sendInput() {
      if (this.input === "") {
        alert("请输入搜索关键词");
        return;
      }
      this.$router.push("/searchPage?search=" + this.input);
    },
  },
  // created() {
  //   // this.$axios.get('http://localhost:9102/servicearticle/article/article/queryArticleByPosition?position=无党派人士').then((res) => {
  //   //   this.wudangpai = res.data.t
  //   // })
  //   // this.$axios
  //   //   .get("http://localhost:9104/servicefile/filedownload/file/fileselectAll")
  //   //   .then((res) => {
  //   //     this.download = res.data;
  //   //     // console.log('请求下载文件')
  //   //     // console.log(res.data)
  //   //   });
  //   //获取无党派人士的数据
  //   //this.$axios.get('http://localhost:9102/servicearticle/article/article/queryArticleByType?type=人大代表').then((res) => {
  //     // console.log('参政议政信息')
  //     // console.log(res);
  //     // console.log(res.data.t);
  //     // console.log(res.data.t)
  //     //this.partpolitics = res.data.t
  //   //})
  // },
};
</script>

<style scoped>
.header_container {
  width: 100%;
  min-width: 1081px;
  background-position: center center;
}
.wrapper_header {
  background: url(../../assets/img/IndexImg/背景2.png) no-repeat center;
  background-size: contain;
  width: 100%;
  margin: 0 auto;
}
.inner {
  width: 100%;
  margin: 0 auto;
  position: relative;
  height: 19vh;
}

.head-left {
  float: left;
  width: 40%;
  margin-top: 5vh;
}
.sitelogo img {
  width: 100%;
  /* padding: 3vh 0px; */
}

.searchBox {
  /* position: absolute;
  top: 13vh;
  width: 20%; */
  text-align: right;
  margin-top: 1vh;
  width: 55%;
}
.wp-search {
  position: relative;
}
::v-deep .el-input {
  font-size: 14px;
  width: 100%;
  position: initial;
}
::v-deep .el-input__inner {
  border-radius: 20px;
  background-color: #f4f9ff;
}

::v-deep .el-button.is-circle {
  position: absolute;
  right: 0px;
  padding: 12px;
  border-top-right-radius: 50%;
  border-top-left-radius: 0%;
  border-bottom-right-radius: 50%;
  border-bottom-left-radius: 0%;
}

::v-deep .el-button {
  background: #99d8ff;
  border: 1px solid #99d8ff;
}

::v-deep .el-icon-search {
  color: #fff;
}
::v-deep .el-button:focus,
.el-button:hover {
  color: #99d8ff;
  border-color: #99d8ff;
  background-color: #99d8ff;
}
.clearfix:after {
  clear: both;
  content: ".";
  display: block;
  height: 0;
  visibility: hidden;
}

.nav {
  background-color: #BD3124;
  height: 60px;
  line-height: 60px;
  min-width: 1081px;
}
.nav .wrapper {
  position: relative;
  z-index: 4;
}
.wrapper {
  max-width: 1200px;
  margin: 0 auto;
}
.nav .wrapper .nav-menu {
  overflow: hidden;
}
.nav .menu-item {
  float: left;
  width: 16%;
  text-align: center;
}
.nav .menu-item .spanlink:hover,
.nav .menu-item.on .spanlink {
  background-color: #611000;
  color: #eee;
}
.nav .menu-item .spanlink {
  display: block;
  font-size: 20px;
  text-align: center;
  color: #fff;
  position: relative;
  border-left: 1px solid #fff;
}
.nav-menu .menu-item {
  display: inline-block;
  position: relative;
}

.nav-menu .menu-item span > .menu-switch-arrow {
  display: none;
  width: 20px;
  height: 20px;
  background: url("../../assets/img/Icon/nav_j.png") no-repeat center center;
  vertical-align: middle;
}
.sub-menu {
  display: none;
  position: absolute;
  left: 0;
  top: 60px;
  min-width: 100%;
  z-index: 100;
  background: #fff;
}
.sub-menu .sub-item {
  position: relative;
  white-space: nowrap;
  vertical-align: top;
}
.sub-menu .sub-item span {
  display: block;
  color: #000;
  height: 40px;
  line-height: 40px;
  padding: 0 10px;
  font-size: 14px;
  background: none;
  text-align: center;
}
.sub-menu .sub-item.hover span,
.sub-menu .sub-item span:hover {
  color: #fff;
  background-color: #861600;
  display: block;
}
.hover {
  display: block;
  overflow: hidden;
  height: 364px;
  margin-top: 0px;
  margin-bottom: 0px;
  padding-top: 0px;
  padding-bottom: 0px;
}
.clear {
  clear: both;
}
</style>

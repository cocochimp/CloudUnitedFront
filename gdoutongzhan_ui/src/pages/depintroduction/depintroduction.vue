<template>
  <div class="dep-container">
    <!-- 头部 -->
    <div class="header">
      <dowhead></dowhead>
    </div>
    <!-- /头部 -->

    <!-- 子网页内容开始 -->
    <div class="content">
      <div class="box">
        <!--部门介绍-->
        <!-- 左侧导航栏 -->
        <div class="left">
          <div class="left_title">
            <span>部门介绍</span>
          </div>
          <ul class="sub_nav">
            <li class="sub_navli" v-for="item in department">
              <router-link
                :to="{
                  path: '/depintroduction/content',
                  query: {
                    content: item.content,
                    name: item.name,
                  },
                }"
              >
                <p>{{ item.name }}</p>
              </router-link>
            </li>
          </ul>
        </div>

        <!-- 右侧内容栏 -->
        <div class="right">
          <dowdepintro />
          <!-- <router-view></router-view> -->
        </div>
      </div>

      <!--      <div class="box">-->
      <!--        &lt;!&ndash; 左侧导航栏 &ndash;&gt;-->
      <!--        <div class="left">-->
      <!--           <dowleftnav />-->
      <!--        </div>-->
      <!--        &lt;!&ndash; /左侧导航栏 &ndash;&gt;-->

      <!--        &lt;!&ndash; 右侧内容栏 &ndash;&gt;-->
      <!--        <div class="right">-->
      <!--          <div class="group-container">-->
      <!--            <downew />-->
      <!--          </div>-->
      <!--        </div>-->
      <!--        &lt;!&ndash; /右侧内容栏 &ndash;&gt;-->
      <!--      </div>-->
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
import dowhead from '../../components/index/index_Header.vue'
import dowfoot from '../../components/index/index_footer.vue'
import dowleftnav from '../../components/faculty/faculty_college_navigator.vue'
import downew from '../../components/faculty/faculty_united_front_group'
import dowdepintro from '../../components/depintroduction/depintroduction_right.vue'
export default {
  data() {
    return {
      department: [
        {
          name: '部门概述',
          content: '统战部是学校党委主管统战工作的职能部门，主要负责党的统一战线方针政策在学校的贯彻落实，履行了解情况、掌握政策、调整关系、安排人事、增进共识、加强团结职能，联系和团结校内广大党外人士，围绕党的中心工作和学校事业发展大局，开展统一战线各领域工作。',
        },
        {
          name: '主要职责',
          content:
            '主要职责：\n       1．在学校党委领导下，学习宣传和贯彻落实党的统一战线工作方针、政策，提出开展全校统战工作的意见和建议；建立健全学校统一战线工作机制，完善工作制度；统筹协调全校统战工作，加强对基层统战工作的指导和督促检查。\n       2．协助建立和落实学校党员领导干部与党外人士联谊交友制度，配合学校党委召开校情通报会、双月座谈会等, 听取党外代表人士对学校工作的意见和建议，鼓励他们为国家和学校的发展建言献策。\n       3．指导、支持各民主党派和统战团体加强思想、组织、制度和领导班子建设，鼓励他们围绕学校中心工作，独立自主地开展工作；发挥民主党派、无党派人士参政议政和参与民主管理、民主监督的作用。\n       4．做好党外知识分子思想政治工作，重点做好有影响、有代表性的党外知识分子凝聚、引导、服务等工作。\n       5．做好党外后备干部和党外代表人士培养、选拔、推荐工作，做好党外代表人士的政治安排、实职安排和挂职锻炼工作，扎实推进党外代表人士队伍建设。',
        },
        {
          name: '机构设置',
          content:
            '                                                             广东海洋大学党委统战部\n 党委常委、部长 侨务办公室主任\n电话：131231251\nEmail：xxxxx@gdou.edu.cn\n\n 副部长\n电话：553564352\nEmail：xxxg@gdou.edu.cn\n\n 民主党派工作办公室 主任\n电话：65123132\nEmail：xxx@gdou.edu.cn',
        },
      ],
    }
  },
  components: {
    dowhead,
    dowfoot,
    dowleftnav,
    downew,
    dowdepintro,
  },
}
</script>

<style scoped>
/*.box {*/
/*  width: 1056px;*/
/*  margin: 0 auto;*/
/*  padding: 25px;*/
/*  background-color: #fff;*/
/*  margin-bottom: 30px;*/
/*}*/
/*.left {*/
/*  float: left;*/
/*  width: 14rem;*/
/*  height: 40rem;*/
/*}*/
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
/*.left {*/
/*  float: left;*/
/*  width: 14rem;*/
/*  height: 40rem;*/
/*}*/
/*.right {*/
/*  margin-left: 16.5rem;*/
/*  width: 50rem;*/
/*  height: 40rem;*/
/*}*/
.right {
  margin-left: 16.5rem;
  width: 50rem;
  height: 40rem;
}
</style>

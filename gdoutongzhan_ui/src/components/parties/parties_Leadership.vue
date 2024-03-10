<template>
  <div >
    <div class="sub_leadership" v-if="$route.query.people">
      <div class="sub_smalltitle">
        <span>领导班子</span>
      </div>
      <div class="wrapper">
        <ul class="sub_nav">
          <li class="sub_navli">
            <p class="active" href="#" @click="openmenu">基本委员组成</p>
            <a href="javascript:void(0);" class="skipbtn"></a>
            <ul class="sub_sub_nav" style="display: block">
              <li v-for="item in $route.query.people">{{item.title}}： {{item.nums}}</li>

            </ul>
          </li>
          <li class="sub_navli">
            <p href="#" @click="openmenu">责任、义务</p>
            <a href="javascript:void(0);" class="skipbtn"></a>
            <ul class="sub_sub_nav">
              <p>{{$route.query.duty}}</p>
            </ul>
          </li>
          <li class="sub_navli">
            <p href="#" @click="openmenu">制度</p>
            <a href="javascript:void(0);" class="skipbtn"></a>
            <ul class="sub_sub_nav">
              <p>{{$route.query.regimen}}</p>
            </ul>
          </li>
        </ul>
      </div>
    </div>
    <div v-else class="nothing">暂时没有成员信息哦</div>


    <div class="sub_introduction clearfix" v-if="$route.query.brief">
      <div class="head">
        <span class="tag">简介</span>
        <span class="position">当前位置：<router-link to="/index">首页</router-link> | 中国民主同盟 </span>
      </div>
      <div class="line">
        <div class="line_short"></div>
      </div>
      <div class="sub_content">
      <span class="sub_about">
        <p style="text-indent: 2em; padding-top: 1rem; font-size: 16px">
          {{$route.query.brief}}
        </p>
      </span>
      </div>
    </div>
    <div v-else class="nothing">暂时没有简介信息哦</div>

  </div>

</template>

<script>
import $ from 'jquery'

export default {
  data(){
    return{
      member:['主任委员','副主任委员','委员']
    }
  },
  created() {
    this.openmenu()
  },
  methods: {
    //领导班子打开菜单关闭其他菜单
    openmenu() {
      this.$nextTick(() => {
        let $container = $('.sub_sub_nav'),
          $trigger = $('.sub_navli') // 分别获取所有的“父子”
        $container.hide() // 隐藏所有的“子”
        $trigger.first().find('.sub_sub_nav').show() // 显示第一个“父”的子（展开第一个）
        $trigger.on('click', function (e) {
          // 当“父”发生点击事件
          if ($(this).find('.sub_sub_nav').is(':hidden')) {
            $trigger.find('.sub_sub_nav').hide(0) // 关闭其他
            $(this).find('.sub_sub_nav').show(0) // 显示自己
          }
          e.preventDefault()
        })
        //在同级
        $('wrapper p').bind('click', function () {
          $(this).addClass('active').siblings().removeClass('active')
        })
        //不在同级
        $('p').bind('click', function () {
          $('p').removeClass('active')
          $(this).addClass('active')
        })
      })
    },
  },
}
</script>

<style scoped>
.nothing{
  margin-left: 5rem;
  margin-bottom: 3rem;
}
.sub_leadership {
  width: 55rem;
  margin-left: 2rem;
  padding-top: 1rem;
  position: relative;
  /*width: 100%;*/
  /*height: 100%;*/
  overflow: hidden;
}
.sub_smalltitle {
  padding-bottom: 1rem;
}
.sub_smalltitle span {
  width: 6rem;
  height: 2rem;
  background-color: #861600;
  text-align: center;
  line-height: 2rem;
  margin-bottom: 0.3rem;
  color: white;
  font-size: 20px;
  padding: 0.3rem 1rem;
}
.sub_nav {
  border: 1px solid #ddd;
}
.sub_leadership .sub_nav li {
  position: relative;
}
.sub_nav li p.active,
.sub_nav li p:hover {
  color: black;
}
.sub_nav li p {
  font-size: 16px;
  display: block;
  padding: 0.7rem 0;
  padding-left: 0.6rem;
  transition: all 0.4s ease-in-out;
}
.sub_leadership .sub_nav li a.skipbtn {
  border: none;
  margin: 0;
  padding: 0;
  display: block;
  width: 40px;
  height: 45px;
  position: absolute;
  right: 1px;
  top: 0px;
  background: url('../../assets/img/Icon/arrow_down.png') no-repeat center;
  margin: 0;
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
.sub_introduction {
  margin-top: 7rem;
  margin-left: 2rem;
}
.sub_content {
  height: 11.6rem;
  overflow-x: hidden;
  max-height: 11.6rem;
  line-height: 2rem;
  display: inline-block;
}
.clearfix:after {
  content: '.';
  display: block;
  height: 0;
  clear: both;
  visibility: hidden;
}

.position {
  font-size: 13px;
  color: #9e9e9e;
  display: inline-block;
  float: right;
  line-height: 3rem;
}

.tag {
  display: inline-block;
  text-align: left;
  color: #AF090B;
  font-weight: 600;
  width: 80px;
  padding-bottom: 10px;
  border-radius: 3px;
  font-size: 20px;
}
.line{
  background: #96A0A9;
  height: 2px;
  position: relative;
  margin-top: 5px;
  width: 100%;
}
.line_short{
  background: #AF090B;
  height: 2px;
  width: 50px;
  /*border: solid 2px palevioletred;*/
  position: absolute;
  top: 0;
  left: 0;
}
.position {
  font-size: 12px;
  color: #9e9e9e;
  display: inline-block;
  float: right;
  line-height: 3rem;
}
</style>

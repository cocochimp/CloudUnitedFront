<template>
  <div>
    <div class="sub_introduction clearfix">
      <div class="head">
        <!-- <span class="tag">{{ $route.query.name }}</span> -->
        <span class="tag">简介</span>
        <span class="position"
          >当前位置：<router-link to="/index">首页</router-link> |
          {{ $route.query.name }}
        </span>
      </div>
      <div class="line">
        <div class="line_short"></div>
      </div>
      <div class="sub_content">
        <span class="sub_about">
          <p style="text-indent: 2em; padding-top: 1rem; font-size: 16px">
            {{ $route.query.brief }}
          </p>
        </span>
      </div>
    </div>

  </div>
</template>

<script>
import $ from 'jquery'
export default {
  props: ['leaderShip'],
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
.sub_leadership {
  padding-top: 1rem;
  position: relative;
  width: 100%;
  height: 100%;
  overflow: hidden;
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
  height: 13rem;
  max-height: 13rem;
  line-height: 3rem;
  overflow: auto;
  overflow-x: hidden;
  background: #f5f5f5;
  padding-left: 1rem;
}
.sub_sub_nav p {
  text-indent: 2em;
  line-height: 2rem;
  white-space: pre-wrap;
  word-wrap: break-word;
}
.sub_introduction {
  margin-top: 1rem;
  /* margin-left: 2rem; */
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
  /* display: block; */
  height: 0;
  clear: both;
  visibility: hidden;
}

.position {
  font-size: 12px;
  color: #9e9e9e;
  display: inline-block;
  float: right;
  line-height: 3rem;
}

.tag {
  display: inline-block;
  text-align: left;
  color: #af090b;
  font-weight: 600;
  /*width: 160px;*/
  padding-bottom: 10px;
  border-radius: 3px;
  font-size: 20px;
}

.line {
  background: #96a0a9;
  height: 2px;
  position: relative;
  margin-top: 5px;
  width: 100%;
  margin-bottom: 10px;
}
.line_short {
  background: #af090b;
  height: 2px;
  width: 200px;
  /*border: solid 2px palevioletred;*/
  position: absolute;
  top: 0;
  left: 0;
}
.showName {
  margin-right: 10px;
}
</style>

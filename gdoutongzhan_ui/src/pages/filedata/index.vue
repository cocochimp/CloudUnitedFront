<template>
  <el-container class="home-container">
      <!-- 头部区域 -->
      <el-header>
          <div class="header_logo">
              <img src="../../assets/img/logo.png" alt="">
              <span>海大云统战</span>
          </div>
          <div class="header_right">
                <div class="userinfo">
                  <img src="../../assets/img/bigSummary/用户-圆.png" alt="">
                  <p>当前用户:{{user}}</p>
                </div>
                <div class="help">
                  <img src="../../assets/img/bigSummary/空心问号.png" alt="">
                  <p>用户指南</p>
                </div>
                <div class="exit" @click="logout">
                  <img src="../../assets/img/bigSummary/退出.png" alt="">
                  <p>退出</p>
                </div>
          </div>
      </el-header>
      <!-- 页面主体区域 -->
      <el-container>
      <!-- 侧边栏 -->
          <el-aside :width="isCollapse ? '64px' : '200px'">
              <div class="toggle-button" @click="toggleCollapse">|||资料库</div>
              <!-- 侧边栏菜单区域 -->
              <!-- router表示以每个菜单的index作为路由进行跳转 -->
              <el-menu
                background-color="#282b34"
                text-color="#fff"
                active-text-color="#409EFF" 
                unique-opened 
                :collapse="isCollapse" 
                :collapse-transition="false" 
                router 
                :default-active="activePath"
                >
                <el-submenu index="3">
                  <template slot="title">
                    <!-- <i class="el-icon-s-order"></i> -->
                    <span>资料管理</span>
                  </template>
                  <el-menu-item-group>
                    <el-menu-item index="reward" >获奖</el-menu-item>
                    <el-menu-item index="homePageArticle">门户网站文章</el-menu-item>
                    <el-menu-item index="homePagePicture">门户网站轮播图</el-menu-item>
                    <el-menu-item index="homePageDownload">门户网站下载专区</el-menu-item>
                    <el-menu-item index="fileDataGainArt">统战成果新闻展示</el-menu-item>
                    <el-menu-item index="fileDataGainPic">统战成果轮播图展示</el-menu-item>
                  </el-menu-item-group>
                </el-submenu>
              </el-menu>
          </el-aside>
          <!-- 右侧内容主体 -->
          <el-main>
              <!-- 面包屑导航区域 -->
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/fileWelcome' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>资料管理</el-breadcrumb-item>
            <el-breadcrumb-item>{{this.$route.meta.title}}</el-breadcrumb-item>
            </el-breadcrumb>
            <!-- 路由占位符 -->
            <router-view></router-view>
          </el-main>
      </el-container>
</el-container>
</template>

<script>
export default {
  name: "FileData",
  data(){
    return{
      //是否折叠
      isCollapse:false,
      //被激活的链接地址
      activePath: '',
      user:'超级管理员'
     }
  },
  methods:{
    logout(){
      // window.sessionStorage.clear()
      this.$router.push('/appMainIndex')
    },
      //是否折叠左侧菜单
    toggleCollapse(){
      this.isCollapse=!this.isCollapse
    },
      //保存菜单链接的激活状态
    saveNavState(activePath){
      window.sessionStorage.setItem('activePath', activePath)
      console.log(activePath);
    },
      //获取左侧表单数据
    getMenuList(){
      console.log(1);
    },
    
 },
  created(){
    this.getMenuList()
    this.activePath=window.sessionStorage.getItem('activePath')
  }
}
</script>

<style >
.home-container{
    height:100%
}
.template{
    height: 100%;
}

.el-header{
    background-color: #385a97;
    display: flex;
    justify-content:space-between;
    align-items: center;
}
.el-aside{
    background-color: #2e313c;
}
.el-main{
    background-color: #fff;
}
 .el-menu{
     border-right: none;
 } 


.header_logo{
 color: #fff;
 font-size: 20px;
 display: flex;
 margin-left: 10px;
 justify-content: center;
 align-items: center;
}
.header_logo img{
  width: 40px;
  margin-right: 12px;
}

.header_right{
    color:#fff;
}
.toggle-button{
    background-color: #87878f;
    font-size: 14px;
    line-height: 28px;
    color: #fff;
    text-align: center;
    letter-spacing: 0.2em;
    cursor: pointer;
}

.header_right{
  display: flex;
}
.header_right .userinfo{
  display: flex;
  align-items: center;
  margin-right: 20px;
}
.header_right .userinfo img{
  margin-right: 8px;
    width: 24px;
    height: 24px;
}

.header_right .help{
  display: flex;
  align-items: center;
  margin-right: 20px;
  cursor: pointer;
}
.header_right .help img{
  margin-right: 8px;
    width: 24px;
    height: 24px;
}

.header_right .exit{
  display: flex;
  align-items: center;
  margin-right: 20px;
  cursor: pointer;
}
.header_right .exit img{
  margin-right: 8px;
    width: 24px;
    height: 24px;
}
</style>
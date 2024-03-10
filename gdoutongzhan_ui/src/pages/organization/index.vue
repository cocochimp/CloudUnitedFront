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
              <div class="toggle-button" @click="toggleCollapse">|||组织库</div>
              <!-- 侧边栏菜单区域 -->
              <!-- router表示以每个菜单的index作为路由进行跳转 -->
              <el-scrollbar wrap-class="scrollbar-wrapper">
              <el-menu
                background-color="#282b34"
                text-color="#fff"
                active-text-color="#409EFF" 
                unique-opened 
                :collapse="isCollapse" 
                :collapse-transition="false" 
                router 
                :default-active="activePath">
                <el-menu-item-group>
                  <template slot="title">组织成员展示</template>
                  <!--基层统战侧边栏-->
                    <el-submenu :index="this.grassRoots.path+''">
                  <template slot="title">
                    <item v-if="this.grassRoots.meta" :title="this.grassRoots.meta.title"/>
                  </template>
                  <el-menu-item v-for="(item1) in this.grassRoots.children" :key="item1.path" :index='`/organization`+item1.path' @click="local1(item1)">{{item1.meta.title}}</el-menu-item>
                </el-submenu>
                <!--民主党派侧边栏-->
                 <el-submenu :index="this.democrat.path+''">
                  <template slot="title">
                    <item v-if="this.democrat.meta" :title="this.democrat.meta.title"/>
                  </template>
                  <el-menu-item-group>
                  <el-menu-item v-for="(item2) in this.democrat.children" :key="item2.path" :index='`/organization`+item2.path' @click="local2(item2)">{{item2.meta.title}}</el-menu-item>
                  </el-menu-item-group>
                  </el-submenu>
                  <!--群团组织侧边栏-->
                <el-submenu :index="this.massOrganization.path+''"> 
                    <template slot="title"> 
                    <item v-if="this.massOrganization.meta" :title="this.massOrganization.meta.title"/>
                  </template>
                    <el-menu-item-group>
                  <el-menu-item v-for="(item3) in this.massOrganization.children" :key="item3.path" :index='`/organization`+item3.path' @click="local3(item3)">{{item3.meta.title}}</el-menu-item>
                  </el-menu-item-group>
              </el-submenu>    
              <el-menu-item index="shaoshuminzu">少数民族</el-menu-item>
                <!--参政议政侧边栏-->
                 <el-submenu :index="this.discussAffairs.path+''">
                  <template slot="title">
                    <item v-if="this.discussAffairs.meta" :title="this.discussAffairs.meta.title"/>
                  </template>
                  <el-menu-item-group>
                  <el-menu-item v-for="(item4) in this.discussAffairs.children" :key="item4.path" :index='`/organization`+item4.path' @click="local4(item4)">{{item4.meta.title}}</el-menu-item>>
                  </el-menu-item-group>
                </el-submenu>
                </el-menu-item-group>
                <el-menu-item-group>
                  <template slot="title">组织成员管理</template>
                  <el-menu-item index="orgManagement">组织管理</el-menu-item>

                </el-menu-item-group>
                
              </el-menu>
              </el-scrollbar>
          </el-aside>
          <!-- 右侧内容主体 -->
          <el-main>
              <!-- 面包屑导航区域 -->
            <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/organization/organizationWelcome' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>用户管理</el-breadcrumb-item>
            <el-breadcrumb-item>用户列表</el-breadcrumb-item>
            </el-breadcrumb>
            <!-- 路由占位符 -->
            <router-view v-if="isReloadData"></router-view>
          </el-main>
      </el-container>
</el-container>
</template>

<script>
import axios from 'axios';
import  {callAllMenu} from "../../api/organzationData/Department"
import Item from '../../components/organizationLayout/components/Sidebar/Item.vue';
export default {
  name: "FileData",
  components:{
    Item
},
data(){
     return{
        user:"超级管理员",
        //是否折叠
        isCollapse:false,
        //被激活的链接地址
        activePath:'',
        //左侧表单栏数据
        grassRoots:'',
        democrat:'',
        massOrganization:'',
        discussAffairs:'',
        minNationality:'',
        //自动刷新标识
        isReloadData:true,
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
          window.sessionStorage.setItem('activePath',activePath)
          console.log(activePath);
    },
      //获取左侧表单数据
      getMenuList(){
        callAllMenu().then((res)=>{
          let result = res
          this.grassRoots = result.res1.data.router
          this.democrat = result.res2.data.router
          this.massOrganization = result.res3.data.router
          this.discussAffairs = result.res4.data.router
        })
    },
    //刷新当前页面，在修改数据之后一下子就可以完成指定标签的刷新
    reloadPart(){
      this.isReloadData=false
      this.$nextTick(()=>{
        this.isReloadData=true
      })
    },
    local1(item1){
      localStorage.setItem("department",item1.meta.title)
      this.reloadPart(  )
    },
    local2(item2){
      localStorage.setItem("party",item2.meta.title)
      this.reloadPart(  )
    },
    local3(item3){
      localStorage.setItem("group",item3.meta.title)
      this.reloadPart(  )
    },
    local4(item4){
      localStorage.setItem("category",item4.meta.title)
      this.reloadPart(  )
    },
 },
    
    created(){
      this.getMenuList()
      this.activePath=window.sessionStorage.getItem('activePath')
 }
}
</script>

<style>
.home-container{
    height: 100%;
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
  height: calc(100vh - 60px);
    background-color: #2e313c;
    overflow-x: hidden;
}

.el-aside::-webkit-scrollbar {
     display: none;
}


.el-main{
  overflow-y: hidden;
   height: calc(100vh - 60px);
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
</style>

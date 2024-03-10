<template>
  <div class="main">
    <div class="nav">
      <!-- 路由跳转 -->
      <button @click="showDescion" class="descion"></button>
      <button @click="showWorkPlace" class="workplace"></button>
      <button class="offerAdvice"></button>
      <button @click="showOrganizationDatabase" class="organizationDatabase"></button>
      <button @click="showPersonDatabase" class="personDatabase"></button>
      <button @click="showDetailDatabase" class="detailDatabase"></button>
    </div>
  </div>
</template>

<script>
import { mapGetters,mapActions } from "vuex";
export default {
  name: "AppMain",
  data() {
    return {
    }
  },
  computed: {
    ...mapGetters(["addRoutes"]),
  },
 async created(){
   await this.$store.dispatch('permission/generateRoutes');
  },
  methods: {
    ...mapActions(["permission/generateRoutes"]),
    showDescion() {
      var i=0
      for( i=0;i<this.addRoutes.length;i++){
        if(this.addRoutes[i].path==="/metadata"){
          this.$router.push(this.addRoutes[i].path);
          break;
        }
        else if(i===this.addRoutes.length-1){
          this.$alert('对不起，您没有进入决策中心的权限',  {
          confirmButtonText: '确定',
        });
        }
      }
    },
    showWorkPlace() {
      var i=0
      for( i=0;i<this.addRoutes.length;i++){
        if(this.addRoutes[i].path==="/workplace"){
          this.$router.push(this.addRoutes[i].path);
          break;
        }
        else if(i===this.addRoutes.length-1){
          this.$alert('对不起，您没有进入业务工作平台的权限',  {
          confirmButtonText: '确定',
        });
        }
      }
    },
    showPersonDatabase() {
      var i=0
      for( i=0;i<this.addRoutes.length;i++){
        if(this.addRoutes[i].path==="/teacher"){
          this.$router.push(this.addRoutes[i].path);
          break;
        }
        else if(i===this.addRoutes.length-1){
          this.$alert('对不起，您没有进入人物库的权限',  {
          confirmButtonText: '确定',
        });
        }
      }   
    },
    showOrganizationDatabase() {
      var i=0
      for( i=0;i<this.addRoutes.length;i++){
        if(this.addRoutes[i].path==="/organization"){
          this.$router.push(this.addRoutes[i].path);
          break;
        }
        else if(i===this.addRoutes.length-1){
          this.$alert('对不起，您没有进入组织库的权限',  {
          confirmButtonText: '确定',
        });
        }
      }
    },
    showDetailDatabase() {
      var i=0
      for( i=0;i<this.addRoutes.length;i++){
        if(this.addRoutes[i].path==="/filedata"){
          this.$router.push(this.addRoutes[i].path);
          break;
        }
        else if(i===this.addRoutes.length-1){
          this.$alert('对不起，您没有进入资料库的权限',  {
          confirmButtonText: '确定',
        });
        }
      }
    },
  },
};
</script>

<style scoped>
.main {
  position: relative;
  bottom: 120px;
  left: 495px;
  width: 545px;
  height: 550px;
}

/* 左侧样式 */

.nav {
  width: 540px;
  height: 550px;
}

.descion {
  width: 545px;
  height: 183px;
  background-image: url("../../assets/img/bigSummary/统战决策中心.png");
  background-size: 100%;
  border-radius: 20px;
  cursor: pointer;
}

.workplace {
  position: relative;
  top: 10px;
  width: 265px;
  height: 183px;
  background-image: url("../../assets/img/bigSummary/分组\ 10.png");
  background-size: 101%;
  border-radius: 20px;
  cursor: pointer;
}

.offerAdvice{
  position: relative;
  top: 10px;
  left: 15px;
  width: 265px;
  height: 183px;
  background-image: url("../../assets/img/bigSummary/分组\ 11.png");
  background-size: 101% ;
  border-radius: 20px;
  cursor: pointer;
}
.organizationDatabase {
  position: relative;
  top: 20px;
  width: 169px;
  height: 169px;
  background-image: url("../../assets/img/bigSummary/组织库.png");
  background-size: 100%;
  border-radius: 20px;
  cursor: pointer;
}

.personDatabase {
  position: relative;
  left: 20px;
  top: 20px;
  width: 169px;
  height: 169px;
  background-image: url("../../assets/img/bigSummary/人物库.png");
  background-size: 100%;
  border-radius: 20px;
  cursor: pointer;
}

.detailDatabase {
  position: relative;
  left: 39px;
  top: 20px;
  width: 169px;
  height: 169px;
  background-image: url("../../assets/img/bigSummary/资料库.png");
  background-size: 100%;
  border-radius: 20px;
  cursor: pointer;
}
</style>
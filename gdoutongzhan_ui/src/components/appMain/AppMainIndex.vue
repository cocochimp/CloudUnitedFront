<template>
  <div class="content">
     <Navbar/>
     <AppMain/>
  </div>
</template>

<script>
import AppMain from './AppMain.vue'
import Navbar from './Navbar.vue'


export default {
  components: { Navbar ,AppMain},
 name:'AppMainIndex',
}
</script>

<style scoped>
* {
    margin: 0;
    padding: 0;
}

.content {
   background: url(../../assets/img/IndexImg/13.gif) no-repeat;
    background-size:cover;
    width: 100%!important;
    background-position: 0 0;
    height: 100%;
}
</style>
<template>
  <div>
    <div class="scroll-container">
      <div class="swiper">
        <div class="swiper-wrapper">
          <div class="swiper-slide" v-for="(item, index) in content" :key="index">
            <img :src="item.imgUrl" alt=""/>
          </div>
      </div>
      </div>
      <!-- <div class="swiper-button-prev" :class="`swiper-button-prev${scrollIndex}`" ref="scollIndex">
        <img src="../../assets/img/IndexImg/左.png" alt="" />
      </div>
      <div class="swiper-button-next" :class="`swiper-button-next${scrollIndex}`">
        <img src="../../assets/img/IndexImg/右.png" alt="" />
      </div> -->
      <!-- <div class="swiper-pagination">
      </div> -->
    </div>
  </div>
    
</template>

<script>

import Swiper from 'swiper'
import 'swiper/swiper-bundle.css'
export default {
  name: "gain_Scroll",
  props: ['content', 'scrollIndex'],
  methods: {
    //轮播图初始化
    initSwiper(){
      let swiper=new Swiper('.swiper', {
      loop: true, // 循环模式选项
      speed: 1000,
      slidesPerView: 1,
      autoplay: {
        delay: 2000,
        disableOnInteraction: false,
        pauseOnMouseEnter: true,
      },
      // pagination: {
      //   el: '.swiper-pagination',
      //   clickable: true,
      // },
      // navigation: {
      //   nextEl: '.swiper-button-next',
      //   prevEl: '.swiper-button-prev',
      // },
    })
    }
  },
  mounted() {
    this.initSwiper()
  },

}
</script>

<style scoped>
.scroll-container {
  position: relative;
  width: 100%;
  height: 50%;
}

.swiper-slide{
  position: relative;
}

.scroll-container img {
  margin-left: 160px;
  width: 400px;
  height: 300px;
}

.swiper-button-prev img,
.swiper-button-next img{
  width: 100%;
  height: 100%;
}
.swiper-button-prev,
.swiper-button-next {
  width: 30px;
  height: 50px;
}

.swiper-button-prev:after,
.swiper-button-next:after {
  content: '';
}

.swiper-pagination{
  position: absolute;
  left: -25%;
}
/* 底部按钮样式 */
::v-deep .swiper-pagination-bullet {
  width: 8px;
  height: 8px;
  background-color: white;
  opacity: 1;
}

::v-deep .swiper-pagination-bullet-active {
  background-color: #c00000;
}
</style>
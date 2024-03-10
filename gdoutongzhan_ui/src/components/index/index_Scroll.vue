<template>
  <div class="scroll-container">
    <div class="swiper-wrapper">
      <div class="swiper-slide" v-for="(item, index) in content" :key="index">
        <img :src="item.imgUrl" alt="" />
      </div>
    </div>
    <div class="swiper-button-prev">
      <img src="../../assets/img/IndexImg/左.png" alt="" />
    </div>
    <div class="swiper-button-next">
      <img src="../../assets/img/IndexImg/右.png" alt="" />
    </div>
    <div class="swiper-pagination"></div>
  </div>
</template>

<script>
//引入swiper
import Swiper from 'swiper'
import 'swiper/swiper-bundle.css'
import SwiperCore, { Autoplay, EffectFade, Pagination, Navigation } from 'swiper'
SwiperCore.use([Autoplay, EffectFade, Pagination, Navigation])

export default {
  props: {
    content: {
      type: Array,
      default() {
        return []
      },
    },
  },
  data() {
    return {}
  },
  created() {},
  mounted() {
    //活动轮播图
    new Swiper('.scroll-container', {
      loop: true, // 循环模式选项
      speed: 1000,
      autoplay: {
        delay: 2000,
        stopOnLastSlide: false,
        disableOnInteraction: false,
        pauseOnMouseEnter: true,
      },
      pagination: {
        el: '.swiper-pagination',
        clickable: true,
      },
      navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
      },
    })
  },
  updated() {
    //活动轮播图
    new Swiper('.scroll-container', {
      loop: true, // 循环模式选项
      speed: 1000,
      autoplay: {
        delay: 2000,
        stopOnLastSlide: false,
        disableOnInteraction: false,
        pauseOnMouseEnter: true,
      },
      pagination: {
        el: '.swiper-pagination',
        clickable: true,
      },
      navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
      },
    })
  },
  methods: {},
}
</script>

<style scoped>
.scroll-container {
  position: relative;
  width: 100%;
  height: 100%;
  overflow: hidden;
}

.scroll-container img {
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

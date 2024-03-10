<template>
  <div class="photoWall">
    <div class="swiper-wrapper">
      <div class="swiper-slide">
        <img src="../../assets/img/IndexImg/carousel-1.png" alt="" />
      </div>
      <div class="swiper-slide">
        <img src="../../assets/img/IndexImg/carousel-2.png" alt="" />
      </div>
      <div class="swiper-slide">
        <img src="../../assets/img/IndexImg/carousel-1.png" alt="" />
      </div>
      <div class="swiper-slide">
        <img src="../../assets/img/IndexImg/carousel-2.png" alt="" />
      </div>
    </div>
  </div>
</template>

<script>
//引入swiper
import Swiper from "swiper";
import "swiper/swiper-bundle.css";
import SwiperCore, { Autoplay, EffectFade, Pagination } from "swiper";
SwiperCore.use([Autoplay, EffectFade, Pagination]);

export default {
  data() {
    return {};
  },
  mounted() {
    new Swiper(".photoWall", {
      loop: true, // 循环模式选项
      speed: 2500,
      slidesPerView: 3,
      spaceBetween: 10,
      autoplay: {
        delay: 0,
        stopOnLastSlide: false,
        disableOnInteraction: false,
        pauseOnMouseEnter: true,
      },
    });
  },
};
</script>

<style scoped>
/* 匀速轮播 */
.photoWall .swiper-wrapper {
  -webkit-transition-timing-function: linear; /*之前是ease-out*/
  -moz-transition-timing-function: linear;
  -ms-transition-timing-function: linear;
  -o-transition-timing-function: linear;
  transition-timing-function: linear;
}

.photoWall {
  overflow: hidden;
  height: 80%;
  margin-top: 1%;
}

.photoWall img {
  width: 100%;
  height: 100%;
}
</style>
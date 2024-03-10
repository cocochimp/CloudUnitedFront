<template>
  <div class="box">
    <div class="title1">院系统战</div>

    <div class="select">
      <div class="tag">学院选择</div>
      <ul class="college">
        <li v-for="t in collegeName" :key="t.id">
          <a>{{ t }}</a>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: 'faculty_united_front',
  data() {
    return {
      collegeName: [
        '水产学院',
        '食品科技学院',
        '海洋与气象学院',
        '滨海农业学院',
        '机械与动力工程学院',
        '海洋工程学院',
        '马克思主义学院',
        '经济学院',
        '管理学院',
        '数学与计算机学院',
        '电子与信息工程学院',
        '化学与环境学院',
        '海运学院',
        '文学与新闻传播学院',
        '法政学院',
        '外国语学院',
        '中歌艺术学院',
        '体育与休闲学院',
        '继续教育学院',
        '寸金学院',
        '研究生院',
        '党群行政系统',
        '科研机构',
        '教辅机构',
        '后勤机构',
      ],
    }
  },
}
</script>

<style scoped>
.title1 {
  margin-bottom: 1.5rem;
  border: #99a9bf solid 2px;
  text-align: center;
  width: 14rem;
  height: 3.5rem;
  font-size: 1.5rem;
  line-height: 3.5rem;
  color: white;
  background: -webkit-linear-gradient(top, #861600, #ee102d);
}
.tag {
  color: white;
  height: 40px;
  text-align: center;
  line-height: 40px;
  font-weight: 600;
  margin-bottom: 15px;
  background: -webkit-linear-gradient(top, #d15549, #edefef);
}
.college {
  padding-left: 15px;
  overflow: scroll;
  overflow-x: hidden;
  height: 380px;
}
.college > li {
  padding-top: 10px;
  padding-bottom: 10px;
  font-size: 10px;
  border-bottom: #99a9bf dashed 1px;
}
.college li::marker {
  color: #7f1b19;
}
.college > li > a:hover {
  color: #861600;
}
.select {
  border: #888888 solid 2px;
  width: 200px;
  height: 440px;
}
</style>

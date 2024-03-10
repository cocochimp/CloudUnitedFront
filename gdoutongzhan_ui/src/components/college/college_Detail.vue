<template>
  <div class="contentContainer">
    <div class="detail rck">
      <div class="total">党派总人数：{{ total[0] }}</div>
      <br />
      <div class="posi_titles">教授</div>
      <div class="number">总人数：{{ total[1] }}</div>
      <br />
      <div class="posi_titles">副教授</div>
      <div class="number">总人数：{{ total[2] }}</div>
      <br />
      <div class="posi_titles">高级实验师</div>
      <div class="number">总人数：{{ total[3] }}</div>
      <br />
      <div class="posi_titles">讲师</div>
      <div class="number">总人数：{{ total[4] }}</div>
    </div>
  </div>
</template>

<script>
export default {
  props: {},

  data() {
    return {
      total: [40, 10, 5, 5, 20],
    };
  },
};
</script>

<style scoped>
.contentContainer {
  width: 100%;
  height: 100%;
}

.total {
  color: #f1cd92;
  font-size: 3.083vh;
  font-weight: bold;
  text-align: center;
  padding-top: 2vh;
}
.posi_titles {
  color: #f1cd92;
  font-size: 3.083vh;
  font-weight: bold;
  padding: 0vh 4vh;
  float: left;
  box-sizing: border-box;
  width: 50%;
}
.number {
  color: #f1cd92;
  font-size: 3.083vh;
  font-weight: bold;
}
</style>
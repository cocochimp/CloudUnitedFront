<template>
  <div class="pie-box"></div>
</template>

<script>
export default {
  data() {
    return {};
  },
  mounted() {
    var chartDom = document.querySelector(".pie-box");
    var myChart = this.$echarts.init(chartDom);
    var option;

    option = {
      title: {
        text: "各党派人数比例",
        left: "center",
      },
      tooltip: {
        trigger: "item",
      },
      series: [
        {
          name: "人数",
          type: "pie",
          radius: "50%",
          data: [
            { value: 1048, name: "中国国民党革命委员会" },
            { value: 735, name: "中国民主同盟" },
            { value: 580, name: "中国民主建国会" },
            { value: 484, name: "中国民主促进会" },
            { value: 350, name: "中国农工民主党" },
            { value: 965, name: "中国致公党" },
            { value: 638, name: "九三学社" },
          ],
          emphasis: {
            itemStyle: {
              shadowBlur: 10,
              shadowOffsetX: 0,
              shadowColor: "rgba(0, 0, 0, 0.5)",
            },
          },
        },
      ],
    };

    option && myChart.setOption(option);
    window.addEventListener("resize", function () {
      myChart.resize();
    });
  },
};
</script>

<style scoped>
.pie-box {
  width: 100%;
  height: 100%;
}
</style>
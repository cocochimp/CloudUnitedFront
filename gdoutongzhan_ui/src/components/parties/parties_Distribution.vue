<template>
  <div class="distributionContainer">
    <div id="longitudinalBar"></div>
    <div class="x-axis-tip"></div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  mounted() {
    let collegeBar = document.querySelector("#longitudinalBar");
    let myChart = this.$echarts.init(collegeBar);
    let option;
    option = {
      grid: {
        left: "2%",
        right: "4%",
        top: "10",
        bottom: "2%",
        containLabel: true,
      },
      //鼠标移入显示信息
      tooltip: {
        trigger: "axis",
        axisPointer: {
          type: "shadow",
        },
      },
      yAxis: {
        type: "category",
        data: [
          "水产学院",
          "食品科技学院",
          "海洋与气象学院",
          "滨海农业学院",
          "机械与动力工程学院",
          "海洋工程学院",
          "马克思主义学院",
          "经济学院",
          "管理学院",
          "数学与计算机学院",
          "电子与信息工程学院",
          "化学与环境学院",
          "海运学院",
          "文学与新闻传播学院",
          "法政学院",
          "外国语学院",
          "中歌艺术学院",
          "体育与休闲学院",
          "继续教育学院",
          "寸金学院",
          "研究生院",
          "党群行政系统",
          "科研机构",
          "教辅机构",
          "后勤机构",
        ],
        //y轴坐标轴反向
        inverse: true,
        //不显示坐标轴刻度
        axisTick: {
          show: false,
        },
        //不显示坐标轴轴线
        axisLine: {
          show: false,
        },
        triggerEvent: true,
        //设置y轴字体颜色
        axisLabel: {
          show: true,
          interval: 0,
          rotate: 0,
          textStyle: {
            color: "#fff",
          },
          // 设置文本过长超出隐藏
          formatter(value, index) {
            if (value.length > 4) {
              value = value.slice(0, 4) + "...";
            }
            return value;
          },
        },
      },

      xAxis: {
        type: "value",
        //设置x轴字体颜色
        axisLabel: {
          show: false,
          textStyle: {
            color: "#f1cd92",
          },
        },
        //设置背景线条颜色
        splitLine: {
          //设置条纹显示 柱状图默认yAxis(true)
          show: true,
          //设置lineStyle即可写入样式即可
          lineStyle: {
            //这里输入线条的样式
            color: "#9b4117",
          },
        },
      },
      series: [
        {
          name: "成员人数",
          data: [
            20, 32, 10, 34, 40, 30, 21, 15, 33, 34, 41, 20, 43, 19, 26, 67, 10,
            10, 15, 8, 4, 6, 17, 31, 24,
          ],
          type: "bar",
          //设置柱子宽度
          barWidth: "60%",
          //设置柱子颜色
          itemStyle: {
            normal: {
              color: this.$echarts.graphic.LinearGradient(1, 0, 0, 0, [
                { offset: 0.7, color: "#ff7e00" },
                { offset: 0, color: "#ffd300" },
              ]),
              borderColor: "#fff",
              borderWidth: 0.5,
            },
          },
        },
      ],
    };
    option && myChart.setOption(option);
    window.addEventListener("resize", function () {
      myChart.resize();
    });
    // 提示泡
    myChart.on("mouseover", function (params) {
      if (params.componentType === "yAxis") {
        let offsetX = params.event.event.offsetX;
        let offsetY = params.event.event.offsetY;
        let xAxisTip = document.querySelector(".x-axis-tip");
        xAxisTip.innerText = params.value.split("#")[0];
        xAxisTip.style.left = offsetX + "px";
        xAxisTip.style.top = offsetY + 10 + "px";
        xAxisTip.style.display = "block";
      }
    });
    myChart.on("mousemove", function (params) {
      if (params.componentType === "yAxis") {
        let offsetX = params.event.event.offsetX;
        let offsetY = params.event.event.offsetY;
        let xAxisTip = document.querySelector(".x-axis-tip");
        xAxisTip.innerText = params.value.split("#")[0];
        xAxisTip.style.left = offsetX + 30 + "px";
        xAxisTip.style.top = offsetY + 10 + "px";
        xAxisTip.style.display = "block";
      }
    });
    myChart.on("mouseout", function (params) {
      let xAxisTip = document.querySelector(".x-axis-tip");
      xAxisTip.style.display = "none";
    });
  },
};
</script>

<style scoped>
.distributionContainer {
  width: 100%;
  height: 100%;
  border: 0.5px #9b4117 solid;
}

#longitudinalBar {
  width: 100%;
  height: 100%;
}

/* 气泡的样式 */
.x-axis-tip {
  display: none;
  position: absolute;
  padding: 5px 5px;
  font-size: 12px;
  line-height: 18px;
  color: #575757;
  background: #ffffff;
  box-shadow: 0 1px 4px 0 rgba(0, 0, 0, 0.2);
  border-radius: 4px;
}
</style>
<template>
  <div>
    <div v-if="$route.query.name">
      <div class="head">
        <span class="tag">{{ $route.query.name }}</span>
        <span class="position"
          >当前位置：<router-link to="/index">首页</router-link> |
          {{ $route.query.name }}
        </span>
      </div>
      <div class="line">
        <div class="line_short"></div>
      </div>
      <div class="sub_content">
        <p class="p-content">{{ $route.query.content }}</p>
      </div>
    </div>
    <div v-else>暂时没有内容哦</div>
  </div>
</template>

<script>
export default {
  name: "depintroduction_right",
};
</script>

<style scoped>
.line {
  background: #96a0a9;
  height: 2px;
  position: relative;
  margin-top: 5px;
  width: 100%;
}
.line_short {
  background: #af090b;
  height: 2px;
  width: 150px;
  /*border: solid 2px palevioletred;*/
  position: absolute;
  top: 0;
  left: 0;
}
.p-content {
  text-indent: 2em;
  padding-top: 1rem;
  line-height: 2rem;
  white-space: pre-wrap;
  word-wrap: break-word;
}
.tag {
  display: inline-block;
  text-align: left;
  color: #af090b;
  font-weight: 600;
  width: 80px;
  padding-bottom: 10px;
  border-radius: 3px;
  font-size: 20px;
}
.position {
  font-size: 12px;
  color: #9e9e9e;
  display: inline-block;
  float: right;
  line-height: 3rem;
}
.head {
  padding-top: 1rem;
  /*border-bottom: 1px solid #ddd;*/
}
</style>

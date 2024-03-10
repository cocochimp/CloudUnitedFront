<template>
  <div class="sub_introduction clearfix">
    <div class="head">
      <span class="tag">简介</span>
      <span class="position">当前位置：<router-link to="/index">首页</router-link> | 中国民主同盟 </span>
    </div>
    <div class="line">
      <div class="line_short"></div>
    </div>
    <div class="sub_content">
      <span class="sub_about">
        <p style="text-indent: 2em; padding-top: 1rem; font-size: 16px">
          中国民主同盟（简称“民盟”）是主要由从事文化教育以及科学技术工作的高、 中级知识分子组成的，具有政治联盟特点的，接受中国共产党领导、 同中国共产党通力合作，进步性与广泛性相统一、致力于中国特色社会主义事业的参政党， 于1941年3月19日在重庆秘密成立。
          中国民主同盟（简称“民盟”）是主要由从事文化教育以及科学技术工作的高、 中级知识分子组成的，具有政治联盟特点的，接受中国共产党领导、 同中国共产党通力合作，进步性与广泛性相统一、致力于中国特色社会主义事业的参政党， 于1941年3月19日在重庆秘密成立。
          中国民主同盟（简称“民盟”）是主要由从事文化教育以及科学技术工作的高、 中级知识分子组成的，具有政治联盟特点的，接受中国共产党领导、 同中国共产党通力合作，进步性与广泛性相统一、致力于中国特色社会主义事业的参政党， 于1941年3月19日在重庆秘密成立。
        </p>
      </span>
    </div>
  </div>
</template>

<script>
export default {}
</script>

<style scoped>
.sub_introduction {
  margin-top: 7rem;
}
.sub_content {
  height: 11.6rem;
  overflow-x: hidden;
  max-height: 11.6rem;
  line-height: 2rem;
  display: inline-block;
}
.clearfix:after {
  content: '.';
  display: block;
  height: 0;
  clear: both;
  visibility: hidden;
}

.position {
  font-size: 13px;
  color: #9e9e9e;
  display: inline-block;
  float: right;
  line-height: 3rem;
}

.tag {
  display: inline-block;
  text-align: left;
  color: #AF090B;
  font-weight: 600;
  width: 80px;
  padding-bottom: 10px;
  border-radius: 3px;
  font-size: 20px;
}
.line{
  background: #96A0A9;
  height: 2px;
  position: relative;
  margin-top: 5px;
  width: 100%;
}
.line_short{
  background: #AF090B;
  height: 2px;
  width: 50px;
  /*border: solid 2px palevioletred;*/
  position: absolute;
  top: 0;
  left: 0;
}
.position {
  font-size: 12px;
  color: #9e9e9e;
  display: inline-block;
  float: right;
  line-height: 3rem;
}
</style>

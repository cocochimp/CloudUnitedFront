<template>
    <div class="box">
        <div class="tit">{{name}}</div>
        <div class="boxnav" style="height: 600px; ">
            <gainScroll :scrollIndex="scrollIndex" :content="photoList"></gainScroll>
            <gainNews :news="newsList"></gainNews>
        </div>
    </div>
</template>

<script>
import gainScroll from './gain_Scroll.vue';
import gainNews from './gain_News.vue'
export default {
    name: "gain_card",
    props: ['name','scrollIndex','photoList','newsList'],
    components: { gainScroll,gainNews}
}
</script>

<style scoped>
* {
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box
}

*,
body {
    padding: 0px;
    margin: 0px;
    font-family: "微软雅黑";
     color: #fff;
}

html,
body {
    height: 100%;
}

hr {
  margin-top: 35px;
  border:1px rgba(7,118,181,.5) dashed ;
}

li {
    list-style-type: none;
}

i {
    margin: 0px;
    padding: 0px;
    text-indent: 0px;
}

a {
    padding: 0;
    text-decoration: none;
    color: #fff;
}

a.active,
a:focus {
    outline: none!important;
    text-decoration: none;
}

ol,
ul,
p,
h1,
h2,
h3,
h4,
h5,
h6 {
    padding: 0;
    margin: 0
}

a:hover {
    color: #06c;
    text-decoration: none!important
}

.box{ 
    border:1px solid rgba(7,118,181,.5);
    box-shadow:inset 0 0 10px rgba(7,118,181,.4);
    margin-bottom: 12px;
    position: relative;
}

.box:before{
    top: -1px;
}

.tit{
    padding: 10px 10px 10px 44%;
    border-bottom:1px solid rgba(7,118,181,.7);
    font-size: 16px;
    font-weight: 500;
    position: relative;
}

.tit:before,
.tit01:before{
    position: absolute;
    content: "";
    width: 6px;
    height: 6px;
    background: rgba(22,214,255,.9);
    box-shadow: 0 0 5px rgba(22,214,255,.9);
    border-radius: 10px; left: 10px; top: 18px;
}

.boxnav{
    padding: 10px;
}

.boxnav ul li {
  /* background-color: #fff; */
  display:flex;
  align-items: center;
  width: 100%;
  height: 30px;
  line-height: 30px;
  padding-left:30px;
}

.boxnav .date{
  margin-left: 25px;
}

.boxnav ul li a p{
  width: 300px;
  overflow:hidden;
  white-space:nowrap;
  text-overflow:ellipsis;
}

</style>
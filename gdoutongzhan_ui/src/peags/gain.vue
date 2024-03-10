<template>
  <div class="mainbox">
    <ul class="clearfix nav1">
      <li style="width: 50%">
        <gain_card name="教学科研成果展示" scrollIndex="sci" :photoList="photoList1" :newsList="newsList1" >
        </gain_card>
      </li>

      <li style="width: 50%">
        <gain_card  name="统战成果展示" scrollIndex="work" :photoList="photoList2" :newsList="newsList2"> 
        </gain_card>
      </li>
    </ul>
  </div>
</template>

<script>
import { reqGetAllPic } from "@/api/fileData/gainPic"
import {reqAllArt}from "@/api/fileData/gainArt"
import gain_card from '@/components/gain/gain_card.vue'
export default {
  name: 'gain',
  components:{gain_card},
  data() {
    return {
      allPhotoList: [],
      allNewsList:[],
      photoList1: [],
      photoList2:[],
      newsList1: [],
      newsList2: [],
      p:{current:1,number:1000}//获取所有的图片数量，这里number可以无限大
    }
  },
  methods: {
    async getPhotoList() {
      let result = await reqGetAllPic(this.p)
      this.allPhotoList = result.t.list
      this.allPhotoList.forEach(item => {
        if (item.type === "科技成果") {
          this.photoList1.push(item)
        } else {
          this.photoList2.push(item)
        }
      });
    },
    async getNewsList() {
      let result = await reqAllArt(this.p)
      this.allNewsList = result.t.list
      this.allNewsList.forEach(item => {
        if (item.type === "科技成果") {
          this.newsList1.push(item)
        } else {
          this.newsList2.push(item)
        }
      });
    },
  },
  mounted() {
    this.getPhotoList()
    this.getNewsList()
  },
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

img {
    border: none;
    max-width: 100%;
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

.clearfix:after,
.clearfix:before {
    display: table;
    content: " "
}

.clearfix:after {
    clear: both
}


i {
    font-style: normal;
}

/*  */
  .mainbox{
    padding: 0px 10px;
}

  .nav1{
    margin-left: -6px;
    margin-right:-6px;
}

  .nav1>li{
    padding:0 6px;
    float: left;
}

  
.mainbox{
    background: url(../assets/img/地图界面.gif) no-repeat center center;
    background-size: cover;
}

</style>
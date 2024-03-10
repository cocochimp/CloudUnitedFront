<template>
  <div class="footer">
      <div class="wrapper">
        <div class="mod clearfix">
          <div class="footerText" portletmode="simpleSiteAttri">
            <p class="copyright">
              <span>版权所有：广东海洋大学党委统战部</span>
            </p>
            <p class="copyright">
              <span class="address">地址：中华人民共和国 广东省 湛江市 麻章区 海大路1号 邮编：524088 </span>
            </p>
            <p class="copyright">
              <span class="telephone">电话：0759-2383111</span>
              <span class="email"> 信箱：xzb@gdou.edu.cn</span>
            </p>
          </div>
        </div>
      </div>
  </div>
</template>

<script>
export default {
  methods:{
    openMenu(){
      this.$nextTick(() => {
      let linksWrap = document.getElementsByClassName('links-wrap')[0];
      let linksItem = document.getElementsByClassName('link-items')[0];
      linksWrap.onmouseover = () => {
        linksWrap.classList.add("wrap-open");
        linksItem.style.display = 'block';
      } 
      linksWrap.onmouseout = () => {
        linksWrap.classList.remove("wrap-open");
        linksItem.style.display ='none';
      }
      });
    },
  },
}
</script>

<style scoped>
.footer{
  position: relative;
  background: #bd2424;
  height: 146px;
}
.wrapper {
  max-width: 1106px;
  margin: 0 auto;
}
.footer .wrapper .mod{
  padding: 0 22px 0 17px;
}
.footer .wrapper .footerText{
  padding: 42px 0px;
  margin-left: 20px;
  font-size: 12px;
}

.footer .wrapper p{
  font-size: 16px;
  line-height: 21px;
  font-weight: normal;
  text-align: center;
  color: #fff;
}
.footer .wrapper p span{
  margin: 0 3px;
}
.footer .wrapper .foot-right{
  float: right;
  margin-top: 41px;
  margin-right: 5px;
}
.links .links-wrap {
  position: relative;
  display: inline-block;
  margin: 4px 10px;
  width: 194px;
  line-height: 34px;
  background: #fff;
  border: 1px solid #b1b1b1;
}
.links .links-wrap a.links-arrow {
  display: block;
  height: 32px;
  line-height: 32px;
  padding: 0 25px 0 10px;
  color: #333333;
  background: url("../../assets/img/IndexImg/arrow.png") no-repeat right top;
}
.links .links-wrap a.links-arrow:hover,
.links .wrap-open a.links-arrow{
  color: #333;
  background-position: right bottom;
  cursor: pointer;
}
.links .links-wrap .link-items {
  display: none;
  position: absolute;
  left: 0;
  bottom: 33px;
  width: 194px;
  height: auto;
  max-height: 130px;
  overflow-y: auto;
  overflow-x: hidden;
  background: #f5f5f5;
}
.links .links-wrap .link-items a {
  display: block;
  line-height: 24px;
  padding: 5px 0;
  color: #444;
}
.links .links-wrap .link-items a span {
  display: block;
  margin: 0 6px;
  white-space: nowrap;
}

.links .links-wrap .link-items a:hover{
  color: #fff;
  background: #861600;
  cursor: pointer;
}
</style>
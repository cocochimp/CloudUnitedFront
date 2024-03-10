<template>
  <div class="group-container">
    <div>
      <div class="head">
        <span class="tag">{{ $route.query.name }}</span>
        <span class="position">
          当前位置：
          <router-link to="/index">
            首页
          </router-link>
          |{{ $route.query.name }}
        </span>
      </div>
      <div class="line">
        <div class="line_short"></div>
      </div>

      <div class="group">
        <group_item v-for="item in showList" :item="item" :key="item.id" />
      </div>

      <!-- 分页器 -->
      <!-- <div class="fenye">
      </div> -->
    </div>

  </div>
</template>

<script>
import group_item from '../../components/faculty/faculty_united_front_group_item'
export default {
  components: { group_item },
  watch: {
    item() {
      if ('"' + this.$route.fullPath + '"' !== localStorage.getItem('keepUrl')) {
        this.total = this.item.length
        this.showList = this.item
        localStorage.removeItem('keepUrl')
      }
    },
  },
  props: ['item'],
  data() {
    return {
      group_item: [
        {
          uuid: 1,
          title: '中共中央印发《中国共产党统一战线工作条例》',
          time: '2022/3/31',
        },
        {
          uuid: 2,
          title: '中共中央印发《中国共产党统一战线工作条例》',
          time: '2022/3/31',
        },
        {
          uuid: 3,
          title: '中共中央印发《中国共产党统一战线工作条例》',
          time: '2022/3/31',
        },
        {
          uuid: 4,
          title: '中共中央印发《中国共产党统一战线工作条例》',
          time: '2022/3/31',
        },
      ],
      showList: [],
    }
  },
  created() {
    if ('"' + this.$route.fullPath + '"' === localStorage.getItem('keepUrl')) {
      this.showList = JSON.parse(localStorage.getItem('keepData'))
    }else {
      this.total = this.item.length
      this.showList = this.item
    }

    window.addEventListener('beforeunload', () => {
      localStorage.setItem('keepUrl', JSON.stringify(this.$route.fullPath))
      localStorage.setItem('keepData', JSON.stringify(this.showList))
    })
  },
  destroyed() {
    localStorage.removeItem('keepData')
    localStorage.removeItem('keepUrl')
  },
}
</script>

<style scoped>
input {
  width: 20px;
  margin-left: 3px;
  margin-right: 3px;
}
.foot > span {
  padding-left: 3px;
  padding-right: 3px;
  font-size: 13px;
}
.position {
  font-size: 12px;
  color: #9e9e9e;
  display: inline-block;
  float: right;
  line-height: 3rem;
}
.group {
  padding-top: 1rem;
}
.group-container {
  box-sizing: border-box;
  display: inline-block;
  width: 50rem;
  padding-top: 1rem;
}

.foot > .count {
  width: 20px;
  height: 20px;
  display: inline-block;
  align-content: center;
  line-height: 20px;
  color: black;
  text-align: center;
  background-color: #bd1313;
  font-size: 13px;
}
.tag {
  display: inline-block;
  text-align: left;
  color: #af090b;
  font-weight: 600;
  /*width: 160px;*/
  padding-bottom: 10px;
  border-radius: 3px;
  font-size: 20px;
}

.foot {
  padding-top: 25px;
  padding-bottom: 5px;
  text-align: right;
}
.foot > button {
  background-color: #f2f2f2;
  border: none;
  margin-left: 10px;
  margin-right: 10px;
  font-size: 13px;
}
.foot > .tips {
  font-size: 10px;
  text-align: center;
  font-size: 13px;
}
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
  width: 180px;
  /*border: solid 2px palevioletred;*/
  position: absolute;
  top: 0;
  left: 0;
}
.fenye {
  position: absolute;
  bottom: 0;
  left: calc(50% - 65px);
}

::v-deep .el-pager .active {
  background-color: #af090b !important;
}
</style>

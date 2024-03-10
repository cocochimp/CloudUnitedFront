<template>
  <div>
    <ul>
      <li class="result-item" v-for="(item, index) in content" :key="index">
        <router-link :to="'/article?id=' + item.id">
          <p class="time">{{ item.releaseTime }}</p>
          <p class="text">{{ item.title }}</p>
        </router-link>
      </li>
    </ul>

    <div class="fenye">
      <el-pagination background layout="prev, pager, next" :page-size="15" :total="total" @current-change="pageChange"> </el-pagination>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      total: 0,
      showList: [],
    }
  },
  props: ['content'],
  created() {
    this.total = this.content.length
    this.showList = this.content.slice(0, 15)
  },
  methods: {
    pageChange(currentPage) {
      this.showList = this.content.slice((currentPage - 1) * 15, currentPage * 15)
    },
  },
}
</script>

<style scoped>
.result-item {
  height: 40px;
  line-height: 30px;
  border-bottom: #d5d5d5 solid 1px;
}
.result-item p {
  display: inline-block;
  line-height: 40px;
}

.result-item .time {
  color: red;
  margin-right: 20px;
  vertical-align: top;
}
.result-item .text {
  width: 690px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  font-size: 16px;
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

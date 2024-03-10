<template>
  <div>
    <ul>
      <li class="item" @click="toArticle(item)" v-if="item.path">
        <a class="article" :href="item.path">{{ item.title }}</a>
        <span class="time">{{ item.releaseTime }}</span>
      </li>
      <li class="item"  v-else>
        <router-link :to="'/article?id=' + item.id">
          <span class="article">{{ item.title }}</span>
          <span class="time">{{ item.releaseTime }}</span>
        </router-link>
      </li>
    </ul>
  </div>
</template>

<script>

export default {
  name: "faculty_united_front_group_item",
  props: ["item"],
};
</script>

<style scoped>
ul {
  list-style-type: circle;
}
.item {
  border-bottom: #d5d5d5 solid 1px;
  /*list-style-type: none;*/
  padding-top: 10px;
  padding-bottom: 10px;
  text-align: left;
}

.item > a {
  text-decoration: none;
  color: black;
}
.article {
  display: inline-block;
  font-size: 16px;
  text-overflow: ellipsis;
  overflow: hidden;
  white-space: nowrap;
  width: 625px;
}
.time {
  font-size: 16px;
  color: #9ba89e;
  float: right;
  display: inline-block;
}
</style>

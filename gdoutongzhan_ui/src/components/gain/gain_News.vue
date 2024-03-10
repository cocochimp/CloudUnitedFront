<template>
  <div>
    <h2 class="tit">新闻</h2>
    <div class="card-ul">
      <ul>
        <template v-for="(item, index) in news">
            <li :key="index" v-if="(index < 8)">
                <router-link :to="{
                  path: '/news',
                  query: {
                    id:item.id  
                  }
                }">
                    <p>{{ item.title }}</p>
                </router-link>
            </li>
        </template>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
    name: "gainNews",
    props:['news'],
    data() {
        return{}
    },
    methods: {

    },

}
</script>

<style scoped>
.tit{
    position: relative;
    left: 25px;
    top: 25px;
}

.card-ul {
    position: relative;
    top: 15px;
    padding: 25px;
}

.card-ul ul li {
  display: flex;
  align-items: center;
  width: 100%;
  height: 30px;
  line-height: 30px;
}

.card-ul ul li p {
  margin-left: 15px;
}


</style>
<template>
    <div>
        <!-- 导航栏区域 -->
        <metadata></metadata>

        <!-- 文章区域 -->
        <div class="content">
            <div class="box">
                <h1 class="articleTitle">{{ articleTitle }}</h1>
                 <p class="arti_metas">
                    <span>作者：{{ author }}</span>
                    <span>发布时间：{{ updateTime }}</span>
                </p>
                <div class="articlePage ql-editor" v-html="article"></div>
            </div>
        </div>
    </div>
</template>

<script>
import axios from "axios";
import metadata from "@/components/metadata.vue"
export default {
    name: "News",
    components: {
        metadata
    },
    data() {
        return {
            articleTitle: "",
            author: "",
            updateTime: "",
            article:""
        }
    },
    methods: {
        getGainArticle() {
            axios.post("http://localhost:9108/servicefile/scientificAchievementOfArticle/queryArticleById", { id: this.$route.query.id }).
                then(res => {
                    let result = res.data.t
                    this.article=result.content
                    this.articleTitle = result.title
                    this.author = result.author
                    this.updateTime=result.updateTime
                })
        }
    },
    mounted() {
        this.getGainArticle()
    }
}
</script>

<style scoped>

.content .box {
  width: 1200px;
  margin: 0 auto;
  padding: 25px;
  background-color: #fff;
  margin-bottom: 30px;
  min-height: 87vh;
}

.articleTitle {
  line-height: 1.7;
  font-family: "Microsoft YaHei";
  font-size: 22px;
  text-align: center;
  color: #9b0d14;
  margin-bottom: 5px;
}
.articlePage {
  margin-top: 20px;
}

.arti_metas {
  padding: 10px;
  text-align: center;
  background: #f5f5f5;
  border-top: 1px solid #ececec;
}
.arti_metas span {
  font-size: 14px;
  margin: 0 10px;
}

</style>
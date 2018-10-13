<template>
    <div class="article">
        <div class="title">{{article.value.title}}</div>
        <div class="infosArticles container center">
            <span class="minititle"> <font-awesome-icon icon="clock"/> <span class="val">{{article.value.publishDate}}</span></span>
            <span class="minititle"> <font-awesome-icon icon="user"/><span class="val">zThulj</span></span>
            <span class="minititle"> <font-awesome-icon icon="comment"/><span class="val">(0) Commentaires</span></span>
        </div>
        <div class="articlecontent container" v-html="article.value.contentHtml">

        </div>
        <!--Comments></Comments> -->
    </div>
</template>

<script>
  import Comments from '@/components/thulj/commons/Comments.vue'
  import axios from 'axios'

  export default {
    name: 'Article',
    components: {
      Comments
    },
    mounted () {
      console.log()
      axios.get('http://localhost:8080/api/blog' + this.$route.path).then(response => {
        this.article = response.data;
      })
        .catch(e => {
        })
    },
    data: function () {
      return {
        article: {id: null, link: '', value: {title: '', content: ''}}
      }
    }
  }
</script>

<style scoped>

    .infosArticles{border-bottom:1px solid #DEDEDE;padding-bottom:10px;margin-bottom:15px;}
    .title{ font-size:2.4rem;color:#5e5e5e;font-weight:lighter}
    .minititle{
        margin-right:0.8em; color:#666666
    }
    .val{margin-left:0.4em; font-weight:lighter;font-size:12px;}
    .articlecontent{font-weight: lighter;text-align: left;margin-bottom:15px;}
    .container{padding-left:0px!important;}
</style>

<template>
    <div class="article">
        <div class="title">{{article.title}}</div>
        <div class="infosArticles container center">
            <span class="minititle"> <font-awesome-icon icon="clock"/> <span class="val">{{article.formattedDate}}</span></span>
            <span class="minititle"> <font-awesome-icon icon="user"/><span class="val">zThulj</span></span>
            <span class="minititle"> <font-awesome-icon icon="comment"/><span class="val">(0) Commentaires</span></span>
            <router-link :to="'/edit/' + article.link" class="minititle" v-if="this.access_token !== ''"> <font-awesome-icon icon="edit"/></router-link>
        </div>
        <div class="articlecontent container" v-html="article.value.contentHtml">

        </div>
        <!--Comments></Comments> -->
    </div>
</template>

<script>
  export default {
    name: 'ArticleContent',
    props: ['article', 'access_token']
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

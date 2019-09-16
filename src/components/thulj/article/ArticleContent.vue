<template>
    <div class="article container">
        <div class="title">{{article.title}}</div>
        <div class="infosArticles">
            <span class="minititle"> <font-awesome-icon icon="clock"/> <span class="val">{{article.formattedDate}}</span></span>
            <span class="minititle"> <font-awesome-icon icon="user"/><span class="val">zThulj</span></span>
            <span class="minititle"> <font-awesome-icon icon="comment"/><span class="val">(0) Commentaires</span></span>
        </div>
        <div class="light descr">{{article.description}}</div>
        <div class="separator"></div>
        <div class="articleContent" v-html="this.article.value.contentHtml" id="content">

        </div>
        <!--Comments></Comments> -->
    </div>
</template>

<script>
  import Prism from 'prismjs'
  export default {
    name: 'ArticleContent',
    props: ['article', 'access_token'],
    updated () {
      Prism.highlightAll(document.getElementById('article'))
    }
  }
</script>

<style scoped>
    .article{font-family:"Open Sans";
    }
    .separator{width:100%;border-bottom:1px solid #DEDEDE;margin-bottom:15px;padding-bottom:10px;}
    .infosArticles{}
    .title{ font-size:2.4rem;color:black;font-weight:700;}
    .minititle{
        margin-right:0.8em; color:#666666
    }
    .val{margin-left:0.4em; font-weight:lighter;font-size:12px;}
    .articleContent{font-weight: lighter;text-align: left;margin-bottom:15px;}
    .container{padding-left:0px!important;font-weight:300;font-size:14px }
    .descr{font-size:12px;color:#777;margin-top:12px;font-weight:300;}

</style>

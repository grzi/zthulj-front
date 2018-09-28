<template>
    <div class="article">
        <div class="title">Ceci sera le titre de l'article</div>
        <div class="infosArticles container center">
            <span class="minititle"> <font-awesome-icon icon="clock"/> <span class="val">27/06/1992</span></span>
            <span class="minititle"> <font-awesome-icon icon="user"/><span class="val">zThulj</span></span>
            <span class="minititle"> <font-awesome-icon icon="comment"/><span class="val">(0) Commentaires</span></span>
        </div>
        <div class="articlecontent container">
            Ceci est le contenu de l'article
        </div>
        <!--Comments></Comments> -->
    </div>
</template>

<script>
  import Comments from '@/components/thulj/commons/Comments.vue'

  export default {
    name: 'Article',
    components: {
      Comments
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

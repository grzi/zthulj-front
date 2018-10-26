<template>
    <ArticleContent :article="article" :access_token="access_token" ></ArticleContent>
</template>

<script>
  import ArticleContent from '@/components/thulj/article/ArticleContent'
  import axios from 'axios'
  import Prism from 'prismjs'
  export default {
    name: 'Article',
    components: {
      ArticleContent
    },
    beforeMount () {
      axios.get(process.env.ROOT_API + 'api/public/blog' + this.$route.path).then(response => {
        this.article = response.data
        Prism.highlightAll(this.article.value.contentHtml)
        console.log(this.article.value.contentHtml)
      })
        .catch(e => {
        })
    },
    computed: {
      access_token () {
        return this.$store.state.access_token
      }
    },
    data: function () {
      return {
        article: {
          value: { }
        }
      }
    }
  }
</script>

<style scoped>

</style>

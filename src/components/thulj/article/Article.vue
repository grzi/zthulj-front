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
      var splittedPath = this.$route.path.split('/')
      axios.get(process.env.ROOT_API + 'api/public/blog/' + splittedPath[splittedPath.length - 1]).then(response => {
        this.article = response.data
        document.title = this.article.title + ' - zThulj'
        Prism.highlightAll(this.article.value.contentHtml)
      })
        .catch(e => {
        })
    },
    computed: {
      access_token () {
        return this.$store.state.access_token
      }
    },
    mounted () {
      document.title = this.article.title
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

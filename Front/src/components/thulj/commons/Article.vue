<template>
    <ArticleContent :article="article" :access_token="access_token" ></ArticleContent>
</template>

<script>
  import ArticleContent from '@/components/thulj/commons/ArticleContent'
  import axios from 'axios'

  export default {
    name: 'Article',
    components: {
      ArticleContent
    },
    beforeMount () {
      axios.get('http://localhost:8080/api/public/blog' + this.$route.path).then(response => {
        this.article = response.data
      })
        .catch(e => {
        })
    },
    props: ['article'],
    computed: {
      access_token () {
        return this.$store.state.access_token
      }
    }
  }
</script>

<style scoped>

</style>

<template>
  <div>
    <SideNav :activeSection='"code"'></SideNav>
    <TitleBar :sectionTitle='sectionTitle'></TitleBar>
    <div class="content">
      <div class="container center">
        <h1 v-if="$route.params.id != null ">Oui</h1>
        <div v-else class="row">
          <Card v-for="article in articles" v-bind:card="article" v-bind:key="article.title"></Card>
        </div>
      </div>
    </div>
      <Footer></Footer>
  </div>
</template>

<script>
  import SideNav from '@/components/thulj/structure/SideNav.vue'
  import TitleBar from '@/components/thulj/structure/TitleBar.vue'
  import Footer from '@/components/thulj/structure/Footer.vue'
  import Card from '@/components/thulj/article/Card.vue'
  import axios from 'axios'

  export default {
    name: 'Projects',
    components: {
      SideNav,
      Footer,
      TitleBar,
      Card
    },
    created () {
      document.title = 'zThulj > Projets'
    },
    mounted () {
      axios.get('http://localhost:8080/api/public/blog/list/projects').then(response => {
        this.articles = response.data
      })
        .catch(e => {

        })
    },
    data: function () {
      return {
        sectionTitle: 'zThulj > Projets',
        articles: [
        ]
      }
    }
  }
</script>

<style scoped>
    .container {
        width: 95%;
    }
</style>

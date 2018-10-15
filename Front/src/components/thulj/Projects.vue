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
  import SideNav from '@/components/thulj/commons/SideNav.vue'
  import TitleBar from '@/components/thulj/commons/TitleBar.vue'
  import Footer from '@/components/thulj/commons/Footer.vue'
  import Card from '@/components/thulj/commons/Card.vue'
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
      document.title = 'Projets - Thulj.fr'
    },
    mounted () {
      axios.get('http://localhost:8080/api/blog/list/projects').then(response => {
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

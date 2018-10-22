<template>
  <div>
    <SideNav :activeSection='"utensils"'></SideNav>
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
    name: 'Recipes',
    components: {
      SideNav,
      Footer,
      TitleBar,
      Card
    },
    created () {
      document.title = 'Recettes'
    },
    mounted () {
      axios.get('http://localhost:8080/api/public/blog/list/recipes').then(response => {
        this.articles = response.data
      })
        .catch(e => {

        })
    },
    data: function () {
      return {
        sectionTitle: 'zThulj > Recettes',
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

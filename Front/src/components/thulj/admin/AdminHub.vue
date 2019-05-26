<template>
    <div>
        <SideNav :activeSection='"editPost"'></SideNav>
        <TitleBar :sectionTitle='sectionTitle' :admin="true"></TitleBar>
        <div class="content">
            <div class="container center">
                <h4>Administration</h4>
                <div class="row">
                    <router-link to="/edit">
                        <div class="btn">Nouvel article</div>
                    </router-link>
                </div>
                <h5>Liste des articles</h5>
                <table class="highlight">
                    <thead>
                    <tr>
                        <th class="title">Titre</th>
                        <th>Description</th>
                        <th>Statut</th>
                    </tr>
                    </thead>

                    <tbody>
                        <tr v-for="article in articles" v-bind:key="article.title">
                            <td> <router-link :to='"/edit/" + article.link'>{{article.title}}</router-link></td>
                            <td>{{article.description}}</td>
                            <td>{{article.published ? 'Publié' : 'Brouillon'}}</td>
                        </tr>
                    </tbody>
                </table>
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
    name: 'AdminHub',
    components: {
      SideNav,
      Footer,
      TitleBar,
      Card
    },
    methods: {
      loadArticles: function () {
        axios.get(process.env.ROOT_API + 'api/secured/blog/listAll/', {
          headers: {
            'authorization': 'Bearer ' + this.access_token
          }
        }).then(response => {
          this.articles = response.data
        })
      }
    },
    data: function () {
      return {
        articles: []
      }
    },
    computed: {
      access_token () {
        return this.$store.state.auth.access_token
      }
    },
    mounted () {
      this.loadArticles()
    }
  }
</script>

<style scoped>
.title{min-width:450px;}
</style>

<template>
    <div>
        <SideNav v-bind:activeSection='"home"'/>
        <TitleBar v-bind:sectionTitle='sectionTitle'/>
        <div class="content">
            <div class="container">

                <div class="row">
                    <div>
                        <h5> <b>Hey ! Bienvenue :) </b></h5>
                    </div>
                    <div class="light">
                        Ce blog regroupe les différents billets que j'écris au fur et à mesure de mes expériences.
                        Attention /!\ mes écrits n'engagent que moi. :)
                    </div>
                    <div class="row"><h6><b>Derniers billets</b></h6></div>
                   <div class="light"> Liste des derniers billets publiés sur le site, toutes catégories confondues </div>

                    <div class="row margin-top-20">
                        <Card v-for="card in cards" v-bind:card="card" v-bind:key="card.title"/>
                    </div>
                </div>

            </div>
        </div>
        <Footer/>
    </div>
</template>

<script>
  import SideNav from '@/components/thulj/commons/SideNav.vue'
  import TitleBar from '@/components/thulj/commons/TitleBar.vue'
  import Footer from '@/components/thulj/commons/Footer.vue'
  import Card from '@/components/thulj/commons/Card.vue'
  import axios from 'axios'

  export default {
    name: 'Home',
    components: {
      Card,
      SideNav,
      Footer,
      TitleBar
    },
    created () {
      document.title = 'Zthulj blog - Accueil'
    },
    beforeMount () {
      axios.get('http://localhost:8080/api/public/blog/list').then(response => {
        this.cards = response.data
      })
        .catch(e => {

        })
    },
    data: function () {
      return {
        sectionTitle: 'zThulj > Accueil',
        cards: [
        ]
      }
    }
  }
</script>

<style scoped>
    .margin-top-20 {
        margin-top: 20px;
    }

    #index-banner {
        background-image: url("../../assets/header.jpg");
    }

    .decaleLiens {
        margin-left: 20px;
        color: gray;
    }

    .decaleLiens a {
        color: gray;
    }

    .decaleLiens a:hover {
        color: #4B4B4B;
        cursor: pointer;
    }

</style>

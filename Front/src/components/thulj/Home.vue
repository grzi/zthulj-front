<template>
    <div>
        <SideNav v-bind:activeSection='"home"'/>
        <TitleBar v-bind:sectionTitle='sectionTitle'/>
        <div class="content">
            <div class="container">

                <div class="row">
                    <div>
                        <div class="title-home">Bienvenue, voyageur.</div>
                    </div>
                    <div class="light margin-top-20">
                        <div>Je suis <span class="boldNormal">Jérémy</span>, consultant Zenika <span class="boldNormal">passionné</span> ! </div>
                        <div class="margin-top-20">Je ne savais pas quoi faire alors j'ai fait ce blog !
                        Je le voyais comme un moyen de tester vue.js, et de me construire un référentiel perso pour mes notes.
                            Il présente mes <span class="boldNormal">pensées</span> et <span class="boldNormal">capitalisations</span>sur divers sujets (tech, projets, cuisine, sport...
                        toute les choses que je souhaite écrire)
                        </div>
                    </div>
                    <div class="light margin-top-20">
                        <b>Mes écrits n'engagent que moi.</b>
                    </div>
                    <div class="subTitle-home margin-top-20">
                        Derniers articles
                    </div>
                   <div class="light"> Liste des derniers articles publiés sur le site, toutes catégories confondues </div>

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
  import SideNav from '@/components/thulj/structure/SideNav.vue'
  import TitleBar from '@/components/thulj/structure/TitleBar.vue'
  import Footer from '@/components/thulj/structure/Footer.vue'
  import Card from '@/components/thulj/article/Card.vue'
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
      axios.get(process.env.ROOT_API + 'api/public/blog/list').then(response => {
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

    .title-home{
        font-weight: lighter;
        font-size:32px;
        color:#444;
    }

    .subTitle-home{
        font-weight: lighter;
        font-size:24px;
        color:#444;
    }

    .decaleLiens a {
        color: gray;
    }

    .decaleLiens a:hover {
        color: #4B4B4B;
        cursor: pointer;
    }
    .boldNormal{font-weight:bold;}

</style>

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
                    <div class="row light margin-top-20">
                        <div class="col s12 m12 l8">
                            <div>Je suis <span class="boldNormal">Jérémy</span>, consultant Zenika <span class="boldNormal">passionné</span> ! </div>
                            <div class="margin-top-20">Je ne savais pas quoi faire alors j'ai fait ce blog !</div>
                            <div class="margin-top-20">Je le voyais comme un moyen de tester vue.js, et de me construire un référentiel perso pour mes notes.
                                Il présente mes <span class="boldNormal">pensées</span> et <span class="boldNormal">capitalisations</span> sur divers sujets (tech, projets, cuisine, sport...
                            toutes les choses que je souhaite écrire)
                            </div>
                            <div class="subTitle-home margin-top-20">
                                Derniers articles
                            </div>
                            <div id="carousel" class="carousel carousel-slider center">
                                <Card v-for="card in cards" v-bind:card="card" v-bind:key="card.title" class="carousel-item"/>
                            </div>

                            <div class="light margin-top-20">
                                <b>Mes écrits n'engagent que moi.</b>
                            </div>
                        </div>
                        <div class="col s12 m12 l4">
                            <Timeline :id="'zThulj'" :sourceType="'profile'" :options="{ tweetLimit: '2' }"/>
                        </div>
                    </div>
                    <div class="row margin-top-20">

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
  import Timeline from 'vue-tweet-embed/timeline'
  import M from 'materialize-css'

  var loopCarousel = 0
  function initCarousel () {
    var elem = document.querySelector('.carousel')
    // eslint-disable-next-line
    if(elem != null){
      var instance = M.Carousel.init(elem, {
        fullWidth: true
      })
      if (loopCarousel === 0) {
        loopCarousel = setInterval(function () {
          instance.next()
        }, 7000)
      } else {
        clearInterval(loopCarousel)
        loopCarousel = setInterval(function () {
          instance.next()
        }, 5000)
      }
      elem.setAttribute('style', 'height : ' + elem.offsetWidth * 325 / 578 + 'px') // Calcul magique..
    }
  }

  export default {
    name: 'Home',
    components: {
      Card,
      SideNav,
      Footer,
      TitleBar,
      Timeline
    },
    created () {
      document.title = 'Zthulj blog - Accueil'
    },
    mounted () {
      initCarousel()
    },
    updated () {
      initCarousel()
    },
    beforeMount () {
      axios.get(process.env.ROOT_API + 'api/public/blog/list').then(response => {
        this.cards = response.data
      })
        .catch(e => {

        })
      M.Carousel.init({
        fullWidth: true,
        indicators: true
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

    .carousel{
        margin-top:20px;
        height:250px !important;
    }

</style>

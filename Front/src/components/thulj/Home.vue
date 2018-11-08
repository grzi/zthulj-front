<template>
    <div>
        <SideNav v-bind:activeSection='"home"'/>
        <TitleBar v-bind:sectionTitle='sectionTitle' :admin="false"/>
        <div class="content">
            <div class="container">

                <div class="row">
                    <div>
                        <div class="title-home"><b>Articles</b></div>
                    </div>
                    <div class="row light margin-top-20">
                        <div class="col s12 m12 l8">
                            <Card v-for="card in cards" v-bind:card="card" v-bind:key="card.title" class="carousel-item"/>
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
    var elem = document.getElementById('carousel')
    // eslint-disable-next-line
    if(elem != null && elem != 'undefined') {
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
        font-size:28px;
        color:#444;
        margin-bottom:10px;
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

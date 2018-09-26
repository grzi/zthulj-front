<template>
    <div>
        <SideNav :activeSection='"newspaper"'></SideNav>
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

  export default {
    name: 'Blog',
    components: {
      Card,
      SideNav,
      Footer,
      TitleBar
    },
    created () {
      document.title = 'Blog - Thulj.fr'
    },
    data: function () {
      return {
        sectionTitle: 'zThulj > Blog',
        articles: [
          {
            title: 'Le site fait peau neuve !',
            description: 'I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.',
            publishDate: '27/08/2018',
            icon: 'newspaper',
            section: 'blog',
            link: 'boyouboyuyou'
          },
          {
            title: 'Le site fait peau neuve !',
            description: 'I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.',
            publishDate: '27/08/2018',
            icon: 'newspaper',
            section: 'blog',
            link: 'areuhareuh'
          },
          {
            title: 'Le site fait peau neuve !',
            description: 'I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.',
            publishDate: '27/08/2018',
            icon: 'code',
            section: 'projects',
            link: 'dklzdjzlekdjzekljd'
          },
          {
            title: 'Le site fait peau neuve !',
            description: 'I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.',
            publishDate: '27/08/2018',
            icon: 'code',
            section: 'projects',
            link: 'straaaaaate'
          }
        ]
      }
    }
  }
</script>

<style scoped>
    .articleLight:hover div {
        background-color: #F2F2F2 !important;
        cursor: pointer;
    }

    .articleLight {
        position: relative;
        color: #333;
    }

    .articleLightContent {
        padding-top: 10px;
        padding-bottom: 10px;
        padding-left: 20px;
        border-bottom: 1px solid #DDD !important;
    }

    .container {
        width: 95%;
    }

    .withMiddleNav {
        padding-left: 547px;
    }

    .middleNav {
        box-shadow: 0 2px 2px 0 rgba(0, 0, 0, 0.14), 0 3px 1px -2px rgba(0, 0, 0, 0.12), 0 1px 5px 0 rgba(0, 0, 0, 0.2);
        width: 400px;
        position: fixed;
        top: 0;
        background: white;
        height: 100%;
        left: 105px;
    }

    .headerNav {
        border-bottom: 1px solid #CCC;
    }

    .selector {
        width: 5px;
        padding: 0px;
        padding-top: 10px;
        padding-bottom: 10px;
        position: absolute;
        height: 100%;
    }
</style>

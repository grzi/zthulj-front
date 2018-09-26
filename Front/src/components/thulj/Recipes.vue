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
    data: function () {
      return {
        sectionTitle: 'zThulj > Recettes',
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
  .container {
    width: 95%;
  }
</style>

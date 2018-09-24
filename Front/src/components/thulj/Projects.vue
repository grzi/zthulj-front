<template>
  <div>
    <SideNav v-bind:activeSection='"code"'></SideNav>
    <TitleBar v-bind:sectionTitle='sectionTitle'></TitleBar>
    <Footer></Footer>
  </div>

</template>

<script>
  import SideNav from '@/components/thulj/commons/SideNav.vue'
  import TitleBar from '@/components/thulj/commons/TitleBar.vue'
  import Footer from '@/components/thulj/commons/Footer.vue'

  export default {
    name: 'Projects',
    components: {
      SideNav,
      Footer,
      TitleBar
    },
    created () {
      document.title = 'Projets - Thulj.fr'
    },
    data: function () {
      return {
        sectionTitle: 'zThulj > Projets'
      }
    }
  }
</script>

<style scoped>

</style>

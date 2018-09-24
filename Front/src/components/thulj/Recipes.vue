<template>
  <div>
    <SideNav v-bind:activeSection='"utensils"'></SideNav>
    <TitleBar v-bind:sectionTitle='sectionTitle'></TitleBar>
    <Footer></Footer>
  </div>

</template>

<script>
  import SideNav from '@/components/thulj/commons/SideNav.vue'
  import TitleBar from '@/components/thulj/commons/TitleBar.vue'
  import Footer from '@/components/thulj/commons/Footer.vue'

  export default {
    name: 'Recipes',
    components: {
      SideNav,
      Footer,
      TitleBar
    },
    created () {
      document.title = 'Recettes'
    },
    data: function () {
      return {
        sectionTitle: 'zThulj > Recettes'
      }
    }
  }
</script>

<style scoped>

</style>

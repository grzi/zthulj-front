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
            </div>

        </div>
    </div>
</template>

<script>
  import SideNav from '@/components/thulj/structure/SideNav.vue'
  import TitleBar from '@/components/thulj/structure/TitleBar.vue'
  import Footer from '@/components/thulj/structure/Footer.vue'
  export default {
    name: 'AdminHub',
    components: {
      SideNav,
      Footer,
      TitleBar
    }
  }
</script>

<style scoped>

</style>

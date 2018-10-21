<template>
  <div>
    <ul class="sidenav sidenav-fixed blue-grey darken-3">
      <li class="logoLi">
        <router-link to="/" class="logo">
          <img alt="Vue logo" src="../../../assets/jbandit-fox-75.png"/>
        </router-link>
      </li>
      <li>
        <div class="divider logoDivider"></div>
      </li>
      <li :class='{active:activeSection=="home"}'><router-link to="/" title="Accueil">
        <font-awesome-icon icon="home" size="2x"/>
      </router-link></li>
      <li :class='{active:activeSection=="cv"}'><router-link to="/about" title="à propos">
        <font-awesome-icon icon="id-card" size="2x" color="#afcd37"/>
      </router-link></li>
      <li>
        <div class="divider"></div>
      </li>
      <li :class='{active:activeSection=="newspaper"}'><router-link to="/blog" title="Blog">
        <font-awesome-icon icon="newspaper" size="2x" color="#00a0d4"/>
      </router-link></li>
      <li :class='{active:activeSection=="code"}'><router-link to="/projects" title="Projects">
        <font-awesome-icon icon="code" size="2x" color="#df0075"/>
      </router-link></li>

      <li :class='{active:activeSection=="utensils"}'>
        <router-link to="/recipes" title="Recettes">
          <font-awesome-icon icon="utensils" size="2x" color="#e23d27"/>
        </router-link></li>

        <li :class='{active:activeSection=="editPost"}' v-if="this.access_token !== ''">
            <router-link to="/edit" title="Nouvel article">
                <font-awesome-icon icon="plus-square" size="2x" color="#EEEEEE"/>
            </router-link></li>

    </ul>
    <a href="#" data-target="slide-out" class="sidenav-trigger"><i class="material-icons">menu</i></a>
  </div>
</template>

<script>
  import M from 'materialize-css'

  document.addEventListener('DOMContentLoaded', function () {
    var elems = document.querySelectorAll('.sidenav')
    /* var instances = */
    M.Sidenav.init(elems)
  })
  export default {
    name: 'SideNav',
    mounted () {
    },
    props: {
      msg: String,
      activeSection: String
    },
    computed: {
      access_token () {
        return this.$store.state.access_token
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .sidenav {
    width: 105px;
  }

  .sidenav .logoLi {
    background: #263238;
    height: 105px;
    padding-top: 15px;
  }

  .sidenav .logoLi:hover {
    background: #1f5058;
  }

  .sidenav li .divider {
    margin-top: 0px;
    margin-bottom: 0px
  }

  .sidenav li .logo {
    padding: 0;
    margin-bottom: 40px;
    margin-top: 0px
  }

  *, ::before, ::after {
    box-sizing: content-box;
  }

  .sidenav li a {
    padding: 0;
    text-align: center;
    padding-top: 15px;
    padding-bottom: 15px;
  }

  .sidenav li a {
    color: #cfd8dc
  }

  .sidenav .divider {
    margin-bottom: 15px;
    background-color: #78909c;
  }
  .active{background-color:#1f3139 !important;}
</style>

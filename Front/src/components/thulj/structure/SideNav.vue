<template>
  <div>
    <ul class="sidenav sidenav-fixed blue-grey darken-3 slide-out" id="sidenav">
      <li class="logoLi">
        <router-link to="/" class="logo">
          <img alt="Vue logo" src="../../../assets/jbandit-fox-75.png"/>
        </router-link>
      </li>
      <li>
        <div class="divider logoDivider"></div>
      </li>
      <li :class='{active:activeSection=="home"}'><router-link to="/" title="Accueil">
        <div><font-awesome-icon icon="home" size="2x"/></div>
        <div class="labelsidenav">Accueil</div>
      </router-link></li>
      <li>
        <div class="divider"></div>
      </li>
      <li :class='{active:activeSection=="blog"}'><router-link to="/blog" title="Blog">
        <font-awesome-icon icon="newspaper" size="2x" color="#00a0d4"/>
        <div class="labelsidenav">Blog</div>
      </router-link></li>
      <li :class='{active:activeSection=="projects"}'><router-link to="/projects" title="Projects">
        <font-awesome-icon icon="code" size="2x" color="#df0075"/>
        <div class="labelsidenav">Projets</div>
      </router-link></li>

      <li :class='{active:activeSection=="receipes"}'>
        <router-link to="/recipes" title="Recettes">
          <font-awesome-icon icon="utensils" size="2x" color="#e23d27"/>
          <div class="labelsidenav">Recettes</div>
        </router-link></li>

        <li :class='{active:activeSection=="editPost"}' v-if="this.access_token !== ''">
            <router-link to="/admin" title="Nouvel article">
                <font-awesome-icon icon="edit" size="2x" color="#EEEEEE"/>
              <div class="labelsidenav">Admin</div>
            </router-link></li>

    </ul>
      <div data-target="sidenav" class="sidenav-trigger black-text menuIcon"><font-awesome-icon icon="bars" size="2x" color="#222"/></div>
  </div>
</template>

<script>
  import M from 'materialize-css'

  export default {
    name: 'SideNav',
    mounted () {
      this.instance = M.Sidenav.init(document.getElementById('sidenav'))
    },
    beforeRouteEnter () {
      M.Sidenav.init(document.getElementById('sidenav'))
    },
    props: {
      msg: String,
      activeSection: String
    },
    computed: {
      access_token () {
        return this.$store.state.auth.access_token
      }
    },
    data: function () {
      return {
        instance: {}
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .menuIcon{
    position:fixed;
    z-index:500;
    top:20px;
    left:15px;
    transform:none;
    -webkit-transform: none;
  }
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
    text-align: center;
    padding: 15px 0;
  }
  .labelsidenav{
    font-size:12px;
    padding-top:3px;
    font-weight: lighter;
  }

  .sidenav li a {
    color: #cfd8dc;
    line-height:20px;
  }

  .sidenav .divider {
    margin-bottom: 15px;
    background-color: #78909c;
  }
  .active{background-color:#1f3139 !important;}
</style>

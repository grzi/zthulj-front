<template>
    <div id="app">
        <router-view></router-view>
    </div>
</template>

<script>
  import axios from 'axios'
  export default {
    name: 'app',
    components: {
    },
    computed: {
      access_token () {
        return this.$store.state.auth.access_token
      }
    },
    mounted () {
      if (this.access_token !== '') {
        axios.post(process.env.ROOT_API + 'api/secured/user/check_token',
                   '',
                   {
                     headers: {
                       'authorization': 'Bearer ' + this.access_token
                     }
        })
          .then(response => {})
          .catch(e => {
            console.log(e)
            this.$store.commit('auth/changeToken', '')
          })
      }
    }
  }
</script>

<style>
    body {
        background: white;
        font-family: 'Source Code Pro', monospace;
        font-weight: 500;
    }
    .content { margin-top:10px; min-height:600px; }
    .articleContent h1{font-size:30px !important;font-weight:500;}
    .articleContent h2{font-size:27px !important;font-weight:500;}
    .articleContent h3{font-size:24px !important;font-weight:500;}
    .articleContent h4{font-size:21px !important;font-weight:500;}
    .articleContent h5{font-size:18px !important;font-weight:500;}
    .articleContent h6{font-size:15px !important;font-weight:500;}
    .articleContent ul li {list-style-type: disc !important;}
    .articleContent ul {margin-left:30px;}
    .articleContent img{width:80%;margin-left:10%;}
</style>

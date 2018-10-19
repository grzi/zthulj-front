<template>
    <div>
        <a class="modal-trigger" href="#loginmodal">Login</a>
        <div id="loginmodal" class="modal">
            <div class="modal-content black-text">
                <h4>Login</h4>
                <div class="row">
                    <div class="input-field col s12">
                        <input placeholder="Username" id="first_name" type="text" class="validate" v-model="user">
                        <label for="first_name" class="forceActive active">First Name</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input placeholder="Password" id="password" type="password" class="validate" v-model="password">
                        <label for="password" class="forceActive active">Password</label>
                    </div>
                </div>
                <div class="red lighten-2 waves-effect waves-light btn" v-on:click="login">Connect</div>
            </div>
        </div>
    </div>

</template>

<script>
  import M from 'materialize-css'
  import axios from 'axios'
  export default {
    name: 'Login',
    mounted () {
      var elem = document.getElementById('loginmodal')
      M.Modal.init(elem, null)
    },
    methods: {
      login: function () {
        axios.post('http://localhost:8080/oauth/token?grant_type=password&username=' + this.user + '&password=' + this.password,
                   '',
                   {
                     headers:
                       {
                         'content-type': 'application/x-www-form-urlencoded',
                         'authorization': 'Basic ' + 'dGVzdENsaWVudDpjbGllbnRpZA=='
                       }
        })
          .then(response => {
            console.log('token : ' + this.$store.state.access_token)
            this.$store.state.access_token = response.data.access_token
          })
          .catch(e => {
          })
      }
    },
    data: function () {
      return {
        user: '',
        password: ''
      }
    }
  }
</script>

<style scoped>

</style>

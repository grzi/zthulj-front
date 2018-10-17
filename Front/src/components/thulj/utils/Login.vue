<template>
    <div>
        <a class="modal-trigger" href="#loginmodal">Login</a>
        <div id="loginmodal" class="modal">
            <div class="modal-content black-text">
                <h4>Login</h4>
            </div>
        </div>
    </div>

</template>

<script>
  import M from 'materialize-css'
  export default {
    name: 'Login',
    mounted () {
      document.addEventListener('DOMContentLoaded', function () {
        var elem = document.getElementById('loginmodal')
        M.Modal.init(elem, null)
      })
    }
  }
</script>

<style scoped>

</style>

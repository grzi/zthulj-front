<template>
    <footer class="page-footer teal blue-grey">
        <div class="container ">
            <div class="row">
                <div class="col l6 s12">
                    <h5 class="white-text">Contacts</h5>
                    <p class="grey-text text-lighten-4">
                        En cas de besoin, vous pouvez toujours me retrouver <br/>sur ces
                        r&eacute;seaux sociaux :
                    </p>
                    <a target="blank" href="https://www.facebook.com/thulliezj"
                       class="waves-effect waves-light"><img
                            src="../../../assets/facebook.png" class="icon"/></a> <a target="blank"
                                                                                     href="https://www.linkedin.com/in/jeremythulliez/"
                                                                                     class="waves-effect waves-light"><img
                        src="../../../assets/linkedin.png" class="icon"/></a> <a target="blank"
                                                                                 href="https://github.com/grzi/"
                                                                                 class="waves-effect waves-light"><img
                        src="../../../assets/github.png" class="icon"/></a>
                </div>
                <div class="col l6 s12">
                    <h5 class="white-text">Liens utiles</h5>
                    <ul>
                        <li><a class="white-text" href="/cv">Curriculum Vitae</a></li>
                        <li><a class="white-text" href="/blog">Blog</a></li>
                        <li><Login></Login></li>
                    </ul>
                </div>
                <div class="col l3 s12">
                    <h5 class="white-text"></h5>

                </div>
            </div>
        </div>
        <div class="footer-copyright blue-grey darken-3">
            <div class="container">
                Made by Jeremy Thulliez, using <a target="blank"
                                                  class="brown-text text-lighten-3" href="http://materializecss.com">Materialize</a>
            </div>
        </div>
    </footer>
</template>

<script>
  import Login from '@/components/thulj/utils/Login.vue'
  export default {
    name: 'Footer',
    components: {
      Login
    }
  }
</script>

<style scoped>
    .icon {
        width: 35px;
        margin-left: 5px;
    }
</style>

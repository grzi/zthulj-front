<template>
    <div>
        <SideNav :activeSection='"editPost"'></SideNav>
        <TitleBar :sectionTitle='sectionTitle'></TitleBar>
        <div class="content">
            <div class="container center">
                <div class="row">
                    <form class="col s12">
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="objectId" type="text" disabled>
                                <label for="objectId">ObjectId</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input placeholder="Titre de l'article" id="title" type="text">
                                <label for="title">Titre</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input placeholder="Lien de l'article" id="link" type="text">
                                <label for="title">Link</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <textarea id="content"></textarea>
                            </div>
                        </div>
                        <div class="row">
                            <div class="btn" v-on:click='convertAndPreview()'>Mettre à jour le preview</div>
                        </div>
                        <div class="row">
                            <div class="btn" v-on:click='saveArticle()'>Sauvegarder l'article</div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12 presee blogpost" id="presee">

                            </div>
                        </div>

                    </form>
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
  import M from 'materialize-css'
  import axios from 'axios'

  export default {
    name: 'Edit',
    components: {
      SideNav,
      Footer,
      TitleBar
    },
    mounted () {
      M.updateTextFields()
      M.textareaAutoResize(document.getElementById('content'))
    },
    methods: {
      convertAndPreview: function () {
        axios.post('http://localhost:8080/api/md/convertToHtml', {'text': document.getElementById('content').value}).then(response => {
          // JSON responses are automatically parsed.
          document.getElementById('presee').innerHTML = response.data
          console.log(response.data)
        })
          .catch(e => { })
      },
      saveArticle: function () {
        var objId = document.getElementById('objectId').value
        var article = {
          id: (objId === null || objId === '') ? null : objId,
          link: document.getElementById('link').value,
          value: {
            title: document.getElementById('title').value,
            subtitle: '',
            author: 'zThulj',
            content: document.getElementById('content').value,
            category: 'BlogPost'
          }
        }
        axios.post('http://localhost:8080/api/blog/push', article).then(response => {

        })
          .catch(e => { })
      }
    },
    data: function () {
      return {
        sectionTitle: 'zThulj > Editer Article'
      }
    }
  }
</script>

<style scoped>
.presee{text-align:left;}
    #content{background:white;min-height:300px;padding:15px;border:1px solid gray;text-align:left;}
</style>

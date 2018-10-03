<template>
    <div>
        <SideNav :activeSection='"editPost"'></SideNav>
        <TitleBar :sectionTitle='sectionTitle'></TitleBar>
        <div class="content">
            <div class="container center">
                <h4>Modification d'un article</h4>
                <div class="row">
                    <form class="col s12">
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="objectId" type="text" disabled v-model="article.id">
                                <label for="objectId" class="forceActive active">Id de l'article</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input placeholder="Titre de l'article" id="title" type="text" v-model="article.value.title">
                                <label for="title">Titre</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input placeholder="Lien de l'article" id="link" type="text" v-model="article.link">
                                <label for="title">Link</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <textarea id="content" v-model="article.value.content"></textarea>
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
        })
          .catch(e => { })
      },
      saveArticle: function () {
        this.article.id = (this.article.id === null || this.article.id === '') ? '' : this.article.id
        axios.post('http://localhost:8080/api/blog/push', this.article).then(response => {
          this.article = response.data
          M.updateTextFields()
        })
          .catch(e => { })
      }
    },
    data: function () {
      return {
        sectionTitle: 'zThulj > Editer Article',
        article: {id: null, link: '', value: {title: '', content: ''}}
      }
    }
  }
</script>

<style scoped>
.presee{text-align:left;}
    #content{background:white;min-height:300px;padding:15px;border:1px solid gray;text-align:left;}
.forceActive {
    -webkit-transform: translateY(-14px) scale(0.8);
    transform: translateY(-14px) scale(0.8);
    -webkit-transform-origin: 0 0;
    transform-origin: 0 0;
}
</style>

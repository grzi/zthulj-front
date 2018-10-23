<template>
    <div>
        <SideNav :activeSection='"editPost"'></SideNav>
        <TitleBar :sectionTitle='sectionTitle'></TitleBar>
        <div class="content">
            <div class="container center">
                <h4>Modification d'un article</h4>
                <div class="row" id="alert_box" v-bind:class="messageboxclass">
                    <div class="col s12 m12">
                        <div class="card" v-bind:class="messageColor">
                            <div class="row">
                                <div class="col s12 m10">
                                    <div class="card-content white-text left-align" id="message">
                                        {{ messageinfo }}
                                    </div>
                                </div>
                                <div class="col s12 m2">
                                    <i class="fa fa-times icon_style" id="alert_close" aria-hidden="true"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
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
                                <input id="objectSection" type="text" disabled v-model="article.category">
                                <label for="objectId" class="forceActive active">Catégorie de l'article</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input placeholder="Titre de l'article" id="title" type="text" v-model="article.title">
                                <label for="title">Titre</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input placeholder="Description de l'article" id="description" type="text" v-model="article.description">
                                <label for="title">Description</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input placeholder="Lien de l'article" id="link" type="text" v-model="article.link">
                                <label for="title">Link</label>
                            </div>
                        </div>
                        <div class="row no-margin-bottom">
                            <div class="input-field col s12">
                                <textarea id="content" v-model="article.value.contentMD"></textarea>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <MarkdownPalette v-on:paletteChange="paletteChange"></MarkdownPalette>
                            </div>
                        </div>
                        <div class="row">
                            <div class="btn" v-on:click='convertAndPreview()'>Preview</div>
                        </div>
                        <div class="row">
                            <div class="btn" v-on:click='saveArticle()'>Sauvegarder l'article</div>
                        </div>
                        <div id="modal1" class="modal">
                            <div class="modal-content presee blogpost" id="presee">
                                <ArticleContent :article="article" :access_token="''"></ArticleContent>
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
  import MarkdownPalette from '@/components/thulj/utils/MarkdownPalette.vue'
  import ArticleContent from '@/components/thulj/commons/ArticleContent.vue'
  import M from 'materialize-css'
  import axios from 'axios'
  import Prism from 'prismjs'

  export default {
    name: 'Edit',
    components: {
      SideNav,
      Footer,
      TitleBar,
      MarkdownPalette,
      ArticleContent
    },
    beforeMount () {
      if (typeof this.$route.params.link !== 'undefined') {
        axios.get('http://localhost:8080/api/public/blog/full/' + this.$route.params.link).then(response => {
          this.article = response.data
        })
      }
    },
    mounted () {
      M.updateTextFields()
      M.textareaAutoResize(document.getElementById('content'))
      var elem = document.getElementById('modal1')
      M.Modal.init(elem, null)
    },
    methods: {
      convertAndPreview: function () {
        axios.post('http://localhost:8080/api/secured/md/convertToHtml',
                   {'text': this.article.value.contentMD},
                   {
                     headers: {
                       'authorization': 'Bearer ' + this.$store.state.access_token
                     }
                   }
        ).then(response => {
          // JSON responses are automatically parsed.
          var test = response.data
          Prism.highlightAll(test)
          this.article.value.contentHtml = test
          M.Modal.getInstance(document.getElementById('modal1')).open()
        }
        )
          .catch(e => { })
      },
      saveArticle: function () {
        this.article.id = (this.article.id === null || this.article.id === '') ? '' : this.article.id
        axios.post('http://localhost:8080/api/secured/blog/push', this.article,
                   {
                     headers: {
                       'authorization': 'Bearer ' + this.$store.state.access_token
                     }
        }).then(response => {
          this.article = response.data
          if (response.status === 400) {

          }
          this.messageboxclass = 'forceDisplay'
          this.messageColor = 'green lighten-2'
          this.messageinfo = 'Article enregistré'
          window.scrollTo(0, 0)
          M.updateTextFields()
        })
          .catch(e => {
            this.messageboxclass = 'forceDisplay'
            this.messageColor = 'red lighten-2'
            this.messageinfo = e.response.data
            window.scrollTo(0, 0)
          })
      },
      paletteChange: function (md) {
        this.article.value.contentMD += md
      }
    },
    data: function () {
      return {
        messageboxclass: '',
        messageinfo: '',
        messageColor: '',
        sectionTitle: 'zThulj > Editer Article',
        article: {id: null, link: '', category: 'blog', title: '', value: {contentMD: '', contentHtml: ''}}
      }
    }
  }
</script>

<style scoped>
    #content{background:white;min-height:300px;padding:15px;border:1px solid gray;text-align:left;}

.forceDisplay{display:inline !important;}
.icon_style{
    position: absolute;
    right: 10px;
    top: 10px;
    font-size: 20px;
    color: white;
    cursor:pointer;
}
    .forceActive {
        -webkit-transform: translateY(-14px) scale(0.8);
        transform: translateY(-14px) scale(0.8);
        -webkit-transform-origin: 0 0;
        transform-origin: 0 0;
    }
    #alert_box{display:none;}
</style>

<template>
    <div>
        <SideNav :activeSection='"editPost"'></SideNav>
        <TitleBar :sectionTitle='sectionTitle' :admin="true"></TitleBar>
        <div class="content">
            <div class="container center">
                <h4>Edition d'un article</h4>
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
                    <div class="btn" v-on:click='reset()'>Nouvel article</div>
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
                                <select id="objectSection" type="text" v-model="article.category">
                                    <option>blog</option>
                                    <option>projects</option>
                                    <option>recipes</option>
                                </select>
                                <label for="objectId" class="forceActive active">Catégorie de l'article</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12 left-align">
                                Etat de l'article :
                                <form action="#">
                                    <p>
                                        <label>
                                            <input name="group1" value="true" type="radio" v-model="article.published"/>
                                            <span>Publié</span>
                                        </label>
                                    </p>
                                    <p>
                                        <label>
                                            <input name="group1" value="false" type="radio"
                                                   v-model="article.published"/>
                                            <span>Brouillon</span>
                                        </label>
                                    </p>
                                </form>
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
                                <input placeholder="Description de l'article" id="description" type="text"
                                       v-model="article.description">
                                <label for="title">Description</label>
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
                                <input placeholder="Image card" id="imageCard" type="text" v-model="article.imageCard">
                                <label for="title">Image Card (Lien vers l'image card)</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <MarkdownPalette :val='article.value.contentMD'
                                                 v-model="article.value.contentMD"></MarkdownPalette>
                            </div>
                        </div>

                        <div class="row">
                            <div class="btn" v-on:click='uploadFile()'>Upload File</div>
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

                        <div id="modal2" class="modal">
                            <div class="modal-content">
                                <div class="row">
                                    <div class="col s12">
                                        <h3>Uploader un fichier</h3>
                                        <form action="#" class="col s12">
                                            <div class="file-field input-field">
                                                <div class="btn">
                                                    <span>File</span>
                                                    <input type="file">
                                                </div>
                                                <div class="file-path-wrapper">
                                                    <input class="file-path validate" type="text">
                                                </div>
                                            </div>
                                        </form>
                                        <div class="row">
                                            <div class="btn" v-on:click='uploadRequest()'>Uploader</div>
                                        </div>
                                    </div>
                                </div>
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
  import SideNav from '@/components/thulj/structure/SideNav.vue'
  import TitleBar from '@/components/thulj/structure/TitleBar.vue'
  import Footer from '@/components/thulj/structure/Footer.vue'
  import MarkdownPalette from '@/components/thulj/admin/MarkdownPalette.vue'
  import ArticleContent from '@/components/thulj/article/ArticleContent.vue'
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
      this.loadArticleFromRoute()
    },
    mounted () {
      M.updateTextFields()
      M.textareaAutoResize(document.getElementById('content'))
      var elem = document.getElementById('modal1')
      M.Modal.init(elem, null)
      var elem2 = document.getElementById('modal2')
      M.Modal.init(elem2, null)
      var elems = document.querySelectorAll('select')
      M.FormSelect.init(elems, null)
    },
    methods: {
      reset: function () {
        this.article = {
          id: null,
          link: '',
          category: 'blog',
          title: '',
          published: false,
          value: {contentMD: '', contentHtml: ''}
        }
      },
      loadArticleFromRoute: function () {
        if (typeof this.$route.params.link !== 'undefined') {
          axios.get(process.env.ROOT_API + 'api/secured/blog/full/' + this.$route.params.link, {
            headers: {
              'authorization': 'Bearer ' + this.$store.state.access_token
            }
          }).then(response => {
            this.article = response.data
          })
        }
      },
      convertAndPreview: function () {
        axios.post(process.env.ROOT_API + 'api/secured/md/convertToHtml',
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
          .catch(e => {
          })
      },
      saveArticle: function () {
        this.article.id = (this.article.id === null || this.article.id === '') ? '' : this.article.id
        axios.post(process.env.ROOT_API + 'api/secured/blog/push', this.article,
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
      uploadFile () {
        M.Modal.getInstance(document.getElementById('modal2')).open()
      },
      uploadRequest () {
        const formData = new FormData();
        //TODO : formData.append('file', );
        formData.append('id', 7878);
        axios.post('/api/uploadFile', formData)
          .then(function (result) {
            console.log(result)
          }, function (error) {
            console.log(error)
          })
      }
    },
    data: function () {
      return {
        messageboxclass: '',
        messageinfo: '',
        messageColor: '',
        sectionTitle: 'zThulj > Editer',
        article: {
          id: null,
          link: '',
          category: 'blog',
          title: '',
          published: false,
          value: {contentMD: '', contentHtml: ''}
        }
      }
    },
    watch: {
      '$route' (newId, oldId) {
        // debug materializecss
        let overlays = document.getElementsByClassName('sidenav-overlay')
        for (var i = 0; i < overlays.length; i++) {
          overlays[i].remove()
        }
        this.loadArticleFromRoute()
      }
    }
  }
</script>

<style scoped>

    .forceDisplay {
        display: inline !important;
    }

    .icon_style {
        position: absolute;
        right: 10px;
        top: 10px;
        font-size: 20px;
        color: white;
        cursor: pointer;
    }

    .forceActive {
        -webkit-transform: translateY(-14px) scale(0.8);
        transform: translateY(-14px) scale(0.8);
        -webkit-transform-origin: 0 0;
        transform-origin: 0 0;
    }

    #alert_box {
        display: none;
    }
</style>

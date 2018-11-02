<template>
    <nav class="white" :class="customClasses">
        <div class="nav-wrapper ">
            <div class="row">
                <div class="col s2">
                    <span class="brand-logo black-text">{{sectionTitle}}</span>
                </div>
                <div class="col s9">
                    <div class="header-search-wrapper hide-on-med-and-down sideNav-lock relative">
                        <font-awesome-icon icon="search" size="2x" class="iconInput" color="gray"/>
                        <input name="Search" ref="keyword" class="header-search-input z-depth-2"
                               placeholder="Chercher... (3 caractères minimum)"
                               type="text" v-model='keywords' v-on:keyup="searchArticles" v-on:blur="resetSearchClass"
                               v-on:focus="searchArticles">
                        <div class="searchResult" v-bind:class="resultsClass" v-on:mouseenter="mouseInResults=true"
                             v-on:mouseleave="mouseLeave">
                            <div v-for="card in results.content" v-bind:key="card.title" class="resultLink">
                                <router-link v-if="admin" @click.native="reset()" :to='"/edit/" + card.link'
                                             class="linkSearch">
                                    <span><b>{{card.category}}</b></span> > <span>{{card.title}}</span>
                                </router-link>
                                <router-link v-else @click.native="reset()" :to='"/" + card.category + "/" + card.link'
                                             class="linkSearch">
                                    <span><b>{{card.category}}</b></span> > <span>{{card.title}}</span>
                                </router-link>
                            </div>
                            <div class="seeAllResults" v-on:click="seeAllResult()">
                                Voir tous les résultats ({{results.totalElements}} Résultat<span
                                    v-if="results.totalElements>1">s</span>)
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="searchmodal" class="modal">
            <div class="modalResultList row">
                <div class="container">
                    <h3>Résultats de recherche pour '{{this.lastSearch}}'</h3>
                    <Card v-for="article in results.content" v-bind:card="article" v-bind:key="article.title"
                          :class="'col s12 m12 l12'"></Card>
                </div>
            </div>
            <ul class="custompagination">
                <li class="disabled paginationPage" :class="{disabled: results.number<1}">
                    <a v-on:click="chevronLeft()">
                    <font-awesome-icon icon="chevron-left"/>
                </a></li>

                <li v-for="i in (1,results.totalPages)" :key="i" class="paginationPage"
                    :class="{active:i==results.number+1}"
                ><a v-on:click="requestSearch(lastSearch,i)">{{i}}</a>
                </li>

                <li class="paginationPage" :class="{disabled: results.number>results.totalPages-1}">
                    <a v-on:click="chevronRight()">
                    <font-awesome-icon icon="chevron-right"/>
                </a></li>
            </ul>
        </div>
    </nav>
</template>

<script>
  import axios from 'axios'
  import M from 'materialize-css'
  import Card from '@/components/thulj/article/Card.vue'

  export default {
    name: 'TitleBar',
    components: {
      Card
    },
    props: ['sectionTitle', 'customClasses', 'admin'],
    methods: {
      chevronLeft: function () {
        if (this.results.number > 0) { this.requestSearch(this.lastSearch, this.results.number) }
      },
      chevronRight: function () {
        if (this.results.number < this.results.totalPages - 1) { this.requestSearch(this.lastSearch, this.results.number + 2) }
      },
      reset: function () {
        this.resultsClass = ''
        this.keywords = ''
      },
      searchArticles: function () {
        if (this.keywords.length > 2) {
          this.requestSearch(this.keywords, 1, true)
        } else {
          this.resultsClass = ''
        }
      },
      requestSearch: function (keywords, page, updateResClasses) {
        let url = 'api/public/blog/search/'
        let headers = {}
        if (this.admin === true) {
          url = 'api/secured/blog/searchAdmin/'
          headers = {
            headers: {
              'authorization': 'Bearer ' + this.$store.state.access_token
            }
          }
        }

        axios.get(process.env.ROOT_API + url + keywords + '/' + page, headers).then(response => {
          this.results = response.data
          if (this.results.content.length > 0 && updateResClasses) {
            this.resultsClass = 'forceDisplay'
          } else {
            this.resultsClass = ''
          }
        })
          .catch(e => {
            this.resultsClass = ''
          })
      },
      resetSearchClass: function () {
        if (!this.mouseInResults) {
          this.resultsClass = ''
        }
      },
      mouseLeave: function () {
        this.mouseInResults = false
        this.$refs.keyword.focus()
      },
      seeAllResult: function () {
        this.lastSearch = this.keywords
        this.reset()
        M.Modal.getInstance(this.elemModal).open()
      }
    },
    data: function () {
      return {
        keywords: '',
        lastSearch: '',
        results: {
          'content': [],
          'pageable': {},
          'totalPages': 0,
          'totalElements': 0,
          'last': true,
          'size': 0,
          'numberOfElements': 0,
          'first': false,
          'number': 0,
          'sort': {'sorted': false, 'unsorted': true, 'empty': true},
          'empty': false
        },
        resultsClass: '',
        mouseInResults: false,
        elemModal: {}
      }
    },
    mounted () {
      this.elemModal = document.getElementById('searchmodal')
      M.Modal.init(this.elemModal, null)
    }
  }
</script>

<style scoped>
    nav {
        position: fixed;
        top: 0;
        z-index: 50
    }

    @media only screen and (min-width: 992px) {
        nav {
            padding-left: 120px;
        }

        .withMiddleNav {
            padding-left: 60px;
            z-index: 0
        }
    }

    .brand-logo {
        font-size: 18px;
        font-weight: lighter;
    }

    .withMiddleNav {
        left: 485px;
    }

    .custompagination {
        width: 100%;
        height: 5%;
        text-align: center;
        bottom: 3%;
        position: absolute;
    }

    .paginationPage {
        display: inline-block;
        *display: inline; /*IE7*/;
        margin-right: 5px;
        float: none !important;
        height: 40px;
        line-height: 2.7;

    }

    .paginationPage a {
        color: #333;
    }

    .custompagination .active {
        background-color: #37474f;
    }

    .custompagination .active a {
        color: white;

    }

    .header-search-input {
        margin-left: 65px !important;
        padding-left: 8px !important;
        font-size: 14px !important;
        width: 100%;
    }

    .iconInput {
        position: absolute;
        font-size: 24px;
        top: 6px;
        margin-left: 24px;
        margin-top: 18px;
        line-height: 32px !important;
        -webkit-transition: color 200ms ease;
        transition: color 200ms ease;
    }

    .relative {
        position: relative;
    }

    .searchResult {
        position: absolute;
        background: white;
        border: 1px solid #EEE;
        margin-left: 65px;
        width: 50%;
        color: #222;
        display: none;
    }

    .percent50height {
        height: 50%
    }

    .forceDisplay {
        display: block !important;
    }

    .modalResultList, #searchmodal {
        height: 80%;
    }

    .modalResultList .container {
        padding-top:10px;
        width: 95%;
    }

    .modalResultList {
        overflow: scroll;
    }

    #searchmodal {
        max-height: 80% !important;
        line-height: 20px;
        color: #111 !important;
    }

    .linkSearch {
        color: #222;
    }

    .linkSearch:hover {
        text-decoration: underline;
    }

    .resultLink {
        padding-left: 10px;
    }

    .seeAllResults {
        text-align: center;
        color: #999;
        border-top: 1px solid #F3F3F3;
    }

    .seeAllResults:hover {
        cursor: pointer;
        background: #F1F1F1;
    }
</style>

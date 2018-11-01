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
                        <input name="Search" ref="keyword" class="header-search-input z-depth-2" placeholder="Chercher. . ."
                               type="text" v-model='keywords' v-on:keyup="searchArticles" v-on:blur="resetSearchClass" v-on:focus="searchArticles">
                        <div class="searchResult" v-bind:class="resultsClass" v-on:mouseenter="mouseInResults=true" v-on:mouseleave="mouseLeave">
                            <div v-for="result in results" v-bind:key="result.title" class="resultLink">
                                <router-link v-if="admin" @click.native="reset()" :to='"/edit/" + result.link' class="linkSearch" >
                                    <span><b>{{result.category}}</b></span> > <span>{{result.title}}</span>
                                </router-link>
                                <router-link v-else @click.native="reset()" :to='"/" + result.category + "/" + result.link' class="linkSearch" >
                                    <span><b>{{result.category}}</b></span> > <span>{{result.title}}</span>
                                </router-link>
                            </div>
                            <div class="seeAllResults">
                                Voir tous les résultats
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</template>

<script>
  import axios from 'axios'
  export default {
    name: 'TitleBar',
    props: ['sectionTitle', 'customClasses', 'admin'],
    methods: {
      reset: function () {
        this.resultsClass = ''
        this.keywords = ''
      },
      searchArticles: function () {
        if (this.keywords.length > 0) {
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

          axios.get(process.env.ROOT_API + url + this.keywords, headers).then(response => {
            this.results = response.data
            if (this.results.length > 0) {
              this.resultsClass = 'forceDisplay'
            } else {
              this.resultsClass = ''
            }
          })
            .catch(e => {
              this.resultsClass = ''
            })
        } else {
          this.resultsClass = ''
        }
      },
      resetSearchClass: function () {
        if (!this.mouseInResults) {
          this.resultsClass = ''
        }
      },
      mouseLeave: function () {
        this.mouseInResults = false
        this.$refs.keyword.focus()
      }
    },
    data: function () {
      return {
        keywords: '',
        results: [],
        resultsClass: '',
        mouseInResults: false
      }
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
        font-weight:lighter;
    }

    .withMiddleNav {
        left: 485px;
    }

    .header-search-input{
        margin-left:65px !important;
        padding-left:8px !important;
        font-size:14px !important;
        width:100%;
    }

    .iconInput{
        position: absolute;
        font-size: 24px;
        top: 6px;
        margin-left: 24px;
        margin-top:18px;
        line-height: 32px !important;
        -webkit-transition: color 200ms ease;
        transition: color 200ms ease;
    }
    .relative{position:relative;}
    .searchResult{position:absolute;background:white;border:1px solid #EEE;margin-left: 65px;width:50%;color:#222;display:none;}
    .forceDisplay{display:block !important;}
    .linkSearch{color:#222;}
    .linkSearch:hover{text-decoration: underline;}
    .resultLink{padding-left:10px;}
    .seeAllResults{text-align:center;color:#999;border-top:1px solid #F3F3F3;}
    .seeAllResults:hover{cursor:pointer;background:#F1F1F1;}
</style>

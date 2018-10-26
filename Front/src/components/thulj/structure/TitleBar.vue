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
                        <div class="searchResult" v-bind:class="resultsClass" v-on:mouseenter="mouseInResults=true" v-on:mouseleave="mouseleave">
                            <div v-for="result in results" v-bind:key="result.title">
                                <router-link @click.native="reset()" :to='"/" + result.category + "/" + result.link' class="linkSearch" >
                                    <span><b>{{result.category}}</b></span> > <span>{{result.title}}</span>
                                </router-link>
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
    props: ['sectionTitle', 'customClasses'],
    methods: {
      reset: function () {
        this.resultsClass = ''
        this.keywords = ''
      },
      searchArticles: function () {
        if (this.keywords.length > 0) {
          axios.get(process.env.ROOT_API + 'api/public/blog/search/' + this.keywords).then(response => {
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
      mouseleave: function () {
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
    .searchResult{position:absolute;background:white;border:1px solid #EEE;margin-left: 65px;width:50%;color:#222;display:none;padding-left:10px;}
    .forceDisplay{display:block !important;}
    .linkSearch{color:#222;}
    .linkSearch:hover{text-decoration: underline;}
</style>

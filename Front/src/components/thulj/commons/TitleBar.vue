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
                        <input name="Search" class="header-search-input z-depth-2" placeholder="Chercher. . ."
                               type="text" v-model='keywords' v-on:keyup="searchArticles">
                        <div class="searchResult">
                            <div v-for="result in results" v-bind:key="result.link">
                                <a href="coucou" class="linkSearch">
                                    <span>{{result.value.category}}</span> > <span>{{result.value.title}}</span>
                                </a>
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
      searchArticles: function () {
        axios.get('http://localhost:8080/api/blog/search/' + this.keywords).then(response => {
          this.results = response.data
        })
          .catch(e => { })
      }
    },
    data: function () {
      return {
        keywords: '',
        results: []
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
    .searchResult{position:absolute;background:white;border:1px solid #EEE;margin-left: 65px;width:50%;color:#222;display:none;}

    .linkSearch{color:#222;}
    .linkSearch:hover{text-decoration: underline;}
</style>

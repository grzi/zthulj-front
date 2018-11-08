<template>
    <router-link :to='"/" + card.category + "/" + card.link'>
        <div class="articleCard">

            <div class="headerImg">
                <img :src="card.imageCard"/>
            </div>
            <div class="padding">
                <div class=articleCardContext>De <span class="important">zThulj</span> le <span class="important">{{card.publishDate}}</span>
                </div>
                <div class="articleCardContent">
                    <div class="articleCardInfos">
                        <div class="articleCardTitle">{{card.title}}</div>
                        <div class="articleCardDescription">{{card.description}}
                        </div>
                    </div>
                    <div class="clearboth"></div>
                </div>
            </div>
        </div>
    </router-link>
</template>

<script>
  export default {
    name: 'Card',
    props: ['card'],
    mounted () {
      this.icon = this.transcodeCategoryToIcon(this.card.category)
    },
    updated () {
      this.icon = this.transcodeCategoryToIcon(this.card.category)
    },
    methods: {
      transcodeCategoryToIcon: function (category) {
        switch (category) {
        case 'blog':
          return 'newspaper'
        case 'recipes':
          return 'utensils'
        case 'projects':
          return 'code'
        default:
          return 'newsletter'
        }
      }
    },
    data: function () {
      return {
        icon: ''
      }
    }
  }
</script>

<style scoped>

    .important{
        color:#df0075;
    }

    .padding{
        padding-left: 20px;
        padding-right: 20px;
    }

    .headerImg {
        width: 100%;
        max-height: 125px;
        overflow: hidden;
    }

    .headerImg img{
        width: 100%;
    }

    .articleCardImage, .articleCardInfos {
        float: left;
    }

    .articleCardImage {
        width: 175px;
    }

    .articleCardInfos {
        width: auto;
    }

    .articleCardImage {
        margin-right: 10px;
    }

    .articleCardImage img {
        max-width: 175px;
        max-height: 120px;
    }

    .articleCardContent {
        display: flex;
    }

    .articleCardTitle {
        text-align: left;
        font-size: 20px;
        margin-bottom: 5px;
        font-weight: bold;
        text-transform: none;
        font-weight: 500;
        color: #111;
    }

    .articleCardDescription {
        text-align: left;
        font-size: 14px;
        font-weight: 300 !important;
        color: #222;
        text-transform: none !important;
    }

    .clearboth {
        clear: both;
    }

    .articleCardContext {
        padding-top: 10px;
        padding-bottom: 10px;
        font-size: 12px;
        text-align: left;
        font-weight: 300 !important;
        text-transform: none;
    }

    .articleCard {
        padding-bottom: 15px;
        display: flex;
        flex-direction: column;
        cursor: pointer;
        transition: all .5s ease;
        background-color: white;
        border: 1px solid #DDD;
        margin-bottom: 20px;
    }

    .articleCard:hover {
        -webkit-box-shadow: 1px 1px 18px 0px rgba(0, 0, 0, 0.25);
        -moz-box-shadow: 1px 1px 18px 0px rgba(0, 0, 0, 0.25);
        box-shadow: 1px 1px 18px 0px rgba(0, 0, 0, 0.25);
    }

    .card {
        z-index: 1;
        height: 230px !important;
    }

    .card .card-content {
        padding-top: 12px !important;
    }

    .card-action {
        text-align: left;
        border-top: none;
        border-bottom: 1px solid rgba(160, 160, 160, 0.2);
    }

    .card-image {
        width: 186px;
        overflow: hidden;
    }

    .badge {
        position: absolute;
        right: 0;
        bottom: 0;
        padding: 10px;
        border-left: 1px solid #DDD;
        border-top: 1px solid #DDD;
    }

    .datePublish {
        font-size: 14px;
        text-align: right;
        position: absolute;
        bottom: 15px;
        left: 15px;
    }

    .newspaper, .newspaper a {
        color: #00a0d4 !important;
    }

    .code, .code a {
        color: #df0075 !important;
    }

    .utensils {
        color: #e23d27 !important;
    }

    .bordernewspaper {
        border-bottom: 1px solid #00a0d4 !important;
    }

    .bordercode {
        border-bottom: 1px solid #df0075 !important;
    }

    .borderutensils {
        border-bottom: 1px solid #e23d27 !important;
    }

    a {
        color: black;
        cursor: pointer;
        text-transform: uppercase;
        font-size: 14px;
        font-weight: bold;
    }

    a:hover {
        text-decoration: underline;
    }

    .important {
        font-weight: bold;
    }
</style>

<template>
    <div class="">
        <div class="card horizontal">
            <div class="card-image">
                <img :src="card.imageCard">
            </div>
            <div class="card-stacked">
                <div class="card-action" :class="icon">
                    <router-link :to='"/" + card.category + "/" + card.link' >{{card.title}}</router-link>
                </div>
                <div class="card-content">
                    <p>{{card.description}}</p>
                    <div class="badge blue-grey lighten-5">
                        <font-awesome-icon v-if="icon!=''" :icon="icon" size="2x" :class="icon"/>
                    </div>
                    <div class="datePublish"><b>Publié le : </b> {{card.publishDate}}</div>
                </div>
            </div>
        </div>
    </div>
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
        case 'blog': return 'newspaper'
        case 'recipes': return 'utensils'
        case 'projects': return 'code'
        default: return 'newsletter'
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
    .card {
        z-index: 1;
        height:230px !important;
    }
    .card .card-content{padding-top:12px !important;}

    .card-action {
        text-align: left;
        border-top:none;
        border-bottom:1px solid rgba(160,160,160,0.2);
    }

    .card-image{
        width:186px;
        overflow:hidden;}

    .badge {
        position: absolute;
        right: 0;
        bottom: 0;
        padding: 10px;
        border-left:1px solid #DDD;
        border-top:1px solid #DDD;
    }

    .datePublish {
        font-size: 14px;
        text-align:right;
        position:absolute;
        bottom: 15px;
        left:15px;
    }
    .newspaper, .newspaper a{color:#00a0d4 !important;}
    .code, .code a{color:#df0075 !important;}
    .utensils, .utensils a{color:#e23d27 !important;}
    a{color:black;cursor:pointer;text-transform: uppercase;font-size:14px; font-weight:bold;}
    a:hover{text-decoration: underline;}
</style>

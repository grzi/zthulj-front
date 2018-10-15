<template>
    <div class="col s12 m6 l4">
        <div class="card white">
            <div class="card-content">
                <div class="badge blue-grey lighten-5">
                    <font-awesome-icon :icon="card.icon" size="2x" :class="card.icon"/>
                </div>
                <div class="card-title"><b><router-link :to='"/" + card.category + "/" + card.link'>{{card.title}}</router-link></b></div>
                <p class="grey-text text-darken-3 light">{{card.description}}</p>
                <div class="datePublish"><b>Publié le : </b> {{card.publishDate}}</div>
            </div>
        </div>
    </div>
</template>

<script>
  export default {
    name: 'Card',
    props: ['card'],
    beforeMount () {
      this.card.icon = this.transcodeCategoryToIcon(this.card.category)
    },
    methods: {
      transcodeCategoryToIcon: function (category) {
        switch (category) {
        case 'blog': return 'newspaper'
        case 'receipe': return 'utensils'
        case 'projects': return 'code'
        default: return 'newsletter'
        }
      }
    }
  }
</script>

<style scoped>
    .card {
        z-index: 1;

    }
    .card .card-content{padding-top:12px !important;}

    .card-action {
        text-align: right
    }

    .badge {
        position: absolute;
        right: 0;
        top: 0;
        padding: 10px;
        border-left:1px solid #DDD;
        border-bottom:1px solid #DDD;
    }

    .datePublish {
        margin-top: 25px;
        font-size: 14px;
        text-align:right;
    }
    .newspaper{color:#00a0d4;}
    .code{color:#df0075;}
    .utensils{color:#e23d27;}
    a{color:black;cursor:pointer;text-transform: uppercase;font-size:22px}
    a:hover{text-decoration: underline;}
</style>

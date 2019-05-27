<template>
    <div class="comments container">
        <h5>Commentaires</h5>

    </div>
</template>

<script>
  export default {
    name: 'Comment',
    data: function () {
      return {
        comments: [
          {
            content: 'Super commentaire de la mort qui tue sur une ligne assez longue pour pouvoir tester un petit peu le placement des blocs sur la partie commentaire',
            author: 'TheBlueFox'
          }
        ]
      }
    }
  }
</script>

<style scoped>
    .comments{text-align: left;}
    .container{padding-left:0px!important;}
</style>

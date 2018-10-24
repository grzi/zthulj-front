<template>
    <div class="left-align">
        <div class="btn white" v-on:click="addMDToValue('**Bold Text**\n')">
            <font-awesome-icon icon="bold" color="black"/>
        </div>
        <div class="btn white" v-on:click="addMDToValue('*Italic Text*\n')">
            <font-awesome-icon icon="italic" color="black"/>
        </div>
        <div class="btn white" v-on:click="addMDToValue('[Text](link.fr)\n')">
            <font-awesome-icon icon="link" color="black"/>
        </div>
        <div class="btn white" v-on:click="addMDToValue('![Alt Text](url)\n')">
            <font-awesome-icon icon="image" color="black"/>
        </div>
        <div class="btn white" v-on:click="addMDToValue('```\n Some code \n```\n')">
            <font-awesome-icon icon="code" color="black"/>
        </div>
        <div class="btn white" v-on:click="addMDToValue('1. Item1\n2. Item2\n')">
            <font-awesome-icon icon="list-ol" color="black"/>
        </div>
        <div class="btn white" v-on:click="addMDToValue('- Item 1\n- Item2\n')">
            <font-awesome-icon icon="list-ul" color="black" />
        </div>
    </div>
</template>

<script>
  export default {
    name: 'MarkdownPalette',
    props: ['value'],
    methods: {
      addMDToValue: function (md) {
        this.$emit('paletteChange', md)
      }
    }
  }
</script>

<style scoped>

</style>

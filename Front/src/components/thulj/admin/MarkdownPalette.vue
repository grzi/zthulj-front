<template>
    <div class="left-align">
        <div class="btn white" v-on:click="addMDToValue('**', '**')">
            <font-awesome-icon icon="bold" color="black"/>
        </div>
        <div class="btn white" v-on:click="addMDToValue('*','*')">
            <font-awesome-icon icon="italic" color="black"/>
        </div>
        <div class="btn white" v-on:click="addMDToValue('[','](link.fr)')">
            <font-awesome-icon icon="link" color="black"/>
        </div>
        <div class="btn white" v-on:click="addMDToValue('![','](url)')">
            <font-awesome-icon icon="image" color="black"/>
        </div>
        <div class="btn white" v-on:click="addMDToValue('```\n','```')">
            <font-awesome-icon icon="code" color="black"/>
        </div>
        <div class="btn white" v-on:click="addMDToValue('1.','\n2. Item2')">
            <font-awesome-icon icon="list-ol" color="black"/>
        </div>
        <div class="btn white" v-on:click="addMDToValue('- ','\n- Item2')">
            <font-awesome-icon icon="list-ul" color="black" />
        </div>
    </div>
</template>

<script>
  export default {
    name: 'MarkdownPalette',
    props: ['value'],
    methods: {
      addMDToValue: function (mdStart, mdEnd) {
        this.$emit('paletteChange', mdStart, mdEnd)
      }
    }
  }
</script>

<style scoped>

</style>

<template>
    <div id="fullscreen" class="left-align palette">
        <textarea id="content" v-model="val" @input="updateData()"></textarea>
        <div class="palettebtn">
            <a class="btn white" v-on:click="addMDToValue('**', '**')">
                <font-awesome-icon icon="bold" color="black"/>
            </a>
            <a class="btn white" v-on:click="addMDToValue('*','*')">
                <font-awesome-icon icon="italic" color="black"/>
            </a>
            <a class="btn white">
                <font-awesome-icon icon="heading" color="black"/>
            </a>
            <a class="btn white" v-on:click="addMDToValue('[','](link.fr)')">
                <font-awesome-icon icon="link" color="black"/>
            </a>
            <a class="btn white" v-on:click="addMDToValue('![','](url)')">
                <font-awesome-icon icon="image" color="black"/>
            </a>
            <a class="btn white" v-on:click="addMDToValue('```\n','```')">
                <font-awesome-icon icon="code" color="black"/>
            </a>
            <a class="btn white" v-on:click="addMDToValue('1.','\n2. Item2')">
                <font-awesome-icon icon="list-ol" color="black"/>
            </a>
            <a class="btn white" v-on:click="addMDToValue('- ','\n- Item2')">
                <font-awesome-icon icon="list-ul" color="black"/>
            </a>
            <a class="btn white" v-on:click="fs">
                <font-awesome-icon icon="expand-arrows-alt" color="black"/>
            </a>
        </div>
    </div>
</template>

<script>
  export default {
    name: 'MarkdownPalette',
    props: ['val'],
    methods: {
      addMDToValue (mdStart, mdEnd) {
        var ta = document.getElementById('content')
        if (ta.selectionStart || ta.selectionStart === '0') {
          var startPos = ta.selectionStart
          var endPos = ta.selectionEnd
          if (ta.selectionStart !== ta.selectionEnd) {
            this.val = this.val.substring(0, startPos) +
              mdStart +
              this.val.substring(startPos, endPos) +
              mdEnd +
              this.val.substring(endPos, this.val.length)
          } else {
            this.val = this.val.substring(0, startPos) +
              mdStart + 'Some Text' + mdEnd +
              this.val.substring(endPos, this.val.length)
          }
        } else {
          this.val += mdStart + 'Some Text' + mdEnd
        }
        this.updateData()
      },
      fs () {
        document.getElementById('fullscreen').requestFullscreen()
      },
      updateData () {
        this.$emit('input', this.val)
      }
    }
  }
</script>

<style scoped>
    #content {
        background: white;
        min-height: 300px;
        padding: 15px;
        border: none;
        text-align: left;
        resize:none;
        height:100%;
        padding-top:70px;
    }
    .palette{
        border:1px solid #BBB;
    }
    .palettebtn{
        position:absolute;
        top:10px;
        margin-top:-2px;
        background:white;
        padding-top:6px;
        padding-bottom:6px;
        padding-left:6px;
    }
</style>

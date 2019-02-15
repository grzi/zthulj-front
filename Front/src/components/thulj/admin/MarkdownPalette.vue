<template>
    <div id="fullscreen" @fullscreenchange="fschange" class="left-align palette">
        <textarea id="content" v-model="val" @input="updateData()"></textarea>
        <div class="palettebtn">
            <button type='button' class="btn white" @click="addMDToValue('**', '**')">
                <font-awesome-icon icon="bold" color="black"/>
            </button>
            <button type='button' class="btn white" @click="addMDToValue('*','*')">
                <font-awesome-icon icon="italic" color="black"/>
            </button>
            <button type='button' class="btn white">
                <font-awesome-icon icon="heading" color="black"/>
            </button>
            <button type='button' class="btn white" @click="addMDToValue('[','](link.fr)')">
                <font-awesome-icon icon="link" color="black"/>
            </button>
            <button type='button' class="btn white" @click="addMDToValue('![','](url)')">
                <font-awesome-icon icon="image" color="black"/>
            </button>
            <button type='button' class="btn white" @click="uploadFile">
                <font-awesome-icon icon="file-upload" color="black"/>
            </button>
            <button type='button' class="btn white" @click="addMDToValue('```\n','```')">
                <font-awesome-icon icon="code" color="black"/>
            </button>
            <button type='button' class="btn white" @click="addMDToValue('1. ','\n2. Item2')">
                <font-awesome-icon icon="list-ol" color="black"/>
            </button>
            <button type='button' class="btn white" @click="addMDToValue('- ','\n- Item2')">
                <font-awesome-icon icon="list-ul" color="black"/>
            </button>
            <button type='button' v-if="fullscreen"  class="btn white" @click="compress">
                <font-awesome-icon icon="compress-arrows-alt" color="black"/>
            </button>
            <button type='button' v-else class="btn white" @click="expand">
                <font-awesome-icon icon="expand-arrows-alt" color="black"/>
            </button>
        </div>
        <div id="modal2" class="modal">
            <div class="modal-content">
                <div class="row center">
                    <div class="col s12">
                        <h3>Uploader un fichier</h3>
                        <form action="#" class="col s12">
                            <div class="file-field input-field">
                                <div class="btn">
                                    <span>File</span>
                                    <input type="file" id="fileupload">
                                </div>
                                <div class="file-path-wrapper">
                                    <input class="file-path validate" type="text">
                                </div>
                            </div>
                        </form>
                        <div class="row">
                            <div class="btn" @click='uploadRequest()'>Uploader</div>
                        </div>
                        <div>Addresse du fichier : {{ uploadedFilePath }}</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
  import axios from 'axios'
  import M from 'materialize-css'
  export default {
    name: 'MarkdownPalette',
    props: ['val'],
    data: function () {
      return {
        uploadedFilePath: '',
        fullscreen: false
      }
    },
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
      fschange () {
        this.fullscreen = document.fullscreenElement != null
      },
      expand () {
        document.getElementById('fullscreen').requestFullscreen()
      },
      compress () {
        document.exitFullscreen()
      },
      updateData () {
        this.$emit('input', this.val)
      },
      uploadFile () {
        M.Modal.getInstance(document.getElementById('modal2')).open()
      },
      uploadRequest () {
        const formData = new FormData()
        formData.append('file', document.getElementById('fileupload').files[0])
        // formData.append('id', 7878)
        axios.post(process.env.ROOT_API + 'api/secured/blog/uploadFile', formData,
                   {
                     headers: {
                       'authorization': 'Bearer ' + this.$store.state.access_token
                     }
        })
          .then(response => {
            this.uploadedFilePath = process.env.ROOT_API + response.data
          }, function (error) {
            console.log(error)
          })
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

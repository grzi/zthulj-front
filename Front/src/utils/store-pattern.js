import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const state = {
  access_token: ''
}

let store = new Vuex.Store({
  state: state
})

export default store

import Vue from 'vue'
import Vuex from 'vuex'
import Cookies from 'js-cookie'
import createPersistedState from 'vuex-persistedstate'

Vue.use(Vuex)

let store = new Vuex.Store({
  modules: {
    auth: {
      state: {
        access_token: ''
      },
      mutations: {
        changeToken: (state, e) => (state.access_token = e)
      },
      namespaced: true
    }
  },
  plugins: [createPersistedState({
    paths: ['auth'],
    storage: {
      getItem: key => Cookies.get(key),
      setItem: (key, value) =>
        Cookies.set(key, value, {expires: 3}),
      removeItem: key => Cookies.remove(key)
    }
  })]
})

export default store

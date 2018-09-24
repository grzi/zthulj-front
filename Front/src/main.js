import Vue from 'vue'
import {router} from './utils/router-config.js'
import './../node_modules/materialize-css/dist/js/materialize.min.js'
import './../node_modules/materialize-css/dist/css/materialize.min.css'

import { library } from '@fortawesome/fontawesome-svg-core'
import {
  faCoffee,
  faIdCard,
  faUtensils,
  faNewspaper,
  faCode,
  faHome,
  faGamepad,
  faHeart,
  faBolt,
  faLightbulb,
  faQuestion,
    faSearch
} from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

library.add(faCoffee, faIdCard, faUtensils, faNewspaper, faCode, faHome, faGamepad, faHeart, faLightbulb, faBolt, faQuestion,faSearch)

Vue.component('font-awesome-icon', FontAwesomeIcon)
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(require('./App.vue').default)
})

import VueRouter from 'vue-router'
import Vue from 'vue'
import axios from 'axios'

import store from './store-pattern.js'
Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  routes: [
    {path: '/', name: 'home', component: require('../components/thulj/Home.vue').default},
    {path: '/about', name: 'about', component: require('../components/thulj/About.vue').default},
    {path: '/blog', name: 'blog', component: require('../components/thulj/article/Blog.vue').default, props: { section: 'blog', section_title: 'zThulj > Blog' }},
    {path: '/blog/:id', name: 'articleBlog', component: require('../components/thulj/article/Blog.vue').default, props: { section: 'blog', section_title: 'zThulj > Blog' }},
    {path: '/projects', name: 'projects', component: require('../components/thulj/article/Blog.vue').default, props: { section: 'projects', section_title: 'zThulj > Projets' }},
    {path: '/projects/:id', name: 'articleProjects', component: require('../components/thulj/article/Blog.vue').default, props: { section: 'projects', section_title: 'zThulj > Projets' }},
    {path: '/recipes', name: 'recipes', component: require('../components/thulj/article/Blog.vue').default, props: { section: 'recipes', section_title: 'zThulj > Recettes' }},
    {path: '/recipes/:id', name: 'articleRecipes', component: require('../components/thulj/article/Blog.vue').default, props: { section: 'recipes', section_title: 'zThulj > Recettes' }},
    {path: '/edit',
     name: 'edit',
     component: require('../components/thulj/admin/Edit.vue').default,
     secure: true,
     meta: {
       metaTags: [
         {
           name: 'robots',
           content: 'noindex'
         }
       ]
     }
    },
    {path: '/edit/:link',
     component: require('../components/thulj/admin/Edit.vue').default,
     secure: true,
     meta: {
       metaTags: [
         {
           name: 'robots',
           content: 'noindex'
         }
       ]
    }}
  ]
})

router.beforeEach((to, from, next) => {
  // Look at all routes
  router.options.routes.forEach((route) => {
    // If this is the current route and it's secure
    if (to.matched[0].path === route.path && route.secure) {
      if (store.state.access_token !== '' && store.state.access_token !== null) {
        axios.post(process.env.ROOT_API + 'oauth/check_token?token=' + store.state.access_token, this.article,
                   {
                     headers:
                       {
                         'content-type': 'application/x-www-form-urlencoded',
                         'authorization': 'Basic ' + 'dGVzdENsaWVudDpjbGllbnRpZA=='
                       }
        }).then(response => {
          console.log(response)
        })
      } else {
        next('/')
      }
    }
  })

  // Proceed as normal
  next()
})

export default router

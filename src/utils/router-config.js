import VueRouter from 'vue-router'
import Vue from 'vue'
import axios from 'axios'
import M from 'materialize-css'
import store from './store-pattern.js'
import Home from '../components/thulj/Home'
import Blog from '../components/thulj/article/Blog'
import Edit from '../components/thulj/admin/Edit'
import AdminHub from '../components/thulj/admin/AdminHub'

Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  routes: [
    {path: '/', name: 'home', component: Home},
    {path: '/about', name: 'about', component: require('../components/thulj/About.vue').default},
    {
      path: '/blog',
      name: 'blog',
      component: Blog,
      props: {section: 'blog', section_title: 'zThulj > Blog'}
    },
    {
      path: '/blog/:id',
      name: 'articleBlog',
      component: Blog,
      props: {section: 'blog', section_title: 'zThulj > Blog'}
    },
    {
      path: '/projects',
      name: 'projects',
      component: Blog,
      props: {section: 'projects', section_title: 'zThulj > Projets'}
    },
    {
      path: '/projects/:id',
      name: 'articleProjects',
      component: Blog,
      props: {section: 'projects', section_title: 'zThulj > Projets'}
    },
    {
      path: '/recipes',
      name: 'recipes',
      component: Blog,
      props: {section: 'recipes', section_title: 'zThulj > Recettes'}
    },
    {
      path: '/recipes/:id',
      name: 'articleRecipes',
      component: Blog,
      props: {section: 'recipes', section_title: 'zThulj > Recettes'}
    },
    {
      path: '/edit',
      name: 'edit',
      component: Edit,
      meta: {
        requiresAuth: true,
        metaTags: [
          {
            name: 'robots',
            content: 'noindex'
          }
        ]
      }
    },
    {
      path: '/admin',
      name: 'admin',
      component: AdminHub,
      meta: {
        requiresAuth: true,
        metaTags: [
          {
            name: 'robots',
            content: 'noindex'
          }
        ]
      }
    },
    {
      path: '/edit/:link',
      component: Edit,
      meta: {
        requiresAuth: true,
        metaTags: [
          {
            name: 'robots',
            content: 'noindex'
          }
        ]
      }
    }
  ],
  scrollBehavior (to, from, savedPosition) {
    // page scroll to top for all route navigations
    return {x: 0, y: 0}
  }
})

router.beforeEach((to, from, next) => {
  try {
    M.Sidenav.init(document.getElementById('sidenav'))
  } catch (e) {
    console.log(e)
  }

  const requiresAuth = to.matched.some(record => record.meta.requiresAuth)
  if (requiresAuth) {
    if (store.state.access_token !== '' && store.state.access_token !== null) {
      axios.post(process.env.ROOT_API + 'api/secured/user/check_token',
                 '',
                 {
                   headers: {
                     'authorization': 'Bearer ' + store.state.auth.access_token
                   }
      })
        .then(response => {})
        .catch(e => {
          this.$store.commit('auth/changeToken', '')
          next('/')
        })
    } else {
      next('/')
    }
  }
  next()
})

export default router

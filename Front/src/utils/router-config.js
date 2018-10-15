import VueRouter from 'vue-router'
import Vue from 'vue'

Vue.use(VueRouter)

export const router = new VueRouter({
  mode: 'history',
  routes: [
    {path: '/', name: 'home', component: require('../components/thulj/Home.vue').default},
    {path: '/about', name: 'about', component: require('../components/thulj/About.vue').default},
    {path: '/blog', name: 'blog', component: require('../components/thulj/Blog.vue').default},
    {path: '/blog/:id', name: 'articleBlog', component: require('../components/thulj/Blog.vue').default},
    {path: '/projects', name: 'projects', component: require('../components/thulj/Projects.vue').default},
    {path: '/recipes', name: 'recipes', component: require('../components/thulj/Recipes.vue').default},
    {path: '/edit', name: 'edit', component: require('../components/thulj/Edit.vue').default},
    {path: '/edit/:link', component: require('../components/thulj/Edit.vue').default}
  ]
})

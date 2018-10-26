import VueRouter from 'vue-router'
import Vue from 'vue'

Vue.use(VueRouter)

export const router = new VueRouter({
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
    {path: '/edit', name: 'edit', component: require('../components/thulj/admin/Edit.vue').default},
    {path: '/edit/:link', component: require('../components/thulj/admin/Edit.vue').default}
  ]
})

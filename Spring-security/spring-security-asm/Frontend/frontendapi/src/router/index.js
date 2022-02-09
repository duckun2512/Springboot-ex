import Vue from 'vue'
import VueRouter from 'vue-router'
import {StreetRoute} from "@/pages/street";



Vue.use(VueRouter)

const routes = [
    ...StreetRoute
]

const router = new VueRouter({
    mode: 'history',
    routes
})

router.beforeEach((to, from, next) => {
    document.title = to.meta.title;
    next();
})

export default router;
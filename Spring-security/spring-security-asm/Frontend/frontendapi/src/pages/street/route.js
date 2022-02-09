import layout from "@/layout/layout";
const routes = [
    {
        path: '/streets',
        component: layout,
        name: 'streets',
        meta: {
            title: 'Streets',
            icon: 'menu-fold'
        },
        children: [
            {
                path: 'list',
                component: () => import('./List'),
                name: 'Streets',
                meta: {
                    title: 'List Streets',
                }
            },
            {
                path: 'add',
                component: () => import('./Create'),
                name: 'Streets',
                meta: {
                }
            },
            {
                path: 'detail/:id',
                component: () => import('./Detail'),
                name: 'Streets',
                meta: {
                }
            }
        ]
    }
]

export default routes;
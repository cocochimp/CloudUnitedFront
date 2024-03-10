import Vue from 'vue'
import VueRouter from 'vue-router'
//组织库
import { callAllMenu } from '../api/organzationData/Department'

Vue.use(VueRouter)

const routes = [
    { path: '/', redirect: '/index' },
    {
        path: '/index', //主页
        component: () =>
            import ('../pages/index/index.vue')
    },
    {
        path: '/login', //登录
        component: () =>
            import ('../pages/login/login.vue')
    },
    {
        path: '/searchPage', //门户网站搜索
        component: () =>
            import ('../pages/searchPage/searchPage.vue')
    },
    {
        path: '/metadata', //大数据
        redirect: '/metadata/dataIndex',
        component: () =>
            import ('../components/metadata.vue'),
        children: [{
                name: 'dataIndex',
                path: 'dataIndex',
                component: () =>
                    import ('../peags/dataIndex.vue')
            }, //首页
            {
                name: 'frontParty',
                path: 'frontParty',
                component: () =>
                    import ('../peags/frontParty.vue')
            }, //无党派、留学人员
            {
                name: 'minNationality',
                path: 'minNationality',
                component: () =>
                    import ('../peags/minNationality.vue')
            }, //少数民族
            {
                name: 'democrat',
                path: 'democrat',
                component: () =>
                    import ('../peags/democrat.vue')
            }, //民主党派
            {
                name: 'portrait',
                path: 'portrait',
                component: () =>
                    import ('../peags/portrait.vue')
            }, //人物画像
            {
                name: 'gain',
                path: 'gain',
                component: () =>
                    import ('../peags/gain.vue')
            }, //统战成果展示
        ],

    }, // 总的大数据
    {
        path: '/appMainIndex',
        component: () =>
            import ('../components/appMain/AppMainIndex.vue'),
    },
    //业务决策平台
    {
        path: '/workplace',
        component: () =>
            import ('../pages/workplace/workplace.vue'),
        redirect: '/welcomeWorkplace',
        name: '业务决策平台',
        children: [{
                path: '/welcomeWorkplace',
                component: () =>
                    import ('../pages/workplace/welcome.vue')
            },
            {
                path: 'user/list', // 前端跳转请求 这两个对应数据库两个数据
                name: '用户管理',
                component: () =>
                    import ('@/pages/workplace/user/list'), // 前端跳转页面
                meta: { title: '用户管理' }
            },
            {
                path: 'role/list',
                name: '角色管理',
                component: () =>
                    import ('@/pages/workplace/role/list'),
                meta: { title: '角色管理' }
            },
            {
                path: 'role/add',
                name: '角色添加',
                component: () =>
                    import ('@/pages/workplace/role/form'),
                meta: { title: '角色添加' },
                hidden: true
            },
            {
                path: 'role/update/:id',
                name: '角色修改',
                component: () =>
                    import ('@/pages/workplace/role/form'),
                meta: { title: '角色修改' },
                hidden: true
            },
            {
                path: 'role/distribution/:id',
                name: '角色权限',
                component: () =>
                    import ('@/pages/workplace/role/roleForm'),
                meta: { title: '角色权限' },
                hidden: true
            },
            {
                path: 'menu/list',
                name: '菜单管理',
                component: () =>
                    import ('@/pages/workplace/menu/list'),
                meta: { title: '菜单管理' }
            },
            {
                path: 'user/add',
                name: '用户添加',
                component: () =>
                    import ('@/pages/workplace/user/form'),
                meta: { title: '用户添加' },
                hidden: true
            },
            {
                path: 'user/update/:id',
                name: '用户修改',
                component: () =>
                    import ('@/pages/workplace/user/form'),
                meta: { title: '用户修改' },
                hidden: true
            },
            {
                path: 'user/role/:id',
                name: '用户角色',
                component: () =>
                    import ('@/pages/workplace/user/roleForm'),
                meta: { title: '用户角色' },
                hidden: true
            }
        ],
    },
    //人物库
    {
        path: '/teacher',
        component: () =>
            import ('../pages/teacher/people.vue'),
        redirect: '/welcome',
        children: [{
                path: '/welcome',
                component: () =>
                    import ('../pages/teacher/welcome.vue')
            },
            {
                path: '/2-3',
                component: () =>
                    import ('../pages/teacher/list.vue')
            },
            {
                path: '/2-4',
                component: () =>
                    import ('../pages/teacher/member_save.vue')
            },
            {
                path: '/2-5',
                component: () =>
                    import ('../pages/teacher/saveStudents.vue')
            },
            {
                path: '/2-6',
                component: () =>
                    import ('../pages/teacher/studentsList.vue')
            },
        ],
    },
    //资料库
    {
        path: '/filedata',
        component: () =>
            import ('../pages/filedata/index.vue'),
        redirect: '/fileWelcome',
        children: [{
                path: '/fileWelcome',
                component: () =>
                    import ('../pages/filedata/welcome.vue')
            },
            {
                path: '/reward',
                component: () =>
                    import ('../pages/filedata/reward.vue'),
                meta: { title: '获奖' }
            },
            {
                path: '/fileDataGainArt',
                component: () =>
                    import ('../pages/filedata/fileDataGainArt'),
                meta: { title: '统战成果新闻展示' }
            },
            {
                path: '/fileDataGainPic',
                component: () =>
                    import ('../pages/filedata/fileDataGainPic'),
                meta: { title: '统战成果轮播图展示' }
            },
            {
                path: '/homePageArticle',
                component: () =>
                    import ('../pages/filedata/politics.vue'),
                meta: { title: '门户网站文章' }
            },
            {
                path: '/homePagePicture',
                component: () =>
                    import ('../pages/filedata/pictureList.vue'),
                meta: { title: '门户网站轮播图' }
            },
            {
                path: '/homePageDownload',
                component: () =>
                    import ('../pages/filedata/downloadList.vue'),
                meta: { title: '门户网站下载专区' }
            },
        ],
    },
    {
        path: '/news',
        component: () =>
            import ('../peags/news/news.vue')
    },
    {
        path: '/download', //下载专区
        component: () =>
            import ('../pages/download/download.vue')
    },
    //
    {
        path: '/depintroduction', //部门介绍
        component: () =>
            import ('../pages/depintroduction/depintroduction.vue'),
        children: [{
            name: 'content',
            path: 'content',
            component: () =>
                import ('../components/depintroduction/depintroduction_right')
        }],
    },
    {
        path: '/faculty', //无党派人士
        component: () =>
            import ('../pages/faculty/faculty'),
        children: [{
            name: 'content',
            path: 'content',
            component: () =>
                import ('../components/faculty/faculty_united_front_group')
        }],
    },
    {
        path: '/ufsystem', //民主党派
        component: () =>
            import ('../pages/ufsystem/ufsystem.vue'),
        children: [{
            name: 'content',
            path: 'content',
            component: () =>
                import ('../components/faculty/faculty_united_front_group')
        }],
    },
    {
        path: '/messageDetail', //门户网站文章点击更多
        component: () =>
            import ('../pages/messageDeatil/messageDeatil.vue'),
        children: [{
            name: 'content',
            path: 'content',
            component: () =>
                import ('../components/faculty/faculty_united_front_group')
        }],
    },
    {
        path: '/article',
        component: () =>
            import ('../pages/article/article.vue')
    },
]

const asyncRouter = [
    //组织库路由
    {
        path: '/organization',
        component: () =>
            import ('../pages/organization/index.vue'),
        name: 'organization',
        redirect: '/organization/organizationWelcome',
        children: [{
                path: 'organizationWelcome',
                name: 'organizationWelcome',
                component: () =>
                    import ('../pages/organization/welcome.vue'),
            },
            {
                path: 'orgManagement',
                name: 'orgManagement',
                component: () =>
                    import ('../pages/organization/orgManagement'),
            },
            {
                path: '2-4',
                name: 'tianjiarenwu',
                redirect: '/2-4'
            },
            //基层统战二级党组织
            //民主党派
            //少数民族
            {
                path: 'shaoshuminzu',
                component: () =>
                    import ('../pages/organization/shaoshuminzu.vue'),
            },
            //参政议政
        ]
    },
]

const router = new VueRouter({
    mode: 'hash',
    routes,
})


//路由拦截
router.beforeEach((to, from, next) => {   //动态生成路由数据
    addRoutes();
     //to将要访问的路径
    //from代表从哪个路径跳转而来
    //next是一个函数，表示放行
    //   next()放行   next('/login')强制跳转

    if (to.path === '/index' || to.path === '/searchPage' || to.path === '/login'
    || to.path === '/download'|| to.path === '/depintroduction'|| to.path === '/faculty'
    || to.path === '/ufsystem'|| to.path === '/messageDetail'|| to.path === '/article') return next()
        //获取token
    const tokenStr = window.sessionStorage.getItem('token')
    if (!tokenStr) {
        return next('/login')
    }
    next();
})

function addRoutes() {
    callAllMenu().then(res => {
        //获取数据
        console.log(res);
        //数据拼接(路由数据)
        routesData1(res.res1.data.router.children);
        routesData2(res.res2.data.router.children);
        routesData3(res.res3.data.router.children);
        routesData4(res.res4.data.router.children);
        //动态添加
        router.addRoutes(asyncRouter)
    })
}
//拼接组织库路由数据
function routesData1(result) {
    result.forEach(item => {
        asyncRouter[0].children.push({
            path: item.component,
            name: item.meta.title,
            component: () =>
                import ('../pages/organization/Jicengtongzhan/index.vue')
        })
    })
    return asyncRouter
}

function routesData2(result) {
    result.forEach(item => {
        asyncRouter[0].children.push({
            path: item.component,
            name: item.meta.title,
            component: () =>
                import ('../pages/organization/Minzhudangpai/index.vue')
        })
    })
    return asyncRouter
}

function routesData3(result) {
    result.forEach(item => {
        asyncRouter[0].children.push({
            path: item.component,
            name: item.meta.title,
            component: () =>
                import ('../pages/organization/Quntuanzuzhi/index.vue')
        })
    })
    return asyncRouter
}

function routesData4(result) {
    result.forEach(item => {
        asyncRouter[0].children.push({
            path: item.component,
            name: item.meta.title,
            component: () =>
                import ('../pages/organization/Canzhengyizheng/index.vue')
        })
    })
    return asyncRouter
}

export default router
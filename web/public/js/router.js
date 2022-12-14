/*
 * 单页应用路由
 * https://gitee.com/lisheng741/singlepagerouter/
 */
function Router(routes, defaultRoute) {
    const onThis = this;

    //路由初始化
    routes && onThis.init(routes, defaultRoute);

    //绑定 hashchange 事件
    window.addEventListener("hashchange", function() {
        //路由改变时，执行autoView();
        autoView();
        let route = location.hash.slice(1) || "";
        onThis.oldRoute = onThis.currentRoute;
        onThis.currentRoute = route;
        onThis.changePage(route);
    });
}

//初始化，可多次初始化
Router.prototype.init = function(routes, defaultRoute) {
    if (!routes || !routes.length) { //routes为undefined，或routes.length为undefined或0
        console.error("Router初始化失败：routes错误！");
        return;
    }
    this.routes = routes;
    this.currentRoute = location.hash.slice(1) || defaultRoute || routes[0].id; //当前路由获取顺序
    this.oldRoute = "";
    location.hash || history.replaceState(null, null, '#' + this.currentRoute); //hash为空，切换当前hash
    this.changePage(this.currentRoute);
    this.oldRoute = location.hash.slice(1);
}

//切换路由
Router.prototype.push = function(route, callback) {
    //获取route
    switch (typeof(route)) {
        case "string":

            break;
        case "number":
            route = this.routes[route] || "";
            break;
        case "object":
            route = route.id || "";
            break;
        case "undefined":
        default:
            route = location.hash.slice(1) || "";
            break;
    }
    location.hash = route; //切换hash，接下来的事情交给hashchange去做。如果与上一次的route一致，不会触发hashchange事件
}

//前进
Router.prototype.forward = function () {
    history.forward();
}

//后退
Router.prototype.back = function () {
    history.back();
}

//切换页面：route为字符串，为空则隐藏所有路由
Router.prototype.changePage = function(route) {
    if (!this.routes || !this.routes.length) { //没有初始化成功的路由，直接返回
        return;
    }
    for (let i = 0; i < this.routes.length; i++) {
        let e = document.getElementById(routes[i].id);
        if (routes[i].id === route) {
            e && (e.style.display = "block");
            (typeof(routes[i].title) === "string") && routes[i].title && (document.title = routes[i].title);
            (typeof(routes[i].handler) === "function") && routes[i].handler(); //handler 存在，执行函数
        } else {
            e && (e.style.display = "none");
        }
    }
}
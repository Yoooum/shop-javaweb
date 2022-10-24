## 项目介绍

- 主页
- 登录注册页面及功能
- 商品管理
- 用户管理
- 个人中心
- ~~购物车及订单管理~~ (正在制作)

## 所用技术

- Mybatis (重写DAO层，使DAO层变得更简单)
- Ajax (进行前后端数据的交互)
- 远程数据库 (同步数据)

##  开发问题

- 跨域

  - **浏览器保护机制** (前端调用的后端数据不属于同一个域，域名或端口不同)

  - `servlet`跨域 `Access-Control-Allow-Headers` 默认不允许`application/json`
  - `response`对象使用`setContentType("application/json");`解决

- 前后端分离原因
  - `JSP`传输数据不好用，代码也很混乱

- 数据库
  - 由于**数据库数据**不统一，使用远程数据库同步数据

- Ajax
  - 根据**Tomcat**部署配置的不同，请求链接会有些许差异











































### 1. 数据库

db.properties 为数据库配置文件，需要自己在 resources 创建
```properties
# 数据库配置文件
db.driver=org.mariadb.jdbc.Driver
db.url=your_url
db.username=your_username
db.password=your_password
```

### ~~2. URL的配置~~（前端页面在public目录，用vscode的Live Server运行）

页面展示路径  
http://localhost:8080/loginService

数据交互路径  
http://localhost:8080/data/loginService

web.xml仅配置 .jsp 后缀映射
```xml
<!-- 示例 -->
<servlet>
    <servlet-name>loginService</servlet-name>
    <jsp-file>/loginService.jsp</jsp-file>
</servlet>
<servlet-mapping>
    <servlet-name>loginService</servlet-name>
    <url-pattern>/loginService</url-pattern>
</servlet-mapping>
```
数据交互路径使用注解统一设置为 /data/xxx

```java
@WebServlet(name = "LoginServlet", urlPatterns = "/data/loginService")
```
好处是可以隐藏 .jsp 后缀


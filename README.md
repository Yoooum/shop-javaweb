## 初学 JavaWeb

### 1. 数据库
db.properties 为数据库配置文件，需要自己在 resources 创建
```properties
# 数据库配置文件
db.driver=org.mariadb.jdbc.Driver
db.url=your_url
db.username=your_username
db.password=your_password
```
### 2. URL的配置

页面展示路径  
http://localhost:8080/login

数据交互路径  
http://localhost:8080/data/login

web.xml仅配置 .jsp 后缀映射
```xml
<!-- 示例 -->
<servlet>
    <servlet-name>login</servlet-name>
    <jsp-file>/login.jsp</jsp-file>
</servlet>
<servlet-mapping>
    <servlet-name>login</servlet-name>
    <url-pattern>/login</url-pattern>
</servlet-mapping>
```
数据交互路径使用注解统一设置为 /data/xxx

```java
@WebServlet(name = "LoginServlet", urlPatterns = "/data/login")
```
好处是可以隐藏 .jsp 后缀

maven是由apache开源的用于构建和管理java项目的工具。

优点：

1.提供统一的项目架构

2.方便的管理项目的依赖

3.支持跨平台构建项目



依赖具有传递性

直接依赖：当前项目通过依赖配置建立的依赖关系

间接依赖：被依赖的资源如果依赖其他资源，当前项目间接依赖其他资源

控制依赖作用域

<scope>test/main/package(测试文件夹/主文件夹/打包指令)</scope>



SpringBoot学习

通过start.spring.io创建项目，添加SpringWeb依赖

spring-boot-starter-web 这个依赖**默认内置了内嵌的 Tomcat**

SpringBoot通过@SpringBootApplication注释确定主类，通过在main函数中执行

SpringApplication.run()函数启动SpringBoot。

如果你是写给前端页面看的（返回页面） ➜ 用 `@Controller`

如果你是写接口、返回 JSON 的 ➜ 用 `@RestController`

[Http协议](Http.md)

Web服务器是一个软件程序，对Http协议的操作进行了封装了，不用直接对协议进行操作，让Web开发更加便捷。

SpringBoot中DispatcherServlet类是整个Spring MVC框架的核心类，DispatcherServlet类是一个前端控制器，实现了Servlet接口，可以接收所有的HTTP请求，将请求转发给合适的处理器(Controller),返回响应结果给客户端。通过HttpServletRequest对象获取请求数据，通过HttpServletResponse对象设置响应数据。

Postman是一款测试后端接口的应用程序。

[SpringBoot获取查询参数](GetParameter.md)

[SpringBoot关于响应](@ResponseBody.md)

MVC架构是整个软件前后端分离的设计模式，三层架构是系统后端职责划分的架构模式。

三层架构分为Controller,Dao,Service.

controller:控制层，负责接收前端发送的请求，对请求进行处理并响应数据。

service:业务逻辑层，处理具体的业务逻辑

dao:数据访问层(Data Access Object)持久层，负责数据访问操作，包括数据的增删改查。

[高内聚和低耦合](IOC&DI.md)




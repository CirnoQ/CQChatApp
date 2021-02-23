# Day1

## 了解MUI
使用前端框架MUI协助搭建前端界面。[MUI文档](https://dev.dcloud.net.cn/mui/ui/)

## 新建项目
我使用了Hbuilder X自带的创建h5+mui项目，创建之后项目文件夹内自带了css、fonts、js文件夹以及一个内容空白的index.html文件。

我没有使用自带的index文件作为首页，而是创建了一个pages文件夹存放之后将会用到的所有html文件，并新建一个ChatApp_welcome.html文件作为首页(即欢迎界面)。

应注意，若要修改首页文件，应在项目的根目录的manifest.json中修改首页地址文件。默认为index.html，我们修改成pages/ChatApp_welcome.html。

## 欢迎页面实现
欢迎页面即打开app后的首页。这里我们在首页设置两个按钮：登录与注册。两个按钮都为绿色，点击后可跳转至对应页面。

## 登录、注册页面实现
为了图方便将登录和注册功能做在同一个页面。

在登录/注册页面，用户需要输入账号和密码，之后点击登录/注册按钮即可进行登录或注册。在这里我们将登录/注册置于同一按钮。

- ### 用户名与密码合法性判断
用户名和密码在长度上有限制，我们规定用户名不能超过12位，密码不能短于6位。用户名与密码都不能为空。

- ### 在app.js文件中封装函数
我们可以将一些常用js函数写入一个js文件中，在以后需要用到的时候直接调用。在js文件夹中创建一个app.js文件，在里面写入js函数。现在我们需要一个判断字符串是否为空的函数isNotNull。之后我们也可以在app.js文件中存放一些信息。

- ### 使用Ajax实现网页异步更新
`AJAX 是一种用于创建快速动态网页的技术。`

在MUI中封装了常用的Ajax函数，我们可以使用这些函数实现与后台的少量数据交换，以达到网页异步更新的目的。即在不重新加载整个网页的情况下，对网页的某部分进行更新。

因为我们的后台程序还没有开始写，所以我们目前只能实现对用户名和密码的合法性检验。之后我们完成后端程序后再来完善这一部分程序。

## 后台项目框架搭建
现在我们开始进行后台框架的搭建。我们使用[SpringBoot](https://spring.io/projects/spring-boot)微服务架构，以快速配置项目。

- ### 使用Idea创建Spring Initializr项目
在Idea中可以直接创建Spring项目，我们点击创建后填写相关信息并选择依赖项即可完成创建。这里我们选择了Spring Web、Mybatis、Mysql Driver依赖。

- ### 在pom.xml中添加阿里巴巴druid数据源
[阿里巴巴druid数据源](https://github.com/alibaba/druid)

在pom.xml中添加之后即配置完毕。

- ### 配置application.yml
在application.yml中配置端口号、上下文路径、数据源、数据库信息等。

- ### 建立控制层controller
我们建立controller文件夹，并且新建一个test类以及test.html文件，请求路径为"/test"。接着启动application，进入在浏览器输入`"http://localhost:8080/cqchat_sys/test"`，成功显示test.html中的内容表示我们的内置tomcat配置成功。
# Day2

## 设计数据库
数据库的重要性自然不必多说，现在我们需要根据我们的需求设计一个数据库。

首先我们可以建立一个聊天信息表，里面包含信息id、发送方id、接收方id、发送的信息、消息是否被签收的状态标记、消息创建时间，主码为信息id。

然后我们创建一个好友请求表，包含请求id、发送方id、接收方id、请求创建时间，主码为请求id。

之后是好友列表，包含列表id、用户id、好友id，主码为列表id。

最后是用户列表，包含用户id、用户名、密码、头像地址、高清头像地址、昵称、二维码、设备id，主码为用户id。

## 使用MyBatis逆向生成pojo,mapper接口与mapper.xml文件
使用MyBatis-generator插件，在配置完generatorConfig.xml文件后即可快速根据数据库逆向生成pojo,mapper接口。另外需要在项目的pom.xml文件中添加相关依赖项防止报错。

- ### 创建UserController
在controller层创建一个新的UserController测试我们生成的pojo,mapper接口是否有效。

- ### 创建UserServices文件
在Service层创建一个UserServices文件处理业务逻辑。我们在其中新建一个getUserById方法，通过给出id从后台获取用户数据。这里用到了UserMapper中的selectByPrimaryKey()方法，是由MyBatis逆向生成的。

- ### 创建user_test.html文件测试效果
我们在templates文件夹新建一个user_test.html文件测试MyBatis逆向生成的接口是否管用。
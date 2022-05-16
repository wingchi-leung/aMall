# aMall

### 前言

大三学生练手的商城项目。用于学习和交流

项目的前端使用的是github创作者@[hai-27](https://github.com/hai-27)写的 [vue-store](https://github.com/hai-27/vue-store)，我在他的基础上进行了一些修改。

**感谢[hai-27](https://github.com/hai-27)的无私分享。**

第二：项目的数据库设计是@[hfbin](https://github.com/hfbin/Seckill)的秒杀项目[Seckill](https://github.com/hfbin/Seckill)设计上修改的。

**在这里表示感谢。**

如果作者看到认为不妥的，请联系我将项目删除。 

### 项目介绍

aMall是一个电商系统，使用了SpringCloud+Mybatis实现。前端技术栈为Vue

![image-20220516152508471](D:\新建文件夹\MyGoodkiller\README.assets\image-20220516152508471.png)

已实现的功能

✅用户登录校验 Spring Security+JWT

✅商品查询和展示

✅购物车添加和删除

✅下单支付 （有待完善）



### 即将上线...

项目还没完全完成，

秒杀模块的设计图：

![image-20220516144154387](D:\新建文件夹\MyGoodkiller\README.assets\image-20220516144154387.png)

### 如何运行

1. 克隆项目到本地
2. 打开`goods_kill.sql`文件到本地数据库运行 
3. 修改后端项目`application.yaml`文件中的数据库用户名和密码
4. 启动后端项目
5. 打开vue-store,在此目录下运行cmd命令行 `npm serve run`  
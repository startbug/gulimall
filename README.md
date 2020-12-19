# 安装vagrant和centos

https://www.vagrantup.com/downloads

手动下载centos7镜像

CentOS-7-x86_64-Vagrant-2004_01.VirtualBox.box

初始化、导入和启动(详情: https://blog.csdn.net/hezekun/article/details/106714861)

## 1.初始化

> vagrant init centos/7
>
> 

## 2.导入

> vagrant box add centos/7 D:\HashiCorp\box\CentOS-7-x86_64-Vagrant-2004_01.VirtualBox.box

## 3.加载

> vagrant up
>
> vagrant ssh #进入centos

## 4.其他

root用户密码为:`vagrant`

`su root` 命令登录root账户





# 使用docker配置linux

## 1.安装命令

```
# 清空多余文件
sudo yum remove docker \
docker-client \
docker-client-latest \
docker-common \
docker-latest \
docker-latest-logrotate \
docker-logrotate \
docker-engine

# 安装工具包
sudo yum install -y yum-utils

# 配置centos的docker仓库
sudo yum-config-manager \
--add-repo \
https://download.docker.com/linux/centos/docker-ce.repo

# 安装docker
sudo yum install docker-ce docker-ce-cli containerd.io

# 启动dcoker
sudo systemctl start docker

# docker命令
docker -v
sudo docker images
docker ps
```



## 2.docker配置阿里云镜像

https://cr.console.aliyun.com/cn-hangzhou/instances/mirrors



## 3.安装mysql

```
# 下载mysql
sudo docker pull mysql:8.0.20

# 启动mysql
docker run -p 3307:3306 --privileged=true --name mysql \
-v /mydata/mysql/log:/var/log/mysql \
-v /mydata/mysql/data:/var/lib/mysql \
-v /mydata/mysql/conf:/etc/mysql \
-v /mydata/mysql/mysql-files:/var/lib/mysql-files/ \
-e MYSQL_ROOT_PASSWORD=root \
-d mysql:8.0.20

# mysql无法启动
参考https://blog.csdn.net/qq_41999034/article/details/106162366
解决办法
添加selinux规则，将要挂载的目录添加到白名单
chcon -Rt svirt_sandbox_file_t /mydata/mysql/log
chcon -Rt svirt_sandbox_file_t /mydata/mysql/data
chcon -Rt svirt_sandbox_file_t /mydata/mysql/conf

# 其他命令
 whereis mysql
 ALTER USER 'root'@'localhost' IDENTIFIED WITH MYSQL_NATIVE_PASSWORD BY '123456';
 flush privileges;
 update user set host="%" where user="root";
 firewall-cmd --zone=public --add-port=3306/tcp --permanent 
 firewall-cmd --reload
 docker exec -it mysql /bin/bash
```



## 3.安装redis

```
# 下载redis镜像
docker pull redis # 默认下载最新版

# 创建实例并启动
mkdir -p /mydata/redis/conf
touch /mydata/redis/conf/redis.conf

docker run -p 6379:6379 --name redis -v /mydata/redis/data:/data \
-v /mydata/redis/conf/redis.conf:/etc/redis/redis.conf \
-d redis redis-server /etc/redis/redis.conf

# 其他命令
docker logs --since 30m redis
docker exec -it redis redis-cli
```





# Nacos配置注册中心



**Nacos可作为服务注册中和配置管理中心**



## 1.下载Nacos

https://github.com/alibaba/nacos/releases



## 2.修改Nacos配置

### 1)修改启动模式为单机模式

![](https://gitee.com/starbug-gitee/PicBed/raw/master/img/20201219175033.png)

### 2)创建数据库

![](https://gitee.com/starbug-gitee/PicBed/raw/master/img/20201219175141.png)



### 3)修改数据库配置

![](https://gitee.com/starbug-gitee/PicBed/raw/master/img/20201219175244.png)



### 4)启动Nacos

![](https://gitee.com/starbug-gitee/PicBed/raw/master/img/20201219175324.png)



### 5)访问localhost:8848/nacos

账号: nacos 密码; nacos

![](https://gitee.com/starbug-gitee/PicBed/raw/master/img/20201219175353.png)



6)创建微服务,配置nacos信息

![](https://gitee.com/starbug-gitee/PicBed/raw/master/img/20201219175635.png)



7)启动后,会自动注册到nacos中

![](https://gitee.com/starbug-gitee/PicBed/raw/master/img/20201219175719.png)





# Nacos配置注册中心

**配置中心配置方式**

## 1、引入依赖

```xml
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
</dependency>
```



## 2、创建bootstrap.yml

```yaml
spring:
  application:
    name: gulimall-coupon
  cloud:
    nacos:
      config:
        server-addr: localhost:8848
        file-extension: yaml
```

## 3、给配置中心添加数据集(Data Id)

​	gulimall-coupon.yaml

​	默认: 微服务名-环境名(dev,prop).指定后缀  ==>  如: gulimall-coupon-dev.yaml

## 4、给配置中心的配置添加配置信息

![](https://gitee.com/starbug-gitee/PicBed/raw/master/img/20201219180400.png)

![](https://gitee.com/starbug-gitee/PicBed/raw/master/img/20201219180416.png)

## 5、获取动态配置

   ` @RefrteshScope`:  动态获取并刷新配置
    `@Value("${配置项名}")`:  获取配置
    如果配置中心和当前应用的配置文件中都配置了相同的项,优先使用配置中心的配置



# 远程调用

远程调用流程    

1、引入open-feign

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```


2、编写一个接口,告诉SpringCloud这个接口需要调用远程服务
      声明接口的每一个方法都是调用那个远程服务的那个请求

> @FeignClient(value = "gulimall-coupon")

3、开启远程调用功能,指定扫描那个包下的远程调用接口

> @EnableFeignClients(basePackages = {"com.ggs.gulimall.member.f eign"})




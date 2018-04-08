## 车机中心

- 详情参见《车机中心系统架构设计说明书》     
````
文档地址：http://120.26.220.241/zhangkejiang/doc.git 
下面的doc/概要设计/车机中心系统架构设计说明书.md 
````

### 开发说明
- 1, biz下 inf(接口定义)、srv（接口实现）

- 2, web下 api(接口服务)、srv(后台服务)

- 3, env下 公共配置文件，各大系统的环境参数变量定义和值

开发启动顺序：
- 启动之前，请先执行Maven命令： clean package -Pdev，采用开发环境的参数配置。
- 服务都在vc-web目录下面，由于采用dubbox框架，所以服务实现和调用是分离的。
- 配置中心->web-srv（后台服务）->web-api（接口服务或者前端服务）。



### 运维说明
1. git下载地址

	http://120.26.220.241/zhangkejiang/vc.git
2. jre需要安装替换加密包（参考下面的spring cloud config server支持加密配置）
3. 下载后打包，在web-env工程下面配置好prod结尾的配置文件，并使用命令：mvn clean package -Pprod
4. 在vc-web目录下找到各个工程的target目录下面的jar包
5. 直接使用命令：java -jar jar包名称，就可以运行
6. 环境搭建<br>

	（1）redis（阿里云）<br>
	（2）zookeeper<br>
	（3）mongodb（阿里云）<br>
	（4）dubbo-admin-2.8.4 (dubbo后台)<br>
	（5）运维git私有工程<br>
	（6）spring cloud config server服务<br>
	（7）mysql(阿里云rds）<br>
	（8）kafka（未使用）<br>

7. 运维<br>

    （1）Jenkins 构建<br>
    （2）构建包传输到服务node上,现有vtsearch、command两个服务<br>
	（3）对外提供统一接口服务域名vc-api.ccclubs.com （未使用）<br>
	（4）SLB路由规则：<br>
       - URL中含有vtsearch的路由到vtsearch服务 <br>
       - URL中含有command的路由到command服务 <br>
    （5）SLB 外网IP:101.37.178.63   内网IP：100.115.174.223


### Swagger2 API 接口注解，显示API接口结构，访问地址如下：
http://IP地址:端口/swagger-ui.html
http://IP地址:端口/v2/api-docs

### 程序端口定义规则,如下：
模块|端口
---|---
vc-web-config-srv        |           prot:11112
vc-web-vtsearch-api      |           prot:7003
vc-web-vtsearch-srv      |           prot:11113
vc-web-command-api       |           prot:7004
vc-web-command-srv       |           prot:11114
vc-web-quota-api         |           port:7005
vc-web-quota-srv         |           port:11115
vc-web-gateway-808-srv     |         port:12001
vc-web-gateway-mqtt-srv     |        port:12002
vc-web-gateway-gb-srv       |        port:12003
vc-web-rule-engine-srv |   port:12004
vc-web-cmd-engine-srv |  port:12005
vc-web-phoenix-api     |  port:7007
vc-web-phoenix-srv     |  port:11117
vc-web-storage-srv     |  port:12008


### mybatis generate自动生成插件(具体参考demo)
- 1.增加SerializablePlugin插件，dubbox传输需要支持serializable序列化接口
- 2.工程分类依赖变动，frm-mybatis provided orm，inf依赖orm（model重复使用），srv则需要依赖orm和mybatis
- 3.详情配置参考/vc-biz-demo-orm/src/main/resources/generatorConfig.xml

### spring cloud config server支持加密配置(具体参考demo)
	
	AES如果密钥大于128, 会抛出Java.security.InvalidKeyException: Illegal key size 异常. 因为密钥长度是受限制的, java运行时环境读到的是受限的policy文件. 文件位于${java_home}/jre/lib/security, 这种限制是因为美国对软件出口的控制.

	在官方网站下载JCE无限制权限策略文件
	jdk6: http://www.oracle.com/technetwork/java/javase/downloads/jce-6-download-429243.html
	JDK7的下载地址: http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html
	JDK8的下载地址: http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html 
	下载后解压，可以看到local_policy.jar和US_export_policy.jar以及readme.txt
	如果安装了JRE，将两个jar文件放到%JRE_HOME%\lib\security目录下覆盖原来的文件
	如果安装了JDK，还要将两个jar文件也放到%JDK_HOME%\jre\lib\security目录下覆盖原来文件

	1. /vc-web-demo-api/src/main/resources/bootstrap.yml配置修改：
	cloud:
	  config:
	  	server:
	    	encrypt: 
	        	#是否暴露加解密接口，true显示加密解密接口
	          	enabled: true

	2. 加密方法，命令行执行： curl 服务地址:端口/encrypt -d 需要加密的字符串
	3. 上面返回的字符串在配置文件里修改，形式如 对象名称：'{cipher}返回的加密字符串'
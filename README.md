# Java技术核心依赖

| 依赖                 | 版本                    |
| -------------------- | ----------------------- |
| Spring Boot          | 2.2.1.RELEASE           |
| Spring Cloud         | 2.2.0.RELEASE（Hoxton） |
| Spring Cloud Alibaba | 0.2.2.RELEASE           |
| Mybatis Plus         | 3.4.3                   |
| druid                | 1.2.6                   |
| swagger              | 1.5.13                  |
| pagehelper           | 1.4.5                   |
| junit                | 4.12                    |
| fastjson             | 1.2.28                  |
| easyexcel            | 2.1.1                   |
| jjwt                 | 0.7.0                   |
| lombok               | 1.18.12                 |



# 【门户网站】

## 主页

* 地址：http://localhost:8080/#/index

![image1](https://cocochimp-img.oss-cn-beijing.aliyuncs.com/23-03/20231115215801.png)



## 主页功能模块

![image](https://cocochimp-img.oss-cn-beijing.aliyuncs.com/23-03/20231115215837.png)

**该模块分为：**

1. **部门介绍：**介绍项目的部门系统
2. **民主党派：**介绍项目的党派信息
3. **无党派人士：**介绍项目的非党派信息
4. **下载专区：**用户下载文件专区



## 统战信息系统

* 点击此处进入“功能页面”

![image](https://cocochimp-img.oss-cn-beijing.aliyuncs.com/23-03/20231115215915.png)

* 登录页面：http://localhost:8080/#/login

![image](https://cocochimp-img.oss-cn-beijing.aliyuncs.com/23-03/20231115215939.png)

| 用户名  | 密码   | 权限     |
| ------- | ------ | -------- |
| admin   | 111111 | all      |
| renwu   | 111111 | 人物库   |
| zuzhi   | 111111 | 组织库   |
| ziliao  | 111111 | 资料库   |
| juece   | 111111 | 决策中心 |
| gongzuo | 111111 | 工作平台 |

* 功能详情：http://localhost:8080/#/appMainIndex

![image](https://cocochimp-img.oss-cn-beijing.aliyuncs.com/23-03/20231115220018.png)



# 【功能模块】

![image-20230903211321069](https://cocochimp-img.oss-cn-beijing.aliyuncs.com/23-03/20230903211321.png)

## 人物库

* 地址：http://localhost:8080/#/welcome
* 功能：管理统战人物信息

![image](https://cocochimp-img.oss-cn-beijing.aliyuncs.com/23-03/20231115220049.png)

> 功能介绍：

**该模块分为：**

1. **统战人物(教职工)：**对所有教职工人员的信息进行统一管理CRUD
2. **添加成员(教职工)：**添加教职工人员信息



## 组织库

* 地址：http://localhost:8080/#/organization/organizationWelcome
* 功能：管理统战组织信息

![image-20230903211707351](https://cocochimp-img.oss-cn-beijing.aliyuncs.com/23-03/20230903211707.png)

> 功能介绍：

**该模块分为：**

1. **基层统战：**学校内每个学院的人员党派信息
2. **民主党派：**各个民主党派的人员党派信息
3. **群团组织：**无党派以及知联会人员党派信息
4. **少数民族：**展示少数民族的人员党派信息
5. **参政议政：**党代表、政协委员、人大代表等人员党派信息

* **组织管理：**管理“基层统战”的组织信息，统计人数



## 资料库

* 地址：http://localhost:8080/#/reward
* 功能：管理门户网站和决策中心资料展示信息

![image-20230903212330892](https://cocochimp-img.oss-cn-beijing.aliyuncs.com/23-03/20230903212330.png)

> 功能介绍：

**该模块分为：**

1. **获奖：**学校内获奖情况展示，并且附有“资料上传”功能
2. **门户网站文章：**展示文章的信息，并且附有”发布“等功能
3. **门户网站轮播图：**在门户网站展示的轮播图，CURD功能
4. **门户网站下载专区：**在门户网站显示的下载专区模块
5. **统战成果新闻展示：**在领导决策中心展示的新闻模块，并且附有”发布“等功能
6. **统战成果轮播图展示：**在领导决策中心展示的轮播图模块，并且附有”添加“等功能



## 业务工作平台

* 地址：http://localhost:8080/#/welcomeWorkplace
* 功能：管理平台权限信息

![image](https://cocochimp-img.oss-cn-beijing.aliyuncs.com/23-03/20231115220118.png)

> 功能介绍：

**该模块分为：**

1. **用户管理：**管理系统用户信息
2. **角色管理：**管理系统角色信息
3. **菜单管理：**管理展示菜单信息



# 【领导决策中心】

该模块是以大数据的形式展示各种统战数据

## 首页

* 地址：http://localhost:8080/#/metadata/dataIndex

![image](https://cocochimp-img.oss-cn-beijing.aliyuncs.com/23-03/20231115220138.png)

* 展示内容：
  * 统战工作对象，党外干部
  * 民主党派，两代表一委员
  * 少数民族，获奖情况
  * 无党派、留学人员，参政议政情况



## 民主党派

* 地址：http://localhost:8080/#/metadata/democrat

![image](https://cocochimp-img.oss-cn-beijing.aliyuncs.com/23-03/20231115220203.png)

* 展示内容：
  * 成员数量，新发展成员数量
  * 年龄分布，性别分布
  * 学历分布，职称分布
  * 各学院人员数量，参政议政



## 无党派、党外人士

* 地址：http://localhost:8080/#/metadata/frontParty

![image](https://cocochimp-img.oss-cn-beijing.aliyuncs.com/23-03/20231115220224.png)

* 展示内容：知联会、无党派人士、留学归国人员
  * 性别分布、年龄分布
  * 学历分布、职称分布
  * 级别分布



## 少数民族

* 地址：http://localhost:8080/#/metadata/minNationality

![image](https://cocochimp-img.oss-cn-beijing.aliyuncs.com/23-03/20231115220245.png)

* 展示内容：
  * 民族分布，性别分布
  * 学历分布，职称分布
  * 学院分布



## 统战成果展示

* 地址：http://localhost:8080/#/metadata/gain

![image](https://cocochimp-img.oss-cn-beijing.aliyuncs.com/23-03/20231115220302.png)

* 展示内容：
  * 教学科研成果展示：新闻
  * 统战成果展示：新闻



## 人物画像

* 地址：http://localhost:8080/#/metadata/portrait

![image](https://cocochimp-img.oss-cn-beijing.aliyuncs.com/23-03/20231115220325.png)

* 展示内容：
  * 人员检索结果
  * 民主党派成果
  * 无党派人士
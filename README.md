# Onlinexam

## 学生在线考试系统

### 使用说明

#### 1.环境

* Eclipse Oxygen.2 Release (4.7.2)
* apache-tomcat-9.0.1
* MySQL 5.7.14
* java version "1.8.0_152" Java(TM) SE Runtime Environment

#### 2.系统配置

* 数据库信息及管理员账号密码配置：/src/db.properties
* username：数据库用户名
* password：数据库密码
* adminUsername：管理员账号
* adminPassword：管理员密码
* 教师账号和学生账号可在管理员模块自行添加

#### 3.使用方法

```
1.在mysql中建立onlinexam表并设置编码为UTF-8，将mysql端口设置为3306（默认）
2.将/sql/onlinexam.sql导入到mysql的onlinexam数据库中
3.将项目导入到Eclipse中并设置系统各项编码为UTF-8
4.修改上述配置文件，填写数据库和管理员等信息
5.部署项目，运行
```

MYBATIS Data Mapper Framework
=============================

[![Build Status](https://travis-ci.org/mybatis/mybatis-3.svg?branch=master)](https://travis-ci.org/mybatis/mybatis-3)
[![Maven central](https://maven-badges.herokuapp.com/maven-central/org.mybatis/mybatis/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.mybatis/mybatis)

![mybatis](http://mybatis.github.io/images/mybatis-logo.png)

The MyBatis data mapper framework makes it easier to use a relational database with object-oriented applications.
MyBatis couples objects with stored procedures or SQL statements using a XML descriptor or annotations.
Simplicity is the biggest advantage of the MyBatis data mapper over object relational mapping tools.

Essentials
----------

* [See the docs](http://mybatis.github.io/mybatis-3)
* [Download Latest](https://github.com/mybatis/mybatis-3/releases)


Note
----------
#与$区别:
    #xxx# 代表xxx是属性值,map里面的key或者是你的pojo对象里面的属性, ibatis会自动在它的外面加上引号,表现在sql语句是这样的 where xxx = 'xxx' ;
    $xxx$ 则是把xxx作为字符串拼接到你的sql语句中, 比如 order by topicId : 
        语句这样写 ... order by #xxx# ibatis 就会把他翻译成 order by 'topicId' （这样就会报错） 
        语句这样写 ... order by $xxx$ ibatis 就会把他翻译成 order by topicId
        
    上述都是使用jdbc的PreparedStatement，只是#作为参数在sql预编译之后再传递进去
    （如：sql预编译结果select id,title,author,content from blog where id = ?， 编译之后再将值用'xx'的形式传入）
    而$作为sql整体直接参与预编译，所以无法防止注入。
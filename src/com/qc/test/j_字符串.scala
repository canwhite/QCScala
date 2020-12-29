package com.qc.test

object j_字符串 {


  //在scala中是没有字符串的，scala的字符串实际上就是Java String
  //在 Scala 中，String 是一个不可变的对象，所以该对象不可被修改。这就意味着你如果修改字符串就会产生一个新的字符串对象。

  def main(args: Array[String]): Unit = {
    //1.创建的话很简单
    var greeting = "Hello World!";
    print(greeting);


    //2.String对象是不可变的，但是也有可变的字符串对象StringBuilder
    var buf = new StringBuilder();
    buf += 'a';//注意需要的是char，所以单引号
    buf ++= "bcdef";//第一次见++=，长见识了
    print(buf.toString());



    //3.字符串长度和js的一毛一样
    print('\n')
    print(greeting.length())


    //4.字符串连接，不用那么麻烦加号连接就可以了



    print('\n');
    //5.创建格式化字符串还是经常用到的
    var floatVar = 12.456
    var intVar = 2000
    var stringVar = "菜鸟教程!"
    var fs = printf("浮点型变量为 " +
      "%f, 整型变量为 %d, 字符串为 " +
      " %s", floatVar, intVar, stringVar)
    println(fs)


    //6.常用的字符串截取
    var test = "123445";
    print(test.slice(1,3));


  }





}

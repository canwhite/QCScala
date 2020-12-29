package com.qc.test

import scala.util.matching.Regex

object p_正则表达式 {
  def main(args: Array[String]): Unit = {

    //1.可以用r方法构建正则对象,当然也可以实例化
    //test1();

    //2.创建实例
    test2();



  }


  //1.通过r方法创建正则实例
  def test1(): Unit ={
    val pattern  = "Scala".r;
    val str = "Scala is Scalable and cool";
    //Option是一个容器，可以是Some也可能是None
    def show(x: Option[String]) = x match {
      case Some(s) => s
      case None => "?"
    }

    var data = (pattern findFirstIn  str);
    println(show(data));

  }



  //2.创建实例
  def test2(): Unit ={
    val pattern  = new Regex("(S|s)cala");//首字母可以是大写或者小写，这是匹配条件 可以用管道（|）来确定不同的模式
    val str = "Scala is scalable and cool";
    //可以用mkString方式来连接正则表达式匹配结果的字符串
    println((pattern findAllIn  str).mkString(","))//使用,来连接返回结果

  }



}

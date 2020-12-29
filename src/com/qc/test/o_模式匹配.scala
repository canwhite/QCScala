package com.qc.test
import scala.util.Random
object o_模式匹配 {
  def main(args: Array[String]): Unit = {

    //基础使用


    val x: Int = Random.nextInt(10)
    x match {
      case 0 => "zero"
      case 1 => "one"
      case 2 => "two"
      case _ => "other"
    }


    //模式匹配有点类似于函数版的switch def func(选择器-参数) =  选择器-参数 match {备选项}。
    println(matchTest(3))

  }

  def matchTest(x:Int):String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "many"//这种应该是匹配所有其余变量
  }


}

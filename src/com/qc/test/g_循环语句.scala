package com.qc.test

object g_循环语句 {
  /*
    while和do...while没有啥可讲的，但是这里的for还是很逗的
    break终端循环

    for循环的语法很有意思
      for(var x <- Range){
        statement;
      }
    其中range可以是一个数字区间i to j
    中间的符号不要误会，它其实是一个左箭头
    指的是把Range赋值给x

   */

  //一个实例,返回值不确定类型的时候类似于js的时候我们去掉了等号
  def main(args:Array[String]){
    var a = 0;
    //for循环
    for(a <- 1 to 10){
      println("Value of a:" + a);
    }

  }





}

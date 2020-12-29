package com.qc.test

object i_闭包 {
  def main(args: Array[String]): Unit = {
    //后边的箭头函数相当于匿名函数，只是把它扶着给了某个变量
    //这就是闭包
    val multiplier = (i:Int) => i * 10
    print(multiplier(1))
  }

}

package com.qc.test

object h_方法和函数 {


  /*

   //1.这是有返回类型的写法
   //这是声明一个函数类型的数据再给他赋值
   def main(args:Array[String]): Unit = {

   }

   */

  //2.这是没有返回类型的写法
  //不用加后边的逻辑块赋值
  def main(args:Array[String]){

    //参数类型需要确定
    def m(x:Int) = x + 3;
    print(m(3))
    print("\n")

    //或者直接将函数赋给变量
    val f = (x:Int) => x + 3;//注意这里用到了箭头函数
    print(f(4));


  }




}

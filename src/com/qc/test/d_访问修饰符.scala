package com.qc.test

object d_访问修饰符 {

  /*
    public 谁都可以访问
    protected 只有自己的子类或者同包可以访问
    private 只有自己类内部可以访问


   */

  //就举一个protected的例子，主要还是为了看创建实例的方法
  def main(args: Array[String]): Unit = {

      class Super{
        protected def f() {println("f")}
      }
      class Sub extends Super{
        f()
      }

      class Other{
        //(new Super).f() //错误，只有自己的子类可以调用
      }


  }




}

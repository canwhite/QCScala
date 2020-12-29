package com.qc.test

object r_提取器 {
  def main(args: Array[String]): Unit = {
    //提取器是从传递给它的对象中提取出构造该对象的参数
    //简单理解，创建Array对象可以这样
    //Scala 提取器是一个带有unapply方法的对象。unapply方法算是apply方法的反向操作：unapply接受一个对象，然后从对象中提取值，提取的值通常是用来构造该对象的值。
    val numNames1 = Array("zero", "one", "two")
    //也可以
    val numNames2 = Array.apply("zero", "one", "two")

    println ("Apply 方法 : " + apply("Zara", "gmail.com"));
    //这里相当于写了一个有筛选的get方法
    println ("Unapply 方法 : " + unapply("Zara@gmail.com"));
    println ("Unapply 方法 : " + unapply("Zara Ali"));

  }

  // 注入方法 (可选)
  def apply(user: String, domain: String) = {
    user +"@"+ domain
  }

  // 提取方法（必选）
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2){
      Some(parts(0), parts(1))
    }else{
      None
    }
  }

}

package com.qc.test

object m_迭代器 {
  def main(args: Array[String]): Unit = {
    //(1)hasNext 和 next()
    val it = Iterator("Baidu", "Google", "Runoob", "Taobao")
    while (it.hasNext){
      println(it.next())
    }

    //fix：还有max，min，length

    var list = List("baidu","ali","google");

//    while(list.iterator.hasNext){
//      println(list.iterator.next());
//    }
    //像上边这样写会无线循环下去
    //(2)拓展使用下forEach
    list.iterator.foreach((item)=>{
      println(item);
    })


  }

}

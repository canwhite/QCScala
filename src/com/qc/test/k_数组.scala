package com.qc.test

object k_数组 {

  def main(args: Array[String]): Unit = {

    //直接字面量
    //var z = Array("Runoob", "Baidu", "Google")
    //用声明的方式也可以
    var z = new Array[String](3)
    z(0) = "Runoob"; z(1) = "Baidu"; z(4/2) = "Google"

    //1.foreach
    z.foreach((item)=>{
      print(item);
      print('\n');
    })
    //2.map
    var a =  Array(1,2,3).map((item=>{
      item + 1
    }))
    print(a(0));
    print('\n');
    //3.concat合并和for循环
    var myList1 = Array(1.9, 2.9, 3.4, 3.5)
    var myList2 = Array(8.9, 7.9, 0.4, 1.5)
    var myList3 =  Array.concat( myList1, myList2)
    for ( x <- myList3 ) {
      println( x );//println本身就有换行
    }

    //4.区间数组，开头、结尾、步距(可省略)
    println();//换个行
    var rangeArray = Range(10,20,2);
    for(x <- rangeArray){
      print(x);
    }







  }
}

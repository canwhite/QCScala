package com.qc.test
import scala.collection.mutable.Set
object l_集合 {


  def main(args: Array[String]): Unit = {

    //=====================1.列表 - 以字符串列表举例==============================
    val site: List[String] = List("Runoob", "Google", "Baidu")
    print(site);
    //(1)构造列表的两个基础单位是::和Nil，Nil也可以表示一个空列表
    //so，字符串列表我们还可以像下边这样写，记得::如果想要往后叠加需要拓展括号，到Nil为止
    val strList = "Runoob" :: ("Google"::("baidu"::Nil))
    print(strList)

    //(2)填充值和foreach
    var fillList = List.fill(3)("baidu");
    fillList.foreach((item)=>{
      print('\n');
      print(item)
    })

    print('\n');

    //(3)使用六点运算符号可以连接列表
    var newList = site ::: strList;
    print(newList);


    //(4)根据给定的函数创建列表,6是生成6个的意思
    var squares = List.tabulate(6)(n =>n*n)
    print(squares);

    //(5)reverse反转 list.reverse

    //(6)foreach
    strList.foreach((item)=>{
      print("item",item);
    })
    print('\n');
    //(7)map
    var sList =  squares.map(item=>item + 1);
    print(sList);


    //(8)会有
    // head、tail(尾巴)、isEmpty
    // max、min、sum、length
    // toSet和toString 等一些属性


    //======================2.Set集合========================
    //Set是没有重复对象的，所有元素都是唯一的
    //默认情况下，Scala 使用的是不可变集合，如果你想使用可变集合，需要引用 scala.collection.mutable.Set 包。
    val site1 = Set("Runoob", "Google", "Baidu")
    val site2 = Set("Faceboook", "Taobao")
    //(1)添加删除,对于可变集合来说
    site1.add("ali");
    print('\n');
    print(site1);
    site1.remove("ali");
    print('\n');
    print(site1);
    //(2)拼接
    print('\n');
    print(site1 ++ site2);

    //(3)会有
    // head、tail(尾巴,去掉第一个)、isEmpty
    // max、min、sum、size


    //====================3.Map============================
    // Map 键值对演示
    val colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF")

    // （1）空哈希表，键为字符串，值为整型，用+号增加键值对
    var A:Map[Char,Int] = Map()
    A += ('I' -> 1)//区别于for循环，是右箭头
    A += ('J' -> 5)
    A += ('K' -> 10)
    A += ('L' -> 100)
    print('\n');
    println(A);
    //然后还可以获取
    println("get value by key:" ,A.get('I'));
    println("get none by key:", A.get('F'));

    print('\n');
    //keys values 都是可以跟forEach的 isEmpty
    A.keys.foreach{ i =>
      print( "Key = " + i )
      println(" Value = " + A(i) )}


    //==================4.元组===============================
    //与列表一样，元组也是不可变的，但与列表不同的是元组可以包含不同类型的元素。

    val t = (1, 3.14, "Fred")
    //(1)访问元素的时候_1访问第一个元素，_2访问第二个元素
    println(t._1);
    //(2)便利
    t.productIterator.foreach{ i =>println("Value = " + i )}
    //(3)转化成字符串是toString 交换元素是t.swap

    //PS：tuple设置键值对的方式和Map差不多
    // tuple(
    //   "username" -> text,
    //   "password" -> text
    // )




    //==================5.Option(选项)========================
    //option[T] 是一个类型为 T 的可选值的容器： 如果值存在， Option[T] 就是一个 Some[T] ，如果不存在， Option[T] 就是对象 None 。

    val sites = Map("runoob" -> "www.runoob.com", "google" -> "www.google.com")
    //和Map搭配使用
    println(show(sites.get( "runoob")) )//返回值是一个Some类型的值
    println(show(sites.get( "baidu")) )//返回值是None，因为key baidu 对应没有值，然后再用下边的模式匹配展开


  }
  //写个模式匹配
  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }






}

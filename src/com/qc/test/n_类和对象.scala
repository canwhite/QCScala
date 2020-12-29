package com.qc.test

//================1.类是抽象的，是蓝图，不占用内存，实例占用内存===================
class  Point(xc:Int,yc:Int){
  var x:Int = xc;
  var y:Int = yc;
  def move(dx:Int,dy:Int): Unit ={
    x = x + dx;
    y = y + dy;
    println ("x 的坐标点: " + x);
    println ("y 的坐标点: " + y);

  }
}

//==================2.和java一样用extends来继承一个类==========================

class  Person{
  private val name = "zack"
  val age=50
  def getName = this.name
}
//（1）Scala中，如果子类要覆盖父类中的一个非抽象方法，必须要使用 override 关键字；子类可以覆盖父类的 val 修饰的field，只要在子类中使用 override 关键字即可。
//（2）此外，在子类覆盖父类方法后，如果在子类中要调用父类中被覆盖的方法，则必须要使用 super 关键字，显示的指出要调用的父类方法。
class  Student extends  Person{
  private  val  score = "A";
  //a.子类可以覆盖父类的val field，使用override关键字
  override val age: Int = 30
  //b.子类定义自己的方法
  def getScore = this.score;

  //c.调用父类非抽象方法，必须要使用override关键字
  //同时调用父类的方法，使用super关键字
  override def getName: String = "your name is " +  super.getName

}



//=================3.单例的实现==================================================

/*
scala中使用单例模式时，除了定义的类之外，还要定义一个同名的Object对象，称为类的伴生对象，它和类的区别是，Object对象不能带参数。
类和他的伴生对象可以互相访问其私有成员。

*/

//(1)类
class  Worker private{
  def  work(){println("i am only a worker")}
  var name:String = "";
}
//(2)同名伴生对象
object Worker{
  var name = "";
  val worker = new Worker;
  def GetWorkInstance() : Worker = {
    worker.work()
    return  worker
  }
  def setName(name:String): Unit ={

    this.name = name;
  }

  def  getName = this.name;
}


/*
class Worker private声明了Worker的首构造函数是私有的，这样Worker的所有构造函数都不能直接被外部调用，
因为所有从构造函数都会首先调用其他构造函数（可以是主构造函数，也可以是从构造函数），结果就是主构造函数是类的唯一入口点。

另一方面，Worker.GetWorkInstance();有点类似静态函数调用，但在Scala中这是不对的。
Scala会隐式地调用apply来创建一个伴生对象的实例。Scala是一个纯粹的面向对象语言，不允许有任何破坏对象模型的机制存在，比如类的静态变量、函数等。

 */



//====================4.scala中的抽象类====================================

abstract class Person9(val name:String) {

  //必须指出返回类型，不然默认返回为Unit

  def sayHello:String

  def sayBye:String

}

//继承实现
class Student9(name:String) extends Person9(name){

  //必须指出返回类型，不然默认

  def sayHello: String = "Hello,"+name

  def sayBye: String ="Bye,"+name

}




//====================5.scala中的接口类===================================
trait Equal {
  def isEqual(x: Any): Boolean
  //与普通接口不同的是，scala特性可以定义实现
  def isNotEqual(x: Any): Boolean = !isEqual(x)
}

class Point1(xc: Int, yc: Int) extends Equal {
  var x: Int = xc
  var y: Int = yc
  //这里补充一个知识点：

  def isEqual(obj: Any) =
    obj.isInstanceOf[Point1] &&
      obj.asInstanceOf[Point1].x == x
}

//================6.补充知识：instance和class精确判断=========================
//注意1： p.isInstanceOf[XX] 判断 p 是否为 XX 对象的实例；p.asInstanceOf[XX] 把 p 转换成 XX 对象的实例
//注意2： 另外还可以用getClass和classOf精确判断
class Person4 {}

class Student4 extends Person4



/*
抽象类接近一些类的属性，而接口更接近于工具属性
（1）接口里定义的变量只能是公共的静态的常量，抽象类中的变量是普通变量。
（2）抽象类要被子类继承，接口要被类实现，一个extends 一个implements
（3）抽象类里的抽象方法必须全部被子类所实现，如果子类不能全部实现父类抽象方法，那么该子类只能是抽象类。
    同样，一个实现接口的时候，如不能全部实现接口方法，那么该类也只能为抽象类。


 */


object n_类和对象 {
  def main(args: Array[String]): Unit = {



    // 1.类的实例化
    val pt = new Point(10, 20);

    pt.move(10, 10);

    // 2.子类的使用,实例化的时候如果没有参数，可以不给实例后边加小括号
    // getName在这里是个闭包
    var name =  (new Student).getName;
    println(name)


    // 3.单例的获取使用，单例的实例化是在内部完成的直接调用就可以了
    Worker.GetWorkInstance();
    Worker.setName("qc");
    println("worker name is : "+ Worker.getName);



    //4.抽象类
    val s = new Student9("tom")

    println(s.sayHello)

    println(s.sayBye)


    //5.接口类
    val p1 = new Point1(2, 3)
    val p2 = new Point1(2, 3)
    val p3 = new Point1(3, 3)

    println(p1.isNotEqual(p2))
    println(p1.isNotEqual(p3))
    println(p1.isNotEqual(2))





    //6.补充知识
    val p:Person4=new Student4

    //判断p是否为Person4类的实例，子类也是

    println(p.isInstanceOf[Person4])//true

    //判断p的类型是否为Person4类，这个就需要精确判断了

    println(p.getClass == classOf[Person4])//false

    //判断p的类型是否为Student4类，只有精确匹配

    println(p.getClass == classOf[Student4])//true




  }
}

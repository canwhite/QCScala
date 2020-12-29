//建包的第一种方式
//src右键，新建package，然后再往里边添加相应的类文件hello
package  hello_package ;//声明式的
object hello {
  //入口函数
  def main(args: Array[String]): Unit = {
    print("hello world");
  }
}


//这是建包的第二种方式，类似于export {}
/*
package hello_package{
  object hello {
    //入口函数
    def main(args: Array[String]): Unit = {
      print("hello world");
    }
  }
}
 */


package com.qc.test
import java.io._ //写文件
import scala.io._ //读input
import scala.io.Source //读文件


object s_文件io {
  def main(args: Array[String]): Unit = {

    //writeFile();

    //readInput();

    readFile()

  }

  //1.写文件
  def  writeFile(): Unit ={

    val writer = new PrintWriter(new File("test.txt" ))
    writer.write("菜鸟教程")
    writer.close()
  }

  //2.读输入
  def  readInput(): Unit ={
    print("请输入菜鸟教程官网 : " )
    val line = StdIn.readLine()
    println("谢谢，你输入的是: " + line)
  }


  //3.读文件
  def readFile(): Unit ={
    println("文件内容为:" )

    Source.fromFile("test.txt" ).foreach{
      print
    }

  }


}

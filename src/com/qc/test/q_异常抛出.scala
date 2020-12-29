package com.qc.test
import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException


object q_异常抛出 {
  def main(args: Array[String]): Unit = {

    try {
      val f = new FileReader("input.txt")
    } catch {
      //catch里边接的case
      case ex: FileNotFoundException =>{
        println("Missing file exception")
      }
      case ex: IOException => {
        println("IO Exception")
      }
    }



  }

}

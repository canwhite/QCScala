package com.qc.test
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Promise
import scala.util.{Failure, Success, Try}//使用alt + enter可以补全
object u_Promise {
  //promise用起来和ES6区别还是很明显的，
  //需要挂载一个Future做展开
  def main(args: Array[String]): Unit = {

    //1.先建一个Promise实例
    val donutStockPromise = Promise[Int]();
    //2.拿到挂载属性future
    val donutStockFuture = donutStockPromise.future
    //3.用future做一个展开等待promise触发
    donutStockFuture.onComplete{
      case Success(stock) => println(s"Stock for vanilla donut = $stock")
      case Failure(e)     => println(s"Failed to find vanilla donut stock, exception = $e")
    }
    //4.然后用promise.success | promise.failure | promise.complete来触发程序运行
    //  相关执行命令里放的是方法

    /*
    val donut = "vanilla donut"
    if(donut == "vanilla donut") {
      donutStockPromise.success(donutStock(donut))//执行到了这里
    } else {
      donutStockPromise.failure(Try(donutStock(donut)).failed.get)//加了Try，末尾是failed.get
    }
    println();
    */


    //当然也可以complete执行
    donutStockPromise.complete(Try(donutStock("unknown donut")))
    println();







  }
  def donutStock(donut: String): Int = {
    if(donut == "vanilla donut") 10
    else throw new IllegalStateException("Out of stock")
  }





}

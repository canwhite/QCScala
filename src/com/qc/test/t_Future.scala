package com.qc.test
//首先引入需要的包
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global//会提供一个默认的线程池来异步执行Future
//阻塞获取
import scala.concurrent.Await
import scala.concurrent.duration._
//非阻塞式获取
import scala.util.{Failure, Success}

object t_Future {
  def main(args: Array[String]): Unit = {

    //1.阻塞方式获取Future的值 Await.result 调用函数给出时间
    /*
    //第二个时间参数就是最大等待时间
    val vanillaDonutStock = Await.result(donutStock("vanilla donut"), 2 seconds)
    println("Stock of vanilla donut = " + vanillaDonutStock);
     */

    //2.非阻塞式的获取Future的值onComplete，判断成功失败状态，当然方法内部是可以阻塞的
    /*
    println();
    donutStock("vanilla donut").onComplete {
      case Success(stock) => println(s"Stock for vanilla donut = $stock")
      case Failure(e) => println(s"Failed to find vanilla donut stock, exception = $e")
    }
    */


    //3.Future链，使用了flatmap去链接他们
    /*
    println();
    //(1)首先链接一下，这里会有一个传值的过程
    var buyingDounts:Future[Boolean] = donutStock("plain donut").flatMap(count=>buyDonuts(count));
    //PS:这里区分一下Map，flatMap返回Future[Boolean],而map则需要嵌套，可以看下下边的返回值
    //val buyingDonuts: Future[Future[Boolean]] = donutStock("plain donut").Map(qty => buyDonuts(qty))

    //(2)然后使用
    var isSuccess = Await.result(buyingDounts,5 seconds);
    println(isSuccess);
    */



    //4.andThen
    println();
    val donutStockOperation = donutStock("vanilla donut")//先做一个闭包





  }

  //定义一个返回Future的函数,甜甜圈存量
  def donutStock(donut:String):Future[Int] = Future{
    println("checking donut stock")
    10//这个10会自动包到Future里边
  }

  //为了测试Future链再配置一个方法,买甜甜圈
  def buyDonuts(quantity: Int): Future[Boolean] = Future {
    println(s"buying $quantity donuts")
    true

  }




}

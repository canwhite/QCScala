package com.qc.test

object v_case_class {

  /*

    案例类非常适用于不可变的数据
    和普通类差不过，只有几点关键差别
    下边介绍几种关键区别，这里主要是前三点
    1.不用new
    2.用val接
    3.按值比较

    另外知道可以浅拷贝

    使用的话可以和模式匹配配套使用：

   */


  /*
    使用部分的案例
   */

  abstract class Notification

  case class Email(sender: String, title: String, body: String) extends Notification

  case class SMS(caller: String, message: String) extends Notification

  case class VoiceRecording(contactName: String, link: String) extends Notification



  def main(args: Array[String]): Unit = {


    //1. 注意在实例化案例类Book时，并没有使用关键字new，这是因为案例类有一个默认的apply方法来负责对象的创建。
    case class Book(isbn: String)
    val frankenstein = Book("978-0486282114")


    //2.因为它是一个val（不可变）,你不能给message1.sender重新赋值，在案例类中使用var也是可以的，但并不推荐这样。
    case class Message(sender: String, recipient: String, body: String)
    val message1 = Message("guillaume@quebec.ca", "jorge@catalonia.es", "Ça va ?")

    println(message1.sender)  // prints guillaume@quebec.ca
    //message1.sender = "travis@washington.us"  // this line does not compile



    //3. 比较，案例类在比较的时候是按值比较而非按引用比较：
    val message2 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
    val message3 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
    val messagesAreTheSame = message2 == message3  // true
    println(messagesAreTheSame);

    //4.拷贝 你可以通过copy方法创建一个案例类实例的浅拷贝，同时可以指定构造参数来做一些改变。
    val message4 = Message("julien@bretagne.fr", "travis@washington.us", "Me zo o komz gant ma amezeg")
    val message5 = message4.copy(sender = message4.recipient, recipient = "claire@bourgogne.fr")
    message5.sender  // travis@washington.us
    message5.recipient // claire@bourgogne.fr //指定了构造参数
    message5.body  // "Me zo o komz gant ma amezeg" //除非特别定义，要不然这里指向的就是message4



    //=========================================使用============================================
    //主要是根据传入的不同案例类，决定了不同的输出，这样封装起来也是很爽啊
    def showNotification(notification: Notification): String = {
      notification match {
        case Email(sender, title, _) =>
          s"You got an email from $sender with title: $title"
        case SMS(number, message) =>
          s"You got an SMS from $number! Message: $message"
        case VoiceRecording(name, link) =>
          s"you received a Voice Recording from $name! Click the link to hear it: $link"
      }
    }
    val someSms = SMS("12345", "Are you there?")
    val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

    println(showNotification(someSms))  // prints You got an SMS from 12345! Message: Are you there?

    println(showNotification(someVoiceRecording))  // you received a Voice Recording from Tom! Click the link to hear it: voicerecording.org/id/123


  }

}

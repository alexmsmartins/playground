package alexmsmartins.shapeless_with_traits

import shapeless._

sealed trait A {
  val a: String
  val b: Int
}
case class AA(override val a: String, override val b: Int, l: Long) extends A

case class BB(a: String, b: Int, s: String) extends A
object Main extends App {

  val aPath = ^ a
  val bPath = ^ b

  Console.println("Hello")

  def updateA[T](param: T, aString: String, bInt: Int)(
    implicit
    aL: aPath.Lens[T, String],
    bL: bPath.Lens[T, Int],
  ): T = {
    val param1: T = aL().set(param)(aString)
    bL().set(param1)(bInt)
  }

  val aa1 = AA("aa", 1, 1l)
  val aaCopied = updateA(aa1, "Updated", 9000)
  Console.println(aaCopied)

}

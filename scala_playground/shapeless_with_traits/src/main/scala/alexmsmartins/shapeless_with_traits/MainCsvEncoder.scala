package alexmsmartins.shapeless_with_traits

import shapeless._

/**
  * Taken from The Type Astronauts Guide to Shapeless - chapter 3 CsvEncoder example
  */
object MainCsvEncoder {
  def main(args: Array[String]): Unit = {

    val shapes: List[Shape] = List(
      Rectangle(3.0, 4.0),
      Circle(1.0)
    )
    val employees = List(
      Employee(name = "Bill", number = 1, manager = true),
      Employee(name = "Peter", number = 2, manager = false),
      Employee(name = "Milton", number = 3, manager = false)
    )
    val iceCreams: List[IceCream] = List(
      IceCream("Sundae", 1, false),
      IceCream("Cornetto", 0, true),
      IceCream("Banana Split", 0, false)
    )

    println("##### employees")
    println(writeCsv(employees))

    println("##### ice creams")

    println(writeCsv(iceCreams))

    println("##### shapes")

    println(writeCsv(shapes))

  }
  def writeCsv[A](values: List[A])(implicit enc: CsvEncoder[A]): String =
    values.map(value => enc.encode(value).mkString(",")).mkString("\n")

  sealed trait Shape
  final case class Rectangle(width: Double, height: Double) extends Shape
  final case class Circle(radius: Double) extends Shape
  case class Employee(name: String, number: Int, manager: Boolean)
  case class IceCream(name: String, numCherries: Int, inCone: Boolean)
  trait CsvEncoder[A] {
    def encode(value: A): List[String]
  }
  object CsvEncoder {

    def apply[A](implicit enc: CsvEncoder[A]): CsvEncoder[A] = enc

    def createEncoder[A](func: A => List[String]): CsvEncoder[A] = new CsvEncoder[A] {
      override def encode(value: A): List[String] = func(value)
    }

    implicit def genericEncoder[A, R](
      implicit gen: Generic[A] { type Repr = R },
      enc: CsvEncoder[R]
    ): CsvEncoder[A] = createEncoder(e => enc.encode(gen.to(e)))

    implicit val stringEncoder: CsvEncoder[String] =
      createEncoder(str => List(str))

    implicit val intEncoder: CsvEncoder[Int] =
      createEncoder(num => List(num.toString))

    implicit val booleanEncoder: CsvEncoder[Boolean] =
      createEncoder(bool => List(if (bool) "yes" else "no"))
    implicit val hnilEncoder: CsvEncoder[HNil] =
      createEncoder(hnil => Nil)

    implicit def hlistEncoder[H, T <: HList](
      implicit
      hEncoder: CsvEncoder[H],
      tEncoder: CsvEncoder[T]
    ): CsvEncoder[H :: T] =
      createEncoder {
        case h :: t =>
          hEncoder.encode(h) ++ tEncoder.encode(t)
      }

    implicit val cnilEncoder: CsvEncoder[CNil] =
      CsvEncoder.createEncoder(cnil => throw new Exception("This should never happen"))

    implicit def coproductEncoder[H, T <: Coproduct](
      implicit
      hEncoder: CsvEncoder[H],
      tEncoder: CsvEncoder[T]
    ): CsvEncoder[H :+: T] = CsvEncoder.createEncoder {
      case Inl(h) => hEncoder.encode(h)
      case Inr(t) => tEncoder.encode(t)
    }
    implicit val doubleEncoder: CsvEncoder[Double] = CsvEncoder.createEncoder(d => List(d.toString))
  }

}

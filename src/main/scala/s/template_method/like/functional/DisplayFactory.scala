package s.template_method.like.functional

object DisplayFactory {

  def createString(string: String): Display = {
    val width = string.length

    def printLine(): Unit = {
      Console.print("+")
      for (_ <- 0 until width) {
        Console.print("-")
      }
      Console.println("+")
    }

    val opener = () => printLine()
    val printer = () => Console.println("|" + string + "|")
    val closer = () => printLine()

    new Display(opener, printer, closer)
  }

  def createChar(ch: Char): Display = {
    val opener = () => Console.print("<<")
    val printer = () => Console.print(ch)
    val closer = () => Console.println(">>")
    new Display(opener, printer, closer)
  }

}

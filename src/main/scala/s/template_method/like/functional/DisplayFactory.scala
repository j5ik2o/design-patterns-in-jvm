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

    val opener: DisplayDelegate = () => {
      printLine()
    }

    val printer: DisplayDelegate = () => {
      Console.println("|" + string + "|")
    }

    val closer: DisplayDelegate = () => {
      printLine()
    }

    new Display(opener, printer, closer)
  }

  def createChar(ch: Char): Display = {
    val opener: DisplayDelegate = () => {
      Console.print("<<")
    }

    val printer: DisplayDelegate = () => {
      Console.print(ch)
    }

    val closer: DisplayDelegate = () => {
      Console.println(">>")
    }

    new Display(opener, printer, closer)
  }

}

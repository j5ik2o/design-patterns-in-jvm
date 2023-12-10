package k.template_method.like.functions

object DisplayFactory {

    fun createString(string: String): Display {
        val width = string.length

        fun printLine() {
            print("+")
            repeat(width) {
                print("-")
            }
            println("+")
        }

        val opener = { printLine() }
        val printer = { println("|$string|") }
        val closer = { printLine() }

        return Display(opener, printer, closer)
    }

    fun createChar(ch: Char): Display {
        val opener = { print("<<") }
        val printer = { print(ch) }
        val closer = { println(">>") }

        return Display(opener, printer, closer)
    }
}

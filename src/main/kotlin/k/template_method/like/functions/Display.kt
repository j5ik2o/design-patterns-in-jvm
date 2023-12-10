package k.template_method.like.functions

class Display(
    private val opener: () -> Unit,
    private val printer: () -> Unit,
    private val closer: () -> Unit
) {
    fun display() {
        opener()
        repeat(5) {
            printer()
        }
        closer()
    }
}
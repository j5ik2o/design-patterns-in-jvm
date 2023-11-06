package k.template_method.delegate

import j.template_method.delegate.DisplayDelegate


class Display(
    private val opener: DisplayDelegate,
    private val printer: DisplayDelegate,
    private val closer: DisplayDelegate
) {
    fun display() {
        opener.open()
        for (i in 0..4) {
            printer.print()
        }
        closer.close()
    }
}

/* (C)2022 */
package k.template_method.inheritance

class CharDisplay(val ch: Char) : AbstractDisplay() {

    override fun open() {
        // 開始文字列として"<<"を表示する
        print("<<")
    }

    override fun print() {
        // フィールドに保存しておいた文字を1回表示する
        print(ch)
    }

    override fun close() {
        // 終了文字列として">>"を表示する
        println(">>")
    }
}

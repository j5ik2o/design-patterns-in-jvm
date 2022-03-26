/* (C)2022 */
package k.command.drawer

import java.awt.Point
import k.command.command.Command

open class DrawCommand(protected var drawable: Drawable, private val position: Point) : Command {
  override fun execute() {
    drawable.draw(position.x, position.y)
  }
}

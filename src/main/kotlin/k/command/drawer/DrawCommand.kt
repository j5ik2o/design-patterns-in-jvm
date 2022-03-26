/* (C)2022 */
package k.command.drawer

import java.awt.Point
import k.command.command.Command

class DrawCommand(private val drawable: Drawable, private val position: Point) : Command {
  override fun execute() {
    drawable.draw(position.x, position.y)
  }
}

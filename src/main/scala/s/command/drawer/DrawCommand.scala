/* (C) 2022 */
package s.command.drawer

import s.command.command.Command

import java.awt.Point

class DrawCommand(var drawable: Drawable, var position: Point) extends Command {
  override def execute(): Unit = {
    drawable.draw(position.x, position.y)
  }
}

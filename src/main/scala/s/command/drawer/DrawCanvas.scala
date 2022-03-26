/* (C) 2022 */
package s.command.drawer

import s.command.command.MacroCommand

import java.awt.Canvas
import java.awt.Color
import java.awt.Graphics

class DrawCanvas(
    width: Int,
    height: Int,
    var history: MacroCommand
) extends Canvas
    with Drawable {
  setSize(width, height)
  setBackground(Color.white)
  private val color = Color.red
  private val radius = 6

  override def paint(g: Graphics): Unit = {
    history.execute()
  }

  override def draw(x: Int, y: Int): Unit = {
    val g = getGraphics
    g.setColor(color)
    g.fillOval(x - radius, y - radius, radius * 2, radius * 2)
  }
}

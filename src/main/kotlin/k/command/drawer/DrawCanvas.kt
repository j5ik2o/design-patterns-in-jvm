/* (C)2022 */
package k.command.drawer

import java.awt.Canvas
import java.awt.Color
import java.awt.Graphics
import k.command.command.MacroCommand

class DrawCanvas(width: Int, height: Int, history: MacroCommand) : Canvas(), Drawable {
  private val color = Color.red

  private val radius = 6

  private val history: MacroCommand

  init {
    setSize(width, height)
    background = Color.white
    this.history = history
  }

  override fun paint(g: Graphics) {
    history.execute()
  }

  override fun draw(x: Int, y: Int) {
    val g = graphics
    g.color = color
    g.fillOval(x - radius, y - radius, radius * 2, radius * 2)
  }
}

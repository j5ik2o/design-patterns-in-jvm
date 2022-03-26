/* (C) 2022 */
package s.command.drawer

import s.command.command.MacroCommand

import java.awt.Canvas
import java.awt.Color
import java.awt.Graphics

class DrawCanvas(
    width: Int,
    height: Int, // 履歴
    var history: MacroCommand
) // コンストラクタ
    extends Canvas
    with Drawable {
  setSize(width, height)
  setBackground(Color.white)
  // 描画色
  private val color = Color.red
  // 描画する点の半径
  private val radius = 6

  override def paint(g: Graphics): Unit = {
    history.execute()
  }

  // 描画
  override def draw(x: Int, y: Int): Unit = {
    val g = getGraphics
    g.setColor(color)
    g.fillOval(x - radius, y - radius, radius * 2, radius * 2)
  }
}

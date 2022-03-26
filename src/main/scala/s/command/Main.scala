/* (C) 2022 */
package s.command

import s.command.command.MacroCommand
import s.command.drawer.DrawCanvas
import s.command.drawer.DrawCommand
import java.awt.event._
import javax.swing._

object Main {
  def main(args: Array[String]): Unit = {
    new Main("Command Pattern Sample")
  }
}

class Main(title: String) // コンストラクタ
    extends JFrame(title)
    with MouseMotionListener
    with WindowListener {
  private val history = new MacroCommand
  private val canvas = new DrawCanvas(400, 400, history)

  addWindowListener(this)
  canvas.addMouseMotionListener(this)

  // 消去ボタン
  val clearButton = new JButton("clear")
  clearButton.addActionListener((e: ActionEvent) => {
    def foo(e: ActionEvent) = {
      history.clear()
      canvas.repaint()
    }
    foo(e)
  })

  val buttonBox = new Box(BoxLayout.X_AXIS)
  buttonBox.add(clearButton)

  val mainBox = new Box(BoxLayout.Y_AXIS)
  mainBox.add(buttonBox)
  mainBox.add(canvas)

  getContentPane.add(mainBox)
  pack()
  setVisible(true)

  override def mouseMoved(e: MouseEvent): Unit = {}

  override def mouseDragged(e: MouseEvent): Unit = {
    val cmd = new DrawCommand(canvas, e.getPoint)
    history.append(cmd)
    cmd.execute()
  }

  override def windowClosing(e: WindowEvent): Unit = {
    System.exit(0)
  }

  override def windowActivated(e: WindowEvent): Unit = {}

  override def windowClosed(e: WindowEvent): Unit = {}

  override def windowDeactivated(e: WindowEvent): Unit = {}

  override def windowDeiconified(e: WindowEvent): Unit = {}

  override def windowIconified(e: WindowEvent): Unit = {}

  override def windowOpened(e: WindowEvent): Unit = {}
}

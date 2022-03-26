/* (C)2022 */
package k.command

import java.awt.event.*
import javax.swing.Box
import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JFrame
import k.command.command.Command
import k.command.command.MacroCommand
import k.command.drawer.DrawCanvas
import k.command.drawer.DrawCommand

class Main(title: String?) : JFrame(title), MouseMotionListener, WindowListener {
  // 描画履歴
  private val history = MacroCommand()

  // 描画領域
  private val canvas = DrawCanvas(400, 400, history)

  // コンストラクタ
  init {
    addWindowListener(this)
    canvas.addMouseMotionListener(this)
    // 消去ボタン
    val clearButton = JButton("clear")
    clearButton.addActionListener { e: ActionEvent? ->
      history.clear()
      canvas.repaint()
    }
    val buttonBox = Box(BoxLayout.X_AXIS)
    buttonBox.add(clearButton)
    val mainBox = Box(BoxLayout.Y_AXIS)
    mainBox.add(buttonBox)
    mainBox.add(canvas)
    contentPane.add(mainBox)
    pack()
    isVisible = true
  }

  // MouseMotionListener用
  override fun mouseMoved(e: MouseEvent) {}
  override fun mouseDragged(e: MouseEvent) {
    val cmd: Command = DrawCommand(canvas, e.point)
    history.append(cmd)
    cmd.execute()
  }

  // WindowListener用
  override fun windowClosing(e: WindowEvent) {
    System.exit(0)
  }

  override fun windowActivated(e: WindowEvent) {}
  override fun windowClosed(e: WindowEvent) {}
  override fun windowDeactivated(e: WindowEvent) {}
  override fun windowDeiconified(e: WindowEvent) {}
  override fun windowIconified(e: WindowEvent) {}
  override fun windowOpened(e: WindowEvent) {}

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      Main("Command Pattern Sample")
    }
  }
}

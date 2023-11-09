package k.command

import k.command.command.Command
import k.command.command.MacroCommand
import k.command.drawer.DrawCanvas
import k.command.drawer.DrawCommand
import java.awt.event.MouseEvent
import java.awt.event.MouseMotionListener
import java.awt.event.WindowEvent
import java.awt.event.WindowListener
import javax.swing.Box
import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JFrame

class Main(title: String?) : JFrame(title), MouseMotionListener, WindowListener {
  private val history = MacroCommand()
  private val canvas = DrawCanvas(400, 400, history)

  init {
    addWindowListener(this)
    canvas.addMouseMotionListener(this)

    val clearButton = JButton("clear")
    clearButton.addActionListener {
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

  override fun mouseMoved(e: MouseEvent) {}
  override fun mouseDragged(e: MouseEvent) {
    val cmd: Command = DrawCommand(canvas, e.point)
    history.append(cmd)
    cmd.execute()
  }

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

/* (C) 2022 */
package s.command.command

import java.util
import scala.jdk.CollectionConverters._

class MacroCommand extends Command {
  private val commands = new util.ArrayDeque[Command]

  override def execute(): Unit = {
    for (cmd <- commands.asScala) {
      cmd.execute()
    }
  }

  def append(cmd: Command): Unit = {
    require(cmd eq this, "infinite loop caused by append")
    commands.push(cmd)
  }

  def undo(): Unit = {
    if (!commands.isEmpty) commands.pop
  }

  def clear(): Unit = {
    commands.clear()
  }
}

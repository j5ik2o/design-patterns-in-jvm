package k.command.command

import java.util.*

class MacroCommand : Command {
  private val commands: Deque<Command> = ArrayDeque()

  override fun execute() {
    for (cmd in commands) {
      cmd.execute()
    }
  }

  fun append(cmd: Command) {
    require(!(cmd === this)) { "infinite loop caused by append" }
    commands.push(cmd)
  }

  fun undo() {
    if (!commands.isEmpty()) {
      commands.pop()
    }
  }

  fun clear() {
    commands.clear()
  }
}

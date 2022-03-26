/* (C)2022 */
package j.command.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class MacroCommand implements Command {
    private final Deque<Command> commands = new ArrayDeque<>();

    @Override
    public void execute() {
        for (Command cmd : commands) {
            cmd.execute();
        }
    }

    public void append(Command cmd) {
        if (cmd == this) {
            throw new IllegalArgumentException("infinite loop caused by append");
        }
        commands.push(cmd);
    }

    public void undo() {
        if (!commands.isEmpty()) {
            commands.pop();
        }
    }

    public void clear() {
        commands.clear();
    }
}

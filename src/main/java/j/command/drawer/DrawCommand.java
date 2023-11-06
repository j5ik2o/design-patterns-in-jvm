package j.command.drawer;

import j.command.command.Command;

import java.awt.*;

public class DrawCommand implements Command {
    private final Drawable drawable;

    private final Point position;

    public DrawCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    @Override
    public void execute() {
        drawable.draw(position.x, position.y);
    }
}

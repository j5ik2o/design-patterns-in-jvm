/* (C)2022 */
package j.command;

import j.command.command.Command;
import j.command.command.MacroCommand;
import j.command.drawer.DrawCanvas;
import j.command.drawer.DrawCommand;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements MouseMotionListener, WindowListener {
    private final MacroCommand history = new MacroCommand();
    private final DrawCanvas canvas = new DrawCanvas(400, 400, history);

    public Main(String title) {
        super(title);

        addWindowListener(this);
        canvas.addMouseMotionListener(this);

        JButton clearButton = new JButton("clear");
        clearButton.addActionListener(
                e -> {
                    history.clear();
                    canvas.repaint();
                });

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);

        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);

        getContentPane().add(mainBox);
        pack();
        setVisible(true);
    }

    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        Command cmd = new DrawCommand(canvas, e.getPoint());
        history.append(cmd);
        cmd.execute();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowOpened(WindowEvent e) {}

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}

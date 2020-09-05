import javax.swing.*;
import java.awt.EventQueue;

public class PacMan extends JFrame{
    public PacMan(){
        initUI();
    }

    private void initUI(){
        add(new Board());
        setResizable(false);
        pack();
        setTitle("Sem20 PacMan");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            JFrame game1 = new PacMan();
            game1.setVisible(true);
        });
    }
}
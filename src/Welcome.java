import javax.swing.*;

public class Welcome extends JFrame {

    JLabel label;
    Welcome(){

        label = new JLabel("Hello");
        label.setOpaque(true);

        this.add(label);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        this.setVisible(true);
    }

}

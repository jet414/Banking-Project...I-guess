import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.SwingConstants.EAST;

public class Homepage {

    JFrame frame;
    JPanel navbar;
    JLabel name;
    Icon logo;

    JButton login;

    Homepage(){

        frame = new JFrame();

        navbar = new JPanel();
        navbar.setLayout(new BorderLayout());
        navbar.setBackground(new Color(34, 52, 43));

        name = new JLabel("Halamcage Banking");
        name.setFont(new Font("Publico Text", 1, 35));
        name.setForeground(Color.YELLOW);
        name.setHorizontalAlignment(2);
        navbar.add(name);

        login = new JButton("Login");
        login.setFont(new Font("Charter", 1, 25));
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //frame.dispose();
                //new Login();
            }
        });
        navbar.add(login, BorderLayout.EAST);



        frame.add(navbar, BorderLayout.NORTH);

        // Set up JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,550);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
    }

}

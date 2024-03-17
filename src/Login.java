import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Login{

    JFrame frame;

    HashMap<String, String> credentials;

    JLabel usernameField;
    JLabel passwordField;

    JTextField username;
    JPasswordField password;

    JRadioButton robot;
    public JButton submit;
    JButton reset;

    JOptionPane optionPane;

    boolean isRobot;

    Login(){

        frame = new JFrame();
        optionPane = new JOptionPane();

        credentials = new HashMap<String, String>();
        credentials.put("Halamcage", "414");

        usernameField = new JLabel("Username");
        usernameField.setBounds(90,100,80,20);

        passwordField = new JLabel("Password");
        passwordField.setBounds(90,160,80,20);

        username = new JTextField();
        username.setBounds(215,100,200,20);

        password = new JPasswordField();
        password.setBounds(215,160,200,20);

        robot = new JRadioButton("I am not a robot");
        robot.setBounds(180,300,300,20);
        robot.addActionListener(e -> {isRobot = true;});

        submit = new JButton("Submit");
        submit.setBounds(179,330,70, 30);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String usernameInput = username.getText();
                String passwordInput = String.valueOf(password.getPassword());

                if(credentials.containsKey(usernameInput) && isRobot){
                    if(passwordInput.equals(credentials.get(usernameInput))){

                        frame.dispose();
                        new Welcome();

                    }
                    else {
                        JOptionPane.showMessageDialog(null, "The password you entered was incorrect");
                    }
                }
                else if(!credentials.containsKey(usernameInput)) {
                    JOptionPane.showMessageDialog(null, "The username you entered was incorrect");
                } else {
                    JOptionPane.showMessageDialog(null, "You are a robot");
                }


            }
        });

        reset = new JButton("Reset");
        reset.setBounds(251,330,70,30);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username.setText("");
                password.setText("");
            }
        });



        // Add the components to the frame
        frame.add(usernameField);
        frame.add(username);
        frame.add(passwordField);
        frame.add(password);
        frame.add(robot);
        frame.add(submit);
        frame.add(reset);

        // Set up the JFrame for Login
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

}

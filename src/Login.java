import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Login{

    // initializing variables
    JFrame frame;

    HashMap<String, String> credentials;

    JLabel usernameField;
    JLabel passwordField;

    JTextField username;
    JPasswordField password;

    JRadioButton robot;
    public JButton submit;
    JButton reset;

    JButton toHomepage;

    JOptionPane optionPane;

    boolean isNotRobot;

    /*
    All of my code is within the constructor. The Main.java class only opens the Login class, which begins the process.
    */
    Login(){

        // Assigning objects/variables
        frame = new JFrame();
        optionPane = new JOptionPane();

        // Sample creds, will add a system to change this later.
        credentials = new HashMap<String, String>();
        credentials.put("Eashan", "414");

        // Label for username input field
        usernameField = new JLabel("Username");
        usernameField.setBounds(90,100,80,20);

        // Label for password input field
        passwordField = new JLabel("Password");
        passwordField.setBounds(90,160,80,20);

        //Enter username
        username = new JTextField();
        username.setBounds(215,100,200,20);

        // Enter password
        password = new JPasswordField();
        password.setBounds(215,160,200,20);

        // 'I am not a robot' check. I don't have a captcha test... YET...
        robot = new JRadioButton("I am not a robot");
        robot.setBounds(180,300,300,20);
        robot.addActionListener(e -> {
            isNotRobot = true;});

        // Submit button. This button has most of the logic. Should I put it in a different method?
        submit = new JButton("Submit");
        submit.setBounds(179,330,70, 30);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Assigning what the user inputted to variables.
                String usernameInput = username.getText();
                String passwordInput = String.valueOf(password.getPassword());

                /*
                HOW THE MAIN VERIFICATION WORKS:

                - If the Hashmap 'credentials' has the 'usernameInput' variable in it and the user is not a robot:
                    - Checks if the 'passwordInput' matches the value for the key 'usernameInput' in HashMap 'credentials':
                        - The 'Login' frame is disposed(meaning closed) and the 'Welcome' frame is launched.
                    - If password is not correct:
                        - JOptionPane shows a message dialog that the password is incorrect
                - If HashMap 'credentials' does not have the 'usernameInput' as a key:
                    - JOptionPane shows a message dialog saying that the entered username was incorrect
                - Else:
                    - JOptionPane shows a message dialog saying that the user is a robot.
                */
                if(credentials.containsKey(usernameInput) && isNotRobot){
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

        // Reset button: When clicked, the button erases whatever is in the 'username' and 'password' fields.
        reset = new JButton("Reset");
        reset.setBounds(251,330,70,30);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username.setText("");
                password.setText("");
            }
        });

        toHomepage = new JButton("⟸Homepage");
        toHomepage.setBounds(0, 375, 500, 90);
        toHomepage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Homepage();
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
        frame.add(toHomepage);

        // Set up the JFrame for Login
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

}

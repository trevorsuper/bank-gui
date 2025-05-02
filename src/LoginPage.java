import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage implements ActionListener { //implements ActionListener so the buttons can "listen" for input by the user
	 String accountNumber = "";
	 String password = "";
	JFrame UIFrame = null;
	JTextField UIOutput = null;
	JFrame frame = new JFrame("Pacific Standard Public Deposit Bank Terminal"); //names the frame
	JButton LoginButton = new JButton("Login"); //creates login button
	JTextField accountNumberField = new JTextField(); //fields create text boxes in the frame that the user can type in
	JPasswordField PasswordField = new JPasswordField();
	JLabel accountNumberLabel = new JLabel("Account Number:");
	JLabel passwordLabel = new JLabel("Password:");
	JLabel messageLabel = new JLabel("Welcome to the Pacific Standard Bank Terminal, please login.");
	
	HashMap<String,String> logininfo = new HashMap<String,String>(); //copy of our HashMap that is globally available to our LoginPage class so that other methods can use it
	
	LoginPage(HashMap<String,String> loginInfoOriginal){ // in the parenthesis of LoginPage() is the constructor, it will accept a HashMap loginInfoOrignial of two data types Strings
		logininfo = loginInfoOriginal;
		accountNumberLabel.setBounds(50,100,125,25);
		passwordLabel.setBounds(50,150,75,25);
		messageLabel.setBounds(50,25,500,35);
		messageLabel.setFont(new Font(null,Font.PLAIN,16)); // setFont() functions are for formatting
		accountNumberField.setBounds(175,100,200,25);
		PasswordField.setBounds(175,150,200,25);
		LoginButton.setBounds(175,200,200,25);
		LoginButton.addActionListener(this); //looks at the public void actionPerformed(ActionEvent e) function to see what each button does
		frame.add(accountNumberLabel); //adding the labels, buttons, and fields to the frame
		frame.add(passwordLabel); //frame and Window are the same thing
		frame.add(messageLabel);
		frame.add(accountNumberField);
		frame.add(PasswordField);
		frame.add(LoginButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == LoginButton) {
			accountNumber = accountNumberField.getText(); //reading the text that the user enters for account number
			password = String.valueOf(PasswordField.getPassword()); //reading the password that the user enters for the account number
			if(logininfo.containsKey(accountNumber)) { //if the Key value of the account number is within logininfo (HashMap) the next if statement will execute
				if(logininfo.get(accountNumber).equals(password)) { //if the Key of the HashMap belongs to the correct Value, the user will be logged in
					frame.dispose(); //closes the window
					//makes an object of documenting.java to print the old values from the last run.
					documenting documenter = new documenting();
					documenter.fileIO(0, 0, accountNumber);
					System.out.println(accountNumber);
					
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Incorrect Password");
				}
			}
			else {
				messageLabel.setForeground(Color.black);
				messageLabel.setText("The account you are trying to log into does not exist.");
			}
		}
	}
}
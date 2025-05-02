import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
public class AccountScreen1 implements ActionListener {
	
	JFrame frame = new JFrame("Pacific Standard Public Deposit Bank Terminal"); //naming the Window/Frame
	JLabel welcomeLabel = new JLabel();
	JLabel savingsLabel = new JLabel();
	JLabel checkingLabel = new JLabel();
	JTextField DepositField = new JTextField();
	JTextField WithdrawalField = new JTextField();
	JTextArea ReceiptField = new JTextArea();
	JTextArea ReceiptFieldTwo = new JTextArea();
	JLabel receiptLabel = new JLabel();
	JButton DepositGeneralButton = new JButton("Deposit");
	JButton WithdrawalGeneralButton = new JButton("Withdrawal");
	JButton CalculateInterestButton = new JButton("Calculate Interest");
	double SavingsAmount = 0.00; //temporary value for bank account amount
	double CheckingAmount = 0.00;
	double CurrentAmount; //what is the current amount in the bank account, for more than one deposit/withdrawal per program execution
	double PocketAmount; //what is the current amount the user has in their pocket that they would like to deposit into the bank
		AccountScreen1(String accountNumber){ //passing through the accountNumber String to the AccounScreen1() function to display the unique account number on the welcome page
			welcomeLabel.setBounds(125,0,500,35);
			welcomeLabel.setFont(new Font(null,Font.PLAIN,16));
			welcomeLabel.setText("Account Number: " + accountNumber + "  Routing Number: 322271627"); //I picked the routing number for California
			savingsLabel.setBounds(125,50,400,50);
			savingsLabel.setFont(new Font(null,Font.PLAIN,16));
			savingsLabel.setText("Savings Account: $"+CheckingAmount);
			checkingLabel.setBounds(125,100,400,50);
			checkingLabel.setFont(new Font(null,Font.PLAIN,16));
			checkingLabel.setText("Checking Account: $"+CheckingAmount);
			DepositField.setBounds(150,150,200,25);
			WithdrawalField.setBounds(150,175,200,25);
			ReceiptField.setBounds(150,255,100,400);
			ReceiptFieldTwo.setBounds(250,255,100,400);
			receiptLabel.setBounds(150, 230, 400, 30);
			receiptLabel.setText("Transaction History:");
			DepositGeneralButton.setBounds(350,150,200,25);
			DepositGeneralButton.addActionListener(this);
			WithdrawalGeneralButton.setBounds(350,175,200,25);
			WithdrawalGeneralButton.addActionListener(this);
			CalculateInterestButton.setBounds(150,200,400,25);
			CalculateInterestButton.addActionListener(this);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(welcomeLabel); //adding everything to the frame
			frame.add(savingsLabel);
			frame.add(checkingLabel);
			frame.add(DepositField);
			frame.add(WithdrawalField);
			frame.add(ReceiptField);
			frame.add(receiptLabel);
			frame.add(ReceiptFieldTwo);
			frame.add(DepositGeneralButton);
			frame.add(WithdrawalGeneralButton);
			frame.add(CalculateInterestButton);
			frame.setSize(750,750);
			frame.setLayout(null);
			frame.setVisible(false);
			ReceiptField.setEditable(false);
			ReceiptField.setLayout(null);
			ReceiptField.setAutoscrolls(true);

		}
		@Override
		public void actionPerformed(ActionEvent e) {
			String amtToDeposit;
			String amtToWithdrawl;
			double amtToDepositDouble;
			double amtToWithdrawlDouble;
			interestCalculator calc = new interestCalculator();
			LoginPage getPassword = new LoginPage(null);
			System.out.println(getPassword.accountNumberField.getText());
			if(e.getSource() == DepositGeneralButton) {
				System.out.println("deposit clicked"+ getPassword.accountNumber);
				savingsLabel.setText("Savings Account: $"+SavingsAmount );
				checkingLabel.setText("Checking Account: $"+CheckingAmount);
				frame.dispose();
				documenting documenter = new documenting();
				amtToDeposit = DepositField.getText(); // gets text from field
				amtToDepositDouble = Double.parseDouble(amtToDeposit);//turns text to double
				documenter.fileIO(amtToDepositDouble, 0, getPassword.accountNumber); //double goes into the fileIO method in documenting.java
				
				
			}
			if(e.getSource() == WithdrawalGeneralButton) {
				System.out.println("clicked withdrawl");
				savingsLabel.setText("Savings ccount: $" + SavingsAmount);
				checkingLabel.setText("Checking ccount: $" + CheckingAmount);
				frame.dispose();
				documenting documenter = new documenting();
				amtToWithdrawl = WithdrawalField.getText();
				amtToWithdrawlDouble = Double.parseDouble(amtToWithdrawl);
				documenter.fileIO(0, amtToWithdrawlDouble, getPassword.accountNumber);
				
			}
			
			if(e.getSource() == CalculateInterestButton) {
				System.out.println("interest button was clicked");
				///frame.dispose();
				calc.frame.setVisible(true);
				
				
		}
	}
		
}
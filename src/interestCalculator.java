import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
public class interestCalculator implements ActionListener {
	
	JFrame frame = new JFrame("Pacific Standard Public Deposit Bank Terminal");
	JLabel infoLabel = new JLabel("Interest Calculator");
	JLabel principalLabel = new JLabel("Principal Amount:");
	JLabel interestRateLabel = new JLabel("Interest Rate as a decimal:");
	JLabel numberOfCompoundLabel = new JLabel("Number of times interest is compounded in one year:");
	JLabel timeInYearsLabel = new JLabel("Number of years interest is compounded:");
	JTextField principalField = new JTextField();
	JTextField interestRateField = new JTextField();
	JTextField numberOfCompoundField = new JTextField();
	JTextField timeInYearsField = new JTextField();
	JButton CalculateButton = new JButton("Calculate Interest");
	String PRINCIPAL_AMOUNT_STRING, INTEREST_RATE_AS_A_DECIMAL_STRING, NUMBER_OF_TIMES_INTEREST_COMPOUNDED_IN_ONE_YEAR_STRING, TIME_IN_YEARS_STRING;
	double AMOUNT_AFTER_INTEREST, PRINCIPAL_AMOUNT_DOUBLE, INTEREST_RATE_AS_A_DECIMAL_DOUBLE, NUMBER_OF_TIMES_INTEREST_COMPOUNDED_IN_ONE_YEAR_DOUBLE, TIME_IN_YEARS_DOUBLE, COMPARISON_AMOUNT_DOUBLE;
	interestCalculator() {
		infoLabel.setBounds(125,0,300,50);
		infoLabel.setFont(new Font(null,Font.PLAIN,16));
		principalLabel.setBounds(25,75,400,25);
		principalLabel.setFont(new Font(null,Font.PLAIN,16));
		interestRateLabel.setBounds(25,100,400,25);
		interestRateLabel.setFont(new Font(null,Font.PLAIN,16));
		numberOfCompoundLabel.setBounds(25,125,500,25);
		numberOfCompoundLabel.setFont(new Font(null,Font.PLAIN,16));
		timeInYearsLabel.setBounds(25,150,400,25);
		timeInYearsLabel.setFont(new Font(null,Font.PLAIN,16));
		principalField.setBounds(450,75,200,25);
		interestRateField.setBounds(450,100,200,25);
		numberOfCompoundField.setBounds(450,125,200,25);
		timeInYearsField.setBounds(450,150,200,25);
		CalculateButton.setBounds(450,175,200,25);
		CalculateButton.addActionListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(infoLabel);
		frame.add(principalLabel);
		frame.add(interestRateLabel);
		frame.add(numberOfCompoundLabel);
		frame.add(timeInYearsLabel);
		frame.add(principalField);
		frame.add(interestRateField);
		frame.add(numberOfCompoundField);
		frame.add(timeInYearsField);
		frame.add(CalculateButton);
		frame.setSize(750,750);
		frame.setLayout(null);
		frame.setVisible(false);
		
		/*
		 Compound interest equation
		 A = Total amount of money after interest
		 P = Principal amount the amount of money before interest
		 R = Interest rate as a decimal
		 N = Number of times interest is compounded per one year
		 T = time in years
		 A = P(1 + (R/N) )^(N*T)
		 the code for the compound interest equation works, but breaks when above $10.00 or when compounding interest daily (N = 365)
		 */
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		AccountScreen1 ac1 = new AccountScreen1(null);
		
		if(e.getSource() == ac1.CalculateInterestButton) {
			frame.setVisible(true);
		}
		calculation();
		
	}
	public void calculation() {
		PRINCIPAL_AMOUNT_STRING = principalField.getText(); //getting the text from the text boxes as strings
		PRINCIPAL_AMOUNT_DOUBLE = Double.parseDouble(PRINCIPAL_AMOUNT_STRING); //and then changing those string values to double values
		System.out.println("Principal Before If statement: " + PRINCIPAL_AMOUNT_DOUBLE);
		COMPARISON_AMOUNT_DOUBLE = PRINCIPAL_AMOUNT_DOUBLE * 10.0; //this piece of code is part of the formatting required for printing currency accurately
		System.out.println("Comparison 1 after if statment: " + COMPARISON_AMOUNT_DOUBLE); //test printing
		INTEREST_RATE_AS_A_DECIMAL_STRING = interestRateField.getText();
		INTEREST_RATE_AS_A_DECIMAL_DOUBLE = Double.parseDouble(INTEREST_RATE_AS_A_DECIMAL_STRING);
		NUMBER_OF_TIMES_INTEREST_COMPOUNDED_IN_ONE_YEAR_STRING = numberOfCompoundField.getText();
		NUMBER_OF_TIMES_INTEREST_COMPOUNDED_IN_ONE_YEAR_DOUBLE = Double.parseDouble(NUMBER_OF_TIMES_INTEREST_COMPOUNDED_IN_ONE_YEAR_STRING);
		TIME_IN_YEARS_STRING = timeInYearsField.getText();
		TIME_IN_YEARS_DOUBLE = Double.parseDouble(TIME_IN_YEARS_STRING);
		AMOUNT_AFTER_INTEREST = Math.pow((PRINCIPAL_AMOUNT_DOUBLE * ( 1 + (INTEREST_RATE_AS_A_DECIMAL_DOUBLE / NUMBER_OF_TIMES_INTEREST_COMPOUNDED_IN_ONE_YEAR_DOUBLE))), (NUMBER_OF_TIMES_INTEREST_COMPOUNDED_IN_ONE_YEAR_DOUBLE * TIME_IN_YEARS_DOUBLE)); // the math equation for compound interest in code form
			while(AMOUNT_AFTER_INTEREST > COMPARISON_AMOUNT_DOUBLE) {
				AMOUNT_AFTER_INTEREST = AMOUNT_AFTER_INTEREST / 10.0; //this while loop is the second part of code for formatting the currency correctly
			}
		System.out.println("Amount after interest final format: " + AMOUNT_AFTER_INTEREST); //also a testing print
		JFrame newAmountAfterInterestFrame = new JFrame("Pacific Standard Public Deposit Bank Terminal");
		JLabel newAmountAfterInterestLabel = new JLabel();
		newAmountAfterInterestLabel.setText("Amount After Interest: $" + BigDecimal.valueOf(AMOUNT_AFTER_INTEREST).setScale(2, RoundingMode.HALF_UP));
		newAmountAfterInterestLabel.setBounds(0,0,750,25);
		newAmountAfterInterestLabel.setFont(new Font(null,Font.PLAIN,16));
		newAmountAfterInterestFrame.add(newAmountAfterInterestLabel);
		newAmountAfterInterestFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newAmountAfterInterestFrame.setSize(750,100);
		newAmountAfterInterestFrame.setLayout(null);
		newAmountAfterInterestFrame.setVisible(true);
		System.out.println("$" + BigDecimal.valueOf(AMOUNT_AFTER_INTEREST).setScale(2, RoundingMode.HALF_UP)); // test printing for final amount after interest
	}
}
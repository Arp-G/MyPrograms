package ChallengePrograms;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JLabel lblOutput; //text field for user output
	private JTextField txtGuess; // lebel too high too low
	private int theNumber;
	public void checkGuess() {       //method to check too high or too low
		String guessText = txtGuess.getText();
		String message = "";
		
		//check the guess for high/low
		int guess = Integer.parseInt(guessText);
		
		if(guess > theNumber)
		{
			message  = guess + " was high. Guess again!";
			lblOutput.setText(message);
		}
		else if (guess < theNumber)
		{
			message = guess + " was low, Guess again!";
			lblOutput.setText(message);
		}
		else //guessed correctly
		{
			message = guess + " was right! you win! Let's play again!";
			lblOutput.setText(message);
			newGame();
		}
		
		txtGuess.requestFocus(); //focus the txt
		txtGuess.selectAll(); //highlight(Select all TXT)  txt
	}
	public void newGame() //create a new random number 1....100
	{
		theNumber = (int)(Math.random()*100 +1);
	}
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Adi's  HI-Lo Guessing Game");
		label.setFont(new Font("Tele-Marines", Font.PLAIN, 14));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(46, 30, 324, 14);
		getContentPane().add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(21, 69, 387, 62);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setBounds(291, 11, 86, 20);
		panel.add(txtGuess);
		txtGuess.setColumns(10);
		
		JLabel lblGuessANumber = new JLabel("Guess a Number Between 1 to 100:");
		lblGuessANumber.setBounds(10, 11, 246, 17);
		lblGuessANumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblGuessANumber);
		lblGuessANumber.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton btnGuess = new JButton("Guess");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		btnGuess.setBounds(164, 142, 89, 23);
		getContentPane().add(btnGuess);
		
		 lblOutput = new JLabel("Enter a number and click guess!");
		lblOutput.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(69, 205, 279, 14);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(500, 330));
		theGame.setVisible(true);
		
	}
}

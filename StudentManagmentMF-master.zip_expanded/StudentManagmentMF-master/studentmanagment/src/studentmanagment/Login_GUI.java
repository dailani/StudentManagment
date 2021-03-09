package studentmanagment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;

public class Login_GUI implements ActionListener {
	
	private static JPanel panel;
	private static JFrame frame;
	private static JLabel userLabel; 
	private static JTextField userText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText; 
	private static JButton button;
	private static JLabel succesMsg;
	

	public static void main(String[] args) {


		 panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(null);
		panel.setVisible(true);
		
		 frame = new JFrame();

		frame.setSize( 600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("MyFuture");
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setBackground(new Color(92,180,190));

		

		 userLabel = new JLabel("User:");
		 userLabel.setFont(new Font("Verdana Pro Cond Black", Font.PLAIN, 13));
		userLabel.setBounds(96, 130, 80, 25);
		panel.add(userLabel);
		

		 userText = new JTextField();
		userText.setBounds(188, 130, 165, 25);
		panel.add(userText);
		
		 passwordLabel = new JLabel("Password:");
		 passwordLabel.setFont(new Font("Verdana Pro Cond Black", Font.PLAIN, 13));
		passwordLabel.setBounds(96, 177, 80, 25);
		panel.add(passwordLabel);
		
		 passwordText = new JPasswordField();
		passwordText.setBounds(188, 177, 165, 25);
		panel.add(passwordText);
		
		 button = new JButton("Login");
		button.setBounds(235, 215 , 80 ,25);
		button.addActionListener(new Login_GUI());
		panel.add(button);
		
		
		 succesMsg = new JLabel("");
		succesMsg.setBounds(100, 130, 300, 25);
		panel.add(succesMsg);
		
		
		ImageIcon login = new ImageIcon("C:\\Users\\Dailan´s PC\\git\\StudentManagmentMF\\StudentManagmentMF-master.zip_expanded\\StudentManagmentMF-master\\studentmanagment\\src\\studentmanagment\\login.png");
		JButton loginBtn = new JButton("Login", login );
		loginBtn.setBounds(226, 29, 73, 66);
		loginBtn.setBackground(new Color(241,178,111));
		loginBtn.setBorderPainted(false);
		loginBtn.setForeground(new Color(92,180,190));
		panel.add(loginBtn);
		
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String user = userText.getText();
		String password = passwordText.getText();
		
		
		if(user.equals("admin") && password.equals("admin")) {
			succesMsg.setText("Login successful!");
			String[] args = null;
			Main_GUI.main(args);
			frame.dispose();
		}
		else {
			succesMsg.setText( "User or password is wrong!");
			passwordText.setText("");
		}
	}
}

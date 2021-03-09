package studentmanagment;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class To_Do {
	private static String url = "jdbc:mysql://localhost:3306/my_future?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String username = "root";
	private static String pass = "dailani123";

	private JFrame frame;
	private JTextArea textAreaTitle;
	private JTextArea textAreaBody;
	int count = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					To_Do window = new To_Do();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public To_Do() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Panel: "Print Bills"
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBounds(12, 13, 458, 95);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		panel.setBorder(blackline);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblPrintBills = new JLabel("TO-DO List");
		lblPrintBills.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrintBills.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblPrintBills.setBounds(12, 13, 418, 67);
		panel.add(lblPrintBills);

		textAreaBody = new JTextArea();
		textAreaBody.setFont(new Font("Monospaced", Font.BOLD, 11));
		textAreaBody.setBounds(126, 178, 259, 412);
		textAreaBody.setBorder(blackline);
		textAreaBody.setLayout(new BorderLayout());
		frame.getContentPane().add(textAreaBody);

		textAreaTitle = new JTextArea();
		textAreaTitle.setBounds(126, 149, 257, 22);
		frame.getContentPane().add(textAreaTitle);
		textAreaTitle.setColumns(10);
		textAreaTitle.setBorder(blackline);

		JButton btnNewButton = new JButton("Add View");
		
		
		
		btnNewButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				String title = textAreaTitle.getText();
				String body = textAreaBody.getText();
				
				try {
					Connection conn = DriverManager.getConnection(url, username, pass);
					PreparedStatement ps = conn.prepareStatement("insert into "
							+ "notes(tasktitle , taskbody  ) " + "values(?,?)");
					ps.setString(1, title);
					ps.setString(2, body);
					
					int status = ps.executeUpdate();
					if(status > 0) JOptionPane.showMessageDialog(null, "Note added succesfuly");
					else JOptionPane.showMessageDialog(null, "Failed");
					textAreaTitle.setText("");
					textAreaBody.setText("");
					
				}
				catch (Exception exc) {
					JOptionPane.showMessageDialog(null, exc.getMessage());
				}
				
				
				
//				int innerCount = count;
//				innerCount += 1;
//				count = innerCount;
//				String viewTextStr = new String(
//						"\t\t TO-DO \n\n " + Integer.toString(innerCount) + "\t" + textAreaTitle.getText() + "\n\n");
//
//				textAreaBody.append(viewTextStr);
			}
		});

		btnNewButton.setBounds(12, 300, 97, 25);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaBody.setText("");
				textAreaTitle.setText("");

			}
		});
		btnNewButton_1.setBounds(12, 360, 97, 25);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnExit = new JButton("Exit");

		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Print Systems",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(12, 420, 97, 25);
		frame.getContentPane().add(btnExit);

		JLabel lblFirstName = new JLabel("Important Task:");
		lblFirstName.setBounds(15, 151, 106, 22);
		frame.getContentPane().add(lblFirstName);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblOtherTask = new JLabel("View:");
		lblOtherTask.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOtherTask.setBounds(79, 188, 33, 22);
		frame.getContentPane().add(lblOtherTask);

	}
}

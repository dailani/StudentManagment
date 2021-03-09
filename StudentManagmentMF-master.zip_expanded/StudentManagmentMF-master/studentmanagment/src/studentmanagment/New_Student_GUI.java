package studentmanagment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class New_Student_GUI {
	private JFrame frame;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private int status;
	private JTextField textField_7;
	private JTextField textField_5_Date;
	private JTextField textField_8_Date;
	private JTextField textField_9_Date;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					New_Student_GUI window = new New_Student_GUI();
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
	public New_Student_GUI() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 381, 609);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);;
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(167, 243, 206));
		panel.setBounds(12, 13, 339, 67);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblAddStudent = new JLabel("Add Student");
		lblAddStudent.setBounds(109, 13, 116, 49);
		panel.add(lblAddStudent);
		lblAddStudent.setFont(new Font("Arial Nova Cond Light", Font.BOLD | Font.ITALIC, 23));
		lblAddStudent.setBackground(new Color(255, 204, 0));

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblFirstName.setBounds(12, 93, 73, 16);
		frame.getContentPane().add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblLastName.setBounds(12, 160, 73, 16);
		frame.getContentPane().add(lblLastName);

		JLabel lblPhoneNr = new JLabel("Phone Nr :");
		lblPhoneNr.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblPhoneNr.setBounds(12, 220, 73, 16);
		frame.getContentPane().add(lblPhoneNr);

		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblCourse.setBounds(12, 311, 73, 16);
		frame.getContentPane().add(lblCourse);

		JLabel lblNewLabel = new JLabel("Fee");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(12, 340, 73, 16);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblMonth = new JLabel("Date:");
		lblMonth.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblMonth.setBounds(12, 380, 73, 16);
		frame.getContentPane().add(lblMonth);

		JLabel lblDue = new JLabel("Due:");
		lblDue.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblDue.setBounds(12, 420, 73, 16);
		frame.getContentPane().add(lblDue);
		
		textField = new JTextField();
		textField.setBounds(121, 89, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(121, 156, 116, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(121, 216, 184, 22);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(121, 307, 116, 22);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(121, 336, 116, 22);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(121, 416, 116, 22);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);

		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Arial", Font.BOLD, 15));
		btnAdd.setBounds(97, 463, 97, 25);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstname = textField.getText();
				String lastname = textField_1.getText();
				String phoneno = textField_2.getText();
				String email =  textField_7.getText();
				String course = textField_3.getText();
				int fee = Integer.parseInt(textField_4.getText());
				String date = textField_5_Date.getText() + "." + textField_8_Date.getText() + "." + textField_9_Date.getText() ;
				int due = Integer.parseInt(textField_6.getText());
				
				StudentMF s = new StudentMF(firstname, lastname, phoneno,email, course, fee, date, due);
				try {
					status = StudentDataOper.saveStudent(s);
					if (status > 0) {
						JOptionPane.showMessageDialog(frame, "Student added successfully!");
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						textField_5_Date.setText("");
						textField_8_Date.setText("");
						textField_9_Date.setText("");
						textField_6.setText("");
						textField_7.setText("");

					} else {
						JOptionPane.showInputDialog(frame, "Sorry, Unable to add student!");
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});



		frame.getContentPane().add(btnAdd);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblEmail.setBounds(12, 265, 56, 16);
		frame.getContentPane().add(lblEmail);
		
		textField_7 = new JTextField();
		textField_7.setBounds(121, 261, 184, 22);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_5_Date = new JTextField();
		textField_5_Date.setBounds(121, 376, 15, 22);
		frame.getContentPane().add(textField_5_Date);
		textField_5_Date.setColumns(10);
		
		JLabel label = new JLabel(".");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(148, 380, 15, 16);
		frame.getContentPane().add(label);
		
		textField_8_Date = new JTextField();
		textField_8_Date.setBounds(158, 376, 15, 22);
		frame.getContentPane().add(textField_8_Date);
		textField_8_Date.setColumns(10);
		
		JLabel label_1 = new JLabel(".");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(181, 379, 15, 16);
		frame.getContentPane().add(label_1);
		
		textField_9_Date = new JTextField();
		textField_9_Date.setBounds(197, 376, 29, 22);
		frame.getContentPane().add(textField_9_Date);
		textField_9_Date.setColumns(10);
		
		

	}
}

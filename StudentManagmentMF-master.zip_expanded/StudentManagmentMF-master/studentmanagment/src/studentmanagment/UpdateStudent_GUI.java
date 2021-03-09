package studentmanagment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class UpdateStudent_GUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStudent_GUI window = new UpdateStudent_GUI();
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
	public UpdateStudent_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.ITALIC, 13));
		frame.setBounds(100, 100, 326, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblRollNo = new JLabel("Roll No.");
		lblRollNo.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lblRollNo.setBounds(12, 13, 95, 28);
		frame.getContentPane().add(lblRollNo);

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblFirstName.setBounds(12, 84, 95, 16);
		frame.getContentPane().add(lblFirstName);

		JLabel lblLastname = new JLabel("LastName:");
		lblLastname.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblLastname.setBounds(12, 113, 95, 16);
		frame.getContentPane().add(lblLastname);

		JLabel lblPhoneno = new JLabel("PhoneNo.");
		lblPhoneno.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblPhoneno.setBounds(12, 142, 95, 16);
		frame.getContentPane().add(lblPhoneno);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblEmail.setBounds(12, 171, 95, 16);
		frame.getContentPane().add(lblEmail);

		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblCourse.setBounds(12, 200, 95, 16);
		frame.getContentPane().add(lblCourse);

		JLabel lblFee = new JLabel("Fee:");
		lblFee.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblFee.setBounds(12, 229, 95, 16);
		frame.getContentPane().add(lblFee);

		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblDate.setBounds(12, 258, 95, 16);
		frame.getContentPane().add(lblDate);

		JLabel lblDue = new JLabel("Due:");
		lblDue.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblDue.setBounds(12, 287, 95, 16);
		frame.getContentPane().add(lblDue);

		textField = new JTextField();
		textField.setBounds(119, 10, 30, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(119, 81, 155, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(119, 113, 155, 22);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(119, 139, 155, 22);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(119, 168, 155, 22);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(119, 197, 155, 22);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(119, 226, 155, 22);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(119, 255, 155, 22);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setBounds(119, 284, 155, 22);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		

		
		

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rollno = Integer.parseInt(textField.getText());
				String firstname = textField_1.getText();
				String lastname = textField_2.getText();
				String phoneno = textField_3.getText();
				String email = textField_4.getText();
				String course = textField_5.getText();
				int fee = Integer.parseInt(textField_6.getText());
				String date = textField_7.getText();
				int due = Integer.parseInt(textField_8.getText());

				StudentMF s = new StudentMF(rollno ,firstname, lastname, phoneno, email, course, fee, date, due);
				int status = StudentDataOper.update(s);

				if (status > 0) {
					JOptionPane.showMessageDialog(frame, "Student updated successfully!");
					Main_GUI.main(new String[] {});
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(frame, "Sorry, Unable to add student!");
				}

			}
		});
		btnUpdate.setBounds(68, 388, 97, 25);
		frame.getContentPane().add(btnUpdate);

		JButton btnBack = new JButton("back");
		btnBack.setBounds(177, 388, 97, 25);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_GUI.main(new String[] {});
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnBack);

		
		JButton btnLoadRecord = new JButton("Load Record");
		btnLoadRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String srollno=textField.getText();
				if(srollno==null||srollno.trim().equals("")){
					JOptionPane.showMessageDialog(frame,"Please enter rollno first!");
				}else{
				int rollno=Integer.parseInt(srollno);
				StudentMF s=StudentDataOper.getStudentByRollno(rollno);
				textField_1.setText(s.getFirstname());
				textField_2.setText(s.getLastname());
				textField_3.setText(s.getPhoneno());
				textField_4.setText(s.getEmail());
				textField_5.setText(s.getCourse());
				textField_6.setText(String.valueOf(s.getFee()));
				textField_7.setText(s.getDate());
				textField_8.setText(String.valueOf(s.getDue()));
				}
			}
		});
		btnLoadRecord.setBounds(161, 9, 109, 32);
		frame.getContentPane().add(btnLoadRecord);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 42, 284, -26);
		frame.getContentPane().add(separator);

		
	}
}

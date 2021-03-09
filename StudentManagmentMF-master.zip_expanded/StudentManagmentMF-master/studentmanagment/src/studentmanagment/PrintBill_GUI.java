package studentmanagment;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.Border;

import javafx.scene.layout.Pane;

import java.awt.Font;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class PrintBill_GUI {

	private JFrame frame;
	private JLabel lblLastName;
	private JLabel lblDate;
	private JLabel lblPagesa;
	private JLabel lblCourse;
	private JPanel panel_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextArea textAreaView;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrintBill_GUI window = new PrintBill_GUI();
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
	public PrintBill_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1080, 748);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Panel: "Print Bills"
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBounds(65, 13, 941, 95);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		panel.setBorder(blackline);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPrintBills = new JLabel("Print Bills");
		lblPrintBills.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblPrintBills.setBounds(391, 13, 157, 67);
		panel.add(lblPrintBills);
		
		panel_1 = new JPanel();
		panel_1.setBounds(12, 175, 116, 382);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblFirstName);
		
		lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblLastName);
		
		lblDate = new JLabel("Month:");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblDate);
		
		lblPagesa = new JLabel("Pagesa:");
		lblPagesa.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblPagesa);
		
		lblCourse = new JLabel("Course:");
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblCourse);
		
		textAreaView = new JTextArea();
		textAreaView.setFont(new Font("Monospaced", Font.BOLD, 21));
		textAreaView.setBounds(492, 121, 558, 523);
		textAreaView.setBorder(blackline);
		textAreaView.setLayout(new BorderLayout());
		frame.getContentPane().add(textAreaView);
		
		textField = new JTextField();
		textField.setBounds(140, 205, 129, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setBorder(blackline);
		
		textField_1 = new JTextField();
		textField_1.setBounds(140, 282, 129, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setBorder(blackline);
		
		textField_5 = new JTextField();
		textField_5.setBounds(140, 433, 129, 22);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		textField_5.setBorder(blackline);
		
		textField_6 = new JTextField();
		textField_6.setBounds(140, 509, 129, 22);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		textField_6.setBorder(blackline);
		
		
		
		
		
		Font font = new Font("LucidaSans", Font.PLAIN, 14);
		
		JButton btnNewButton = new JButton("Add View");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"); 
				LocalDateTime date = LocalDateTime.now();  
				
				String viewTextStr = new String("\t\t Print Bill \n\n " +
						dtf.format(date) +" \t\t\t" + 
						"\n======================================================\n"+
						"First Name: \t\t\t" + textField.getText()+ "\n\n" +
						"Last Name:  \t\t\t" + textField_1.getText()+"\n\n" +
						"Month:	\t\t\t" + textField_2.getText()+"\n\n" +
						"Pages: 	 \t\t\t" + textField_5.getText()+"\n\n" +
						"Course:   \t\t\t" + textField_6.getText()+"\n\n" +
						"\n======================================================\n"
						);
				
				
				textAreaView.append(viewTextStr);
				
				
			}
		});
		btnNewButton.setBounds(12, 615, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textAreaView.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPrint.setBounds(378, 121, 97, 25);
		frame.getContentPane().add(btnPrint);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaView.setText("");
				textField.setText("");
				textField_1.setText("");
				textField_5.setText("");
				textField_2.setText("");
				textField_6.setText("");
			}
		});
		btnNewButton_1.setBounds(146, 615, 97, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnExit = new JButton("Exit");
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit" , "Print Systems" , JOptionPane.YES_NO_OPTION ) == JOptionPane.YES_NO_OPTION){
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(277, 615, 97, 25);
		frame.getContentPane().add(btnExit);
		
		textField_2 = new JTextField();
		textField_2.setBounds(140, 358, 129, 22);
		textField_2.setBorder(blackline);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		
		
		
		
		
		
	}
}

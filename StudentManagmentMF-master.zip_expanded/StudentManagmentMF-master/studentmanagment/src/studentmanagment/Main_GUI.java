package studentmanagment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import java.awt.GridBagConstraints;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;

public class Main_GUI {

	private JFrame frame;
	static JList<String> list;
	static String oper[] = { "English", "French", "German" };
	static String todo[];
	static JTextField textFieldSearch;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_GUI window = new Main_GUI();
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
	public Main_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(178, 218, 218));
		frame.setBounds(100, 100, 801, 504);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("myfuture");
		frame.setResizable(false);

		JLabel lblMyfuture = new JLabel("Welcome to My Future");
		lblMyfuture.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyfuture.setFont(new Font("Rockwell Nova Cond", Font.ITALIC, 45));
		lblMyfuture.setBounds(42, 13, 674, 100);
		frame.getContentPane().add(lblMyfuture);

		Border emptyBorder = BorderFactory.createEmptyBorder();
		ImageIcon addImage = new ImageIcon(
				"C:\\Users\\Dailan큦 PC\\git\\StudentManagmentMF\\StudentManagmentMF-master.zip_expanded\\StudentManagmentMF-master\\studentmanagment\\src\\studentmanagment\\studentAdd.png");
		JButton btnAddStudent = new JButton("", addImage);
		btnAddStudent.setBorder(emptyBorder);
		btnAddStudent.setForeground(Color.BLACK);
		btnAddStudent.setBackground(new Color(224, 153, 94));
		frame.validate();
		btnAddStudent.setBounds(68, 157, 115, 115);
		frame.getContentPane().add(btnAddStudent);
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] args = null;
				New_Student_GUI.main(args);
			}
		});

		list = new JList(oper);
		list.setFont(new Font("Verdana Pro Cond", Font.ITALIC, 15));
		frame.getContentPane().add(list);
		list.setBounds(328, 348, 97, 71);

		ImageIcon okIcon = new ImageIcon(
				"C:\\Users\\Dailan큦 PC\\git\\StudentManagmentMF\\StudentManagmentMF-master.zip_expanded\\StudentManagmentMF-master\\studentmanagment\\src\\studentmanagment\\ok.png");
		JButton btnOkButton = new JButton("OK", okIcon);
		btnOkButton.setHorizontalAlignment(SwingConstants.LEADING);
		btnOkButton.setBackground(new Color(178, 218, 218));
		btnOkButton.setBorderPainted(false);
		btnOkButton.setBounds(456, 357, 44, 32);
		frame.getContentPane().add(btnOkButton);
		btnOkButton.setVisible(false);
		btnOkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String[] args = null;
				ViewCourse_GUI.main(args);

			}
		});

		ImageIcon faturaimg = new ImageIcon(
				"C:\\Users\\Dailan큦 PC\\git\\StudentManagmentMF\\StudentManagmentMF-master.zip_expanded\\StudentManagmentMF-master\\studentmanagment\\src\\studentmanagment\\view.png");
		JButton btnFaturaBill = new JButton("", new ImageIcon(
				"C:\\Users\\Dailan\u00B4s PC\\git\\StudentManagmentMF\\StudentManagmentMF-master.zip_expanded\\StudentManagmentMF-master\\studentmanagment\\src\\studentmanagment\\view.png"));
		btnFaturaBill.setHorizontalAlignment(SwingConstants.LEADING);
		btnFaturaBill.setBounds(572, 157, 160, 109);
		btnFaturaBill.setBackground(new Color(178, 218, 218));
		btnFaturaBill.setBorderPainted(false);
		frame.getContentPane().add(btnFaturaBill);

		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setFont(new Font("Rockwell Nova Cond", Font.BOLD, 13));
		lblCourse.setBounds(271, 365, 56, 16);
		frame.getContentPane().add(lblCourse);
		lblCourse.setVisible(false);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Rockwell Nova Cond", Font.BOLD, 13));
		lblName.setBounds(271, 310, 56, 16);
		frame.getContentPane().add(lblName);
		lblName.setVisible(false);

		JButton btnOk2Button = new JButton("OK", okIcon);
		btnOk2Button.setHorizontalAlignment(SwingConstants.LEADING);
		btnOk2Button.setBackground(new Color(178, 218, 218));
		btnOk2Button.setBorderPainted(false);
		btnOk2Button.setBounds(456, 302, 44, 32);
		frame.getContentPane().add(btnOk2Button);
		btnOk2Button.setVisible(false);

		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(328, 307, 116, 22);
		frame.getContentPane().add(textFieldSearch);
		textFieldSearch.setColumns(10);
		textFieldSearch.setVisible(false);

		ImageIcon search = new ImageIcon(
				"C:\\Users\\Dailan큦 PC\\git\\StudentManagmentMF\\StudentManagmentMF-master.zip_expanded\\StudentManagmentMF-master\\studentmanagment\\src\\studentmanagment\\search.png");
		JButton btnOperations = new JButton("Search", search);
		btnOperations.setBounds(300, 157, 173, 132);
		btnOperations.setBackground(new Color(178, 218, 218));
		btnOperations.setForeground(new Color(178, 218, 218));
		btnOperations.setBorderPainted(false);
		frame.getContentPane().add(btnOperations);

		JLabel lblAddStudent = new JLabel("Add Student");
		lblAddStudent.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 12));
		lblAddStudent.setBounds(72, 116, 98, 32);
		frame.getContentPane().add(lblAddStudent);

		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 13));
		lblSearch.setBounds(353, 116, 72, 32);
		frame.getContentPane().add(lblSearch);

		JLabel lblDatabase = new JLabel("FATURA");
		lblDatabase.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 12));
		lblDatabase.setBounds(617, 116, 63, 32);
		frame.getContentPane().add(lblDatabase);

		JButton btnViewEmails = new JButton("View Emails");
		btnViewEmails.setBounds(315, 432, 110, 22);

		frame.getContentPane().add(btnViewEmails);

		textField = new JTextField();
		textField.setBounds(110, 432, 23, 22);
		textField.setBorder(new LineBorder(Color.BLACK));

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Verdana Pro Cond", Font.BOLD, 13));
		textArea.setEditable(false);
		textArea.setBounds(557, 312, 205, 144);
		frame.getContentPane().add(textArea);

		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(570, 432, 110, -120);

		frame.getContentPane().add(scrollPane);

		JButton btnEditStudent = new JButton("Edit Student");
		btnEditStudent.setBounds(63, 300, 121, 25);

		frame.getContentPane().add(btnEditStudent);

		JButton btnViewStudents_1 = new JButton("View Students");
		btnViewStudents_1.setBounds(61, 350, 123, 25);

		frame.getContentPane().add(btnViewStudents_1);

		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.setBounds(61, 400, 123, 25);

		frame.getContentPane().add(btnDeleteStudent);

		JButton btnTodo = new JButton("TO-DO");
		btnTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> result = StudentDataOper.viewTitleTask();
				Iterator<String> it1 = result.iterator();
				while (it1.hasNext()) {
					textArea.append(it1.next() + "\n\n");
				}
			}
		});
		btnTodo.setFont(new Font("Verdana Pro Cond Black", Font.PLAIN, 14));
		btnTodo.setBounds(617, 267, 86, 22);

		frame.getContentPane().add(btnTodo);

		table = new JTable();
		table.setBounds(572, 432, 173, -120);
		frame.getContentPane().add(table);

		JButton btnRemove = new JButton("Delete");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n = JOptionPane.showInputDialog("Insert the number of the task which you want to remove!");
				int status = StudentDataOper.deleteTask(Integer.parseInt(n));
				if (status > 0) {
					JOptionPane.showMessageDialog(frame, "Task Removed succesfuly!");

				} else {
					JOptionPane.showMessageDialog(frame, "Sorry, Unable to remove task!");
				}
				
				textArea.setText("");
			}
		});
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRemove.setBounds(627, 296, 69, 16);
		frame.getContentPane().add(btnRemove);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title =JOptionPane.showInputDialog("What is todays task?");
				
				
				try {
					Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/my_future?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "dailani123");
					PreparedStatement ps = conn.prepareStatement("insert into "
							+ "notes(tasktitle ) " + "values(?)");
					ps.setString(1, title);
					
					
					int status = ps.executeUpdate();
					if(status > 0) JOptionPane.showMessageDialog(null, "Note added succesfuly");
					else JOptionPane.showMessageDialog(null, "Failed");
					
					
				}
				catch (Exception exc) {
					JOptionPane.showMessageDialog(null, exc.getMessage());
				}
				
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAdd.setBounds(692, 296, 69, 16);
		frame.getContentPane().add(btnAdd);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnClear.setBounds(557, 296, 73, 16);
		frame.getContentPane().add(btnClear);

		btnDeleteStudent.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (textField.getText() == null || textField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(frame, "Please enter rollno first!");
				} else {
					int status = StudentDataOper.delete(Integer.parseInt(textField.getText()));
					if (status > 0) {
						JOptionPane.showMessageDialog(frame, "Student updated successfully!");

					} else {
						JOptionPane.showMessageDialog(frame, "Sorry, Unable to add student!");
					}

				}
			}
		});
		btnViewStudents_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] args = null;
				ViewStudent_GUI.main(args);
			}
		});

		btnEditStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] args = null;
				UpdateStudent_GUI.main(args);
			}
		});

		list.setVisible(true);
		btnOkButton.setVisible(true);
		btnOk2Button.setVisible(true);
		lblName.setVisible(true);
		textFieldSearch.setVisible(true);
		lblCourse.setVisible(true);

		// MiniGame: Every time u press the button the font changes
		btnOperations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
				int R = (int) Math.floor(Math.random() * 100);
				int G = (int) Math.floor(Math.random() * 100);
				int B = (int) Math.floor(Math.random() * 100);

				for (int i = (int) Math.floor(Math.random() * 10); i < fonts.length; i++) {
					lblMyfuture.setFont(new Font(fonts[i], Font.ITALIC, 45));
					lblMyfuture.setForeground(new Color(R, G, B));
					break;
				}

			}
		});

		btnFaturaBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] args = null;
				PrintBill_GUI.main(args);
			}
		});

		btnOk2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String[] args = null;
				SearchName.main(args);

			}
		});

		btnViewEmails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] args = null;
				ViewEmails_GUI.main(args);
			}
		});

		JFrame.setDefaultLookAndFeelDecorated(true);
		String[] args = null;
		Date.main(args);

	}
}

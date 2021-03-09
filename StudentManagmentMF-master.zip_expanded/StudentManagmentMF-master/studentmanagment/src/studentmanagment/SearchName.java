package studentmanagment;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class SearchName {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchName window = new SearchName();
					window.frame.setVisible(true);
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchName() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 921, 501);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		List<StudentMF> viewStudentList = StudentDataOper.searchNameOper(Main_GUI.textFieldSearch.getText());
		int size = viewStudentList.size();
		String data[][] = new String[size][9];
		int row = 0;
		for (StudentMF s : viewStudentList) {
			data[row][0] = String.valueOf(s.getRollno());
			data[row][1] = s.getFirstname();
			data[row][2] = s.getLastname();
			data[row][3] = s.getPhoneno();
			data[row][4] = s.getEmail();
			data[row][5] = s.getCourse();
			data[row][6] = String.valueOf(s.getFee());
			data[row][7] = s.getDate();
			data[row][8] = String.valueOf(s.getDue());
			row++;
		}
		String columnNames[] = {"No.", "FirstName", "LastName", "PhoneNo", "Email", "Course", "Fee", "Date", "Due" };
		JTable jt = new JTable(data, columnNames) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int data, int columns) {
				return false;
			}

			public Component prepareRenderer(TableCellRenderer r, int data, int columns) {
				Component c = super.prepareRenderer(r, data, columns);

				if (data % 2 == 0)
					c.setBackground(Color.WHITE);
				else
					c.setBackground(new Color(205, 226, 244));

				if (isCellSelected(data, columns)) {
					c.setBackground(new Color(255, 179, 92));
				}
				return c;
			}

		};
		jt.setIntercellSpacing(new Dimension(0, 1));
		jt.setRowHeight(25);
		jt.setShowVerticalLines(false);
		jt.setShowGrid(false);
		jt.setRowMargin(0);
		jt.getTableHeader().setReorderingAllowed(false);
		jt.getTableHeader().setFont(new Font("Rockwell Nova Cond", Font.BOLD, 13));
		jt.getTableHeader().setOpaque(false);
		jt.getTableHeader().setBackground(new Color(124, 156, 186));
		jt.getTableHeader().setForeground(new Color(255, 255, 255));
		jt.getColumnModel().getColumn(0).setPreferredWidth(5);
		jt.getColumnModel().getColumn(6).setPreferredWidth(6);
		jt.getColumnModel().getColumn(7).setPreferredWidth(6);
		jt.getColumnModel().getColumn(8).setPreferredWidth(6);
		
		

		JScrollPane sp = new JScrollPane(jt);
		frame.add(sp);

	}

}

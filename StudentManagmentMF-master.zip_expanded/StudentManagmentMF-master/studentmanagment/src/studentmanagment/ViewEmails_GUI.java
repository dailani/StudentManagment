package studentmanagment;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

public class ViewEmails_GUI {

	private JFrame frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEmails_GUI window = new ViewEmails_GUI();
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
	public ViewEmails_GUI() {
		initialize();
	
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 921, 501);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		List<StudentMF> viewEmailsList = StudentDataOper.viewEmails();
		int size = viewEmailsList.size();
		String data[][]=new String[size][4];
		int row=0;
		for(StudentMF s : viewEmailsList ) {
			data[row][0] = String.valueOf(s.getRollno());
			data[row][1] = s.getFirstname();
			data[row][2]= s.getLastname();
			data[row][3] = s.getEmail();
			
			row++;		
		}
		String columnNames[] = {"No.", "FirstName", "LastName",  "Email" };
		JTable jt=new JTable(data,columnNames) {
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
		jt.getColumnModel().getColumn(0).setPreferredWidth(0);
		JScrollPane sp=new JScrollPane(jt);
		frame.add(sp);
		
		
	}

}

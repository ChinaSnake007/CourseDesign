package CourseDesign;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/*
 * �鿴���гɼ���
 * */
public class CheckAll {
	public static void Window() {
		final ArrayList<GradeBean> results = JdbcHelper.CheckAll();
		if(results.size()>0) {
			EventQueue.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						//GradeQueryResultFrame frame = new GradeQueryResultFrame();
						
						JFrame jfrm = new JFrame("�ɼ���");
						
						Point A =WindowUtil.getLocation();
						

						jfrm.setLocation(A.x+510,A.y);

						jfrm.setSize(WindowUtil.getSize());
						
						JPanel contentPane = new JPanel();
						contentPane.setLayout(new BorderLayout(0,0));
						jfrm.add(contentPane);
						//setContentPane(contentPane);
						
						JScrollPane scrollPane = new JScrollPane();
						contentPane.add(scrollPane);
						
						JTable studentGradeTable = new JTable();
						
						studentGradeTable.setFont(new Font("΢���ź�",Font.PLAIN,15));
						studentGradeTable.setRowHeight(25);
						JTableHeader header = studentGradeTable.getTableHeader();
						header.setFont(new Font("΢���ź�",Font.PLAIN,15));
						header.setPreferredSize(new Dimension(header.getWidth(),50));
						
						
						
						DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
						renderer.setHorizontalAlignment(SwingConstants.CENTER);
						
						DefaultTableModel model = (DefaultTableModel) studentGradeTable.getModel();
						model.setRowCount( 0); 		//��ձ���е�����
						model.setColumnIdentifiers(new Object[] {"���","ѧ������","ѧ���༶","���Կ�Ŀ","���Գɼ�","����ʱ��","��ע"});
						for(GradeBean grade:results) {
							model.addRow(new Object[] {grade.getId(),grade.getStudentName(),grade.getStudentClass(),grade.getTestSubject(),grade.getScore(),grade.getTestTime(),grade.getRemark()}); 		
							System.out.println(grade.getId());
						}
																									
						
						studentGradeTable.setModel(model);
						studentGradeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						
						scrollPane.setViewportView(studentGradeTable);
						scrollPane.setLocation(WindowUtil.getLocation());
						scrollPane.setSize(WindowUtil.getSize());
						jfrm.setVisible(true);
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			});
			return ;
		}else {
			JOptionPane JO = new JOptionPane();
			JO.showMessageDialog(null, "��δ¼��ɼ�");
		}
	}
}

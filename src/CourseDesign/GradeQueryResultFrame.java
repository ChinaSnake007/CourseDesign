package CourseDesign;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class GradeQueryResultFrame {
	public void set(ArrayList<GradeBean> results,JFrame jfrm) {
		
		
		
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
		model.setColumnIdentifiers(new Object[] {"ѧ������","ѧ���༶","���Կ�Ŀ","���Գɼ�","����ʱ��","��ע"});
		for(GradeBean grade:results) {
			model.addRow(new Object[] {grade.getStudentName(),grade.getStudentClass(),grade.getTestSubject(),grade.getScore(),grade.getTestTime(),grade.getRemark()}); 		
		}
		studentGradeTable.setModel(model);
		studentGradeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(studentGradeTable);
		scrollPane.setLocation(WindowUtil.getLocation());
		scrollPane.setSize(WindowUtil.getSize());
	}
}

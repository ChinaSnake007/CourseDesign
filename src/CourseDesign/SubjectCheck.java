package CourseDesign;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class SubjectCheck {
	public static void Window(GradeBean grade) {
		final ArrayList<GradeBean> results = JdbcHelper.query(grade);
		if(results.size()>0) {
			EventQueue.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						//GradeQueryResultFrame frame = new GradeQueryResultFrame();
						System.out.println("查询结果");
						JFrame frame = new JFrame("查询结果");
						frame.setVisible(true);
						

						Dimension a = WindowUtil.getSize();
						Point A = WindowUtil.getLocation();
						int move = GetMove.move;
						frame.setBounds(A.x+510+35*move,A.y+20*move,a.width,a.height);
						GetMove.add();
						
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.getContentPane().setLayout(null);
						
						JScrollPane scrollPane = new JScrollPane();
						frame.getContentPane().add(scrollPane);
						
						
						JTable studentGradeTable = new JTable();
						
						studentGradeTable.setFont(new Font("微软雅黑",Font.PLAIN,15));
						studentGradeTable.setRowHeight(25);
						
						
						JTableHeader header = studentGradeTable.getTableHeader();
						header.setFont(new Font("微软雅黑",Font.PLAIN,15));
						header.setPreferredSize(new Dimension(header.getWidth(),50));
																	
						DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
						renderer.setHorizontalAlignment(SwingConstants.CENTER);
						
						DefaultTableModel model = (DefaultTableModel) studentGradeTable.getModel();
						model.setRowCount( 0); 		//清空表格中的数据
						model.setColumnIdentifiers(new Object[] {"学生姓名","学生班级","考试科目","考试成绩","考试时间","备注"});
						for(GradeBean grade:results) {
							model.addRow(new Object[] {grade.getStudentName(),grade.getStudentClass(),grade.getTestSubject(),grade.getScore(),grade.getTestTime(),grade.getRemark()}); 		
						}
						studentGradeTable.setModel(model);
						studentGradeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						
						scrollPane.setViewportView(studentGradeTable);
						Dimension size = WindowUtil.getSize();
						scrollPane.setLocation(0, 0);
						
						scrollPane.setSize(size.width,size.height-100);
						
						
						
						
						JButton returnButton = new JButton("返回");				 	 
						returnButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
						
						frame.add(returnButton);
						returnButton.setBounds(300,220,80,35);
						
						returnButton.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								frame.setVisible(false);
								GetMove.setzeros();
							}
						});
							
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			});
			return ;
		}
	}
}

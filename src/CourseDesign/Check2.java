package CourseDesign;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Check2 {
    
	public static void main(String []args) {
		String sql="select * from StudentScoreManage";
		Connection conn = JdbcHelper.getConnection();
		try {
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(sql.toString());
			while(rs.next()) {
				System.out.print(rs.getString("ѧ������")+" ");
				System.out.print(rs.getString("ѧ���༶")+"\t");
				System.out.print(rs.getString("���Կ�Ŀ")+"\t");
				System.out.print(rs.getString("���Գɼ�")+"\t");
				System.out.print(rs.getString("����ʱ��")+"\t");
				System.out.println(rs.getString("��ע"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
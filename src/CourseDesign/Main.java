package CourseDesign;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JMenuBar;

import CourseDesign.*;

public class Main {
	 /*public JdbcHelper a = new JdbcHelper();
		Connection conn=a.getConnection();
		String sql="select * from Student";static void main(String[] args) {
		JdbcHelper a = new JdbcHelper();
		Connection conn=a.getConnection();
		String sql="select * from Student";
		try{
			Statement Stmt = conn.createStatement();
			ResultSet rs = Stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.print(rs.getString("ѧ��")+"\t");
				System.out.print(rs.getString("����")+"\t");
				System.out.print(rs.getString("רҵ��")+"\t");
				System.out.print(rs.getString("�Ա�")+"\t");
				System.out.print(rs.getString("����ʱ��")+"\t");
				System.out.print(rs.getString("��ѧ��")+"\t");
				System.out.println(rs.getString("��ע"));
				
			}
		}catch(Exception err) {
			System.out.println("ʹ�����ݿ�ʧ��");
			err.printStackTrace(System.out);
		}
		
	}*/
	
	static JMenuBar menuBar = new JMenuBar();			//�����˵���
	
	
	
	
	
	public static void main(String[] args) {
		setLocation(WindowUtil.getLocation());	//��ʾ����λ��
	}
}

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
				System.out.print(rs.getString("学号")+"\t");
				System.out.print(rs.getString("姓名")+"\t");
				System.out.print(rs.getString("专业名")+"\t");
				System.out.print(rs.getString("性别")+"\t");
				System.out.print(rs.getString("出生时间")+"\t");
				System.out.print(rs.getString("总学分")+"\t");
				System.out.println(rs.getString("备注"));
				
			}
		}catch(Exception err) {
			System.out.println("使用数据库失败");
			err.printStackTrace(System.out);
		}
		
	}*/
	
	static JMenuBar menuBar = new JMenuBar();			//创建菜单条
	
	
	
	
	
	public static void main(String[] args) {
		setLocation(WindowUtil.getLocation());	//显示窗口位置
	}
}

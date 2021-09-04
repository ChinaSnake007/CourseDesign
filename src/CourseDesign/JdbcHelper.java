package CourseDesign;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.List;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Thread.State;

import CourseDesign.GradeBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
public class JdbcHelper {
	public static Connection getConnection(){
		
		String RL="jdbc:sqlserver://localhost:1433;DatabaseName=StudentScoreManage";		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	//驱动程序类
			Connection con=DriverManager.getConnection(RL,"sa","123456");	//创建于数据库的连接			
			System.out.println("数据库连接成功");
			return con;
		}
		catch(Exception err) {
			err.printStackTrace(System.out);
		}
		return null;
	}
	
	
	/*save类用来保存成绩单
	 * 
	 * */
	public static int save(GradeBean grade) {
		//sql应该使用SQLserve的语句
		String sql="insert into StudentScoreManage(学生姓名,学生班级,考试科目,考试成绩,考试时间,备注) values(?,?,?,?,?,?)";
		Connection conn=getConnection();
		PreparedStatement ps = null;
		System.out.println("save函数运行成功");
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,grade.getStudentName());
			ps.setString(2, grade.getStudentClass());
			ps.setString(3, grade.getTestSubject());
			ps.setString(4,grade.getScore());
			ps.setString(5, grade.getTestTime());
			ps.setString(6, grade.getRemark());
			return  ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try{
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return -1;
	}
	
	
	/*update() 修改成绩单
	 * 
	 * */
	public static int updata(GradeBean grade) {
		String sql = "update StudentScoreManage set 学生姓名 = ?, 学生班级 = ?, 考试科目 = ?, 考试成绩 = ?, 考试时间 = ?, 备注= ?  where ID = ?;";
		Connection conn = getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,grade.getStudentName());
			ps.setString(2, grade.getStudentClass());
			ps.setString(3, grade.getTestSubject());
			ps.setString(4,grade.getScore());
			ps.setString(5, grade.getTestTime());
			ps.setString(6, grade.getRemark());
			ps.setInt(7, grade.getId());
			
			System.out.println(grade.getId());
			
			return ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try{
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return -1;
	}
	
	
	/*queryAll()方法保存表格中的全部数据
	 * 
	 * 
	 * */
	
	
	/*
	public static List<GradeBean> queryAll(){
		
		String sql="select * from tb_transcript;";
		List<GradeBean>	result = new ArrayList<GradeBean>();
		
		Connection conn = getConnection();
		Statement stat = null;
		ResultSet rs = null;
		try {
			start 
		}
		return null;
	}
	*/
	
	/*
	 * 保存部分成绩单信息
	 * 
	 * */
	public static ArrayList<GradeBean> query(GradeBean grade){
		String studentName = grade.getStudentName();
		String studentClass = grade.getStudentClass();
		String testSubject = grade.getTestSubject();
		String score = grade.getScore();
		String testTime = grade.getTestTime();
		String remark = grade.getRemark();
		
		StringBuilder sql = new StringBuilder("select * from StudentScoreManage where 1=1");
		if(!studentName.isEmpty()) {
			sql.append("and 学生姓名 like '%"+studentName+"%'");
		}
		if(!studentClass.isEmpty()) {
			sql.append("and 学生班级 like '%"+studentClass+"%'");
		}
		if(!testSubject.isEmpty()) {
			sql.append("and 考试科目 like '%"+testSubject+"%'");
		}
		if(!score.isEmpty()) {
			sql.append("and 考试成绩 like '%"+score+"%'");
		}
		if(!testTime.isEmpty()) {
			sql.append("and 考试时间 like '%"+testTime+"%'");
		}
		sql.append(";");
		
		ArrayList<GradeBean> results = new ArrayList<GradeBean>();
		Connection conn = JdbcHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql.toString());
			while(rs.next()) {
				/*System.out.print(rs.getString("学生姓名")+" ");
				System.out.print(rs.getString("学生班级")+"\t");
				System.out.print(rs.getString("考试科目")+"\t");
				System.out.print(rs.getString("考试成绩")+"\t");
				System.out.print(rs.getString("考试时间")+"\t");
				System.out.println(rs.getString("备注"));*/
				GradeBean tempGrade = new GradeBean(rs.getString("学生姓名"),rs.getString("学生班级"),rs.getString("考试科目"),rs.getString("考试成绩"),rs.getString("考试时间"),rs.getString("备注"));
				
				int id = rs.getInt("ID");
				tempGrade.setId(id);
				
				results.add(tempGrade);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {		//释放资源
			if(rs!=null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(stat!=null) {
				try {
					stat.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return results;
	}
	
	public static ArrayList<GradeBean> CheckAll(){
		StringBuilder sql = new StringBuilder("select * from StudentScoreManage");
		ArrayList<GradeBean> results = new ArrayList<GradeBean>();
		Connection conn = JdbcHelper.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql.toString());
			while(rs.next()) {
				GradeBean tempGrade = new GradeBean(rs.getString("学生姓名"),rs.getString("学生班级"),rs.getString("考试科目"),rs.getString("考试成绩"),rs.getString("考试时间"),rs.getString("备注"));
				int id = rs.getInt("ID");
				tempGrade.setId(id);		
				results.add(tempGrade);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {		//释放资源
			if(rs!=null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(stat!=null) {
				try {
					stat.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return results;
	}
	
	public static void delete(JFrame frame,GradeBean grade) {
		String sql = "delete from StudentScoreManage where ID = ?";
		Connection coon = getConnection();
		try {
			PreparedStatement ps = coon.prepareStatement(sql);
			ps.setInt(1, grade.getId());
			ps.executeUpdate();
			JOptionPane.showMessageDialog(frame, "删除成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

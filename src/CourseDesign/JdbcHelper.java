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
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	//����������
			Connection con=DriverManager.getConnection(RL,"sa","123456");	//���������ݿ������			
			System.out.println("���ݿ����ӳɹ�");
			return con;
		}
		catch(Exception err) {
			err.printStackTrace(System.out);
		}
		return null;
	}
	
	
	/*save����������ɼ���
	 * 
	 * */
	public static int save(GradeBean grade) {
		//sqlӦ��ʹ��SQLserve�����
		String sql="insert into StudentScoreManage(ѧ������,ѧ���༶,���Կ�Ŀ,���Գɼ�,����ʱ��,��ע) values(?,?,?,?,?,?)";
		Connection conn=getConnection();
		PreparedStatement ps = null;
		System.out.println("save�������гɹ�");
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
	
	
	/*update() �޸ĳɼ���
	 * 
	 * */
	public static int updata(GradeBean grade) {
		String sql = "update StudentScoreManage set ѧ������ = ?, ѧ���༶ = ?, ���Կ�Ŀ = ?, ���Գɼ� = ?, ����ʱ�� = ?, ��ע= ?  where ID = ?;";
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
	
	
	/*queryAll()�����������е�ȫ������
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
	 * ���沿�ֳɼ�����Ϣ
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
			sql.append("and ѧ������ like '%"+studentName+"%'");
		}
		if(!studentClass.isEmpty()) {
			sql.append("and ѧ���༶ like '%"+studentClass+"%'");
		}
		if(!testSubject.isEmpty()) {
			sql.append("and ���Կ�Ŀ like '%"+testSubject+"%'");
		}
		if(!score.isEmpty()) {
			sql.append("and ���Գɼ� like '%"+score+"%'");
		}
		if(!testTime.isEmpty()) {
			sql.append("and ����ʱ�� like '%"+testTime+"%'");
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
				/*System.out.print(rs.getString("ѧ������")+" ");
				System.out.print(rs.getString("ѧ���༶")+"\t");
				System.out.print(rs.getString("���Կ�Ŀ")+"\t");
				System.out.print(rs.getString("���Գɼ�")+"\t");
				System.out.print(rs.getString("����ʱ��")+"\t");
				System.out.println(rs.getString("��ע"));*/
				GradeBean tempGrade = new GradeBean(rs.getString("ѧ������"),rs.getString("ѧ���༶"),rs.getString("���Կ�Ŀ"),rs.getString("���Գɼ�"),rs.getString("����ʱ��"),rs.getString("��ע"));
				
				int id = rs.getInt("ID");
				tempGrade.setId(id);
				
				results.add(tempGrade);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {		//�ͷ���Դ
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
				GradeBean tempGrade = new GradeBean(rs.getString("ѧ������"),rs.getString("ѧ���༶"),rs.getString("���Կ�Ŀ"),rs.getString("���Գɼ�"),rs.getString("����ʱ��"),rs.getString("��ע"));
				int id = rs.getInt("ID");
				tempGrade.setId(id);		
				results.add(tempGrade);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {		//�ͷ���Դ
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
			JOptionPane.showMessageDialog(frame, "ɾ���ɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

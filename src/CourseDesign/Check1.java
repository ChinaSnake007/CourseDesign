package CourseDesign;

import java.sql.*;
import java.util.ArrayList;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class Check1 {
	
	public static void main(String[] args) {
		ArrayList<GradeBean> a = new ArrayList<GradeBean>();
		for(int i=0;i<3;i++) {
			GradeBean b = new GradeBean("123", "123", "14", "15", "12", "45");
			a.add(b);
		}
		
		System.out.println("���гɹ�");
	}
}
/*JFrame noonframe = new JFrame("�´���");
noonframe.setSize(WindowUtil.getSize());
noonframe.setLocation(WindowUtil.getLocation());
noonframe.setVisible(true);
JPanel contentPane = new JPanel();
contentPane.setBounds(0, 0, 200, 50);
contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
FlowLayout flowLayout = new FlowLayout();
flowLayout.setAlignment(FlowLayout.CENTER);
noonframe.add(contentPane);
*/
/*

JdbcHelper a = new JdbcHelper();
Connection coon = a.getConnection();
String sql = "select * from StudentScoreManage";
try{
	Statement st = coon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	ResultSet rs = st.executeQuery(sql);

	while(rs.next()) {
		//rs.deleteRow();
		System.out.print(rs.getString("ѧ������")+" ");
		System.out.print(rs.getString("ѧ���༶")+"\t");
		System.out.print(rs.getString("���Կ�Ŀ")+"\t");
		System.out.print(rs.getString("���Գɼ�")+"\t");
		System.out.print(rs.getString("����ʱ��")+"\t");
		System.out.println(rs.getString("��ע"));
	}
}catch (Exception e) {
	e.printStackTrace(System.out);
}

*/


/*sql="insert into Student(ѧ��,����,רҵ��,�Ա�,����ʱ��,��ѧ��,��ע) values(?,?,?,?,?,?,?)";
String ID="10005";
String name="����";
String major="�����";
String sex="��";
String date="2001-05-07";
String Xuefen="201";
String text="";
try {
	PreparedStatement pstm = coon.prepareStatement(sql);
	pstm.setString(1,ID);
	pstm.setString(2,name);
	pstm.setString(3,major);
	pstm.setString(4,sex);
	pstm.setString(5,date);
	pstm.setString(6,Xuefen);
	pstm.setString(7,text);
	System.out.println("������ݳɹ�");
	pstm.executeUpdate();
}catch (Exception e) {
	e.printStackTrace();
}*/

		











/*JPanel contentPane = new JPanel();
        //��ȡcontentPane��岼��
        FlowLayout flowLayout_0 = (FlowLayout) contentPane.getLayout();
        flowLayout_0.setAlignment(FlowLayout.LEFT);					//�����
        contentPane.setBounds(0, 0, 484,150);
        contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
        contentFrame.add(contentPane);
        
		 JPanel studentInfoPanel = new JPanel();
		 studentInfoPanel.setBounds(0,0,484,46);
		 studentInfoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));*/
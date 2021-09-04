package CourseDesign;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Check3 {
	public static void main(String[] args) {
		JFrame jfrm = new JFrame("学生管理系统");
        // Give the frame an initial size.
        jfrm.setLocation(WindowUtil.getLocation());
        
        jfrm.setSize(WindowUtil.getSize());
        // Terminate the program when the user closes the application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //设置背景
        ImageIcon background = new ImageIcon("src/学生管理系统.jpg");
        JLabel label = new JLabel(background);
        jfrm.add(label);
        jfrm.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        
        jfrm.setVisible(true);
	}
}

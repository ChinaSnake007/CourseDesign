package CourseDesign;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
 
public class SimpleTest extends JFrame{
	private JButton jb = new JButton("����һ����ť");
	public SimpleTest() {
		Container c = getContentPane();
		setLayout(null);
		setSize(100,100);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		c.add(jb);
		jb.setBounds(10,10,100,30);
		jb.addActionListener(new jbAction());
	}
	class jbAction implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			jb.setText("�����˰�ť");
		}
	}
	public static void main(String args[]) {
		new SimpleTest();
	}
}
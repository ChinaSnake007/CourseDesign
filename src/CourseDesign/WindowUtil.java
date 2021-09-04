package CourseDesign;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JOptionPane;

/**窗体剧中显示
 * 
 */
public class WindowUtil {
	public static Dimension getSize() {
		return new Dimension(500,309);
	}
	public static Point getLocation() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();	//获得Toolkit实例
		Dimension screenSize = toolkit.getScreenSize();	//获得显示器大小
		if((screenSize.width<getSize().width)||(screenSize.height<getSize().height)) {
			JOptionPane.showMessageDialog(null, "显示器大小至少为500✖309","",JOptionPane.WARNING_MESSAGE);
			System.exit(0); 		//终止程序
		}
		int x = (screenSize.width-getSize().width)/2;	//计算左上角横坐标
		int y = (screenSize.height-getSize().height)/2;	//计算左上角纵坐标
		return new Point(x,y);
	}
}
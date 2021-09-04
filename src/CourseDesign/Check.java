package CourseDesign;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;

public class Check {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Check window = new Check();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Check() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 555, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);*/
		
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(69, 84, 231, 126);
		frame.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		
		/*textField = new JTextField();
		textField.setBounds(160, 72, 86, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);*/
	}
}

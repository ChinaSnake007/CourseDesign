package CourseDesign;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class GradeModificationFrame {
	public static void setWindow(GradeBean grade,JFrame contentFrame,JFrame frame) {
		JPanel contentPane = new JPanel();
        //��ȡcontentPane��岼��
        FlowLayout flowLayout_0 = (FlowLayout) contentPane.getLayout();
        flowLayout_0.setAlignment(FlowLayout.LEFT);					//�����
        contentPane.setBounds(0, 0, 484,150);
        contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
        contentFrame.add(contentPane);
        
		 JPanel studentInfoPanel = new JPanel();
		 studentInfoPanel.setBounds(0,0,484,46);
		 //studentInfoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
		 
		 FlowLayout flowLayout = (FlowLayout) studentInfoPanel.getLayout();
		 //�����岼��
		 flowLayout.setAlignment(FlowLayout.LEFT); 		//��������еĿؼ��������
		 contentPane.add(studentInfoPanel);				//Ӧ�����
		
		 JLabel studentNameLabel = new JLabel("ѧ��������");			//������ǩ
		 studentNameLabel.setFont(new Font("΢���ź�",Font.PLAIN,15));
		 studentInfoPanel.add(studentNameLabel);
		 
		 JTextField studentNameTextField = new JTextField();				//�����ı���
		 studentNameTextField.setFont(new Font("΢���ź�",Font.PLAIN,15));
		 studentInfoPanel.add(studentNameTextField);
		 studentNameTextField.setColumns(10);
		 studentNameTextField.setText(grade.getStudentName());
		 
		 JLabel studentClassLabel = new JLabel("ѧ���༶��");
		 studentClassLabel.setFont(new Font("΢���ź�",Font.PLAIN,15));
		 studentInfoPanel.add(studentClassLabel);
		 
		 JTextField studentClassTextField = new JTextField();
		 studentClassTextField.setFont(new Font("΢���ź�",Font.PLAIN,15));
		 studentInfoPanel.add(studentClassTextField);
		 studentClassTextField.setColumns(10);
		 studentClassTextField.setText(grade.getStudentClass());
		 
		 
		 JPanel testInfoPanel = new JPanel();
		 testInfoPanel.setBounds(0, 58, 484, 89);
		 //testInfoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
		 
		 FlowLayout flowLayout_1 = (FlowLayout) testInfoPanel.getLayout();
		 flowLayout_1.setAlignment(FlowLayout.LEFT); 					//��������еĿؼ������������
		 contentPane.add(testInfoPanel);
		 
		 JLabel testSubjectLabel = new JLabel("���Կ�Ŀ��");
		 testSubjectLabel.setFont(new Font("΢���ź�",Font.PLAIN,15));
		 testInfoPanel.add(testSubjectLabel);
		 
		 JTextField testSubjectTextField = new JTextField();
		 testSubjectTextField.setFont(new Font("΢���ź�",Font.PLAIN,15));
		 testInfoPanel.add(testSubjectTextField);
		 testSubjectTextField.setColumns(10);
		 testSubjectTextField.setText(grade.getTestSubject());
		 
		 JLabel scoreLabel = new JLabel("���Գɼ���");
		 scoreLabel.setFont(new Font("΢���ź�",Font.PLAIN,15));
		 testInfoPanel.add(scoreLabel);
		 
		 JTextField scoreTextField = new JTextField();
		 scoreTextField.setFont(new Font("΢���ź�",Font.PLAIN,15));
		 testInfoPanel.add(scoreTextField);
		 scoreTextField.setColumns(10);
		 scoreTextField.setText(grade.getScore());
		 
		 /*	���ò������
		  *
		  * */
		 JPanel testTimePanel = new JPanel();
		 contentPane.add(testTimePanel);
		 
		 
		 
		 
		 JLabel testTimeLabel = new JLabel("����ʱ�䣺");
		 testTimeLabel.setFont(new Font("΢���ź�",Font.PLAIN,15));
		 testTimePanel.add(testTimeLabel );
		 
		
		 JTextField testTimeTextField = new JTextField();
		 testTimeTextField.setFont(new Font("΢���ź�",Font.PLAIN,15));
		 //testTimeTextField.setText("������2020-10-20");
		 testTimePanel.add(testTimeTextField);
		 testTimeTextField.setColumns(10);
		 testTimeTextField.setText(grade.getTestTime());
		 
		 JPanel remarkPanel = new JPanel();
		//remarkPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
		 FlowLayout flowLayout_2 = (FlowLayout) remarkPanel.getLayout();
		 flowLayout_2.setAlignment(FlowLayout.LEFT);
		 
		 remarkPanel.setBounds(0, 159, 484, 46);
		 contentPane.add(remarkPanel);
		 
		 JLabel remarkLabel = new JLabel("��ע��");
		 remarkLabel.setFont(new Font("΢���ź�",Font.PLAIN,15));
		 remarkPanel.add(remarkLabel);
		 
		 JTextField remarkTextField = new JTextField();
		 remarkTextField.setFont(new Font("΢���ź�",Font.PLAIN,15));
		 remarkPanel.add(remarkTextField);
		 remarkTextField.setColumns(29);
		 remarkTextField.setText(grade.getRemark());
		 
		 
		 JPanel buttonPanel = new JPanel();			//�������
		 //buttonPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
		
		 buttonPanel.setBounds(0, 217, 484, 48);
		 contentPane.add(buttonPanel,BorderLayout.SOUTH);
		 
		 FlowLayout flowLayout3 = new FlowLayout();
		 flowLayout3.setAlignment(FlowLayout.RIGHT);
		 
		
		
		
		 JButton ChangeButton = new JButton("�޸�");
		 //ʡ���¼�������ش���

		 ChangeButton.setFont(new Font("΢���ź�",Font.PLAIN,15));
		 buttonPanel.add(ChangeButton);
		 ChangeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String StudentName = studentNameTextField.getText();
				String StudentClass = studentClassTextField.getText();
				String TestSubject = testSubjectTextField.getText();
				String TestTime = testTimeTextField.getText();
				String Score = scoreTextField.getText();
				String Remark = remarkTextField.getText();
				GradeBean Grade = new GradeBean(StudentName, StudentClass, TestSubject, Score, TestTime, Remark);
				
				Grade.setId(grade.getId());
				
				//System.out.println(Grade.getId()+"\t"+StudentName+"\t"+StudentClass+"\t"+TestSubject+"\t"+TestTime+"\t"+Score+"\t"+Remark);
				
				int ChangeResult = JOptionPane.showConfirmDialog(contentFrame, "ȷ���޸�","��ʾ",JOptionPane.YES_NO_CANCEL_OPTION);
				
				if(ChangeResult == JOptionPane.YES_OPTION) {
					int result = JdbcHelper.updata(Grade);
					if(result >= 0) {
					JOptionPane.showMessageDialog(contentFrame, "�ɼ����޸ĳɹ���");
					
					
					}else {
						JOptionPane.showMessageDialog(contentFrame,"�ɼ����޸�ʧ��", "����",JOptionPane.WARNING_MESSAGE);
						return ;
					}
				}
				else {
					frame.setVisible(false);
				}
				
			}
		});
		 
				 
		 
		 JButton returnButton = new JButton("����");
		 returnButton.setFont(new Font("΢���ź�",Font.PLAIN,15));
		 buttonPanel.add(returnButton);
		 
		 returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				contentFrame.setVisible(false);
				frame.setVisible(true);
			}
		});
		 
		 
	}
}

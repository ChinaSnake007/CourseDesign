package CourseDesign;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

class SwingDemo {	
	
    private static void createAndShowGUI() {
        // Create a new JFrame container.
        JFrame jfrm = new JFrame("ѧ������ϵͳ");
        // Give the frame an initial size.
        jfrm.setLocation(WindowUtil.getLocation());
        
        jfrm.setSize(WindowUtil.getSize());
        // Terminate the program when the user closes the application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //���ñ���
        ImageIcon background = new ImageIcon("src/ѧ������ϵͳ.jpg");
        JLabel label = new JLabel(background);
        jfrm.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        
        
        
        //�����˵���
        JMenuBar menuBar = new JMenuBar();
        jfrm.setJMenuBar(menuBar);
        
        //�鿴�������гɼ���
        JMenu CheckMenu = new JMenu("�鿴�ɼ���");
        CheckMenu.setFont(new Font("΢���ź�",Font.PLAIN,15));
        menuBar.add(CheckMenu);
        
        JMenu SubjectMenu = new JMenu("���Կ�Ŀ");
        SubjectMenu.setFont(new Font("΢���ź�",Font.PLAIN,15));
        CheckMenu.add(SubjectMenu);
        
        JMenuItem EnglishMenuItem = new JMenuItem("Ӣ��");
        EnglishMenuItem.setFont(new Font("΢���ź�",Font.PLAIN,15));
        SubjectMenu.add(EnglishMenuItem);
        EnglishMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GradeBean grade = new GradeBean("", "", "Ӣ��", "", "", "");
				SubjectCheck.Window(grade);
				
			}
		});
        
        JMenuItem ChineseMenuItem = new JMenuItem("����");
        ChineseMenuItem.setFont(new Font("΢���ź�",Font.PLAIN,15));
        SubjectMenu.add(ChineseMenuItem);
        ChineseMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GradeBean grade = new GradeBean("", "", "����", "", "", "");
				SubjectCheck.Window(grade);
			}
		});
        
        
        JMenuItem MathMenuItem = new JMenuItem("��ѧ");
        MathMenuItem.setFont(new Font("΢���ź�",Font.PLAIN,15));
        SubjectMenu.add(MathMenuItem);
        MathMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GradeBean grade = new GradeBean("", "", "��ѧ", "", "", "");
				SubjectCheck.Window(grade);
			}
		});
        
        
        JMenuItem CheckAllMenuItem = new JMenuItem("���гɼ�");
        CheckAllMenuItem.setFont(new Font("΢���ź�",Font.PLAIN,15));
        CheckMenu.add(CheckAllMenuItem);
        
        CheckAllMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CheckAll.Window();
				
			}
		});
        
        
        
        //Ϊ�˵����������С�˵����ɼ��������С����        
        JMenu gradeManagementMenu = new JMenu("�ɼ�������");
        gradeManagementMenu.setFont(new Font("΢���ź�",Font.PLAIN,15));
        menuBar.add(gradeManagementMenu);
        
        
        JMenu toolMenu = new JMenu("С����");
        toolMenu.setFont(new Font("΢���ź�",Font.PLAIN,15));
        menuBar.add(toolMenu);
        
        
        //�ֱ�Ϊ�������˵����Ӳ˵�ѡ��
        
        
        
        
        
        JMenuItem addGradeMenuItem = new JMenuItem("���ӳɼ���");
        //ʡ���¼�������ش���
        addGradeMenuItem.addActionListener(new ActionListener () {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jfrm.setVisible(false);
				//������һ�������ӳɼ���������
				JFrame contentFrame = new JFrame("���ӳɼ���");
				//��Ϊ�ɼ�
				contentFrame.setVisible(true);
				//λ����Ϊ����
				contentFrame.setLocation(WindowUtil.getLocation());
		        
				//���ô��ڴ�С
				contentFrame.setSize(WindowUtil.getSize());
				//�������
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
				 
				 JLabel studentClassLabel = new JLabel("ѧ���༶��");
				 studentClassLabel.setFont(new Font("΢���ź�",Font.PLAIN,15));
				 studentInfoPanel.add(studentClassLabel);
				 
				 JTextField studentClassTextField = new JTextField();
				 studentClassTextField.setFont(new Font("΢���ź�",Font.PLAIN,15));
				 studentInfoPanel.add(studentClassTextField);
				 studentClassTextField.setColumns(10);
				 
				 
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
				 
				 JLabel scoreLabel = new JLabel("���Գɼ���");
				 scoreLabel.setFont(new Font("΢���ź�",Font.PLAIN,15));
				 testInfoPanel.add(scoreLabel);
				 
				 JTextField scoreTextField = new JTextField();
				 scoreTextField.setFont(new Font("΢���ź�",Font.PLAIN,15));
				 testInfoPanel.add(scoreTextField);
				 scoreTextField.setColumns(10);
				 
				 /*	���ò������
				  *
				  * */
				 JPanel testTimePanel = new JPanel();
				 testTimePanel.setBounds(0, 200, 484, 46);
				 contentPane.add(testTimePanel);
				 				 
				 
				 
				 JLabel testTimeLabel = new JLabel("����ʱ�䣺");
				 testTimeLabel.setFont(new Font("΢���ź�",Font.PLAIN,15));
				 testTimePanel.add(testTimeLabel );
				 
				
				 JTextField testTimeTextField = new JTextField();
				 testTimeTextField.setFont(new Font("΢���ź�",Font.PLAIN,15));
				 testTimeTextField.setText("������2020-10-20");
				 testTimePanel.add(testTimeTextField);
				 testTimeTextField.setColumns(10);
				 
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
				 
				 
				 
				 
				 
				 
				 JPanel buttonPanel = new JPanel();			//�������
				 buttonPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
				
				 buttonPanel.setBounds(0, 217, 484, 48);
				 contentPane.add(buttonPanel);
				 
				 FlowLayout flowLayout3 = new FlowLayout();
				 flowLayout3.setAlignment(FlowLayout.CENTER);
				 
				 JButton saveButton = new JButton("����");
				 //ʡ���¼�������ش���
				 saveButton.setFont(new Font("΢���ź�",Font.PLAIN,15));
				 saveButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						String StudentName = studentNameTextField.getText();
						String StudentClass = studentClassTextField.getText();
						String TestSubject = testSubjectTextField.getText();
						String TestTime = testTimeTextField.getText();
						String Score = scoreTextField.getText();
						String Remark = remarkTextField.getText();
						GradeBean a = new GradeBean(StudentName, StudentClass, TestSubject, Score, TestTime, Remark);
						if(StudentName.isEmpty()||StudentClass.isEmpty()||TestTime.isEmpty()||TestTime.isEmpty()||Score.isEmpty()||TestSubject.isEmpty())
							JOptionPane.showMessageDialog(null, "����ע֮��Բ���Ϊ��", "WARNING", JOptionPane.ERROR_MESSAGE);
						else {
							if(!ValidationUtil.validateTestTimeFormat(TestTime)) {
								JOptionPane.showMessageDialog(null, "���ڸ�ʽ����");
							}
							else if(!ValidationUtil.validateStudentClassFormat(StudentClass)){
								JOptionPane.showMessageDialog(null, "�༶��ʽ���ԣ�ӦΪ��12��");
							}
							else {
							JdbcHelper.save(a);
							JOptionPane.showMessageDialog(null, "����ɹ�");
							}
						}
					}
				});
				 buttonPanel.add(saveButton);
				 
				 JButton clearButton = new JButton("���");
				 //ʡ���¼�������ش���
				 clearButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						studentNameTextField.setText("");
						studentClassTextField.setText("");
						testSubjectTextField.setText("");
						scoreTextField.setText("");
						testTimeTextField.setText("");
						remarkTextField.setText("");
					}
				})		//testTime
				;
				 clearButton.setFont(new Font("΢���ź�",Font.PLAIN,15));
				 buttonPanel.add(clearButton);
				 
				 
				 JButton returnButton = new JButton("����");				 	 
				 returnButton.setFont(new Font("΢���ź�",Font.PLAIN,15));
				//ʡ���¼��Ĵ���
				 returnButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							contentFrame.setVisible(false);
							jfrm.setVisible(true);
							GetMove.setzeros();
						}
					});
				 buttonPanel.add(returnButton);
				 
				 
			}
		});

        addGradeMenuItem.setFont(new Font("΢���ź�",Font.PLAIN,15));
        gradeManagementMenu.add(addGradeMenuItem);
        
        JMenuItem modifyGradeMenuItem = new JMenuItem("�޸ĳɼ���");
        //ʡ���¼�������ش���
        modifyGradeMenuItem.setFont(new Font("΢���ź�",Font.PLAIN,15));
        gradeManagementMenu.add(modifyGradeMenuItem);
        modifyGradeMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				jfrm.setVisible(false);
				JFrame contentFrame = new JFrame("��ѯ�ɼ���");
				//��Ϊ�ɼ�
				contentFrame.setVisible(true);
				//λ����Ϊ����
				contentFrame.setLocation(WindowUtil.getLocation());
		        
				//���ô��ڴ�С
				contentFrame.setSize(WindowUtil.getSize());
				//�������
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
				 
				 JLabel studentClassLabel = new JLabel("ѧ���༶��");
				 studentClassLabel.setFont(new Font("΢���ź�",Font.PLAIN,15));
				 studentInfoPanel.add(studentClassLabel);
				 
				 JTextField studentClassTextField = new JTextField();
				 studentClassTextField.setFont(new Font("΢���ź�",Font.PLAIN,15));
				 studentInfoPanel.add(studentClassTextField);
				 studentClassTextField.setColumns(10);
				 
				 
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
				 
				 JLabel scoreLabel = new JLabel("���Գɼ���");
				 scoreLabel.setFont(new Font("΢���ź�",Font.PLAIN,15));
				 testInfoPanel.add(scoreLabel);
				 
				 JTextField scoreTextField = new JTextField();
				 scoreTextField.setFont(new Font("΢���ź�",Font.PLAIN,15));
				 testInfoPanel.add(scoreTextField);
				 scoreTextField.setColumns(10);
				 
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
				 
				 
				 JPanel buttonPanel = new JPanel();			//�������
				 //buttonPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
				
				 buttonPanel.setBounds(0, 217, 484, 48);
				 contentPane.add(buttonPanel,BorderLayout.SOUTH);
				 
				 FlowLayout flowLayout3 = new FlowLayout();
				 flowLayout3.setAlignment(FlowLayout.RIGHT);
				 
				
				
				
				 JButton CheckButton = new JButton("��ѯ");
				 //ʡ���¼�������ش���
				 
				 
				 CheckButton.setFont(new Font("΢���ź�",Font.PLAIN,15));
				 buttonPanel.add(CheckButton);
				 CheckButton.addActionListener(new ActionListener() {
					
					@SuppressWarnings("static-access")
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String StudentName = studentNameTextField.getText();
						String StudentClass = studentClassTextField.getText();
						String TestSubject = testSubjectTextField.getText();
						String TestTime = testTimeTextField.getText();
						String Score = scoreTextField.getText();
						String Remark = remarkTextField.getText();
						//System.out.println("��հ�ť");
						
						
						//jfrm.setVisible(false);
						
						
						if(StudentName.isEmpty()&&StudentClass.isEmpty()&&TestTime.isEmpty()&&TestTime.isEmpty()&&Score.isEmpty()&&TestSubject.isEmpty())
						{	
							JOptionPane JO = new JOptionPane();
							JO.showMessageDialog(null, "��ѯ��������Ϊ��", "WARNING", JOptionPane.ERROR_MESSAGE);
							JO.setFont(new Font("΢���ź�",Font.PLAIN,15));
						}
						else {
							GradeBean grade = new GradeBean(StudentName, StudentClass, TestSubject, Score, TestTime, Remark);
							final ArrayList<GradeBean> results = JdbcHelper.query(grade);
							if(results.size()>0) {
								EventQueue.invokeLater(new Runnable() {
									
									@Override
									public void run() {
										// TODO Auto-generated method stub
										try {
											//GradeQueryResultFrame frame = new GradeQueryResultFrame();
											System.out.println("��ѯ���");
											JFrame frame = new JFrame("��ѯ���");
											frame.setVisible(true);
											

											Dimension a = WindowUtil.getSize();
											Point A = WindowUtil.getLocation();
											int move = GetMove.move;
											frame.setBounds(A.x+510+35*move,A.y+20*move,a.width,a.height);
											GetMove.add();
											
											frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
											frame.getContentPane().setLayout(null);
											
											JScrollPane scrollPane = new JScrollPane();
											frame.getContentPane().add(scrollPane);
											
											
											JTable studentGradeTable = new JTable();
											
											studentGradeTable.setFont(new Font("΢���ź�",Font.PLAIN,15));
											studentGradeTable.setRowHeight(25);
											
											
											JTableHeader header = studentGradeTable.getTableHeader();
											header.setFont(new Font("΢���ź�",Font.PLAIN,15));
											header.setPreferredSize(new Dimension(header.getWidth(),50));
																						
											DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
											renderer.setHorizontalAlignment(SwingConstants.CENTER);
											
											DefaultTableModel model = (DefaultTableModel) studentGradeTable.getModel();
											model.setRowCount( 0); 		//��ձ���е�����
											model.setColumnIdentifiers(new Object[] {"���","ѧ������","ѧ���༶","���Կ�Ŀ","���Գɼ�","����ʱ��","��ע"});
											for(GradeBean grade:results) {
												model.addRow(new Object[] {grade.getId(),grade.getStudentName(),grade.getStudentClass(),grade.getTestSubject(),grade.getScore(),grade.getTestTime(),grade.getRemark()}); 		
											}
											studentGradeTable.setModel(model);
											studentGradeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
											
											scrollPane.setViewportView(studentGradeTable);
											Dimension size = WindowUtil.getSize();
											scrollPane.setLocation(0, 0);
											
											scrollPane.setSize(size.width,size.height-100);
											
											
											
											
											JButton returnButton = new JButton("����");				 	 
											returnButton.setFont(new Font("΢���ź�",Font.PLAIN,15));
											
											frame.add(returnButton);
											returnButton.setBounds(300,220,80,35);
											
											returnButton.addActionListener(new ActionListener() {
												
												@Override
												public void actionPerformed(ActionEvent arg0) {
													// TODO Auto-generated method stub
													frame.setVisible(false);
													
												}
											});
											
											JButton changeButton = new JButton("�޸�");
											changeButton.setFont(new Font("΢���ź�",Font.PLAIN,15));
											
											frame.add(changeButton);
											changeButton.setBounds(150,220,80,35);
											
											changeButton.addActionListener(new ActionListener() {
												
												@Override
												public void actionPerformed(ActionEvent arg0) {
													// TODO Auto-generated method stub
													int selectRow = studentGradeTable.getSelectedRow();
													if(selectRow<0) {
														JOptionPane.showMessageDialog(frame, "��ѡ����Ҫ�޸ĵ���","Waring",JOptionPane.WARNING_MESSAGE);
														return;
													}else {
														String StudentName = (String) studentGradeTable.getValueAt(selectRow, 1);
														String StudentClass = (String) studentGradeTable.getValueAt(selectRow, 2);
														String TestSubject = (String) studentGradeTable.getValueAt(selectRow, 3);
														String Score = (String) studentGradeTable.getValueAt(selectRow, 4);
														String TestTime = (String) studentGradeTable.getValueAt(selectRow, 5);
														String Remark = (String) studentGradeTable.getValueAt(selectRow, 6);
														
														final GradeBean grade = new GradeBean(StudentName, StudentClass, TestSubject, Score, TestTime, Remark);
														grade.setId((int) studentGradeTable.getValueAt(selectRow,0));
														EventQueue.invokeLater(new Runnable() {
															
															@Override
															public void run() {
																try {
																	frame.setVisible(false);
																	JFrame jfrm = new JFrame("�޸ĳɼ���");
																	jfrm.setVisible(true);
																	
																	Dimension a = WindowUtil.getSize();
																	Point A = WindowUtil.getLocation();
																	jfrm.setBounds(A.x+510,A.y,a.width,a.height);
																	
																	GradeModificationFrame jFrame = new GradeModificationFrame();
																	jFrame.setWindow(grade,jfrm,frame);
																	
																	
																	
																}catch(Exception e) {
																	e.printStackTrace();
																}
																
															}
														});
													}
													
												}
											});
											
										}catch (Exception e) {
											// TODO: handle exception
											e.printStackTrace();
										}
									}
								});
								return ;
							}else {
								JOptionPane JO = new JOptionPane();
								JO.showMessageDialog(null, "�޷�������");
							}
						}
					}
				});
				 
				 JButton clearButton = new JButton("���");
				 //ʡ���¼�������ش���
				 clearButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						studentNameTextField.setText("");
						studentClassTextField.setText("");
						testSubjectTextField.setText("");
						scoreTextField.setText("");
						testTimeTextField.setText("");
						remarkTextField.setText("");
					}
				});		
				 
				 
				 clearButton.setFont(new Font("΢���ź�",Font.PLAIN,15));
				 buttonPanel.add(clearButton);
				 
				 
				 JButton returnButton = new JButton("����");				 	 
				 returnButton.setFont(new Font("΢���ź�",Font.PLAIN,15));
				//ʡ���¼��Ĵ���
				 returnButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							contentFrame.setVisible(false);
							jfrm.setVisible(true);
							GetMove.setzeros();
							
						}
					});
				 buttonPanel.add(returnButton);
				
			
				
				
				
				
			}
		});
        
        JMenuItem qureyGradeMenuItem = new JMenuItem("��ѯ�ɼ���");
        //ʡ���¼�������ش���
        qureyGradeMenuItem.setFont(new Font("΢���ź�",Font.PLAIN,15));
        gradeManagementMenu.add(qureyGradeMenuItem);
        qureyGradeMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				jfrm.setVisible(false);
				JFrame contentFrame = new JFrame("��ѯ�ɼ���");
				//��Ϊ�ɼ�
				contentFrame.setVisible(true);
				//λ����Ϊ����
				contentFrame.setLocation(WindowUtil.getLocation());
		        
				//���ô��ڴ�С
				contentFrame.setSize(WindowUtil.getSize());
				//�������
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
				 
				 JLabel studentClassLabel = new JLabel("ѧ���༶��");
				 studentClassLabel.setFont(new Font("΢���ź�",Font.PLAIN,15));
				 studentInfoPanel.add(studentClassLabel);
				 
				 JTextField studentClassTextField = new JTextField();
				 studentClassTextField.setFont(new Font("΢���ź�",Font.PLAIN,15));
				 studentInfoPanel.add(studentClassTextField);
				 studentClassTextField.setColumns(10);
				 
				 
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
				 
				 JLabel scoreLabel = new JLabel("���Գɼ���");
				 scoreLabel.setFont(new Font("΢���ź�",Font.PLAIN,15));
				 testInfoPanel.add(scoreLabel);
				 
				 JTextField scoreTextField = new JTextField();
				 scoreTextField.setFont(new Font("΢���ź�",Font.PLAIN,15));
				 testInfoPanel.add(scoreTextField);
				 scoreTextField.setColumns(10);
				 
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
				 
				 
				 JPanel buttonPanel = new JPanel();			//�������
				 //buttonPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
				
				 buttonPanel.setBounds(0, 217, 484, 48);
				 contentPane.add(buttonPanel,BorderLayout.SOUTH);
				 
				 FlowLayout flowLayout3 = new FlowLayout();
				 flowLayout3.setAlignment(FlowLayout.RIGHT);
				 
				
				
				
				 JButton CheckButton = new JButton("��ѯ");
				 //ʡ���¼�������ش���
				 CheckButton.setFont(new Font("΢���ź�",Font.PLAIN,15));
				 buttonPanel.add(CheckButton);
				 CheckButton.addActionListener(new ActionListener() {
					
					@SuppressWarnings("static-access")
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String StudentName = studentNameTextField.getText();
						String StudentClass = studentClassTextField.getText();
						String TestSubject = testSubjectTextField.getText();
						String TestTime = testTimeTextField.getText();
						String Score = scoreTextField.getText();
						String Remark = remarkTextField.getText();
						//System.out.println("��հ�ť");
						
						
						//jfrm.setVisible(false);
						
						if(StudentName.isEmpty()&&StudentClass.isEmpty()&&TestTime.isEmpty()&&TestTime.isEmpty()&&Score.isEmpty()&&TestSubject.isEmpty())
						{	
							JOptionPane JO = new JOptionPane();
							JO.showMessageDialog(null, "��ѯ��������Ϊ��", "WARNING", JOptionPane.ERROR_MESSAGE);
							JO.setFont(new Font("΢���ź�",Font.PLAIN,15));
						}
						else {
							GradeBean grade = new GradeBean(StudentName, StudentClass, TestSubject, Score, TestTime, Remark);
							final ArrayList<GradeBean> results = JdbcHelper.query(grade);
							if(results.size()>0) {
								EventQueue.invokeLater(new Runnable() {
									
									@Override
									public void run() {
										// TODO Auto-generated method stub
										try {
											//GradeQueryResultFrame frame = new GradeQueryResultFrame();
											
											JFrame jfrm = new JFrame("��ѯ���");
											
											Point A =WindowUtil.getLocation();
											
											int move = GetMove.move;
											jfrm.setLocation(A.x+510+35*move,A.y+20*move);
											GetMove.add();
											
											jfrm.setSize(WindowUtil.getSize());
											
											JPanel contentPane = new JPanel();
											contentPane.setLayout(new BorderLayout(0,0));
											jfrm.add(contentPane);
											//setContentPane(contentPane);
											
											JScrollPane scrollPane = new JScrollPane();
											contentPane.add(scrollPane);
											
											JTable studentGradeTable = new JTable();
											
											studentGradeTable.setFont(new Font("΢���ź�",Font.PLAIN,15));
											studentGradeTable.setRowHeight(25);
											JTableHeader header = studentGradeTable.getTableHeader();
											header.setFont(new Font("΢���ź�",Font.PLAIN,15));
											header.setPreferredSize(new Dimension(header.getWidth(),50));
											
											
											
											DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
											renderer.setHorizontalAlignment(SwingConstants.CENTER);
											
											DefaultTableModel model = (DefaultTableModel) studentGradeTable.getModel();
											model.setRowCount( 0); 		//��ձ���е�����
											model.setColumnIdentifiers(new Object[] {"ѧ������","ѧ���༶","���Կ�Ŀ","���Գɼ�","����ʱ��","��ע"});
											for(GradeBean grade:results) {
												model.addRow(new Object[] {grade.getStudentName(),grade.getStudentClass(),grade.getTestSubject(),grade.getScore(),grade.getTestTime(),grade.getRemark()}); 		
												System.out.println(grade.getId());
											}
																														
											
											studentGradeTable.setModel(model);
											studentGradeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
											
											scrollPane.setViewportView(studentGradeTable);
											scrollPane.setLocation(WindowUtil.getLocation());
											scrollPane.setSize(WindowUtil.getSize());
											jfrm.setVisible(true);
										}catch (Exception e) {
											// TODO: handle exception
											e.printStackTrace();
										}
									}
								});
								return ;
							}else {
								JOptionPane JO = new JOptionPane();
								JO.showMessageDialog(null, "�޷�������");
							}
						}
					}
				});
				 
				 JButton clearButton = new JButton("���");
				 //ʡ���¼�������ش���
				 clearButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						studentNameTextField.setText("");
						studentClassTextField.setText("");
						testSubjectTextField.setText("");
						scoreTextField.setText("");
						testTimeTextField.setText("");
						remarkTextField.setText("");
					}
				});		
				 
				 
				 clearButton.setFont(new Font("΢���ź�",Font.PLAIN,15));
				 buttonPanel.add(clearButton);
				 
				 
				 JButton returnButton = new JButton("����");				 	 
				 returnButton.setFont(new Font("΢���ź�",Font.PLAIN,15));
				//ʡ���¼��Ĵ���
				 returnButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							contentFrame.setVisible(false);
							jfrm.setVisible(true);
							GetMove.setzeros();
						}
					});
				 buttonPanel.add(returnButton);
				
			
				
			}
		});
        
        
        
        JMenuItem deleteGradeMenuItem = new JMenuItem("ɾ���ɼ���");
        //ʡ���¼�������ش���
        deleteGradeMenuItem.setFont(new Font("΢���ź�",Font.PLAIN,15));
        gradeManagementMenu.add(deleteGradeMenuItem);
        deleteGradeMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				jfrm.setVisible(false);
				JFrame contentFrame = new JFrame("��ѯ�ɼ���");
				
				
				
				
				
				
				
				
				//��Ϊ�ɼ�
				contentFrame.setVisible(true);
				//λ����Ϊ����
				contentFrame.setLocation(WindowUtil.getLocation());
		        
				//���ô��ڴ�С
				contentFrame.setSize(WindowUtil.getSize());
				//�������
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
				 
				 JLabel studentClassLabel = new JLabel("ѧ���༶��");
				 studentClassLabel.setFont(new Font("΢���ź�",Font.PLAIN,15));
				 studentInfoPanel.add(studentClassLabel);
				 
				 JTextField studentClassTextField = new JTextField();
				 studentClassTextField.setFont(new Font("΢���ź�",Font.PLAIN,15));
				 studentInfoPanel.add(studentClassTextField);
				 studentClassTextField.setColumns(10);
				 
				 
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
				 
				 JLabel scoreLabel = new JLabel("���Գɼ���");
				 scoreLabel.setFont(new Font("΢���ź�",Font.PLAIN,15));
				 testInfoPanel.add(scoreLabel);
				 
				 JTextField scoreTextField = new JTextField();
				 scoreTextField.setFont(new Font("΢���ź�",Font.PLAIN,15));
				 testInfoPanel.add(scoreTextField);
				 scoreTextField.setColumns(10);
				 
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
				 
				 
				 JPanel buttonPanel = new JPanel();			//�������
				 //buttonPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
				
				 buttonPanel.setBounds(0, 217, 484, 48);
				 contentPane.add(buttonPanel,BorderLayout.SOUTH);
				 
				 FlowLayout flowLayout3 = new FlowLayout();
				 flowLayout3.setAlignment(FlowLayout.RIGHT);
				 
				
				
				
				 JButton CheckButton = new JButton("��ѯ");
				 //ʡ���¼�������ش���
				 CheckButton.setFont(new Font("΢���ź�",Font.PLAIN,15));
				 buttonPanel.add(CheckButton);
				 CheckButton.addActionListener(new ActionListener() {
					
					@SuppressWarnings("static-access")
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String StudentName = studentNameTextField.getText();
						String StudentClass = studentClassTextField.getText();
						String TestSubject = testSubjectTextField.getText();
						String TestTime = testTimeTextField.getText();
						String Score = scoreTextField.getText();
						String Remark = remarkTextField.getText();
						//System.out.println("��հ�ť");
						
						
						//jfrm.setVisible(false);
						
						if(StudentName.isEmpty()&&StudentClass.isEmpty()&&TestTime.isEmpty()&&TestTime.isEmpty()&&Score.isEmpty()&&TestSubject.isEmpty())
						{	
							JOptionPane JO = new JOptionPane();
							JO.showMessageDialog(null, "��ѯ��������Ϊ��", "WARNING", JOptionPane.ERROR_MESSAGE);
							JO.setFont(new Font("΢���ź�",Font.PLAIN,15));
						}
						else {
							GradeBean grade = new GradeBean(StudentName, StudentClass, TestSubject, Score, TestTime, Remark);
							final ArrayList<GradeBean> results = JdbcHelper.query(grade);
							if(results.size()>0) {
								EventQueue.invokeLater(new Runnable() {
									
									@Override
									public void run() {
										// TODO Auto-generated method stub
										try {
											//GradeQueryResultFrame frame = new GradeQueryResultFrame();
											System.out.println("��ѯ���");
											JFrame frame = new JFrame("��ѯ���");
											frame.setVisible(true);
											

											Dimension a = WindowUtil.getSize();
											Point A = WindowUtil.getLocation();
											int move = GetMove.move;
											frame.setBounds(A.x+510+35*move,A.y+20*move,a.width,a.height);
											GetMove.add();
											
											frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
											frame.getContentPane().setLayout(null);
											
											JScrollPane scrollPane = new JScrollPane();
											frame.getContentPane().add(scrollPane);
											
											
											JTable studentGradeTable = new JTable();
											
											studentGradeTable.setFont(new Font("΢���ź�",Font.PLAIN,15));
											studentGradeTable.setRowHeight(25);
											
											
											JTableHeader header = studentGradeTable.getTableHeader();
											header.setFont(new Font("΢���ź�",Font.PLAIN,15));
											header.setPreferredSize(new Dimension(header.getWidth(),50));
																						
											DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
											renderer.setHorizontalAlignment(SwingConstants.CENTER);
											
											DefaultTableModel model = (DefaultTableModel) studentGradeTable.getModel();
											model.setRowCount( 0); 		//��ձ���е�����
											model.setColumnIdentifiers(new Object[] {"���","ѧ������","ѧ���༶","���Կ�Ŀ","���Գɼ�","����ʱ��","��ע"});
											
											for(GradeBean grade:results) {
												model.addRow(new Object[] {grade.getId(),grade.getStudentName(),grade.getStudentClass(),grade.getTestSubject(),grade.getScore(),grade.getTestTime(),grade.getRemark()}); 		
											}
											
											studentGradeTable.setModel(model);
											studentGradeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
											
											scrollPane.setViewportView(studentGradeTable);
											Dimension size = WindowUtil.getSize();
											scrollPane.setLocation(0, 0);
											
											scrollPane.setSize(size.width,size.height-100);
											
											
											
											
											JButton returnButton = new JButton("����");				 	 
											returnButton.setFont(new Font("΢���ź�",Font.PLAIN,15));
											
											frame.add(returnButton);
											returnButton.setBounds(300,220,80,35);
											
											returnButton.addActionListener(new ActionListener() {
												
												@Override
												public void actionPerformed(ActionEvent arg0) {
													// TODO Auto-generated method stub
													frame.setVisible(false);
													
												}
											});
											
											JButton DeleteButton = new JButton("ɾ��");
											DeleteButton.setFont(new Font("΢���ź�",Font.PLAIN,15));
											
											//��ɾ����ť����ӽ��봰��
											frame.add(DeleteButton);
											DeleteButton.setBounds(150,220,80,35);
											
											DeleteButton.addActionListener(new ActionListener() {
												
												@Override
												public void actionPerformed(ActionEvent arg0) {
													// TODO Auto-generated method stub
													int selectRow = studentGradeTable.getSelectedRow();
													if(selectRow<0) {
														JOptionPane.showMessageDialog(frame, "��ѡ����Ҫɾ������","Waring",JOptionPane.WARNING_MESSAGE);
														return;
													}else {
														String StudentName = (String) studentGradeTable.getValueAt(selectRow, 1);
														String StudentClass = (String) studentGradeTable.getValueAt(selectRow, 2);
														String TestSubject = (String) studentGradeTable.getValueAt(selectRow, 3);
														String Score = (String) studentGradeTable.getValueAt(selectRow, 4);
														String TestTime = (String) studentGradeTable.getValueAt(selectRow, 5);
														String Remark = (String) studentGradeTable.getValueAt(selectRow, 6);
																											
														final GradeBean Grade = new GradeBean(StudentName, StudentClass, TestSubject, Score, TestTime, Remark);
														Grade.setId((int) studentGradeTable.getValueAt(selectRow,0));
														/**/
														int DeleteResult = JOptionPane.showConfirmDialog(frame, "ȷ��ɾ��","��ʾ",JOptionPane.YES_NO_CANCEL_OPTION);
														
														if(DeleteResult == JOptionPane.YES_OPTION) {
															JdbcHelper.delete(frame,Grade);
															/*��������*/
															
															System.out.println(selectRow);
															
															model.removeRow(selectRow); 		//��ɾ������һ�������Ƴ�
															
															
														}
													}													
												}
											});
											
										}catch (Exception e) {
											// TODO: handle exception
											e.printStackTrace();
										}
									}
								});
								return ;
							}else {
								JOptionPane JO = new JOptionPane();
								JO.showMessageDialog(null, "�޷�������");
							}
						}
					}
				});
				 
				 JButton clearButton = new JButton("���");
				 //ʡ���¼�������ش���
				 clearButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						studentNameTextField.setText("");
						studentClassTextField.setText("");
						testSubjectTextField.setText("");
						scoreTextField.setText("");
						testTimeTextField.setText("");
						remarkTextField.setText("");
					}
				});		
				 
				 
				 clearButton.setFont(new Font("΢���ź�",Font.PLAIN,15));
				 buttonPanel.add(clearButton);
				 
				 
				 JButton returnButton = new JButton("����");				 	 
				 returnButton.setFont(new Font("΢���ź�",Font.PLAIN,15));
				//ʡ���¼��Ĵ���
				 returnButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							contentFrame.setVisible(false);
							jfrm.setVisible(true);
							GetMove.setzeros();
						}
					});
				 buttonPanel.add(returnButton);
				
			
			}
		});
        
        
        
        
        
        JMenuItem notepadMenuItem = new JMenuItem("���±�");
        //ʡ���¼�������ش���
        notepadMenuItem.setFont(new Font("΢���ź�",Font.PLAIN,15));
        toolMenu.add(notepadMenuItem);
        notepadMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Runtime runTime = Runtime.getRuntime();
				try {
					runTime.exec("notepad");
				}catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
			}
		});
        
        JMenuItem calculatorMenuItem = new JMenuItem("������");
        //ʡ���¼�������ش���
        calculatorMenuItem.setFont(new Font("΢���ź�",Font.PLAIN,15));
        toolMenu.add(calculatorMenuItem);
        calculatorMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				
				
				
				
				
				
				
				
			}
		});
        
        
        
       
        // Display the frame.
        jfrm.setVisible(true);
    }

    public static void main(String args[]) {
        // Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

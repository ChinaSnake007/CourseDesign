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
        JFrame jfrm = new JFrame("学生管理系统");
        // Give the frame an initial size.
        jfrm.setLocation(WindowUtil.getLocation());
        
        jfrm.setSize(WindowUtil.getSize());
        // Terminate the program when the user closes the application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //设置背景
        ImageIcon background = new ImageIcon("src/学生管理系统.jpg");
        JLabel label = new JLabel(background);
        jfrm.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        
        
        
        //创建菜单条
        JMenuBar menuBar = new JMenuBar();
        jfrm.setJMenuBar(menuBar);
        
        //查看所有已有成绩单
        JMenu CheckMenu = new JMenu("查看成绩单");
        CheckMenu.setFont(new Font("微软雅黑",Font.PLAIN,15));
        menuBar.add(CheckMenu);
        
        JMenu SubjectMenu = new JMenu("考试科目");
        SubjectMenu.setFont(new Font("微软雅黑",Font.PLAIN,15));
        CheckMenu.add(SubjectMenu);
        
        JMenuItem EnglishMenuItem = new JMenuItem("英语");
        EnglishMenuItem.setFont(new Font("微软雅黑",Font.PLAIN,15));
        SubjectMenu.add(EnglishMenuItem);
        EnglishMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GradeBean grade = new GradeBean("", "", "英语", "", "", "");
				SubjectCheck.Window(grade);
				
			}
		});
        
        JMenuItem ChineseMenuItem = new JMenuItem("语文");
        ChineseMenuItem.setFont(new Font("微软雅黑",Font.PLAIN,15));
        SubjectMenu.add(ChineseMenuItem);
        ChineseMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GradeBean grade = new GradeBean("", "", "语文", "", "", "");
				SubjectCheck.Window(grade);
			}
		});
        
        
        JMenuItem MathMenuItem = new JMenuItem("数学");
        MathMenuItem.setFont(new Font("微软雅黑",Font.PLAIN,15));
        SubjectMenu.add(MathMenuItem);
        MathMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GradeBean grade = new GradeBean("", "", "数学", "", "", "");
				SubjectCheck.Window(grade);
			}
		});
        
        
        JMenuItem CheckAllMenuItem = new JMenuItem("所有成绩");
        CheckAllMenuItem.setFont(new Font("微软雅黑",Font.PLAIN,15));
        CheckMenu.add(CheckAllMenuItem);
        
        CheckAllMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CheckAll.Window();
				
			}
		});
        
        
        
        //为菜单条添加两个小菜单，成绩单管理和小工具        
        JMenu gradeManagementMenu = new JMenu("成绩单管理");
        gradeManagementMenu.setFont(new Font("微软雅黑",Font.PLAIN,15));
        menuBar.add(gradeManagementMenu);
        
        
        JMenu toolMenu = new JMenu("小工具");
        toolMenu.setFont(new Font("微软雅黑",Font.PLAIN,15));
        menuBar.add(toolMenu);
        
        
        //分别为这两个菜单增加菜单选项
        
        
        
        
        
        JMenuItem addGradeMenuItem = new JMenuItem("增加成绩单");
        //省略事件处理相关代码
        addGradeMenuItem.addActionListener(new ActionListener () {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jfrm.setVisible(false);
				//新生成一个“增加成绩单”窗口
				JFrame contentFrame = new JFrame("增加成绩单");
				//设为可见
				contentFrame.setVisible(true);
				//位置设为正中
				contentFrame.setLocation(WindowUtil.getLocation());
		        
				//设置窗口大小
				contentFrame.setSize(WindowUtil.getSize());
				//生成面板
		        JPanel contentPane = new JPanel();
		        //获取contentPane面板布局
		        FlowLayout flowLayout_0 = (FlowLayout) contentPane.getLayout();
		        flowLayout_0.setAlignment(FlowLayout.LEFT);					//左对齐
		        contentPane.setBounds(0, 0, 484,150);
		        contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
		        contentFrame.add(contentPane);
		        
				 JPanel studentInfoPanel = new JPanel();
				 studentInfoPanel.setBounds(0,0,484,46);
				 //studentInfoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
				 
				 FlowLayout flowLayout = (FlowLayout) studentInfoPanel.getLayout();
				 //获得面板布局
				 flowLayout.setAlignment(FlowLayout.LEFT); 		//设置面板中的控件按左对齐
				 contentPane.add(studentInfoPanel);				//应用面板
				
				 JLabel studentNameLabel = new JLabel("学生姓名：");			//创建标签
				 studentNameLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 studentInfoPanel.add(studentNameLabel);
				 
				 JTextField studentNameTextField = new JTextField();				//创建文本框
				 studentNameTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 studentInfoPanel.add(studentNameTextField);
				 studentNameTextField.setColumns(10);
				 
				 JLabel studentClassLabel = new JLabel("学生班级：");
				 studentClassLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 studentInfoPanel.add(studentClassLabel);
				 
				 JTextField studentClassTextField = new JTextField();
				 studentClassTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 studentInfoPanel.add(studentClassTextField);
				 studentClassTextField.setColumns(10);
				 
				 
				 JPanel testInfoPanel = new JPanel();
				 testInfoPanel.setBounds(0, 58, 484, 89);
				 //testInfoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
				 
				 FlowLayout flowLayout_1 = (FlowLayout) testInfoPanel.getLayout();
				 flowLayout_1.setAlignment(FlowLayout.LEFT); 					//设置面板中的控件按左对齐排列
				 contentPane.add(testInfoPanel);
				 
				 JLabel testSubjectLabel = new JLabel("考试科目：");
				 testSubjectLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 testInfoPanel.add(testSubjectLabel);
				 
				 JTextField testSubjectTextField = new JTextField();
				 testSubjectTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 testInfoPanel.add(testSubjectTextField);
				 testSubjectTextField.setColumns(10);
				 
				 JLabel scoreLabel = new JLabel("考试成绩：");
				 scoreLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 testInfoPanel.add(scoreLabel);
				 
				 JTextField scoreTextField = new JTextField();
				 scoreTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 testInfoPanel.add(scoreTextField);
				 scoreTextField.setColumns(10);
				 
				 /*	设置测试面板
				  *
				  * */
				 JPanel testTimePanel = new JPanel();
				 testTimePanel.setBounds(0, 200, 484, 46);
				 contentPane.add(testTimePanel);
				 				 
				 
				 
				 JLabel testTimeLabel = new JLabel("考试时间：");
				 testTimeLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 testTimePanel.add(testTimeLabel );
				 
				
				 JTextField testTimeTextField = new JTextField();
				 testTimeTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 testTimeTextField.setText("样例：2020-10-20");
				 testTimePanel.add(testTimeTextField);
				 testTimeTextField.setColumns(10);
				 
				 JPanel remarkPanel = new JPanel();
				//remarkPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
				 FlowLayout flowLayout_2 = (FlowLayout) remarkPanel.getLayout();
				 flowLayout_2.setAlignment(FlowLayout.LEFT);
				 
				 remarkPanel.setBounds(0, 159, 484, 46);
				 contentPane.add(remarkPanel);
				 
				 JLabel remarkLabel = new JLabel("备注：");
				 remarkLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 remarkPanel.add(remarkLabel);
				 
				 JTextField remarkTextField = new JTextField();
				 remarkTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 remarkPanel.add(remarkTextField);
				 remarkTextField.setColumns(29);
				 
				 
				 
				 
				 
				 
				 JPanel buttonPanel = new JPanel();			//创建面板
				 buttonPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
				
				 buttonPanel.setBounds(0, 217, 484, 48);
				 contentPane.add(buttonPanel);
				 
				 FlowLayout flowLayout3 = new FlowLayout();
				 flowLayout3.setAlignment(FlowLayout.CENTER);
				 
				 JButton saveButton = new JButton("保存");
				 //省略事件处理相关代码
				 saveButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
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
							JOptionPane.showMessageDialog(null, "除备注之外皆不能为空", "WARNING", JOptionPane.ERROR_MESSAGE);
						else {
							if(!ValidationUtil.validateTestTimeFormat(TestTime)) {
								JOptionPane.showMessageDialog(null, "日期格式不对");
							}
							else if(!ValidationUtil.validateStudentClassFormat(StudentClass)){
								JOptionPane.showMessageDialog(null, "班级格式不对，应为：12班");
							}
							else {
							JdbcHelper.save(a);
							JOptionPane.showMessageDialog(null, "保存成功");
							}
						}
					}
				});
				 buttonPanel.add(saveButton);
				 
				 JButton clearButton = new JButton("清空");
				 //省略事件处理相关代码
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
				 clearButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 buttonPanel.add(clearButton);
				 
				 
				 JButton returnButton = new JButton("返回");				 	 
				 returnButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
				//省略事件的代码
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

        addGradeMenuItem.setFont(new Font("微软雅黑",Font.PLAIN,15));
        gradeManagementMenu.add(addGradeMenuItem);
        
        JMenuItem modifyGradeMenuItem = new JMenuItem("修改成绩单");
        //省略事件处理相关代码
        modifyGradeMenuItem.setFont(new Font("微软雅黑",Font.PLAIN,15));
        gradeManagementMenu.add(modifyGradeMenuItem);
        modifyGradeMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				jfrm.setVisible(false);
				JFrame contentFrame = new JFrame("查询成绩单");
				//设为可见
				contentFrame.setVisible(true);
				//位置设为正中
				contentFrame.setLocation(WindowUtil.getLocation());
		        
				//设置窗口大小
				contentFrame.setSize(WindowUtil.getSize());
				//生成面板
		        JPanel contentPane = new JPanel();
		        //获取contentPane面板布局
		        FlowLayout flowLayout_0 = (FlowLayout) contentPane.getLayout();
		        flowLayout_0.setAlignment(FlowLayout.LEFT);					//左对齐
		        contentPane.setBounds(0, 0, 484,150);
		        contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
		        contentFrame.add(contentPane);
		        
				 JPanel studentInfoPanel = new JPanel();
				 studentInfoPanel.setBounds(0,0,484,46);
				 //studentInfoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
				 
				 FlowLayout flowLayout = (FlowLayout) studentInfoPanel.getLayout();
				 //获得面板布局
				 flowLayout.setAlignment(FlowLayout.LEFT); 		//设置面板中的控件按左对齐
				 contentPane.add(studentInfoPanel);				//应用面板
				
				 JLabel studentNameLabel = new JLabel("学生姓名：");			//创建标签
				 studentNameLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 studentInfoPanel.add(studentNameLabel);
				 
				 JTextField studentNameTextField = new JTextField();				//创建文本框
				 studentNameTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 studentInfoPanel.add(studentNameTextField);
				 studentNameTextField.setColumns(10);
				 
				 JLabel studentClassLabel = new JLabel("学生班级：");
				 studentClassLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 studentInfoPanel.add(studentClassLabel);
				 
				 JTextField studentClassTextField = new JTextField();
				 studentClassTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 studentInfoPanel.add(studentClassTextField);
				 studentClassTextField.setColumns(10);
				 
				 
				 JPanel testInfoPanel = new JPanel();
				 testInfoPanel.setBounds(0, 58, 484, 89);
				 //testInfoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
				 
				 FlowLayout flowLayout_1 = (FlowLayout) testInfoPanel.getLayout();
				 flowLayout_1.setAlignment(FlowLayout.LEFT); 					//设置面板中的控件按左对齐排列
				 contentPane.add(testInfoPanel);
				 
				 JLabel testSubjectLabel = new JLabel("考试科目：");
				 testSubjectLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 testInfoPanel.add(testSubjectLabel);
				 
				 JTextField testSubjectTextField = new JTextField();
				 testSubjectTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 testInfoPanel.add(testSubjectTextField);
				 testSubjectTextField.setColumns(10);
				 
				 JLabel scoreLabel = new JLabel("考试成绩：");
				 scoreLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 testInfoPanel.add(scoreLabel);
				 
				 JTextField scoreTextField = new JTextField();
				 scoreTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 testInfoPanel.add(scoreTextField);
				 scoreTextField.setColumns(10);
				 
				 /*	设置测试面板
				  *
				  * */
				 JPanel testTimePanel = new JPanel();
				 contentPane.add(testTimePanel);
				 
				 
				 
				 
				 JLabel testTimeLabel = new JLabel("考试时间：");
				 testTimeLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 testTimePanel.add(testTimeLabel );
				 
				
				 JTextField testTimeTextField = new JTextField();
				 testTimeTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 //testTimeTextField.setText("样例：2020-10-20");
				 testTimePanel.add(testTimeTextField);
				 testTimeTextField.setColumns(10);
				 
				 JPanel remarkPanel = new JPanel();
				//remarkPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
				 FlowLayout flowLayout_2 = (FlowLayout) remarkPanel.getLayout();
				 flowLayout_2.setAlignment(FlowLayout.LEFT);
				 
				 remarkPanel.setBounds(0, 159, 484, 46);
				 contentPane.add(remarkPanel);
				 
				 JLabel remarkLabel = new JLabel("备注：");
				 remarkLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 remarkPanel.add(remarkLabel);
				 
				 JTextField remarkTextField = new JTextField();
				 remarkTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 remarkPanel.add(remarkTextField);
				 remarkTextField.setColumns(29);
				 
				 
				 JPanel buttonPanel = new JPanel();			//创建面板
				 //buttonPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
				
				 buttonPanel.setBounds(0, 217, 484, 48);
				 contentPane.add(buttonPanel,BorderLayout.SOUTH);
				 
				 FlowLayout flowLayout3 = new FlowLayout();
				 flowLayout3.setAlignment(FlowLayout.RIGHT);
				 
				
				
				
				 JButton CheckButton = new JButton("查询");
				 //省略事件处理相关代码
				 
				 
				 CheckButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
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
						//System.out.println("清空按钮");
						
						
						//jfrm.setVisible(false);
						
						
						if(StudentName.isEmpty()&&StudentClass.isEmpty()&&TestTime.isEmpty()&&TestTime.isEmpty()&&Score.isEmpty()&&TestSubject.isEmpty())
						{	
							JOptionPane JO = new JOptionPane();
							JO.showMessageDialog(null, "查询条件不能为空", "WARNING", JOptionPane.ERROR_MESSAGE);
							JO.setFont(new Font("微软雅黑",Font.PLAIN,15));
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
											System.out.println("查询结果");
											JFrame frame = new JFrame("查询结果");
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
											
											studentGradeTable.setFont(new Font("微软雅黑",Font.PLAIN,15));
											studentGradeTable.setRowHeight(25);
											
											
											JTableHeader header = studentGradeTable.getTableHeader();
											header.setFont(new Font("微软雅黑",Font.PLAIN,15));
											header.setPreferredSize(new Dimension(header.getWidth(),50));
																						
											DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
											renderer.setHorizontalAlignment(SwingConstants.CENTER);
											
											DefaultTableModel model = (DefaultTableModel) studentGradeTable.getModel();
											model.setRowCount( 0); 		//清空表格中的数据
											model.setColumnIdentifiers(new Object[] {"编号","学生姓名","学生班级","考试科目","考试成绩","考试时间","备注"});
											for(GradeBean grade:results) {
												model.addRow(new Object[] {grade.getId(),grade.getStudentName(),grade.getStudentClass(),grade.getTestSubject(),grade.getScore(),grade.getTestTime(),grade.getRemark()}); 		
											}
											studentGradeTable.setModel(model);
											studentGradeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
											
											scrollPane.setViewportView(studentGradeTable);
											Dimension size = WindowUtil.getSize();
											scrollPane.setLocation(0, 0);
											
											scrollPane.setSize(size.width,size.height-100);
											
											
											
											
											JButton returnButton = new JButton("返回");				 	 
											returnButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
											
											frame.add(returnButton);
											returnButton.setBounds(300,220,80,35);
											
											returnButton.addActionListener(new ActionListener() {
												
												@Override
												public void actionPerformed(ActionEvent arg0) {
													// TODO Auto-generated method stub
													frame.setVisible(false);
													
												}
											});
											
											JButton changeButton = new JButton("修改");
											changeButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
											
											frame.add(changeButton);
											changeButton.setBounds(150,220,80,35);
											
											changeButton.addActionListener(new ActionListener() {
												
												@Override
												public void actionPerformed(ActionEvent arg0) {
													// TODO Auto-generated method stub
													int selectRow = studentGradeTable.getSelectedRow();
													if(selectRow<0) {
														JOptionPane.showMessageDialog(frame, "请选择需要修改的行","Waring",JOptionPane.WARNING_MESSAGE);
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
																	JFrame jfrm = new JFrame("修改成绩单");
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
								JO.showMessageDialog(null, "无符合条件");
							}
						}
					}
				});
				 
				 JButton clearButton = new JButton("清空");
				 //省略事件处理相关代码
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
				 
				 
				 clearButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 buttonPanel.add(clearButton);
				 
				 
				 JButton returnButton = new JButton("返回");				 	 
				 returnButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
				//省略事件的代码
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
        
        JMenuItem qureyGradeMenuItem = new JMenuItem("查询成绩单");
        //省略事件处理相关代码
        qureyGradeMenuItem.setFont(new Font("微软雅黑",Font.PLAIN,15));
        gradeManagementMenu.add(qureyGradeMenuItem);
        qureyGradeMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				jfrm.setVisible(false);
				JFrame contentFrame = new JFrame("查询成绩单");
				//设为可见
				contentFrame.setVisible(true);
				//位置设为正中
				contentFrame.setLocation(WindowUtil.getLocation());
		        
				//设置窗口大小
				contentFrame.setSize(WindowUtil.getSize());
				//生成面板
		        JPanel contentPane = new JPanel();
		        //获取contentPane面板布局
		        FlowLayout flowLayout_0 = (FlowLayout) contentPane.getLayout();
		        flowLayout_0.setAlignment(FlowLayout.LEFT);					//左对齐
		        contentPane.setBounds(0, 0, 484,150);
		        contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
		        contentFrame.add(contentPane);
		        
				 JPanel studentInfoPanel = new JPanel();
				 studentInfoPanel.setBounds(0,0,484,46);
				 //studentInfoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
				 
				 FlowLayout flowLayout = (FlowLayout) studentInfoPanel.getLayout();
				 //获得面板布局
				 flowLayout.setAlignment(FlowLayout.LEFT); 		//设置面板中的控件按左对齐
				 contentPane.add(studentInfoPanel);				//应用面板
				
				 JLabel studentNameLabel = new JLabel("学生姓名：");			//创建标签
				 studentNameLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 studentInfoPanel.add(studentNameLabel);
				 
				 JTextField studentNameTextField = new JTextField();				//创建文本框
				 studentNameTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 studentInfoPanel.add(studentNameTextField);
				 studentNameTextField.setColumns(10);
				 
				 JLabel studentClassLabel = new JLabel("学生班级：");
				 studentClassLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 studentInfoPanel.add(studentClassLabel);
				 
				 JTextField studentClassTextField = new JTextField();
				 studentClassTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 studentInfoPanel.add(studentClassTextField);
				 studentClassTextField.setColumns(10);
				 
				 
				 JPanel testInfoPanel = new JPanel();
				 testInfoPanel.setBounds(0, 58, 484, 89);
				 //testInfoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
				 
				 FlowLayout flowLayout_1 = (FlowLayout) testInfoPanel.getLayout();
				 flowLayout_1.setAlignment(FlowLayout.LEFT); 					//设置面板中的控件按左对齐排列
				 contentPane.add(testInfoPanel);
				 
				 JLabel testSubjectLabel = new JLabel("考试科目：");
				 testSubjectLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 testInfoPanel.add(testSubjectLabel);
				 
				 JTextField testSubjectTextField = new JTextField();
				 testSubjectTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 testInfoPanel.add(testSubjectTextField);
				 testSubjectTextField.setColumns(10);
				 
				 JLabel scoreLabel = new JLabel("考试成绩：");
				 scoreLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 testInfoPanel.add(scoreLabel);
				 
				 JTextField scoreTextField = new JTextField();
				 scoreTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 testInfoPanel.add(scoreTextField);
				 scoreTextField.setColumns(10);
				 
				 /*	设置测试面板
				  *
				  * */
				 JPanel testTimePanel = new JPanel();
				 contentPane.add(testTimePanel);
				 
				 
				 
				 
				 JLabel testTimeLabel = new JLabel("考试时间：");
				 testTimeLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 testTimePanel.add(testTimeLabel );
				 
				
				 JTextField testTimeTextField = new JTextField();
				 testTimeTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 //testTimeTextField.setText("样例：2020-10-20");
				 testTimePanel.add(testTimeTextField);
				 testTimeTextField.setColumns(10);
				 
				 JPanel remarkPanel = new JPanel();
				//remarkPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
				 FlowLayout flowLayout_2 = (FlowLayout) remarkPanel.getLayout();
				 flowLayout_2.setAlignment(FlowLayout.LEFT);
				 
				 remarkPanel.setBounds(0, 159, 484, 46);
				 contentPane.add(remarkPanel);
				 
				 JLabel remarkLabel = new JLabel("备注：");
				 remarkLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 remarkPanel.add(remarkLabel);
				 
				 JTextField remarkTextField = new JTextField();
				 remarkTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 remarkPanel.add(remarkTextField);
				 remarkTextField.setColumns(29);
				 
				 
				 JPanel buttonPanel = new JPanel();			//创建面板
				 //buttonPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
				
				 buttonPanel.setBounds(0, 217, 484, 48);
				 contentPane.add(buttonPanel,BorderLayout.SOUTH);
				 
				 FlowLayout flowLayout3 = new FlowLayout();
				 flowLayout3.setAlignment(FlowLayout.RIGHT);
				 
				
				
				
				 JButton CheckButton = new JButton("查询");
				 //省略事件处理相关代码
				 CheckButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
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
						//System.out.println("清空按钮");
						
						
						//jfrm.setVisible(false);
						
						if(StudentName.isEmpty()&&StudentClass.isEmpty()&&TestTime.isEmpty()&&TestTime.isEmpty()&&Score.isEmpty()&&TestSubject.isEmpty())
						{	
							JOptionPane JO = new JOptionPane();
							JO.showMessageDialog(null, "查询条件不能为空", "WARNING", JOptionPane.ERROR_MESSAGE);
							JO.setFont(new Font("微软雅黑",Font.PLAIN,15));
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
											
											JFrame jfrm = new JFrame("查询结果");
											
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
											
											studentGradeTable.setFont(new Font("微软雅黑",Font.PLAIN,15));
											studentGradeTable.setRowHeight(25);
											JTableHeader header = studentGradeTable.getTableHeader();
											header.setFont(new Font("微软雅黑",Font.PLAIN,15));
											header.setPreferredSize(new Dimension(header.getWidth(),50));
											
											
											
											DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
											renderer.setHorizontalAlignment(SwingConstants.CENTER);
											
											DefaultTableModel model = (DefaultTableModel) studentGradeTable.getModel();
											model.setRowCount( 0); 		//清空表格中的数据
											model.setColumnIdentifiers(new Object[] {"学生姓名","学生班级","考试科目","考试成绩","考试时间","备注"});
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
								JO.showMessageDialog(null, "无符合条件");
							}
						}
					}
				});
				 
				 JButton clearButton = new JButton("清空");
				 //省略事件处理相关代码
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
				 
				 
				 clearButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 buttonPanel.add(clearButton);
				 
				 
				 JButton returnButton = new JButton("返回");				 	 
				 returnButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
				//省略事件的代码
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
        
        
        
        JMenuItem deleteGradeMenuItem = new JMenuItem("删除成绩单");
        //省略事件处理相关代码
        deleteGradeMenuItem.setFont(new Font("微软雅黑",Font.PLAIN,15));
        gradeManagementMenu.add(deleteGradeMenuItem);
        deleteGradeMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				jfrm.setVisible(false);
				JFrame contentFrame = new JFrame("查询成绩单");
				
				
				
				
				
				
				
				
				//设为可见
				contentFrame.setVisible(true);
				//位置设为正中
				contentFrame.setLocation(WindowUtil.getLocation());
		        
				//设置窗口大小
				contentFrame.setSize(WindowUtil.getSize());
				//生成面板
		        JPanel contentPane = new JPanel();
		        //获取contentPane面板布局
		        FlowLayout flowLayout_0 = (FlowLayout) contentPane.getLayout();
		        flowLayout_0.setAlignment(FlowLayout.LEFT);					//左对齐
		        contentPane.setBounds(0, 0, 484,150);
		        contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
		        contentFrame.add(contentPane);
		        
				 JPanel studentInfoPanel = new JPanel();
				 studentInfoPanel.setBounds(0,0,484,46);
				 //studentInfoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
				 
				 FlowLayout flowLayout = (FlowLayout) studentInfoPanel.getLayout();
				 //获得面板布局
				 flowLayout.setAlignment(FlowLayout.LEFT); 		//设置面板中的控件按左对齐
				 contentPane.add(studentInfoPanel);				//应用面板
				 
				 
				 
				 
				 JLabel studentNameLabel = new JLabel("学生姓名：");			//创建标签
				 studentNameLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 studentInfoPanel.add(studentNameLabel);
				 
				 JTextField studentNameTextField = new JTextField();				//创建文本框
				 studentNameTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 studentInfoPanel.add(studentNameTextField);
				 studentNameTextField.setColumns(10);
				 
				 JLabel studentClassLabel = new JLabel("学生班级：");
				 studentClassLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 studentInfoPanel.add(studentClassLabel);
				 
				 JTextField studentClassTextField = new JTextField();
				 studentClassTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 studentInfoPanel.add(studentClassTextField);
				 studentClassTextField.setColumns(10);
				 
				 
				 JPanel testInfoPanel = new JPanel();
				 testInfoPanel.setBounds(0, 58, 484, 89);
				 //testInfoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
				 
				 FlowLayout flowLayout_1 = (FlowLayout) testInfoPanel.getLayout();
				 flowLayout_1.setAlignment(FlowLayout.LEFT); 					//设置面板中的控件按左对齐排列
				 contentPane.add(testInfoPanel);
				 
				 JLabel testSubjectLabel = new JLabel("考试科目：");
				 testSubjectLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 testInfoPanel.add(testSubjectLabel);
				 
				 JTextField testSubjectTextField = new JTextField();
				 testSubjectTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 testInfoPanel.add(testSubjectTextField);
				 testSubjectTextField.setColumns(10);
				 
				 JLabel scoreLabel = new JLabel("考试成绩：");
				 scoreLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 testInfoPanel.add(scoreLabel);
				 
				 JTextField scoreTextField = new JTextField();
				 scoreTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 testInfoPanel.add(scoreTextField);
				 scoreTextField.setColumns(10);
				 
				 /*	设置测试面板
				  *
				  * */
				 JPanel testTimePanel = new JPanel();
				 contentPane.add(testTimePanel);
				 
				 
				 
				 
				 JLabel testTimeLabel = new JLabel("考试时间：");
				 testTimeLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 testTimePanel.add(testTimeLabel );
				 
				
				 JTextField testTimeTextField = new JTextField();
				 testTimeTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 //testTimeTextField.setText("样例：2020-10-20");
				 testTimePanel.add(testTimeTextField);
				 testTimeTextField.setColumns(10);
				 
				 JPanel remarkPanel = new JPanel();
				//remarkPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
				 FlowLayout flowLayout_2 = (FlowLayout) remarkPanel.getLayout();
				 flowLayout_2.setAlignment(FlowLayout.LEFT);
				 
				 remarkPanel.setBounds(0, 159, 484, 46);
				 contentPane.add(remarkPanel);
				 
				 JLabel remarkLabel = new JLabel("备注：");
				 remarkLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 remarkPanel.add(remarkLabel);
				 
				 JTextField remarkTextField = new JTextField();
				 remarkTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 remarkPanel.add(remarkTextField);
				 remarkTextField.setColumns(29);
				 
				 
				 JPanel buttonPanel = new JPanel();			//创建面板
				 //buttonPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
				
				 buttonPanel.setBounds(0, 217, 484, 48);
				 contentPane.add(buttonPanel,BorderLayout.SOUTH);
				 
				 FlowLayout flowLayout3 = new FlowLayout();
				 flowLayout3.setAlignment(FlowLayout.RIGHT);
				 
				
				
				
				 JButton CheckButton = new JButton("查询");
				 //省略事件处理相关代码
				 CheckButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
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
						//System.out.println("清空按钮");
						
						
						//jfrm.setVisible(false);
						
						if(StudentName.isEmpty()&&StudentClass.isEmpty()&&TestTime.isEmpty()&&TestTime.isEmpty()&&Score.isEmpty()&&TestSubject.isEmpty())
						{	
							JOptionPane JO = new JOptionPane();
							JO.showMessageDialog(null, "查询条件不能为空", "WARNING", JOptionPane.ERROR_MESSAGE);
							JO.setFont(new Font("微软雅黑",Font.PLAIN,15));
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
											System.out.println("查询结果");
											JFrame frame = new JFrame("查询结果");
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
											
											studentGradeTable.setFont(new Font("微软雅黑",Font.PLAIN,15));
											studentGradeTable.setRowHeight(25);
											
											
											JTableHeader header = studentGradeTable.getTableHeader();
											header.setFont(new Font("微软雅黑",Font.PLAIN,15));
											header.setPreferredSize(new Dimension(header.getWidth(),50));
																						
											DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
											renderer.setHorizontalAlignment(SwingConstants.CENTER);
											
											DefaultTableModel model = (DefaultTableModel) studentGradeTable.getModel();
											model.setRowCount( 0); 		//清空表格中的数据
											model.setColumnIdentifiers(new Object[] {"编号","学生姓名","学生班级","考试科目","考试成绩","考试时间","备注"});
											
											for(GradeBean grade:results) {
												model.addRow(new Object[] {grade.getId(),grade.getStudentName(),grade.getStudentClass(),grade.getTestSubject(),grade.getScore(),grade.getTestTime(),grade.getRemark()}); 		
											}
											
											studentGradeTable.setModel(model);
											studentGradeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
											
											scrollPane.setViewportView(studentGradeTable);
											Dimension size = WindowUtil.getSize();
											scrollPane.setLocation(0, 0);
											
											scrollPane.setSize(size.width,size.height-100);
											
											
											
											
											JButton returnButton = new JButton("返回");				 	 
											returnButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
											
											frame.add(returnButton);
											returnButton.setBounds(300,220,80,35);
											
											returnButton.addActionListener(new ActionListener() {
												
												@Override
												public void actionPerformed(ActionEvent arg0) {
													// TODO Auto-generated method stub
													frame.setVisible(false);
													
												}
											});
											
											JButton DeleteButton = new JButton("删除");
											DeleteButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
											
											//将删除按钮，添加进入窗口
											frame.add(DeleteButton);
											DeleteButton.setBounds(150,220,80,35);
											
											DeleteButton.addActionListener(new ActionListener() {
												
												@Override
												public void actionPerformed(ActionEvent arg0) {
													// TODO Auto-generated method stub
													int selectRow = studentGradeTable.getSelectedRow();
													if(selectRow<0) {
														JOptionPane.showMessageDialog(frame, "请选择需要删除的行","Waring",JOptionPane.WARNING_MESSAGE);
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
														int DeleteResult = JOptionPane.showConfirmDialog(frame, "确定删除","提示",JOptionPane.YES_NO_CANCEL_OPTION);
														
														if(DeleteResult == JOptionPane.YES_OPTION) {
															JdbcHelper.delete(frame,Grade);
															/*将表格更新*/
															
															System.out.println(selectRow);
															
															model.removeRow(selectRow); 		//将删掉的那一行数据移除
															
															
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
								JO.showMessageDialog(null, "无符合条件");
							}
						}
					}
				});
				 
				 JButton clearButton = new JButton("清空");
				 //省略事件处理相关代码
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
				 
				 
				 clearButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
				 buttonPanel.add(clearButton);
				 
				 
				 JButton returnButton = new JButton("返回");				 	 
				 returnButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
				//省略事件的代码
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
        
        
        
        
        
        JMenuItem notepadMenuItem = new JMenuItem("记事本");
        //省略事件处理相关代码
        notepadMenuItem.setFont(new Font("微软雅黑",Font.PLAIN,15));
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
        
        JMenuItem calculatorMenuItem = new JMenuItem("计算器");
        //省略事件处理相关代码
        calculatorMenuItem.setFont(new Font("微软雅黑",Font.PLAIN,15));
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

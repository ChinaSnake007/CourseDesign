package CourseDesign;

public class GradeBean {
	private int id;						//�ɼ����
	private	String studentName;			//ѧ������
	private String studentClass;		//ѧ���༶
	private String testSubject;			//���Կ�Ŀ
	private String score;				//���Գɼ�
	private String testTime;			//����ʱ��
	private String remark;				//��ע
	public GradeBean(String StudentName,String StudentClass,String TestSubject,String Score,String TestTime,String Remark) {
		studentName = StudentName;
		studentClass = StudentClass;
		testSubject = TestSubject;
		score = Score;
		testTime = TestTime;
		remark = Remark;
	}
	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public String getStudentName(){
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName=studentName;
	}
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass=studentClass;
	}
	public String getTestSubject() {
		return testSubject;
	}
	public void setTestSubject(String testSubject) {
		this.testSubject=testSubject;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score=score;
	}
	public String getTestTime() {
		return testTime;
	}
	public void setTestTime(String testTime) {
		this.testTime=testTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark=remark;
	}
}

package CourseDesign;

public class GradeBean {
	private int id;						//成绩编号
	private	String studentName;			//学生姓名
	private String studentClass;		//学生班级
	private String testSubject;			//考试科目
	private String score;				//考试成绩
	private String testTime;			//考试时间
	private String remark;				//备注
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

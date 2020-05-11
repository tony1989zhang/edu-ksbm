package net.xgf.pojo;

public class TbStudentExt{
	private String examdate;
	private String examtime;
	public String getExamdate() {
		return examdate;
	}
	public void setExamdate(String examdate) {
		this.examdate = examdate;
	}
	public String getExamtime() {
		return examtime;
	}
	public void setExamtime(String examtime) {
		this.examtime = examtime;
	}
	@Override
	public String toString() {
		return "TbStudentExt [examdate=" + examdate + ", examtime=" + examtime + "]";
	}
	
}

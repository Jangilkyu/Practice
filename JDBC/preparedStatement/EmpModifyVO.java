package Project;

public class EmpModifyVO {
	//자주 변경되는거 위주로
	
	private String Job;
	private int sal;
	private int comm;
	
	public EmpModifyVO() {

	}//EmpModifyVO

	public EmpModifyVO(String job, int sal, int comm) {
		Job = job;
		this.sal = sal;
		this.comm = comm;
	}//EmpModifyVO

	public String getJob() {
		return Job;
	}//getJob

	public void setJob(String job) {
		Job = job;
	}//setJob

	public int getSal() {
		return sal;
	}//getSal

	public void setSal(int sal) {
		this.sal = sal;
	}//setSal

	public int getComm() {
		return comm;
	}//getComm

	public void setComm(int comm) {
		this.comm = comm;
	}//setComm

	@Override
	public String toString() {
		return "EmpModifyVO [Job=" + Job + ", sal=" + sal + ", comm=" + comm + "]";
	}//toString
	

}//class

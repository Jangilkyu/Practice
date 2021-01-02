package Project;

public class EmpModifyVO {
	//자주 변경되는거 위주로
	
	private int sal;
	private int comm;
	
	public EmpModifyVO() {

	}//EmpModifyVO

	public EmpModifyVO(int sal, int comm) {
		this.sal = sal;
		this.comm = comm;
	}//EmpModifyVO

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	@Override
	public String toString() {
		return "EmpModifyVO [sal=" + sal + ", comm=" + comm + "]";
	}

	


}//class

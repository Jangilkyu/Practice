package Project;

public class EmpModifyVO {
	//���� ����Ǵ°� ���ַ�
	
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

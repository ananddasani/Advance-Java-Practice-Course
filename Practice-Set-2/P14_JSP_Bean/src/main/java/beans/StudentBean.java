package beans;

public class StudentBean {

	private String student_name;
	private String enrollment_no;
	private String mobile_no;
	private Integer cpi;

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getEnrollment_no() {
		return enrollment_no;
	}

	public void setEnrollment_no(String enrollment_no) {
		this.enrollment_no = enrollment_no;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public Integer getCpi() {
		return cpi;
	}

	public void setCpi(Integer cpi) {
		this.cpi = cpi;
	}

	@Override
	public String toString() {
		return "StudentBean [student_name=" + student_name + ", enrollment_no=" + enrollment_no + ", mobile_no="
				+ mobile_no + ", cpi=" + cpi + "]";
	}

}

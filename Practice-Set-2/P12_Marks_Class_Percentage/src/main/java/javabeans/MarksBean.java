package javabeans;

public class MarksBean {
	
	private Double percentage;
	private Class<?> classs;
	
	public Double getPercentage() {
		return percentage;
	}
	
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	
	public Class<?> getClasss() {
		return classs;
	}
	
	public void setClasss(Class<?> classs) {
		this.classs = classs;
	}
	
	@Override
	public String toString() {
		return "MarksBean [percentage=" + percentage + ", classs=" + classs + "]";
	}

}

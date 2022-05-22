package hbrnt_6_HQL_Queries.model;

public class AggregateResultModel {

    private long empCount;
    private double avgSalary;
    private long sumSalary;

    public AggregateResultModel() {
    }

    public AggregateResultModel(long empCount, double avgSalary, long sumSalary) {
        this.empCount = empCount;
        this.avgSalary = avgSalary;
        this.sumSalary = sumSalary;
    }

    public long getEmpCount() {
        return empCount;
    }

    public void setEmpCount(long empCount) {
        this.empCount = empCount;
    }

    public long getSumSalary() {
        return sumSalary;
    }

    public void setSumSalary(long sumSalary) {
        this.sumSalary = sumSalary;
    }

    public double getAvgSalary() {
        return avgSalary;
    }

    public void setAvgSalary(double avgSalary) {
        this.avgSalary = avgSalary;
    }

    @Override
    public String toString() {
        return "AggregateResultModel{" +
                "empCount=" + empCount +
                ", sumSalary=" + sumSalary +
                ", avgSalary=" + avgSalary +
                '}';
    }
}

package hbrnt_4_get_load;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "servlet_jdbc")
public class ModelClass {

    @Id
    @Column(name = "Enrollment_no")
    private int enrolment;

    @Column(name = "Sname")
    private String name;

    @Column(name = "Semester")
    private int sem;

    @Column(name = "Mobile_no")
    private String mobile;

    public ModelClass() {
    }

    public int getEnrolment() {
        return enrolment;
    }

    public void setEnrolment(int enrolment) {
        this.enrolment = enrolment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "StudentManagement{" +
                "enrolment=" + enrolment +
                ", name='" + name + '\'' +
                ", sem=" + sem +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}

package hbrnt_5_embedding_object;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Certificate {

    @Column(name = "course_name")
    private String courseName;

    private String duration;

    public Certificate() {
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "courseName='" + courseName + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}

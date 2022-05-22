package hbrnt_3_insert_image;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.Arrays;

@Entity
@Table(name = "hibernate_image")
public class Image_Hibernate {

    @Id
    private int id;

    @Lob
    private byte[] image;

    public Image_Hibernate() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Image_Hibernate{" +
                "id=" + id +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}

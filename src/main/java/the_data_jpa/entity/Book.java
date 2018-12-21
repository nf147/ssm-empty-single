package the_data_jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_book")
public class Book {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "t_name")
    private String name;
    private float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

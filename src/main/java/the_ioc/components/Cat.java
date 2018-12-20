package the_ioc.components;

import org.springframework.beans.factory.annotation.Autowired;

public class Cat {


    @Autowired
    private Image image;
    private String name;

    public Cat() {
        System.out.println("dfdf");
        this.name = image.getName();
        System.out.println(this.name);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package br.com.maratona.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Maratona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date age;
    @Column(nullable = false)
    private String sex;
    @Column(nullable = false)
    private String modality;
    private String description;
    @Column(nullable = false)
    private String badge;

    public Maratona() {

    }

    public Maratona(Long id, String name, String sex, String modality, String badge) {
        this.id = id;
        this.badge = badge;
        this.modality = modality;
        this.name = name;
        this.sex = sex;
    }

    public Maratona(String name, Date age, String sex, String modality, String description, String badge) {
        this.age = age;
        this.badge = badge;
        this.description = description;
        this.modality = modality;
        this.name = name;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getModality() {
        return modality;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

}

package io.ideahell.graduation.domain;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import io.ideahell.graduation.util.Names;
import io.ideahell.graduation.util.Randomizations;
import io.ideahell.graduation.util.Tables;

@Entity
@Inheritance
@Table(name = Tables.BUNNY)
@DiscriminatorColumn(name = "type")
public class Bunny implements Serializable {

    public enum Gender {
        MALE, FEMALE;
    }

    public enum Color {
        WHITE, BROWN, BLACK, SPOTTED;
    }

    @Id
    @GeneratedValue
    private Long id;

    protected String title;

    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Color color;

    public Bunny() {
        this.title = "Bunny";
        this.age = 0;
        this.color = Randomizations.rollEnum(Color.class);
        this.gender = Randomizations.rollEnum(Gender.class);
        this.name = Names.generate(gender);
    }

    public String getFullname() {
        return title + " " + name;
    }

    public int getLifespan() {
        return 10;
    }

    public boolean canBreed() {
        return age >= 2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}

package com.mrchoozy.demoboot.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlType(propOrder = {"hobby_name","complexity"})
public class Hobby {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "persons_id")
    private Person person;

    @Column
    private String hobby_name;

    @Column
    private int complexity;

    public Hobby(){}

    public Hobby(String hobby_name, int complexity) {
        this.hobby_name = hobby_name;
        this.complexity = complexity;
    }

    public String getHobby_name() {
        return hobby_name;
    }

    public void setHobby_name(String hobby_name) {
        this.hobby_name = hobby_name;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "hobby_name='" + hobby_name + '\'' +
                ", complexity=" + complexity +
                '}';
    }
}

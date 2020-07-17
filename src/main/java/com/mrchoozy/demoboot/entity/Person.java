package com.mrchoozy.demoboot.entity;


import com.mrchoozy.demoboot.entity.adapters.DateAdapter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="persons")
@XmlType(propOrder = {"name","birthday", "hobbyes"})
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column
    private String name;

    @Column
    private Date birthday;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Hobby> hobbyes = null;

    public Person(){}

    public Person(String name, Date date) {
        this.name = name;
        this.birthday = date;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", hobbyes=" + hobbyes +
                '}';
    }

    public void addHobby(String name, int complexity){
        if (hobbyes == null){
            hobbyes = new ArrayList<>();
            hobbyes.add(new Hobby(name, complexity));
        }else{
            hobbyes.add(new Hobby(name, complexity));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date date) {
        this.birthday = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "hobby")
    @XmlElementWrapper
    public List<Hobby> getHobbyes() {
        return hobbyes;
    }

    public void setHobbyes(List<Hobby> hobbyes) {
        this.hobbyes = hobbyes;
    }
}

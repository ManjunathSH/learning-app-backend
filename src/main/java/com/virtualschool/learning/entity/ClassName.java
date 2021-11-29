package com.virtualschool.learning.entity;

import javax.persistence.*;

// Can be omitted
@Entity
@Table(name = "CLASS")
public class ClassName {

    @Id
    @GeneratedValue
    @Column(name = "CLASS_ID")
    private Integer classId;

    @Column(name = "CLASS_NAME")
    private String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                '}';
    }
}

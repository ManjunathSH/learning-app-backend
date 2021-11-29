package com.virtualschool.learning.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "SUBJECT")
public class Subject {

    @Id
    @GeneratedValue
    @Column(name = "SUBJECT_ID")
    private Integer subjectId;

    @Column(name = "SUBJECT_NAME")
    private String subjectName;

    @Column(name = "CLASS")
    private String className;

    @OneToOne
    @JoinColumn(name="BOARD_ID", referencedColumnName = "BOARD_ID")
    private Board board;

    @OneToMany(mappedBy="subject")
    @JsonManagedReference(value = "chapter-subject")
    private Set<Chapter> chapters;

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Set<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(Set<Chapter> chapters) {
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", className='" + className + '\'' +
                ", board=" + board +
                ", chapters=" + chapters +
                '}';
    }
}

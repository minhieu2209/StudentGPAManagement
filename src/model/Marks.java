package model;

import java.io.Serializable;

public class Marks implements Serializable {
    private Student students;
    private Subject subjects;
    private float marks;

    public Marks() {
    }

    public Marks(Student student, Subject subjects, float marks) {
        this.students = student;
        this.subjects = subjects;
        this.marks = marks;
    }

    public Student getStudents() {
        return students;
    }

    public void setStudents(Student students) {
        this.students = students;
    }

    public Subject getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject subjects) {
        this.subjects = subjects;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "MarkSheet {" +
                " student = " + students +
                ", subjects = " + subjects +
                '}';
    }
}

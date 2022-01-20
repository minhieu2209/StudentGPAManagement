package controller;

import model.Student;
import model.Subject;

import java.io.*;

public class IOFile {
    // Write
    public void writeStudenttoFile(Student[] sa) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("STUDENT.DAT", true))) {
            outputStream.writeObject(sa);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void writeSubjecttoFile(Subject[] subA) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("SUBJECT.DAT", true))) {
            outputStream.writeObject(subA);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // READ
    public void readStudentFromFile() {
        Student[] sa = new Student[0];
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("STUDENT.DAT"))) {
            sa = (Student[]) inputStream.readObject();
        } catch (Exception e) {
            System.out.println(e);
        }
        for (Student s : sa) {
            System.out.println(s);
        }
    }

    public void readSubjectFromFile() {
        Subject[] subA = new Subject[0];
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("SUBJECT.DAT"))) {
            subA = (Subject[]) inputStream.readObject();
        } catch (Exception e) {
            System.out.println(e);
        }
        for (Subject sub : subA) {
            System.out.println(sub);
        }
    }
}

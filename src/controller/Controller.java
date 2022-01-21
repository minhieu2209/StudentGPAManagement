package controller;

import model.Marks;
import model.Student;
import model.Subject;

import java.util.Scanner;

public class Controller {
    private static Scanner in = new Scanner(System.in);
    private static int numSV;
    private static int numSub;
    private Student s = new Student();
    private static Student[] sa = new Student[0];
    private Subject sub = new Subject();
    private static Subject[] subA = new Subject[0];
    private IOFile IO = new IOFile();
    private static Marks[] marks = new Marks[20];

    public Student[] nhapSV() {
        String name, address, phoneNum, lop;
        try {
            System.out.print("Nhập số lượng sinh viên: ");
            this.numSV = in.nextInt();
            sa = new Student[numSV];
            in.nextLine();
            for (int i = 0; i < numSV; i++) {
                System.out.print("Nhập tên sinh viên: ");
                name = in.nextLine();
                System.out.print("Nhập địa chỉ: ");
                address = in.nextLine();
                System.out.print("Nhập số điện thoại: ");
                phoneNum = in.nextLine();
                System.out.print("Nhập lớp: ");
                lop = in.nextLine();
                Student s = new Student(0, name, address, phoneNum, lop);
                sa[i] = s;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return sa;
    }

    public Subject[] nhapSubject() {
        String name, lm;
        int soTinChi, loaiMon;
        String[] loai = {"Đại cương", " Cơ sở Ngành", "Chuyên ngành"};
        System.out.print("Nhập số môn học: ");
        this.numSub = in.nextInt();
        subA = new Subject[numSub];
        in.nextLine();
        for (int i = 0; i < numSub; i++) {
            System.out.print("Nhập tên môn: ");
            name = in.nextLine();
            System.out.print("Nhập số tín chỉ: ");
            soTinChi = in.nextInt();
            System.out.println("Nhập loại môn: ");
            do {
                System.out.println("1. Đại cương");
                System.out.println("2. Cơ sở ngành");
                System.out.println("3. Chuyên ngành");
                loaiMon = in.nextInt();
                in.nextLine();
            } while (loaiMon < 1 && loaiMon > 3);
            lm = loai[loaiMon - 1];
            sub = new Subject(0, name, soTinChi, lm);
            subA[i] = sub;
        }
        return subA;
    }

    public static Marks[] markSheet() {
        int countStudent = -1, countSubject = -1;
        countStudent = sa.length;
        countSubject = subA.length;
        float diem = -1;
        if (countStudent == 0 || countSubject == 0) {
            System.out.println("Chưa có thông tin sinh viên hoặc môn học!");
        } else {
            marks = new Marks[countStudent];
            for (int i = 0; i < countStudent; i++) {
                boolean check = false;
                Student tempStudent = sa[i];
                System.out.print("Nhập số môn học cho sinh viên " + tempStudent.getSid()+
                        " (sinh viên " + tempStudent.getName() + "): ");
                int slMonHoc;
                do {
                    slMonHoc = in.nextInt();
                    if (slMonHoc > countSubject) {
                        System.out.print("Nhập quá số lượng môn học!, nhập lại: ");
                        check = true;
                    } else if (slMonHoc < 1) {
                        System.out.print("Phải nhập ít nhất 1 môn học: ");
                        check = true;
                    } else
                        check = false;
                } while (check);
                Subject localSub[] = new Subject[slMonHoc];
                marks = new Marks[slMonHoc];
                Subject[] subTemps = new Subject[slMonHoc];
                boolean check1 = true;
                for (int j = 0; j < slMonHoc; j++) {
                    Subject checksub;
                    System.out.print("Nhập ID môn học: ");
                    do {
                        int id = in.nextInt();
                        checksub = searchForSubject(subA, id);
                        if (checksub != null) {
                            subTemps[j] = checksub;
                            if (countSubjects(subTemps, id) > 1) {
                                System.out.print("Môn học " + id + " đã có! Nhập môn khác!: ");
                                check1 = true;
                            } else {
                                check1 = false;
                            }
                        } else {
                            System.out.print("Nhập lại ID: ");
                            check1 = true;
                        }
                    } while (check1);
                    System.out.print("Nhập điểm của sinh viên: ");
                    do {
                        diem = in.nextFloat();
                        if (diem < 0 || diem > 10)
                            System.out.print("Điểm chỉ được trong đoạn[0,10]! Nhập lại: ");
                    } while (diem < 0 || diem > 10);
                    localSub[j] = checksub;
                    System.out.println("===========");
                }
                marks[i] = new Marks();

            }
        }
        return marks;
    }

    public void showMarks() {
        for (int i = 0; i < marks.length; i++) {
            System.out.println(marks[i].toString());
        }
    }

    public static Subject searchForSubject(Subject[] subjects, int name) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i].getIdSub() == name)
                return subjects[i];
        }
        return null;
    }

    public static int countSubjects(Subject[] subjects, int id) {
        int count = 0;
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                if (subjects[i].getIdSub() == id)
                    count++;
            }
        }
        return count;
    }
}

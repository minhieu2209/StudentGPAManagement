package controller;

import model.Student;
import model.Subject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice;
        Scanner in = new Scanner(System.in);
        Controller controller = new Controller();
        Student[] sa;
        Subject[] subA;
        IOFile io = new IOFile();
        do{
            System.out.println("===========MENU==========");
            System.out.println("1. Nhập danh sách sinh viên mới, in ra danh sách sinh viên sau khi nhập");
            System.out.println("2. Nhập danh sách môn học mới, in ra danh sách môn học sau khi nhập");
            System.out.println("3. Nhập điểm cho mỗi sinh viên và in danh sách ra màn hình");
            System.out.println("4. Sắp xếp bảng điểm theo họ tên sinh viên");
            System.out.println("5. Sắp xếp bảng điểm theo tên môn học");
            System.out.println("6. Tính điểm tổng kết cho mỗi sinh viên");
            System.out.println("0. Thoát!!!");
            choice = in.nextInt();
            switch(choice){
                case 0:
                    System.out.println("Tạm biệt!!!");
                    System.exit(0);
                    break;
                case 1:
                    sa = controller.nhapSV();
                    io.writeStudenttoFile(sa);
                    io.readStudentFromFile();
                    break;
                case 2:
                    subA = controller.nhapSubject();
                    io.writeSubjecttoFile(subA);
                    io.readSubjectFromFile();
                    break;
                case 3:
                    controller.markSheet();
                    break;
            }
        }while(choice != 0);

    }

}

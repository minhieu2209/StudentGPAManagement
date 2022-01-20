package model;

import java.io.Serializable;

public class Student implements Serializable {
   private static int sidS = 10000;
   private int sid;
   private String name;
   private String address;
   private String phoneNum;
   private String lop;

    public Student() {
    }

    public Student(int sid, String name, String address, String phoneNum, String lop) {
        if(sid == 0){
            this.sid = sidS++;
        }else this.sid = sid;
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.lop = lop;
    }

    public static int getSidS() {
        return sidS;
    }

    public static void setSidS(int sidS) {
        Student.sidS = sidS;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", lop='" + lop + '\'' +
                '}';
    }
}

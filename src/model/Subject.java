package model;

import java.io.Serializable;

public class Subject implements Serializable {
    private static int SidSub = 100;
    private int idSub;
    private String nameSub;
    private int soTinChi;
    private String typeSub;

    public Subject() {
    }

    public Subject(int idSub, String nameSub, int soTinChi, String typeSub) {
        if(idSub == 0){
            this.idSub = SidSub++;
        }else this.idSub = idSub;
        this.nameSub = nameSub;
        this.soTinChi = soTinChi;
        this.typeSub = typeSub;
    }

    public static int getSidSub() {
        return SidSub;
    }

    public static void setSidSub(int sidSub) {
        SidSub = sidSub;
    }

    public int getIdSub() {
        return idSub;
    }

    public void setIdSub(int idSub) {
        this.idSub = idSub;
    }

    public String getNameSub() {
        return nameSub;
    }

    public void setNameSub(String nameSub) {
        this.nameSub = nameSub;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public String getTypeSub() {
        return typeSub;
    }

    public void setTypeSub(String typeSub) {
        this.typeSub = typeSub;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "idSub=" + idSub +
                ", nameSub='" + nameSub + '\'' +
                ", soTinChi=" + soTinChi +
                ", typeSub='" + typeSub + '\'' +
                '}';
    }
}

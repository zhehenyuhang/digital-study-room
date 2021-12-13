package xyz.yuhang.pojo;

public class Studyroom {
    int id;
    String srid;
    int seatNumber;
    String academy;
    String academyName;


    public Studyroom() {
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSrid() {
        return srid;
    }

    public void setSrid(String srid) {
        this.srid = srid;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    @Override
    public String toString() {
        return "Studyroom{" +
                "id=" + id +
                ", srid='" + srid + '\'' +
                ", seatNumber=" + seatNumber +
                ", academy=" + academy +
                ", academyName='" + academyName + '\'' +
                '}';
    }
}

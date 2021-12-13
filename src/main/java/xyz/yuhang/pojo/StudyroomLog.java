package xyz.yuhang.pojo;

public class StudyroomLog {
    String srid;
    int seatNumber;
    int usIng;
    int nusIng;
    String timeId;
    String date;
    String academyName;

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
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

    public int getUsIng() {
        return usIng;
    }

    public void setUsIng(int usIng) {
        this.usIng = usIng;
    }

    public int getNusIng() {
        return nusIng;
    }

    public void setNusIng(int nusIng) {
        this.nusIng = nusIng;
    }

    public String getTimeId() {
        return timeId;
    }

    public void setTimeId(String timeId) {
        this.timeId = timeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "StudyroomLog{" +
                "srid='" + srid + '\'' +
                ", seatNumber=" + seatNumber +
                ", usIng=" + usIng +
                ", nusIng=" + nusIng +
                ", timeId='" + timeId + '\'' +
                ", date='" + date + '\'' +
                ", academyName='" + academyName + '\'' +
                '}';
    }
}

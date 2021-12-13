package xyz.yuhang.pojo;

public class StudentStudy {
    String studentId;
    String srid;
    String timeId;
    String date;
    int count;

    String studentName;

    public StudentStudy() {
    }

    public StudentStudy(String studentId, String srid, String timeId, String date, int count, String studentName) {
        this.studentId = studentId;
        this.srid = srid;
        this.timeId = timeId;
        this.date = date;
        this.count = count;
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSrid() {
        return srid;
    }

    public void setSrid(String srid) {
        this.srid = srid;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "StudentStudy{" +
                "studentId='" + studentId + '\'' +
                ", srid='" + srid + '\'' +
                ", timeId='" + timeId + '\'' +
                ", date='" + date + '\'' +
                ", count=" + count +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}

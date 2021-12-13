package xyz.yuhang.pojo;

public class Student {
    int id;
    String studentId;
    String studentName;

    public Student() {
    }

    public Student(int id, String studentId, String studentName) {
        this.id = id;
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}

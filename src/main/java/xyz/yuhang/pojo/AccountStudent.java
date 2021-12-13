package xyz.yuhang.pojo;

public class AccountStudent {
    String studentId;
    String studentNumber;
    String studentPassword;

    public AccountStudent() {
    }

    public AccountStudent(String studentId, String studentNumber, String studentPassword) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.studentPassword = studentPassword;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    @Override
    public String toString() {
        return "AccountStudent{" +
                "studentId='" + studentId + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", studentPassword='" + studentPassword + '\'' +
                '}';
    }
}

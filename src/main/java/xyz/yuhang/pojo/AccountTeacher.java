package xyz.yuhang.pojo;

public class AccountTeacher {
    String teacherId;
    String teacherNumber;
    String teacherPassword;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    @Override
    public String toString() {
        return "AccountTeacher{" +
                "teacherId='" + teacherId + '\'' +
                ", teacherNumber='" + teacherNumber + '\'' +
                ", teacherPassword='" + teacherPassword + '\'' +
                '}';
    }
}

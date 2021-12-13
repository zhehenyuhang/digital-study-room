package xyz.yuhang;

import xyz.yuhang.pojo.Student;
import xyz.yuhang.pojo.StudentStudy;
import xyz.yuhang.pojo.Studyroom;
import xyz.yuhang.service.StudentService;
import xyz.yuhang.service.StudyroomService;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class StudentStudyJdbc {
    public static void main(String[] args) {


    }

    public void play(){
        StudentService studentService = new StudentService();
        StudyroomService studyroomService = new StudyroomService();

        //1.获取所有学生Id
        List<Student> students = studentService.selectAllStudentName();
        String[] studentId = new String[students.size()];

        int i=0;
        for (Student student : students) {
            String studentIdd = student.getStudentId();
            studentId[i] = studentIdd;
            i++;
        }
        List studentId_list = new ArrayList();
        for (i = 0; i < studentId.length; i++) {
            studentId_list.add(studentId[i]);
        }

        //获取已有Id
        List<StudentStudy> StudentStudy = studentService.selectAllStudentNameStudentStudy();
        String[] studentId1 = new String[StudentStudy.size()];
        int ii=0;
        for (StudentStudy studentStudy : StudentStudy) {
            String studentIdd1 = studentStudy.getStudentId();
            studentId1[ii] = studentIdd1;
            ii++;
        }

        List studentIdend = new ArrayList();

        for (int js=0;js<studentId.length;js++){
            int flog = 0;
            for (int js1=0;js1<studentId1.length;js1++){
                if(studentId[js].equals(studentId1[js1])){
                    flog = 1;
                    break;
                }
            }
            if (flog == 0){
                studentIdend.add(studentId[js]);
            }
        }

        // System.out.println(studentIdend);

        //2.获取所有教室信息
        List<Studyroom> studyrooms = studyroomService.selectAllStudyroom();
        String[] srid = new String[studyrooms.size()];
        int j=0;
        for (Studyroom studyroom : studyrooms) {
            srid[j] = studyroom.getSrid();
            j++;
        }

        //获取已有教室
        List<Studyroom> studyrooms1 = studyroomService.selectAllStudyroomStudentStudy();
        String[] srid1 = new String[studyrooms1.size()];
        int jj=0;
        for (Studyroom studyroom : studyrooms1) {
            srid1[jj] =  studyroom.getSrid();
            jj++;
        }

        List sridend = new ArrayList();


        for (int js=0;js<srid.length;js++){
            int flog = 0;
            for (int js1=0;js1<srid1.length;js1++){
                if(srid[js].equals(srid1[js1])){
                    flog = 1;
                    break;
                }
            }
            if (flog == 0){
                sridend.add(srid[js]);
            }
        }
        String[] sridend_ = new String[sridend.size()];
        jj=0;
        for (Object o : sridend) {
            sridend_[jj] = (String) o;
            jj++;
        }



        //3.获取当前时间
        //1.获取当前时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Date date = new Date(System.currentTimeMillis());
        String strTime = new SimpleDateFormat("yyyy-MM-dd").format(date);
        int time = Integer.parseInt(strTime.replace("-",""));
        //4.次数归零
        // System.out.println(time);

        Boolean today = today(time);
        if (!today){
            addStudentStudy(studentId_list,srid,time);
        }else {
            addStudentStudy(studentIdend,srid,time);
            addStudentStudy(studentId_list,sridend_,time);
        }


    }

    public static Boolean today(int time){

        Connection connection = null;
        PreparedStatement pr = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = Timejdbc.getConnection();

            String sql = "select distinct date from student_study where date = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(time));
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Timejdbc.close(resultSet,preparedStatement,connection);
        }

        return false;
    }

    public static void addStudentStudy(List studentIdend,String[] srid,int time){

        Connection connection = null;
        PreparedStatement pr = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = Timejdbc.getConnection();

            String sql = "INSERT INTO student_study VALUES (?, ?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < studentIdend.size(); i++) {
                for (int j = 0; j < srid.length; j++) {
                    for (int k = 0; k < 3; k++) {
                        preparedStatement.setString(1, (String) studentIdend.get(i));
                        preparedStatement.setString(2, srid[j]);
                        preparedStatement.setString(3, String.valueOf(k+1));
                        preparedStatement.setString(4, String.valueOf(time));
                        preparedStatement.setString(5, String.valueOf(0));

                        preparedStatement.executeUpdate();
                    }
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Timejdbc.close(resultSet,preparedStatement,connection);
        }
    }
}

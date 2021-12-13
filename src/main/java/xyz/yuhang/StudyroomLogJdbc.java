package xyz.yuhang;



import xyz.yuhang.pojo.Studyroom;
import xyz.yuhang.service.StudyroomService;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class StudyroomLogJdbc {


    public void play(){
        //1.获取当前时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Date date = new Date(System.currentTimeMillis());
        String strTime = new SimpleDateFormat("yyyy-MM-dd").format(date);
        // String[] format = simpleDateFormat.format(date).split(" ");
        int time = Integer.parseInt(strTime.replace("-",""));


        //判断是否存在今日座位

        Boolean flog = today(time);

        if (!flog) {
            //2.以当前时间生成今天自习室座位表
            //  1.获取所有教室号，座位总数
            List studyroom = obtaindb();
            //        System.out.println(studyroom);

            //  3.每个教室生成三行数据列对应三个时间段
            generatedb(time, studyroom);
        }
        // }else {
        //
        //     StudyroomService studyroomService = new StudyroomService();
        //     List<Studyroom> studyrooms = studyroomService.selectAllStudyroom();
        //
        //
        //
        //
        // }

    }

    public static Boolean today(int time){

        Connection connection = null;
        PreparedStatement pr = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = Timejdbc.getConnection();

            String sql = "select distinct date from studyroom_log where date = ?";
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
    public static List obtaindb(){
        List studyroom = new ArrayList();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = Timejdbc.getConnection();
            String sql = "SELECT * FROM all_studyroom";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                studyroom.add(resultSet.getString(4));
                studyroom.add(resultSet.getString(2));
                studyroom.add(resultSet.getString(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Timejdbc.close(resultSet,preparedStatement,connection);
        }
        return studyroom;
    }
    // public static

    public static void generatedb(int time,List studyroom){

        Connection connection = null;
        PreparedStatement pr = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = Timejdbc.getConnection();

            String sql = "INSERT INTO studyroom_log VALUES (?, ?, 0, ?, ?, ?,?)";
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < studyroom.size()/3; i++) {
                for (int j = 0; j < 3; j++) {
                    preparedStatement.setString(1, (String) studyroom.get(i*3+1));
                    preparedStatement.setString(2, (String) studyroom.get(i*3+2));
                    preparedStatement.setString(3, (String) studyroom.get(i*3+2));
                    preparedStatement.setString(4, String.valueOf(j+1));
                    preparedStatement.setString(5, String.valueOf(time));
                    preparedStatement.setString(6, (String) studyroom.get(i*3));

                    preparedStatement.executeUpdate();
                }
            }



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Timejdbc.close(resultSet,preparedStatement,connection);
        }
    }

    public void insert(String srid,String seatNumber,String acid){
        //1.获取当前时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Date date = new Date(System.currentTimeMillis());
        String strTime = new SimpleDateFormat("yyyy-MM-dd").format(date);
        // String[] format = simpleDateFormat.format(date).split(" ");
        int time = Integer.parseInt(strTime.replace("-",""));

        Connection connection = null;
        PreparedStatement pr = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = Timejdbc.getConnection();

            String sql = "INSERT INTO studyroom_log VALUES (?, ?, 0, ?, ?, ?,?)";
            preparedStatement = connection.prepareStatement(sql);

            for (int j = 0; j < 3; j++) {
                preparedStatement.setString(1, srid);
                preparedStatement.setString(2, seatNumber);
                preparedStatement.setString(3, seatNumber);
                preparedStatement.setString(4, String.valueOf(j+1));
                preparedStatement.setString(5, String.valueOf(time));
                preparedStatement.setString(6, acid);

                preparedStatement.executeUpdate();
            }




        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Timejdbc.close(resultSet,preparedStatement,connection);
        }
    }
}
package xyz.yuhang.mapper;

import org.apache.ibatis.annotations.*;
import xyz.yuhang.pojo.StudentStudy;

import java.util.List;

public interface DataMapper {

    @Select("select SUM(us_ing) FROM studyroom_log where date = #{time}")
    String selectDataUsing(int time);


    String selectDataUsingZhou(int time);


    String selectDataUsingYue(int time);

    @Update("UPDATE student_study set count = 1 WHERE srid=#{srid} and time_id = #{timeId} and date = #{date} and student_id = #{studentId}")
    void updateUsing(@Param("srid") String srid, @Param("timeId")String timeId,@Param("date") String date,@Param("studentId") String studentId);


    void updateStudyroomlog(@Param("srid") String srid, @Param("timeId")String timeId,@Param("date") String date);


    @Select("select sum(count) from student_study where student_id =#{studentId} and time_id = #{timeId} and date = #{date}")
    String selectByIdandTime(@Param("studentId") String  studentId,@Param("timeId") String timeId,@Param("date") String date);

    @Delete("UPDATE student_study set count = 0 WHERE srid=#{srid} and time_id = #{timeId} and date = #{date} and student_id = #{studentId}")
    void delectUsing(@Param("srid") String srid, @Param("timeId")String timeId,@Param("date") String date,@Param("studentId") String studentId);


    void delectStudyroomlog(@Param("srid") String srid, @Param("timeId")String timeId,@Param("date") String date);

    @Select("select count from student_study where student_id =#{studentId} and time_id = #{timeId} and date = #{date} and srid = #{srid}")
    String dselectByIdandTime(@Param("studentId") String  studentId,@Param("timeId") String timeId,@Param("date") String date,@Param("srid") String srid);


    @Select("select nus_ing from studyroom_log where srid = #{srid} and date = #{date} and time_id = #{timeId}")
    int selectByNusing(@Param("srid") String srid, @Param("timeId")String timeId,@Param("date") String date);

    @Select("select * from student_study WHERE student_id = #{studentId} and count = 1 and date = #{date}")
    @ResultMap("studentstudyResultMap")
    List<StudentStudy> selectByCount(@Param("studentId") String studentId,@Param("date") String date);
}

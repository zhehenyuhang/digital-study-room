package xyz.yuhang.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

}

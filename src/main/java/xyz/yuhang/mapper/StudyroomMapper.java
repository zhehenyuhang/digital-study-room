package xyz.yuhang.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import xyz.yuhang.pojo.Academy;
import xyz.yuhang.pojo.Studyroom;
import xyz.yuhang.pojo.StudyroomLog;
import xyz.yuhang.pojo.Teacher;

import java.awt.dnd.DragGestureEvent;
import java.util.List;

public interface StudyroomMapper {

    /**
     * 查询所有教室座位信息
     * @return
     */
    @Select("select * from studyroom_log where date = #{date}")
    @ResultMap("studyroomLogResultMap")
    List<StudyroomLog> studyroomLog(String date);

    /**
     * 查询所有教室号
     * @return
     */
    @Select("select srid from all_studyroom")
    List<Studyroom> selectAllStudyroom();

    /**
     * 查询所有教室号 StudentStudy
     * @return
     */
    @Select("select distinct srid from student_study")
    List<Studyroom> selectAllStudyroomStudentStudy();

    /**
     * 查询所有教室信息
     * @return
     */
    @Select("select * from all_studyroom")
    @ResultMap("studyroomResultMap")
    List<Studyroom> selectAll();


    /**
     * 查询所有学院名称
     * @return
     */
    @Select("select distinct academy_name from academy ")
    @ResultMap("academyResultMap")
    List<Academy> selectAcademyName();

    /**
     * 查询教室座位中的日期信息
     * @return
     */
    @Select("select distinct date from studyroom_log ")
    List<StudyroomLog> selectDate();

    /**
     * 查询教室座位中的教室信息
     * @return
     */
    @Select("select distinct srid from studyroom_log ")
    List<StudyroomLog> selectSrid();

    /**
     * 按需求多条件查询教室座位信息
     * @param srid
     * @param timeId
     * @param date
     * @return
     */
    List<StudyroomLog> SelectById(@Param("srid") String srid, @Param("timeId") String timeId,@Param("date") String date,@Param("academyName")String academyName);

    /**
     * 查询所有学院
     * @return
     */
    @Select("select * from academy")
    @ResultMap("academyResultMap")
    List<Academy> selectAllAcademy();


    /**
     * 查询所有教室信息
     * 和学院表关联查询
     * @return
     */
    List<Studyroom> selectStudyroom();

    /**
     * 按学院名判断学院是否已存在
     * @param academyName
     * @return
     */
    @Select("select * from academy where academy_name = #{academyName}")
    @ResultMap("academyResultMap")
    Academy selectByAcademy(String academyName);

    /**
     * 按name返回学院信息
     * @param id
     * @return
     */
    @Select("select * from academy where academy_name = #{id}")
    @ResultMap("academyResultMap")
    Academy selectByIdAcademy(String id);

    /**
     * 按Id返回学院信息
     * @param id
     * @return
     */
    @Select("select * from academy where id = #{id}")
    @ResultMap("academyResultMap")
    Academy selectByIdnAcademy(int id);

    /**
     * 按Id返回单个教室信息
     * @param id
     * @return
     */
    @Select("select * from all_studyroom where id = #{id}")
    @ResultMap("studyroomResultMap")
    Studyroom selectByIdsr(int id);

    /**
     * 添加学院
     * @param academyName
     */
    @Select("insert into academy values(null,#{academyName})")
    void addAcademy(String academyName);

    /**
     * 在教室表中查询是否存在有此学院ID的教室
     * @param id
     */
    @Select("select distinct academy from all_studyroom where academy = #{id}")
    Studyroom selectAcademy(int id);

    /**
     * 删除学院
     * @param id
     */
    @Select("delete from academy where id = #{id}")
    void deleteAcademy(int id);

    /**
     * 修改
     * @param academy
     */
    @Select("update academy set academy_name = #{academyName} where id =#{id};")
    void updataAcademy(Academy academy);


    @Select("update studyroom_log set acadmy_name = #{acname} where acadmy_name = #{academyName}")
    void updateAcademyNameStudyroomlog(String acname,String academyName);

    @Select("insert into all_studyroom values(null,#{srid},#{seatNumber},#{id})")
    void addStudyroom(@Param("srid") String srid,@Param("seatNumber") String seatNumber,@Param("id") String id);

    @Select("delete from all_studyroom WHERE id = #{id}")
    void deleteStudyroom(int id);


    @Select("delete from studyroom_log WHERE srid = #{srid}")
    void deleteBySridStudyroomlog(String srid);

    @Update("update all_studyroom set srid = #{srid}, Seat_number = #{seatNumber}, academy = #{acid} where id = #{id}")
    void updataStudyroom(@Param("id") String id,@Param("srid") String srid,@Param("seatNumber") String seatNumber,@Param("acid") String acid);


    /**
     * 修改学院改变log表
     * @param srid
     * @param seatNumber
     * @param academyName
     * @param ysrid
     * @param yseatNumber
     * @param yacademyName
     */
    @Update("update studyroom_log set srid = #{srid},academy_name=#{academyName},Seat_number=#{seatNumber},nus_ing=#{seatNumber}-us_ing where srid = #{ysrid} and Seat_number = #{yseatNumber} and academy_name=#{yacademyName}")
    void updateStudyroomLog(@Param("srid") String srid,@Param("seatNumber")int seatNumber,@Param("academyName")String academyName,@Param("ysrid") String ysrid,@Param("yseatNumber")int yseatNumber,@Param("yacademyName")String yacademyName);


    @Update("update studyroom_log set nus_ing=#{seatNumber}-us_ing where srid = #{srid} and Seat_number = #{seatNumber} and academy_name=#{academyName}")
    void updateStudyroomfLog(@Param("srid") String srid,@Param("seatNumber")int seatNumber,@Param("academyName")String academyName);

    /**
     * 模糊查询
     * @param academyName
     * @return
     */
    @Select("select * from academy where academy_name like #{academyName}")
    @ResultMap("academyResultMap")
    List<Academy> selectByname(String academyName);

    /**
     * 模糊查询
     * @param academyName
     * @return
     */
    @Select("select * from all_studyroom where srid like #{srid}")
    @ResultMap("studyroomResultMap")
    List<Studyroom> selectBynamestudyroom(String srid);

}


package xyz.yuhang.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import xyz.yuhang.pojo.AccountStudent;
import xyz.yuhang.pojo.AccountTeacher;
import xyz.yuhang.pojo.StudyroomLog;
import xyz.yuhang.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from all_teacher")
    @ResultMap("teacherResultMap")
    List<Teacher> selectAll();

    /**
     * 添加数据
     * @param teacher
     */
    @Select("insert into all_teacher values(null,#{teacherId},#{teacherName})")
    void add(Teacher teacher);

    @Select("insert into account_teacher values (#{teacherId},#{teacherId},#{teacherId})")
    void addAccount(String teacherId);
    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from all_teacher where id = #{id}")
    @ResultMap("teacherResultMap")
    Teacher selectById(int id);

    @Select("select * from account_teacher where Teacher_id = #{teacherId}")
    @ResultMap("accountTeacherResultMap")
    AccountTeacher selectByIdAccount(String studentId);

    /**
     * 修改
     * @param teacher
     */
    @Select("update all_teacher set Teacher_id = #{teacherId}, Teacher_name = #{teacherName} where id =#{id};")
    void updata(Teacher teacher);

    @Select("update account_teacher set Teacher_number = #{teacherNumber}, Teacher_password = #{teacherPassword} where Teacher_id = #{teacherId};")
    void updataAccount(AccountTeacher accountTeacher);
    /**
     * 删除
     * @param id
     */
    @Select("delete from all_teacher where id = #{id}")
    void delete(int id);

    @Select("delete from account_teacher where Teacher_id = #{teacherId}")
    void deleteAccount(String teacherId);

    /**
     * 根据用户名和密码查询数据
     * @param teacherNumber
     * @param teacherPassword
     * @return
     */
    @Select("select * from account_teacher where Teacher_number = #{teacherNumber} and Teacher_password = #{teacherPassword}")
    @ResultMap("accountTeacherResultMap")
    AccountTeacher login(@Param("teacherNumber") String teacherNumber, @Param("teacherPassword") String teacherPassword);

    /**
     * 根据唯一名和姓名查询数据
     * @param teacherId
     * @param teacherName
     * @return
     */
    @Select("select * from all_teacher where Teacher_id = #{teacherId} and Teacher_name = #{teacherName}")
    @ResultMap("teacherResultMap")
    Teacher loginadd(@Param("teacherId") String teacherId, @Param("teacherName") String teacherName);

    String teacherName(String teacherId);

    /**
     * 模糊查询
     * @param teacherName
     * @return
     */
    @Select("select * from all_teacher where Teacher_name like #{teacherName}")
    @ResultMap("teacherResultMap")
    List<Teacher> selectByname(String teacherName);


}

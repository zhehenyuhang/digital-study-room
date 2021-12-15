package xyz.yuhang.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import xyz.yuhang.StudentStudyJdbc;
import xyz.yuhang.pojo.AccountStudent;
import xyz.yuhang.pojo.Student;
import xyz.yuhang.pojo.StudentStudy;
import xyz.yuhang.pojo.Teacher;

import java.util.List;

public interface StudentMapper {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from all_student")
    @ResultMap("studentResultMap")
    List<Student> selectAll();

    /**
     * 添加数据
     * @param student
     */
    @Select("insert into all_student values(null,#{studentId},#{studentName})")
    void add(Student student);

    @Select("insert into account_student values(#{studentId},#{studentId},#{studentId})")
    void addAccount(String studentId);

    /**
     * 根据id查询学生表
     * @param id
     * @return
     */
    @Select("select * from all_student where id = #{id}")
    @ResultMap("studentResultMap")
    Student selectById(int id);

    /**
     * 按id查询学生登录信息
     * @param studentId
     * @return
     */
    @Select("select * from account_student where Student_id = #{studentId}")
    @ResultMap("accountStudentResultMap")
    AccountStudent selectByIdAccount(String studentId);

    /**
     * 修改学生信息
     * @param student
     */
    @Select("update all_student set Student_id = #{studentId}, Student_name = #{studentName} where id = #{id};")
    void updata(Student student);


    /**
     * 修改学生登录信息
     * @param accountStudent
     */
    @Select("update account_student set Student_number = #{studentNumber}, Student_password = #{studentPassword} where Student_id = #{studentId};")
    void updataAccount(AccountStudent accountStudent);

    /**
     * 删除
     * @param id
     */
    @Select("delete from all_student where id = #{id}")
    void delete(int id);

    @Select("delete from account_student where Student_id = #{studentId}")
    void deleteAccount(String studentId);


    @Select("select * from account_student where Student_number = #{studentNumber} and Student_password = #{studentPassword}")
    @ResultMap("accountStudentResultMap")
    AccountStudent login(@Param("studentNumber") String studentNumber,@Param("studentPassword") String studentPassword);


    /**
     * 查询所有学生Id
     * @return
     */
    @Select("select Student_id from all_student")
    @ResultMap("studentResultMap")
    List<Student> selectAllStudentName();

    /**
     * 查询所有学生Id StudentStudy
     * @return
     */
    @Select("select distinct Student_id from student_study")
    @ResultMap("StudentStudyResultMap")
    List<StudentStudy> selectAllStudentNameStudentStudy();



    /**
     * 模糊查询
     * @param teacherName
     * @return
     */
    @Select("select * from all_student where Student_name like #{studentName}")
    @ResultMap("studentResultMap")
    List<Student> selectByname(String studentName);

}

package xyz.yuhang.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import xyz.yuhang.StudentStudyJdbc;
import xyz.yuhang.mapper.StudentMapper;
import xyz.yuhang.mapper.TeacherMapper;
import xyz.yuhang.pojo.AccountStudent;
import xyz.yuhang.pojo.Student;
import xyz.yuhang.pojo.StudentStudy;
import xyz.yuhang.pojo.Teacher;
import xyz.yuhang.util.SqlSessionFactoryUtils;

import java.util.List;

public class StudentService {

    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();


    /**
     * 查询所有
     * @return
     */
    public List<Student> selectAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> students = mapper.selectAll();

        sqlSession.commit();

        return students;
    }

    /**
     * 添加信息
     * @param student
     */
    public void add(Student student){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        mapper.add(student);

        sqlSession.commit();

        sqlSession.close();
    }

    public void addAccount(String studentId){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        mapper.addAccount(studentId);

        sqlSession.commit();

        sqlSession.close();
    }

    /**
     * 按ID查询
     * @param id
     * @return
     */
    public Student selectById(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Student student = mapper.selectById(id);

        sqlSession.close();

        return student;
    }

    /**
     * 按id查询账户密码信息
     * @param studentId
     * @return
     */
    public AccountStudent selectByIdAccount(String studentId){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        AccountStudent accountStudent = mapper.selectByIdAccount(studentId);

        sqlSession.close();

        return accountStudent;

    }

    /**
     * 修改学生信息
     * @param student
     */
    public void updata(Student student){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        mapper.updata(student);

        sqlSession.commit();

        sqlSession.close();

    }

    /**
     * 修改学生登录信息
     * @param accountStudent
     */
    public void updataAccount(AccountStudent accountStudent){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        mapper.updataAccount(accountStudent);

        sqlSession.commit();

        sqlSession.close();

    }

    /**
     * 删除学生信息
     * @param id
     */
    public void delete(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        mapper.delete(id);

        sqlSession.commit();

        sqlSession.close();

    }

    public void deleteAccount(String studentId){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        mapper.deleteAccount(studentId);

        sqlSession.commit();

        sqlSession.close();

    }

    public AccountStudent login(String studentNumber,String studentPassword){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        AccountStudent accountStudent = mapper.login(studentNumber, studentPassword);

        sqlSession.close();

        return accountStudent;
    }

    /**
     * 查询所有学生Id
     * @return
     */
    public List<Student> selectAllStudentName(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> students = mapper.selectAllStudentName();

        sqlSession.close();

        return students;
    }

    /**
     * 获取StudentStudy的学生Id
     * @return
     */
    public List<StudentStudy> selectAllStudentNameStudentStudy(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<StudentStudy> StudentStudy = mapper.selectAllStudentNameStudentStudy();

        sqlSession.close();

        return StudentStudy;
    }


    public List<Student> selectByname(String studentName){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        studentName = "%"+studentName+"%";
        List<Student> students = mapper.selectByname(studentName);

        sqlSession.close();

        return students;
    }

}

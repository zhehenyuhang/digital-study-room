package xyz.yuhang.service;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import xyz.yuhang.mapper.TeacherMapper;
import xyz.yuhang.pojo.AccountTeacher;
import xyz.yuhang.pojo.Teacher;
import xyz.yuhang.util.SqlSessionFactoryUtils;

import java.util.List;

public class TeacherService {

    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询所有
     * @return
     */
    public List<Teacher> selectAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        List<Teacher> Teachers = mapper.selectAll();

        sqlSession.commit();

        return Teachers;
    }

    /**
     * 添加信息
     * @param Teacher
     */
    public void add(Teacher Teacher){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        mapper.add(Teacher);

        sqlSession.commit();

        sqlSession.close();
    }

    public void addAccount(String teacherId){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        mapper.addAccount(teacherId);

        sqlSession.commit();

        sqlSession.close();
    }

    /**
     * 按ID查询
     * @param id
     * @return
     */
    public Teacher selectById(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher Teacher = mapper.selectById(id);

        sqlSession.close();

        return Teacher;
    }

    public AccountTeacher selectByIdAccount(String teacherId){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        AccountTeacher accountTeacher = mapper.selectByIdAccount(teacherId);

        sqlSession.close();

        return accountTeacher;
    }

    /**
     * 修改学生信息
     * @param Teacher
     */
    public void updata(Teacher Teacher){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        mapper.updata(Teacher);

        sqlSession.commit();

        sqlSession.close();

    }

    public void updataAccount(AccountTeacher accountTeacher){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        mapper.updataAccount(accountTeacher);

        sqlSession.commit();

        sqlSession.close();
    }

    /**
     * 删除学生信息
     * @param id
     */
    public void delete(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        mapper.delete(id);

        sqlSession.commit();

        sqlSession.close();

    }

    public void deleteAccount(String teacherId){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        mapper.deleteAccount(teacherId);

        sqlSession.commit();

        sqlSession.close();
    }

    public AccountTeacher login(String teacherNumber, String teacherPassword){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        AccountTeacher accountTeacher = mapper.login(teacherNumber, teacherPassword);

        sqlSession.close();

        return accountTeacher;

    }

    public Teacher loginadd(String teacherId, String teacherName){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacher = mapper.loginadd(teacherId, teacherName);

        sqlSession.close();

        return teacher;

    }

    public String teacherName(String teacherId){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        String teacherName = mapper.teacherName(teacherId);

        sqlSession.close();

        return teacherName;
    }
}

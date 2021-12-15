package xyz.yuhang.service;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import xyz.yuhang.mapper.DataMapper;
import xyz.yuhang.pojo.StudentStudy;
import xyz.yuhang.util.SqlSessionFactoryUtils;

import java.util.List;

public class DataService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public String selectDataUsing(int time){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DataMapper mapper = sqlSession.getMapper(DataMapper.class);

        String i = mapper.selectDataUsing(time);

        sqlSession.close();

        return i;

    }

    public String selectDataUsingZhou(int time){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DataMapper mapper = sqlSession.getMapper(DataMapper.class);

        String i = mapper.selectDataUsingZhou(time);

        sqlSession.close();

        return i;

    }

    public String selectDataUsingYue(int time) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DataMapper mapper = sqlSession.getMapper(DataMapper.class);

        String i = mapper.selectDataUsingYue(time);

        sqlSession.close();

        return i;
    }

    public void updateUsing(String srid, String timeId, String date, Object studentId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DataMapper mapper = sqlSession.getMapper(DataMapper.class);

        mapper.updateUsing(srid, timeId, date, (String) studentId);

        sqlSession.commit();

        sqlSession.close();

    }

    public void updateStudyroomlog(String srid, String timeId, String date) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DataMapper mapper = sqlSession.getMapper(DataMapper.class);

        mapper.updateStudyroomlog(srid,timeId,date);

        sqlSession.commit();

        sqlSession.close();
    }

    public String selectByIdandTime(Object studentId,String timeId, String date){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DataMapper mapper = sqlSession.getMapper(DataMapper.class);

        String i = mapper.selectByIdandTime((String) studentId, timeId, date);

        sqlSession.close();

        return i;

    }
    public void delectUsing(String srid, String timeId, String date, Object studentId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DataMapper mapper = sqlSession.getMapper(DataMapper.class);

        mapper.delectUsing(srid, timeId, date, (String) studentId);

        sqlSession.commit();

        sqlSession.close();

    }
    public void delectStudyroomlog(String srid, String timeId, String date) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DataMapper mapper = sqlSession.getMapper(DataMapper.class);

        mapper.delectStudyroomlog(srid,timeId,date);

        sqlSession.commit();

        sqlSession.close();
    }

    public String dselectByIdandTime(Object studentId,String timeId, String date,String srid){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DataMapper mapper = sqlSession.getMapper(DataMapper.class);

        String i = mapper.dselectByIdandTime((String) studentId, timeId, date,srid);

        sqlSession.close();

        return i;

    }


    public int selectByNusing(@Param("srid") String srid, @Param("timeId")String timeId,@Param("date") String date){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DataMapper mapper = sqlSession.getMapper(DataMapper.class);

        int s = mapper.selectByNusing(srid, timeId, date);

        sqlSession.close();

        return s;

    }

    public  List<StudentStudy> selectByCount( String studentId,  String date){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DataMapper mapper = sqlSession.getMapper(DataMapper.class);

        List<StudentStudy> studentStudies = mapper.selectByCount(studentId, date);

        sqlSession.close();

        return studentStudies;
    }


}

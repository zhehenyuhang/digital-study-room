package xyz.yuhang.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import xyz.yuhang.mapper.NoticeMapper;
import xyz.yuhang.mapper.StudentMapper;
import xyz.yuhang.pojo.Notice;
import xyz.yuhang.pojo.Student;
import xyz.yuhang.util.SqlSessionFactoryUtils;

import java.util.List;

public class NoticeService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();





    public void add(String notice){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);

        mapper.add(notice);

        sqlSession.commit();

        sqlSession.close();
    }

    public List<Notice> selectAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);

        List<Notice> notices = mapper.selectAll();

        sqlSession.close();

        return notices;
    }

    public void delect(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);

        mapper.delete(id);

        sqlSession.commit();

        sqlSession.close();

    }
}

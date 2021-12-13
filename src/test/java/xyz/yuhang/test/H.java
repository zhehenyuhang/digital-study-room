package xyz.yuhang.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import xyz.yuhang.mapper.DataMapper;
import xyz.yuhang.util.SqlSessionFactoryUtils;

import java.io.IOException;
import java.io.InputStream;

public class H {

    @Test
    public void ddd() {
        System.out.println(212);
    }

    @Test
    public void text() throws IOException {
        //获取SqlSessionFactoryF
        String resource = "mybatis-config.xml";//路径
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DataMapper mapper = sqlSession.getMapper(DataMapper.class);

        String i = mapper.selectDataUsingZhou(20211210);

        sqlSession.close();

        System.out.println(i);

    }
}

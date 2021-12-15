package xyz.yuhang.service;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import xyz.yuhang.mapper.StudentMapper;
import xyz.yuhang.mapper.StudyroomMapper;
import xyz.yuhang.mapper.TeacherMapper;
import xyz.yuhang.pojo.*;
import xyz.yuhang.util.SqlSessionFactoryUtils;

import java.util.List;

public class StudyroomService {

    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();


    public List<StudyroomLog> studyroomLog(String date){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudyroomMapper mapper = sqlSession.getMapper(StudyroomMapper.class);

        List<StudyroomLog> studyroomLogs = mapper.studyroomLog(date);

        sqlSession.close();

        return studyroomLogs;

    }

    public List<Studyroom> selectAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudyroomMapper mapper = sqlSession.getMapper(StudyroomMapper.class);

        List<Studyroom> studyrooms = mapper.selectAll();

        sqlSession.close();

        return studyrooms;

    }

    public List<StudyroomLog> selectDate(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudyroomMapper mapper = sqlSession.getMapper(StudyroomMapper.class);

        List<StudyroomLog> studyroomLogs = mapper.selectDate();

        sqlSession.close();

        return studyroomLogs;
    }

    public List<StudyroomLog> selectSrid(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudyroomMapper mapper = sqlSession.getMapper(StudyroomMapper.class);

        List<StudyroomLog> studyroomLogs = mapper.selectSrid();

        sqlSession.close();

        return studyroomLogs;
    }

    public List<StudyroomLog> SelectById(String srid,String timeId,String date,String academyName){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudyroomMapper mapper = sqlSession.getMapper(StudyroomMapper.class);

        List<StudyroomLog> studyroomLogs = mapper.SelectById(srid, timeId, date,academyName);

        sqlSession.close();

        return studyroomLogs;
    }

    public List<Academy> selectAllAcademy(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudyroomMapper mapper = sqlSession.getMapper(StudyroomMapper.class);

        List<Academy> academies = mapper.selectAllAcademy();

        sqlSession.close();

        return academies;
    }

    public List<Studyroom> selectStudyroom(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudyroomMapper mapper = sqlSession.getMapper(StudyroomMapper.class);

        List<Studyroom> studyrooms = mapper.selectStudyroom();

        sqlSession.close();

        return studyrooms;
    }

    public Academy selectByAcademy(String academyName){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudyroomMapper mapper = sqlSession.getMapper(StudyroomMapper.class);

        Academy academy = mapper.selectByAcademy(academyName);

        sqlSession.close();

        return academy;
    }

    public void addAcademy(String academyName){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudyroomMapper mapper = sqlSession.getMapper(StudyroomMapper.class);

        mapper.addAcademy(academyName);

        sqlSession.commit();

        sqlSession.close();
    }

    public void deleteAcademy(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudyroomMapper mapper = sqlSession.getMapper(StudyroomMapper.class);

        mapper.deleteAcademy(id);

        sqlSession.commit();

        sqlSession.close();
    }

    public Studyroom selectAcademy(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudyroomMapper mapper = sqlSession.getMapper(StudyroomMapper.class);

        Studyroom studyroom = mapper.selectAcademy(id);

        sqlSession.close();

        return studyroom;

    }

    public Academy selectByIdAcademy(String id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudyroomMapper mapper = sqlSession.getMapper(StudyroomMapper.class);

        Academy academy = mapper.selectByIdAcademy(id);

        sqlSession.close();

        return academy;
    }

    public Academy selectByIdnAcademy(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudyroomMapper mapper = sqlSession.getMapper(StudyroomMapper.class);

        Academy academy = mapper.selectByIdnAcademy(id);

        sqlSession.close();

        return academy;
    }

    public void updataAcademy(Academy academy){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudyroomMapper mapper = sqlSession.getMapper(StudyroomMapper.class);

        mapper.updataAcademy(academy);

        sqlSession.commit();

        sqlSession.close();
    }

    public List<Academy> selectAcademyName(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudyroomMapper mapper = sqlSession.getMapper(StudyroomMapper.class);

        List<Academy> academies = mapper.selectAcademyName();

        sqlSession.close();

        return academies;
    }

    public List<Studyroom> selectAllStudyroom(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudyroomMapper mapper = sqlSession.getMapper(StudyroomMapper.class);

        List<Studyroom> studyrooms = mapper.selectAllStudyroom();

        sqlSession.close();

        return studyrooms;
    }

    public List<Studyroom> selectAllStudyroomStudentStudy(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudyroomMapper mapper = sqlSession.getMapper(StudyroomMapper.class);

        List<Studyroom> studyrooms = mapper.selectAllStudyroomStudentStudy();

        sqlSession.close();

        return studyrooms;
    }

    public void addStudyroom(String srid, String seatNumber, String id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudyroomMapper mapper = sqlSession.getMapper(StudyroomMapper.class);

        mapper.addStudyroom(srid,seatNumber,id);

        sqlSession.commit();

        sqlSession.close();

    }

    public void deleteStudyroom(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudyroomMapper mapper = sqlSession.getMapper(StudyroomMapper.class);

        mapper.deleteStudyroom(id);

        sqlSession.commit();

        sqlSession.close();

    }

    public void deleteBySridStudyroomlog(String srid) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudyroomMapper mapper = sqlSession.getMapper(StudyroomMapper.class);

        mapper.deleteBySridStudyroomlog(srid);

        sqlSession.commit();

        sqlSession.close();

    }

    public Studyroom selectByIdsr(int parseInt) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudyroomMapper mapper = sqlSession.getMapper(StudyroomMapper.class);

        Studyroom studyroom = mapper.selectByIdsr(parseInt);

        sqlSession.close();

        return studyroom;
    }

    public void updataStudyroom(String id, String srid, String seatNumber, String acid) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudyroomMapper mapper = sqlSession.getMapper(StudyroomMapper.class);

        mapper.updataStudyroom(id,srid,seatNumber,acid);

        sqlSession.commit();

        sqlSession.close();

    }

    public void updateStudyroomLog(String srid,int seatNumber,String academyName,String ysrid,int yseatNumber, String yacademyName){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudyroomMapper mapper = sqlSession.getMapper(StudyroomMapper.class);

        mapper.updateStudyroomLog(srid,seatNumber,academyName,ysrid,yseatNumber,yacademyName);

        sqlSession.commit();
        sqlSession.close();
    }

    public void updateStudyroomfLog(String srid,int seatNumber,String academyName){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudyroomMapper mapper = sqlSession.getMapper(StudyroomMapper.class);

        mapper.updateStudyroomfLog(srid,seatNumber,academyName);

        sqlSession.commit();
        sqlSession.close();
    }


    public List<Academy> selectByname(String academyName){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudyroomMapper mapper = sqlSession.getMapper(StudyroomMapper.class);

        academyName = "%"+academyName+"%";
        List<Academy> academies = mapper.selectByname(academyName);

        sqlSession.close();

        return academies;
    }

    public List<Studyroom> selectBynamestudyroom(String srid){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudyroomMapper mapper = sqlSession.getMapper(StudyroomMapper.class);

        srid = "%"+srid+"%";
        List<Studyroom> studyrooms = mapper.selectBynamestudyroom(srid);

        sqlSession.close();

        return studyrooms;
    }


}

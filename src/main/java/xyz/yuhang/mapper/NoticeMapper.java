package xyz.yuhang.mapper;

import xyz.yuhang.pojo.Notice;

import java.util.List;

public interface NoticeMapper {

    /**
     * 添加通知
     * @param notice
     */
    void add(String notice);


    List<Notice> selectAll();

    void delete(int id);

}

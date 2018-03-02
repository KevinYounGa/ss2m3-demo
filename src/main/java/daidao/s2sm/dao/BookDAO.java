package daidao.s2sm.dao;

import daidao.s2sm.po.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
* Created by 13396091139@163.com on 2018-01-28 13:24:57.
* 图书数据访问接口
*/
public interface BookDAO {
/**
* 获得所有图书
*/
public List<Book> getAllBooks();
    /**
    * 根据图书编号获得图书对象
    */
    public Book getBookById(@Param("id") int id);
    /**
    * 添加图书
    */
    public int add(Book entity);
    /**
    * 根据图书编号删除图书
    */
    public int delete(int id);
    /**
    * 更新图书
    */
    public int update(Book entity);
    }
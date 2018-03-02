package daidao.s2sm.web;

import com.opensymphony.xwork2.ModelDriven;
import daidao.s2sm.dao.BookDAO;
import daidao.s2sm.po.Book;
import daidao.s2sm.service.CacheService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * Created by 13396091139@163.com on 2018-01-28 13:24:57
 * 测试Action
 */
@Component(value = "testAction")
@Scope(value = "prototype")
public class TestAction extends ActionSupport implements ModelDriven<Book> {
    @Autowired
    private BookDAO bookDao;
    private StringBuilder builder = new StringBuilder();
    @Autowired
    private CacheService cacheService;
    private Book book = new Book();
    private String result = "operation is success!!!!";
    HttpServletResponse response = ServletActionContext.getResponse();

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * 测试struts2 跳转是否成功
     *
     * @return
     */
    public String index() {
        result = "success!!!!";
        return SUCCESS;
    }

    /**
     * 测试数据库查询
     */
    public String testDatabase() {
        List<Book> list = bookDao.getAllBooks();
        if (list != null && list.size() == 0) {
            System.out.println("没有查询到数据-----");
        }
        for (Book tempBook :
                list) {
            builder.append(tempBook.toString()).append("\n");
        }
        result = builder.toString();
        return SUCCESS;
    }

    //testDatabase1
    public String testDatabase1() {
        int id = 1;
        Book book = bookDao.getBookById(id);
        if (book == null) {
            System.out.println("没有查询到数据-----");
        }
        builder.append(book.toString()).append("\n");
        result = builder.toString();
        return SUCCESS;
    }

    public String testCache() {
        String value = cacheService.testCache("helloworld");
        result = "---------cache success ----------";
        return SUCCESS;
    }

    /***
     * 测试sitemesh
     * @return
     */
    public String nositemesh() {
        return SUCCESS;
    }

    /**
     * 装载model
     *
     * @return
     */
    @Override
    public Book getModel() {
        return book;
    }
}
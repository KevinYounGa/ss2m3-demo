package daidao.s2sm.web;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class HelloWorldAction extends ActionSupport {
    private String name;

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String name = request.getParameter("name");
        System.out.println("Inside action....");
        System.out.println("name = " + name);
        return "success";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package daidao.s2sm.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        /* let us do some pre-processing */
        String output = "Pre-Processing";
        System.out.println(output);

        /* let us call action or next interceptor */
        String result = actionInvocation.invoke();

        /* let us do some post-processing */
        output = "Post-Processing";
        System.out.println(output);

        return result;
    }
}

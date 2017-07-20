package com.yu.autocoder.test;

import com.jfinal.core.Controller;
import com.yu.autocoder.sys.bean.User;


/**
 * Created by igreentree on 2017/7/19 0019.
 */
public class HelloController extends Controller {
    public void index() {
        User user = User.dao.findById("1500453530921");
        renderHtml("id:" + user.getId() + "<br/>" + "name:" + user.getName() + "<br/>" + "age:" + user.getAge());
    }
}

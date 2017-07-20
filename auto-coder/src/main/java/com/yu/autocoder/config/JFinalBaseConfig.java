package com.yu.autocoder.config;

import com.jfinal.config.*;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import com.yu.autocoder.sys.bean.User;
import com.yu.autocoder.test.HelloController;

/**
 * Created by igreentree on 2017/7/20 0020.
 */
public class JFinalBaseConfig extends JFinalConfig {
    public void configConstant(Constants constants) {
        //开启debug模式
        constants.setDevMode(true);
        System.out.println("configConstant");
    }

    public void configRoute(Routes routes) {
        System.out.println("configRoute");
        routes.add("/", HelloController.class);
        routes.add("/hello", HelloController.class);
    }

    public void configEngine(Engine engine) {
        System.out.println("configEngine");
    }

    public void configPlugin(Plugins plugins) {
        System.out.println("configPlugin");
        //连接数据库
        DruidPlugin dp = new DruidPlugin("jdbc:mysql://172.104.98.7/YuResource", "yu", "5227146");
        plugins.add(dp);
        //添加表和对象映射关系
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        plugins.add(arp);
        arp.addMapping("user", User.class);
    }

    public void configInterceptor(Interceptors interceptors) {
        System.out.println("configInterceptor");
    }

    public void configHandler(Handlers handlers) {
        System.out.println("configHandler");
    }
}

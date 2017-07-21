package com.yu.autocoder.config;

import com.jfinal.config.*;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import com.yu.jinal.plugin.ext.annotation.ControllerAnnotation;
import com.yu.jinal.plugin.ext.annotation.ModelAnnotationPlugin;


/**
 * Created by igreentree on 2017/7/20 0020.
 */
public class JFinalBaseConfig extends JFinalConfig {
    /**
     * model类扫描包
     */
    private final static String[] scanModelPackage = new String[]{
            "com.yu.autocoder"
    };
    /**
     * controller类扫描包
     */
    private final static String[] scanControllerPackage = new String[]{
            "com.yu.autocoder"
    };

    public void configConstant(Constants constants) {
        //开启debug模式
        constants.setDevMode(true);
        System.out.println("configConstant");
    }

    public void configRoute(final Routes routes) {
        System.out.println("configRoute");
        ControllerAnnotation controllerAnnotation = new ControllerAnnotation(scanControllerPackage,routes);
    }

    public void configEngine(Engine engine) {
        System.out.println("configEngine");
    }

    public void configPlugin(Plugins plugins) {
        System.out.println("configPlugin");
        //连接数据库
        DruidPlugin dp = new DruidPlugin("jdbc:mysql://172.104.98.7/YuResource", "yu", "5227146");
        plugins.add(dp);
        //建立表和对象映射关系对象
         ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        //添加表和对象映射关系，扫描@JFinalModel注解
        ModelAnnotationPlugin map = new ModelAnnotationPlugin(scanModelPackage, arp);
        plugins.add(map);
        plugins.add(arp);

    }

    public void configInterceptor(Interceptors interceptors) {
        System.out.println("configInterceptor");
    }

    public void configHandler(Handlers handlers) {
        System.out.println("configHandler");
    }
}

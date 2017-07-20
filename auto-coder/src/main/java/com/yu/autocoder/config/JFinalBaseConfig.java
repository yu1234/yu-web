package com.yu.autocoder.config;

import com.jfinal.config.*;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import com.yu.autocoder.sys.bean.User;
import com.yu.autocoder.test.HelloController;
import com.yu.tools.annotation.AnnotationScanReportImpl;
import com.yu.tools.annotation.AnnotationScanUtils;
import com.yu.tools.annotation.JFinalModel;

import java.lang.annotation.Annotation;

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
        //添加表和对象映射关系，扫描@JFinalModel注解
        final ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        plugins.add(arp);
        String[] scanPackage = new String[]{
                "com.yu.autocoder"
        };
        AnnotationScanUtils.scanAnnotationByClass(new Class[]{JFinalModel.class}, new AnnotationScanReportImpl() {
            public void report(Class<? extends Annotation> aClass, String s) {
                try {

                    Class<? extends Model<?>> modelClass = (Class<? extends Model<?>>) Class.forName(s);
                    JFinalModel jFinalModel = modelClass.getAnnotation(JFinalModel.class);
                    String tableName = jFinalModel.tableName();
                    arp.addMapping(tableName, (Class<? extends Model<?>>) Class.forName(s));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(s);
            }
        }, scanPackage);
    }

    public void configInterceptor(Interceptors interceptors) {
        System.out.println("configInterceptor");
    }

    public void configHandler(Handlers handlers) {
        System.out.println("configHandler");
    }
}

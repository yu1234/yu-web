package com.yu.tools.annotation;

import java.lang.annotation.*;

/**
 * Created by igreentree on 2017/7/20 0020.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JFinalModel {
     String tableName();
}

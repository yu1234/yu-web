package com.yu.tools.annotation;

import java.lang.annotation.Annotation;

/**
 * Created by igreentree on 2017/7/20 0020.
 */
public interface AnnotationScanReportImpl {
    void report(Class<? extends Annotation> aClass, String s);
}

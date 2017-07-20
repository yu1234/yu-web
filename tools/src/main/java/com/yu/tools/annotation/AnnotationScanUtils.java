package com.yu.tools.annotation;


import com.yu.tools.string.StringTools;
import eu.infomas.annotation.AnnotationDetector;
import org.junit.Test;

import java.io.IOException;
import java.lang.annotation.Annotation;

/**
 * Created by igreentree on 2017/7/20 0020.
 */
public class AnnotationScanUtils {


    public void scanAnnotation(final Class<? extends Annotation>[] annotationClasses, final AnnotationScanReportImpl report, String... scanPackage) {
        AnnotationDetector.Reporter reporter = new AnnotationDetector.TypeReporter() {
            public void reportTypeAnnotation(Class<? extends Annotation> aClass, String s) {
                report.report(aClass, s);
            }

            public Class<? extends Annotation>[] annotations() {
                return annotationClasses;
            }
        };
        AnnotationDetector cf = new AnnotationDetector(reporter);
        try {
            if (StringTools.isNotBlank(scanPackage)) {
                cf.detect(scanPackage);
            } else {
                cf.detect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

package com.yu.tools.collection;

import java.util.Collection;
import java.util.Map;

/**
 * Created by igreentree on 2017/7/20 0020.
 */
public class CollectionTools {
    /**
     * 判断Collectionj是否为空
     *
     * @param obj
     * @return
     */
    public static boolean isBlank(final Collection<?> obj) {
        return (obj == null) || obj.isEmpty();

    }

    public static boolean isNotBlank(final Collection<?> obj) {
        return !isBlank(obj);
    }
}

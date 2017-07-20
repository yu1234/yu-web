package com.yu.tools.object;

/**
 * Created by igreentree on 2017/7/20 0020.
 */
public class ObjectTools {
    /**
     * 判断对象是否为空
     */
    public static boolean isBlank(final Object obj) {
        return (obj == null);
    }

    public static boolean isNotBlank(final Object obj)
    {
        return !isBlank(obj);
    }

    public static boolean isNotBlankObjs(final Object... obj)
    {
        if(obj != null && obj.length > 0)
        {
            for (Object object : obj)
            {
                if(isBlank(object))
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * 判断数组是否为空
     * @param objs
     * @return
     */
    public static boolean isBlank(final Object[] objs) {
        return (objs == null) || (objs.length <= 0);
    }

    public static boolean isNotBlank(final Object[] objs)
    {
        return !isBlank(objs);
    }

}

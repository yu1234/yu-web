package com.yu.tools.Map;

import java.util.Map;

/**
 * Created by igreentree on 2017/7/20 0020.
 */
public class MapTools {
    /**
     * 判断Map是否为空
     * @param map
     * @return
     */
    public static boolean isBlank(final Map<?, ?> map) {
        return (map == null) || map.isEmpty();
    }

    public static boolean isNotBlank(final Map<?, ?> map)
    {
        return !isBlank(map);
    }
}

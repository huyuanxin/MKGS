package org.graduation.knowledge.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author huyuanxin
 */
public class ListUtil {

    /**
     * 对任意List进行去重,非String类型需要重写equals()和hashcode()
     *
     * @param list 需要去重的List
     * @param <T>  List的类型
     * @return 去重后的症状
     */
    public static <T> List<T> deleteRepeat(List<T> list) {
        return Optional.ofNullable(list)
                .map(it -> it.stream().distinct().collect(Collectors.toList()))
                .orElse(new ArrayList<>());
    }
}

package com.ds.utils;

import java.util.Collection;

public class CollectionUtils {

    private CollectionUtils() {
    }

    public static <T> boolean isValidIndex(Collection<T> collection, int index) {
        return NumberUtils.isInRangeStartInclusive(index, 0, collection.size());
    }

}

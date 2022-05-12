package util;

import types.Event;

public class Collection {

    public static Object[] remove(Object[] collection, int removeIndex) {

        // на базата на индекса - да елиминирам този елемент
        collection[removeIndex] = null;

        // да прехвърля всички останали елементи в нов масив
        Object[] temporalEventCollection = new Object[collection.length];
        int temporalIndex = 0;

        for(Object eventElement : collection) {

            if(eventElement != null) {
                temporalEventCollection[temporalIndex++] = eventElement;
            }
        }

        collection = temporalEventCollection;
        return collection;
    }
}

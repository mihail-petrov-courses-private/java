package util;

public class CustomCollectionUtil {

    public static Object[] copyCollection(Object[] collection) {

        int collectionLength = collection.length;
        Object[] newCollection = new Object[collectionLength];

        for(int i = 0; i < collectionLength; i++) {
            newCollection[i] = collection[i];
        }

        return newCollection;
    }

    // baseCollection.lenght > mergableCollection.length
    public static Object[] mergeCollections(Object[] baseCollection, Object[] mergableCollection) {

        Object[] newCollection = copyCollection(baseCollection);

        for(int i = 0; i < mergableCollection.length; i++) {
            newCollection[i] = mergableCollection[i];
        }
        return newCollection;
    }
}

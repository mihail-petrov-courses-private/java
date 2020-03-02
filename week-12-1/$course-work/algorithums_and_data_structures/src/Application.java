import collection_exception.NoElementOverThisIndexInCollection;
import data_structure.CustomArrayList;
import data_structure.CustomStack;
import search.BinarySearch;
import search.MinMaxSearch;
import search.Student;
import sort.BoobleSort;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Application {

    public static void main(String[] args) {
        // MinMaxSearch.run();
        // BoobleSort.run();

        int[] collection = new int[] {
                5,	4,	0,	0,	0,	0,	5,	7,	23,	8,	8,	4,	9,	0,	11,	3
        };


        Object sampleObject = new Object();
        ArrayList<Integer> collectionInteger = new ArrayList<>();

//        collectionInteger.add(10);
//        collectionInteger.add(10);
//        collectionInteger.add(10);
//        collectionInteger.add(10);
//        collectionInteger.add(10);
//        collectionInteger.add(10);
//        collectionInteger.add(10);
//        collectionInteger.add(10);
//        collectionInteger.add(10);
//        collectionInteger.add(10);
//        collectionInteger.add(5, 10);
        //collectionInteger.get(6666);


            CustomArrayList<Student> studentCollection = new CustomArrayList<>();
            studentCollection.add(new Student("Mihail1", 28));
            studentCollection.add(new Student("Mihail2", 28));
            studentCollection.add(new Student("Mihail3", 28));
            studentCollection.add(new Student("Mihail4", 28));
            studentCollection.add(new Student("Mihail5", 28));
            studentCollection.add(new Student("Mihail6", 28));
            studentCollection.add(new Student("Mihail7", 28));
            studentCollection.add(new Student("Mihail8", 28));
            studentCollection.add(new Student("Mihail9", 28));
            studentCollection.add(new Student("Mihail10", 28));
            studentCollection.add(new Student("Mihail11", 28));
            studentCollection.add(new Student("Mihail12", 28));
            studentCollection.add(new Student("Mihail13", 28));
            studentCollection.add(new Student("Mihail14", 28));
            studentCollection.add(new Student("Mihail15", 28));
            studentCollection.add(new Student("Mihail16", 28));
            studentCollection.add(new Student("Mihail17", 28));
            studentCollection.add(new Student("Mihail18", 28));
            studentCollection.add(new Student("Mihail19", 28));
            studentCollection.add(new Student("Mihail20", 28));
            studentCollection.add(new Student("Mihail21", 28));
//            System.out.println(studentCollection.size());
//            System.out.println(studentCollection.length());
//
//            System.out.println(((Student) studentCollection.getByIndex(25)));
//            System.out.println(((Student) studentCollection.getElementByIndex(25)));


        CustomStack studentStack = new CustomStack();
        studentStack.push(new Student("Mihail", 28));
        studentStack.push(new Student("Todor", 38));
        studentStack.push(new Student("Ivan", 48));
//        System.out.println(((Student)studentStack.pop()).name);
//        System.out.println(((Student)studentStack.pop()).age);
//        System.out.println(((Student)studentStack.pop()).age);
//        System.out.println(((Student)studentStack.pop()).age);

        while(studentStack.isEmpty() != true) {
            System.out.println(((Student)studentStack.pop()).name);
        }



        //ArrayList<Integer> listCollection = new ArrayList<Integer>();

        //Stack<Integer> stackExample = new Stack<>();

        //Queue<Integer> qExample = new PriorityQueue<>();






//        if(BinarySearch.doesExists(collection, 0)) {
//            System.out.print("YES");
//        }
//        else {
//            System.out.print("NO");
//        }
    }
}

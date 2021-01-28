import collection_exception.NoElementOverThisIndexInCollection;
import data_structure.CustomArrayList;
import data_structure.CustomLinkedList;
import data_structure.CustomQ;
import data_structure.CustomStack;
import search.BinarySearch;
import search.IStudent;
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
        ArrayList<Student> collectionInteger = new ArrayList<>();
        collectionInteger.add(new Student("Test", 28));

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

            // Everithing is object
            int number = 10;
            Integer number10Object = 10; // new Integer(10);
            Integer number20Object = 20;
            Integer finalNumber = number10Object + number20Object;
            System.out.println(finalNumber);
        System.out.println("**");

//            Object value = 10;

//            CustomArrayList<IStudent> studentCollection = new CustomArrayList();
            //studentCollection.add(10);
            //studentCollection.add(true);
            //studentCollection.add("TEST MEST");
            //studentCollection.add(10.5);
//            studentCollection.add(new Student("Mihail1", 28));
//            System.out.println(studentCollection.getElementByIndex(0).grade());


//            studentCollection.add(new Student("Mihail2", 28));
//            studentCollection.add(new Student("Mihail3", 28));
//            studentCollection.add(new Student("Mihail4", 28));
//            studentCollection.add(new Student("Mihail5", 28));
//            studentCollection.add(new Student("Mihail6", 28));
//            studentCollection.add(new Student("Mihail7", 28));
//            studentCollection.add(new Student("Mihail8", 28));
//            studentCollection.add(new Student("Mihail9", 28));
//            studentCollection.add(new Student("Mihail10", 28));
//            studentCollection.add(new Student("Mihail11", 28));
//            studentCollection.add(new Student("Mihail12", 28));
//            studentCollection.add(new Student("Mihail13", 28));
//            studentCollection.add(new Student("Mihail14", 28));
//            studentCollection.add(new Student("Mihail15", 28));
//            studentCollection.add(new Student("Mihail16", 28));
//            studentCollection.add(new Student("Mihail17", 28));
//            studentCollection.add(new Student("Mihail18", 28));
//            studentCollection.add(new Student("Mihail19", 28));
//            studentCollection.add(new Student("Mihail20", 28));
//            studentCollection.add(new Student("Mihail21", 28));
//
//            for (Student element : studentCollection) {
//
//            }


//            System.out.println(studentCollection.size());
//            System.out.println(studentCollection.length());
//
//            System.out.println(((Student) studentCollection.getByIndex(25)));
//            System.out.println(((Student) studentCollection.getElementByIndex(25)));


//        CustomStack studentStack = new CustomStack();
//        studentStack.push(new Student("Mihail", 28));
//        studentStack.push(new Student("Todor", 38));
//        studentStack.push(new Student("Ivan", 48));
//        System.out.println(((Student)studentStack.pop()).name);
//        System.out.println(((Student)studentStack.pop()).age);
//        System.out.println(((Student)studentStack.pop()).age);
//        System.out.println(((Student)studentStack.pop()).age);

//        while(studentStack.isEmpty() != true) {
//            System.out.println(((Student)studentStack.pop()).name);
//        }



        //ArrayList<Integer> listCollection = new ArrayList<Integer>();

        //Stack<Integer> stackExample = new Stack<>();

        //Queue<Integer> qExample = new PriorityQueue<>();

//        if(BinarySearch.doesExists(collection, 0)) {
//            System.out.print("YES");
//        }
//        else {
//            System.out.print("NO");
//        }

        // Q Examples
//        CustomQ customQCollection = new CustomQ();
//        customQCollection.enq(new Student("Mihail", 28));
//        customQCollection.enq(new Student("Todor", 38));
//        customQCollection.enq(new Student("Ivan", 48));
//
//        System.out.println(((Student)(customQCollection.deq())).name); // Mihaikl
//        System.out.println(((Student)(customQCollection.deq())).name); // Todor
//        System.out.println(((Student)(customQCollection.deq())).name); // Ivan
//
//        customQCollection.enq(new Student("Petar", 58));
//        System.out.println(((Student)(customQCollection.deq())).name); // Petar
//        System.out.println(customQCollection.getFrontIndex());
//        System.out.println(customQCollection.getBackIndex());
//
//        customQCollection.enq(new Student("Petar1", 58));
//        customQCollection.enq(new Student("Petar2", 58));
//        customQCollection.enq(new Student("Petar3", 58));
//        System.out.println(((Student)(customQCollection.deq())).name); // Petar


        CustomLinkedList<Student> linkedListCollection = new CustomLinkedList<>();
        linkedListCollection.add(new Student("Mihail", 28));
        linkedListCollection.add(new Student("Todor", 38));
        linkedListCollection.add(new Student("Ivan", 48));
        System.out.println(linkedListCollection.getElementByPosition(0).name);
        System.out.println(linkedListCollection.getElementByPosition(1).name);
        System.out.println(linkedListCollection.getElementByPosition(2).name);


    }
}

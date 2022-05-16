import data_structure.CustomArrayList;
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

        //ArrayList<Integer> listCollection = new ArrayList<Integer>();

        //Stack<Integer> stackExample = new Stack<>();

        //Queue<Integer> qExample = new PriorityQueue<>();


        CustomArrayList<Student> customStudentCollection = new CustomArrayList<>();
        customStudentCollection.add(new Student("Mihail", 28));
        customStudentCollection.add(new Student("Ivan", 28));
        customStudentCollection.add(new Student("Dragan", 28));
        customStudentCollection.add(new Student("Petkan", 28));


        Student currentStudent = customStudentCollection.get(0);
        System.out.print(currentStudent.name);



//        if(BinarySearch.doesExists(collection, 0)) {
//            System.out.print("YES");
//        }
//        else {
//            System.out.print("NO");
//        }
    }
}

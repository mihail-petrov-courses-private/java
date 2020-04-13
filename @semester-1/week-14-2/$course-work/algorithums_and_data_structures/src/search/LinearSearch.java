package search;

import java.util.ArrayList;

public class LinearSearch {

    private int[] numericCollection;
    private Student[] studentCollection;


    public LinearSearch() {

        this.numericCollection = new int[] {
                1, 5, 7, 8, 6, 7, 4, 2, 0, 0, 0, 0, 5, -6, 1, 1, 6, 3
        };

        this.studentCollection = new Student[] {
                new Student("Mihail", 28),
                new Student("Petko", 38),
                new Student("Ivan", 48)
        };
    }

    public boolean doesExists(int serachElement) {

        int resultElement = -55555;

        for(int i = 0; i < this.numericCollection.length; i++) {
            if(this.numericCollection[i] == serachElement) {
                return true;
            }
        }

        return false;
    }

    public Student[] selectOlderStudents() {

        // Student[] resultCollection = new
        ArrayList<Student> resultCollection = new ArrayList<>();

        for(int i = 0; i < this.studentCollection.length; i++) {

            if(this.studentCollection[i].age > 20) {
                resultCollection.add(this.studentCollection[i]);
            }
        }

        return (Student[]) resultCollection.toArray();
    }



}

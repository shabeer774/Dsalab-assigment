import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {

        HashMap<Integer, String> students = new HashMap<>();

        students.put(101, "Ali");
        students.put(102, "shabeer");
        students.put(103, "Sara");

        System.out.println("Student 102: " + students.get(102));

        students.remove(101);

        for (Integer id : students.keySet()) {
            System.out.println(id + " -> " + students.get(id));
        }
    }
}

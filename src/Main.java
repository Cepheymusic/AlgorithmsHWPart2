import java.util.Arrays;

public class Main {
    public static Integer[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        Integer[] expense = new Integer[100000];

        for (int i = 0; i < expense.length; i++) {
            expense[i] = random.nextInt(100_000) + 100_000;
        }
        return expense;
    }
    public static void main(String[] args) {

        Integer[] arr = generateRandomArray();
        Integer[] arr1 = Arrays.copyOf(arr, 100000);
        Integer[] arr2 = Arrays.copyOf(arr, 100000);


//        long start = System.currentTimeMillis();
//        IntegerListImpl.sortBubble(arr);
//        System.out.println(System.currentTimeMillis() - start); затратный самый

        long start1 = System.currentTimeMillis();
        IntegerListImpl.sortSelection(arr1);
        System.out.println(System.currentTimeMillis() - start1);




//        long start2 = System.currentTimeMillis();
//        IntegerListImpl.sortInsertion(arr2);
//        System.out.println(System.currentTimeMillis() - start2); затратный


    }
}
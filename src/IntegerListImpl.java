import java.util.Arrays;

public class IntegerListImpl implements StringList{

    private Integer[] items;
    private int size;


    public IntegerListImpl() {
        this.items = new Integer[10];
    }
    public IntegerListImpl(int initSize) {
        this.items = new Integer[initSize];
    }


    @Override
    public Integer add(Integer item) {
        growIfNeeded();
        validateItem(item);
        items[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateItem(item);
        validateIndex(index);
        if(index == size){
            items[size++] = item;
            return item;
        }
        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        items[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        if(index == -1){
            throw new NotFoundException();

        }
        if(index != size) {
            System.arraycopy(items, index + 1, items, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = items[index];
        if(index != size) {
            System.arraycopy(items, index + 1, items, index, size - index);
        }
        size--;
        return item;
    }



    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                return  i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (items[i].equals(item)) {
                return  i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return items[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer [] toArray() {
        return Arrays.copyOf(items, size);
    }
    public void validateItem(Integer item){
        if(item == null){
            throw new NullItemException();
        }
    }
    public void growIfNeeded(){
        if(size == items.length){
            grow();
        }

    }
    public void validateIndex(int index){
        if(index >= size) {
            throw new InvalidIndexException();

        }
    }
    public static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }
    private static int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
    public static void sortBubble(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }
    public static void sortSelection(Integer[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    public static void sortInsertion(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j-1] >= temp) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }
    @Override
    public boolean contains(Integer item) {
        Integer[] arr = toArray();
        sortSelection(arr);
        return binarySearch(arr, item);
    }
    public static boolean binarySearch(Integer[] arr, Integer item) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item.equals(arr[mid])) {
                return true;
            }
            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
    private void grow() {
        items = Arrays.copyOf(items, size + size / 2);
    }
}

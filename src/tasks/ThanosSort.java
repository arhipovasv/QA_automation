package tasks;

import java.util.Arrays;

public class ThanosSort {

    //Слепила сортировку из разных сортировок интернета
    //Пыталась разобраться с рекурсией.. сортировка вроде работает,но
    //как накапливаются данные не очень понятно
    //За основу взяла сортировку слиянием и вот что получилось

    static int[] tanosSort(int[] nums, int n) {
        if (n < 2) return nums;
        int head = 0;
        int tail = nums.length - 1;
        int [] sortAvg = new int[nums.length];
        int avg = average(nums);
        for (int j : nums) {
            if (avg >= j) {
                sortAvg[head] = j;
                head = head + 1;
            }
            else {
                sortAvg[tail] = j;
                tail = tail - 1;
            }
        }
        if (head == n) {
            head = head - 1;
        }
        int[] l = new int[head];
        int[] r = new int[nums.length - head];
        for (int i = 0; i < nums.length; i++) {
            if (i < head) l[i] = sortAvg[i];
            else r[i - head] = sortAvg[i];
        }
        int[] sortR = tanosSort(r, r.length);
        int[] sortL = tanosSort(l, l.length);
        int[] union = union(sortR, sortL);
        return union;
    }

    static int[] union(int[] r, int[] l) {
        int size = r.length + l.length;
        int[] union = new int[size];
        for (int i = 0; i < size; i++) {
            if (i < l.length) union[i] = l[i];
            else  union[i] = r[i - l.length];
        }
        return union;
    }
    static int average(int[] nums) {
        int sum = sum(nums);
        int average = sum / nums.length;
        return average;
    }

    static int sum (int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 90, 6, 5, 70, 3, 20};
        int[] sort = tanosSort(nums, nums.length);
        System.out.println(Arrays.toString(sort));
    }
}

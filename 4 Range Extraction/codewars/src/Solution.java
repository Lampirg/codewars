import java.util.ArrayList;
import java.util.List;

class Solution {
    public static String rangeExtraction(int[] arr) {
        List<String> groups = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int begin = i;
            int end = begin;
            while (i + 1 < arr.length && arr[i + 1] - arr[end] == 1) {
                end++;
                i++;
            }
            if (end == begin || end - 1 == begin)
                addOneOrTwo(groups, arr[begin], arr[end]);
            else
                groups.add(arr[begin] + "-" + arr[end]);
        }
        return String.join(",", groups);
    }

    public static void addOneOrTwo(List<String> list, int first, int second) {
        if (first == second)
            list.add(String.valueOf(first));
        else {
            list.add(String.valueOf(first));
            list.add(String.valueOf(second));
        }
    }
}
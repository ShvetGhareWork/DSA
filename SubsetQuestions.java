// Subset Problem: When permutations and combinations are both allowed, we can use the following code to generate all subsets of a given set of numbers.
import java.util.ArrayList;
import java.util.List;
public class SubsetQuestions {

    public static void main(String[] args) {

        // ArrayList<String> result = SubsequenceArray("", "shvet");
        // System.out.println(result);
        
        // SubsequenceAscii("", "shvet");
        
        // ArrayList<String> result = SubsequenceArrayAscii("", "abc");
        // System.out.println(result);

        // Subsequence("", "shvet");

        int[] nums = {2,1,2};
        List<List<Integer>> result = Subset(nums);
        System.out.println(result);
    }

    static void Subsequence(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        // Yes Choice
        Subsequence(p + ch, up.substring(1));
        // No Choice
        Subsequence(p, up.substring(1));
    }

    static void SubsequenceAscii(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        // Yes Choice
        SubsequenceAscii(p + ch, up.substring(1));
        // Ascii Value Choice
        SubsequenceAscii(p + (int)ch + "", up.substring(1));
        // No Choice
        SubsequenceAscii(p, up.substring(1));
    }

    static ArrayList <String> SubsequenceArray(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        // Yes Choice/Left Choice
        ArrayList<String> left = SubsequenceArray(p + ch, up.substring(1));
        // No Choice/right Choice
        ArrayList<String> right = SubsequenceArray(p, up.substring(1));
        left.addAll(right);
        return left;
    }

    static ArrayList <String> SubsequenceArrayAscii(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        // Yes Choice/Left Choice
        ArrayList<String> left = SubsequenceArrayAscii(p + ch, up.substring(1));
        // Ascii Value Choice
        ArrayList<String> asciivalue = SubsequenceArrayAscii(p + (int)ch + "", up.substring(1));
        left.addAll(asciivalue);
        // No Choice/right Choice
        ArrayList<String> right = SubsequenceArray(p, up.substring(1));
        left.addAll(right);
        return left;
    }

    static List<List<Integer>> Subset(int[] nums) {
        List<List<Integer>> list_outer = new ArrayList<>();

        list_outer.add(new ArrayList<>());
        for (int num : nums) {
            int size = list_outer.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list_inner = new ArrayList<>(list_outer.get(i));
                list_inner.add(num);
                list_outer.add(list_inner);
            }
        }

        return list_outer;
    }
    static List<List<Integer>> SubsetDuplicates(int[] nums) {
        List<List<Integer>> list_outer = new ArrayList<>();

        list_outer.add(new ArrayList<>());
        for (int num : nums) {
            int size = list_outer.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list_inner = new ArrayList<>(list_outer.get(i));
                list_inner.add(num);
                if (!list_outer.contains(list_inner)) {
                    list_outer.add(list_inner);
                }
            }
        }

        return list_outer;
    }

}
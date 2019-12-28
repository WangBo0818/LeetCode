import java.util.HashMap;
import java.util.Map;

/**
 * @author wb
 * @date 2019/12/27 - 11:10
 * LeetCode---13. 罗马数字转整数
 */
public class LeetCode_13_RomanToInt {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("0", 0);
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        char[] arr = s.toCharArray();
        int result = 0;
        for(int i = 0; i < arr.length; i++) {
            String str1 = String.valueOf(arr[i]);
            String str2;
            if(i != arr.length-1) {
                str2 = String.valueOf(arr[i+1]);
            }else {
                str2 = String.valueOf(0);
            }
            if(map.get(str1) >= map.get(str2)) {
                if(map.containsKey(str1)) {
                    result += map.get(str1);
                }
            }else {
                if(map.containsKey(str1+str2)) {
                    result += map.get(str1+str2);
                    i++;
                }
            }
        }
        return result;
    }
}

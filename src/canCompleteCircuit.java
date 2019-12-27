/**
 * @author wb
 * @date 2019/12/21 - 10:34
 * LeetCode134---加油站
 */
public class canCompleteCircuit {

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[] {
                4,5,2,6,5,3
        }, new int[] {
                3,2,7,3,2,9
        }));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0; i < gas.length; i++) {
            boolean flag = false;
            if(gas[i] < cost[i]) {
                continue;
            }
            int count = gas[i] - cost[i];
            for(int j = i; j < gas.length - 1; j++) {
                if(count + gas[j + 1] < cost[j + 1]) {
                    count = -1;
                    flag = true;
                    break;
                }else {
                    count = count + gas[j + 1] - cost[j + 1];
                }
            }

            if(flag) {
                continue;
            }

            for(int j = 0; j < i; j++) {
                if(count + gas[j] < cost[j]) {
                    count = -1;
                    break;
                }else {
                    count = count + gas[j] - cost[j];
                }
            }
            if(count >= 0) {
                return i;
            }
        }
        return -1;
    }
}

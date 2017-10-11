import java.util.ArrayList;
import java.util.List;

/**
 * Created by dy on 2017/10/10.
 * 求最大子序列的和
 */
public class MaxSubsequeueSum {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        int N = 1000;
        a.add(4);
        a.add(3);
        a.add(5);
        a.add(-2);
        a.add(-1);
        a.add(2);
        a.add(6);
        a.add(-2);
        for (int i = 0; i < N ;i ++) {
            a.add(-1);
        }
        int maxSum;
        long beginTime = System.currentTimeMillis();
        maxSum = logN(a, 0, N+7);
        System.out.println(maxSum);
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - beginTime));
    }

    public static int n3(List<Integer> a) {
        int sum = 0;
        for (int i = 0; i < a.size() ; i++) {
            for (int j = i; j < a.size() ; j++) {
                int subSum = 0;
                for (int k = i; k <= j ; k ++) {
                    subSum = subSum + a.get(k);
                }
                if (subSum > sum) {
                    sum = subSum;
                }
            }
        }
        return sum;
    }

    public static int logN(List<Integer> a, int left, int right) {
        int sum = 0;
        if (left == right) {
            if (a.get(left) > 0) {
                return  a.get(left);
            } else {
                return  0;
            }
        }
        int mid = (left + right)/2;
        int maxLeft = logN(a, left, mid);
        int maxRight = logN(a, mid + 1, right);
        int maxLeftBorder = 0, maxRightBorder = 0, tmpMaxLeftBorder = 0, tmpMaxRightBorder = 0;
        for (int i = mid;i >= left;i--) {
            tmpMaxLeftBorder += a.get(i);
            if (tmpMaxLeftBorder > maxLeftBorder) {
                maxLeftBorder = tmpMaxLeftBorder;
            }
        }
        for (int i = mid +1;i <= right;i++) {
            tmpMaxRightBorder += a.get(i);
            if (tmpMaxRightBorder > maxRightBorder) {
                maxRightBorder = tmpMaxRightBorder;
            }
        }
        if (maxLeft > maxRight) {
            sum = maxLeft;
        } else {
            sum = maxRight;
        }
        if (maxLeftBorder + maxRightBorder > sum) {
            sum = maxLeftBorder + maxRightBorder;
        }
        return sum;
    }

    public static int n2(List<Integer> a) {
        int sum = 0;
        for (int i = 0; i < a.size() ; i++) {
            int subSum = 0;
            for (int j = i; j < a.size() ; j++) {
                subSum = subSum + a.get(j);
                if (subSum > sum) {
                    sum = subSum;
                }
            }
        }
        return sum;
    }

    public static int n(List<Integer> a) {
        int sum = 0;
        int subSum = 0;
        for (int i = 0; i < a.size() ; i++) {
            subSum = subSum + a.get(i);
            if (subSum > sum) {
                sum = subSum;
            } else if (subSum < 0) {
                subSum = 0;
            }
        }
        return sum;
    }
}

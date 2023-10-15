import java.util.*;

class Result{
    public static long countPairs(List<Integer> arr) {
        Map<Integer, Integer> d = new HashMap<>();

        for (int x : arr) {
            d.put(x, d.getOrDefault(x, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(d.entrySet());
        long ans = 0;

        for (int i = 0; i < entries.size(); i++) {
            int a = entries.get(i).getKey();
            int aCount = entries.get(i).getValue();

            for (int j = i; j < entries.size(); j++) {
                int b = entries.get(j).getKey();
                int bCount = entries.get(j).getValue();

                if (isPowerOfTwo(a & b)) {
                    if (a == b) {
                        ans += (long) (aCount * (aCount - 1)) / 2;
                    } else {
                        ans += (long) aCount * bCount;
                    }
                }
            }
        }

        return ans;
    }

    public static boolean isPowerOfTwo(int x) {
        return x > 0 && (x & (x - 1)) == 0;
    }
}

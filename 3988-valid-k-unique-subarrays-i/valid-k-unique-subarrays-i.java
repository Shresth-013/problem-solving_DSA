import java.util.*;

class Solution {
    private static long splitmix64(long x) {
        x = (x + 0x9E3779B97F4A7C15L) & 0xFFFFFFFFFFFFFFFFL;
        x = (x ^ (x >>> 30)) * 0xBF58476D1CE4E5B9L & 0xFFFFFFFFFFFFFFFFL;
        x = (x ^ (x >>> 27)) * 0x94D049BB133111EBL & 0xFFFFFFFFFFFFFFFFL;
        return x ^ (x >>> 31);
    }

    private void add(int[] bit, int idx, int delta, int n) {
        idx++;
        while (idx <= n) {
            bit[idx] += delta;
            idx += idx & -idx;
        }
    }

    private int sum(int[] bit, int idx) {
        int s = 0;
        while (idx > 0) {
            s += bit[idx];
            idx -= idx & -idx;
        }
        return s;
    }

    public boolean[] validSubarrays(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        int maxi = 0;
        for (int v : nums) maxi = Math.max(maxi, v);

        long[] hLow = new long[maxi + 1];
        long[] hHigh = new long[maxi + 1];
        for (int v = 1; v <= maxi; v++) {
            long a = splitmix64(v);
            long b = splitmix64(v + 0x9E3779B97F4A7C15L);
            hLow[v] = b;
            hHigh[v] = a;
        }

        long[] prefLow = new long[n + 1];
        long[] prefHigh = new long[n + 1];
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            prefLow[i + 1] = prefLow[i] ^ hLow[val];
            prefHigh[i + 1] = prefHigh[i] ^ hHigh[val];
        }

        int[] bit = new int[n + 1];

        List<int[]>[] byR = new List[n];
        for (int i = 0; i < n; i++) byR[i] = new ArrayList<>();
        for (int qi = 0; qi < queries.length; qi++) {
            int l = queries[qi][0], r = queries[qi][1];
            byR[r].add(new int[]{l, qi});
        }

        boolean[] ans = new boolean[queries.length];
        int[] last = new int[maxi + 1];
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            int v = nums[i];
            if (last[v] != -1) add(bit, last[v], -1, n);
            add(bit, i, 1, n);
            last[v] = i;

            for (int[] p : byR[i]) {
                int l = p[0], qi = p[1];
                int distinct = sum(bit, i + 1) - sum(bit, l);
                if (distinct == k && prefLow[i + 1] == prefLow[l] && prefHigh[i + 1] == prefHigh[l]) {
                    ans[qi] = true;
                }
            }
        }
        return ans;
    }
}
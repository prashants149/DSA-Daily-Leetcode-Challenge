class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
         int n = intervals.length;

           Arrays.sort(intervals, (vec1, vec2) -> {
                if (vec1[1] != vec2[1]) 
                    return vec1[1] - vec2[1];
                return vec2[0] - vec1[0];
            });
            int result = 0;
            int first = -1;
            int second = -1;

            for (int i = 0; i < n; ++i) {
                int l = intervals[i][0];
                int r = intervals[i][1];

                if (l <= first)
                    continue;

                    if (l > second) {
                        result += 2;
                        second = r;
                        first = r - 1;
                    } else {
                        result += 1;
                        first = second;
                        second = r;
                    }
                }
                return result;    
    }
}
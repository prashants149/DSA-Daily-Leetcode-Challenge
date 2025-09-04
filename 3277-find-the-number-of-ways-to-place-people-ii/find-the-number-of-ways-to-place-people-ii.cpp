class Solution {
    public:
        int numberOfPairs(vector<vector<int>>& points) {
            int n = points.size();
            int count = 0;

             // Sort by x, then by y descending
            sort(points.begin(), points.end(), [](auto &a, auto &b) {
             if (a[0] == b[0]) return a[1] > b[1];
            return a[0] < b[0];
             });

             for (int i = 0; i < n; i++) {
           for (int j = i+1; j < n; j++) {
          int topLeftX = points[i][0], topLeftY = points[i][1];
                                                                                                                                     int bottomRightX = points[j][0], bottomRightY = points[j][1];

                                                                                                                                            if (topLeftY < bottomRightY) continue; // orientation wrong

                                                                                                                                             bool valid = true;
                                                                                                                                            for (int k = i+1; k < j; k++) {
                                                                                                                                          int x = points[k][0], y = points[k][1];
                                                                                                                                       if (y <= topLeftY && y >= bottomRightY) {
                                                                                                                                     valid = false;
                                                                                                                                                                                                                                                                 break;
                                                                                                                                                                                                                                                                     }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                 if (valid) count++;
                                                                                                                                                                                                                                                                  }
                                                                                                                                     }
                                                                                                                                                                                                                                                                 return count;
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                         };

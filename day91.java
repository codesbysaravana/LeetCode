import java.util.ArrayList;
import java.util.List;

public class day91 {
    public static int[][] mergeIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n <= 1) return intervals;

        List<int[]> ans = new ArrayList<>();

        int start = 0;
        int end = 0;

        for(int i=0; i<n; i++) {
            start = intervals[i][0];
            end = intervals[i][1];
            
            if(!ans.isEmpty() && end <= ans.get(ans.size() -1) [1]) {   //the end must be inside the ans.get final so merge overlappu
                continue;
            }

            for(int j = i+1; j<n; j++) {
                if(intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }

            ans.add(new int[]{start, end});
        }

        return ans.toArray(new int[ans.size()][]);
    }
}


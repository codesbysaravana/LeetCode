class day63 {
    public static int longestChar(String s, int k) {
        int left = 0;
        int maxLen = 0;
        int n = s.length();

        for(int right = 0; right<n; right++) {
            if(s.charAt(left) != s.charAt(right)) {
                k--;
            }

            while(k<0) {
                if(s.charAt(left) == s.charAt(right)) {
                    k++;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
        }

        return maxLen;
    }
}


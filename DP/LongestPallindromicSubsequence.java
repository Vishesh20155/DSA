class Solution
{
    public int longestPalinSubseq(String text1)
    {
        String text2 = "";
        char ch;
        for (int i=0; i<text1.length(); i++)
        {
            ch= text1.charAt(i); 
            text2= ch+text2; 
        }
        int dp[][] = new int[1002][1002];
        for (int i = 0; i <= text1.length(); i++) {
           dp[i][0] = 0;
        }
        for (int i = 0; i <= text2.length(); i++) {
           dp[0][i] = 0;
        }
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
       return dp[text1.length()][text2.length()];
    }
}
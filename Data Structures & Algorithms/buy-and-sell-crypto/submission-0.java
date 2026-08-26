class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int sum = 0;
        int l = 0;
        int r = 1;
        
        while(r<n){
            if(prices[r] > prices[l]){
                sum = prices[r] - prices[l];
                profit = Math.max(profit,sum);
            }else{
                // if r is < l , then means r is a better l
                l = r;
            }
            r++;
        }
        return profit;
    }
}

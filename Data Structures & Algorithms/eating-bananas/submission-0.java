class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r = getArrayMax(piles);
        int hoursTaken = -1;
        int minSpeed = r;
        while(l<=r){
            int mid = l + (r-l)/2;  // speed is between 1 and highes value in array
            hoursTaken = hours(piles, mid); // piles and speed with which koko eating bananas
            if(hoursTaken > h){
                // increase the speed as the time given is less than time taken.
                l = mid+1; // increase speed
            }else{
                // in cse of hoursTaken<=h we can then decrease the speed
                minSpeed = mid;
                r = mid-1;
            }
        }
        return minSpeed;
    }

    static int getArrayMax(int[] piles){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<piles.length; i++){
            max= Math.max(piles[i], max);
        }
        return max;
    }

    static int hours(int[] piles , int speed){
        // we will calculate the time taken with the speed of eating banannas and 
        // we get the number of bananas to be eaten with speed by piles[i]/speed , remainder banans are left 
        // if remainder is left than means we add one more hour 
        // example - 5 bananas and 3 speed , 5/3 - > 1 then 5%3=2 if mod > 0 means some banans are ledt and it will take one hour 

        int hrs = 0;
        for(int i=0 ; i<piles.length; i++){
            hrs = hrs + (piles[i]/speed);
            if(piles[i] % speed > 0) hrs++;
        }
        return hrs;
    }
}

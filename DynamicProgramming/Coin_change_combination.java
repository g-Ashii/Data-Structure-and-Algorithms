/*
    Given coins of denomination 2,3,5,6.
    Find number of ways a change of 16 can be paid by using coins of these denominations.
    You have infinite supply of each coin.
    Find Combinations of the number of ways not permuations.
    223 , 232, 322 should count as 1 and not 3.

*/


/*
    Coin change Combinations                                          
    
    Use one coin for entire dp at one time. 
    After one coin is done use next coin.
    This way there won't be any possiblity of a coin looking back and find 
    it's own value being used before.


    Coin change Permutations
    
    Use all coins for each amount of value (each index of dp) at once.
    Then go to next index.
    This way looking back a coin will be able to find it's own value being used before.


*/


public interface Coin_change_combination {

    public static void main (String args[]) {
        int[] denomination = {2,3,5,6};
        int change = 7;
        changeCombinations(denomination, change);
        
    }

    public static void changeCombinations(int[] denom, int change ){
        
        //Each index which is acting as amount of change in dp stores the number of permutations of paying that amount(Conside index as the value of change) 
        
        int[] dp = new int[change + 1];        //To store value of change at last index take array of value change+1
        dp[0] = 1;                             // number of ways of paying 0 is 1 . case in which we dont give any coin.(This is a technicality to get out of handling looking back to get value otherwise we would have to return value when we hit 0)

        for(int i=0; i<denom.length; i++) {
            for(int j=1; j<dp.length; j++) {
                if(j >= denom[i] ) {             //Value of amount being processed is atleast = value of coin for that coin to participate
                    int remsum = j-denom[i];
                    dp[j] = dp[j] + dp[remsum]; 
                }
            }
        }
        System.out.println(dp[change]);  //Print number of permutations of amount = change in dp
    }
}

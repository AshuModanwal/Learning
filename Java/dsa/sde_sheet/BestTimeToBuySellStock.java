package dsa.sde_sheet;

public class BestTimeToBuySellStock {

    private int buySellStockFirst(int []prices){
        int n = prices.length;
        int profit = 0;
        int buyPrice = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            if(prices[i]<buyPrice && i!=n-1){
                buyPrice = prices[i];
            }

            if(buyPrice!=Integer.MAX_VALUE){
                profit = Math.max(profit, prices[i] - buyPrice);
            }
        }

        return profit;
    }

    private int buySellStockSecond(int []prices){
        int n = prices.length;
        int profit = 0;
        int buyPrice =0;
        boolean baught = false;

        for (int i = 0; i < n; i++) {

            if (!baught) {
                buyPrice = prices[i];
                baught = true;
            }

            if (baught && (i == n - 1 || prices[i] > prices[i + 1])) {
                if (prices[i] > buyPrice) {
                    profit += prices[i] - buyPrice;
                }
                baught = false;
            }
        }
        return  profit;
    }
    public static void main(String []args){
        int [] prices = {7,1,5,3,6,4};
        BestTimeToBuySellStock ob = new BestTimeToBuySellStock();
        System.out.println("buySellStockFirst profit: "+ob.buySellStockFirst(prices));
        System.out.println("buySellStockSecond profit: "+ob.buySellStockSecond(prices));
    }
}

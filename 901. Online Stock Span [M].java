901. Online Stock Span [M]
https://leetcode.com/problems/online-stock-span/

/* Solution 1:
Knowledge Center: https://www.youtube.com/watch?v=CupkFLDywXo

Time Complexity: O(n^2). It should be less than n^2.
Space Complexity: O(n).

*/

class StockSpanner {
    private List<Integer> prices;
    private List<Integer> spans;

    public StockSpanner() {
        prices = new ArrayList<>();
        spans = new ArrayList<>();
    }

    public int next(int price) {
        int idx = prices.size() - 1; //idx is the index of the element which is greater than today's price
        while (idx >= 0 && prices.get(idx) <= price) {
            int span = spans.get(idx);
            idx = idx - span;
        }

        prices.add(price);
        //'current index' - 'idx is the index of the element which is greater than today's price'
        int span = prices.size() - 1 - idx;
        spans.add(span);

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

class Solution {
    public int maxScore(int[] cards, int k) {
         int total = 0;
        for (int card : cards) {
            total += card;
        }
        
        if (k == cards.length) {
            return total;
        }
        int state = 0;
        int maxPoints = 0;
        int start = 0;
        for (int end = 0; end < cards.length; end++) {
            state += cards[end];
            if (end - start + 1 == cards.length - k) {
                maxPoints = Math.max(total - state, maxPoints);
                state -= cards[start];
                start++;
            }
        }
        return maxPoints;
    }
}
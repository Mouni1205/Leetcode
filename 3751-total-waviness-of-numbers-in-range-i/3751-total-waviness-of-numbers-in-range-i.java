class Solution {
    public int totalWaviness(int num1, int num2) {
        int result = 0;
        for(int i=num1;i<=num2;i++){
            result += getWaves(i);
        }
        return result;
    }
    public int getWaves(int x){
        String num = Integer.toString(x);
        int n = num.length();
        int waves = 0;
        for(int i=1;i<n-1;i++){
            //peak
            boolean isPeak = num.charAt(i)>num.charAt(i-1) && num.charAt(i) > num.charAt(i+1);
            boolean isValley = num.charAt(i)<num.charAt(i-1) && num.charAt(i) < num.charAt(i+1);
            if(isPeak||isValley) waves++;
        }
        return waves;
    }
}
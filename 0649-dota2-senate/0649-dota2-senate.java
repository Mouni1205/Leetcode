class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> dire = new LinkedList<>();
        Queue<Integer> radiant = new LinkedList<>();
        int n = senate.length();
        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i)=='R') radiant.offer(i);
            else dire.offer(i);
        }
        while(!dire.isEmpty() && !radiant.isEmpty()){
            int d = dire.poll();
            int r = radiant.poll();
            if(d<r) dire.offer(d+n);
            else radiant.offer(r+n); 
        }
        return (dire.isEmpty())? "Radiant" : "Dire";
    }
}
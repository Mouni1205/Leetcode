//Main Observations: To become a town judge a node should have in degree equal to n-1 and and outdegree 0
//There will be only one node which can satisfy first two conditions and the third one at the same time
class Solution {
    public int findJudge(int n, int[][] trust) {
        int degree[] = new int[n+1];
        for(int t[]:trust){
            degree[t[0]]--; //[1,2][2,1] if you don't decrement you will get wrong answer 
            degree[t[1]]++;
        }
        for(int i=1;i<=n;i++){
            if(degree[i]==n-1) return i;
        }
        return -1;
    }
}
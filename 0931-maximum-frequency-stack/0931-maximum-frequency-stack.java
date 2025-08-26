//we will maintain stack like bucket for each freq of element like element pushed 1time, 2 times, 3 times
//another map to maintain freq 
class FreqStack {
    Map<Integer,Integer> freqMap;
    Map<Integer,Stack<Integer>> freqBucket;
    int maxFreq;
    public FreqStack() {
        freqMap = new HashMap<>();
        freqBucket = new HashMap<>();
    }
    
    public void push(int val) {
        //increment the freq and put it in the correct freq bucket
        int freq = freqMap.getOrDefault(val,0)+1;
        freqMap.put(val,freq);
        maxFreq=Math.max(maxFreq,freq);
        if(!freqBucket.containsKey(freq)){
            freqBucket.put(freq,new Stack<>());
        }
        freqBucket.get(freq).push(val);
    }
    
    public int pop() {
        //decrement the freq and check if the max freq bucket is empty then decrement or else keep it same 
        int result = freqBucket.get(maxFreq).pop();
        freqMap.put(result,maxFreq-1);
        if(freqBucket.get(maxFreq).size()==0) maxFreq--;
        return result;     
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
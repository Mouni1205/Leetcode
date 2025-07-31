class Pair{
    int num;
    int freq;
    Pair(int num,int freq){
        this.num = num;
        this.freq = freq;
    }
}
class Solution {
    public ArrayList<Pair> getFreqPair(String str){
        int count = 1;
        ArrayList<Pair> list = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            if(i+1<str.length() && str.charAt(i)==str.charAt(i+1)){
                count++;
                continue;
            }
            else{
            list.add(new Pair(str.charAt(i)-'0',count));
            count=1;
            }
        }
        return list;
    }
    public String getString(ArrayList<Pair> list){
        StringBuilder str = new StringBuilder();
        for(Pair freq:list){
            str.append(freq.freq);
            str.append(freq.num);
        }
        return str.toString();
    }
    public String getElement(int n,String result){
        if(n==1) return result;
        ArrayList<Pair> list = getFreqPair(result);
        String str = getString(list);
        return getElement(n-1,str);
    }
    public String countAndSay(int n) {
        return getElement(n,"1");
    }
}
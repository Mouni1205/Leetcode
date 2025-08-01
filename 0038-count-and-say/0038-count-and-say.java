class Solution {
    public String getString(String str){
        int count = 1;
        StringBuilder result = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(i+1<str.length() && str.charAt(i)==str.charAt(i+1)){
                count++;
                continue;
            }
            else{
            result.append(count).append(str.charAt(i)-'0');
            count=1;
            }
        }
        return result.toString();
    }
    public String getElement(int n,String result){
        if(n==1) return result;
        return getElement(n-1,getString(result));
    }
    public String countAndSay(int n) {
        return getElement(n,"1");
    }
}
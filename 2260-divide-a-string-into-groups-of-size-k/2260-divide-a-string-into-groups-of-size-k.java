class Solution {
    public String[] divideString(String s, int k, char fill) {
       
        int start = 0;
        int end = k;
        int n = s.length();
         String result[]=new String[(n+k-1)/k];
         int ind = 0;
        while(end<n){
            result[ind++]=s.substring(start,end);
            start = end;
            end = end+k;
        }
        char last[]=new char[k];
        int j=0;
        for(int i=start;i<end;i++){
            if(i<s.length())
                last[j++]= s.charAt(i);
            else last[j++] = fill;
        }
        result[ind]=String.valueOf(last);
        return result;
    }
}
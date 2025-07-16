class Solution {
    public String[] divideString(String s, int k, char fill) {
        ArrayList<String> result = new ArrayList<>();
        int start = 0;
        int end = k;
        int n = s.length();
        while(end<n){
            result.add(s.substring(start,end));
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
        result.add(String.valueOf(last));
        return result.toArray(new String[0]);
    }
}
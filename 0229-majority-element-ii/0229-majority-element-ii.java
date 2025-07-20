class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int candidate1 = 0;
        int candidate2 = 0;
        int c1 = 0;
        int c2 = 0;
        for(int num:nums){
            if(c1==0 && candidate2!=num){
                c1++;
                candidate1 = num;
            }
            else if(c2==0 && candidate1!=num){
                c2++;
                candidate2 = num;
            }
            else if(num==candidate1) c1++;
            else if(num==candidate2) c2++;
            else{
                c1--;
                c2--;
            }
        }
        c1=0;
        c2=0;
        for(int num : nums){
            if(num==candidate1) c1++;
            else if(num==candidate2) c2++;
        }
        if(c1>=(nums.length)/3+1) result.add(candidate1);
        if(c2>=(nums.length)/3+1) result.add(candidate2);
        return result;
    }
}
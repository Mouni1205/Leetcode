class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> list = new HashSet<>();

        for(int x:nums1) set.add(x);
        for(int x:nums2){
            if(set.contains(x)) list.add(x);
        }
        int result[] = new int[list.size()];
        int k=0;
        for(int x:list) result[k++] = x;
        return result;
    }
}
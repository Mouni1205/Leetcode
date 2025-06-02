class Solution {
    public void helper(int nums[],boolean visited[],List<List<Integer>> result,List<Integer> crnt){
        if(crnt.size()==nums.length){
            result.add(new ArrayList<>(crnt));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]) continue;
            visited[i]=true;
            crnt.add(nums[i]);
            helper(nums,visited,result,crnt);
            visited[i]=false;
            crnt.remove(crnt.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        boolean visited[] = new boolean[n];
        helper(nums,visited,result,new ArrayList<>());
        return result;
    }
}
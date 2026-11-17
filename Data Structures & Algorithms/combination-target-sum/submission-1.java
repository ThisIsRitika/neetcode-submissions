class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();

        backtrack(nums,curr,target,0);

        return result;
    }

    private void backtrack(int[] nums, List<Integer> curr, int target, int idx){
        if(target<0) return;
        if(target==0) result.add(new ArrayList<>(curr));

        for(int i=idx;i<nums.length;i++){
            curr.add(nums[i]);
            backtrack(nums,curr,target-nums[i],i);
            curr.remove(curr.size()-1);
        }
    }
}

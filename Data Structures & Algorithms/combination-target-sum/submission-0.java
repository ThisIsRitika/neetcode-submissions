class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();

        backtrack(nums,0,target,curr,result);

        return result;
    }

    private void backtrack(int[] nums, int idx, int target, List<Integer> curr, List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(curr));
        }

        if(target<0) return;

        for(int i=idx;i<nums.length;i++){
            curr.add(nums[i]);
            backtrack(nums,i,target-nums[i],curr,result);
            curr.remove(curr.size()-1);
        }
    }
}

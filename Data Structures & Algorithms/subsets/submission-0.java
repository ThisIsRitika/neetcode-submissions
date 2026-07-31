class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();

        backtrack(nums,0,curr,result);

        return result;
    }

    private void backtrack(int[] nums, int idx, List<Integer> curr, List<List<Integer>> result){

        result.add(new ArrayList<>(curr));

        for(int i=idx;i<nums.length;i++){
            curr.add(nums[i]);

            backtrack(nums, i+1, curr, result);

            //remove the latest element added
            curr.remove(curr.size()-1);
        }
    }
}

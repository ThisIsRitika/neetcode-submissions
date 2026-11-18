class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();

        Arrays.sort(nums);
        backtrack(nums,curr,0);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> curr, int idx){
        result.add(new ArrayList<>(curr));

        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1]) continue;

            curr.add(nums[i]);
            backtrack(nums,curr,i+1);
            curr.remove(curr.size()-1);
        }
    }
}

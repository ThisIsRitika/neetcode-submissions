class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();

        backtrack(nums,curr,0);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> curr, int idx){

        //adds subset everytime a new subset is being formed
        //initially adds empty set to the list
        result.add(new ArrayList<>(curr));

        //add numbers to the set
        for(int i=idx;i<nums.length;i++){
            curr.add(nums[i]);
            backtrack(nums,curr,i+1);
            //removes the latest element added
            curr.remove(curr.size()-1);
        }
        

    }
}

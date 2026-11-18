class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        boolean[] check=new boolean[nums.length];
        backtrack(nums, check, curr);
        return result;
    }

    private void backtrack(int[] nums, boolean[] check, List<Integer> curr){
        if(curr.size()==nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(check[i]==false){
                curr.add(nums[i]);
                check[i]=true;
                backtrack(nums,check,curr);

                curr.remove(curr.size()-1);
                check[i]=false;
            }
  
        }
    }
}

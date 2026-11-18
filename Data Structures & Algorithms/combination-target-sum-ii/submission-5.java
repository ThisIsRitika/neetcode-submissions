class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(candidates,0,target,curr,ans);

        return ans;
    }

    private void backtrack(int[] candidates, int idx, int target, List<Integer> curr, List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(target<0) return;

        for(int i=idx;i<candidates.length;i++){  
            if(i>idx && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) break;

            curr.add(candidates[i]);
            backtrack(candidates,i+1,target-candidates[i],curr,ans);
            curr.remove(curr.size()-1);
        }
    }
}

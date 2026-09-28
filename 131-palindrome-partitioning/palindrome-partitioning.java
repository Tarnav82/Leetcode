class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(0,s,new ArrayList<>(),result);
        return result;
    }
    private void backtrack(int start,String s, List<String> currentPath,List<List<String>> result){
        if(start==s.length()){
            result.add(new ArrayList<>(currentPath));
            return;

        }
        for(int end = start;end<s.length();end++){
            if(isPallindrome(s,start,end)){
                currentPath.add(s.substring(start,end+1));
                backtrack(end+1,s,currentPath,result);
                currentPath.remove(currentPath.size()-1);
            }
        }
    }
    private boolean isPallindrome(String s ,int left,int right){
        while(left<right){
            if(s.charAt(left++)!= s.charAt(right--)){
                return false;
            }
         
        }   return true;
    }
}
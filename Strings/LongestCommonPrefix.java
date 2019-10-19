class Solution{
    public String longestCommonPrefix(String[] strs){
        if(strs.length == 0)
            return "";
        
        String prefix = strs[0];
        for(int i=1; i<strs.length; i++){
            int j=0,k=0;
            while((j<prefix.length() && k<strs[i].length()) ){
                if(prefix.charAt(j) == strs[i].charAt(k)){
                    j++;
                    k++;
                }
                else{
                    break;   
                }
            }
            
            prefix = prefix.substring(0,k);
        }
        
        return prefix;
    }
}
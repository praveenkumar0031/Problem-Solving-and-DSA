class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            if(c=='#' && sb.length()>0)
                sb.deleteCharAt(sb.length()-1);
            else if(c!='#')
                sb.append(c);
        }
        String sr=sb.toString();
        sb=new StringBuilder();
        for(char c:t.toCharArray()){
            if(c=='#' && sb.length()>0)
                sb.deleteCharAt(sb.length()-1);
            else if(c!='#')
                sb.append(c);
        }
        return sr.equals(sb.toString());
        
    }
}
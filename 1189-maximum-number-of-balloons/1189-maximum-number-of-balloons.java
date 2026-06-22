class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character,Integer> hm= new HashMap<>();
        String t="balon";
        for(char e:t.toCharArray()){
            hm.put(e,0);
        }
        int ct=Integer.MAX_VALUE;
        for(char e:text.toCharArray()){
            if(hm.containsKey(e)){
                hm.put(e,hm.get(e)+1);
            }
        }
        for(char e:("ban").toCharArray()){

            ct=Math.min(ct,hm.get(e));
        }
        ct=Math.min(ct,hm.get('l')/2);
        ct=Math.min(ct,hm.get('o')/2);
        return ct;

    }
}
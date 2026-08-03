class Solution {
    public int[] findOrder(int n, int[][] pre) {
        int indgree[]=new int[n];
        int res[]=new int[n],c=0;
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int []i:pre){
            List<Integer> t=adj.getOrDefault(i[1],new ArrayList<>());
            t.add(i[0]);
            adj.put(i[1],t);
            indgree[i[0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indgree[i]==0)
                q.offer(i);
        }
        
        while(!q.isEmpty()){
            
            int t=q.poll();
            res[c++]=t;
            if(adj.containsKey(t)){
            for(int i:adj.get(t)){
                indgree[i]--;
                if(indgree[i]==0)
                    q.offer(i);
                }
            }
            
        }
        return c==n?res:new int[0];

    }
}
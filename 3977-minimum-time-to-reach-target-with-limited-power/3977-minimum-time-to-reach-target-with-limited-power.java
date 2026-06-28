class Solution {
    public long[] minTimeMaxPower(int n, int[][] edges, int power, int[] cost, int src, int target) {
        List<int[]>[] gh=new ArrayList[n];
        for(int i=0;i<n;i++){
            gh[i]=new ArrayList<>();
        }
        for(int e[]:edges){
            gh[e[0]].add(new int[]{e[1],e[2]});
        }
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0])
                    return Long.compare(a[0],b[0]);
            return Long.compare(b[1],a[1]);
        } );
        pq.offer(new long[]{0,power,src});
        int max[]=new int[n];
        Arrays.fill(max,-1);
        long[] res=new long[]{-1,-1};
        while(!pq.isEmpty()){
            long crt[]=pq.poll(),t=crt[0];
            int p=(int)crt[1],u=(int)crt[2];
            if(u==target){
                res=new long[]{t,p};
                return res;
            }
            if(p<=max[u]){
                continue;
            }
            max[u]=p;
            if(p<cost[u]){
                continue;
            }
            int next=p-cost[u];
            for(int e[]:gh[u]){
                int v=e[0];
                long w=e[1];
                pq.offer(new long[]{t+w,next,v});
            }
        }
        return res;
    }
}
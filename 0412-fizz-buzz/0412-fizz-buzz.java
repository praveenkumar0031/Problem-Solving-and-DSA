class Solution {
    public List<String> fizzBuzz(int n) {
        String res[]=new String[n];
        for(int i=1;i<=n;i++){
            String t=String.valueOf(i);
            if(i%3==0&&i%5==0)
                t=new String("FizzBuzz");
            else if(i%3==0)
                t=new String("Fizz");
            else if(i%5==0)
                t=new String("Buzz");
            res[i-1]=new String(t);
        }
        return Arrays.asList(res);
    }
}
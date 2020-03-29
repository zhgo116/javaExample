package cn.fancy.suafa.bayes;

public class recursion1 {
    public static void main(String[] args) {
        System.out.println(test(5,0));
    }

    public static int test(int x, int y){
        if(x==0){
            return y;
        }
        return test(x-1,y+x);
    }
}
import java.util.stream.*;
import java.util.*;
import java.io.*;

//Find minimum in queried subsets
/*The idea to solve this problem with DSU is the following: 
 * We will iterate over the array and when we are at the ith
 * element we will answer all queries (L, R) with R == i. 
 * To do this efficiently we will keep a DSU using the first i 
 * elements with the following structure: the parent of an 
 * element is the next smaller element to the right of it. 
 * Then using this structure the answer to a query will be 
 * the a[find_set(L)], the smallest number to the right of L.
 * This approach obviously only works offline, i.e. if we know all queries beforehand.
 */

public class ArpasTrick{
    public static void main(String[] args) {
        int []arr = {1,9,3,7,4,3,2,7,6,5};
        int N=arr.length;
        
        //int arr[]=  new int[N];
        //findMin(arr, N);
        findMax(arr, N);
        
    }
    static void findMin(int []arr, int N){
        
        //Queries offlines
        ArrayList<Query> Q[] = new ArrayList[N];
        for(int i=0;i<N;i++) Q[i] = new ArrayList<Query>();
        for(int i=0;i<N;i++) for(int j=0;j<=i;j++) Q[i].add(new Query(j,i));
        
        int parent[] = new int[N];
        for(int i=0;i<N;i++) parent[i] = i;
        Stack<Integer> S = new Stack<Integer>();
        for(int i=0;i<N;i++){
            while(!S.isEmpty() && arr[S.peek()] > arr[i]){
                parent[S.peek()] = i;
                S.pop();
            }
            S.push(i);
            for(Query q: Q[i]){
                q.ANS = findSet(q.L, parent);
            }
            System.out.println(S);
        }
        for(int i=0;i<N;i++) for(int j=i;j<N;j++) System.out.print(Q[j].get(i));
    }
    static void findMax(int []arr, int N){
        
        //Queries offlines
        ArrayList<Query> Q[] = new ArrayList[N];
        for(int i=0;i<N;i++) Q[i] = new ArrayList<Query>();
        for(int i=0;i<N;i++) for(int j=0;j<=i;j++) Q[i].add(new Query(j,i));
        
        int parent[] = new int[N];
        for(int i=0;i<N;i++) parent[i] = i;
        Stack<Integer> S = new Stack<Integer>();
        for(int i=0;i<N;i++){
            while(!S.isEmpty() && arr[S.peek()] < arr[i]){
                parent[S.peek()] = i;
                S.pop();
            }
            S.push(i);
            for(Query q: Q[i]){
                q.ANS = findSet(q.L, parent);
            }
            System.out.println(S);
        }
        for(int i=0;i<N;i++) for(int j=i;j<N;j++) System.out.print(Q[j].get(i));
    }
    static int findSet(int a, int[] parent){
        if(parent[a] == a) return a;
        else return findSet(parent[a], parent);
    }
    static class Query{
        int L, R, ANS;
        Query(int l, int r){
            L=l;
            R=r;
            ANS=-1;
        }
        public String toString(){
            return "\n[ "+L+", "+R+" ] = "+ANS;
        }
    }
}
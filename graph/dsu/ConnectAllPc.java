
import java.io.*;
import java.util.*;

public class ConnectAllPc {
   static class Edge implements Comparable<Edge> {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
      
      public int compareTo(Edge o){
          return this.wt - o.wt;
      }
      
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      // write your code here
      
      kruskals(graph);
      
   }
  
   
    public static void kruskals(ArrayList<Edge>[] graph){
        
        PriorityQueue<Edge> pq=new PriorityQueue<>(); 
        
        for(int v=0;v<graph.length;v++){
            for(Edge e:graph[v]){
                pq.add(e);
            }
        }
        
        parents = new int[graph.length];
        ranks = new int[graph.length];
        
        
        for(int v=0;v<graph.length;v++){
            parents[v] = v;
            ranks[v] = 0;
        }        
        
        
        // make tree by joining edges
        while(pq.size() > 0){
            Edge e = pq.remove();
            
            int srcLead = findLead(e.src);
            int nbrLead = findLead(e.nbr);
                
            // if verteces are not in same set
            if(srcLead != nbrLead){
                System.out.println(e.src + "." + e.nbr + "@" + e.wt);
                union(srcLead,nbrLead);
            }
                
        }

    }
    
    static int []parents;
    static int []ranks;
    
    
   // find set
    public static int findLead(int x){
        if(parents[x]==x){
            return x;
        }else{
            int pofx=parents[x];
            int setLead=findLead(pofx);
            
            // compression
            parents[x]=setLead;
            
            return setLead;
        }
    }
    
    public static void union(int s11,int s21){
        
        if(ranks[s11] < ranks[s21]){
            parents[s11]=s21;
        }else if(ranks[s11] < ranks[s21]){
            parents[s21]=s11;
        }else{
            parents[s11] = s21;
            ranks[s21]++;
        }
        
    }


}
import java.util.*;
class Node implements Comparable<Node> {
       int dis;
    int num;
  		@Override
        public int compareTo(Node n) {
            return this.dis - n.dis;
        }
   }
class pathInfo {
    int dest; // 도착지
    int cost; // 간선비용
}
class Solution {
      
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        Map<Integer,List<pathInfo>> graph = new HashMap<>() ;
        for(int i = 1; i<= n;i++){
            List<pathInfo> temp = new ArrayList<>();
            graph.put(i, temp);
        }
        for (int i = 0; i<fares.length;i++){ //인접리스트 만들기(무방향 그래프 주의)
            int startNum = fares[i][0];
            int endNum = fares[i][1];
            int cost =fares[i][2];
            pathInfo path1 = new pathInfo();
            path1.dest = endNum;
            path1.cost = cost;
            graph.get(startNum).add(path1);
            
            pathInfo path2 = new pathInfo();
            path2.dest = startNum;
            path2.cost = cost;
            graph.get(endNum).add(path2);
        }
        int answer = 2147483647;
       	int [] start = dijk(s,n,graph);
       	int [] A = dijk(a,n,graph);
       	int [] B = dijk(b,n,graph);
        for(int i = 1; i<= n; i++){
            answer = Math.min(answer,start[i] + A[i]+B[i]);
        }
        return answer;
        
    }
    public int[] dijk(int start ,int n,Map<Integer,List<pathInfo>> graph){
        Node no = new Node();
        no.dis = 0;
        no.num = start;
      	PriorityQueue<Node> pq = new PriorityQueue<>();
        int arr [] = new int [n+1];
        for (int i= 0 ; i<n+1;i++){
            arr[i] = 2147483647;
        }
        arr[start] = 0 ;
        pq.add(no);
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(node.dis  > arr[node.num]){
                continue;
            }
            for (pathInfo nextNode : graph.get(node.num)){
                int newDistance = nextNode.cost+ node.dis;
                if(newDistance < arr[nextNode.dest]){
                    arr[nextNode.dest] = newDistance;
                    Node newNode = new Node();
                    newNode.dis = newDistance;
                    newNode.num = nextNode.dest;
                    pq.add(newNode);
                }
            }
        }
        return arr;
    }
}
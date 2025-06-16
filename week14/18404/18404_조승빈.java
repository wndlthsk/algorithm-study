import java.util.*;
class Node{
    int x;
    int y;
    Node(int x,int y){
        this.x= x;
        this.y= y;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int [][] visted = new int[n][n];
        int startX = sc.nextInt()-1;
        int startY = sc.nextInt()-1;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY));
        int [] nx  = {1,2,2,1,-1,-2,-2,-1};
        int [] ny = {-2,-1,1,2,2,1,-1,-2};
        visted[startX][startY] = 1;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            for (int i =0;i<8;i++){
                int px = node.x + nx[i];
                int py = node.y + ny[i];
                if (px<0||py<0||px>=n||py>=n){
                    continue;
                }
                if (visted[px][py]==0){
                    visted[px][py]+=(visted[node.x][node.y]+1);
                    queue.add(new Node(px, py));
                }
            }
        }
        List<Node> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            edges.add(new Node(a,b));
        }
        
        for (Node edge:edges) {
            System.out.println(visted[edge.x][edge.y]-1);
        }

        sc.close();
    }
}

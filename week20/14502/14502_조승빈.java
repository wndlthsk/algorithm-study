import java.io.*;
import java.util.*;
class Node {
  int x;
  int y;
  Node(int x,int y){
    this.x = x ;
    this.y =y;
  }
}
public class Main {
  static int ans =0; 
  static int n = 0;
  static int m = 0;
  static int safeArea = 0; //안전 구역(빈칸)
  static List<Node> virusPos = new ArrayList<>(); // 바이러스 위치
  static int minVirusNum = 2147483647;
  static int []nx = {-1,1,0,0};
  static int []ny = {0,0,-1,1};
  static List<Node> emptyPos = new ArrayList<>();


  public static void  BFS(int[][]original){
  int[][] arr = new int[n][m]; // 깊은 복사본 생성
    for (int i = 0; i < n; i++) {
        arr[i] = original[i].clone();
    }
 
  Queue<Node> que = new  LinkedList<>();
    int virusNum = 0;
    for(Node virus : virusPos){
      que.add(virus);
    }
    while(!que.isEmpty()){
        Node virus = que.poll();
        for(int i = 0; i<4;i++){
          int px = virus.x + nx[i];
          int py = virus.y + ny[i];
          if (px<0||px>=n ||py<0||py>=m){
            continue;
          }
          if(arr[px][py] == 0){
            arr[px][py]= 2;
            virusNum+=1;
            if(virusNum>minVirusNum){
              return;
            }
            que.add(new Node(px, py));
          }
        }
    }
    if (minVirusNum>virusNum){
      minVirusNum= virusNum;
    }
    if(ans< (safeArea-virusNum)){
      ans=safeArea-virusNum;
    }
  }
   public static void makeWall(int cnt, int start, int[][] arr) {
        if (cnt == 3) {
            BFS(arr);
            return;
        }

        for (int i = start; i < emptyPos.size(); i++) {
            Node cur = emptyPos.get(i);
            arr[cur.x][cur.y] = 1;
            makeWall(cnt + 1, i + 1, arr);
            arr[cur.x][cur.y] = 0;
        }
    }

  public static void main(String[] args)throws IOException {
  
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int arr[][] = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
              int num =  Integer.parseInt(st.nextToken());
              if (num ==0){
                safeArea++;
                emptyPos.add(new Node(i, j)); // 빈칸 따로 저장
              }
             
              if(num ==2){
                virusPos.add(new Node(i, j)); //바이러스 위치 저장
              }
                arr[i][j] = num;
            }
        }   
      
       makeWall(0, 0, arr); 
      System.out.println(ans-3);
  }
 
}
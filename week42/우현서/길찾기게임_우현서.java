// 2팀, 각 팀이 같은 곳을 다른 순서로 방문하도록해서 먼저 순회한 팀이 승리
// 방문할 곳의 2차원 좌표, 각 장소 이진 트리 노드, 순회 방법 힌트 -> 각 팀이 스스로 경로 찾게
// 트리 노드 구성 규칙
// 모든 노드는 서로 다른 x값
// 같은 레벨에 있는 노드는 같은 y 좌표
// 자식 노드의 y값은 항상 부모 노드보다 작다
// 노드 V의 왼쪽 서브 트리에 있는 모든 노드의 x값은 V의 x값보다 작다
// 오른쪽 서브트리는 x값 크다
// 전위 순회, 후위 순회 결과를 리턴

// nodeinfo: 이진트리 노드들 좌표
// nodeinfo[i] = i+1번 노드 좌표, [x축 좌표, y축 좌표]

// 간선을 구해야하네

// 객체 정렬
// nodes.sort((a, b) -> {
//     if (a.y != b.y) return Integer.compare(b.y, a.y); // y 내림차순
//     return Integer.compare(a.x, b.x); // x 오름차순
// }

import java.util.ArrayList;
import java.util.List;

class Node {
    int idx;
    int x;
    int y;
    Node left;
    Node right;

    public Node (int idx, int x, int y) {
        this.idx = idx;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[idx: " + idx
            + " left: " + (left != null ? left.idx : "null")
            + " right: " + (right != null ? right.idx : "null")
            + "]\n";
    }
}

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        List<Node> nodes = new ArrayList<>();
        for (int i=0; i<n; i++) {
            nodes.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        nodes.sort((a, b) -> {
            if (a.y != b.y) return Integer.compare(b.y, a.y); // y 내림차순
            return Integer.compare(a.x, b.x); // x 오름차순
        });
        // System.out.println(nodes);

        // 왜 계속 root를 넘길까?
        // -> “현재까지 만들어진 트리 전체”를 기준으로 위치를 찾아야 해서
        Node root = nodes.get(0);
        for (int i=1; i<n; i++) {
            insert(root, nodes.get(i));
        }
        // System.out.println(nodes);


        // 전위, 후위 순회
        preOrder(root);
        postOrder(root);

        // 2차원 배열로 바꾸기
        int[][] answer = new int[2][n];
        for (int i=0; i<n; i++) {
            answer[0][i] = pre.get(i);
            answer[1][i] = post.get(i);
        }

        return answer;
    }

    public void insert(Node now, Node child) {
        if (child.x < now.x) {
            if (now.left == null) now.left = child;
            else insert(now.left, child);
        } else {
            if (now.right == null) now.right = child;
            else insert(now.right, child);
        }
    }


    List<Integer> pre = new ArrayList<>();
    public void preOrder(Node now) {
        pre.add(now.idx);
        if (now.left != null) preOrder(now.left);
        if (now.right != null) preOrder(now.right);
    }

    List<Integer> post = new ArrayList<>();
    public void postOrder(Node now) {
        if (now.left != null) postOrder(now.left);
        if (now.right != null) postOrder(now.right);
        post.add(now.idx);
    }

}
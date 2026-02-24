// 두팀으로 나눠서 각팀이 다른 순서로 방문, 먼저 순회한 팀이 승리
// 좌표값 이진트리

import java.util.ArrayList;
import java.util.Collections;
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
        return "[idx: " + idx + " x: " + x + " y: " + y + "]";
    }
}

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        int[][] answer = new int[2][n];

        // y 내림차순, x 오름차순으로 정렬
        List<Node> nodes = new ArrayList<>();
        for (int i=0; i<nodeinfo.length; i++) {
            int[] node = nodeinfo[i];
            nodes.add(new Node(i+1, node[0], node[1]));
        }
        Collections.sort(nodes, (a, b) -> {
            if (a.y != b.y) return Integer.compare(b.y, a.y);
            return Integer.compare(a.x, b.x);
        });
        // System.out.println(nodes);

        // 루트 저장
        Node root = nodes.get(0);

        // 나머지 노드들 루트에다가 삽입
        for (int i = 1; i < nodes.size(); i++) {
            insert(root, nodes.get(i));
        }


        // 전위순회, 후위순회
        List<Integer> pre = new ArrayList<>();
        preorder(root, pre);

        List<Integer> post = new ArrayList<>();
        postorder(root, post);

        for (int i=0; i<n; i++) {
            answer[0][i] = pre.get(i);
            answer[1][i] = post.get(i);
        }

        return answer;
    }

    public void insert(Node root, Node n) {
        if (n.x < root.x) {
            if (root.left == null) root.left = n;
            else insert(root.left, n);
        } else {
            if (root.right == null) root.right = n;
            else insert(root.right, n);
        }
    }

    public void preorder(Node node, List<Integer> result) {
        if (node == null) return;
        result.add(node.idx);
        preorder(node.left, result);
        preorder(node.right, result);
    }

    public void postorder(Node node, List<Integer> result) {
        if (node == null) return;
        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.idx);
    }
}
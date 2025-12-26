import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 바이너리 트리, 노드에 알파벳 대문자 하나씩 쓴다.
// 같은 알파벳을 여러노드에 쓰지 않는다
// 트리의 프리오더, 인오더 순회 결과를 적어둠
// 포스트오더로 순회한 결과를 출력



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = br.readLine();
            if (s == null) break;

            String[] splited = s.split(" ");
            String preorder = splited[0]; // 첫번째가 루트
            String inorder = splited[1]; // 루트 기준 왼/오 서브트리

            tree(preorder, inorder);
            System.out.println();
        }

    }

    public static void tree(String preorder, String inorder) {
        if (preorder.length() == 0 || inorder.length() == 0) {
            return;
        }
        char root = preorder.charAt(0);
        int rootInorderIdx = inorder.indexOf(root);
        String leftInorderTree = inorder.substring(0, rootInorderIdx);
        String leftPreorderTree = preorder.substring(1, 1 + leftInorderTree.length());
        String rightInorderTree = inorder.substring(rootInorderIdx + 1);
        String rightPreorderTree = preorder.substring(1 + leftPreorderTree.length());

        tree(leftPreorderTree, leftInorderTree);
        tree(rightPreorderTree, rightInorderTree);

        System.out.print(root);
    }
}
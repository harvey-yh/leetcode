package 剑指offer;

/**
 * @author Harvey
 * @date 2020/5/12
 * @slogan Drive business with technology, make business generate value.
 */
public class 序列化二叉树 {
    String Serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        if(root == null){
            res.append("#!");
            return res.toString();
        }
        res.append(root.val+"!");
        res.append(Serialize(root.left));
        res.append(Serialize(root.right));
        return res.toString();
    }
    int index=-1;
    TreeNode Deserialize(String str) {
        index++;
        String[] s = str.split("!");
        TreeNode node = null;
        if(!s[index].equals("#")){
            node = new TreeNode(Integer.valueOf(s[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}

package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉树的序列化与反序列化 {
    public String serialize(TreeNode root) {
        if(root==null){
            return "null,";
        }
        String str=root.val+",";
        str+=serialize(root.left);
        str+=serialize(root.right);
        return str;
    }

    public TreeNode deserialize(String data) {
        String []arr=data.split(",");
        Queue<String> queue=new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            queue.offer(arr[i]);
        }
        //调用先序遍历递归方法（改动后）依次重建二叉树
        return deserialize(queue);
    }

    public TreeNode deserialize(Queue <String> queue) {
        String str = queue.poll();
        if (str.equals("null")) {
            return null;
        }
        //若节点值不为空，将其由String转换回int
        //将其作为当前节点值新建当前节点
        TreeNode root = new TreeNode(Integer.parseInt(str));
        //递归调用连接当前节点的左右节点
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        //递归完成后返回当前节点
        return root;
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}




import java.util.*;

class treenode {
    static Scanner sc = new Scanner(System.in);
    int data;
    treenode left, right;

    treenode(int data) {
        this.data = data;
    }

    public static treenode createtree() {
        System.out.println("enter data of this node");
        int t = sc.nextInt();
        if (t == -1)
            return null;
        treenode root = new treenode(t);
        System.out.println("enter left for" + t);
        root.left = createtree();
        System.out.println("enter right for" + t);
        root.right = createtree();
        return root;

    }
//-----------------------------------------------------------------------------------------------------------------------------
    //PREORDER(DLR)
//public static void print(treenode root)
//{
//   if(root==null)
//       return;
//    System.out.println(root.data);
//    print(root.left);
//    print(root.right);
//}
    // INORDER(LDR)
    public static void print(treenode root) {
        if (root == null) {
            return;
        }

        print(root.left);
        System.out.println(root.data);
        print(root.right);
    }

    //POSTORDER(LRD)
//    public static void print(treenode root)
//    {
//        if(root==null)
//            return;
//
//        print(root.left);
//        print(root.right);
//        System.out.println(root.data);
//    }
//    public static int numOfNodes(treenode root)
//    {
//        if(root==null)
//            return 0;
//        else
//            return (1+numOfNodes(root.left)+numOfNodes(root.right));
//    }
//--------------------------------------------------------------------------------------------------------------------

//--------------------------------------------------------------------------------------------------------------------
    public static int countLeafNodes(treenode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;


        else
            return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

    public static int countFullNodes(treenode root) {
        if (root == null || root.left == null || root.right == null)
            return 0;
        return 1 + countFullNodes(root.left) + countFullNodes(root.right);
    }
//-----------------------------------------------------------------------------------------------------------------------
    public static void ListOrderTraverse(treenode root) {
        List<List<Integer>> bfs = new ArrayList<>();

        if (root == null)
            return;

        Queue<treenode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelsize = queue.size();
            ArrayList<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelsize; i++) {
                treenode current = queue.poll();
                currentLevel.add(current.data);

                if (current.left != null)
                    queue.offer(current.left);

                if (current.right != null)
                    queue.offer(current.right);

            }
            bfs.add(currentLevel);

        }

        for (int i = 0; i < bfs.size(); i++)
            System.out.println(bfs.get(i));
    }

    public static void zigzagListOrderTraverse(treenode root) {
        List<List<Integer>> bfs = new ArrayList<>();
        boolean t = true;
        if (root == null)
            return;

        Queue<treenode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelsize = queue.size();

            List<Integer> currentLevel = new LinkedList<>();
            for (int i = 0; i < levelsize; i++) {
                treenode current = queue.poll();

                if (t)
                    currentLevel.add(current.data);
                else
                    currentLevel.add(0, current.data);
                if (current.left != null)
                    queue.offer(current.left);

                if (current.right != null)
                    queue.offer(current.right);

            }
            bfs.add(currentLevel);
            t = !t;
        }

        for (int i = 0; i < bfs.size(); i++)
            System.out.println(bfs.get(i));
    }

    //    LEVEL ORDER SUCCESSOR
//    public static int check(int key,treenode root)
//    {
//        if(root==null)
//            return -1;
//        Queue<treenode> q1 = new LinkedList<>();
//        q1.offer(root);
//        while (!q1.isEmpty())
//        {
//            treenode n=q1.poll();
//            if(n.data==key && !q1.isEmpty())
//                return q1.peek().data;
//            if(n.left!=null)
//                q1.offer(n.left);
//            if(n.right!=null)
//                q1.offer(n.right);
//        }
//return -1;
//
//    }
//    ---------------------------------------------------------------------------------------------------------------------------
    public static void rigthview(treenode root) {
        {
            if (root == null)
                return;
            ;
            Queue<treenode> q1 = new LinkedList<>();
            q1.offer(root);

            while (!q1.isEmpty()) {

                int size = q1.size();

//            if(n.data==key && !q1.isEmpty())
//                return q1.peek().data
                treenode n = null;
                for (int i = 0; i < size; i++) {
                    n = q1.poll();


                    if (n.left != null)
                        q1.offer(n.left);
                    if (n.right != null)
                        q1.offer(n.right);
                }
                System.out.println(n.data);
            }
            return;

        }
    }

    public static void leftview(treenode root) {
        {
            if (root == null)
                return;
            ;
            Queue<treenode> q1 = new LinkedList<>();
            q1.offer(root);

            while (!q1.isEmpty()) {

                int size = q1.size();

                treenode n = null;
                for (int i = 0; i < size; i++) {
                    n = q1.poll();


                    if (n.right != null)
                        q1.offer(n.right);
                    if (n.left != null)
                        q1.offer(n.left);
                }
                System.out.println(n.data);
            }
            return;

        }
    }
//---------------------------------------------------------------------------------------------------------------------------------
    public static int findMinimumDepth(treenode root) {
        int minimumDepth = 0;
        if (root == null) return minimumDepth;
        Queue<treenode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            minimumDepth++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                treenode current = queue.poll();

                if (current.left == null && current.right == null) {
                    return minimumDepth;
                }

                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
        }
        return minimumDepth;
    }
//--------------------------------------------------------------------------------------------------------------------------

    public static boolean pathsum(int s, treenode root) {
        if (root == null)
            return false;
        if (root.data == s && root.right == null && root.left == null)
            return true;
        return (pathsum(s - root.data, root.left) || pathsum(s - root.data, root.right));
    }

    public static int nodesum(treenode root, int s) {
        if (root == null)
            return 0;
        s = 10 * s + root.data;
        if (root.left == null && root.right == null)
            return s;
        return nodesum(root.left, s) + nodesum(root.right, s);

    }
//------------------------------------------------------------------------------------------------------------------------------
    public static boolean pathWithSequence(int[] arr, treenode root, int index) {
        if (root == null)
            return false;
        if (root.data != arr[index] || index >= arr.length)
            return false;
        if ((root.left == null) && root.right == null && index == arr.length - 1) {
            return true;
        }
        return (pathWithSequence(arr, root.left, index + 1) || pathWithSequence(arr, root.right, index + 1));
    }
//---------------------------------------------------------------------------------------------------------------------------------
    //public static int diameter(treenode  root)
//{
//    if(root==null)
//        return 0;
//    int leftheight=diameter(root.left) ;
//    int rightheight =diameter(root.right);
//    int dia=
//}
    public static boolean findSymmetric(treenode root1, treenode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        return (root1.data == root2.data) &&
                findSymmetric(root1.left, root2.right) &&
                findSymmetric(root1.right, root2.left);
    }

    public static boolean isSymmetric(treenode root) {
        return findSymmetric(root, root);
    }
//---------------------------------------------------------------------------------------------------------------------------------
    public static void sumReplacement(treenode root) {
        if (root == null)
            return;

        sumReplacement(root.left);
        sumReplacement(root.right);
        if (root.left != null)
            root.data += root.left.data;
        if (root.right != null)
            root.data += root.right.data;



    }
}
//------------------------------------------------------------------------------------------------------------------------------------------------
    public class                               tree1 {
        public static void main(String[] args) {
            treenode root = treenode.createtree();
//        try
//        {
//            System.out.println(root.data);
//        }
//        catch(NullPointerException e )
//        {
//            System.out.println(" Oops!!! No Data Exist");
//
//        }
//        System.out.println(" the data elements of tree is");
//        treenode.print(root);
//        System.out.println("no of nodes is : " + treenode.numOfNodes(root));
//        System.out.println("no of leaf nodes : "+ treenode.countLeafNodes(root));
//        System.out.println("no of full nodes : "+ treenode.countFullNodes(root));
//        treenode.ListOrderTraverse(root);
//        System.out.println("-----------------------------------------------------------------");
//        treenode.zigzagListOrderTraverse(root);
//        System.out.println( treenode.check(12,root));
//          treenode.rigthview(root);
//          treenode.leftview(root);
//        System.out.println("-----------------------------------------------");
//        System.out.println(  treenode.pathsum(9,root));
//        System.out.println( treenode.nodesum(root,0));
            treenode.sumReplacement(root);
            treenode.print(root);

        }

}
class Main {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        view(root, list, 0);
        return list;
    }
    private static  void view(TreeNode root, List<Integer> list, int level){
        if(root == null) return;
        if(level == list.size()){
            list.add(root.val);
        }
        view(root.right, list, level + 1);
        view(root.left, list, level + 1);
    }

    public static int minimumDepth(TreeNode root){
        if(root == null) return 0;
        if(root.left == null) return 1 + minimumDepth(root.right);
        if(root.right == null) return 1 + minimumDepth(root.left);
        return 1 + Math.min(minimumDepth(root.left), minimumDepth(root.right));
    }

    public static int maximumDepth(TreeNode root){
        if(root==null) return 0;
        return 1 + Math.max(maximumDepth(root.left), maximumDepth(root.right));
    }

    public static boolean isSameTree(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null|| root2 == null) return false;

        return root1.val == root2.val 
            && isSameTree(root1.left, root2.left) 
            && isSameTree(root1.right,root2.right);
    }
    public static boolean isSymmetric(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null|| root2 == null) return false;
        return root1.val == root2.val 
            && isSymmetric(root1.left, root2.right) 
            && isSymmetric(root2.left,root1.right);
    }

    public static List<Integer> BinaryTreePaths(TreeNode root){
        List<Integer>result = new ArrayList<>();
        traversal(root,result);
        return result;
    }
    private static void traversal(TreeNode root,List<Integer>list){
        if(root==null) return;
        if(root.left==null && root.right==null){
            str+=str.val;
            list.add(root.val);
            return;
        }
        str= str+root.val+"->";
        traversal(root.left,list);
        traversal(root.right,list);
    }

    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }

    public static  boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer>list1 = new ArrayList<>();
        List<Integer>list2 = new ArrayList<>();
        getLeaf(root1,list1);
        getLeaf(root2,list2);
        return list1.equals(list2);
    }
    private static  void getLeaf(TreeNode root,List<Integer>list){
        if(root==null) return;
        if(root.left==null && root.right==null) {
            list.add(root.val);
            return;
        }
        getLeaf(root.left,list);
        getLeaf(root.right,list);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode>queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer>list = new ArrayList<>();
            for(int i= 0;i<level;i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            result.add(list);
        }
        return result;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList();
        Queue<TreeNode>queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
        int n = queue.size();
        double num = 0;
        System.out.println("Current Level : "+n);
        for(int i = 0;i<n;i++){
            TreeNode node = queue.poll();
            num+=node.val;
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
        result.add(num/n);
        }
        return result;
    }

    public List<Integer> largestValues(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<Integer> result = new ArrayList();
        Queue<TreeNode>queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
        int n = queue.size();
        int num = Integer.MIN_VALUE;
        System.out.println("Current Level : "+n);
        for(int i = 0;i<n;i++){
            TreeNode node = queue.poll();
            num = Math.max(num,node.val);
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
        result.add(num);
        }
        return result;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>result = new LinkedList<>();
        if(root==null) return result;
        Queue<TreeNode>queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeftToRight = true;
        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer>list = new ArrayList<>();
            for(int i= 0;i<level;i++){
                TreeNode node = queue.poll();
                if(isLeftToRight==true)  list.addLast(node.val);
                else list.addFirst(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            isLeftToRight = !isLeftToRight;
            result.add(list);
        }
        return result;
    }
    public static void main(String[] args) {
        
    }
}

public class MyTree {
    public static class Node{
        private int val;
        public Node left;
        public Node right;
        public Node(int val,Node left,Node right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
        public Node(int val){
            this(val,null,null);
        }
    }

    public Node root;

    public void preOrderTraversal(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void preOrder(Node root){
        if(root==null){
            return;
        }
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node=stack.pop();
            System.out.print(node.val+" ");
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
    }

    public void inOrderTraversal(Node root){
        if(root==null){
            return ;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val+" ");
        inOrderTraversal(root.right);
    }
    public void inOrder(Node root){
        Stack<Node> stack=new Stack<>();
        Node cur=root;
        while(!stack.isEmpty()||cur!=null){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            Node node=stack.pop();
            System.out.print(node.val+" ");
            if(node.right!=null){
                cur=node.right;
            }
        }
    }

    public void postOrderTraversal(Node root){
        if(root==null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val+" ");
    }
    public void postOrder(Node root){
        if(root==null){
            return;
        }
        Stack<Node> stack1=new Stack<>();
        Stack<Node> stack2=new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            Node node=stack1.pop();
            stack2.push(node);
            if(node.left!=null){
                stack1.push(node.left);
            }
            if(node.right!=null){
                stack1.push(node.right);
            }
        }
        while(!stack2.isEmpty()){
            System.out.print((stack2.pop()).val+" ");
        }
    }

    public void levelOrder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node node=queue.poll();
            System.out.print(node.val+" ");
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
    }

    public int getNodeSize(Node root){
        if(root==null){
            return 0;
        }
        return 1+getNodeSize(root.left)+getNodeSize(root.right);
    }

    public int getLeafSize(Node root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        return getLeafSize(root.left)+getLeafSize(root.right);
    }
    public int size=0;
    public void getLeafParent(Node root){
        if(root==null){
            return ;
        }
        getLeafParent(root.left);
        getLeafParent(root.right);
        if((root.left!=null&&root.left.left==null&&root.left.right==null)||
                (root.right!=null&&root.right.left==null&&root.right.right==null)){
            size++;
        }
    }

    public int getLevelSize(Node root,int k){
        if(k<=0||root==null){
            return  0;
        }
        if(k==1){
            return 1;
        }
        return getLevelSize(root.left,k-1)+getLevelSize(root.right,k-1);
    }

    public int getDepth(Node root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(getDepth(root.left),getDepth(root.right));
    }

    public boolean isBalancedTree(Node root){
        if(root==null){
            return true;
        }
        int leftHigt=getDepth(root.left);
        int rightHigh=getDepth(root.right);
        return Math.abs(leftHigt-rightHigh)<=1&&
                isBalancedTree(root.left)&&isBalancedTree(root.right);
    }
    
}



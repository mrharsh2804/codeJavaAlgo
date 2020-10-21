public boolean preOrderItr(TreeNode root) 
{
  Stack<TreeNode> st = new Stack<>();
  while(!st.isEmpty() || root!=null)
  {
      if(root == null && !st.isEmpty()) root=st.pop();
      System.out.print(root.val+" ");
      if(root.right!=null) st.push(root.right);
      root = root.left;
  }
  return true;
}

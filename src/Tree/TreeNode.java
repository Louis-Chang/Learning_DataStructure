package Tree;

public class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }


    public boolean hasNoChild() {
        if(getLeft()==null && getRight()==null) {
            return true;
        }
        return  false;
    }
    public boolean hasOneChild() {
        if((getLeft()!=null && getRight()!=null) || (getRight()==null && getLeft()!=null)) {
            return true;
        }
        return  false;
    }
    public boolean hasTwoChildren() {
        if (getLeft()!=null && getRight()!=null) {
            return true;
        }
        return false;
    }
}

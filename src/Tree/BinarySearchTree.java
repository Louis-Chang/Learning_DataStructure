package Tree;

import com.sun.source.tree.Tree;

public class BinarySearchTree {
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }


    // public methods
    public void insert(int value) throws Exception {
        TreeNode newNode = new TreeNode(value);

        if (getRoot()==null) {
            setRoot(newNode);
            return;
        }

        TreeNode currentNode = getRoot();
        boolean hasFoundPosition = false;
        while (!hasFoundPosition) {
            if (newNode.getValue() < currentNode.getValue()) {
                if (currentNode.getLeft() != null) {
                    currentNode = currentNode.getLeft();
                } else {
                    currentNode.setLeft(newNode);
                    hasFoundPosition = true;
                }
            } else if (newNode.getValue() > currentNode.getValue()) {
                if (currentNode.getRight() != null) {
                    currentNode = currentNode.getRight();
                } else {
                    currentNode.setRight(newNode);
                    hasFoundPosition = true;
                }
            } else {
                throw new Exception("Binary Search Tree does not allow nodes with the same value! ");
            }
        }


    }

    public TreeNode search(int value) {
        TreeNode currentNode = getRoot();

        while (currentNode!=null) {
            if (value == currentNode.getValue()) {
                break;
            } else if (value < currentNode.getValue()) {
                if (currentNode.getLeft() != null) {
                    currentNode = currentNode.getLeft();
                }
            } else {
                if (currentNode.getRight() != null) {
                    currentNode = currentNode.getRight();
                }
            }
        }

        return currentNode;
    }


    public void deleteByLoop(int key) throws Exception {
        TreeNode parentNode = getRoot();
        TreeNode currentNode = getRoot();
        boolean isLeftChild = false;

        if (currentNode==null) {
            throw new Exception("The tree is empty. ");
        }

        while(currentNode!=null && currentNode.getValue()!=key) {
            parentNode = currentNode;
            if(key < currentNode.getValue()) {
                isLeftChild = true;
                currentNode = currentNode.getLeft();
            } else {
                isLeftChild = false;
                currentNode = currentNode.getRight();
            }
        }

        if(currentNode.getLeft()==null && currentNode.getRight()==null) {
            if(isLeftChild) {
                parentNode.setLeft(null);
            } else {
                parentNode.setRight(null);
            }
        } else if(currentNode.getRight()==null) {
            if(isLeftChild) {
                parentNode.setLeft(currentNode.getLeft());
            } else {
                parentNode.setRight(currentNode.getLeft());
            }
        } else if (currentNode.getLeft()==null) {
            if(isLeftChild) {
                parentNode.setLeft(currentNode.getRight());
            } else {
                parentNode.setRight(currentNode.getRight());
            }
        } else {
            TreeNode successor = popSuccessor(currentNode);
            if(isLeftChild) {
                parentNode.setLeft(successor);
            } else {
                parentNode.setRight(successor);
            }
            successor.setLeft(currentNode.getLeft());
            successor.setRight(currentNode.getRight());
        }
    }
    private TreeNode popSuccessor(TreeNode treeNode) {  // 找右子樹最小的Node
        TreeNode currentNode = treeNode.getRight();
        TreeNode parentNode = treeNode;

        while (currentNode.getLeft()!=null) {
            parentNode = currentNode;
            currentNode = currentNode.getLeft();
        }

        parentNode.setLeft(currentNode.getRight());

        return currentNode;
    }

    public void traversePreOrder(TreeNode root) throws Exception {  // 立馬印
        if(root == null) {
            throw new Exception("Root is null! ");
        }

        TreeNode currentNode = root;

        System.out.print(currentNode.getValue());
        if(currentNode.getLeft() != null) {
            traversePreOrder(currentNode.getLeft());
        }
        if(currentNode.getRight() != null) {
            traversePreOrder(currentNode.getRight());
        }
    }
    public void traverseInOrder(TreeNode root) throws Exception {    // 左邊回來後印
        if(root == null) {
            throw new Exception("Root is null! ");
        }

        TreeNode currentNode = root;

        if(currentNode.getLeft() != null) {
            traverseInOrder(currentNode.getLeft());
        }
        System.out.print(currentNode.getValue());
        if(currentNode.getRight() != null) {
            traverseInOrder(currentNode.getRight());
        }
    }

    public void traversePostOrder(TreeNode root) throws Exception {  // 右邊回來後印
        if(root == null) {
            throw new Exception("Root is null! ");
        }

        TreeNode currentNode = root;

        if(currentNode.getLeft() != null) {
            traversePostOrder(currentNode.getLeft());
        }
        if(currentNode.getRight() != null) {
            traversePostOrder(currentNode.getRight());
        }
        System.out.print(currentNode.getValue());
    }
}

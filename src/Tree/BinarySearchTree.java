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


    public void deleteByLoop(int value) throws Exception {
        TreeNode parentNode = getRoot();
        TreeNode currentNode = getRoot();
        boolean isLeftChild = false;



        if (currentNode == null) {
            throw new Exception("Value " + value + " does not exist in the tree! ");
        }

        if (currentNode.getLeft()==null && currentNode.getRight()==null) {
            if (currentNode == getRoot()) {
                setRoot(null);
            } else if (isLeftChild) {
                parentNode.setLeft(null);
            } else {
                parentNode.setRight(null);
            }
        } else if (currentNode.getLeft()!=null && currentNode.getRight()==null) {
            if (currentNode == getRoot()) {
                setRoot(currentNode.getRight());
            } else if (isLeftChild) {
                parentNode.setLeft(currentNode.getLeft());
            } else {
                parentNode.setRight(currentNode.getLeft());
            }
        } else if (currentNode.getLeft()==null && currentNode.getRight()!=null) {
            if (currentNode == getRoot()) {
                setRoot(currentNode.getRight());
            } else if (isLeftChild) {
                parentNode.setLeft(currentNode.getRight());
            } else {
                parentNode.setRight(currentNode.getRight());
            }
        } else {

        }
    }

    public void deleteByRecursion(TreeNode root, int value) throws Exception {

//        if (root == null) {
//            setRoot(null);
//        } else if (value < root.getValue()) {
//            if (root.getLeft() != null) {
//                deleteInRecursion(root.getLeft(), value);
//            } else {
//
//            }
//        }
//
//
//        if (targetNode == null) {
//            throw new Exception("Value " + value + " does not exist in the tree! ");
//        }
//
//        TreeNode parent = null;
//        TreeNode successor = null;
//        boolean isLeft = false;
//
//        // 分情況討論
//        if (targetNode == getRoot()) {
//            setRoot(null);
//        } else {
//            if (targetNode.getLeft()!=null && targetNode.getRight()!=null) {
//
//            } else if (targetNode.getLeft()!=null && targetNode.getRight()==null) {
//
//            } else if (targetNode.getLeft()==null && targetNode.getRight()!=null) {
//
//            } else {
//
//            }
//        }
    }

    public void traversePreOrder() {

    }
    public void traverseInOrder() {

    }
    public void traversePostOrder() {

    }

    // private methods
    private TreeNode getSuccessor(TreeNode treeNode) {
        TreeNode successorNode = null;
        TreeNode successorParentNode = null;
        TreeNode currentNode = treeNode.getRight();

        while (currentNode != null) {
            successorParentNode = successorNode;
            successorNode = currentNode;
            currentNode = currentNode.getLeft();
        }

        return null;
    }
}

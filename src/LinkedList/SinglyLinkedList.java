package LinkedList;

public class SinglyLinkedList {

    SinglyNode head;
    SinglyNode tail;
    int size;

    // Constructor
    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Getter

    private void setHead(SinglyNode head) {
        this.head = head;
    }

    private void setTail(SinglyNode tail) {
        this.tail = tail;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public SinglyNode getHead() {
        return head;
    }

    public SinglyNode getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }


    // public methods
    public void insert(Object element, int position) throws Exception {
        if (position > getSize()) {
            throw new Exception("index out of bounds!");
        }

        SinglyNode newHead = new SinglyNode(element);

        if (position == 0) {
            newHead.setNext(getHead());
            setHead(newHead);
            return;
        }

        if (position == size) {
            newHead.setNext(null);
            getTail().setNext(newHead);
            setTail(newHead);
            return;
        }

        int count = 0;
        SinglyNode currentNode = getHead();
        SinglyNode formerNode = new SinglyNode();
        SinglyNode latterNode = new SinglyNode();
        while (count < position) {
            count++;
            if (count == position) {
                formerNode = currentNode;
                latterNode = currentNode.getNext().getNext();
            }
            currentNode = currentNode.getNext();
        }
        formerNode.setNext(currentNode);
        currentNode.setNext(latterNode);

        return;
    }


    public int find(Object element) {

        int index = 0;
        SinglyNode currentNode = getHead();

        while (!currentNode.getElementInsideNode().equals(element)) {
            currentNode = currentNode.getNext();
            index++;
            if (index > getSize()) {
                index = -1;
                break;
            }
        }
        return index;
    }


    public void delete(Object element) throws Exception {
        SinglyNode currentNode = getHead();

        if (currentNode == null) {
            throw new Exception("nothing to delete!");
        }

        if (currentNode.getElementInsideNode().equals(element)) {
            setHead(currentNode.getNext());
            setSize(getSize() - 1);
            return;
        } else {
            SinglyNode formerNode = currentNode;
            currentNode = currentNode.getNext();

            while (currentNode != null) {
                if (currentNode.getElementInsideNode().equals(element)) {

                }
            }
            if (currentNode == null) {
                throw new Exception("nothing to delete!");
            }
        }

        for (int i = 1; i < getSize(); i++) {
            if (currentNode.getElementInsideNode().equals(element)) {
                currentNode.setNext(currentNode.getNext().getNext());
                setSize(getSize() - 1);
                return;
            } else {
                if (currentNode.getNext() == null) {
                    throw new Exception("element not found!");
                }
                currentNode = currentNode.getNext();
            }
        }
    }
}

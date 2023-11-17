package Queue;

public interface QueueInterface<AnyType> {
    void enqueue(AnyType item);
    AnyType dequeue();
    AnyType peekFront();
    boolean isEmpty();
}

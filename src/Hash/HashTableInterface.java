package Hash;

public interface HashTableInterface {

    /**
     * Returns true when the key is found
     * @param key int key to search
     * @return boolean true if found, false if not found
     */
    boolean search(int key);

    /**
     * Deletes and returns an int key from the table
     * @param key int key to delete
     * @return the deleteed int key (if not found, -1)
     */
    int delete(int key);

    /**
     * Inserts a key into the table
     * @param key int key to insert
     */
    void insert(int key);
}

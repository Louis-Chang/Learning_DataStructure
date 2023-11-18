package Hash;

public class HashTable implements HashTableInterface {

    private static final DataItem DELETED = new DataItem(-1);
    private DataItem[] hashArray;

    public HashTable(int initialCapacity) {
        this.hashArray = new DataItem[initialCapacity];
    }

    /**
     * Returns true when the key is found
     *
     * @param key int key to search
     * @return boolean true if found, false if not found
     */
    @Override
    public boolean search(int key) {
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].key == key) {
                return true;
            }
            hashVal++;
            hashVal = hashVal % hashArray.length;
        }
        return false;
    }

    /**
     * Deletes and returns an int key from the table
     *
     * @param key int key to delete
     * @return the deleteed int key (if not found, -1)
     */
    @Override
    public int delete(int key) {
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].key == key) {
                int temp = hashArray[hashVal].key;
                hashArray[hashVal] = DELETED;
                return temp;
            }
        }
        return -1;
    }

    /**
     * Inserts a key into the table
     *
     * @param key int key to insert
     */
    @Override
    public void insert(int key) {
        int hashVal = hashFunc(key);
        while (hashArray[hashVal]!=null && hashArray[hashVal]!=DELETED) {
            hashVal++;
            hashVal = hashVal % hashArray.length;
        }
        DataItem dataItem = new DataItem(key);
        hashArray[hashVal] = dataItem;
    }

    private int hashFunc(int key) {
        return key % hashArray.length;
    }

    private static class DataItem {
        private int key;

        public DataItem(int key) {
            this.key = key;
        }
    }
}

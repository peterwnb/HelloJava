package data_structure.map;

public class MyHashMap implements Map {

    private int INIT_SIZE = 10;

    private Node[] table;

    private int size;

    //最大容量
    static final int MAXIMUM_CAPACITY = 1 << 30;

    // 默认加载因子为0.75f
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    //HashMap大小达到临界值，需要重新分配大小
    int threshold;
    /**
     * 加载因子
     */
    final float loadFactor;

    /**
     * 构造一个指定初始容量的HashMap
     */
    public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int initialCapacity, float loadFactor) {
        int capacity = 1;
        while (capacity < initialCapacity)
            capacity <<= 1;
        this.loadFactor = loadFactor;
        // 设置容量极限等于容量 * 负载因子
        threshold = (int) (capacity * loadFactor);
        // 初始化 table 数组
        table = new Node[capacity];
    }

    @Override
    public Object get(Object o) {
        return null;
    }

    @Override
    public void put(Object o, Object o2) {

    }


    /**
     * 节点类
     *
     * @param <K>
     * @param <V>
     */
    private static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;
        final int hash;

        Node(int h, K k, V v, Node<K, V> n) {
            value = v;
            next = n;
            key = k;
            hash = h;
        }

        public final boolean equals(Object o) {
            if (!(o instanceof Node)) {
                return false;
            }
            Node e = (Node) o;
            Object k1 = getKey();
            Object k2 = e.getKey();
            if (k1 == k2 || (k1 != null && k1.equals(k2))) {
                Object v1 = getValue();
                Object v2 = e.getValue();
                if (v1 == v2 || (v1 != null && v1.equals(v2)))
                    return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return (key == null ? 0 : key.hashCode()) ^
                    (value == null ? 0 : value.hashCode());
        }

        @Override
        public String toString() {
            return getKey() + "=" + getValue();
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}

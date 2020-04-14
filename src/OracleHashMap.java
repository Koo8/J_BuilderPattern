public class OracleHashMap<K, V>
{

    public static interface HashProvider<K>
    {
        // a mothod to turn a key into an int to be used as an index for the value in the array.

        public int getHashNumber(K key);
    }

    private V[] values;
    // create an instance of the interface to be used later
    private HashProvider<K> mProvider;

    // constructor
    // since a HashProvider is the parameter, so b4 this OracleHashMap
    // is created in any class, a provider interface needs to be created first.
    public OracleHashMap( HashProvider<K> provider)
    {
        values = (V[])new Object[1000];
        mProvider = provider;
    }
    
    public void put(K key, V value) {
        values[getKeyHash(key)] = value;
    }

    private int getKeyHash(K key) {
        // how to set up the unique index number for a specific key, the method should be decided when implement
        // this class, so set up an interface that ask the class who instantiate this class to set up the  rule

        // this to keep the newly created index number to be within the valuse array range.
        return mProvider.getHashNumber(key) % values.length;
    }

    public V get(K key) {
        return values[getKeyHash(key)];
    }
}

public class OracleArrayList<T>
{
    private T[] mItems;
    private int mFilledSpot;

    // create an array of 10
    public OracleArrayList()
    {
        mItems = (T[])new Object[1];
    }

    public void add(T item)
    {
        if(mFilledSpot < mItems.length) {
            mItems[mFilledSpot] = item;
            // increment the count of the index by 1
            mFilledSpot++;
        }else {
            T[] copy = mItems;
            mItems = (T[])new Object[copy.length + 1];
            for (int i = 0; i <copy.length ; i++) {
                mItems[i]= copy[i];
            }
            add(item);
        }
    }

    public int size()
    {
        return mItems.length;
    }

    public T get(int i)
    {
        return mItems[i];
    }
}
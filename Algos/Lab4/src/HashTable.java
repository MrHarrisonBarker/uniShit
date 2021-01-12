public class HashTable
{

    // public for testing purposes
    public int buckets[];

    private long a;
    private long c;
    private int m;

    private long numberOfElements;

    public HashTable(long _a, long _c, long _m)
    {
        a = _a;
        c = _c;
        m = (int) _m;
        buckets = new int[m];
        numberOfElements = 0;
    }

    public void insert(int key)
    {
        double load = loadFactor();
        if (load >= 1)
        {
            extend();
        }
        int hashValue = hash(key); // hash function

        if (buckets[hashValue] > 0)
        {
            // bucket is full
            boolean bucketFound = false;
            int i = hashValue;
            while (!bucketFound)
            {
                i++;
                if (buckets[i] == 0)
                {
                    buckets[i] = key;
                    bucketFound = true;
                    numberOfElements++;
                }
                // TODO: Out of bounds error
            }
        } else
        {
            // bucket is empty
            buckets[hashValue] = key;
            numberOfElements++;
        }
    }

    private int hash(int key)
    {
        return (int) ((a * key + c) % m);
    }

    public void extend()
    {
        int extensionFactor = 2;
        int[] tmp = buckets;
        m *= extensionFactor;
        buckets = new int[m];
        numberOfElements = 0;
        for (int key : tmp)
        {
            if (key > 0)
            {
                insert(key);
            }
        }
    }

    public boolean find(int key)
    {
        int hashValue = hash(key);
        int i = 0;
        while (true)
        {
            int value = buckets[hashValue + i];
            if (value == key)
            {
                System.out.println(hashValue + i);
                return true;
            }

            if (value == 0)
            {
                return false;
            }

            // possible out of bounds
            if (hashValue + i == m)
            {
                return false;
            }

            i++;
        }
    }

    public void remove(int key)
    {
        int hashValue = hash(key);
        int i = 0;
        boolean removed = false;
        while (!removed)
        {
            // if key is found remove
            if (buckets[hashValue + i] == key)
            {
                buckets[hashValue + i] = 0;
                numberOfElements = 0;
                int[] tmp = buckets;
                buckets = new int[m];

                for (int tmpKey : tmp)
                {
                    if (tmpKey > 0)
                    {
                        insert(tmpKey);
                    }
                }

                removed = true;

                // find duplicated and move up
//                int duplicates = 0;
//                int j = 0;
//                boolean noDuplicates = false;
//                while (!noDuplicates)
//                {
//
//
//                    if (buckets[hashValue + i + 1 + duplicates] == key)
//                    {
//                        duplicates++;
//                    }
//
//                    if (hashValue + i + j >= m) {
//                        noDuplicates = true;
//                    }
//
//                    j ++;

//                    if (hashValue + i + 1 + duplicates == m)
//                    {
//                        noDuplicates = true;
//                    }

//                        buckets[hashValue + i + duplicates - 1] = key;
//                        buckets[hashValue + i + duplicates] = 0;
//                        numberOfElements--;
//                    } else
//                    {
//                        return;
//                    }
//                    duplicates++;
            }
//                if (duplicates > 0)
//                {
//                    System.out.println(hashValue + i + duplicates);
//                    buckets[hashValue + i + duplicates] = 0;
//                    for (int d = duplicates - 1; d >= 0 ; d--)
//                    {
//                        buckets[hashValue + i + d] = key;
//                    }
//                }
//                return;
//            }

            // possible out of bounds
            if (hashValue + i == m)
            {
                return;
            }

            i++;
        }
    }

    public double loadFactor()
    {
        return (double) numberOfElements / (double) buckets.length;
    }
}

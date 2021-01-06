import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        HashTable hashTable = new HashTable(10, 8, 20);
        hashTable.insert(5);
        hashTable.insert(2);
        hashTable.insert(2);
        hashTable.insert(3);
        hashTable.insert(2);
        hashTable.insert(2);
        hashTable.insert(2);
        hashTable.remove(2);
        hashTable.remove(2);
        System.out.println(hashTable.find(2));
        //        for (int i = 0; i < 20; i++)
//        {
//            hashTable.insert((new Random().nextInt(10)) + 1);
//
//        }
//        System.out.println(hashTable.find(7));
    }
}

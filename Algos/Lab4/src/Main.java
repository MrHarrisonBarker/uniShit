public class Main
{
    public static void main(String[] args)
    {
        HashTable hashTable = new HashTable(11342, 11630, 104);
        hashTable.insert(33575210);
        System.out.println(hashTable.find(33575210));
        //        for (int i = 0; i < 20; i++)
//        {
//            hashTable.insert((new Random().nextInt(10)) + 1);
//
//        }
//        System.out.println(hashTable.find(7));
    }
}


class TestHashTable {
    public static void main (String [] args){
        HashTable <Integer, String> ht = new HashTable<>();
        ht.add(5, "Five");
        ht.add(5, "Five Modified");
        ht.add(2, "Two");
        System.out.println(ht.getValue(5));
        System.out.println(ht.getValue(2));
        ht.remove(2);
        ht.remove(5);
        System.out.println(ht.getValue(5));
        System.out.println(ht.getValue(2));

    }
}
import java.util.ArrayList;

public class HashTable <K , V> {
    ArrayList <HashNode <K , V>> hashArray;
    int size; 
    int numOfBuckets;

    HashTable (){
        hashArray = new ArrayList<>();
        size = 0;
        numOfBuckets = 10;

        for (int i = 0; i <numOfBuckets; i ++){
            hashArray.add(null);
        }
    }

public int getSize (){
    return size;
}

public Boolean isEmpty (){
    return getSize()== 0; 
}

public int getBucketIndex (K key){
    int hashCode = key.hashCode();
    int bucketIndex = hashCode % numOfBuckets;
    return Math.abs(bucketIndex);
}

public void add (K key , V value){
    int index = getBucketIndex(key);
    HashNode<K ,V> head = hashArray.get(index);
    while (head!= null){
        if (head.key.equals(key)){
            head.value = value;
        }
        head = head.next; 
    }
    size ++;
    HashNode <K, V> new_Node = new HashNode<>(key, value);
    new_Node.next = head;
    hashArray.set(index, new_Node);
        
    
}

public void remove (K key){
    int index = getBucketIndex(key);
    HashNode <K, V> head = hashArray.get(index);
    while (head != null){
        if (head.key.equals(key)){
            break;
        }
        head = head.next;
    }
    if (head == null){
        System.out.println("No key found");
    } else if (head.next == null){
        head = null;
        hashArray.set(index, head);
    } else {
        HashNode <K, V> prev = head;
        head = head.next;
        prev.next = null;
        hashArray.set(index, head);
    }

}

public V getValue (K key){
    int index = getBucketIndex(key);
    HashNode<K, V> head = hashArray.get(index);
     while (head != null){
         if (head.key.equals(key)){
             return head.value;
         }
         head = head.next;
     }
     return null;
}

}
package hotel.exceptions;
/**
 * Self-defined class for storing pair data
 */
public class Pair<K, V>{
    private K key;
    private V value;

    /**
     * Contructor
     * @param key key
     * @param value value
     */
    public Pair(K key, V value){
	this.key = key;
	this.value = value;
    }

    public K getKey(){
	return key;
    }

    public V getValue(){
	return value;
    }

    public void setKey(K key){
	this.key = key;
    }

    public void setValue(V value){
	this.value = value;
    }
}

// Function Used to sort the map entries based on the values 
static <K,V extends Comparable<? super V>>
    SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>((a,b)->a.getValue().compareTo(b.getValue())<0?-1:1);
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
}
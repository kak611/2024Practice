class TestMyHashMap {
	public static void main(String[] args) {
		MyHashMap<Integer, String> map = new MyHashMap();
		System.out.println("is Map empty: " + map.isEmpty());
		map.put(1, "one");
		map.put(2, "two");
		map.print();
	}
}
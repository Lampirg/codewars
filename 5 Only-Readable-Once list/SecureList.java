public class SecureList {
	private int[] array;
	
    public SecureList(int[] array) {
		this.array = array;
	}
	
	public int get(int index) {
		int toReturn = array[index];
		int array[] = new int[this.array.length - 1];
		for (int i = 0; i < index; i++)
			array[i] = this.array[i];
		for (int i = index; i < array.length; i++)
			array[i] = this.array[i + 1];
		this.array = array;
		return toReturn;
	}
	
	public String toString() {
		if (array.length == 0)
			return "[]";
		String toReturn = new String("[");
		for (int i = 0; i < array.length - 1; i++)
			toReturn += array[i] + ",";
		toReturn += array[array.length - 1] + "]";
		array = new int[0];
		return toReturn;
	}
	
	public int size() {
		return array.length;
	}
}
package stackQMap;

public class StackQMap {

	public static void main(String[] args) {

		stackX s = new stackX(10);

		s.push(20);
		s.push(40);
		s.push(60);
		s.push(80);

		while (!s.isEmpty()) {
			int value = s.pop();
			System.out.print(value + " ");
		}

		System.out.println();
	}
}

class stackX {

	private int size, top;
	private int[] arr;

	public stackX(int s) {
		size = s;
		arr = new int[s];
		top = -1;
	}

	public void push(int j) {
		arr[++top] = j;
	}

	public int pop() {
		return arr[top--];

	}

	public int peek() {
		return arr[top];

	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == size - 1);
	}

}
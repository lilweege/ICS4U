import java.util.Collection;
import java.util.TreeSet;
public class BinarySearch {



	public static <T extends Comparable<T>> int binarySearchRecursive(T[] arr, T target) {
		return binarySearchRecursive(arr, target, 0, arr.length-1);
	}
	
	public static <T extends Comparable<T>> int binarySearchRecursive(T[] arr, T target, int left, int right) {
		
		while (left <= right) {
			int mid = (right-left)/2 + left;
			System.out.print(arr[mid] + " -> ");
			int comp = arr[mid].compareTo(target);
			if (comp == 0) {
				return mid;
			}
			else if (comp > 0) {
				return binarySearchRecursive(arr, target, left, mid-1);
			}
			else if (comp < 0) {
				return binarySearchRecursive(arr, target, mid+1, right);
			}
		}
		return -1;
	}
	
	public static <T extends Comparable<T>> int binarySearchFirst(T[] arr, T target) {
		int left = 0;
		int right = arr.length-1;
		int ans = -1;

		while (left <= right) {
			int mid = (right-left)/2 + left;
			System.out.print(arr[mid] + " -> ");
			int comp = arr[mid].compareTo(target);
			if (comp < 0) {
				left = mid+1;
			}
			else if (comp > 0) {
				right = mid-1;
			}
			else if (comp == 0) {
				ans = mid;
				right = mid-1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {

		// regular binary trace (only works on pre-sorted arrays)
		System.out.println("Using regular binary trace (first index): ");
		System.out.println();
		Integer[] nums = new Integer[] {23, 27, 29, 31, 35, 39, 40, 41, 52, 66, 71, 74, 75, 90, 99};
		System.out.println("First index of 74 in numbers array: " + binarySearchRecursive(nums, 74));
		System.out.println("First index of 35 in numbers array: " + binarySearchFirst(nums, 35));
		System.out.println("First index of 62 in numbers array: " + binarySearchFirst(nums, 62));


		
		
		String[] animals = new String[] {"Bat", "Cat", "Cow", "Dog", "Elk", "Fly", "Fox", "Gnu", "Hen", "Owl", "Pig", "Rat", "Yak"};
		System.out.println("First index of \"Man\" in animals array: " + binarySearchFirst(animals, "Man"));
		System.out.println("\n");




		// if the arrays are not sorted, then a binary trace tree is valid
		nums = shuffleArray(nums);

		BST<Integer> tree = new BST<Integer>(nums);
		System.out.println("The shuffled array will be unordered: ");
		printArray(nums);
		System.out.println("The tree traversal will be ordered: ");
		tree.traverse();
		System.out.println();
		System.out.println("The trace for 74 in the BST: ");
		tree.trace(74);
		tree.remove(74);
		System.out.println("The trace for 35 in the BST: ");
		tree.trace(35);
		tree.remove(35);
		System.out.println("The trace for 62 in the BST: ");
		tree.trace(62);
		tree.remove(62);
		System.out.println("\n");

		
		

		animals = shuffleArray(animals);
		BST<String> zoo = new BST<String>(animals);
		System.out.println("Shuffed: ");
		printArray(animals);
		System.out.println("Using BST: ");
		zoo.traverse();
		System.out.println();
		System.out.println("The trace for \"Man\" in the BST: ");
		zoo.trace("Man");
		System.out.println("\n");



		
		
		

		System.out.println("Any object (even custom ones) can be used, as long as they are comparable.");
		System.out.println();
		BST<Point> points = new BST<Point>() {
			{
				for (int i = 0; i < 500; i++) {
					insert(new Point()); // the default point with no params will be random
				}
			}
		};

		points.traverse();
		System.out.println("The trace for a random point in BST: ");
		points.trace(new Point(1, 1));
		System.out.println("\n");
		
		
		
		
		
		
		
		Student[] students = new Student[] {
				new Student("Quattrociocchi Luigi", 335231),
				new Student("El Ashmawy Ahmed", 571932),
				new Student("Bedaywi Mark", 466317),
				new Student("Nagpal Yash", 100283),
				new Student("Castro Andrew", 991293)
				};
		
		BST<Student> classroom = new BST<Student>(students);
		classroom.traverse();
		

		System.out.println("\n");
		
		System.out.println("Alternatively, java's built in TreeSet can be used.");
		TreeSet<Point> ts = new TreeSet<Point>() {

			{
				for (int i = 0; i < 500; i++) {
					add(new Point());
				}
			}
		};
		System.out.println(ts.toString());
		System.out.println(ts.contains(new Point(1, 1)));
		
	}


	// some helper functions used for
	public static <T> T[] shuffleArray(T[] arr) {
		int n = arr.length;
		for (int i = n-1; i > 0; i--) {
			int j = (int)(Math.random()*n);
			T temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		return arr;
	}

	public static <T> void printArray(T[] arr) {
		for (T elm : arr) {
			System.out.print(elm + " ");
		}
		System.out.println();
	}
}


// some custom objects used to demonstrate binary search tree
class Student implements Comparable<Student> {
	public final String name;
	public final int id;
	public final double avg;
	public final String[] schedule;
	
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
		this.avg = 100;
		this.schedule = new String[4];
	}
	
	public Student(String name, int id, double avg, String[] schedule) {
		this.name = name;
		this.id = id;
		this.avg = avg;
		this.schedule = schedule;
	}
	
	public String toString() {
		return name.toString();
	}
	
	public int compareTo(Student other) {
		int compName = this.name.compareTo(other.name);
		if (compName > 0) return 1;
		if (compName < 0) return -1;

		int compId = this.id - other.id;
		if (compId > 0) return 1;
		if (compId < 0) return -1;
		return 0;
	}
}


class Point implements Comparable<Point> {
	public final double x;
	public final double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point(int min, int max, int precision) {
		this.x = Math.floor((Math.random()*(max-min+1)+min)*Math.pow(10, precision))/Math.pow(10, precision);
		this.y = Math.floor((Math.random()*(max-min+1)+min)*Math.pow(10, precision))/Math.pow(10, precision);
	}

	public Point() {
		int min = 1;
		int max = 25;
		int precision = 0;
		this.x = Math.floor((Math.random()*(max-min+1)+min)*Math.pow(10, precision))/Math.pow(10, precision);
		this.y = Math.floor((Math.random()*(max-min+1)+min)*Math.pow(10, precision))/Math.pow(10, precision);
	}

	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}

	public int compareTo(Point other) {
		if (this.x > other.x) return 1;
		if (this.x < other.x) return -1;
		if (this.y > other.y) return 1;
		if (this.y < other.y) return -1;
		return 0;
	}
}




class BST<T extends Comparable<T>> {
	class Node {
		T obj;
		Node left;
		Node right;

		public Node(T obj) {
			this.obj = obj;
			left = null;
			right = null;
		}

		public String toString() {
			return this.obj.toString();
		}
	}


	Node root;
	public BST() {
		this.root = null;
	}

	public BST(T root) {
		this.root = new Node(root);
	}

	public BST(T[] arr) {
		for (T obj : arr) {
			insert(obj);
		}
	}
	
	public BST(Collection<? extends T> c) {
		for (T obj : c) {
			insert(obj);
		}
	}


	public T trace(T obj) {
		Node cur = root;

		while (cur != null) {
			System.out.print(cur.obj + " ");
			int comp = cur.obj.compareTo(obj);
			if (comp == 0) {
				System.out.println();
				return cur.obj;
			}
			else if (comp > 0) {
				cur = cur.left;
			}
			else if (comp < 0) {
				cur = cur.right;
			}
			System.out.print("-> ");
		}
		System.out.print("null");
		System.out.println();
		return null;
	}

	public T search(T obj) {
		Node cur = root;

		while (cur != null) {
			int comp = cur.obj.compareTo(obj);
			if (comp == 0) {
				System.out.println();
				return cur.obj;
			}
			else if (comp > 0) {
				cur = cur.left;
			}
			else if (comp < 0) {
				cur = cur.right;
			}
		}
		return null;
	}

	public boolean contains(T obj) {
		return search(obj) != null;
	}

	public boolean insert(T obj) {
		if (root == null) {
			root = new Node(obj);
			return true;
		}

		Node cur = root;
		Node par = null;

		while (true) {
			par = cur;

			int comp = cur.obj.compareTo(obj);
			if (comp > 0) {
				cur = cur.left;
				if (cur == null) {
					par.left = new Node(obj);
					return true;
				}
			}
			if (comp < 0) {
				cur = cur.right;
				if (cur == null) {
					par.right = new Node(obj);
					return true;
				}
			}
			if (comp == 0) {
				return false;
			}
		}
	}

	public boolean remove(T obj) {

		Node par = root;
		Node cur = root;

		boolean isLeftChild = false;

		while (cur.obj != obj) {

			par = cur;

			int comp = cur.obj.compareTo(obj);

			if (comp > 0) {
				isLeftChild = true;
				cur = cur.left;
			}
			else if (comp < 0) {
				isLeftChild = false;
				cur = cur.right;
			}

			// case node does not exist in tree
			if (cur == null) {
				return false;
			}
		}



		// node exists in tree

		// case node has no children
		if (cur.left == null && cur.right == null) {

			// simply remove node
			if (cur == root) {
				root = null;
			}
			if (isLeftChild) {
				par.left = null;
			}
			else {
				par.right = null;
			}
		}


		// case node has only one child
		else if ((cur.right == null) != (cur.left == null)) {

			if (cur.right == null) {
				if (cur == root) {
					root = cur.left;
				}
				else if (isLeftChild) {
					par.left = cur.left;
				}
				else {
					par.right = cur.left;
				}
			}
			else if (cur.left == null) {
				if (cur == root) {
					root = cur.right;
				}
				else if (isLeftChild) {
					par.left = cur.right;
				}
				else {
					par.right = cur.right;
				}
			}
		}


		// case node has both children
		else if (cur.left != null && cur.right != null) {
			Node successor = null;
			Node successorParent = null;
			Node temp = cur.right;
			while (temp != null) {
				successorParent = successor;
				successor = temp;
				temp = temp.left;
			}

			if (successor != cur.right) {
				successorParent.left = successor.right;
				successor.right = cur.right;
			}

			if (cur == root) {
				root = successor;
			}
			else if (isLeftChild) {
				par.left = successor;
			}
			else {
				par.right = successor;
			}
			successor.left = cur.left;
		}

		return true;
	}

	public void traverse() {
		traverse(root);
		System.out.println();
	}

	public void traverse(Node root) {
		if (root != null) {
			traverse(root.left);
			System.out.print(root + " ");
			traverse(root.right);
		}
	}
}

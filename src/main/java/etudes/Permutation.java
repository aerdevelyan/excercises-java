package etudes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This is a non-recursive implementation of the 'remove-one-and-permutate-rest' algorithm.
 * Instead of recursion it uses a queue thus being easier to understand how it works.
 * 
 * Each instance of the class represents a unit for permutation consisting of two collections:
 * fixed - where already permutated elements are kept
 * permutable - elements that are left to be permutated  
 */
public class Permutation<T> {
	private final List<T> fixedElements;
	private final List<T> permutableElements;

	public Permutation(List<T> fixedElements, List<T> permutableElements) {
		this.fixedElements = fixedElements;
		this.permutableElements = permutableElements;
	}

	public void printAllPermutations() {
		Queue<Permutation<T>> q = new LinkedList<>();
		q.add(this);
		
		while (!q.isEmpty()) {
			Permutation<T> permutation = q.remove();
			List<T> permutableElements = permutation.permutableElements;
			if (permutableElements.size() == 0) {
				// only fixed elements are left here - print them and take another permutation unit from the queue
				System.out.println(Arrays.toString(permutation.fixedElements.toArray()));
				continue;
			}
			for (int i = 0; i < permutableElements.size(); i++) {
				List<T> fixedElements = new ArrayList<>(permutation.fixedElements);
				T fixedElement = permutableElements.get(i);
				fixedElements.add(fixedElement);
				List<T> newPermutableElements = new ArrayList<T>(permutableElements);
				newPermutableElements.remove(i);
				Permutation<T> newPermutation = new Permutation<>(fixedElements, newPermutableElements);
				q.add(newPermutation);
			}
		}
	}
	

	public static void main(String[] args) {
		Integer[] items = { 1, 2, 3, 4 };
		Permutation<Integer> initialPermutation = new Permutation<>(new ArrayList<Integer>(), new ArrayList<>(Arrays.asList(items)));
		initialPermutation.printAllPermutations();
	}
	
}

package april30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class InsertRemoveRandom {

	ArrayList<Integer> list;
	HashMap<Integer, Integer> map;
	Random rd;

	/** Initialize your data structure here. */
	public InsertRemoveRandom() {
		this.list = new ArrayList<>();
		this.map = new HashMap<>();
		rd = new Random();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		System.out.println(map);
		System.out.println(map.containsKey(val));
		if (map.containsKey(val))
			return false;

		map.put(val, list.size());
		list.add(val);
		return true;

	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */

	public boolean remove(int val) {
		if (!map.containsKey(val))
			return false;

		int idx = map.get(val);
		int lastIdx = list.size() - 1;
		map.remove(val);

		if (idx != lastIdx) {

			int lastVal = list.get(lastIdx);

			list.set(idx, lastVal);

			map.put(lastVal, idx);
		}
		list.remove(lastIdx);

		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		if (list.size() == 0)
			return 0;

		int idx = rd.nextInt(list.size());

		System.out.println(map);

		return list.get(idx);
	}

	public static void main(String[] args) {

		InsertRemoveRandom randomSet = new InsertRemoveRandom();

		// Inserts 1 to the set. Returns true as 1 was inserted successfully.

		// Returns false as 2 does not exist in the set.
		randomSet.remove(0);

		// Inserts 2 to the set, returns true. Set now contains [1,2].
		randomSet.insert(0);

		// getRandom should return either 1 or 2 randomly.
		randomSet.getRandom();

		// Removes 1 from the set, returns true. Set now contains [2].
		randomSet.remove(0);

		randomSet.insert(0);

	}
}

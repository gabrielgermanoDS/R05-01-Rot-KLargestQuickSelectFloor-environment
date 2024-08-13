package problems;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {

		return binarySearch(array, 0, array.length - 1, x);
		
	}

	public Integer binarySearch(Integer[] array, int l, int r, Integer x) {
		if (x < array[0]) {
            return null;
        }

		int m;

		while (l <= r) {

			m = (l + r) / 2; 

			if (array[m].equals(x)) {
				return array[m];
			}

			if (l == r) {
				return array[m];
			}

			else if (x.compareTo(array[m]) > 0) {
				l = m + 1;
			} else {
				r = m - 1;
			}

		}

		return null;
	}

}

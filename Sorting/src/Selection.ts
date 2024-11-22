const main = () => {
	const arr = [13, 46, 24, 52, 20, 9];

	const sortedArr = selectionSort(arr);

	console.log(sortedArr);
};

const selectionSort = (arr: number[]): number[] => {
	for (let i = 0; i < arr.length - 1; i++) {
		let minIndex = i;

		for (let j = i; j < arr.length; j++) {
			if (arr[j] < arr[minIndex]) minIndex = j;
		}

		swap(arr, minIndex, i);
	}

	return arr;
};

const swap = (arr: number[], a: number, b: number) => {
	const temp = arr[a];
	arr[a] = arr[b];
	arr[b] = temp;
};

main();

// TC: O(N^2) 	SC: O(1)

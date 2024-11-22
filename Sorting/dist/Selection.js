"use strict";
const main = () => {
    const arr = [13, 46, 24, 52, 20, 9];
    const sortedArr = selectionSort(arr);
    console.log(sortedArr);
};
const selectionSort = (arr) => {
    for (let i = 0; i < arr.length - 1; i++) {
        let minIndex = i;
        for (let j = i; j < arr.length; j++) {
            if (arr[j] < arr[minIndex])
                minIndex = j;
        }
        swap(arr, minIndex, i);
    }
    return arr;
};
const swap = (arr, a, b) => {
    const temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
};
main();

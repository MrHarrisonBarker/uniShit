function BubbleSort(A) {
    let swapped = true;
    while (swapped) {
        swapped = false;
        for (let index = 0; index < A.length - 1; index++) {
            let nextElement = A[index + 1];
            let element = A[index];

            if (element > nextElement) {
                A[index] = nextElement;
                A[index + 1] = element;
                swapped = true
            }
        }
    }
    return A;
}

let A = [9, 8, 7, 6, 5, 4, 3, 2, 1];

console.log(BubbleSort(A));


function InsertionSort(A) {
    for (let index = 1; index <= A.length - 1; index++) {
        let element = A[index]
        let insertionIndex = index - 1;
        while(insertionIndex >= 0 && element < A[insertionIndex]) {
            A[insertionIndex + 1] = A[insertionIndex];
            insertionIndex --;
        }   
        A[insertionIndex + 1] = element;
    }
    return A;
}

let B = [9, 8, 7, 6, 5, 4, 3, 2, 1];

console.log(InsertionSort(B));
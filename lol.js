let A = [
    [2, 2, 22, 2],
    [2, 22, 2, 2],
    [12, 31324, 123, 124]
];

console.log(A.reduce((acc,val) => {
    console.log(acc + val);
    // return A[acc];
}));
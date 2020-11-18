function f(A,i,j) {
    if (i<=j && i>0 && j < A.length) {
        for (k=i;k<=j; k++) {
            if (A[k]%2 == 0) {
                A[k] ++;
            }
        }
    }
    return A;
}

function sum(i) 
{
    if (i == 1) 
    {
        return 1;
    }

    return sum(i - 1) + i;
}

function fib(n) 
{
    if (n == 0) 
    {
        return 0;
    }

    if (n == 1) 
    {
        return 1;
    }

    return fib(n-1) + fib(n-2);
}

console.log(sum(100));
console.log(f([1,2,3,4,5],1,3));
console.log(fib(5));
for (i = 0; i < 10; i ++) {
    console.log(fib(i));
}
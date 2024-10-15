function chunk(arr, n) {
    return Array.from({ length: Math.ceil(arr.length / n) }, (_, i) => arr.slice(n * i, n * (i + 1)))
}

chunk([1, 2, 3, 4, 5, 6, 7], 2)
    .forEach((val, idx, arr) => {
        console.log(val)
    })
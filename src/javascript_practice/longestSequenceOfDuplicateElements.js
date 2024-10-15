function longestSequenceOfDuplicateElements(arr) {
    let [x,y] = [0,0]
    let max = 1
    let [mx,my]=[0,0]
    for (let i = 1; i < arr.length; ++i) {
        if (arr[i] == arr[i-1]) {
            y = i
        }
        
        if (arr[i] != arr[i-1] || i == arr.length - 1) {
            if (y - x + 1 > max) {
                [mx,my] = [x,y]
                max = y - x + 1
            }
            [x, y] = [i, i]
        }
    }

    return arr.slice(mx,my+1)
}

let res = longestSequenceOfDuplicateElements([1,1,1,1,1,1,2,2,4,4,4,4,3,3,3])
console.log(res)
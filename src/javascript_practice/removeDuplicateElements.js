function removeDuplicateElements(arr) {
    return [...new Set(arr)]
}

let result = removeDuplicateElements([1,2,2,3,3,3,4,4,4,4])
console.log(result)
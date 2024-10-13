// abc def ghi => ghi def abc
function reverseWordsInString(s) {
    return s.split(' ')
        .map((val, idx, arr) => {
            console.log(`before filter: ${val}`)
            return val
        })
        .filter((value, index, arr) => value.length > 0)
        .map((val, idx, arr) => {
            console.log(`after filter: ${val}`)
            return val
        })
        .reverse()
        .join(' ')
}

let result = reverseWordsInString("abc    def ghi")
console.log(`result: ${result}`)

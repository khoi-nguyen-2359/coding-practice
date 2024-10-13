// format: YYYY-MM-DD
function formatDate(date) {
    return `${date.getFullYear()}-${date.getMonth()}-${date.getDate()}`
}

let result = formatDate(new Date())
console.log(result)
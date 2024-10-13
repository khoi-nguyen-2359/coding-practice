function mergeTwoObjsWithoutOverriding(objA, objB) {
    return {...objB, ...objA}
}

let result = mergeTwoObjsWithoutOverriding(
    { a: 'a', b: 'b'},
    { c: 'c', d: 'd', a: 'x'}
)
console.log(result)
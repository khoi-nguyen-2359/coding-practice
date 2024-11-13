const testLoop = function(testcases, func) {
    testcases.forEach((tc, idx) => {
        console.log(idx + 1, ". Test Case: ", JSON.stringify(tc))
        var actual = func(...Object.values(tc))
        var assert = JSON.stringify(tc.expect) == JSON.stringify(actual)
        if (assert) {
            console.log('PASSED ✅')
        } else {
            console.log('FAILED ❌, actual: ', actual)
        }
    });
}

exports.testLoop = testLoop
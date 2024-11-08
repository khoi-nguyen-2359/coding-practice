const testLoop = function(testcases, func) {
    testcases.forEach(tc => {
        console.log("Test Case: ", tc)
        var actual = func(...Object.values(tc))
        var assert = actual == tc.expect
        if (assert) {
            console.log('PASSED ✅')
        } else {
            console.log('FAILED ❌, actual: ', actual)
        }
    });
}

exports.testLoop = testLoop
package hackerrank_Day_of_the_Programmer

/*
 * Complete the 'dayOfProgrammer' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts INTEGER year as parameter.
 */

/*
256th day in normal year: 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 13
256th day in leap year: 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 12
256th day in 1918: 31 + 15 + 31 + 30 + 31 + 30 + 31 + 31 + 26
 */

fun dayOfProgrammer(year: Int): String = when {
    (year in 1700 .. 1917 && year % 4 == 0)
            || (year in 1919 .. 2700 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0))
    -> "12.09.$year"
    year in 1700 .. 1917 || year in 1919 .. 2700 -> "13.09.$year"
    year == 1918 -> "26.09.1918" // 1918
    else -> "" // out of constraints
}

fun main(args: Array<String>) {
    val year = readLine()!!.trim().toInt()

    val result = dayOfProgrammer(year)

    println(result)
}

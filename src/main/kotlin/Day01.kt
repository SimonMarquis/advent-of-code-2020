class Day01(raw: List<String>) {

    private val input: List<Int> = raw.map(String::toInt)

    fun part1(): Int {
        for (i in 0 until input.size - 1) {
            val iValue = input[i]
            for (j in i until input.size) {
                val jValue = input[j]
                if (iValue + jValue == 2020) return iValue * jValue
            }
        }
        return -1
    }

    fun part2(): Int {
        for (i in 0 until input.size - 2) {
            val iValue = input[i]
            for (j in i until input.size - 1) {
                val jValue = input[j]
                for (k in j until input.size) {
                    val kValue = input[k]
                    if (iValue + jValue + kValue == 2020) return iValue * jValue * kValue
                }
            }
        }
        return -1
    }

}
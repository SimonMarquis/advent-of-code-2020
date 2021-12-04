import java.lang.Exception

class Day05(raw: List<String>) {

    private val seatIds: Sequence<Int> = raw.asSequence().map {
        seatId(
            row = it.frontBack(),
            column = it.leftRight(),
        )
    }

    companion object {
        val FRONT_BACK_RANGE = 0..127
        val LEFT_RIGHT_RANGE = 0..7
    }

    fun part1(): Int = seatIds.maxOf { it }

    fun part2(): Int = seatIds.sorted().windowed(size = 2).first { (l, r) -> l.inc() != r }.first().inc()

    private fun IntRange.lowerHalf() = IntRange(start = start, endInclusive = endInclusive - count() / 2)

    private fun IntRange.upperHalf() = IntRange(start = start + count() / 2, endInclusive = endInclusive)

    private fun String.frontBack() = take(7).fold(FRONT_BACK_RANGE) { acc: IntRange, char: Char ->
        when (char) {
            'F' -> acc.lowerHalf()
            'B' -> acc.upperHalf()
            else -> throw Exception()
        }
    }.value()

    private fun String.leftRight() = takeLast(3).fold(LEFT_RIGHT_RANGE) { acc: IntRange, char: Char ->
        when (char) {
            'L' -> acc.lowerHalf()
            'R' -> acc.upperHalf()
            else -> throw Exception()
        }
    }.value()

    private fun IntRange.value(): Int {
        assert(first == last)
        return first
    }

    private fun seatId(row: Int, column: Int) = row * 8 + column

}

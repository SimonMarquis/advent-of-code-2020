class Day03(raw: List<String>) {

    private val forest: Forest = Forest.parse(raw)

    fun part1(): Long = forest.trees(Slope(right = 3, down = 1))

    fun part2(): Long = listOf(
        Slope(right = 1, down = 1),
        Slope(right = 3, down = 1),
        Slope(right = 5, down = 1),
        Slope(right = 7, down = 1),
        Slope(right = 1, down = 2),
    ).map(forest::trees).reduce { acc, i -> acc * i }

    data class Forest(val raw: List<BooleanArray>) {

        companion object {

            fun parse(lines: List<String>): Forest = lines.map { line ->
                line.map { it.toTree() }.toBooleanArray()
            }.let(::Forest)

            private fun Char.toTree() = when (this) {
                '#' -> true
                '.' -> false
                else -> throw Exception()
            }

        }

        private operator fun get(position: Position): Boolean = raw[position.y].let { it[position.x % it.size] }

        private fun horizontal(slope: Slope): Sequence<Int> = generateSequence(0) { x -> x + slope.right }

        private fun vertical(slope: Slope): Sequence<Int> = generateSequence(0) { y -> (y + slope.down).takeUnless { it >= raw.size } }

        private fun positions(slope: Slope): Sequence<Position> = horizontal(slope).zip(vertical(slope), ::Position)

        fun trees(slope: Slope): Long = positions(slope).count { this[it] }.toLong()

    }

    data class Slope(val right: Int, val down: Int)

    data class Position(val x: Int, val y: Int)


}
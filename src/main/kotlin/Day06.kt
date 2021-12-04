class Day06(raw: List<String>) {

    private val input: List<String> = raw

    fun part1(): Int = input.fold(mutableListOf(mutableSetOf())) { acc: MutableList<MutableSet<Char>>, line: String ->
        acc.apply {
            when {
                line.isEmpty() -> add(mutableSetOf())
                else -> last().addAll(line.toList())
            }
        }
    }.sumOf { it.count() }

    fun part2(): Int = input.fold(mutableListOf(mutableListOf())) { acc: MutableList<MutableList<Set<Char>>>, line: String ->
        acc.apply {
            when {
                line.isEmpty() -> add(mutableListOf())
                else -> last().add(line.toSet())
            }
        }
    }.sumOf { group ->
        val answers = mutableMapOf<Char, Int>()
        group.forEach { line ->
            line.forEach { char ->
                answers[char] = answers[char]?.inc() ?: 1
            }
        }
        answers.count { it.value == group.size }
    }

}
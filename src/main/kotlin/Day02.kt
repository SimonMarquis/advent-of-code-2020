class Day02(raw: List<String>) {

    private val input = raw.map(PasswordWithPolicy.Companion::parse)

    fun part1(): Int = input.count(PasswordWithPolicy::validate1)

    fun part2(): Int = input.count(PasswordWithPolicy::validate2)

    data class PasswordWithPolicy(val password: String, val char: Char, val range: IntRange) {

        companion object {

            private val pattern = """(\d+)-(\d+) ([a-z]): ([a-z]+)""".toRegex()

            fun parse(string: String): PasswordWithPolicy {
                val (min, max, char, password) = pattern.find(string)!!.destructured
                return PasswordWithPolicy(password, char.single(), min.toInt()..max.toInt())
            }
        }

        fun validate1() = password.count { it == char } in range

        fun validate2() = (password[range.first - 1] == char) xor (password[range.last - 1] == char)

    }

}
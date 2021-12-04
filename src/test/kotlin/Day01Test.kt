import Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 01")
class Day01Test {

    val sampleInput = resourceAsList("Day01-sample.txt")
    val actualInput = resourceAsList("Day01.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() = assertEquals(
            expected = 514579,
            actual = Day01(sampleInput).part1(),
        )

        @Test
        fun `Actual answer`() = assertEquals(
            expected = 996075,
            actual = Day01(actualInput).part1(),
        )
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() = assertEquals(
            expected = 241861950,
            actual = Day01(sampleInput).part2(),
        )

        @Test
        fun `Actual answer`() = assertEquals(
            expected = 51810360,
            actual = Day01(actualInput).part2(),
        )
    }

}
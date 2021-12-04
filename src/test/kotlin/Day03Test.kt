import Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 03")
class Day03Test {

    val sampleInput = resourceAsList("Day03-sample.txt")
    val actualInput = resourceAsList("Day03.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() = assertEquals(
            expected = 7,
            actual = Day03(sampleInput).part1(),
        )

        @Test
        fun `Actual answer`() = assertEquals(
            expected = 145,
            actual = Day03(actualInput).part1(),
        )
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() = assertEquals(
            expected = 336,
            actual = Day03(sampleInput).part2(),
        )

        @Test
        fun `Actual answer`() = assertEquals(
            expected = 3424528800,
            actual = Day03(actualInput).part2(),
        )
    }

}
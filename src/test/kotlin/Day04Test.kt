import Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 04")
class Day04Test {

    val sampleInput = resourceAsList("Day04-sample.txt")
    val actualInput = resourceAsList("Day04.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() = assertEquals(
            expected = 2,
            actual = Day04(sampleInput).part1(),
        )

        @Test
        fun `Actual answer`() = assertEquals(
            expected = 204,
            actual = Day04(actualInput).part1(),
        )
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() = assertEquals(
            expected = 2,
            actual = Day04(sampleInput).part2(),
        )

        @Test
        fun `Actual answer`() = assertEquals(
            expected = 179,
            actual = Day04(actualInput).part2(),
        )
    }

}
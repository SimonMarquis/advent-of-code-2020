import Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 06")
class Day06Test {

    val sampleInput = resourceAsList("Day06-sample.txt")
    val actualInput = resourceAsList("Day06.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() = assertEquals(
            expected = 11,
            actual = Day06(sampleInput).part1(),
        )

        @Test
        fun `Actual answer`() = assertEquals(
            expected = 6630,
            actual = Day06(actualInput).part1(),
        )
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() = assertEquals(
            expected = 6,
            actual = Day06(sampleInput).part2(),
        )

        @Test
        fun `Actual answer`() = assertEquals(
            expected = 3437,
            actual = Day06(actualInput).part2(),
        )
    }

}
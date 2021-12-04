import Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 02")
class Day02Test {

    val sampleInput = resourceAsList("Day02-sample.txt")
    val actualInput = resourceAsList("Day02.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() = assertEquals(
            expected = 2,
            actual = Day02(sampleInput).part1(),
        )

        @Test
        fun `Actual answer`() = assertEquals(
            expected = 538,
            actual = Day02(actualInput).part1(),
        )
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() = assertEquals(
            expected = 1,
            actual = Day02(sampleInput).part2(),
        )

        @Test
        fun `Actual answer`() = assertEquals(
            expected = 489,
            actual = Day02(actualInput).part2(),
        )
    }

}
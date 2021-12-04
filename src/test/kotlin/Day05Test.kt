import Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 05")
class Day05Test {

    val sampleInput = resourceAsList("Day05-sample.txt")
    val actualInput = resourceAsList("Day05.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() = assertEquals(
            expected = 820,
            actual = Day05(sampleInput).part1(),
        )

        @Test
        fun `Actual answer`() = assertEquals(
            expected = 901,
            actual = Day05(actualInput).part1(),
        )
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Actual answer`() = assertEquals(
            expected = 661,
            actual = Day05(actualInput).part2(),
        )
    }

}
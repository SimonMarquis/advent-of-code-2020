import Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 00")
class Day00Test {

    val sampleInput = resourceAsList("Day00-sample.txt")
    val actualInput = resourceAsList("Day00.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() = assertEquals(
            expected = Unit,
            actual = Day00(sampleInput).part1(),
        )

        @Test
        fun `Actual answer`() = assertEquals(
            expected = Unit,
            actual = Day00(actualInput).part1(),
        )
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() = assertEquals(
            expected = Unit,
            actual = Day00(sampleInput).part2(),
        )

        @Test
        fun `Actual answer`() = assertEquals(
            expected = Unit,
            actual = Day00(actualInput).part2(),
        )
    }

}
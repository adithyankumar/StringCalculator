import kotlin.test.Test
import kotlin.test.assertEquals

class StringCalculatorTest {

    private val stringCalculator = StringCalculator()

    @Test
    fun `pass empty input string then return 0`() {
        val inputStr = ""
        val expected = 0
        assertEquals(expected , stringCalculator.add(inputStr))
    }

    @Test
    fun `pass 1 as input string then return 1`() {
        val inputStr = "1"
        val expected = 1
        assertEquals(expected , stringCalculator.add(inputStr))
    }

    @Test
    fun `pass 1,2 as input string then return 3`() {
        val inputStr = "1,2"
        val expected = 3
        assertEquals(expected , stringCalculator.add(inputStr))
    }

    @Test
    fun `allow the Add method to handle new lines between numbers`() {
        val inputStr = "1\n2,3"
        val expected = 6
        assertEquals(expected , stringCalculator.add(inputStr))
    }

    @Test
    fun `support different delimiters`() {
        val inputStr = "//;\n1;2"
        val expected = 3
        assertEquals(expected , stringCalculator.add(inputStr))
    }

}
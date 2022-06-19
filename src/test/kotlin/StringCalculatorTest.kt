import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class StringCalculatorTest {

    private val stringCalculator = StringCalculator()

    @Test
    fun `pass empty input string then return 0`() {
        val inputStr = ""
        val expected = 0
        assertEquals(expected , stringCalculator.add(inputStr))
    }

    @Test
    fun `pass one number as input string then return sum`() {
        val inputStr = "1"
        val expected = 1
        assertEquals(expected , stringCalculator.add(inputStr))
    }

    @Test
    fun `pass two number as input string then return sum`() {
        val inputStr = "1,2"
        val expected = 3
        assertEquals(expected , stringCalculator.add(inputStr))
    }

    @Test
    fun `allow the add method to handle new lines between numbers then return sum`() {
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

    @Test
    fun `calling add with a negative number then throws Exception`() {
        assertFailsWith<Exception> {
            val inputStr = "//;\n-1;2"
            stringCalculator.add(inputStr)
        }
    }

    @Test
    fun `numbers bigger than 1000 should be ignored then return sum`() {
        val inputStr = "//;\n1001;2"
        val expected = 2
        assertEquals(expected , stringCalculator.add(inputStr))
    }

    @Test
    fun `delimiters can be of any length but should be ignored then return sum`() {
        val inputStr = "//[***]\n1***2***3"
        val expected = 6
        assertEquals(expected , stringCalculator.add(inputStr))
    }

    @Test
    fun `allow multiple delimiters but should be ignored then return sum`() {
        val inputStr = "//[*][%]\n1*2%3"
        val expected = 6
        assertEquals(expected , stringCalculator.add(inputStr))
    }


    @Test
    fun `allow multiple delimiters with length longer than one char but should be ignored then return sum`() {
        val inputStr = "//[****][%***]\n1****%*\n2%%%%%%3"
        val expected = 6
        assertEquals(expected , stringCalculator.add(inputStr))
    }

}
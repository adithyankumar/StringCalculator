class StringCalculator {
    fun add(input : String) : Int{
        if (!input.isNullOrEmpty()){
            val delimiters = ","
            val whiteSpaceChar ="\n"
            var newInput = input.replace(whiteSpaceChar, delimiters)
            var sum = 0
            var splitArray = newInput.split(delimiters)
            for (operandStr in splitArray){
                var operand = operandStr.toInt()
                sum +=operand
            }
            return  sum
        }
        return 0
    }
}
fun main(args : Array<String>){
    val stringCalculator = StringCalculator()
    println("Sum = ${stringCalculator.add("1,2\n2")}")
}


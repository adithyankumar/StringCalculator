class StringCalculator {
    fun add(input : String) : Int{
        if (input.isNotEmpty()){
            val delimiters: String
            val startingDelimiter ="//"
            val whiteSpaceChar ="\n"
            var newInput : String
            if (input.length > 2 && input.substring(0,2) == startingDelimiter){
                delimiters =  ";"
                newInput = input.replace(startingDelimiter,"")
                newInput = newInput.replace(whiteSpaceChar, delimiters)
            }
            else{
                delimiters =  ","
                newInput = input.replace(whiteSpaceChar, delimiters)
            }

            var sum = 0
            val splitArray = newInput.split(delimiters)
            for (operandStr in splitArray){
                if (operandStr != "") {
                    val operand = operandStr.toInt()
                    sum += operand
                }
            }
            return  sum
        }
        return 0
    }
}
fun main(args : Array<String>){
    val stringCalculator = StringCalculator()
    println("Sum = ${stringCalculator.add("//;\n1;2")}")
}


class StringCalculator {
    fun add(input : String) : Int{
        if (input.isNotEmpty()){
            val defaultDelimiter: String
            val startingDelimiter ="//"
            val whiteSpaceChar ="\n"
            val delimiters = "[*%]"
            var newInput : String
            if (input.length > 2 && input.substring(0,2) == startingDelimiter){
                defaultDelimiter =  ";"
                newInput = input.replace(startingDelimiter,"")
                newInput = newInput.replace(whiteSpaceChar, defaultDelimiter)
                newInput = newInput.replace("[", "")
                newInput = newInput.replace("]", "")
                newInput = newInput.replace(delimiters.toRegex(), defaultDelimiter)

            }
            else{
                defaultDelimiter =  ","
                newInput = input.replace(whiteSpaceChar, defaultDelimiter)
            }

            var sum = 0
            val splitArray = newInput.split(defaultDelimiter)
            var isNegativeNumberFound = false
            for (operandStr in splitArray){
                if (operandStr.isNotEmpty()) {
                    val operand = operandStr.toInt()
                    if(operand in 1..1000) {
                        sum += operand
                    }else if(operand < 0){
                        isNegativeNumberFound = true
                        println("$operand not allowed")
                    }
                }
            }
            if (isNegativeNumberFound){
                throw Exception("negatives not allowed")
            }
            return  sum
        }
        return 0
    }
}
fun main(args : Array<String>){
    val stringCalculator = StringCalculator()
    println("Sum = ${stringCalculator.add("//[****][%***]\n1****%*\n2%%%%%%3")}")
}


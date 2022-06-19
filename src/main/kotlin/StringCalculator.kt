class StringCalculator {
    fun add(input : String) : Int{
        if (!input.isNullOrEmpty()){
            val delimiters = ","
            var sum = 0
            var splitArray = input.split(delimiters)
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
    println("Sum = ${stringCalculator.add("1,2")}")
}


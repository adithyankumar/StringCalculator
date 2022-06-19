fun main(args : Array<String>){
    println("Sum = ${add("1,2")}")
}

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
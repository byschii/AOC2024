
import scala.util.CommandLineParser.FromString.given




def splitColumn(input: String, columnIndex: Integer): List[Int] = {
    val listMatrix = input.split("\n").map(_.trim.split("  "))
    // get the column and trim the spaces
    val column = listMatrix.map(_(columnIndex)).map(_.trim)
    return column.map(_.toInt).toList
}


@main
def init(): Unit = {
    val example = """3   4
    4   3
    2   5
    1   3
    3   9
    3   3"""

    val c0 = splitColumn(example, 0).sorted
    val c1 = splitColumn(example, 1).sorted

    val result = c0.zip(c1).map((a, b) => a - b).map(_.abs).sum
    println("distance = " + result)

    // calc similarity

    var similarity : Int = 0
    for (i <- 0 to c0.length - 1) {
        // count occurrence of c0(i) is in c1
        val count = c1.count(_ == c0(i))
        val c : Integer = count * c0(i)
        similarity += c
    }

    println("similarity = " + similarity)
        
}






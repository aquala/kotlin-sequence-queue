fun main() {

    val queueLength = 3
    val sequence = listOf<String>("a", "b", "c", "d", "e").asSequence()

    sequence.runningFold(ArrayDeque<String>()) { acc, myString ->
        acc.addFirst(myString)
        if (acc.size > queueLength) acc.removeLast()
        acc
    }.filter {
        check(it.size <= queueLength)
        it.size == queueLength
    }.forEach {
        print(it)
    }

}
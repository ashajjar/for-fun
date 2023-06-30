import java.time.Instant
import kotlin.random.Random

fun main(args: Array<String>) {
    var sum1 = 0L
    var sum2 = 0L
    (1..100).forEach {
        println("round {$it}")
        val p = main1()
        println(p)
        println("--------------")
        sum1 += p.first
        sum2 += p.second
    }
    val avg1 = sum1 / 100L
    val avg2 = sum2 / 100L

    println("Average for add =$avg1")
    println("Average for and =$avg2")

}

fun main1(): Pair<Long, Long> {
    val triplets = (0..10000000).map {
        Triple(
            Random(it).nextInt(),
            Random(it).nextInt(),
            Random(it).nextInt()
        )
    }

    println("ADD")

    var time1 = Instant.now().toEpochMilli()
    triplets.forEach {
        adding(it.first, it.second, it.third)
    }
    time1 = Instant.now().toEpochMilli() - time1
    println("Time is {$time1}")
    println("AND")

    var time2 = Instant.now().toEpochMilli()
    triplets.forEach {
        anding(it.first, it.second, it.third)
    }
    time2 = Instant.now().toEpochMilli() - time2
    println("Time is {$time2}")
    return Pair(time1, time2)
}

fun anding(a: Int, b: Int, c: Int): Boolean {
    return (a == 0 && b == 0 && c == 0)
}

fun adding(a: Int, b: Int, c: Int): Boolean {
    return (a + b + c == 0)
}

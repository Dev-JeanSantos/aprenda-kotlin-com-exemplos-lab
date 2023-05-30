// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Level { BASIC, INTERMEDIARY, HARD }

data class User(var name: String, var email: String, val userId: Long)

data class EducationalContent(var name: String, val duration: Int = 60,  val level: Level)

data class Formation(val name: String, var contents: List<EducationalContent>) {

    val allSubscribers = mutableListOf<User>()

    fun enrollment(user: User) {
        allSubscribers.add(user)
    }

    fun viewClass(bootcamp: Formation){
        println("\nF"+"Bootcamp Name: " + bootcamp.name)
        bootcamp.allSubscribers.forEach(){ println("$it")}
    }
}

fun main() {

    val user1 = User("user1", "user1@email.com", 1)
    val user2 = User("user2", "user2@email.com", 2)
    val user3 = User("user3", "user3@email.com", 3)
    val user4 = User("user4", "user4@email.com", 4)
    val user5 = User("user5", "user5@email.com", 5)

    val docker =  EducationalContent("Doker Fundamentals", 10, Level.INTERMEDIARY)
    val logicaProgramacao =  EducationalContent("Começando na Lógica de Programação", 10, Level.INTERMEDIARY)
    val java =  EducationalContent("Programação Java", 120, Level.BASIC)
    val kotlin =  EducationalContent("Programação Kotlin", 120, Level.BASIC)
    val sql =  EducationalContent("SQL", 30, Level.BASIC)
    val python =  EducationalContent("Python", 30, Level.INTERMEDIARY)
    val cloud =  EducationalContent("Cloud AWS", level = Level.INTERMEDIARY)
    val spring =  EducationalContent("Spring Framework", 200 , Level.HARD)

    val tqiKotlin = Formation("TQI Kotlin", mutableListOf(logicaProgramacao,java, kotlin, sql, spring))
    val tqiPyhton = Formation("TQI Python", mutableListOf(logicaProgramacao,python,docker, sql))
    val tqiCloud= Formation("TQI Cloud", mutableListOf(logicaProgramacao, cloud))


    tqiKotlin.enrollment(user1)
    tqiKotlin.enrollment(user2)
    tqiKotlin.enrollment(user5)

    tqiPyhton.enrollment(user5)
    tqiPyhton.enrollment(user2)

    tqiCloud.enrollment(user1)
    tqiCloud.enrollment(user2)
    tqiCloud.enrollment(user3)
    tqiCloud.enrollment(user4)
    tqiCloud.enrollment(user5)

    tqiKotlin.viewClass(tqiKotlin)
    tqiPyhton.viewClass(tqiPyhton)
    tqiCloud.viewClass(tqiCloud)
}

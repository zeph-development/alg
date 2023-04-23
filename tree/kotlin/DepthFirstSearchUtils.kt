data class LevelTwoObj(
    val text: String,
    val number: Long,
    val answer: Boolean,
)

data class LevelOneObj(
    val obj1: LevelTwoObj,
    val obj2: LevelTwoObj,
    val number: int
)

data class DataObject(
    val text: String,
    val myMap: Map<String, LevelTwoObj>,
    val myList: List<LevelTwoObj>
)

// init tree
val obj1: LevelTwoObj = LevelTwoObj("Arbiter", 30, true)
val obj2: LevelTwoObj = LevelTwoObj("WonderStorm", 50, true)

val objLevelOne: LevelOneObj = LevelOneObj(obj1, obj2, 100)

val rootObj: DataObject = DataObject(
    "Data",
    mapOf("one" to obj1, "two" to obj2),
    listOf(obj1, obj2)
)

//DepthFirstTraversal with recursion
fun dfs() {

}






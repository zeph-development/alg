package com.learning.kotlinlearning

fun main() {
    val publisher: Publisher = Publisher()

    publisher.subscribe(CarListener())
    publisher.subscribe(HouseListener())
    publisher.subscribe(GardenListener())

    publisher.notify("action1")
}

class Observer {
    fun main() {
        val publisher: Publisher = Publisher()

        publisher.subscribe(CarListener())
        publisher.subscribe(HouseListener())
        publisher.subscribe(GardenListener())

        publisher.notify("action1")
    }
}

class Publisher {
    private val listeners: LinkedHashSet<Listener> = LinkedHashSet<Listener>()

    fun subscribe(listener: Listener) {
        listeners.add(listener)
    }

    fun unsubscribe(listener: Listener){
        listeners.remove(listener)
    }

    fun notify(action: String) {
        listeners.forEach {
            it.update(action);
        }
    }

}

interface Listener {
    fun update(action: String)
}

class GardenListener : Listener {
    override fun update(action: String) {
        println("Garden listener $action")
    }
}

class HouseListener : Listener {
    override fun update(action: String) {
        println("House listener $action")
    }
}

class CarListener : Listener {
    override fun update(action: String) {
        println("Car listener $action")
    }
}
//Enum
//Задача 3.
//Реализация статусов заказа:
//Создайте Enum для статусов заказа в интернет-магазине: NEW, IN_PROGRESS, DELIVERED, CANCELLED. Реализуйте класс Order, который будет хранить информацию о заказе и текущем статусе, а также методы для смены статуса.
//
//Требования:
//
//Определите Enum для статусов заказа.
//Реализуйте методы в классе Order для изменения и отображения статуса заказа.
//Реализуйте логику проверки переходов статусов, чтобы нельзя было отменить доставленный заказ.
// Определение Enum для статусов заказа
enum class OrderStatus {
    NEW,
    IN_PROGRESS,
    DELIVERED,
    CANCELLED
}

// Класс Order
class Order(private val orderId: Int) {
    private var status: OrderStatus = OrderStatus.NEW

    // Метод для получения текущего статуса заказа
    fun getStatus(): OrderStatus {
        return status
    }

    // Метод для смены статуса
    fun changeStatus(newStatus: OrderStatus) {
        if (isStatusTransitionValid(newStatus)) {
            status = newStatus
            println("Статус заказа $orderId изменен на: $status")
        } else {
            println("Невозможно изменить статус заказа $orderId на: $newStatus")
        }
    }

    // Логика проверки переходов статусов
    private fun isStatusTransitionValid(newStatus: OrderStatus): Boolean {
        return when (status) {
            OrderStatus.NEW -> newStatus == OrderStatus.IN_PROGRESS || newStatus == OrderStatus.CANCELLED
            OrderStatus.IN_PROGRESS -> newStatus == OrderStatus.DELIVERED || newStatus == OrderStatus.CANCELLED
            OrderStatus.DELIVERED -> false // Невозможно отменить доставленный заказ
            OrderStatus.CANCELLED -> false // Невозможно менять статус после отмены
        }
    }
}

fun main() {
    val order = Order(101)

    println("Текущий статус: ${order.getStatus()}")

    order.changeStatus(OrderStatus.IN_PROGRESS)
    order.changeStatus(OrderStatus.DELIVERED)
    order.changeStatus(OrderStatus.CANCELLED) // Не должно работать

    println("Текущий статус: ${order.getStatus()}")

    val anotherOrder = Order(102)
    anotherOrder.changeStatus(OrderStatus.CANCELLED) // Должно быть разрешено
}

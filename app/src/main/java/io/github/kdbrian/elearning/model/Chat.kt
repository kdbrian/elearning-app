package io.github.kdbrian.elearning.model

data class Chat(
    val id: Int? = null,
    val userName: String = "Dev Yolo",
    val messages: List<Message> = Message.getMessages(),
    val newMessages: Int = 0,
    val isActive: Boolean = true,
    val latestMessageTime: String

){
    companion object{
        fun getChats() = listOf(
            Chat(userName = "Wanda Kelvin", latestMessageTime = "8:30 PM"),
            Chat(userName = "Jessi Libby", latestMessageTime = "9:30 PM"),
            Chat(userName = "Billy Green", latestMessageTime = "7:39 AM"),
            Chat(userName = "Andre Flores", latestMessageTime = "6:41 PM"),
            Chat(userName = "Jaime Allen", latestMessageTime = "12:18 AM"),
        )
    }
}

data class Message(
    val from: String,
    val content: String = "Hi, your course is a very effective one. Thank you",
) {
    companion object {
        fun getMessages() = listOf(
            Message(
                from = "Wanda Klein",
                content = "Hi, your course is a very effective one. Thank you"
            ),
            Message(
                from = "me",
                content = "Hi, your course is a very effective one. Thank you"
            ),
            Message(
                from = "Billy Green",
                content = "Hi, your course is a very effective one. Thank you"
            ),
            Message(
                from = "Andre Flores",
                content = "Hi, your course is a very effective one. Thank you"
            ),
            Message(
                from = "Jaime Allen",
                content = "Hi, your course is a very effective one. Thank you"
            ),
        )
    }
}


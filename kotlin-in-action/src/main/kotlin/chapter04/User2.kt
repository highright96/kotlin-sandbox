package chapter04

interface User2 {
    val nickname: String
}

class PrivateUser(override val nickname: String) : User2

class SubscribingUser(val email: String) : User2 {
    override val nickname: String
        get() = email.substringBefore('@')
}

/*
class FacebookUser(val accountId: Int) : User2 {
    override val nickname = getFacebookName(accountId)
}*/
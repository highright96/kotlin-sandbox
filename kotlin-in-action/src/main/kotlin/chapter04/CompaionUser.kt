package chapter04

class CompanionUser(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String)  = User(email.substringBefore("@"))
        //fun newFacebookUser(accountId: Int) = User(getFacebookUser(accountId))
    }

    class NestedUser { }
}
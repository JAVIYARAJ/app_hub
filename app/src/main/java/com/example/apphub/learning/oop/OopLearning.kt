package com.example.apphub.learning.oop

class OopLearning(name: String) : AbstractLearning() {
    override fun learnOpp() {

    }

    override fun learnEnglish() {

    }

}

class OopLearningArg(name: String) : AbstractLearningWithArg(name) {
    override fun learnOpp(name: String) {

    }

    override fun learnEnglish(name: String) {

    }
}

abstract class AbstractLearning {
    abstract fun learnOpp()
    abstract fun learnEnglish()
}

abstract class AbstractLearningWithArg(val name: String) {
    abstract fun learnOpp(name: String)
    abstract fun learnEnglish(name: String)
}

interface AuthInterface{
    abstract fun login()
    abstract fun register()
    abstract fun logout()
}

class LoginRepository:AuthInterface{
    override fun login() {

    }

    override fun register() {

    }

    override fun logout() {

    }
}
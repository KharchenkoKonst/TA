import kotlin.system.exitProcess

class RecursiveDescent {
    init {
        print("Введите строку: ")
    }

    private var index = 0
    private val s: String = readLine() + " "

    fun Do() {
        S()
        println("Допущено")
    }

    private fun Error() {
        println("Не допущено")
        exitProcess(0)
    }

    private fun S() {
        println("1. S -> OT")
        O()
        T()
    }

    private fun T() {
        when (s[index]) {
            ';' -> {
                println("2. T -> ;OT")
                ++index
                O()
                T()
            }
            else -> println("3. T -> e")
        }
    }

    private fun O() {
        when (s[index]) {
            '{' -> {
                println("4. O -> {Y[S]}")
                index++
                Y()
                when (s[++index]) {
                    '[' -> {
                        index++
                        S()
                        when (s[index]) {
                            ']' -> {
                                if (s[++index] == '}')
                                    index++
                                else Error()
                            }
                            else -> Error()
                        }
                    }
                    else -> Error()
                }
            }
            'a' -> {
                println("5. O -> a=E")
                when (s[++index]) {
                    '=' -> {
                        index++
                        E()
                    }
                    else -> Error()
                }
            }
            else -> Error()
        }
    }

    private fun Y() {
        when (s[index]) {
            '|' -> {
                println("6. Y -> |(Y,Y)")
                when (s[++index]) {
                    '(' -> {
                        index++
                        Y()
                        when (s[++index]) {
                            ',' -> {
                                index++
                                Y()
                                if (s[++index] != ')')
                                    Error()
                            }
                            else -> Error()
                        }
                    }
                    else -> Error()
                }
            }
            '&' -> {
                println("7. Y -> &(Y,Y)")
                when (s[++index]) {
                    '(' -> {
                        index++
                        Y()
                        when (s[++index]) {
                            ',' -> {
                                index++
                                Y()
                                if (s[++index] != ')')
                                    Error()
                            }
                            else -> Error()
                        }
                    }
                    else -> Error()
                }
            }
            '!' -> {
                println("8. Y -> !(Y)")
                when (s[++index]) {
                    '(' -> {
                        index++
                        Y()
                        if (s[++index] != ')')
                            Error()
                    }
                    else -> Error()
                }
            }
            'a' -> println("9. Y -> a")
            else -> Error()
        }
    }

    private fun E() {
        when (s[index]) {
            'a' -> {
                println("10. E -> aD")
                index++
                D()
            }
            else -> Error()
        }
    }

    private fun D() {
        when (s[index]) {
            'a' -> {
                println("11. D -> EMD")
                E()
                M()
                D()
            }
            else -> println("12. D -> e")
        }
    }

    private fun M() {
        when (s[index]) {
            '+' -> {
                println("13. M -> +")
                index++
            }
            '*' -> {
                println("14. M -> *")
                index++
            }
            else -> Error()
        }
    }
}

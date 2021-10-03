class MP(private val chain: String) {
    private val mag = mutableListOf('@') //@ - символ конца магазина
    private var currentPos = 0
    private var state = "work"

    fun getState() = state

    fun solve() {

        val x = if (chain[currentPos] != '@') {
            getId(chain[currentPos])
        } else {
            TABLE[0].size - 1
        }

        val y = when {
            mag.last() != '@' -> {
                if (TERMINALS.contains(mag.last())) {
                    NOT_TERMINALS.size + getId(mag.last())
                } else {
                    getId(mag.last())
                }
            }
            else -> {
                TABLE.size - 1
            }
        }

        if (state == "work") {
            when {
                TABLE[y][x] == 'e' -> state = "error"
                TABLE[y][x] == 'p' -> p()
                TABLE[y][x] == 'o' -> op()
                else -> state = "allow"
            }
        }
    }

    /**
     * Поиск индекса символа в векторе
     */
    private fun getId(c: Char): Int = when {
        TERMINALS.contains(c) -> TERMINALS.indexOf(c)
        else -> NOT_TERMINALS.indexOf(c)
    }

    //перенос
    private fun p() {
        mag.add(chain[currentPos])
        currentPos++
    }

    //опознание
    private fun op() {
        var buf = mag.last()
        mag.removeLast()

        when (buf) {
            'S' -> {
                buf = mag.last()
                if (buf == '@') {
                    mag.add('G')
                    println("Свёртка по правилу 1")
                } else state = "error"
            }
            'O' -> {
                buf = mag.last()
                if (buf == 'S') {
                    buf = nextMagItem()
                    if (POD.getValue('S').contains(buf)) {
                        mag.add('S')
                        println("Свёртка по правилу 2")
                    } else state = "error"
                } else if (POD.getValue('S').contains(buf)) {
                    mag.add('S')
                    println("Свёртка по правилу 3")
                } else state = "error"
            }
            'G' -> {
                buf = mag.last()
                if (buf == '@') {
                    println("Допуск")
                    state = "allow"
                } else state = "error"
            }
            '}' -> {
                buf = mag.last()
                if (buf == 'Y') {
                    buf = nextMagItem()
                    if (buf == ']') {
                        buf = nextMagItem()
                        if (buf == 'S') {
                            buf = nextMagItem()
                            if (buf == '[') {
                                buf = nextMagItem()
                                if (buf == '{') {
                                    buf = nextMagItem()
                                    if (POD.getValue('O').contains(buf)) {
                                        mag.add('O')
                                        println("Свёртка по правилу 4")
                                    } else state = "error"
                                } else state = "error"
                            } else state = "error"
                        } else state = "error"
                    } else state = "error"
                } else state = "error"
            }
            'E' -> {
                buf = mag.last()
                if (buf == '=') {
                    buf = nextMagItem()
                    if (buf == 'a') {
                        buf = nextMagItem()
                        if (POD.getValue('O').contains(buf)) {
                            mag.add('O')
                            println("Свёртка по правилу 5")
                        } else state = "error"
                    } else state = "error"
                } else state = "error"
            }
            ')' -> {
                buf = mag.last()
                if (buf == 'Y') {
                    buf = nextMagItem()

                    if (buf == '|') {
                        buf = nextMagItem()
                        if (buf == 'Y') {
                            buf = nextMagItem()
                            if (buf == '(') {
                                buf = nextMagItem()
                                if (POD.getValue('Y').contains(buf)) {
                                    mag.add('Y')
                                    println("Свёртка по правилу 6")
                                } else state = "error"
                            } else state = "error"
                        } else state = "error"

                    } else if (buf == '&') {
                        buf = nextMagItem()
                        if (buf == 'Y') {
                            buf = nextMagItem()
                            if (buf == '(') {
                                buf = nextMagItem()
                                if (POD.getValue('Y').contains(buf)) {
                                    mag.add('Y')
                                    println("Свёртка по правилу 7")
                                } else state = "error"
                            } else state = "error"
                        } else state = "error"

                    } else if (buf == '(') {
                        buf = nextMagItem()
                        if (buf == '!') {
                            buf = nextMagItem()
                            if (POD.getValue('Y').contains(buf)) {
                                mag.add('Y')
                                println("Свёртка по правилу 8")
                            } else state = "error"
                        } else state = "error"
                    } else state = "error"

                } else if (buf == 'E') {
                    buf = nextMagItem()
                    if (buf == ',') {
                        buf = nextMagItem()
                        if (buf == 'E') {
                            buf = nextMagItem()
                            if (buf == '(') {
                                buf = nextMagItem()
                                if (buf == '+') {
                                    buf = nextMagItem()
                                    if (POD.getValue('E').contains(buf)) {
                                        mag.add('E')
                                        println("Свёртка по правилу 10")
                                    } else state = "error"
                                } else if (buf == '*') {
                                    buf = nextMagItem()
                                    if (POD.getValue('E').contains(buf)) {
                                        mag.add('E')
                                        println("Свёртка по правилу 11")
                                    } else state = "error"
                                } else state = "error"
                            } else state = "error"
                        } else state = "error"
                    } else state = "error"
                } else state = "error"
            }
            'a' -> {
                buf = mag.last()
                if (POD.getValue('E').contains(buf) &&
                    listOf('+', '*', 'a', 'E').contains(mag.size.let { mag[it - 2] })
                ) {
                    mag.add('E')
                    println("Свёртка по правилу 12")
                } else if (POD.getValue('Y').contains(buf)) {
                    mag.add('Y')
                    println("Свёртка по правилу 9")
                } else state = "error"
            }
            else -> state = "error"
        }
    }

    private fun nextMagItem(): Char {
        mag.removeLast()
        return mag.last()
    }
}
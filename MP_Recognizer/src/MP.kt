class MP {
    private val magazine = emptyList<Char>().toMutableList()
    private val table = TABLE_OF_RULES
    private val magazineSymbols = RECOGNIZER_SYMBOLS
    private val chainSymbols = CHAIN_SYMBOLS

    private var currentChainSymbolIndex = 0

    fun compile(chain: String): Boolean {
        val endChar = magazineSymbols.last()
        val startChar = magazineSymbols.first()
        magazine.add(endChar)
        magazine.add(startChar)

        var permissibleState = false

        while (!permissibleState) {

            println("Магазин: ${magazine.reversed().joinToString()}")

            //Поиск индекса символа в магазине
            val indexOfMagazineSymbol = magazineSymbols.indexOf(magazine.last())

            //Поиск индекса символа цепочки
            val indexOfChainSymbol = chainSymbols.indexOf(chain[currentChainSymbolIndex])

            if (indexOfChainSymbol == -1 || indexOfMagazineSymbol == -1)
                return false
            if (table[indexOfMagazineSymbol][indexOfChainSymbol] == 0)
                return false

            print("Текущая цепочка: ")
            for (i in 0 until currentChainSymbolIndex) {
                print(chain[i])
            }

            for (i in 1 until magazine.size) {
                print(magazine[magazine.size - i])
            }
            println()

            permissibleState = applyRule(table[indexOfMagazineSymbol][indexOfChainSymbol])
            println()
        }
        return true
    }

    private fun applyRule(rule: Int): Boolean {
        if (rule != 16) print("Применяем правило: ")

        fun addToMagazine(chain: String) {
            chain.reversed().forEach { magazine.add(it) }
        }

        when (rule) {
            1 -> {
                print("1. S -> OT")
                magazine.removeLast()
                addToMagazine("OT")

            }
            2 -> {
                print("2. T -> ;OT")
                magazine.removeLast()
                addToMagazine("OT")
                currentChainSymbolIndex++
            }
            3 -> {
                print("3. T -> e")
                magazine.removeLast()
            }
            4 -> {
                print("4. O -> {Y[S]}")
                magazine.removeLast()
                addToMagazine("Y[S]}")
                currentChainSymbolIndex++
            }
            5 -> {
                print("5. O -> a=E")
                magazine.removeLast()
                addToMagazine("E")
                currentChainSymbolIndex += 2
            }
            6 -> {
                print("6. Y -> |(Y,Y)")
                magazine.removeLast()
                addToMagazine("(Y,Y)")
                currentChainSymbolIndex++
            }
            7 -> {
                print("7. Y -> &(Y,Y)")
                magazine.removeLast()
                addToMagazine("(Y,Y)")
                currentChainSymbolIndex++
            }
            8 -> {
                print("8. Y -> !(Y)")
                magazine.removeLast()
                addToMagazine("(Y)")
                currentChainSymbolIndex++
            }
            9 -> {
                print("9. Y -> a")
                magazine.removeLast()
                currentChainSymbolIndex++
            }
            10 -> {
                print("10. E -> aD")
                magazine.removeLast()
                addToMagazine("D")
                currentChainSymbolIndex++
            }
            11 -> {
                print("11. D -> EMD")
                magazine.removeLast()
                addToMagazine("EMD")
            }
            12 -> {
                print("12. D -> e")
                magazine.removeLast()
            }
            13 -> {
                print("13. M -> +")
                magazine.removeLast()
                currentChainSymbolIndex++
            }
            14 -> {
                print("14. M -> *")
                magazine.removeLast()
                currentChainSymbolIndex++
            }
            15 -> {
                print("Выт, сдвиг")
                magazine.removeLast()
                currentChainSymbolIndex++
            }
            16 -> {
                return true
            }
        }
        println()
        return false
    }
}
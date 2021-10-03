fun main() {
    val recognizer = MP()
    print("Введите строку: ")
    val chain = readLine() + ' '
    println()

    if (recognizer.compile(chain))
        print("Допущено")
    else print("Не допущено")
}
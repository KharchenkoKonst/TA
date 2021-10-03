fun main() {
    val chain = "{[a=a]((a&a)|!(a))}a=+(*(a,a),a)@"
    val mp = MP(chain)
    while (mp.getState() == "work") {
        mp.solve()
    }
    if (mp.getState() == "error") {
        println("Цепочка не допущена")
    }
}
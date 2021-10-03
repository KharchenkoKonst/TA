//Множество входных символов
val CHAIN_SYMBOLS = listOf(';', '[', ']', '{', '}', 'a', '|', '&', '!', '+', '*', '(', ')', '=', ',', ' ')

//Множество символов распознавателя
val RECOGNIZER_SYMBOLS = listOf('S', 'T', 'O', 'Y', 'E', 'D', 'M', '[', ']', '}', '(', ')', '=', ',', '^')

val TABLE_OF_RULES = listOf(
        //      ;   [   ]   {   }   a   |   &   !   +   *   (   )   =   ,   -|
        listOf( 0,  0,  0,  1,  0,  1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0), //S
        listOf( 2,  0,  3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  3), //T
        listOf( 0,  0,  0,  4,  0,  5,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0), //O
        listOf( 0,  0,  0,  0,  0,  9,  6,  7,  8,  0,  0,  0,  0,  0,  0,  0), //Y
        listOf( 0,  0,  0,  0,  0, 10,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0), //E
        listOf(12,  0, 12,  0,  0, 11,  0,  0,  0, 12, 12,  0,  0,  0,  0, 12), //D
        listOf( 0,  0,  0,  0,  0,  0,  0,  0,  0, 13, 14,  0,  0,  0,  0,  0), //M
        listOf( 0, 15,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0), //[
        listOf( 0,  0, 15,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0), //]
        listOf( 0,  0,  0,  0, 15,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0), //}
        listOf( 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 15,  0,  0,  0,  0), //(
        listOf( 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 15,  0,  0,  0), //)
        listOf( 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 15,  0,  0), //=
        listOf( 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 15,  0), //,
        listOf( 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 16), //^
)
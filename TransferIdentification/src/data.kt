val TABLE = listOf(
    //      [    ]    {    }    a    =    |    &    !    (    )    +    *    ,    -|
    listOf('e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'o'),  //S'
    listOf('e', 'p', 'p', 'e', 'p', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'o'),  //S
    listOf('e', 'o', 'o', 'e', 'o', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'o'),  //O
    listOf('e', 'e', 'e', 'p', 'e', 'e', 'p', 'p', 'e', 'e', 'p', 'e', 'e', 'e', 'e'),  //Y
    listOf('e', 'o', 'o', 'e', 'o', 'e', 'e', 'e', 'e', 'e', 'p', 'e', 'e', 'p', 'o'),  //E
    listOf('e', 'e', 'p', 'e', 'p', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e'),  //[
    listOf('e', 'e', 'e', 'e', 'p', 'e', 'e', 'e', 'p', 'p', 'e', 'e', 'e', 'e', 'e'),  //]
    listOf('p', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e'),  //{
    listOf('e', 'o', 'o', 'e', 'o', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'o'),  //}
    listOf('e', 'o', 'o', 'o', 'o', 'p', 'o', 'o', 'e', 'e', 'o', 'e', 'e', 'o', 'o'),  //a
    listOf('e', 'e', 'e', 'e', 'p', 'e', 'e', 'e', 'e', 'e', 'e', 'p', 'p', 'e', 'e'),  //=
    listOf('e', 'e', 'e', 'e', 'p', 'e', 'e', 'e', 'p', 'p', 'e', 'e', 'e', 'e', 'e'),  //|
    listOf('e', 'e', 'e', 'e', 'p', 'e', 'e', 'e', 'p', 'p', 'e', 'e', 'e', 'e', 'e'),  //&
    listOf('e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'p', 'e', 'e', 'e', 'e', 'e'),  //!
    listOf('e', 'e', 'e', 'e', 'p', 'e', 'e', 'e', 'p', 'p', 'e', 'p', 'p', 'e', 'e'),  //(
    listOf('e', 'o', 'o', 'o', 'o', 'e', 'o', 'o', 'e', 'e', 'o', 'e', 'e', 'o', 'o'),  //)
    listOf('e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'p', 'e', 'e', 'e', 'e', 'e'),  //+
    listOf('e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'p', 'e', 'e', 'e', 'e', 'e'),  //*
    listOf('e', 'e', 'e', 'e', 'p', 'e', 'e', 'e', 'e', 'e', 'e', 'p', 'p', 'e', 'e'),  //,
    listOf('e', 'e', 'p', 'e', 'p', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'a'),  //ᐁ
)

val NOT_TERMINALS = listOf('G', 'S', 'O', 'Y', 'E')

val TERMINALS = listOf('[', ']', '{', '}', 'a', '=', '|', '&', '!', '(', ')', '+', '*', ',')

val POD = mapOf(
    'S' to listOf('@', '['),
    'O' to listOf('@', '[', 'S'),
    'Y' to listOf(']', '(', '|', '&'),
    'E' to listOf('=', '(', ',')
)
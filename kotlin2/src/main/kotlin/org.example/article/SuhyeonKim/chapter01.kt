package org.example.org.example.article.SuhyeonKim

open class Sword
class Excalibur : Sword()

class Sheath<T>(val item: T)

//val sword: Sheath<Sword> = Sheath<Excalibur>(Excalibur()) // ❌ Compile Error: Type mismatch!
//val excalibur: Sheath<Excalibur> = Sheath<Sword>(Sword()) // ❌ Compile Error: Type mismatch!
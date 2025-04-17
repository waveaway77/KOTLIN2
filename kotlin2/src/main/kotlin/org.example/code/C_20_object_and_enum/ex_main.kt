package code.C_20_object_and_enum

fun main() {
    println(BANKCODE_OBJECT.woori) // 020
    println(BANKCODE_ENUM.shinhan) // woori

    val allBanks = BANKCODE_ENUM.values()
    allBanks.forEach { println(it) } // woori shinhan
}

fun getBankName(bank: BANKCODE_ENUM): String {
    return when (bank) {
        BANKCODE_ENUM.woori -> "신한은행"
        BANKCODE_ENUM.shinhan -> "우리은행"
    }
}

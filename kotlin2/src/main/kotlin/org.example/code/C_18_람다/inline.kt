package org.example.org.example.code.C_18_람다


fun callLambda1(lambda: () -> Unit) {
    lambda()
}

inline fun callLambda2(lambda: () -> Unit) {
    lambda()
}

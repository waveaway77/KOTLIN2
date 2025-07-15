package org.example.org.example.utils.logger.mdc.practice

import kotlinx.coroutines.ThreadContextElement
import org.example.org.example.utils.logger.mdc.MDCContext
import org.example.org.example.utils.logger.mdc.MDCContextMap
import org.slf4j.MDC
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

typealias MDCContextMap = Map<String, String>?

class MDCContext(
    val contextMap: MDCContextMap = MDC.getCopyOfContextMap() // parameter
) : ThreadContextElement<MDCContextMap>, AbstractCoroutineContextElement(MDCContext) {

    companion object Key :CoroutineContext.Key<MDCContext>
    // is an interface used to retrieve specific elements
    // from a CoroutineContext

    /** @suppress */
    override fun updateThreadContext(context: CoroutineContext): MDCContextMap {
        val state = MDC.getCopyOfContextMap()
        setState(contextMap)
        return state
    }

    /** @suppress */
    override fun restoreThreadContext(context: CoroutineContext, oldState: MDCContextMap) {
        setState(oldState)
    }

    private fun setState(contextMap: MDCContextMap) {
        if (contextMap == null) {
            MDC.clear()
        } else {
            MDC.setContextMap(contextMap)
        }
    }
}
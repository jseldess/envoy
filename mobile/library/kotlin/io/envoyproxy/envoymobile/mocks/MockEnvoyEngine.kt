package io.envoyproxy.envoymobile

import io.envoyproxy.envoymobile.engine.EnvoyConfiguration
import io.envoyproxy.envoymobile.engine.EnvoyEngine
import io.envoyproxy.envoymobile.engine.EnvoyHTTPStream
import io.envoyproxy.envoymobile.engine.types.EnvoyHTTPCallbacks
import io.envoyproxy.envoymobile.engine.types.EnvoyNetworkType
import io.envoyproxy.envoymobile.engine.types.EnvoyStringAccessor
import io.envoyproxy.envoymobile.engine.types.EnvoyStatus

/**
 * Mock implementation of `EnvoyEngine`. Used internally for testing the bridging layer & mocking.
 */
internal class MockEnvoyEngine : EnvoyEngine {
  override fun runWithConfig(envoyConfiguration: EnvoyConfiguration?, logLevel: String?): EnvoyStatus = EnvoyStatus.ENVOY_SUCCESS

  override fun performRegistration(envoyConfiguration: EnvoyConfiguration) = Unit

  override fun runWithYaml(
    configurationYAML: String,
    logLevel: String
  ): EnvoyStatus = EnvoyStatus.ENVOY_SUCCESS

  override fun startStream(
    callbacks: EnvoyHTTPCallbacks?,
    explicitFlowControl: Boolean,
    minDeliverySize: Long
  ): EnvoyHTTPStream {
    return MockEnvoyHTTPStream(callbacks!!, explicitFlowControl, minDeliverySize)
  }

  override fun terminate() = Unit

  override fun recordCounterInc(elements: String, tags: MutableMap<String, String>, count: Int): Int = 0

  override fun registerStringAccessor(accessorName: String, accessor: EnvoyStringAccessor): Int = 0

  override fun flushStats() = Unit

  override fun dumpStats(): String = ""

  override fun resetConnectivityState() = Unit

  override fun setPreferredNetwork(network: EnvoyNetworkType) = Unit

  override fun setProxySettings(host: String, port: Int) = Unit

  override fun setLogLevel(level: EnvoyEngine.LogLevel) = Unit
}

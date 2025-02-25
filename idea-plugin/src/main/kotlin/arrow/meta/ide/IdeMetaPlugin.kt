package arrow.meta.ide

import arrow.meta.MetaPlugin
import arrow.meta.Plugin
import arrow.meta.ide.dsl.IdeSyntax
import arrow.meta.phases.CompilerContext
import arrow.meta.ide.internal.registry.IdeInternalRegistry
import arrow.meta.ide.plugins.comprehensions.comprehensionsIdePlugin
import arrow.meta.ide.plugins.higherkinds.higherKindsIdePlugin
import arrow.meta.ide.plugins.initial.initialIdeSetUp
import arrow.meta.ide.plugins.nothing.nothingIdePlugin
import arrow.meta.ide.plugins.optics.opticsIdePlugin
import arrow.meta.ide.plugins.typeclasses.typeclassesIdePlugin
import kotlin.contracts.ExperimentalContracts

class IdeMetaPlugin : MetaPlugin(), IdeInternalRegistry, IdeSyntax {
  @ExperimentalContracts
  override fun intercept(ctx: CompilerContext): List<Plugin> =
    super.intercept(ctx) +
      initialIdeSetUp +
      higherKindsIdePlugin +
      typeclassesIdePlugin +
      comprehensionsIdePlugin +
      opticsIdePlugin +
      nothingIdePlugin
}

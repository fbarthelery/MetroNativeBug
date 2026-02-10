Metro native build bug with bindings containers
==============================================

Including a binding container from an external module in a dependency graph cause build failure for native build.

```
error: Compilation failed: Empty list doesn't contain element at index 0.

 * Source files: ExpectResourceCollectors.kt, Res.kt, Drawable0.iosMain.kt, ActualResourceCollectors.kt, App.kt, AppGraph.kt, Greeting.kt, MainViewController.kt, Platform.kt
 * Compiler version: 2.3.10
 * Output kind: LIBRARY

error: org.jetbrains.kotlin.fir.pipeline.IrGenerationExtensionException: Empty list doesn't contain element at index 0.
	at org.jetbrains  .kotlin.fir.pipeline.Fir2IrPipeline.applyIrGenerationExtensions(convertToIr.kt:577)
	at org.jetbrains.kotlin.fir.pipeline.Fir2IrPipeline.runActualizationPipeline(convertToIr.kt:279)
	at org.jetbrains.kotlin.fir.pipeline.Fir2IrPipeline.convertToIrAndActualize(convertToIr.kt:150)
	at org.jetbrains.kotlin.fir.pipeline.ConvertToIrKt.convertToIrAndActualize(convertToIr.kt:115)
	at org.jetbrains.kotlin.fir.pipeline.ConvertToIrKt.convertToIrAndActualize$default(convertToIr.kt:88)
	at org.jetbrains.kotlin.backend.konan.Fir2IrKt.fir2Ir(Fir2Ir.kt:75)
	at org.jetbrains.kotlin.backend.konan.driver.phases.Fir2IrKt.Fir2IrPhase$lambda$1(Fir2Ir.kt:28)
	at org.jetbrains.kotlin.backend.common.phaser.PhaseBuildersKt$createSimpleNamedCompilerPhase$1.phaseBody(PhaseBuilders.kt:58)
	at org.jetbrains.kotlin.config.phaser.NamedCompilerPhase.invoke(CompilerPhase.kt:102)
	at org.jetbrains.kotlin.backend.common.phaser.PhaseEngine.runPhase(PhaseEngine.kt:64)
	at org.jetbrains.kotlin.backend.common.phaser.PhaseEngine.runPhase$default(PhaseEngine.kt:56)
	at org.jetbrains.kotlin.backend.konan.driver.phases.Fir2IrKt.runFir2Ir(Fir2Ir.kt:32)
	at org.jetbrains.kotlin.backend.konan.driver.NativeCompilerDriver.serializeKLibK2(NativeCompilerDriver.kt:131)
	at org.jetbrains.kotlin.backend.konan.driver.NativeCompilerDriver.produceKlib(NativeCompilerDriver.kt:106)
	at org.jetbrains.kotlin.backend.konan.driver.NativeCompilerDriver.run$lambda$0$0$0(NativeCompilerDriver.kt:46)
Compilation failed: Empty list doesn't contain element at index 0.
```

Code sample
===========

The `:bindings` module defines a binding container who provides an internal dependency

The `:composeApp` module defines the AppGraph that include the SimpleBindings from `:bindings`

This setup would build for jvm/android but will fails on native

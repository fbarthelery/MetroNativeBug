package com.geekorum.bindings

import dev.zacsweers.metro.BindingContainer
import dev.zacsweers.metro.Provides

// this bindings fails when it is included in another module
@BindingContainer
object SimpleBindings {

    // doesn't fail if there is no dependency parameter.
    @Provides
    private fun providesItunesApi(dependency: InternalDependency): String {
        return "My string"
    }

    @Provides
    private fun providesInternalDependency(): InternalDependency = InternalDependency()

}

class InternalDependency
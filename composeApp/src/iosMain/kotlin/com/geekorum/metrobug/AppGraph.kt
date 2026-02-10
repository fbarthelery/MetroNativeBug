package com.geekorum.metrobug

import com.geekorum.bindings.SimpleBindings
import dev.zacsweers.metro.DependencyGraph

@DependencyGraph(bindingContainers = [SimpleBindings::class])
interface AppGraph {
    val injectedString: String
}


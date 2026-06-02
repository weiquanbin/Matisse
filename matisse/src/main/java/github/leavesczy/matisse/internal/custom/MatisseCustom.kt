package github.leavesczy.matisse.internal.custom

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import github.leavesczy.matisse.MediaResource

/**
  * 二次开发高聚敛物理隔离单例
  * 专用于管理外部注入的示例图配置，防止对 Matisse 原生库的静态插槽侵入。
  */
object MatisseCustom {
    var customFirstItem: MediaResource? = null
    var customFirstItemBadge: (@Composable BoxScope.() -> Unit)? = null
}

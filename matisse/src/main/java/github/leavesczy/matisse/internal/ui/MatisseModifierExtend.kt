package github.leavesczy.matisse.internal.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

/**
 * @Author: CZY
 * @Date: 2023/2/19 18:56
 * @Desc:
 */
@Composable
internal fun Modifier.clickableNoRipple(onClick: () -> Unit): Modifier {
    return then(
        other = Modifier.clickable(
            onClickLabel = null,
            indication = null,
            interactionSource = remember { MutableInteractionSource() },
            onClick = onClick
        )
    )
}
package nah.prayer.widgetslib.corners

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat


class CornerButton(context: Context, attrs: AttributeSet?) : AppCompatButton(context, attrs) {
    init {
        this.setBackgroundColor(ContextCompat.getColor(context, android.R.color.white))
        this.background = StyleShorten().setStyle(context, attrs, CornersEnum.C_BUTTON)
    }
}
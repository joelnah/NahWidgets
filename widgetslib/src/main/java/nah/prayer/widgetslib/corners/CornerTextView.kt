package nah.prayer.widgetslib.corners

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat


class CornerTextView(context: Context, attrs: AttributeSet?) : AppCompatTextView(context, attrs) {
    init {
        this.setBackgroundColor(ContextCompat.getColor(context, android.R.color.white))
        this.background = StyleShorten().setStyle(context, attrs, CornersEnum.C_TEXT)
    }
}
package nah.prayer.widgetslib.corners

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat


class CornerImageView(context: Context, attrs: AttributeSet?) : AppCompatImageView(context, attrs) {
    init {
        this.setBackgroundColor(ContextCompat.getColor(context, android.R.color.white))
        this.background = StyleShorten().setStyle(context, attrs, CornersEnum.IMAGE)
    }
}
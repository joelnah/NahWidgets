package nah.prayer.widgetslib.corners

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.annotation.ColorInt
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat


class CornerFrameLayout(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {
    private val styleShorten = StyleShorten()
    init {
        this.setBackgroundColor(ContextCompat.getColor(context, android.R.color.white))
        this.background = styleShorten.setStyle(context, attrs, CornersEnum.C_LAYOUT)
    }

    fun setNaStrokeSize(width:Int){
        this.background = styleShorten.setCustomStrokeSize(width)
    }

    fun setNaStrokeColor(@ColorInt color:Int){
        this.background = styleShorten.setCustomStrokeColor(color)
    }

    fun setNaBackGroundColor(@ColorInt color:Int){
        this.background = styleShorten.setCustomBackGroundColor(color)
    }
}
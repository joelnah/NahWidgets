package nah.prayer.widgetslib.corners

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.ColorInt
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat


class CornerTextView(context: Context, attrs: AttributeSet?) : AppCompatTextView(context, attrs) {
    private val styleShorten = StyleShorten()
    init {
        this.setBackgroundColor(ContextCompat.getColor(context, android.R.color.white))
        this.background = styleShorten.setStyle(context, attrs, CornersEnum.C_TEXT)
    }

    fun setNaStrokeSize(width:Float){
        this.background = styleShorten.setCustomStrokeSize(width)
    }

    fun setNaStrokeColor(@ColorInt color:Int){
        this.background = styleShorten.setCustomStrokeColor(color)
    }

    fun setNaBackGroundColor(@ColorInt color:Int){
        this.background = styleShorten.setCustomBackGroundColor(color)
    }
}
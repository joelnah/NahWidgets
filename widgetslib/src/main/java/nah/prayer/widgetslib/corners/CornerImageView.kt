package nah.prayer.widgetslib.corners

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.ColorInt
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat


class CornerImageView(context: Context, attrs: AttributeSet?) : AppCompatImageView(context, attrs) {
    private val styleShorten = StyleShorten()
    init {
        this.setBackgroundColor(ContextCompat.getColor(context, android.R.color.white))
        this.background = styleShorten.setStyle(context, attrs, CornersEnum.C_IMAGE)
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
package nah.prayer.widgetslib.corners

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import nah.prayer.widgetslib.R

class StyleShorten {

    private val defValue = 0f
    private lateinit var type: CornersEnum

    private var cornerAll = defValue
    private var cornerTop = defValue
    private var cornerBottom = defValue
    private var cornerTopLeft = defValue
    private var cornerTopRight = defValue
    private var cornerBottomLeft = defValue
    private var cornerBottomRight = defValue
    private var stroke = defValue

    @ColorInt private var strokeColor=0
    @ColorInt private var bgColor=0

    fun setStyle(context: Context, attrs: AttributeSet?, type: CornersEnum):Drawable {
        this.type = type
        val typeArray = context.obtainStyledAttributes(attrs, R.styleable.CornerTextView)

        cornerAll = typeArray.getDimension(R.styleable.CornerTextView_corner_all, defValue)
        cornerTop = typeArray.getDimension(R.styleable.CornerTextView_corner_top, defValue)
        cornerBottom = typeArray.getDimension(
                R.styleable.CornerTextView_corner_bottom,
                defValue
        )
        cornerTopLeft = typeArray.getDimension(
                R.styleable.CornerTextView_corner_top_left,
                defValue
        )
        cornerTopRight = typeArray.getDimension(
                R.styleable.CornerTextView_corner_top_right,
                defValue
        )
        cornerBottomLeft = typeArray.getDimension(
                R.styleable.CornerTextView_corner_bottom_left,
                defValue
        )
        cornerBottomRight =
                typeArray.getDimension(R.styleable.CornerTextView_corner_bottom_right, defValue)

        stroke = typeArray.getDimension(R.styleable.CornerTextView_stroke, defValue)
        strokeColor = typeArray.getColor(
                R.styleable.CornerTextView_stroke_color,
            ContextCompat.getColor(context, android.R.color.white)
        )
//        val tset = typeArray.getColorStateList(R.styleable.CornerTextView_stroke_color)

        bgColor = typeArray.getColor(
                R.styleable.CornerTextView_bg_color, context.getColor(
                android.R.color.white
        )
        )

        typeArray.recycle()

        return setDrawables()
    }

    fun setCustomStrokeSize(width:Int):Drawable{
        stroke = width.toFloat()
        return setDrawables()
    }

    fun setCustomStrokeColor(@ColorInt color:Int):Drawable{
        strokeColor = color
        return setDrawables()
    }

    fun setCustomBackGroundColor(@ColorInt color:Int):Drawable{
        bgColor = color
        return setDrawables()
    }

    private fun setDrawables():Drawable{
        return Drawables().getSelectableDrawableFor(
            type,
            cornerTop,
            cornerBottom,
            cornerTopLeft,
            cornerTopRight,
            cornerBottomRight,
            cornerBottomLeft,
            cornerAll,
            stroke,
            strokeColor,
            bgColor
        )
    }
}
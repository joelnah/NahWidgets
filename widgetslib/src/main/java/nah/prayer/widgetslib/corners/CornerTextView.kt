package nah.prayer.widgetslib.corners

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import nah.prayer.widgetslib.R


class CornerTextView: AppCompatTextView {
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        style(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        style(context, attrs)
    }

    private fun style(context: Context, attrs: AttributeSet?) {
        this.setBackgroundColor(ContextCompat.getColor(context, android.R.color.white))
        val typeArray = context.obtainStyledAttributes(attrs, R.styleable.CornerTextView)

        val defValue = 0f

        val cornerAll = typeArray.getDimension(R.styleable.CornerTextView_corner_all, defValue)
        val cornerTop = typeArray.getDimension(R.styleable.CornerTextView_corner_top, defValue)
        val cornerBottom = typeArray.getDimension(
            R.styleable.CornerTextView_corner_bottom,
            defValue
        )
        val cornerTopLeft = typeArray.getDimension(
            R.styleable.CornerTextView_corner_top_left,
            defValue
        )
        val cornerTopRight = typeArray.getDimension(
            R.styleable.CornerTextView_corner_top_right,
            defValue
        )
        val cornerBottomLeft = typeArray.getDimension(
            R.styleable.CornerTextView_corner_bottom_left,
            defValue
        )
        val cornerBottomRight =
            typeArray.getDimension(R.styleable.CornerTextView_corner_bottom_right, defValue)

        val stroke = typeArray.getDimension(R.styleable.CornerTextView_stroke, defValue)
        val strokeColor = typeArray.getColor(
            R.styleable.CornerTextView_strokeColor, ContextCompat.getColor(
                context,
                android.R.color.white
            )
        )

        val bgColor = typeArray.getColor(
            R.styleable.CornerTextView_bgColor, context.getColor(
                android.R.color.white
            )
        )
        this.background = Drawables().getSelectableDrawableFor(
            CornersEnum.TEXT,
            cornerTop,
            cornerBottom,
            cornerTopLeft,
            cornerTopRight,
            cornerBottomRight,
            cornerBottomLeft,
            cornerAll,
            stroke.toInt(),
            strokeColor,
            bgColor
        )

        typeArray.recycle()
    }
}
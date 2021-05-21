package nah.prayer.widgetslib.corners;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;

import androidx.annotation.NonNull;

import java.util.Arrays;

public class Drawables {
    float defValue = 0f;

    @NonNull
    public Drawable getSelectableDrawableFor(
            CornersEnum type,
            float cornerTop,
            float cornerBottom,
            float cornerTopLeft,
            float cornerTopRight,
            float cornerBottomRight,
            float cornerBottomLeft,
            float cornerAll,
            int stroke,
            int strokeColor,
            int bgColor) {

        ColorStateList pressedColor = ColorStateList.valueOf(lightenOrDarken(bgColor, 0.2D));
        float[] corners = getCorners(cornerTop, cornerBottom, cornerTopLeft, cornerTopRight, cornerBottomRight, cornerBottomLeft);

        Drawable drawable;
        if (type == CornersEnum.BUTTON) {
            drawable = new RippleDrawable(
                    pressedColor,
                    getGradientDrawable(corners, cornerAll, stroke, strokeColor, bgColor),
                    getRippleMask(corners, bgColor)
            );
        } else {
            drawable = getGradientDrawable(corners, cornerAll, stroke, strokeColor, bgColor);
        }

        return drawable;
    }

    @NonNull
    private GradientDrawable getGradientDrawable(float[] corners, float cornerAll, int stroke, int strokeColor, int bgColor) {
        GradientDrawable gradientDrawable = new GradientDrawable();

        if (stroke != defValue) {
            gradientDrawable.setStroke(stroke, strokeColor);
        }
        gradientDrawable.setColor(bgColor);

        if (cornerAll != defValue) {
            gradientDrawable.setCornerRadius(cornerAll);
        } else {
            gradientDrawable.setCornerRadii(
                    new float[]{corners[0], corners[1], corners[2], corners[3], corners[4], corners[5], corners[6], corners[7]});
        }
        return gradientDrawable;
    }

    @NonNull
    private float[] getCorners(
            float cornerTop,
            float cornerBottom,
            float cornerTopLeft,
            float cornerTopRight,
            float cornerBottomRight,
            float cornerBottomLeft
    ) {
        float topL = cornerTopLeft;
        float topR = cornerTopRight;
        float bottomR = cornerBottomRight;
        float bottomL = cornerBottomLeft;


        if (cornerTop != defValue) {
            topL = cornerTop;
            topR = cornerTop;
        }

        if (cornerBottom != defValue) {
            bottomR = cornerBottom;
            bottomL = cornerBottom;
        }

        return new float[]{topL, topL, topR, topR, bottomR, bottomR, bottomL, bottomL};
    }

    private Drawable getRippleMask(float[] corners, int color) {
        Arrays.fill(
                new float[]{corners[0], corners[1], corners[2], corners[3], corners[4], corners[5], corners[6], corners[7]},
                3);

        RoundRectShape r = new RoundRectShape(
                new float[]{corners[0], corners[1], corners[2], corners[3], corners[4], corners[5], corners[6], corners[7]},
                null, null);
        ShapeDrawable shapeDrawable = new ShapeDrawable(r);
        shapeDrawable.getPaint().setColor(color);
        return shapeDrawable;
    }

    private int lightenOrDarken(int color, double fraction) {
        if (canLighten(color, fraction)) {
            return lighten(color, fraction);
        } else {
            return darken(color, fraction);
        }
    }

    private int lighten(int color, double fraction) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        red = lightenColor(red, fraction);
        green = lightenColor(green, fraction);
        blue = lightenColor(blue, fraction);
        int alpha = Color.alpha(color);
        return Color.argb(alpha, red, green, blue);
    }

    private int darken(int color, double fraction) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        red = darkenColor(red, fraction);
        green = darkenColor(green, fraction);
        blue = darkenColor(blue, fraction);
        int alpha = Color.alpha(color);

        return Color.argb(alpha, red, green, blue);
    }

    private boolean canLighten(int color, double fraction) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        return canLightenComponent(red, fraction)
                && canLightenComponent(green, fraction)
                && canLightenComponent(blue, fraction);
    }

    private boolean canLightenComponent(int colorComponent, double fraction) {
        int red = Color.red(colorComponent);
        int green = Color.green(colorComponent);
        int blue = Color.blue(colorComponent);
        return red + (red * fraction) < 255
                && green + (green * fraction) < 255
                && blue + (blue * fraction) < 255;
    }

    private int darkenColor(int color, double fraction) {
        return (int) Math.max(color - (color * fraction), 0);
    }

    private int lightenColor(int color, double fraction) {
        return (int) Math.min(color + (color * fraction), 255);
    }

}
# NahWidgets

[![](https://jitpack.io/v/joelnah/NahWidgets.svg)](https://jitpack.io/#joelnah/NahWidgets)

implementation 'com.github.joelnah:NahWidgets:Tag'

사용

        <nah.prayer.widgetslib.corners.CornerButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:padding="20dp"
            android:textColor="@color/black"
            android:textAllCaps="false"
            app:corner_top_right="@dimen/buttonRound"
            app:corner_bottom_left="@dimen/buttonRound"
            app:stroke="1dp"
            app:stroke_color="@android:color/holo_green_dark"
            app:bg_color="@android:color/holo_blue_bright"
            android:text="Hello World!"/>
        
        ※CornerTextView도 동일

스타일

        corner_all : 전체 모서리 적용
        corner_top : 상단만 적용 (개별보다 우선순위 높음)
        corner_bottom : 하단만 적용 (개별보다 우선순위 높음)
        corner_top_left : 상단 왼쪽
        corner_top_right : 상단 오른쪽
        corner_bottom_left : 하단 왼쪽 
        corner_bottom_right : 하단 오른쪽
        stroke : 외각선 두께
        stroke_color : 외각선 색상
        bg_color : 배경 색상


코드수정

        view.setNaStrokeColor(ContextCompat.getColor(this, R.color.black))
        view.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        view.setNaStrokeSize(5)

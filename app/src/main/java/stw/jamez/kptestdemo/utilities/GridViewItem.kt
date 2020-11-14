package stw.jamez.kptestdemo.utilities

import android.content.Context
import android.util.AttributeSet
import androidx.cardview.widget.CardView

class GridViewItem:CardView {
    constructor(context: Context) : super(context) {}
    constructor(context:Context, attrs: AttributeSet) : super(context, attrs) {}
    constructor(context:Context, attrs:AttributeSet, defStyle:Int) : super(context, attrs, defStyle) {}
    override fun onMeasure(widthMeasureSpec:Int, heightMeasureSpec:Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec) // This is the key that will make the height equivalent to its width
    }
}
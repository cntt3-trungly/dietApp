package fontsmaterialuiux;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
/**
 * Created by Mohammmed Alsudani on 26-Jan-19.
 * for more visit http://materialuiux.com
 */
public class cairoBoldTextView extends AppCompatTextView
{

    public cairoBoldTextView(Context context)
    {
        super(context);
        init();
    }

    public cairoBoldTextView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public cairoBoldTextView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init()
    {
        setLineSpacing(0,0.6f);

        if (!isInEditMode())
        {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Cairo-Bold.ttf");
            setTypeface(tf);
        }
    }

}

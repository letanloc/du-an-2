package efood.loc.com.efood.Model;

import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.RemoteViews;

/**
 * Created by loc on 26/02/2016.
 */
@RemoteViews.RemoteView
public abstract class Unline {
      public static final SpannableString unlinetext(String st) {
        SpannableString content = new SpannableString(st);
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        return content;
    }

}

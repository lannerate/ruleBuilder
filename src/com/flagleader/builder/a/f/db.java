package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.builder.d;
import java.util.HashMap;
import org.eclipse.swt.browser.TitleEvent;
import org.eclipse.swt.browser.TitleListener;

class db
  implements TitleListener
{
  db(da paramda)
  {
  }

  public void changed(TitleEvent paramTitleEvent)
  {
    if (!da.b(this.a))
    {
      da.c(this.a, true);
      if (paramTitleEvent.title != null)
        if (paramTitleEvent.title.indexOf(";") <= 0)
        {
          da.c(this.a).getProjectTree().c(paramTitleEvent.title);
        }
        else
        {
          String[] arrayOfString1 = paramTitleEvent.title.split("&");
          for (int i = 0; i < arrayOfString1.length; i++)
          {
            String[] arrayOfString2 = arrayOfString1[i].split(";");
            if (arrayOfString2.length != 2)
              continue;
            da.d(this.a).put(arrayOfString2[0], arrayOfString2[1]);
          }
        }
      da.c(this.a, false);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.db
 * JD-Core Version:    0.6.0
 */
package com.flagleader.builder.a.d;

import com.flagleader.builder.dialogs.d.a;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.export.PageFieldModel;
import org.eclipse.swt.browser.TitleEvent;
import org.eclipse.swt.browser.TitleListener;

class J
  implements TitleListener
{
  J(I paramI)
  {
  }

  public void changed(TitleEvent paramTitleEvent)
  {
    if (!I.a(this.a))
    {
      I.b(this.a, true);
      if (paramTitleEvent.title != null)
      {
        Object localObject;
        if (paramTitleEvent.title.indexOf(";") > 0)
        {
          localObject = paramTitleEvent.title.substring(0, paramTitleEvent.title.indexOf(";"));
          String str = paramTitleEvent.title.substring(paramTitleEvent.title.indexOf(";") + 1);
          int i = this.a.e().getElementPos((PageFieldModel)this.a.e().getPageField((String)localObject));
          int j = this.a.e().getElementPos((PageFieldModel)this.a.e().getPageField(str));
          if (i != j)
          {
            this.a.e().moveElement(i, j);
            this.a.e().setModified(true);
            this.a.update();
          }
        }
        else if (this.a.e().getPageField(paramTitleEvent.title) != null)
        {
          localObject = new a((PageFieldModel)this.a.e().getPageField(paramTitleEvent.title));
          if ((((a)localObject).open() == 0) && (((a)localObject).o()))
          {
            this.a.e().setModified(true);
            this.a.update();
          }
        }
      }
      I.b(this.a, false);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.J
 * JD-Core Version:    0.6.0
 */
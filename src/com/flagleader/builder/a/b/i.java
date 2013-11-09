package com.flagleader.builder.a.b;

import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class i
  implements Listener
{
  i(e parame, int paramInt)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    Object localObject;
    String str;
    IElement[] arrayOfIElement;
    int i;
    if (this.b == 1)
    {
      localObject = new C(this.a, "", this.b);
      if (((C)localObject).open() == 0)
      {
        str = ((C)localObject).a();
        if (str != null)
        {
          arrayOfIElement = e.b(this.a);
          if (arrayOfIElement.length > 0)
          {
            this.a.K().initUndoable();
            for (i = 0; i < arrayOfIElement.length; i++)
              this.a.a(arrayOfIElement[i], this.b, str);
            this.a.K().setModified(true);
            this.a.K().takeSnapshot();
            this.a.K().updateViewer();
          }
        }
      }
    }
    else
    {
      localObject = new A(this.a, "", this.b);
      if (((A)localObject).open() == 0)
      {
        str = ((A)localObject).a();
        if (str != null)
        {
          arrayOfIElement = e.b(this.a);
          if (arrayOfIElement.length > 0)
          {
            this.a.K().initUndoable();
            for (i = 0; i < arrayOfIElement.length; i++)
              this.a.a(arrayOfIElement[i], this.b, str);
            this.a.K().setModified(true);
            this.a.K().takeSnapshot();
            this.a.K().updateViewer();
          }
        }
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.i
 * JD-Core Version:    0.6.0
 */
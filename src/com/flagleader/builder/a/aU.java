package com.flagleader.builder.a;

import com.flagleader.builder.a.c.b;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

class aU
  implements Runnable
{
  aU(aS paramaS)
  {
  }

  public void run()
  {
    if (!aS.a(this.a))
    {
      if ((this.a.k == null) || (this.a.k.isDisposed()))
        return;
      ToolItem[] arrayOfToolItem = this.a.k.getItems();
      for (int i = 0; i < arrayOfToolItem.length; i++)
      {
        b localb = (b)arrayOfToolItem[i].getData();
        if (localb == null)
          continue;
        if (localb.b())
          arrayOfToolItem[i].setEnabled(true);
        else
          arrayOfToolItem[i].setEnabled(false);
        if (localb.g() == 1)
        {
          if (!localb.h())
            continue;
          arrayOfToolItem[i].setSelection(true);
        }
        else
        {
          if (localb.g() != 2)
            continue;
          ((Combo)arrayOfToolItem[i].getControl()).setText(localb.j());
        }
      }
      aS.a(this.a, true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.aU
 * JD-Core Version:    0.6.0
 */
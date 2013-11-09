package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rom.IBusinessObject;
import java.util.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

class bR extends SelectionAdapter
{
  bR(bQ parambQ)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = bQ.a(this.a).getSelectionIndex();
    if (i >= 0)
    {
      for (int j = 0; j < bE.c(bQ.c(this.a)).length; j++)
      {
        if (!bE.c(bQ.c(this.a))[j].equalsIgnoreCase(((IBusinessObject)bE.d(bQ.c(this.a)).get(i)).getDisplayName()))
          continue;
        bQ.b(this.a).select(j);
        return;
      }
      for (j = 0; j < bE.c(bQ.c(this.a)).length; j++)
      {
        if (((IBusinessObject)bE.d(bQ.c(this.a)).get(i)).getDisplayName().indexOf(bE.c(bQ.c(this.a))[j]) < 0)
          continue;
        bQ.b(this.a).select(j);
        return;
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bR
 * JD-Core Version:    0.6.0
 */
package com.flagleader.builder.shell;

import com.flagleader.repository.a.a;
import java.io.IOException;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class bK extends SelectionAdapter
{
  bK(bu parambu)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (bu.c(this.a).getSelectionIndex() == 1)
    {
      bu.d(this.a);
    }
    else if (bu.c(this.a).getSelectionIndex() == 2)
    {
      bu.d(this.a);
      try
      {
        bu.e(this.a);
      }
      catch (a locala)
      {
        bu.a(this.a, "", locala.getLocalizedMessage());
      }
      catch (IOException localIOException)
      {
        bu.a(this.a, "", localIOException.getLocalizedMessage());
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.bK
 * JD-Core Version:    0.6.0
 */
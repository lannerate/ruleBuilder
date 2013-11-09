package com.flagleader.builder.shell;

import com.flagleader.repository.a.a;
import java.io.IOException;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class bg extends SelectionAdapter
{
  bg(aQ paramaQ)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (aQ.f(this.a).getSelectionIndex() == 1)
      try
      {
        aQ.g(this.a);
      }
      catch (a locala)
      {
        aQ.a(this.a, "", locala.getLocalizedMessage());
      }
      catch (IOException localIOException)
      {
        aQ.a(this.a, "", localIOException.getLocalizedMessage());
      }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.bg
 * JD-Core Version:    0.6.0
 */
package com.flagleader.builder.shell;

import com.flagleader.repository.lang.d;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class am extends SelectionAdapter
{
  am(aa paramaa)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    try
    {
      aa.e(this.a).c();
    }
    catch (Exception localException)
    {
      MessageDialog.openError(null, "", localException.getLocalizedMessage());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.am
 * JD-Core Version:    0.6.0
 */
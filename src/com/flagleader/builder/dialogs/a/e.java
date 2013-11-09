package com.flagleader.builder.dialogs.a;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;

class e extends SelectionAdapter
{
  e(d paramd)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (d.a(this.a).getText().length() > 0)
      try
      {
        d.b(this.a);
      }
      catch (Exception localException)
      {
        MessageDialog.openError(this.a.getShell(), "", localException.getMessage());
        localException.printStackTrace();
      }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.a.e
 * JD-Core Version:    0.6.0
 */
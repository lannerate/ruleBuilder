package com.flagleader.builder.shell;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class aR extends SelectionAdapter
{
  aR(aQ paramaQ)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if ((this.a.l()) && (MessageDialog.openQuestion(this.a.a, "", aQ.a(this.a, "rspmodified.RspEditor"))))
      this.a.i();
    this.a.g();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.aR
 * JD-Core Version:    0.6.0
 */
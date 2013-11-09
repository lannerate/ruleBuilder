package com.flagleader.builder.shell;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;

class ch extends ShellAdapter
{
  ch(bX parambX)
  {
  }

  public void shellClosed(ShellEvent paramShellEvent)
  {
    if ((bX.k(this.a)) && (MessageDialog.openConfirm(null, "", bX.a(this.a, "toSave.RspTagEditor"))))
      this.a.e();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.ch
 * JD-Core Version:    0.6.0
 */
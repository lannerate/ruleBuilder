package com.flagleader.builder.shell;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;

class bJ extends ShellAdapter
{
  bJ(bu parambu)
  {
  }

  public void shellClosed(ShellEvent paramShellEvent)
  {
    if ((this.a.k()) && (MessageDialog.openQuestion(this.a.a, "", "已经修改模板,是否保存?")))
      this.a.f();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.bJ
 * JD-Core Version:    0.6.0
 */
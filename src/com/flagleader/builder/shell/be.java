package com.flagleader.builder.shell;

import com.flagleader.builder.widget.a.t;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;

class be extends ShellAdapter
{
  be(aQ paramaQ)
  {
  }

  public void shellClosed(ShellEvent paramShellEvent)
  {
    if ((this.a.l()) && (MessageDialog.openQuestion(this.a.a, "", aQ.a(this.a, "rspmodified.RspEditor"))))
      this.a.i();
    if (this.a.e != null)
      this.a.e.b();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.be
 * JD-Core Version:    0.6.0
 */
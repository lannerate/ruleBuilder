package com.flagleader.builder.shell;

import com.flagleader.builder.widget.a.t;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;

class f extends ShellAdapter
{
  f(ClassInfoEditor paramClassInfoEditor)
  {
  }

  public void shellClosed(ShellEvent paramShellEvent)
  {
    if ((ClassInfoEditor.f(this.a)) && (MessageDialog.openQuestion(this.a.a, "", ClassInfoEditor.a(this.a, "changed.ClassInfoEditor"))))
      this.a.i();
    if (this.a.f != null)
      this.a.f.b();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.f
 * JD-Core Version:    0.6.0
 */
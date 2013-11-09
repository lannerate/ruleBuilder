package org.agilemore.agilegrid.a;

import java.text.MessageFormat;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;

class n extends ShellAdapter
{
  n(l paraml)
  {
  }

  public void shellDeactivated(ShellEvent paramShellEvent)
  {
    boolean bool = l.a(this.a, this.a.n);
    if (bool)
    {
      l.b(this.a);
      l.c(this.a);
    }
    else
    {
      l.a(this.a, MessageFormat.format(this.a.j(), new Object[] { this.a.n.toString() }));
      l.a(this.a);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.a.n
 * JD-Core Version:    0.6.0
 */
package com.flagleader.builder.shell;

import com.flagleader.builder.dialogs.g.b;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class eF extends SelectionAdapter
{
  eF(RuleTraceViewer paramRuleTraceViewer)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    b localb = new b(RuleTraceViewer.d(this.a));
    if (localb.open() == 0)
    {
      try
      {
        RuleTraceViewer.a(this.a, localb.b());
      }
      catch (Exception localException)
      {
        this.a.a(localException.getMessage());
      }
      RuleTraceViewer.e(this.a);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.eF
 * JD-Core Version:    0.6.0
 */
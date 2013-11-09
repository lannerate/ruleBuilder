package com.flagleader.builder.widget.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.al;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;

class aj extends FocusAdapter
{
  aj(af paramaf)
  {
  }

  public void focusGained(FocusEvent paramFocusEvent)
  {
    if (af.b(this.a) != null)
      af.b(this.a).getMenuAndToolBar().a(this.a);
    af.c(this.a);
    this.a.notifyObservers();
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    if (af.b(this.a) != null)
      af.b(this.a).getMenuAndToolBar().a(null);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.a.aj
 * JD-Core Version:    0.6.0
 */
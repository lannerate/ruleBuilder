package com.flagleader.builder.a;

import com.flagleader.builder.a.c.b;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

class aV extends SelectionAdapter
{
  aV(aS paramaS, b paramb, Combo paramCombo)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    this.b.a(this.c.getSelectionIndex());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.aV
 * JD-Core Version:    0.6.0
 */
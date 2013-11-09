package org.agilemore.agilegrid.a;

import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class e extends SelectionAdapter
{
  e(d paramd)
  {
  }

  public void widgetDefaultSelected(SelectionEvent paramSelectionEvent)
  {
    this.a.N();
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    this.a.n = d.a(this.a).getSelectionIndex();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.a.e
 * JD-Core Version:    0.6.0
 */
package org.agilemore.agilegrid;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;

class D extends FocusAdapter
{
  D(A paramA)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    this.a.a();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.D
 * JD-Core Version:    0.6.0
 */
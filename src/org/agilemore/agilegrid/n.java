package org.agilemore.agilegrid;

import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;

class n
  implements FocusListener
{
  private G[] b;

  n(e parame)
  {
  }

  public void focusGained(FocusEvent paramFocusEvent)
  {
    if ((!this.a.i()) && (this.b != null))
    {
      e.h(this.a).a(this.b);
      this.a.a(this.b);
      this.b = null;
    }
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    if (!this.a.i())
    {
      this.b = e.h(this.a).e();
      e.h(this.a).d();
      if (this.b != null)
        this.a.a(this.b);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.n
 * JD-Core Version:    0.6.0
 */
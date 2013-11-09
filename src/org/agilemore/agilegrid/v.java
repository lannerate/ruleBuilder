package org.agilemore.agilegrid;

import org.eclipse.jface.action.Action;

public class v extends Action
{
  protected v(r paramr)
  {
    setId("AgileGridCopyActionHandler");
    setEnabled(false);
    setText("Copy");
  }

  public void run()
  {
    if ((this.a.h != null) && (!this.a.h.isDisposed()))
      this.a.a(this.a.h.y());
  }

  public void a()
  {
    if ((this.a.h != null) && (!this.a.h.isDisposed()))
    {
      G[] arrayOfG = this.a.h.y();
      setEnabled((arrayOfG != null) && (arrayOfG.length > 0));
    }
    else
    {
      setEnabled(false);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.v
 * JD-Core Version:    0.6.0
 */
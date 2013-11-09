package org.agilemore.agilegrid;

import org.eclipse.jface.action.Action;

public class x extends Action
{
  protected x(r paramr)
  {
    setId("AgileGridCutActionHandler");
    setEnabled(false);
    setText("Cut");
  }

  public void run()
  {
    if ((this.a.h != null) && (!this.a.h.isDisposed()))
    {
      G[] arrayOfG = this.a.h.y();
      this.a.a(arrayOfG);
      a(arrayOfG);
    }
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

  protected void a(G[] paramArrayOfG)
  {
    ar localar = this.a.h.j();
    if (localar == null)
      return;
    int i = paramArrayOfG.length > 4 ? 0 : 1;
    try
    {
      if (i == 0)
        this.a.h.setRedraw(false);
      for (int j = 0; j < paramArrayOfG.length; j++)
        localar.b(paramArrayOfG[j].c, paramArrayOfG[j].d, "");
      if (i != 0)
        this.a.h.a(paramArrayOfG);
    }
    finally
    {
      if (i == 0)
        this.a.h.setRedraw(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.x
 * JD-Core Version:    0.6.0
 */
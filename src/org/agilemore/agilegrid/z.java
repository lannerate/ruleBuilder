package org.agilemore.agilegrid;

import java.util.Vector;
import org.eclipse.jface.action.Action;

public class z extends Action
{
  protected z(r paramr)
  {
    setId("AgileGridSelectAllActionHandler");
    setEnabled(false);
    setText("Select All");
  }

  public void run()
  {
    if ((this.a.h != null) && (!this.a.h.isDisposed()))
    {
      au localau = this.a.h.w();
      if (localau != null)
        a(localau);
    }
  }

  public void a()
  {
    if ((this.a.h != null) && (!this.a.h.isDisposed()) && (this.a.h.h()))
      setEnabled(true);
    else
      setEnabled(false);
  }

  protected void a(au paramau)
  {
    Vector localVector = new Vector();
    for (int i = 0; i < paramau.a(); i++)
      for (int j = 0; j < paramau.b(); j++)
      {
        G localG = paramau.a(j, i);
        if ((localG.d != j) || (localG.c != i))
          continue;
        localVector.add(localG);
      }
    try
    {
      this.a.h.setRedraw(false);
      this.a.h.z();
      this.a.h.b((G[])localVector.toArray(new G[0]));
    }
    finally
    {
      this.a.h.setRedraw(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.z
 * JD-Core Version:    0.6.0
 */
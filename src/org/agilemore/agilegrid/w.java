package org.agilemore.agilegrid;

import java.util.Vector;
import org.eclipse.jface.action.Action;

public class w extends Action
{
  protected w(r paramr)
  {
    setId("AgileGridCopyAllActionHandler");
    setEnabled(false);
    setText("Copy All");
  }

  public void run()
  {
    if ((this.a.h != null) && (!this.a.h.isDisposed()))
      this.a.a(b());
  }

  public void a()
  {
    if ((this.a.h != null) && (!this.a.h.isDisposed()))
      setEnabled(true);
    else
      setEnabled(false);
  }

  private G[] b()
  {
    au localau = this.a.h.w();
    if (localau == null)
      return new G[0];
    Vector localVector = new Vector(localau.b() * localau.a());
    for (int i = 0; i < localau.a(); i++)
      for (int j = 0; j < localau.b(); j++)
      {
        G localG = localau.a(j, i);
        if ((localG.c != i) || (localG.d != j))
          continue;
        localVector.add(localG);
      }
    return (G[])localVector.toArray(new G[0]);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.w
 * JD-Core Version:    0.6.0
 */
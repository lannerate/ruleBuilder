package org.agilemore.agilegrid;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class W extends MouseAdapter
{
  private e a;
  private V b;

  public W(e parame, V paramV)
  {
    this.a = parame;
    this.b = paramV;
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button != 1)
      return;
    G localG = this.a.e(paramMouseEvent.x, paramMouseEvent.y);
    if ((localG == G.b) || (!a(localG.d)))
      return;
    int i = this.a.a(localG.d);
    int j = i + this.a.i(localG.d) - 1;
    int k = this.a.C() / 2;
    if ((paramMouseEvent.x - i < k) || (j - paramMouseEvent.x < k))
      return;
    au localau = this.a.w();
    aq localaq = localau.f();
    if (localaq != null)
    {
      int m = 1;
      if (localaq.c() == localG.d)
        if (localaq.b() == 1)
          m = 2;
        else if (localaq.b() == 2)
          m = -1;
      this.b.a(localG.d);
      this.b.b(m);
      localaq.a(this.b);
      if (this.a.d())
        this.a.n().b();
      this.a.redraw();
    }
  }

  public boolean a(int paramInt)
  {
    G localG = null;
    au localau = this.a.w();
    int i = localau.a();
    for (int j = 0; j < i; j++)
    {
      localG = localau.a(j, paramInt);
      if ((localG != null) && ((localG.c != j) || (localG.d != paramInt)))
        return false;
    }
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.W
 * JD-Core Version:    0.6.0
 */
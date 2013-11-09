package org.agilemore.agilegrid;

import java.util.ArrayList;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;

public class A
{
  private J g;
  private G h;
  private ad i;
  private ak j;
  private aj k;
  private FocusListener l;
  private MouseListener m;
  private e n;
  private TraverseListener o;
  private ArrayList p;
  private ae q;
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 4;
  public static final int d = 8;
  public static final int e = 16;
  public static final int f = 32;
  private int r;

  public A(e parame, int paramInt)
  {
    this.n = parame;
    this.r = paramInt;
    this.q = new ae(parame);
    this.k = new B(this);
    a(this.n);
  }

  private void a(e parame)
  {
    parame.addMouseListener(new C(this));
  }

  protected void a(MouseEvent paramMouseEvent, int paramInt)
  {
    if (paramMouseEvent.button == 1)
    {
      G localG = this.n.o(paramMouseEvent.x, paramMouseEvent.y);
      if (localG == G.b)
        return;
      localG = this.n.i(localG.c, localG.d);
      a(new ad(localG, null, paramMouseEvent, paramInt), null);
    }
  }

  synchronized void a(Object paramObject)
  {
    if (this.h == G.b)
      return;
    if (b(this.h.c, this.h.d))
    {
      this.n.a(false);
      if (paramObject == null)
        this.g = this.j.a(this.h.c, this.h.d);
      else
        this.g = this.j.a(this.h.c, this.h.d, paramObject);
      if (this.g != null)
      {
        this.i.m = this.g;
        if ((this.p != null) && (!this.p.isEmpty()))
          for (int i1 = 0; i1 < this.p.size(); i1++)
          {
            if (this.i.l)
            {
              this.h = null;
              return;
            }
            ((as)this.p.get(i1)).b(this.i);
          }
        this.g.a(this.k);
        this.j.a(this.g, this.h);
        Control localControl = this.g.i();
        this.g.a(this.i);
        if ((localControl == null) || (this.g == null))
          return;
        if (this.g.I())
        {
          if (this.l == null)
            this.l = new D(this);
          localControl.addFocusListener(this.l);
        }
        if (this.o == null)
          this.o = new E(this);
        localControl.addTraverseListener(this.o);
        if ((this.p != null) && (!this.p.isEmpty()))
          for (int i2 = 0; i2 < this.p.size(); i2++)
            ((as)this.p.get(i2)).a(this.i);
      }
    }
    else
    {
      this.h = null;
    }
  }

  synchronized void a()
  {
    if ((this.g == null) || (this.h == G.b))
      return;
    J localJ = this.g;
    this.g = null;
    ag localag = new ag(this.h, localJ, true);
    if (this.p != null)
      for (int i1 = 0; i1 < this.p.size(); i1++)
        ((as)this.p.get(i1)).b(localag);
    this.i = null;
    a(localJ);
    localJ.b(this.k);
    Control localControl = localJ.i();
    if (localControl != null)
    {
      if (this.m != null)
      {
        localControl.removeMouseListener(this.m);
        this.m = null;
      }
      if (this.l != null)
        localControl.removeFocusListener(this.l);
      if (this.o != null)
        localControl.removeTraverseListener(this.o);
    }
    localJ.b();
    if (this.p != null)
      for (int i2 = 0; i2 < this.p.size(); i2++)
        ((as)this.p.get(i2)).a(localag);
    localJ.c();
    this.h = null;
  }

  synchronized void b()
  {
    if (this.g == null)
      return;
    J localJ = this.g;
    this.g = null;
    ag localag = new ag(this.h, localJ, false);
    if (this.p != null)
      for (int i1 = 0; i1 < this.p.size(); i1++)
        ((as)this.p.get(i1)).b(localag);
    localJ.b(this.k);
    Control localControl = localJ.i();
    if (localControl != null)
    {
      if (this.m != null)
      {
        localControl.removeMouseListener(this.m);
        this.m = null;
      }
      if (this.l != null)
        localControl.removeFocusListener(this.l);
      if (this.o != null)
        localControl.removeTraverseListener(this.o);
    }
    localJ.b();
    if (this.p != null)
      for (int i2 = 0; i2 < this.p.size(); i2++)
        ((as)this.p.get(i2)).a(localag);
    localJ.c();
    this.i = null;
    this.h = null;
  }

  void a(ad paramad, Object paramObject)
  {
    if (this.q.a(paramad))
    {
      if (this.g != null)
        a();
      this.h = ((G)paramad.getSource());
      if ((this.h.c == -1) || (this.h.d == -1))
        return;
      this.h = this.n.i(this.h.c, this.h.d);
      this.n.b(this.h);
      this.i = paramad;
      a(paramObject);
    }
  }

  void a(J paramJ)
  {
    if (this.j != null)
      this.j.b(paramJ, this.h);
  }

  boolean c()
  {
    return this.g != null;
  }

  void a(as paramas)
  {
    if (this.p == null)
      this.p = new ArrayList();
    this.p.add(paramas);
  }

  void b(as paramas)
  {
    if (this.p != null)
      this.p.remove(paramas);
  }

  protected void a(G paramG, TraverseEvent paramTraverseEvent)
  {
    G localG = null;
    if (paramTraverseEvent.detail == 8)
    {
      paramTraverseEvent.doit = false;
      if (((paramTraverseEvent.stateMask & 0x40000) == 262144) && ((this.r & 0x8) == 8))
        localG = a(paramG, 1);
      else if ((this.r & 0x10) == 16)
        localG = a(paramG, 4);
    }
    else if (paramTraverseEvent.detail == 16)
    {
      paramTraverseEvent.doit = false;
      if (((paramTraverseEvent.stateMask & 0x40000) == 262144) && ((this.r & 0x8) == 8))
        localG = a(paramG, 2);
      else if ((this.r & 0x10) == 16)
        localG = a(paramG, 8);
    }
    if (localG != null)
    {
      this.n.setRedraw(false);
      this.n.b(localG);
      this.n.a(false);
      ad localad = new ad(localG, null, paramTraverseEvent);
      this.n.a(localad, null);
      this.n.setRedraw(true);
    }
  }

  private G a(G paramG, int paramInt)
  {
    Object localObject = null;
    G localG = this.n.a(paramG, paramInt, true);
    if (localG != null)
    {
      if (this.j.b(localG.c, localG.d))
        localObject = localG;
      else
        localObject = a(localG, paramInt);
    }
    else
    {
      if ((this.r & 0x4) == 4)
      {
        if (paramInt == 8)
          localG = new G(this.n, paramG.c, 0);
        else if (paramInt == 4)
          localG = new G(this.n, paramG.c, this.n.w().b() - 1);
      }
      else if ((this.r & 0x2) == 2)
        if (paramInt == 1)
          localG = new G(this.n, 0, paramG.d);
        else if (paramInt == 2)
          localG = new G(this.n, this.n.w().a() - 1, paramG.d);
      if ((localG != null) && (!this.j.b(localG.c, localG.d)))
        localObject = a(localG, paramInt);
      else
        localObject = localG;
    }
    return (G)localObject;
  }

  protected e d()
  {
    return this.n;
  }

  void e()
  {
    if (c())
      if (!this.n.p(this.h.c, this.h.d))
      {
        Rectangle localRectangle = new Rectangle(-101, -101, 100, 100);
        this.g.a(localRectangle);
      }
      else
      {
        this.g.b(this.h);
      }
  }

  boolean a(int paramInt1, int paramInt2)
  {
    return (c()) && (paramInt2 == this.h.d) && (paramInt1 == this.h.c);
  }

  void a(ak paramak)
  {
    this.j = paramak;
  }

  ak f()
  {
    return this.j;
  }

  boolean b(int paramInt1, int paramInt2)
  {
    return (!c()) && (this.j != null) && (this.j.b(paramInt1, paramInt2));
  }

  ae g()
  {
    return this.q;
  }

  void a(ae paramae)
  {
    if (this.q != null)
      this.q.a(false);
    this.q = paramae;
  }

  int h()
  {
    return this.r;
  }

  void a(int paramInt)
  {
    this.r = paramInt;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.A
 * JD-Core Version:    0.6.0
 */
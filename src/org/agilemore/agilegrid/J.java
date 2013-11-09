package org.agilemore.agilegrid;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;

public abstract class J
{
  private ArrayList a = new ArrayList(10);
  private ArrayList n = new ArrayList(10);
  private boolean o = false;
  private al p = null;
  private String q = null;
  private boolean r = false;
  private Control s = null;
  private static final int t = 0;
  private int u = 0;
  public static final String b = "copy";
  public static final String c = "cut";
  public static final String d = "delete";
  public static final String e = "find";
  public static final String f = "paste";
  public static final String g = "redo";
  public static final String h = "selectall";
  public static final String i = "undo";
  protected G j;
  protected e k;
  protected Rectangle l;
  protected String m;
  private KeyListener v;
  private TraverseListener w;

  protected J(e parame)
  {
    this(parame, 0);
  }

  protected J(e parame, int paramInt)
  {
    this.u = paramInt;
    this.k = parame;
    this.s = a(parame);
    if ((this.s != null) && (!this.s.isDisposed()))
    {
      this.v = new K(this);
      this.s.addKeyListener(this.v);
      this.w = new L(this);
      this.s.addTraverseListener(this.w);
      this.s.setVisible(false);
    }
  }

  public void a(aj paramaj)
  {
    this.a.add(paramaj);
  }

  public void a(PropertyChangeListener paramPropertyChangeListener)
  {
    this.n.add(paramPropertyChangeListener);
  }

  protected abstract Control a(e parame);

  public void b()
  {
    if ((this.s != null) && (!this.s.isDisposed()))
      this.s.setVisible(false);
  }

  public void c()
  {
    if (this.s != null)
    {
      this.s.removeKeyListener(this.v);
      this.s.removeTraverseListener(this.w);
      Control localControl = this.s;
      this.s = null;
      localControl.dispose();
    }
  }

  protected abstract Object d();

  protected void e()
  {
    if (this.s != null)
      this.s.setFocus();
  }

  protected abstract void a(Object paramObject);

  protected void f()
  {
    for (int i1 = 0; i1 < this.a.size(); i1++)
    {
      aj localaj = (aj)this.a.get(i1);
      localaj.b();
    }
  }

  protected void g()
  {
    for (int i1 = 0; i1 < this.a.size(); i1++)
    {
      aj localaj = (aj)this.a.get(i1);
      localaj.a();
    }
  }

  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (int i1 = 0; i1 < this.a.size(); i1++)
    {
      aj localaj = (aj)this.a.get(i1);
      localaj.a(paramBoolean1, paramBoolean2);
    }
  }

  protected void a(String paramString)
  {
    for (int i1 = 0; i1 < this.n.size(); i1++)
    {
      PropertyChangeListener localPropertyChangeListener = (PropertyChangeListener)this.n.get(i1);
      localPropertyChangeListener.propertyChange(new PropertyChangeEvent(this, paramString, null, null));
    }
  }

  public void a(int paramInt)
  {
    this.u = paramInt;
  }

  public int h()
  {
    return this.u;
  }

  public Control i()
  {
    return this.s;
  }

  public String j()
  {
    return this.q;
  }

  public N k()
  {
    N localN = new N();
    Control localControl = i();
    if (localControl != null)
      localN.c = localControl.computeSize(-1, -1, true).x;
    return localN;
  }

  public al l()
  {
    return this.p;
  }

  public final Object m()
  {
    if (!this.o)
      return null;
    return d();
  }

  public boolean n()
  {
    return (this.s != null) && (this.s.getVisible());
  }

  public boolean o()
  {
    return false;
  }

  protected boolean b(Object paramObject)
  {
    this.q = null;
    if (this.p == null)
      return true;
    this.q = this.p.a(paramObject);
    return (this.q == null) || (this.q.equals(""));
  }

  public boolean p()
  {
    return false;
  }

  public boolean q()
  {
    return false;
  }

  public boolean r()
  {
    return this.r;
  }

  protected void s()
  {
    this.r = true;
  }

  public boolean t()
  {
    return false;
  }

  public boolean u()
  {
    return false;
  }

  public boolean v()
  {
    return false;
  }

  public boolean w()
  {
    return false;
  }

  public boolean x()
  {
    return false;
  }

  public boolean y()
  {
    return this.o;
  }

  protected void a()
  {
    if (n())
      f();
  }

  public void z()
  {
  }

  public void A()
  {
  }

  public void B()
  {
  }

  public void C()
  {
  }

  public void D()
  {
  }

  public void E()
  {
  }

  public void F()
  {
  }

  public void G()
  {
  }

  public void b(aj paramaj)
  {
    this.a.remove(paramaj);
  }

  public void b(PropertyChangeListener paramPropertyChangeListener)
  {
    this.n.remove(paramPropertyChangeListener);
  }

  protected void b(String paramString)
  {
    this.q = paramString;
  }

  public void H()
  {
    e();
  }

  public void a(al paramal)
  {
    this.p = paramal;
  }

  public final void c(Object paramObject)
  {
    this.o = b(paramObject);
    this.r = false;
    a(paramObject);
  }

  protected void a(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }

  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.o = paramBoolean2;
    this.r = true;
    a(paramBoolean1, paramBoolean2);
  }

  public void a(ad paramad)
  {
    this.j = ((G)paramad.getSource());
    this.l = a(this.j);
    a(this.l);
    if (this.s != null)
    {
      this.s.setToolTipText(this.m);
      this.s.addMouseMoveListener(new M(this));
      this.s.setVisible(true);
      H();
    }
  }

  protected Rectangle a(G paramG)
  {
    return this.k.d(paramG.c, paramG.d);
  }

  protected boolean I()
  {
    return true;
  }

  public boolean J()
  {
    if (this.s == null)
      return false;
    return this.s.isFocusControl();
  }

  public void b(G paramG)
  {
    Rectangle localRectangle = a(paramG);
    a(localRectangle);
  }

  public void a(Rectangle paramRectangle)
  {
    if (this.s != null)
      this.s.setBounds(paramRectangle);
  }

  public Rectangle K()
  {
    if (this.s != null)
    {
      Rectangle localRectangle = this.s.getBounds();
      return localRectangle;
    }
    return new Rectangle(0, 0, 0, 0);
  }

  protected void a(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.character == '\r') && ((paramKeyEvent.stateMask & 0x20000) == 0))
    {
      f();
      b();
    }
    else if (paramKeyEvent.character == '\033')
    {
      g();
    }
    else
    {
      this.k.a(false);
    }
  }

  protected void a(TraverseEvent paramTraverseEvent)
  {
    int i1 = this.j.c;
    int i2 = this.j.d;
    G localG = null;
    switch (paramTraverseEvent.keyCode)
    {
    case 16777219:
      i2--;
      break;
    case 16777220:
      i2++;
      for (localG = this.k.i(i1, i2); this.j.equals(localG); localG = this.k.i(i1, i2))
        i2++;
      break;
    case 16777217:
      i1--;
      break;
    case 16777218:
      i1++;
      for (localG = this.k.i(i1, i2); this.j.equals(localG); localG = this.k.i(i1, i2))
        i2++;
    }
    if ((i1 != this.j.c) || (i2 != this.j.d))
    {
      f();
      this.k.b(new G(this.k, i1, i2));
      this.k.a(false);
    }
  }

  public void c(String paramString)
  {
    this.m = paramString;
  }

  public e L()
  {
    return this.k;
  }

  public void b(e parame)
  {
    this.k = parame;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.J
 * JD-Core Version:    0.6.0
 */
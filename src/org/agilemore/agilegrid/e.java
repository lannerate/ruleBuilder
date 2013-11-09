package org.agilemore.agilegrid;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ScrollBar;

public class e extends Canvas
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 4;
  public static final int d = 8;
  private A g;
  private R h;
  private ao i;
  private au j;
  private ar k;
  protected int e;
  protected int f;
  private G l;
  private boolean m;
  private Point n;
  private int o = 0;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t = 1;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y = 4;
  private ArrayList z;
  private ArrayList A;
  private PropertyChangeListener B;
  private Point C;
  private Cursor D;
  private Cursor E;
  private Cursor F;
  private Cursor G;
  private Cursor H;
  private String I;

  public e(Composite paramComposite, int paramInt)
  {
    super(paramComposite, 0x140000 | paramInt);
    this.o = paramInt;
    this.e = 0;
    this.f = 0;
    this.p = 0;
    this.q = 0;
    this.r = 0;
    this.s = 0;
    this.w = -2147483648;
    this.u = -2147483648;
    this.v = -2147483648;
    this.x = -2147483648;
    this.l = G.b;
    this.m = false;
    this.n = null;
    this.h = P();
    this.i = O();
    this.g = o();
    this.B = new f(this);
    this.j = M();
    this.j.a(this.B);
    this.k = N();
    this.k.a(this.B);
    this.z = new ArrayList(7);
    this.A = new ArrayList(7);
    a();
    this.I = super.getToolTipText();
    super.setToolTipText("");
    Display localDisplay = getDisplay();
    this.E = new Cursor(localDisplay, 7);
    this.F = new Cursor(localDisplay, 9);
    if ((this.o & 0x700) == 1792)
    {
      addListener(11, new h(this));
      a(new i(this));
    }
  }

  public void dispose()
  {
    checkWidget();
    if (this.D != null)
      this.D.dispose();
    if (this.E != null)
      this.E.dispose();
    if (this.F != null)
      this.F.dispose();
    if (this.G != null)
      this.G.dispose();
    if (this.H != null)
      this.H.dispose();
    ax.a();
    super.dispose();
  }

  protected void a()
  {
    addPaintListener(new j(this));
    addControlListener(new k(this));
    addMouseListener(new l(this));
    addMouseMoveListener(new m(this));
    addFocusListener(new n(this));
    p localp = new p(this);
    addListener(12, localp);
    addListener(1, localp);
    addListener(3, localp);
    addListener(8, localp);
    addListener(5, localp);
    addListener(32, localp);
    addListener(7, localp);
    ScrollBar localScrollBar1 = getVerticalBar();
    if (localScrollBar1 != null)
    {
      localScrollBar1.addSelectionListener(new o(this, localScrollBar1));
      localScrollBar1.addListener(13, localp);
    }
    ScrollBar localScrollBar2 = getHorizontalBar();
    if (localScrollBar2 != null)
    {
      localScrollBar2.addSelectionListener(new g(this, localScrollBar2));
      localScrollBar2.addListener(13, localp);
    }
  }

  private Rectangle E()
  {
    Rectangle localRectangle1 = getClientArea();
    Rectangle localRectangle2 = J();
    Rectangle localRectangle3 = K();
    if (localRectangle2.width > 0)
      localRectangle1.width -= localRectangle2.width;
    if (localRectangle3.height > 0)
      localRectangle1.height -= localRectangle3.height;
    int i1 = b();
    int i2 = L();
    int i3 = localRectangle1.x + localRectangle1.width - i1;
    int i4 = localRectangle1.x + localRectangle1.height - i2;
    return new Rectangle(i1, i2, i3, i4);
  }

  private Rectangle F()
  {
    Rectangle localRectangle1 = getClientArea();
    Rectangle localRectangle2 = J();
    if (localRectangle2.width > 0)
      localRectangle1.width -= localRectangle2.width;
    int i1 = this.t;
    if (this.j.j())
    {
      i1 += this.j.c();
      i1 += this.t;
    }
    int i2 = this.t;
    int i3 = localRectangle1.x + localRectangle1.width - i1;
    int i4 = this.j.e();
    i3 += this.t;
    i4 += this.t;
    return new Rectangle(i1, i2, i3, i4);
  }

  private Rectangle G()
  {
    Rectangle localRectangle1 = getClientArea();
    Rectangle localRectangle2 = K();
    if (localRectangle2.height > 0)
      localRectangle1.height -= localRectangle2.height;
    int i1 = this.t;
    int i2 = this.t;
    if (this.j.k())
    {
      i2 += this.j.e();
      i2 += this.t;
    }
    int i3 = this.j.c();
    int i4 = localRectangle1.y + localRectangle1.height - i2;
    i3 += this.t;
    i4 += this.t;
    return new Rectangle(i1, i2, i3, i4);
  }

  private Rectangle H()
  {
    if (this.j.i() <= 0)
      return new Rectangle(0, 0, 0, 0);
    Rectangle localRectangle1 = getClientArea();
    Rectangle localRectangle2 = J();
    if (localRectangle2.width > 0)
      localRectangle1.width -= localRectangle2.width;
    int i1 = this.t;
    if (this.j.j())
    {
      i1 += this.j.c();
      i1 += this.t;
    }
    for (int i2 = 0; i2 < this.j.h(); i2++)
    {
      i1 += i(i2);
      i1 += this.t;
    }
    i2 = this.t;
    if (this.j.k())
    {
      i2 += this.j.e();
      i2 += this.t;
    }
    int i3 = localRectangle1.x + localRectangle1.width - i1;
    int i4 = 0;
    for (int i5 = 0; i5 < this.j.i(); i5++)
    {
      i4 += this.j.e(i5);
      i4 += this.t;
    }
    return new Rectangle(i1, i2, i3, i4);
  }

  private Rectangle I()
  {
    if (this.j.h() <= 0)
      return new Rectangle(0, 0, 0, 0);
    Rectangle localRectangle1 = getClientArea();
    Rectangle localRectangle2 = K();
    if (localRectangle2.width > 0)
      localRectangle1.height -= localRectangle2.height;
    int i1 = this.t;
    if (this.j.k())
    {
      i1 += this.j.e();
      i1 += this.t;
    }
    for (int i2 = 0; i2 < this.j.i(); i2++)
    {
      i1 += this.j.e(i2);
      i1 += this.t;
    }
    i2 = this.t;
    if (this.j.j())
    {
      i2 += this.j.c();
      i2 += this.t;
    }
    int i3 = localRectangle1.y + localRectangle1.height - i1;
    int i4 = 0;
    for (int i5 = 0; i5 < this.j.h(); i5++)
    {
      i4 += i(i5);
      i4 += this.t;
    }
    return new Rectangle(i2, i1, i4, i3);
  }

  private Rectangle J()
  {
    int i1 = this.j.b() - 1;
    if (this.f + this.s - 1 == i1)
    {
      Rectangle localRectangle = getClientArea();
      int i2 = b(i1);
      if (i2 + 1 + this.t >= localRectangle.x + localRectangle.width)
        return new Rectangle(0, 0, -1, -1);
      int i3 = 0;
      int i4 = localRectangle.x + localRectangle.width - 1 - this.t - i2;
      int i5 = localRectangle.height;
      return new Rectangle(i2, i3, i4, i5);
    }
    return new Rectangle(0, 0, -1, -1);
  }

  private Rectangle K()
  {
    int i1 = this.j.a() - 1;
    if (this.e + this.q - 1 == i1)
    {
      Rectangle localRectangle = getClientArea();
      int i2 = c(i1);
      if (i2 + 1 + this.t >= localRectangle.y + localRectangle.height - 1)
        return new Rectangle(0, 0, -1, -1);
      int i3 = 0;
      int i4 = localRectangle.width;
      int i5 = localRectangle.y + localRectangle.height - i2 - 1 - this.t;
      return new Rectangle(i3, i2, i4, i5);
    }
    return new Rectangle(0, 0, -1, -1);
  }

  public void a(G[] paramArrayOfG)
  {
    if (paramArrayOfG.length <= 0)
      return;
    int i1 = getStyle();
    int i2 = 2147483647;
    int i3 = 2147483647;
    int i4 = -2147483648;
    int i5 = -2147483648;
    int i6 = this.e + this.p - 1;
    int i7 = this.f + this.r - 1;
    int i8 = this.j.i();
    int i9 = this.j.h();
    for (int i10 = 0; i10 < paramArrayOfG.length; i10++)
    {
      i2 = Math.min(i2, paramArrayOfG[i10].c);
      i3 = Math.min(i3, paramArrayOfG[i10].d);
      i4 = Math.max(i4, paramArrayOfG[i10].c);
      i5 = Math.max(i5, paramArrayOfG[i10].d);
      int i11;
      G[] arrayOfG;
      int i13;
      if ((paramArrayOfG[i10] instanceof Q))
      {
        for (i11 = 0; i11 < i9; i11++)
        {
          arrayOfG = a(new G(this, paramArrayOfG[i10].c, i11));
          for (i13 = 0; i13 < arrayOfG.length; i13++)
          {
            i4 = Math.max(i4, arrayOfG[i13].c);
            i5 = Math.max(i5, arrayOfG[i13].d);
          }
        }
        for (i11 = this.f; i11 <= i7; i11++)
        {
          arrayOfG = a(new G(this, paramArrayOfG[i10].c, i11));
          for (i13 = 0; i13 < arrayOfG.length; i13++)
          {
            i4 = Math.max(i4, arrayOfG[i13].c);
            i5 = Math.max(i5, arrayOfG[i13].d);
          }
        }
      }
      else if ((paramArrayOfG[i10] instanceof H))
      {
        for (i11 = 0; i11 < i8; i11++)
        {
          arrayOfG = a(new G(this, i11, paramArrayOfG[i10].d));
          for (i13 = 0; i13 < arrayOfG.length; i13++)
          {
            i4 = Math.max(i4, arrayOfG[i13].c);
            i5 = Math.max(i5, arrayOfG[i13].d);
          }
        }
        for (i11 = this.e; i11 <= i6; i11++)
        {
          arrayOfG = a(new G(this, i11, paramArrayOfG[i10].d));
          for (i13 = 0; i13 < arrayOfG.length; i13++)
          {
            i4 = Math.max(i4, arrayOfG[i13].c);
            i5 = Math.max(i5, arrayOfG[i13].d);
          }
        }
      }
      else
      {
        localObject = a(paramArrayOfG[i10]);
        for (int i12 = 0; i12 < localObject.length; i12++)
        {
          i4 = Math.max(i4, localObject[i12].c);
          i5 = Math.max(i5, localObject[i12].d);
        }
      }
    }
    if ((i1 & 0x10000000) != 0)
    {
      i2 = 0;
      i4 = i6;
    }
    else
    {
      if (i2 < 0)
        i2 = 0;
      if ((i2 >= i8) && (i2 < this.e))
        i2 = this.e;
      if (i2 > i6)
        i2 = i6;
      if (i4 < 0)
        i4 = 0;
      if (i4 > i6)
        i4 = i6;
      if ((i4 >= i8) && (i4 < this.e))
        i4 = i8 - 1;
    }
    if ((i1 & 0x8000000) != 0)
    {
      i3 = 0;
      i5 = i7;
    }
    else
    {
      if (i3 < 0)
        i3 = 0;
      if ((i3 >= i9) && (i3 < this.f))
        i3 = this.f;
      if (i3 > i7)
        i3 = i7;
      if (i5 < 0)
        i5 = 0;
      if (i5 > i7)
        i5 = i7;
      if ((i5 >= i9) && (i5 < this.f))
        i5 = i9 - 1;
    }
    G localG = i(i2, i3);
    Object localObject = d(localG.c, localG.d);
    localG = i(i4, i5);
    Rectangle localRectangle1 = d(localG.c, localG.d);
    Rectangle localRectangle2 = ((Rectangle)localObject).union(localRectangle1);
    redraw(localRectangle2.x, localRectangle2.y, localRectangle2.width, localRectangle2.height, true);
  }

  G[] a(G paramG)
  {
    G localG = this.j.a(paramG.c, paramG.d);
    if (!localG.equals(paramG))
      return new G[0];
    int i1 = paramG.c;
    int i2 = paramG.d;
    int i3 = this.j.a();
    int i4 = this.j.b();
    HashSet localHashSet = new HashSet();
    for (int i5 = i1 + 1; (i(i5, i2).equals(paramG)) && (i5 < i3); i5++)
      localHashSet.add(new G(this, i5, i2));
    for (int i6 = i2 + 1; (i(i1, i6).equals(paramG)) && (i6 < i4); i6++)
      localHashSet.add(new G(this, i1, i6));
    return (G[])localHashSet.toArray(new G[0]);
  }

  protected int b()
  {
    int i1 = this.t;
    if (this.j.j())
    {
      i1 += this.j.c();
      i1 += this.t;
    }
    for (int i2 = 0; i2 < this.j.h(); i2++)
    {
      i1 += i(i2);
      i1 += this.t;
    }
    return i1;
  }

  protected int a(int paramInt)
  {
    int i1 = this.t;
    if (this.j.j())
    {
      if (paramInt == -1)
        return i1;
      i1 += this.j.c();
      i1 += this.t;
    }
    else if (paramInt == -1)
    {
      return -2147483648;
    }
    int i2 = this.j.h();
    if (paramInt < i2)
    {
      for (i3 = 0; i3 < paramInt; i3++)
      {
        i1 += i(i3);
        i1 += this.t;
      }
      return i1;
    }
    i1 = b();
    if ((paramInt >= i2) && (paramInt < this.f))
    {
      for (i3 = this.f - 1; i3 >= paramInt; i3--)
      {
        i1 -= this.t;
        i1 -= i(i3);
      }
      return i1;
    }
    for (int i3 = this.f; i3 < paramInt; i3++)
    {
      i1 += i(i3);
      i1 += this.t;
    }
    return i1;
  }

  protected int b(int paramInt)
  {
    if (paramInt < -1)
      return -2147483648;
    int i1 = a(paramInt);
    if (paramInt == -1)
      return i1 + this.j.c() - 1;
    return i1 + i(paramInt) - 1;
  }

  protected int c(int paramInt)
  {
    if (paramInt < -1)
      return -2147483648;
    int i1 = p(paramInt);
    if (paramInt == -1)
      return i1 + this.j.e() - 1;
    return i1 + this.j.e(paramInt) - 1;
  }

  private int L()
  {
    int i1 = this.t;
    if (this.j.k())
    {
      i1 += this.j.e();
      i1 += this.t;
    }
    for (int i2 = 0; i2 < this.j.i(); i2++)
    {
      i1 += this.j.e(i2);
      i1 += this.t;
    }
    return i1;
  }

  public void c()
  {
    Rectangle localRectangle = getClientArea();
    if (localRectangle.isEmpty())
      return;
    if (this.j == null)
    {
      ScrollBar localScrollBar1 = getHorizontalBar();
      if (localScrollBar1 != null)
      {
        localScrollBar1.setMinimum(0);
        localScrollBar1.setMaximum(1);
        localScrollBar1.setPageIncrement(1);
        localScrollBar1.setThumb(1);
        localScrollBar1.setSelection(1);
      }
      localScrollBar1 = getVerticalBar();
      if (localScrollBar1 != null)
      {
        localScrollBar1.setMinimum(0);
        localScrollBar1.setMaximum(1);
        localScrollBar1.setPageIncrement(1);
        localScrollBar1.setThumb(1);
        localScrollBar1.setSelection(1);
      }
      return;
    }
    int i1 = this.j.i();
    int i2 = this.j.h();
    int i3 = this.j.a();
    int i4 = this.j.b();
    this.e = Math.max(this.e, i1);
    if (this.e >= i3)
      this.e = 0;
    this.f = Math.max(this.f, i2);
    if (this.f >= i4)
      this.f = 0;
    this.r = 0;
    this.s = 0;
    int i6;
    int i7;
    if (i4 > i2)
    {
      int i5 = localRectangle.x + localRectangle.width;
      i6 = a(this.f);
      for (i7 = this.f; i7 < i4; i7++)
      {
        if (i6 < i5)
          this.r += 1;
        i6 += i(i7);
        i6 += this.t;
        if (i6 > i5)
          break;
        this.s += 1;
      }
    }
    ScrollBar localScrollBar2 = getHorizontalBar();
    if (localScrollBar2 != null)
      if (i2 >= i4)
      {
        localScrollBar2.setMinimum(0);
        localScrollBar2.setMaximum(1);
        localScrollBar2.setPageIncrement(1);
        localScrollBar2.setThumb(1);
        localScrollBar2.setSelection(1);
      }
      else
      {
        localScrollBar2.setMinimum(i2);
        localScrollBar2.setMaximum(i4);
        localScrollBar2.setIncrement(1);
        localScrollBar2.setPageIncrement(this.r - i2);
        localScrollBar2.setThumb(this.s);
        localScrollBar2.setSelection(this.f);
      }
    this.p = 0;
    this.q = 0;
    if (i3 > i1)
    {
      i6 = localRectangle.y + localRectangle.height;
      i7 = p(this.e);
      for (int i8 = this.e; i8 < i3; i8++)
      {
        if (i7 < i6)
          this.p += 1;
        i7 += this.j.e(i8);
        i7 += this.t;
        if (i7 > i6)
          break;
        this.q += 1;
      }
    }
    localScrollBar2 = getVerticalBar();
    if (localScrollBar2 != null)
      if (i3 <= i1)
      {
        localScrollBar2.setMinimum(0);
        localScrollBar2.setMaximum(1);
        localScrollBar2.setPageIncrement(1);
        localScrollBar2.setThumb(1);
        localScrollBar2.setSelection(1);
      }
      else
      {
        localScrollBar2.setMinimum(i1);
        localScrollBar2.setMaximum(i3);
        localScrollBar2.setPageIncrement(this.p - i1);
        localScrollBar2.setIncrement(1);
        localScrollBar2.setThumb(this.q);
        localScrollBar2.setSelection(this.e);
      }
  }

  protected Rectangle a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2, a(paramInt2), p(paramInt1));
  }

  protected Rectangle a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 < 0) || (paramInt2 >= this.j.b()))
      return new Rectangle(-1, -1, 0, 0);
    int i1 = paramInt3;
    int i2 = paramInt4;
    int i3 = i(paramInt2);
    int i4 = this.j.e(paramInt1);
    return new Rectangle(i1, i2, i3, i4);
  }

  protected Rectangle d(int paramInt)
  {
    return b(paramInt, a(paramInt));
  }

  protected Rectangle b(int paramInt1, int paramInt2)
  {
    int i1 = paramInt2;
    int i2 = this.t;
    int i3 = i(paramInt1);
    int i4 = this.j.e();
    return new Rectangle(i1, i2, i3, i4);
  }

  protected Rectangle e(int paramInt)
  {
    return c(paramInt, p(paramInt));
  }

  protected Rectangle c(int paramInt1, int paramInt2)
  {
    int i1 = this.t;
    int i2 = paramInt2;
    int i3 = this.j.c();
    int i4 = this.j.e(paramInt1);
    return new Rectangle(i1, i2, i3, i4);
  }

  public Rectangle d(int paramInt1, int paramInt2)
  {
    checkWidget();
    G localG = i(paramInt1, paramInt2);
    if ((localG == G.b) || (localG.c != paramInt1) || (localG.d != paramInt2))
      return new Rectangle(0, 0, 0, 0);
    Rectangle localRectangle = a(paramInt1, paramInt2);
    int i1 = this.j.i();
    int i2 = this.j.a();
    int i3 = paramInt1 + 1;
    while ((i(i3, paramInt2).equals(localG)) && (i3 < i2))
      if ((paramInt1 < i1) && (i3 >= i1) && (i3 < this.e))
      {
        i3++;
      }
      else
      {
        localRectangle.height += this.j.e(i3);
        localRectangle.height += this.t;
        i3++;
      }
    int i4 = paramInt2 + 1;
    int i5 = this.j.h();
    int i6 = this.j.b();
    while ((i(paramInt1, i4).equals(localG)) && (i4 < i6))
      if ((paramInt2 < i5) && (i4 >= i5) && (i4 < this.f))
      {
        i4++;
      }
      else
      {
        localRectangle.width += i(i4);
        localRectangle.width += this.t;
        i4++;
      }
    return localRectangle;
  }

  private void a(PaintEvent paramPaintEvent)
  {
    c();
    GC localGC1 = paramPaintEvent.gc;
    if (this.j != null)
    {
      int i1 = this.j.i();
      int i2 = this.j.h();
      boolean bool1 = this.j.k();
      boolean bool2 = this.j.j();
      int i3 = i1 > 0 ? 1 : 0;
      int i4 = i2 > 0 ? 1 : 0;
      Rectangle localRectangle2 = null;
      int i5 = getStyle();
      Rectangle localRectangle3 = localGC1.getClipping();
      GC localGC2;
      if (bool1)
      {
        localRectangle4 = F();
        localRectangle2 = localRectangle4.intersection(localRectangle3);
        if (!localRectangle2.isEmpty())
        {
          localGC1.setClipping(localRectangle2);
          if (i4 != 0)
            a(localGC1, localRectangle2, 0, i2 - 1);
          a(localGC1, localRectangle2, this.f, this.f + this.r - 1);
          localGC1.setClipping(localRectangle3);
        }
        else if (((i5 & 0x40000000) == 1073741824) || ((i5 & 0x20000000) == 536870912))
        {
          localGC2 = new GC(this);
          localGC2.setClipping(localRectangle4);
          if (i4 != 0)
            a(localGC2, localGC2.getClipping(), 0, i2 - 1);
          a(localGC2, localGC2.getClipping(), this.f, this.f + this.r - 1);
          localGC2.dispose();
        }
      }
      if (bool2)
      {
        localRectangle4 = G();
        localRectangle2 = localRectangle4.intersection(localRectangle3);
        if (!localRectangle2.isEmpty())
        {
          localGC1.setClipping(localRectangle2);
          if (i3 != 0)
            b(localGC1, localRectangle2, 0, i1 - 1);
          b(localGC1, localRectangle2, this.e, this.e + this.p - 1);
          localGC1.setClipping(localRectangle3);
        }
        else if (((i5 & 0x40000000) == 1073741824) || ((i5 & 0x20000000) == 536870912))
        {
          localGC2 = new GC(this);
          localGC2.setClipping(localRectangle4);
          if (i3 != 0)
            b(localGC2, localGC2.getClipping(), 0, i1 - 1);
          b(localGC2, localGC2.getClipping(), this.e, this.e + this.p - 1);
          localGC2.dispose();
        }
      }
      if ((bool1) && (bool2))
        a(localGC1);
      if (i3 != 0)
      {
        localRectangle4 = H();
        localRectangle2 = localRectangle4.intersection(localRectangle3);
        if (!localRectangle2.isEmpty())
        {
          localGC1.setClipping(localRectangle2);
          a(localGC1, localRectangle2, 0, i1 - 1, this.f, this.f + this.r - 1);
          localGC1.setClipping(localRectangle3);
        }
      }
      if (i4 != 0)
      {
        localRectangle4 = I();
        localRectangle2 = localRectangle4.intersection(localRectangle3);
        if (!localRectangle2.isEmpty())
        {
          localGC1.setClipping(localRectangle2);
          a(localGC1, localRectangle2, this.e, this.e + this.p - 1, 0, i2 - 1);
          localGC1.setClipping(localRectangle3);
        }
      }
      if ((i3 != 0) && (i4 != 0))
        a(localGC1, localRectangle3, 0, i1 - 1, 0, i2 - 1);
      Rectangle localRectangle4 = E();
      localRectangle2 = localRectangle4.intersection(localRectangle3);
      if (!localRectangle2.isEmpty())
      {
        localGC1.setClipping(localRectangle2);
        a(localGC1, localRectangle2, this.e, this.e + this.p - 1, this.f, this.f + this.r - 1);
        localGC1.setClipping(localRectangle3);
      }
      int i6 = this.j.a();
      int i7 = this.j.b();
      if (((!bool1) && (i6 == 0)) || ((!bool2) && (i7 == 0)))
      {
        Rectangle localRectangle5 = getClientArea();
        localGC1.fillRectangle(localRectangle5);
      }
      else
      {
        b(localGC1);
        c(localGC1);
        d(localGC1);
      }
    }
    else
    {
      Rectangle localRectangle1 = getClientArea();
      localGC1.fillRectangle(localRectangle1);
    }
  }

  protected void a(GC paramGC)
  {
    int i1 = this.j.c();
    int i2 = this.j.e();
    Rectangle localRectangle = new Rectangle(this.t, this.t, i1, i2);
    an localan = this.i.b(0);
    localan.a(paramGC, localRectangle, -1, -1);
    int i3 = this.t + i1 - 1;
    int i4 = this.t + i2 - 1;
    paramGC.setBackground(getDisplay().getSystemColor(16));
    paramGC.fillPolygon(new int[] { i3, i4, i3, i4 - 8, i3 - 8, i4, i3, i4 });
  }

  private void b(GC paramGC)
  {
    int i1 = this.j.b() - 1;
    if (this.f + this.s - 1 == i1)
    {
      Rectangle localRectangle1 = getClientArea();
      int i2 = b(this.f + this.s - 1) + 1 + this.t;
      if (i2 >= localRectangle1.x + localRectangle1.width - 1 - this.t)
        return;
      int i3 = this.t;
      int i4 = localRectangle1.x + localRectangle1.width - this.t - i2 + 1;
      int i5 = this.j.e();
      if ((getStyle() & 0x40000) != 0)
      {
        Rectangle localRectangle2 = null;
        if (this.j.k())
        {
          localRectangle2 = new Rectangle(i2, i3, i4 - 1, i5);
          an localan1 = this.i.b(i1);
          localan1.a(paramGC, localRectangle2, -1, i1 + 1);
          i3 += this.j.e();
          i3 += this.t;
        }
        an localan2;
        for (int i6 = 0; i6 < this.j.i(); i6++)
        {
          i5 = this.j.e(i6);
          localan2 = this.i.a(i6, i1);
          localRectangle2 = new Rectangle(i2, i3, i4 - 1, i5);
          localan2.a(paramGC, localRectangle2, i6, i1 + 1);
          i3 += i5;
          i3 += this.t;
        }
        for (i6 = this.e; i6 <= this.e + this.p; i6++)
        {
          i5 = this.j.e(i6);
          localan2 = this.i.a(i6, i1);
          localRectangle2 = new Rectangle(i2, i3, i4 - 1, i5);
          localan2.a(paramGC, localRectangle2, i6, i1 + 1);
          i3 += i5;
          i3 += this.t;
        }
      }
      else
      {
        i3 = 0;
        i5 = localRectangle1.height;
        paramGC.setBackground(getBackground());
        paramGC.fillRectangle(i2, i3, i4, i5);
      }
    }
  }

  private void c(GC paramGC)
  {
    int i1 = this.j.a() - 1;
    if (this.e + this.q - 1 == i1)
    {
      Rectangle localRectangle = getClientArea();
      int i2 = c(i1) + 1 + this.t;
      if (i2 >= localRectangle.height - 1)
        return;
      int i3 = 0;
      int i4 = localRectangle.width;
      int i5 = localRectangle.height - i2;
      paramGC.setBackground(getBackground());
      paramGC.fillRectangle(i3, i2, i4, i5);
    }
  }

  private void d(GC paramGC)
  {
    if (this.j.a() > 0)
    {
      Display localDisplay = getDisplay();
      if ((getStyle() & 0x800000) == 0)
        paramGC.setForeground(localDisplay.getSystemColor(17));
      else
        paramGC.setForeground(localDisplay.getSystemColor(25));
    }
    int i1 = 0;
    int i2 = 0;
    Rectangle localRectangle = getClientArea();
    int i3 = this.j.a() - 1;
    int i4 = this.j.b() - 1;
    int i5;
    if (this.e + this.q - 1 == i3)
    {
      i5 = c(i3) + 1;
      if (i5 <= localRectangle.height - 1)
      {
        localRectangle.height = (i5 + 1);
        i2 = 1;
      }
    }
    if (this.f + this.s - 1 == i4)
    {
      i5 = b(i4) + 1;
      int i6 = getStyle();
      if (i5 <= localRectangle.width - 1)
      {
        if ((i6 & 0x40000) == 0)
          localRectangle.width = (i5 + 1);
        i1 = 1;
      }
    }
    paramGC.drawLine(localRectangle.x, localRectangle.y, localRectangle.x + localRectangle.width - 1, localRectangle.y);
    paramGC.drawLine(localRectangle.x, localRectangle.y, localRectangle.x, localRectangle.y + localRectangle.height - 1);
    if (i2 != 0)
      paramGC.drawLine(localRectangle.x, localRectangle.y + localRectangle.height - 1, localRectangle.x + localRectangle.width - 1, localRectangle.y + localRectangle.height - 1);
    if (i1 != 0)
      paramGC.drawLine(localRectangle.x + localRectangle.width - 1, localRectangle.y, localRectangle.x + localRectangle.width - 1, localRectangle.y + localRectangle.height - 1);
  }

  protected void a(GC paramGC, Rectangle paramRectangle, int paramInt1, int paramInt2)
  {
    int i1 = a(paramInt1);
    int i2 = paramRectangle.x + paramRectangle.width;
    for (int i3 = paramInt1; i3 <= paramInt2; i3++)
    {
      if (i1 >= i2)
        break;
      Rectangle localRectangle1 = b(i3, i1);
      i1 += localRectangle1.width;
      i1 += this.t;
      Rectangle localRectangle2 = localRectangle1.intersection(paramRectangle);
      if (localRectangle2.isEmpty())
        continue;
      an localan = this.i.b(i3);
      localan.a(paramGC, localRectangle1, -1, i3);
    }
  }

  protected void b(GC paramGC, Rectangle paramRectangle, int paramInt1, int paramInt2)
  {
    int i1 = p(paramInt1);
    int i2 = paramRectangle.y + paramRectangle.height;
    for (int i3 = paramInt1; i3 <= paramInt2; i3++)
    {
      if (i1 >= i2)
        break;
      Rectangle localRectangle1 = c(i3, i1);
      i1 += localRectangle1.height;
      i1 += this.t;
      Rectangle localRectangle2 = localRectangle1.intersection(paramRectangle);
      if (localRectangle2.isEmpty())
        continue;
      an localan = this.i.a(i3);
      localan.a(paramGC, localRectangle1, i3, -1);
    }
  }

  G e(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < this.t) || (paramInt2 > this.t + this.j.e() - 1))
      return G.b;
    int i1 = this.t;
    if (this.j.j())
    {
      i1 += this.j.c();
      i1 += this.t;
    }
    if (paramInt1 <= i1)
      return G.b;
    for (int i2 = 0; i2 < this.j.h(); i2++)
    {
      i1 += i(i2);
      if (paramInt1 <= i1)
        return new G(this, -1, i2);
      i1 += this.t;
    }
    for (i2 = this.f; i2 < this.j.b(); i2++)
    {
      i1 += i(i2);
      if (paramInt1 <= i1)
        return new G(this, -1, i2);
      i1 += this.t;
    }
    return G.b;
  }

  G f(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < this.t) || (paramInt1 > this.t + this.j.c() - 1))
      return G.b;
    int i1 = this.t;
    if (this.j.k())
    {
      i1 += this.j.e();
      i1 += this.t;
    }
    if (paramInt2 <= i1)
      return G.b;
    for (int i2 = 0; i2 < this.j.i(); i2++)
    {
      i1 += this.j.e(i2);
      if (paramInt2 <= i1)
        return new G(this, i2, -1);
      i1 += this.t;
    }
    for (i2 = this.f; i2 < this.j.b(); i2++)
    {
      i1 += this.j.e(i2);
      if (paramInt2 <= i1)
        return new G(this, i2, -1);
      i1 += this.t;
    }
    return G.b;
  }

  public G g(int paramInt1, int paramInt2)
  {
    checkWidget();
    int i1 = this.j.c();
    int i2 = this.j.e();
    if ((paramInt1 >= this.t) && (paramInt1 <= this.t + i1) && (paramInt2 >= this.t) && (paramInt2 <= this.t + i2))
      return new G(this, -1, -1);
    if ((paramInt1 >= this.t) && (paramInt1 <= this.t + i1))
      return f(paramInt1, paramInt2);
    if ((paramInt2 >= this.t) && (paramInt2 <= this.t + i2))
      return e(paramInt1, paramInt2);
    return G.b;
  }

  public Rectangle h(int paramInt1, int paramInt2)
  {
    checkWidget();
    int i1 = this.j.c();
    int i2 = this.j.e();
    if ((paramInt1 == -1) && (paramInt2 == -1))
      return new Rectangle(this.t, this.t, i1, i2);
    if ((paramInt2 == -1) && (paramInt1 >= 0) && (paramInt1 <= this.j.a() - 1))
      return e(paramInt1);
    if ((paramInt1 == -1) && (paramInt2 >= 0) && (paramInt2 <= this.j.b() - 1))
      return d(paramInt2);
    return new Rectangle(0, 0, -1, -1);
  }

  private void a(GC paramGC, Rectangle paramRectangle, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.g.e();
    int i1 = paramRectangle.x + paramRectangle.width;
    int i2 = paramRectangle.y + paramRectangle.height;
    int i3 = p(paramInt1);
    for (int i4 = paramInt1; i4 <= paramInt2; i4++)
    {
      int i5 = a(paramInt3);
      for (int i6 = paramInt3; i6 <= paramInt4; i6++)
      {
        Rectangle localRectangle = b(i4, i6, i5, i3);
        i5 += i(i6);
        i5 += this.t;
        if (localRectangle.x >= i1)
          break;
        if (localRectangle.y >= i2)
          return;
        if (localRectangle.isEmpty())
        {
          G localG = i(i4, i6);
          if (((localG.c >= this.e) || (i4 < this.e)) && ((localG.d >= this.f) || (i6 < this.f)))
            continue;
          localRectangle = d(localG.c, localG.d);
          if (localRectangle.intersection(paramRectangle).isEmpty())
            continue;
          a(paramGC, localG.c, localG.d, localRectangle);
        }
        else
        {
          if (localRectangle.intersection(paramRectangle).isEmpty())
            continue;
          a(paramGC, i4, i6, localRectangle);
        }
      }
      i3 += this.j.e(i4);
      i3 += this.t;
    }
  }

  public G i(int paramInt1, int paramInt2)
  {
    checkWidget();
    if ((paramInt1 < -1) || (paramInt1 >= this.j.a()) || (paramInt2 < -1) || (paramInt2 >= this.j.b()))
      return G.b;
    G localG1 = new G(this, paramInt1, paramInt2);
    G localG2 = G.b;
    while (!localG1.equals(localG2))
    {
      localG2 = localG1;
      localG1 = this.j.a(localG1.c, localG1.d);
      if ((localG1 != null) && (localG1 != G.b) && ((localG1.d > localG2.d) || (localG1.c > localG2.c)))
        throw new IllegalArgumentException("When spanning over several cells, supercells that determine the content of the large cell must always be in the left upper corner!");
      if ((localG1 == null) || (localG1 == G.b))
        return localG2;
    }
    return localG1;
  }

  protected void a(GC paramGC, int paramInt1, int paramInt2, Rectangle paramRectangle)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.j.a()) || (paramInt2 < 0) || (paramInt2 >= this.j.b()) || (paramRectangle.isEmpty()))
      return;
    an localan = this.i.a(paramInt1, paramInt2);
    localan.a(paramGC, paramRectangle, paramInt1, paramInt2);
  }

  public boolean j(int paramInt1, int paramInt2)
  {
    checkWidget();
    int i1 = getStyle();
    if (((i1 & 0x40000000) != 1073741824) && ((i1 & 0x20000000) != 536870912))
      return false;
    Object localObject1;
    Object localObject2;
    if ((i1 & 0x40000000) == 1073741824)
    {
      localObject1 = y();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        localObject2 = w();
        int i2;
        if ((i1 & 0x8000000) != 0)
        {
          if ((paramInt1 == -1) && (paramInt2 >= 0) && (paramInt2 < ((au)localObject2).b()))
            return true;
          for (i2 = 0; i2 < localObject1.length; i2++)
            if (paramInt1 == localObject1[i2].c)
              return true;
        }
        else if ((i1 & 0x10000000) != 0)
        {
          if ((paramInt2 == -1) && (paramInt1 >= 0) && (paramInt1 < ((au)localObject2).a()))
            return true;
          for (i2 = 0; i2 < localObject1.length; i2++)
            if (paramInt2 == localObject1[i2].d)
              return true;
        }
        else
        {
          for (i2 = 0; i2 < localObject1.length; i2++)
          {
            if ((paramInt1 == localObject1[i2].c) || (paramInt2 == localObject1[i2].d))
              return true;
            G localG = i(localObject1[i2].c, paramInt2);
            if (localG.d == localObject1[i2].d)
              return true;
            localG = i(paramInt1, localObject1[i2].d);
            if (localG.c == localObject1[i2].c)
              return true;
          }
        }
      }
    }
    else
    {
      localObject1 = A();
      if (localObject1 == G.b)
        return false;
      if ((paramInt1 == ((G)localObject1).c) || (paramInt2 == ((G)localObject1).d))
        return true;
      localObject2 = i(((G)localObject1).c, paramInt2);
      if (((G)localObject2).d == ((G)localObject1).d)
        return true;
      localObject2 = i(paramInt1, ((G)localObject1).d);
      if (((G)localObject2).c == ((G)localObject1).c)
        return true;
    }
    return false;
  }

  public boolean k(int paramInt1, int paramInt2)
  {
    checkWidget();
    Rectangle localRectangle = null;
    if ((paramInt1 >= 0) && (paramInt2 >= 0))
      localRectangle = d(paramInt1, paramInt2);
    else if ((paramInt1 == -1) || (paramInt2 == -1))
      localRectangle = h(paramInt1, paramInt2);
    int i1 = (this.n != null) && (localRectangle.contains(this.n)) && (this.m) && (paramInt1 == this.l.c) && (paramInt2 == this.l.d) ? 1 : 0;
    return i1;
  }

  public boolean l(int paramInt1, int paramInt2)
  {
    checkWidget();
    return this.h.a(paramInt1, paramInt2);
  }

  public boolean d()
  {
    checkWidget();
    return this.g.c();
  }

  protected boolean m(int paramInt1, int paramInt2)
  {
    if (this.g.a(paramInt1, paramInt2))
      return false;
    return (this.h.b(paramInt1, paramInt2)) && ((isFocusControl()) || (i()));
  }

  public boolean n(int paramInt1, int paramInt2)
  {
    checkWidget();
    return this.h.b(paramInt1, paramInt2);
  }

  public void a(Cursor paramCursor, Point paramPoint)
  {
    checkWidget();
    if (this.D != null)
      this.D.dispose();
    this.D = paramCursor;
    this.C = paramPoint;
    setCursor(paramCursor);
  }

  public Cursor e()
  {
    checkWidget();
    if (this.G == null)
      return this.E;
    return this.G;
  }

  public void a(Cursor paramCursor)
  {
    checkWidget();
    if (this.G != null)
      this.G.dispose();
    this.G = paramCursor;
  }

  public Cursor f()
  {
    checkWidget();
    if (this.H == null)
      return this.F;
    return this.H;
  }

  public void b(Cursor paramCursor)
  {
    checkWidget();
    if (this.H != null)
      this.H.dispose();
    this.H = paramCursor;
  }

  public void c(Cursor paramCursor)
  {
    checkWidget();
    if (this.E != null)
      this.E.dispose();
    this.E = paramCursor;
  }

  public void d(Cursor paramCursor)
  {
    checkWidget();
    if (this.F != null)
      this.F.dispose();
    this.F = paramCursor;
  }

  private int w(int paramInt1, int paramInt2)
  {
    if ((!this.j.k()) || (paramInt2 <= this.t) || (paramInt2 >= this.j.e() + this.t))
      return -2147483648;
    int i1 = 0;
    int i2 = 0;
    int i3 = this.y / 2;
    if (paramInt1 <= this.t + this.j.c() + i3)
    {
      i1 = a(-1);
      i2 = i1 + this.j.c() - 1;
      if ((paramInt1 > i2 - i3) && (paramInt1 < i2 + 1 + this.t + i3) && (this.j.u(-1)))
        return -1;
    }
    else
    {
      if (paramInt1 <= this.t + b() + i3)
      {
        i4 = this.j.h();
        i1 = a(0);
        for (i5 = 0; i5 < i4; i5++)
        {
          i2 = i1 + i(i5) - 1;
          if ((paramInt1 > i2 - i3) && (paramInt1 < i2 + 1 + this.t + i3) && (this.j.u(i5)))
            return i5;
          if ((paramInt1 >= i1) && (paramInt1 <= i2))
            break;
          i1 = i2 + 1 + this.t;
        }
        return -2147483648;
      }
      int i4 = this.j.b();
      i1 = a(this.f);
      for (int i5 = this.f; (i5 <= this.f + this.r - 1) && (i5 < i4); i5++)
      {
        i2 = i1 + i(i5) - 1;
        if ((paramInt1 > i2 - i3) && (paramInt1 < i2 + 1 + this.t + i3) && (this.j.u(i5)))
          return i5;
        if ((paramInt1 >= i1) && (paramInt1 <= i2))
          break;
        i1 = i2 + 1 + this.t;
      }
    }
    return -2147483648;
  }

  private int x(int paramInt1, int paramInt2)
  {
    if ((!this.j.j()) || (paramInt1 <= this.t) || (paramInt1 >= this.j.c() + this.t))
      return -2147483648;
    int i1 = 0;
    int i2 = 0;
    int i3 = this.y / 2;
    if (paramInt2 <= this.t + this.j.e() + i3)
    {
      i1 = p(-1);
      i2 = i1 + this.j.e() - 1;
      if ((paramInt2 > i2 - i3) && (paramInt2 < i2 + 1 + this.t + i3) && (this.j.v(-1)))
        return -1;
    }
    else
    {
      if (paramInt2 <= this.t + L() + i3)
      {
        i4 = this.j.i();
        i1 = p(0);
        for (i5 = 0; i5 < i4; i5++)
        {
          i2 = i1 + this.j.e(i5) - 1;
          if ((paramInt2 > i2 - i3) && (paramInt2 < i2 + 1 + this.t + i3) && (this.j.v(i5)))
            return i5;
          if ((paramInt2 >= i1) && (paramInt2 <= i2))
            break;
          i1 = i2 + 1 + this.t;
        }
        return -2147483648;
      }
      int i4 = this.j.a();
      i1 = p(this.e);
      for (int i5 = this.e; (i5 <= this.e + this.p - 1) && (i5 < i4); i5++)
      {
        i2 = i1 + this.j.e(i5) - 1;
        if ((paramInt2 > i2 - i3) && (paramInt2 < i2 + 1 + this.t + i3) && (this.j.v(i5)))
          return i5;
        if ((paramInt2 >= i1) && (paramInt2 <= i2))
          break;
        i1 = i2 + 1 + this.t;
      }
    }
    return -2147483648;
  }

  private int n(int paramInt)
  {
    if (paramInt < 0)
      return -2147483648;
    int i1 = this.t;
    if (this.j.k())
    {
      i1 += this.j.e();
      i1 += this.t;
      if (paramInt <= i1)
        return -1;
    }
    int i2 = this.j.i();
    for (int i3 = 0; i3 < i2; i3++)
    {
      i1 += this.j.e(i3);
      i1 += this.t;
      if (paramInt <= i1)
        return i3;
    }
    for (i3 = this.e; i3 <= this.e + this.p - 1; i3++)
    {
      i1 += this.j.e(i3);
      i1 += this.t;
      if (paramInt <= i1)
        return i3;
    }
    return -2147483648;
  }

  private int o(int paramInt)
  {
    if (paramInt < 0)
      return -2147483648;
    int i1 = this.t;
    if (this.j.j())
    {
      i1 += this.j.c();
      i1 += this.t;
      if (paramInt <= i1)
        return -1;
    }
    int i2 = this.j.h();
    for (int i3 = 0; i3 < i2; i3++)
    {
      i1 += i(i3);
      i1 += this.t;
      if (paramInt <= i1)
        return i3;
    }
    for (i3 = this.f; i3 <= this.f + this.r - 1; i3++)
    {
      i1 += i(i3);
      i1 += this.t;
      if (paramInt <= i1)
        return i3;
    }
    return -2147483648;
  }

  public G o(int paramInt1, int paramInt2)
  {
    checkWidget();
    if (this.j == null)
      return G.b;
    int i1 = n(paramInt2);
    int i2 = o(paramInt1);
    if ((i1 != -2147483648) && (i2 != -2147483648))
      return new G(this, i1, i2);
    return G.b;
  }

  public boolean p(int paramInt1, int paramInt2)
  {
    checkWidget();
    if (this.j == null)
      return false;
    return (paramInt1 >= -1) && (paramInt1 < this.e + this.p) && ((paramInt1 < this.j.i()) || (paramInt1 >= this.e)) && (paramInt2 >= -1) && (paramInt2 < this.f + this.r) && ((paramInt2 < this.j.h()) || (paramInt2 >= this.f));
  }

  public boolean q(int paramInt1, int paramInt2)
  {
    checkWidget();
    if (this.j == null)
      return false;
    return ((paramInt2 >= this.f) && (paramInt2 < this.f + this.s) && (paramInt1 >= this.e) && (paramInt1 < this.e + this.q)) || ((paramInt2 < this.j.h()) && (paramInt1 < this.j.i()));
  }

  public boolean f(int paramInt)
  {
    checkWidget();
    if (this.j == null)
      return false;
    return ((paramInt >= this.e) && (paramInt < this.e + this.p)) || (paramInt < this.j.i());
  }

  public boolean g(int paramInt)
  {
    checkWidget();
    if (this.j == null)
      return false;
    return ((paramInt >= this.e) && (paramInt < this.e + this.q)) || (paramInt < this.j.i());
  }

  protected void a(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 1)
    {
      setCapture(true);
      this.m = true;
      int i1 = w(paramMouseEvent.x, paramMouseEvent.y);
      if (i1 >= -1)
      {
        this.w = i1;
        this.x = a(i1);
        return;
      }
      int i2 = x(paramMouseEvent.x, paramMouseEvent.y);
      if (i2 >= -1)
      {
        this.u = i2;
        this.v = p(i2);
        return;
      }
    }
    if (paramMouseEvent.button == 1)
    {
      this.n = new Point(paramMouseEvent.x, paramMouseEvent.y);
      G localG = o(paramMouseEvent.x, paramMouseEvent.y);
      if (localG == G.b)
      {
        localG = g(paramMouseEvent.x, paramMouseEvent.y);
        if (localG == G.b)
          return;
      }
      this.l = localG;
      if ((this.l.c == -1) || (this.l.d == -1))
      {
        Rectangle localRectangle = h(localG.c, localG.d);
        localRectangle.width += this.t;
        localRectangle.height += this.t;
        redraw(localRectangle.x, localRectangle.y, localRectangle.width, localRectangle.height, true);
      }
    }
  }

  protected void b(MouseEvent paramMouseEvent)
  {
    if (this.j == null)
      return;
    if (paramMouseEvent.button == 1)
    {
      G localG = o(paramMouseEvent.x, paramMouseEvent.y);
      if (localG == G.b)
        return;
      if (paramMouseEvent.y < this.t + this.j.e())
      {
        int i1 = w(paramMouseEvent.x, paramMouseEvent.y);
        if (i1 != -2147483648)
        {
          h(i1);
          this.w = -2147483648;
        }
      }
      I localI = new I(localG, paramMouseEvent);
      a(localI);
    }
  }

  protected void c(MouseEvent paramMouseEvent)
  {
    if (this.j == null)
      return;
    if ((this.w != -2147483648) || (w(paramMouseEvent.x, paramMouseEvent.y) >= -1))
      setCursor(f());
    else if ((this.u != -2147483648) || (x(paramMouseEvent.x, paramMouseEvent.y) >= -1))
      setCursor(e());
    else
      setCursor(this.D);
    Object localObject;
    if ((this.l.c == -1) || (this.l.d == -1))
    {
      this.n = new Point(paramMouseEvent.x, paramMouseEvent.y);
      localObject = h(this.l.c, this.l.d);
      localObject.width += this.t;
      localObject.height += this.t;
      redraw(((Rectangle)localObject).x, ((Rectangle)localObject).y, ((Rectangle)localObject).width, ((Rectangle)localObject).height, true);
    }
    if ((paramMouseEvent.stateMask == 524288) && (h()) && (!this.g.c()) && (this.l.c >= 0) && (this.l.d >= 0))
    {
      localObject = o(paramMouseEvent.x, paramMouseEvent.y);
      if ((((G)localObject).c >= 0) && (((G)localObject).d >= 0))
        this.h.a((G)localObject, paramMouseEvent.stateMask | 0x20000);
    }
    int i3;
    int i4;
    if (this.w != -2147483648)
      if (this.w == -1)
      {
        localObject = getClientArea();
        i3 = this.j.c();
        i4 = paramMouseEvent.x > ((Rectangle)localObject).width - 5 ? ((Rectangle)localObject).width - this.x - 5 : paramMouseEvent.x - this.x;
        if (i4 < 5)
          i4 = 5;
        this.j.m(i4);
        i4 = this.j.c();
        if (i3 != i4)
          s(this.w, i4);
      }
      else if (this.w >= 0)
      {
        int i1 = i(this.w);
        i3 = paramMouseEvent.x - this.x;
        if (i3 < 5)
          i3 = 5;
        this.j.b(this.w, i3);
        i4 = i(this.w);
        if (i1 != i4)
          s(this.w, i4);
      }
    if (this.u != -2147483648)
      if (this.u == -1)
      {
        Rectangle localRectangle = getClientArea();
        i3 = this.j.e();
        i4 = paramMouseEvent.y > localRectangle.height - 5 ? localRectangle.height - 5 - this.v : paramMouseEvent.y - this.v;
        if (i4 < 5)
          i4 = 5;
        this.j.s(i4);
        i4 = this.j.e();
        if (i3 != i4)
          t(this.u, i4);
      }
      else if (this.u >= 0)
      {
        int i2 = this.j.e(this.u);
        i3 = paramMouseEvent.y - this.v;
        if (i3 < this.j.d())
          i3 = this.j.d();
        this.j.d(this.u, i3);
        i4 = this.j.e(this.u);
        if (i2 != i4)
          t(this.u, i3);
      }
  }

  protected void d(MouseEvent paramMouseEvent)
  {
    if (this.j == null)
      return;
    setCapture(false);
    this.m = false;
    if (this.l != G.b)
    {
      int i1 = this.l.c;
      int i2 = this.l.d;
      this.l = G.b;
      this.n = null;
      Object localObject;
      if ((i1 == -1) || (i2 == -1))
      {
        localObject = h(i1, i2);
        localObject.width += this.t;
        localObject.height += this.t;
        redraw(((Rectangle)localObject).x, ((Rectangle)localObject).y, ((Rectangle)localObject).width, ((Rectangle)localObject).height, true);
      }
      else
      {
        localObject = i(i1, i2);
        a(new G[] { localObject });
      }
    }
    this.w = -2147483648;
    this.u = -2147483648;
  }

  public void setToolTipText(String paramString)
  {
    checkWidget();
    this.I = paramString;
  }

  public String getToolTipText()
  {
    checkWidget();
    return this.I;
  }

  public int h(int paramInt)
  {
    checkWidget();
    int i1 = 5;
    int i2 = 0;
    GC localGC;
    int i3;
    if ((paramInt >= 0) && (paramInt < this.j.b()))
    {
      localGC = new GC(this);
      if (this.j.k())
      {
        i2 = this.i.b(paramInt).a(localGC, -1, paramInt);
        if (i2 > i1)
          i1 = i2;
      }
      for (i3 = 0; i3 < this.j.i(); i3++)
      {
        i2 = this.i.a(i3, paramInt).a(localGC, i3, paramInt);
        if (i2 <= i1)
          continue;
        i1 = i2;
      }
      for (i3 = this.e; i3 < this.e + this.p; i3++)
      {
        i2 = this.i.a(i3, paramInt).a(localGC, i3, paramInt);
        if (i2 <= i1)
          continue;
        i1 = i2;
      }
      localGC.dispose();
      this.j.b(paramInt, i1);
      return i1;
    }
    if (paramInt == -1)
    {
      localGC = new GC(this);
      for (i3 = 0; i3 < this.j.i(); i3++)
      {
        i2 = this.i.a(i3).a(localGC, i3, paramInt);
        if (i2 <= i1)
          continue;
        i1 = i2;
      }
      for (i3 = this.e; i3 < this.e + this.p; i3++)
      {
        i2 = this.i.a(i3).a(localGC, i3, paramInt);
        if (i2 <= i1)
          continue;
        i1 = i2;
      }
      localGC.dispose();
      this.j.m(i1);
      return i1;
    }
    return -2147483648;
  }

  public void r(int paramInt1, int paramInt2)
  {
    checkWidget();
    if ((paramInt2 < 0) || (paramInt2 >= this.j.b()) || (paramInt1 < 0) || (paramInt1 >= this.j.a()))
      return;
    int i1 = this.e;
    int i2 = this.f;
    this.e = paramInt1;
    this.f = paramInt2;
    if ((i1 != this.e) || (i2 != this.f))
      redraw();
  }

  public void a(boolean paramBoolean)
  {
    int i1 = 0;
    if (paramBoolean)
      c();
    G localG = this.h.b();
    if ((localG == null) || (localG == G.b))
      return;
    if (getVerticalBar() != null)
    {
      if ((localG.c < this.e) && (localG.c >= this.j.i()))
      {
        this.e = localG.c;
        i1 = 1;
      }
      if ((this.q > 0) && (localG.c >= this.e + this.q))
      {
        this.e = (localG.c - this.q + 1);
        i1 = 1;
      }
    }
    if (getHorizontalBar() != null)
    {
      if ((localG.d < this.f) && (localG.d >= this.j.h()))
      {
        this.f = localG.d;
        i1 = 1;
      }
      if ((this.s > 0) && (localG.d >= this.f + this.s))
      {
        this.f = (localG.d - this.s + 1);
        i1 = 1;
      }
    }
    if (i1 != 0)
      redraw();
  }

  public void g()
  {
    a(false);
  }

  protected void a(I paramI)
  {
    for (int i1 = 0; i1 < this.z.size(); i1++)
      ((ai)this.z.get(i1)).a(paramI);
  }

  protected void s(int paramInt1, int paramInt2)
  {
    for (int i1 = 0; i1 < this.A.size(); i1++)
      ((ap)this.A.get(i1)).b(paramInt1, paramInt2);
  }

  protected void t(int paramInt1, int paramInt2)
  {
    for (int i1 = 0; i1 < this.A.size(); i1++)
      ((ap)this.A.get(i1)).a(paramInt1, paramInt2);
  }

  public void a(ap paramap)
  {
    checkWidget();
    this.A.add(paramap);
  }

  public void a(ai paramai)
  {
    checkWidget();
    this.z.add(paramai);
  }

  public boolean b(ap paramap)
  {
    checkWidget();
    return this.A.remove(paramap);
  }

  public boolean b(ai paramai)
  {
    checkWidget();
    return this.z.remove(paramai);
  }

  public boolean h()
  {
    checkWidget();
    return (getStyle() & 0x2) == 2;
  }

  protected boolean i()
  {
    return (getStyle() & 0x8000) != 32768;
  }

  public void a(ar paramar)
  {
    checkWidget();
    if (this.k != null)
      this.k.b(this.B);
    this.k = paramar;
    this.k.a(this.B);
    G localG = this.h.b();
    localG.d = -2147483648;
    localG.c = -2147483648;
    this.h.c();
    if ((getStyle() & 0x700) == 1792)
      k();
    redraw();
  }

  public ar j()
  {
    return this.k;
  }

  protected void k()
  {
    try
    {
      Rectangle localRectangle = getClientArea();
      boolean bool = false;
      int i1 = 1;
      for (int i2 = 0; i2 < this.j.a(); i2++)
      {
        i1 += this.j.e(i2);
        if (i1 <= localRectangle.height)
          continue;
        bool = true;
        break;
      }
      getVerticalBar().setVisible(bool);
      i2 = 0;
      for (int i3 = 0; i3 < this.j.b(); i3++)
        i2 += i(i3);
      getHorizontalBar().setVisible(localRectangle.width < i2);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public int i(int paramInt)
  {
    checkWidget();
    if ((paramInt == this.j.b() - 1) && ((getStyle() & 0x20000) != 0))
    {
      Rectangle localRectangle = getClientArea();
      int i1 = localRectangle.x + localRectangle.width - this.t - a(paramInt);
      return Math.max(i1, this.j.f(paramInt));
    }
    return this.j.f(paramInt);
  }

  public int getStyle()
  {
    checkWidget();
    return this.o;
  }

  public void j(int paramInt)
  {
    checkWidget();
    this.o = paramInt;
  }

  public void u(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, null);
  }

  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    G localG1 = new G(this, paramInt1, paramInt2);
    G localG2 = A();
    if ((localG2.equals(localG1)) && (d()))
      return;
    this.h.a(localG1, 0);
    a(true);
    ad localad = new ad(localG1, null);
    a(localad, paramObject);
  }

  public void l()
  {
    this.g.b();
  }

  public void m()
  {
    this.g.a();
  }

  public void a(ad paramad, Object paramObject)
  {
    this.g.a(paramad, paramObject);
  }

  public A n()
  {
    checkWidget();
    return this.g;
  }

  public void a(A paramA)
  {
    checkWidget();
    this.g = paramA;
  }

  protected A o()
  {
    A localA = new A(this, 16);
    return localA;
  }

  public int p()
  {
    checkWidget();
    if (this.g != null)
      return this.g.h();
    return 0;
  }

  public void k(int paramInt)
  {
    checkWidget();
    if (this.g != null)
      this.g.a(paramInt);
  }

  public void a(ak paramak)
  {
    checkWidget();
    if (this.g != null)
      this.g.a(paramak);
  }

  public ak q()
  {
    checkWidget();
    if (this.g != null)
      return this.g.f();
    return null;
  }

  public G a(G paramG, int paramInt, boolean paramBoolean)
  {
    checkWidget();
    G localG1 = null;
    G localG2 = this.j.a(paramG.c, paramG.d);
    if (localG2 != null)
      paramG = localG2;
    if (((paramInt & 0x1) == 1) && (paramG.c > 0))
    {
      localG1 = this.j.a(paramG.c - 1, paramG.d);
      if (localG1 == null)
        localG1 = new G(this, paramG.c - 1, paramG.d);
    }
    else
    {
      int i1;
      if (((paramInt & 0x2) == 2) && (paramG.c < this.j.a() - 1))
      {
        i1 = 1;
        for (localG1 = this.j.a(paramG.c + i1, paramG.d); paramG.equals(localG1); localG1 = this.j.a(paramG.c + i1, paramG.d))
        {
          i1++;
          if (paramG.c + i1 >= this.j.a())
            break;
        }
        if (paramG.equals(localG1))
          localG1 = null;
      }
      else if (((paramInt & 0x4) == 4) && (paramG.d > 0))
      {
        localG1 = this.j.a(paramG.c, paramG.d - 1);
      }
      else if (((paramInt & 0x8) == 8) && (paramG.d < this.j.b() - 1))
      {
        i1 = 1;
        for (localG1 = this.j.a(paramG.c, paramG.d + i1); paramG.equals(localG1); localG1 = this.j.a(paramG.c, paramG.d + i1))
        {
          i1++;
          if (paramG.d + i1 >= this.j.b())
            break;
        }
        if (paramG.equals(localG1))
          localG1 = null;
      }
    }
    return localG1;
  }

  public int r()
  {
    checkWidget();
    return this.p;
  }

  public int s()
  {
    checkWidget();
    return this.q;
  }

  public int t()
  {
    checkWidget();
    return this.r;
  }

  public int u()
  {
    checkWidget();
    return this.s;
  }

  public ao v()
  {
    checkWidget();
    return this.i;
  }

  public void a(ao paramao)
  {
    checkWidget();
    this.i = paramao;
  }

  public au w()
  {
    checkWidget();
    return this.j;
  }

  public void a(au paramau)
  {
    checkWidget();
    if (this.j != null)
      this.j.b(this.B);
    this.j = paramau;
    this.j.a(this.B);
    G localG = this.h.b();
    localG.d = -2147483648;
    localG.c = -2147483648;
    this.h.c();
    if ((getStyle() & 0x700) == 1792)
      k();
    redraw();
  }

  public Object v(int paramInt1, int paramInt2)
  {
    checkWidget();
    if (this.k == null)
      return "";
    aq localaq = this.j.f();
    if (localaq != null)
      paramInt1 = localaq.b(paramInt1);
    return this.k.b(paramInt1, paramInt2);
  }

  public void b(int paramInt1, int paramInt2, Object paramObject)
  {
    checkWidget();
    aq localaq = this.j.f();
    if (localaq != null)
      paramInt1 = localaq.b(paramInt1);
    this.k.b(paramInt1, paramInt2, paramObject);
  }

  private au M()
  {
    return new ab(this);
  }

  private ar N()
  {
    return new aa();
  }

  private ao O()
  {
    return new Y(this);
  }

  private R P()
  {
    return new R(this, new O());
  }

  public void a(am paramam)
  {
    this.h.a(paramam);
  }

  public am x()
  {
    return this.h.a();
  }

  private int p(int paramInt)
  {
    int i1 = this.t;
    if (this.j.k())
    {
      if (paramInt == -1)
        return i1;
      i1 += this.j.e();
      i1 += this.t;
    }
    else if (paramInt == -1)
    {
      return -2147483648;
    }
    int i2 = this.j.i();
    if (paramInt < i2)
    {
      for (i3 = 0; i3 < paramInt; i3++)
      {
        i1 += this.j.e(i3);
        i1 += this.t;
      }
      return i1;
    }
    i1 = L();
    if ((paramInt >= i2) && (paramInt < this.e))
    {
      for (i3 = this.e - 1; i3 >= paramInt; i3--)
      {
        i1 -= this.t;
        i1 -= this.j.e(paramInt);
      }
      return i1;
    }
    for (int i3 = this.e; i3 < paramInt; i3++)
    {
      i1 += this.j.e(i3);
      i1 += this.t;
    }
    return i1;
  }

  private Rectangle b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    G localG = i(paramInt1, paramInt2);
    if ((localG == G.b) || (localG.c != paramInt1) || (localG.d != paramInt2))
      return new Rectangle(0, 0, 0, 0);
    Rectangle localRectangle = a(paramInt1, paramInt2, paramInt3, paramInt4);
    int i1 = paramInt1 + 1;
    int i2 = this.j.i();
    int i3 = this.j.a();
    while ((i(i1, paramInt2).equals(localG)) && (i1 < i3))
      if ((i1 >= i2) && (i1 < this.e))
      {
        i1++;
      }
      else
      {
        localRectangle.height += this.j.e(i1);
        localRectangle.height += this.t;
        i1++;
      }
    int i4 = paramInt2 + 1;
    int i5 = this.j.h();
    int i6 = this.j.b();
    while ((i(paramInt1, i4).equals(localG)) && (i4 < i6))
      if ((i4 >= i5) && (i4 < this.f))
      {
        i4++;
      }
      else
      {
        localRectangle.width += i(i4);
        localRectangle.width += this.t;
        i4++;
      }
    return localRectangle;
  }

  public void a(av paramav)
  {
    checkWidget();
    this.h.a(paramav);
  }

  public boolean b(av paramav)
  {
    checkWidget();
    return this.h.b(paramav);
  }

  public void a(at paramat)
  {
    checkWidget();
    this.h.a(paramat);
  }

  public boolean b(at paramat)
  {
    checkWidget();
    return this.h.b(paramat);
  }

  public void b(G paramG)
  {
    checkWidget();
    this.h.a(paramG, 0);
  }

  public G[] y()
  {
    checkWidget();
    return this.h.e();
  }

  public void b(G[] paramArrayOfG)
  {
    checkWidget();
    this.h.a(paramArrayOfG);
  }

  public void z()
  {
    checkWidget();
    this.h.d();
  }

  public G A()
  {
    checkWidget();
    return this.h.b();
  }

  public int B()
  {
    checkWidget();
    return this.t;
  }

  public void l(int paramInt)
  {
    checkWidget();
    this.t = paramInt;
  }

  int C()
  {
    return this.y;
  }

  void m(int paramInt)
  {
    this.y = paramInt;
  }

  public void a(as paramas)
  {
    checkWidget();
    if (this.g != null)
      this.g.a(paramas);
  }

  public void b(as paramas)
  {
    checkWidget();
    if (this.g != null)
      this.g.b(paramas);
  }

  public ae D()
  {
    checkWidget();
    if (this.g != null)
      this.g.g();
    return null;
  }

  public void a(ae paramae)
  {
    checkWidget();
    if (this.g != null)
      this.g.a(paramae);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.e
 * JD-Core Version:    0.6.0
 */
package org.agilemore.agilegrid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class R
{
  private e a;
  private Set b;
  private Set c;
  private G d;
  private G e;
  private am f;
  private ArrayList g;
  private ArrayList h;

  public R(e parame, O paramO)
  {
    this.a = parame;
    this.d = G.b;
    this.b = new HashSet();
    this.c = new HashSet();
    this.g = new ArrayList(7);
    this.h = new ArrayList(7);
    this.f = paramO;
    S localS = new S(this);
    a(parame, localS);
    a(new T(this));
    a(new U(this));
  }

  am a()
  {
    return this.f;
  }

  void a(am paramam)
  {
    this.f = paramam;
  }

  private void a(Event paramEvent)
  {
    G localG1 = null;
    if (this.f.a(this.a, paramEvent))
    {
      this.a.forceFocus();
      G localG2 = this.d;
      if (!this.c.isEmpty())
        localG2 = this.e;
      localG1 = this.f.a(this.a, localG2, paramEvent);
      if ((localG1 != null) && (localG1 != G.b) && (!localG1.equals(localG2)))
      {
        int i = paramEvent.stateMask;
        if (paramEvent.keyCode == 9)
          i &= -131073;
        a(localG1, i);
        if (!this.a.q(this.d.c, this.d.d))
          this.a.a(false);
      }
    }
    if (this.f.b(this.a, paramEvent))
      paramEvent.doit = false;
  }

  protected void a(e parame, Listener paramListener)
  {
    parame.addListener(1, paramListener);
    parame.addListener(15, paramListener);
    parame.addListener(3, paramListener);
    parame.addListener(5, paramListener);
    parame.addListener(8, paramListener);
    parame.addListener(32, paramListener);
    parame.addListener(7, paramListener);
  }

  protected void a(ah paramah)
  {
    G localG = paramah.b();
    if (localG != G.b)
      this.a.a(new G[] { localG });
  }

  protected void a(aB paramaB)
  {
    Set localSet = paramaB.d();
    localSet.addAll(paramaB.c());
    this.a.a((G[])localSet.toArray(new G[0]));
  }

  G b()
  {
    return this.d;
  }

  boolean a(int paramInt1, int paramInt2)
  {
    if ((this.d == G.b) || (paramInt1 <= -1) || (paramInt2 <= -1))
      return false;
    return (this.d.c == paramInt1) && (this.d.d == paramInt2);
  }

  void a(G paramG, int paramInt)
  {
    if (paramG == null)
      paramG = G.b;
    G localG1 = this.d;
    b(paramG, paramInt);
    G localG2 = this.d;
    if (!localG2.equals(localG1))
      a(localG2, localG1);
  }

  private void b(G paramG, int paramInt)
  {
    this.a.m();
    if ((paramG == null) || (paramG == G.b))
    {
      this.d = G.b;
      return;
    }
    G localG = this.a.i(paramG.c, paramG.d);
    if ((localG == null) || (localG == G.b))
      return;
    HashSet localHashSet1 = null;
    Object localObject1 = null;
    int i = this.a.getStyle();
    if ((paramInt & 0x40000) != 0)
    {
      if (!this.a.h())
        return;
      this.b.addAll(this.c);
      this.c.clear();
      this.e = null;
      localHashSet1 = new HashSet(this.b);
      b(localG);
      localObject1 = this.b;
      this.d = localG;
      a((Set)localObject1, localHashSet1);
    }
    else if ((paramInt & 0x20000) != 0)
    {
      if (!this.a.h())
        return;
      HashSet localHashSet2 = new HashSet(this.c);
      this.c.clear();
      this.e = localG;
      Object localObject2 = Math.min(localG.c, this.d.c);
      Object localObject3 = Math.min(localG.d, this.d.d);
      Object localObject4 = Math.max(localG.c, this.d.c);
      Object localObject5 = Math.max(localG.d, this.d.d);
      Object localObject6;
      Object localObject7;
      if ((i & 0x8000000) != 0)
      {
        localObject6 = null;
        for (localObject7 = localObject2; localObject7 <= localObject4; localObject7++)
        {
          localObject6 = new Q(this.a, localObject7);
          this.c.add(localObject6);
        }
      }
      else if ((i & 0x10000000) != 0)
      {
        localObject6 = null;
        for (localObject7 = localObject3; localObject7 <= localObject5; localObject7++)
        {
          localObject6 = new H(this.a, localObject7);
          this.c.add(localObject6);
        }
      }
      else
      {
        for (localObject6 = localObject2; localObject6 <= localObject4; localObject6++)
          for (localObject7 = localObject3; localObject7 <= localObject5; localObject7++)
            this.c.add(new G(this.a, localObject6, localObject7));
      }
      if (!this.c.equals(localHashSet2))
      {
        localHashSet1 = new HashSet(this.b);
        localHashSet1.addAll(localHashSet2);
        localObject1 = new HashSet(this.b);
        ((Set)localObject1).addAll(this.c);
        a((Set)localObject1, localHashSet1);
      }
    }
    else
    {
      localHashSet1 = new HashSet(this.b);
      localHashSet1.addAll(this.c);
      c();
      a(localG);
      localObject1 = this.b;
      this.d = localG;
      this.e = null;
      a((Set)localObject1, localHashSet1);
    }
  }

  protected void c()
  {
    this.b.clear();
    this.c.clear();
    this.d = G.b;
  }

  void d()
  {
    c();
    this.a.redraw();
  }

  private void b(G paramG)
  {
    int i = this.a.getStyle();
    Object localObject;
    G[] arrayOfG;
    int j;
    if ((i & 0x8000000) != 0)
    {
      localObject = new Q(this.a, paramG.c);
      if (this.b.contains(localObject))
        this.b.remove(localObject);
      else
        this.b.add(localObject);
      arrayOfG = this.a.a(paramG);
      for (j = 0; j < arrayOfG.length; j++)
      {
        if (arrayOfG[j].c == paramG.c)
          continue;
        localObject = new Q(this.a, arrayOfG[j].c);
        if (this.b.contains(localObject))
          this.b.remove(localObject);
        else
          this.b.add(localObject);
      }
    }
    else if ((i & 0x10000000) != 0)
    {
      localObject = new H(this.a, paramG.d);
      if (this.b.contains(localObject))
        this.b.remove(localObject);
      else
        this.b.add(localObject);
      arrayOfG = this.a.a(paramG);
      for (j = 0; j < arrayOfG.length; j++)
      {
        if (arrayOfG[j].d == paramG.d)
          continue;
        localObject = new H(this.a, arrayOfG[j].d);
        if (this.b.contains(localObject))
          this.b.remove(localObject);
        else
          this.b.add(localObject);
      }
    }
    else if (this.b.contains(paramG))
    {
      this.b.remove(paramG);
    }
    else
    {
      this.b.add(paramG);
    }
  }

  protected void a(G paramG)
  {
    int i = this.a.getStyle();
    G[] arrayOfG;
    int j;
    if ((i & 0x8000000) != 0)
    {
      this.b.add(new Q(this.a, paramG.c));
      arrayOfG = this.a.a(paramG);
      for (j = 0; j < arrayOfG.length; j++)
      {
        if (arrayOfG[j].c == paramG.c)
          continue;
        this.b.add(new Q(this.a, arrayOfG[j].c));
      }
    }
    else if ((i & 0x10000000) != 0)
    {
      this.b.add(new H(this.a, paramG.d));
      arrayOfG = this.a.a(paramG);
      for (j = 0; j < arrayOfG.length; j++)
      {
        if (arrayOfG[j].d == paramG.d)
          continue;
        this.b.add(new H(this.a, arrayOfG[j].d));
      }
    }
    else
    {
      this.b.add(paramG);
    }
  }

  void a(G[] paramArrayOfG)
  {
    if ((paramArrayOfG == null) || (paramArrayOfG.length < 1))
    {
      d();
      return;
    }
    try
    {
      au localau = this.a.w();
      this.a.setRedraw(false);
      if (this.a.h())
        for (int i = 0; i < paramArrayOfG.length; i++)
        {
          if ((paramArrayOfG[i].d >= localau.b()) || (paramArrayOfG[i].d < 0) || (paramArrayOfG[i].c >= localau.a()) || (paramArrayOfG[i].c < 0))
            continue;
          a(paramArrayOfG[i]);
        }
      else
        a(paramArrayOfG[0]);
    }
    finally
    {
      this.a.setRedraw(true);
    }
  }

  boolean b(int paramInt1, int paramInt2)
  {
    Object localObject = this.a.i(paramInt1, paramInt2);
    int i = this.a.getStyle();
    if ((i & 0x8000000) != 0)
      localObject = new Q(this.a, ((G)localObject).c);
    else if ((i & 0x10000000) != 0)
      localObject = new H(this.a, ((G)localObject).d);
    if (this.c.contains(localObject))
      return true;
    return this.b.contains(localObject);
  }

  G[] e()
  {
    HashSet localHashSet = new HashSet(this.b);
    localHashSet.addAll(this.c);
    return (G[])localHashSet.toArray(new G[0]);
  }

  protected boolean a(Point paramPoint)
  {
    G[] arrayOfG = e();
    if ((arrayOfG == null) || (arrayOfG.length < 0))
      return false;
    for (int i = 0; i < arrayOfG.length; i++)
      if (this.a.d(arrayOfG[i].c, arrayOfG[i].d).contains(paramPoint))
        return true;
    return false;
  }

  void a(av paramav)
  {
    if (!this.g.contains(paramav))
      this.g.add(paramav);
  }

  boolean b(av paramav)
  {
    return this.g.remove(paramav);
  }

  private void a(Set paramSet1, Set paramSet2)
  {
    aB localaB = new aB(this, paramSet1, paramSet2);
    b(localaB);
  }

  private void b(aB paramaB)
  {
    for (int i = 0; i < this.g.size(); i++)
      ((av)this.g.get(i)).a(paramaB);
  }

  void a(at paramat)
  {
    if (!this.h.contains(paramat))
      this.h.add(paramat);
  }

  boolean b(at paramat)
  {
    return this.h.remove(paramat);
  }

  private void a(G paramG1, G paramG2)
  {
    ah localah = new ah(this, paramG1, paramG2);
    b(localah);
  }

  private void b(ah paramah)
  {
    for (int i = 0; i < this.h.size(); i++)
      ((at)this.h.get(i)).a(paramah);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.R
 * JD-Core Version:    0.6.0
 */
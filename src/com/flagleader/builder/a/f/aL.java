package com.flagleader.builder.a.f;

import com.flagleader.repository.d.u;
import com.flagleader.repository.tree.DecisionRule;
import com.flagleader.repository.tree.l;
import java.util.List;
import org.agilemore.agilegrid.G;
import org.agilemore.agilegrid.ab;
import org.agilemore.agilegrid.e;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

public class aL extends ab
{
  public aL(af paramaf, e parame)
  {
    super(parame);
  }

  public String a(int paramInt)
  {
    if (paramInt < af.a(this.a).getConditionNum())
    {
      if (paramInt == 0)
        return u.a("dicisionRuleY.head", "if");
      return "";
    }
    if (paramInt == af.a(this.a).getConditionNum())
      return u.a("decisionRuleX.head", "then");
    return "";
  }

  public int a()
  {
    return this.a.e().size() + 2;
  }

  public int b()
  {
    if (af.a(this.a).getMaxX() > 0)
      return af.a(this.a).getConditionNum() + af.a(this.a).getMaxX();
    return af.a(this.a).getConditionNum() + 1;
  }

  public int b(int paramInt)
  {
    return (af.d(this.a).getSize().x - 92) / b();
  }

  public G a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 < af.a(this.a).getConditionNum() + af.a(this.a).getMaxX()) && (!f(paramInt1, paramInt2)))
    {
      if (paramInt2 < af.a(this.a).getConditionNum())
        return new G(this.b, paramInt1, 0);
      return new G(this.b, paramInt1, af.a(this.a).getConditionNum());
    }
    if ((paramInt2 < af.a(this.a).getConditionNum()) && (paramInt1 > 1) && (!f(paramInt1, paramInt2)))
    {
      int i = paramInt1 - 2;
      if (this.a.e().size() > i)
      {
        l locall1 = (l)this.a.e().get(i);
        if (locall1.a().size() <= paramInt2)
          return new G(this.b, paramInt1, paramInt2);
        int j = i;
        for (int k = i - 1; k >= -1; k--)
        {
          if (k == -1)
          {
            j = 0;
            break;
          }
          l locall2 = (l)this.a.e().get(k);
          if ((locall1.a().size() <= paramInt2) || (locall2.a().size() <= paramInt2) || (locall1.a().get(paramInt2).equals(locall2.a().get(paramInt2))))
            continue;
          j = k + 1;
          break;
        }
        if (j < i)
          return new G(this.b, j + 2, paramInt2);
        return new G(this.b, paramInt1, paramInt2);
      }
    }
    return new G(this.b, paramInt1, paramInt2);
  }

  public int c(int paramInt)
  {
    return 18;
  }

  public String d(int paramInt)
  {
    if (paramInt > 1)
      return String.valueOf(paramInt - 1);
    return "";
  }

  public int c()
  {
    return 30;
  }

  public int e(int paramInt)
  {
    return super.e(paramInt);
  }

  public int d()
  {
    return 20;
  }

  public int e()
  {
    return 20;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.aL
 * JD-Core Version:    0.6.0
 */
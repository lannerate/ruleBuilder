package com.flagleader.builder.a.f;

import com.flagleader.repository.d.u;
import com.flagleader.repository.tree.DecisionRelateAction;
import com.flagleader.repository.tree.DecisionRelateRule;
import com.flagleader.repository.tree.l;
import java.util.List;
import org.agilemore.agilegrid.G;
import org.agilemore.agilegrid.ab;
import org.agilemore.agilegrid.e;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

public class V extends ab
{
  public V(o paramo, e parame)
  {
    super(parame);
  }

  public String a(int paramInt)
  {
    if (paramInt < o.a(this.a).getConditionNum())
      return u.a("decitioncondition.text", "condition") + (paramInt + 1);
    if ((paramInt >= o.a(this.a).getConditionNum()) && (paramInt < o.a(this.a).getConditionNum() + o.a(this.a).getValueNum()))
      return u.a("decisionassign.text", "assign") + (paramInt - o.a(this.a).getConditionNum() + 1);
    if (paramInt == o.a(this.a).getConditionNum() + o.a(this.a).getValueNum())
      return u.a("decisionaction.text", "action");
    return "";
  }

  public int a()
  {
    return this.a.e().size() + 1;
  }

  public int b()
  {
    return o.a(this.a).getConditionNum() + o.a(this.a).getValueNum() + 1;
  }

  public int b(int paramInt)
  {
    return (o.d(this.a).getSize().x - 92) / b();
  }

  public G a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < o.a(this.a).getConditionNum()) && (paramInt1 > 0) && (!f(paramInt1, paramInt2)))
    {
      int i = paramInt1 - 1;
      if (this.a.e().size() > i)
      {
        l locall1 = (l)this.a.e().get(i);
        if (locall1.a().size() <= paramInt2)
          return new G(this.b, paramInt1, paramInt2);
        if (locall1.a(paramInt2) == 0)
        {
          int j = i;
          for (int k = i - 1; k >= -1; k--)
          {
            if (k == -1)
            {
              j = 0;
              break;
            }
            l locall2 = (l)this.a.e().get(k);
            if (locall2.a(paramInt2) <= 0)
              continue;
            j = k;
            break;
          }
          if (j < i)
            return new G(this.b, j + 1, paramInt2);
          return new G(this.b, paramInt1, paramInt2);
        }
        return new G(this.b, paramInt1, paramInt2);
      }
    }
    return new G(this.b, paramInt1, paramInt2);
  }

  public int c(int paramInt)
  {
    return 20;
  }

  public String d(int paramInt)
  {
    if (paramInt > 0)
      return String.valueOf(paramInt);
    return "";
  }

  public int c()
  {
    return 30;
  }

  public int e(int paramInt)
  {
    if ((this.a.e().size() > paramInt - 1) && (paramInt >= 1))
    {
      l locall = (l)this.a.e().get(paramInt - 1);
      DecisionRelateAction localDecisionRelateAction = o.a(this.a).getDecisionAction(locall.a());
      if (!localDecisionRelateAction.isEmpty())
        return localDecisionRelateAction.getHeight() * 12 + 8;
    }
    return super.e(paramInt);
  }

  public int d()
  {
    return 20;
  }

  public int e()
  {
    return 30;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.V
 * JD-Core Version:    0.6.0
 */
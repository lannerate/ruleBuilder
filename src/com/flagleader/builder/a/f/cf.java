package com.flagleader.builder.a.f;

import com.flagleader.repository.d.u;
import com.flagleader.repository.rlm.lang.ILangToken;
import com.flagleader.repository.tree.RuleSet;
import com.flagleader.util.StringUtil;
import java.util.List;
import org.agilemore.agilegrid.G;
import org.agilemore.agilegrid.ab;
import org.agilemore.agilegrid.e;
import org.apache.commons.lang.StringUtils;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

public class cf extends ab
{
  public cf(bQ parambQ, e parame)
  {
    super(parame);
  }

  public String a(int paramInt)
  {
    if (paramInt == 0)
      return u.a("tv_condition");
    if (paramInt == bQ.b(this.a) - 2)
      return u.a("tv_if");
    if (paramInt == bQ.b(this.a) - 1)
      return u.a("tv_action");
    return "";
  }

  public int a()
  {
    return bQ.c(this.a).getRuleTableCount() + 1;
  }

  public int b()
  {
    return bQ.b(this.a);
  }

  public int b(int paramInt)
  {
    return (bQ.d(this.a).getSize().x - 92) / bQ.e(this.a);
  }

  public G a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < bQ.b(this.a) - 2) && (!f(paramInt1, paramInt2)))
      for (int i = 0; i < bQ.f(this.a).size(); i++)
      {
        bZ localbZ = (bZ)bQ.f(this.a).get(i);
        if ((localbZ.a <= paramInt1) && (localbZ.a + localbZ.d > paramInt1) && (localbZ.b == paramInt2))
          return new G(this.b, localbZ.a, paramInt2);
      }
    return new G(this.b, paramInt1, paramInt2);
  }

  public int c(int paramInt)
  {
    return 30;
  }

  public String d(int paramInt)
  {
    return String.valueOf(paramInt);
  }

  public int c()
  {
    return 30;
  }

  public int e(int paramInt)
  {
    int i = 0;
    for (int j = 0; j < bQ.f(this.a).size(); j++)
    {
      bZ localbZ = (bZ)bQ.f(this.a).get(j);
      int k;
      if ((localbZ.a == paramInt) && (localbZ.b == bQ.e(this.a) - 1))
      {
        k = a(localbZ.e);
        if (k <= i)
          continue;
        i = k;
      }
      else
      {
        if ((localbZ.a != paramInt) || (localbZ.b != bQ.e(this.a) - 2))
          continue;
        k = a(localbZ.e);
        if (k <= i)
          continue;
        i = k;
      }
    }
    if (i > 0)
      return i * 17 + 2;
    return super.e(paramInt);
  }

  private int a(Object paramObject)
  {
    if ((paramObject instanceof ILangToken))
      return StringUtils.countMatches(((ILangToken)paramObject).getText(), "\n");
    return StringUtils.countMatches(StringUtil.stringValue(paramObject), "\n");
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
 * Qualified Name:     com.flagleader.builder.a.f.cf
 * JD-Core Version:    0.6.0
 */
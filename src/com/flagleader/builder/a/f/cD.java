package com.flagleader.builder.a.f;

import com.flagleader.repository.d.u;
import java.util.List;
import org.agilemore.agilegrid.G;
import org.agilemore.agilegrid.ab;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

public class cD extends ab
{
  public cD(ck paramck, org.agilemore.agilegrid.e parame)
  {
    super(parame);
  }

  public String a(int paramInt)
  {
    switch (paramInt)
    {
    case 0:
      return u.a("tv_condition");
    case 1:
      return u.a("tv_action");
    }
    return super.a(paramInt);
  }

  public int a()
  {
    return this.a.e().size() + 1;
  }

  public int b()
  {
    return 2;
  }

  public int b(int paramInt)
  {
    if (paramInt == 0)
      return (ck.d(this.a).getSize().x - 92) * 2 / 5;
    return (ck.d(this.a).getSize().x - 92) * 3 / 5;
  }

  public G a(int paramInt1, int paramInt2)
  {
    return new G(this.b, paramInt1, paramInt2);
  }

  public int c(int paramInt)
  {
    return 30;
  }

  public String d(int paramInt)
  {
    if ((this.a.e().size() > paramInt - 1) && (paramInt > 0))
    {
      com.flagleader.repository.rlm.e locale = (com.flagleader.repository.rlm.e)this.a.e().get(paramInt - 1);
      return locale.a();
    }
    return "";
  }

  public int c()
  {
    return 70;
  }

  public int e(int paramInt)
  {
    if ((this.a.e().size() > paramInt - 1) && (paramInt > 0))
    {
      com.flagleader.repository.rlm.e locale = (com.flagleader.repository.rlm.e)this.a.e().get(paramInt - 1);
      int i = locale.d() * 17 + 2;
      if (i > 20)
        return i;
      return 20;
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
 * Qualified Name:     com.flagleader.builder.a.f.cD
 * JD-Core Version:    0.6.0
 */
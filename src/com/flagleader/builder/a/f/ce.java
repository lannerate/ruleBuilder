package com.flagleader.builder.a.f;

import com.flagleader.repository.e.m;
import com.flagleader.repository.rlm.lang.ILangToken;
import com.flagleader.repository.tree.RuleSet;
import com.flagleader.util.StringUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.agilemore.agilegrid.c;

public class ce extends c
{
  private Random d = new Random();

  public ce(bQ parambQ)
  {
  }

  public Object a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      if (paramInt2 < bQ.g(this.a).length)
        return bQ.g(this.a)[paramInt2];
      return null;
    }
    bY localbY = new bY(paramInt1, paramInt2);
    Object localObject = bQ.h(this.a).get(localbY);
    if (localObject == null)
      for (int i = 0; i < bQ.f(this.a).size(); i++)
      {
        bZ localbZ = (bZ)bQ.f(this.a).get(i);
        if ((localbZ.a > paramInt1) || (localbZ.a + localbZ.d <= paramInt1) || (localbZ.b != paramInt2))
          continue;
        bQ.h(this.a).put(localbY, localbZ.e);
      }
    if (localObject != null)
    {
      if ((localObject instanceof ILangToken))
      {
        String str = ((ILangToken)localObject).getText().trim();
        if (str.endsWith(m.q))
          str = str.substring(0, str.length() - m.q.length());
        if ((paramInt2 < bQ.g(this.a).length) && (!StringUtil.isEmpty(bQ.g(this.a)[paramInt2])))
          str = bQ.c(this.a).parseShortRuleName(str, bQ.g(this.a)[paramInt2]);
        return str;
      }
      return StringUtil.stringValue(localObject);
    }
    return localObject;
  }

  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.ce
 * JD-Core Version:    0.6.0
 */
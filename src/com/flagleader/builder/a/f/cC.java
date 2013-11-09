package com.flagleader.builder.a.f;

import com.flagleader.repository.e.m;
import com.flagleader.repository.rlm.e;
import com.flagleader.repository.rlm.lang.ILangToken;
import com.flagleader.repository.tree.Rule;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.agilemore.agilegrid.c;

public class cC extends c
{
  private Random d = new Random();

  public cC(ck paramck)
  {
  }

  public Object a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      if (paramInt2 == 0)
        return ck.e(this.a);
      if (paramInt2 == 1)
        return ck.f(this.a);
    }
    cs localcs = new cs(paramInt1, paramInt2);
    ILangToken localILangToken = (ILangToken)ck.g(this.a).get(localcs);
    Object localObject;
    if ((localILangToken == null) && (this.a.e().size() > paramInt1 - 1) && (paramInt1 > 0))
    {
      localObject = (e)this.a.e().get(paramInt1 - 1);
      localILangToken = ((e)localObject).a(paramInt2);
      if (localILangToken != null)
        ck.g(this.a).put(localcs, localILangToken);
    }
    if (localILangToken != null)
    {
      localObject = localILangToken.getText();
      if (((String)localObject).endsWith(m.q))
        localObject = ((String)localObject).substring(0, ((String)localObject).length() - m.q.length());
      if (paramInt2 == 0)
        localObject = ck.a(this.a).parseShortRuleName((String)localObject, ck.e(this.a));
      else if (paramInt2 == 1)
        localObject = ck.a(this.a).parseShortRuleName((String)localObject, ck.f(this.a));
      return localObject;
    }
    return localILangToken;
  }

  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.cC
 * JD-Core Version:    0.6.0
 */
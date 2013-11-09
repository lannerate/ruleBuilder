package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.c;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.RulePackage;
import java.text.SimpleDateFormat;
import java.util.Date;

public class P
  implements c
{
  public P(y paramy)
  {
  }

  public String a()
  {
    if (y.a(this.a).getStartTime() == 0L)
      return "";
    return new SimpleDateFormat(com.flagleader.manager.d.b.a().h()).format(new Date(y.a(this.a).getStartTime()));
  }

  public boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.a(this.a).setStartTime(0L);
      y.a(this.a).setModified(true);
      return true;
    }
    try
    {
      y.a(this.a).setStartTime(new SimpleDateFormat(com.flagleader.manager.d.b.a().h()).parse(paramString).getTime());
      y.a(this.a).setModified(true);
      return true;
    }
    catch (Exception localException)
    {
      y.b(this.a).b().showError(localException.getLocalizedMessage());
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.P
 * JD-Core Version:    0.6.0
 */
package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.c;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.IRuleTree;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ar
  implements c
{
  public ar(ao paramao)
  {
  }

  public String a()
  {
    if (this.a.h().getEndTime() == 0L)
      return "";
    return new SimpleDateFormat(com.flagleader.manager.d.b.a().h()).format(new Date(this.a.h().getEndTime()));
  }

  public boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      this.a.h().setEndTime(0L);
      this.a.h().setModified(true);
      return true;
    }
    try
    {
      this.a.h().setEndTime(new SimpleDateFormat(com.flagleader.manager.d.b.a().h()).parse(paramString).getTime());
      this.a.h().setModified(true);
      return true;
    }
    catch (Exception localException)
    {
      ao.a(this.a).b().showError(localException.getLocalizedMessage());
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.ar
 * JD-Core Version:    0.6.0
 */
package com.flagleader.builder.a.e;

import com.flagleader.builder.BuilderManager;
import com.flagleader.repository.db.CustomSql;
import com.flagleader.repository.db.ISelectObject;
import com.flagleader.repository.h;
import java.util.List;

class n extends Thread
{
  n(k paramk)
  {
  }

  public void run()
  {
    for (int i = 0; i < k.d(this.a); i++)
    {
      Object localObject = k.e(this.a).get(i);
      if (localObject != null)
        try
        {
          boolean bool = true;
          if ((localObject instanceof CustomSql))
            bool = ((CustomSql)localObject).check();
          else if ((localObject instanceof ISelectObject))
            bool = ((ISelectObject)localObject).check();
          if (!bool)
            k.a(this.a, i);
        }
        catch (Exception localException)
        {
          k.c(this.a).getUserLogger().a(localException.getLocalizedMessage());
          k.a(this.a, i);
        }
      this.a.b(i);
    }
    this.a.b(k.d(this.a));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.e.n
 * JD-Core Version:    0.6.0
 */
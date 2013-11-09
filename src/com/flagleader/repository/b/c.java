package com.flagleader.repository.b;

import com.flagleader.engine.Property;
import com.flagleader.engine.RuleEngineException;
import java.util.HashMap;
import java.util.Set;

public class c extends Thread
{
  Thread a = null;
  boolean b = false;

  public c(b paramb, Thread paramThread)
  {
    this.a = paramThread;
  }

  public void run()
  {
    while ((!this.b) && (this.a != null) && (this.a.isAlive()))
    {
      Object[] arrayOfObject = b.a(this.c).keySet().toArray();
      for (int i = 0; (arrayOfObject != null) && (i < arrayOfObject.length); i++)
      {
        String str = arrayOfObject[i].toString();
        try
        {
          if (!b.a(this.c, str))
            continue;
          b.a(this.c, str, b.b(this.c, str));
        }
        catch (RuleEngineException localRuleEngineException)
        {
        }
      }
      try
      {
        if (Property.getInstance().getUpdateInternateTime() > 0L)
          sleep(Property.getInstance().getUpdateInternateTime());
        else
          sleep(1000L);
      }
      catch (Exception localException)
      {
      }
    }
    this.b = true;
    super.run();
  }

  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public boolean a()
  {
    return this.b;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.b.c
 * JD-Core Version:    0.6.0
 */
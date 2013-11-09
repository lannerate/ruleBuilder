package com.flagleader.builder.d;

import com.flagleader.builder.BuilderConfig;
import com.flagleader.builder.BuilderManager;
import java.util.Timer;

public class a
{
  private Timer a = null;
  private BuilderManager b;

  public a(BuilderManager paramBuilderManager)
  {
    this.b = paramBuilderManager;
  }

  public void a()
  {
    if (this.a != null)
      this.a.cancel();
    this.a = null;
  }

  public void b()
  {
    a();
    if (BuilderConfig.getInstance().isAutoCheckVersion())
    {
      long l = BuilderConfig.getInstance().getAutoCheckVersionTime() * 1000L;
      if (l > 0L)
      {
        this.a = new Timer();
        this.a.schedule(new b(this), l, l);
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.d.a
 * JD-Core Version:    0.6.0
 */
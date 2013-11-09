package com.flagleader.builder.d;

import java.util.Timer;

public class e
{
  private Timer a = null;

  public void a()
  {
    if (this.a != null)
      this.a.cancel();
    this.a = null;
  }

  public void b()
  {
    a();
    this.a = new Timer();
    this.a.schedule(new f(this), 60000L, 60000L);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.d.e
 * JD-Core Version:    0.6.0
 */
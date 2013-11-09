package com.flagleader.builder.a.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.db.IResult;
import com.flagleader.repository.h;
import java.sql.Connection;
import java.util.Vector;

class f extends Thread
{
  f(a parama)
  {
  }

  public void run()
  {
    try
    {
      a.a(this.a, 1);
      this.a.f = this.a.i();
      if (this.a.f != null)
      {
        a.b(this.a, this.a.f.getRows());
        this.a.C();
        while ((this.a.f.next()) && (!isInterrupted()))
          this.a.a(this.a.f.getCurrentRecord());
        this.a.f.close();
        if (!this.a.f.getConn().isClosed())
          this.a.f.getConn().close();
      }
      if (a.c(this.a).isEmpty())
        this.a.b(a.e(this.a));
    }
    catch (Throwable localThrowable)
    {
      a.f(this.a).getUserLogger().a(localThrowable.getLocalizedMessage(), localThrowable);
      if (a.c(this.a).isEmpty())
        this.a.b(a.e(this.a));
    }
    a.a(this.a, true);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.f
 * JD-Core Version:    0.6.0
 */
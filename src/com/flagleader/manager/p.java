package com.flagleader.manager;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

class p extends Handler
{
  public void publish(LogRecord paramLogRecord)
  {
    this.a.a(paramLogRecord);
  }

  public void flush()
  {
  }

  public void close()
  {
  }

  p(n paramn)
  {
    setFormatter(new o(paramn));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.p
 * JD-Core Version:    0.6.0
 */
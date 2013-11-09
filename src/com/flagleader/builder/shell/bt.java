package com.flagleader.builder.shell;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

class bt extends Handler
{
  public void publish(LogRecord paramLogRecord)
  {
    int i = paramLogRecord.getLevel().intValue();
    if (i >= Level.FINEST.intValue())
    {
      String str = getFormatter().format(paramLogRecord);
      aQ.a(this.a, str, paramLogRecord.getLevel());
    }
  }

  public void flush()
  {
  }

  public void close()
  {
  }

  bt(aQ paramaQ)
  {
    setFormatter(new bs(paramaQ));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.bt
 * JD-Core Version:    0.6.0
 */
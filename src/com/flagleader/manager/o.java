package com.flagleader.manager;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

class o extends Formatter
{
  public String format(LogRecord paramLogRecord)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramLogRecord.getMessage());
    return localStringBuffer.toString();
  }

  public o(n paramn)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.o
 * JD-Core Version:    0.6.0
 */
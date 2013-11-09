package com.flagleader.builder.shell;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

class bs extends Formatter
{
  public String format(LogRecord paramLogRecord)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramLogRecord.getMessage());
    return localStringBuffer.toString();
  }

  public bs(aQ paramaQ)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.bs
 * JD-Core Version:    0.6.0
 */
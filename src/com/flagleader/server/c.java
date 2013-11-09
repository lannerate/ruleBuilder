package com.flagleader.server;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class c extends Formatter
{
  private Date a = new Date();
  private static final String b = "{0,date} {0,time}";
  private MessageFormat c;
  private Object[] d = new Object[1];

  public synchronized String format(LogRecord paramLogRecord)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    this.a.setTime(paramLogRecord.getMillis());
    this.d[0] = this.a;
    StringBuffer localStringBuffer = new StringBuffer();
    if (this.c == null)
      this.c = new MessageFormat("{0,date} {0,time}");
    this.c.format(this.d, localStringBuffer, null);
    localPrintWriter.print(localStringBuffer);
    localPrintWriter.print(" ");
    String str = formatMessage(paramLogRecord);
    localPrintWriter.print(paramLogRecord.getLevel().getLocalizedName());
    localPrintWriter.print(": ");
    localPrintWriter.print(str);
    localPrintWriter.println();
    a(localPrintWriter, paramLogRecord.getThrown());
    return localStringWriter.toString();
  }

  private void a(PrintWriter paramPrintWriter, Throwable paramThrowable)
  {
    if ((paramThrowable instanceof InvocationTargetException))
    {
      InvocationTargetException localInvocationTargetException = (InvocationTargetException)paramThrowable;
      if (localInvocationTargetException.getTargetException() != null)
        a(paramPrintWriter, localInvocationTargetException.getTargetException());
    }
    if (paramThrowable != null)
      paramThrowable.printStackTrace(paramPrintWriter);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.server.c
 * JD-Core Version:    0.6.0
 */
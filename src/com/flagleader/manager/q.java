package com.flagleader.manager;

import java.io.Writer;
import java.util.logging.Level;

public class q extends Writer
{
  StringBuffer a = null;

  public q(n paramn)
  {
    this.lock = this.a;
  }

  public void write(int paramInt)
  {
    this.a.append((char)paramInt);
  }

  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > paramArrayOfChar.length) || (paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfChar.length) || (paramInt1 + paramInt2 < 0))
      throw new IndexOutOfBoundsException();
    if (paramInt2 == 0)
      return;
    this.a.append(paramArrayOfChar, paramInt1, paramInt2);
  }

  public void write(String paramString)
  {
    this.a.append(paramString);
  }

  public void write(String paramString, int paramInt1, int paramInt2)
  {
    this.a.append(paramString.substring(paramInt1, paramInt1 + paramInt2));
  }

  public String toString()
  {
    return this.a.toString();
  }

  public StringBuffer a()
  {
    return this.a;
  }

  public void flush()
  {
    this.b.a(this.a.toString(), Level.WARNING);
    this.a.setLength(0);
  }

  public void close()
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.q
 * JD-Core Version:    0.6.0
 */
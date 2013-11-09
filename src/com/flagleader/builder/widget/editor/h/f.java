package com.flagleader.builder.widget.editor.h;

import com.flagleader.manager.c.d;
import com.flagleader.util.ListIterator;
import java.util.Iterator;

public abstract class f extends d
{
  public Iterator a(String paramString)
  {
    try
    {
      String[] arrayOfString = c(paramString);
      String str = b(arrayOfString[0]);
      if (arrayOfString.length > 1)
        for (int i = 0; i < arrayOfString.length - 1; i++)
          str = a.a().a(str, arrayOfString[(i + 1)]);
      if (str.length() > 0)
        return new ListIterator(a.a().a(str));
      return null;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  protected String[] c(String paramString)
  {
    String[] arrayOfString = paramString.split("[.]");
    for (int i = 0; i < arrayOfString.length; i++)
      arrayOfString[i] = b(arrayOfString[i]);
    return arrayOfString;
  }

  protected abstract String b(String paramString);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.h.f
 * JD-Core Version:    0.6.0
 */
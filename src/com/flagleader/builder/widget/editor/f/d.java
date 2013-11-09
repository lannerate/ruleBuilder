package com.flagleader.builder.widget.editor.f;

import com.flagleader.repository.collections.g;
import com.flagleader.util.ArrayIterator;
import java.util.Iterator;

public class d extends com.flagleader.manager.c.d
{
  public static final String[] a = { "request", "response", "out", "session", "application", "pageContext", "config", "page" };

  public Iterator a(String paramString)
  {
    return g.a();
  }

  public Iterator a()
  {
    return new ArrayIterator(a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.f.d
 * JD-Core Version:    0.6.0
 */
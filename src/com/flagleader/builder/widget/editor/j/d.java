package com.flagleader.builder.widget.editor.j;

import com.flagleader.builder.widget.editor.q;
import com.flagleader.util.ArrayIterator;
import java.util.Iterator;

public class d extends q
{
  public static final String[] a = { "version", "encoding", "xml" };
  public static final String[] b = { "{", "}", "=", "*", "+", "-", "</", ";", "(", ")", "[", "]", "/", "&&", "||", "@", ">", "<", "!=", ">=", "<=", "<>" };
  public static final String c = "{}=+=*/;,()[]&|@><!";

  public Iterator a()
  {
    return new ArrayIterator(a);
  }

  public Iterator b()
  {
    return new ArrayIterator(b);
  }

  public static boolean a(char paramChar)
  {
    return "{}=+=*/;,()[]&|@><!".indexOf(paramChar) >= 0;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.j.d
 * JD-Core Version:    0.6.0
 */
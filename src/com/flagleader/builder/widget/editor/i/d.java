package com.flagleader.builder.widget.editor.i;

import com.flagleader.builder.widget.editor.q;
import com.flagleader.util.ArrayIterator;
import java.util.Iterator;

public class d extends q
{
  public static final String[] a = { "insert", "select", "into", "from", "as", "where", "and", "or", "on", "not", "delete", "update", "max", "min", "count", "concat", "like", "is", "null", "order", "by", "set", "distinct", "string", "int", "long", "float", "double", "date", "datatime", "HAVING", "asc", "group", "values", "inner", "join", "left", "right", "union", "desc", "in", "TRUNCATE", "DROP" };
  public static final String[] b = { "{", "}", "=", "*", "+", "-", "/", ";", "(", ")", "[", "]", "&&", "||", "@", ">", "<", "!=", ">=", "<=", "<>" };
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
 * Qualified Name:     com.flagleader.builder.widget.editor.i.d
 * JD-Core Version:    0.6.0
 */
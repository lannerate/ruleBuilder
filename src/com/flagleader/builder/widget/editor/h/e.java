package com.flagleader.builder.widget.editor.h;

import com.flagleader.builder.widget.editor.q;
import com.flagleader.repository.lang.expression.StatementSystem;
import com.flagleader.util.ArrayIterator;
import com.flagleader.util.ListUtil;
import java.util.Iterator;

public class e extends q
{
  public static final String[] a = ListUtil.addArray(StatementSystem.o, StatementSystem.a);
  public static final String[] b = ListUtil.addArray(ListUtil.addArray(ListUtil.addArray(StatementSystem.c, StatementSystem.b), StatementSystem.d), StatementSystem.h);
  public static final String c = "{}=+=*/%&|@><!";

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
    return "{}=+=*/%&|@><!".indexOf(paramChar) >= 0;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.h.e
 * JD-Core Version:    0.6.0
 */
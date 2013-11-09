package com.flagleader.builder.widget.editor.g;

import com.flagleader.builder.widget.editor.q;
import com.flagleader.util.ArrayIterator;
import java.util.Iterator;

public class d extends q
{
  public static final String[] a = { "abstract", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "delete", "do", "double", "else", "extends", "false", "final", "finally", "float", "for", "function", "goto", "if", "implements", "import", "short", "in", "instanceof", "int", "interface", "long", "native", "new", "null", "package", "private", "protected", "public", "return", "short", "static", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "true", "try", "typeof", "var", "void", "while", "PageFieldModel", "PageElementModel", "call", "include" };
  public static final String[] b = { "{", "}", "=", "*", "+", "-", "/", "==", "+=", "-=", "*=", "/=", "&&", "||", "@" };
  public static final String[] c = { "<?", "?>", "?><?", "<??>" };
  public static final String d = "{}=+=*/;,&|@><!";

  public Iterator a()
  {
    return new ArrayIterator(a);
  }

  public Iterator b()
  {
    return new ArrayIterator(b);
  }

  public Iterator c()
  {
    return new ArrayIterator(c);
  }

  public static boolean a(char paramChar)
  {
    return "{}=+=*/;,&|@><!".indexOf(paramChar) >= 0;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.g.d
 * JD-Core Version:    0.6.0
 */
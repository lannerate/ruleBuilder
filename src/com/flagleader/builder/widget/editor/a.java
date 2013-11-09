package com.flagleader.builder.widget.editor;

import java.util.Iterator;
import org.eclipse.jface.text.rules.IWordDetector;

public class a
  implements IWordDetector
{
  o a;

  public a(o paramo)
  {
    this.a = paramo;
  }

  public boolean isWordStart(char paramChar)
  {
    Iterator localIterator = this.a.c();
    while (localIterator.hasNext())
      if (paramChar == ((String)localIterator.next()).charAt(0))
        return true;
    return false;
  }

  public boolean isWordPart(char paramChar)
  {
    Iterator localIterator = this.a.c();
    while (localIterator.hasNext())
      if (((String)localIterator.next()).indexOf(paramChar) != -1)
        return true;
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.a
 * JD-Core Version:    0.6.0
 */
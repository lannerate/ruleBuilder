package com.flagleader.builder.widget.editor;

import org.eclipse.jface.text.rules.IWordDetector;

public class F
  implements IWordDetector
{
  o a;

  public F(o paramo)
  {
    this.a = paramo;
  }

  public boolean isWordStart(char paramChar)
  {
    return Character.isJavaIdentifierStart(paramChar);
  }

  public boolean isWordPart(char paramChar)
  {
    return Character.isJavaIdentifierPart(paramChar);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.F
 * JD-Core Version:    0.6.0
 */
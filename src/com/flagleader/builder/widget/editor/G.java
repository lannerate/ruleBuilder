package com.flagleader.builder.widget.editor;

import com.flagleader.manager.c.a;
import org.eclipse.jface.text.rules.IWordDetector;

public class G
  implements IWordDetector
{
  a a;

  public G(a parama)
  {
    this.a = parama;
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
 * Qualified Name:     com.flagleader.builder.widget.editor.G
 * JD-Core Version:    0.6.0
 */
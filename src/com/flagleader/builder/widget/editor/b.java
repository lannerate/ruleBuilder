package com.flagleader.builder.widget.editor;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

public class b
  implements IRule
{
  protected static final int a = -1;
  protected IToken b;
  protected int c = -1;

  public b(IToken paramIToken)
  {
    Assert.isNotNull(paramIToken);
    this.b = paramIToken;
  }

  public void a(int paramInt)
  {
    if (paramInt < 0)
      paramInt = -1;
    this.c = paramInt;
  }

  public IToken evaluate(ICharacterScanner paramICharacterScanner)
  {
    int i = paramICharacterScanner.read();
    if ((a((char)i)) && ((this.c == -1) || (this.c == paramICharacterScanner.getColumn() - 1)))
    {
      do
        i = paramICharacterScanner.read();
      while (a((char)i));
      paramICharacterScanner.unread();
      return this.b;
    }
    paramICharacterScanner.unread();
    return Token.UNDEFINED;
  }

  private boolean a(char paramChar)
  {
    return "{}=*+-/&|@[],;".indexOf(paramChar) >= 0;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.b
 * JD-Core Version:    0.6.0
 */
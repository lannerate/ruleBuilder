package com.flagleader.builder.widget.editor.d;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.Token;

public class c
  implements IRule
{
  protected static final int a = -1;
  protected IWordDetector b;
  protected IToken c;
  protected int d = -1;
  protected Map e = new HashMap();
  private StringBuffer f = new StringBuffer();
  private boolean g = false;

  public c(IWordDetector paramIWordDetector)
  {
    this(paramIWordDetector, Token.UNDEFINED, false);
  }

  public c(IWordDetector paramIWordDetector, boolean paramBoolean)
  {
    this(paramIWordDetector, Token.UNDEFINED, paramBoolean);
  }

  public c(IWordDetector paramIWordDetector, IToken paramIToken)
  {
    this(paramIWordDetector, paramIToken, false);
  }

  public c(IWordDetector paramIWordDetector, IToken paramIToken, boolean paramBoolean)
  {
    Assert.isNotNull(paramIWordDetector);
    Assert.isNotNull(paramIToken);
    this.b = paramIWordDetector;
    this.c = paramIToken;
    this.g = paramBoolean;
  }

  public void a(String paramString, IToken paramIToken)
  {
    Assert.isNotNull(paramString);
    Assert.isNotNull(paramIToken);
    this.e.put(paramString, paramIToken);
  }

  public void a(int paramInt)
  {
    if (paramInt < 0)
      paramInt = -1;
    this.d = paramInt;
  }

  public IToken evaluate(ICharacterScanner paramICharacterScanner)
  {
    int i = paramICharacterScanner.read();
    if ((i != -1) && (this.b.isWordStart((char)i)) && ((this.d == -1) || (this.d == paramICharacterScanner.getColumn() - 1)))
    {
      this.f.setLength(0);
      do
      {
        this.f.append((char)i);
        i = paramICharacterScanner.read();
      }
      while ((i != -1) && (this.b.isWordPart((char)i)));
      paramICharacterScanner.unread();
      String str1 = this.f.toString();
      IToken localIToken = (IToken)this.e.get(str1);
      if (this.g)
      {
        Iterator localIterator = this.e.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          if (!str1.equalsIgnoreCase(str2))
            continue;
          localIToken = (IToken)this.e.get(str2);
          break;
        }
      }
      else
      {
        localIToken = (IToken)this.e.get(str1);
      }
      if (localIToken != null)
        return localIToken;
      if (this.c.isUndefined())
        a(paramICharacterScanner);
      return this.c;
    }
    paramICharacterScanner.unread();
    return Token.UNDEFINED;
  }

  protected void a(ICharacterScanner paramICharacterScanner)
  {
    for (int i = this.f.length() - 1; i >= 0; i--)
      paramICharacterScanner.unread();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.d.c
 * JD-Core Version:    0.6.0
 */
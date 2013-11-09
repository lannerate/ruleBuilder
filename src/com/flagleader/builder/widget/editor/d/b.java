package com.flagleader.builder.widget.editor.d;

import java.text.CharacterIterator;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;

class b
  implements CharacterIterator
{
  private IDocument a;
  private int b = -1;
  private int c = -1;
  private int d = -1;

  public void a(IDocument paramIDocument, IRegion paramIRegion)
  {
    this.a = paramIDocument;
    this.b = paramIRegion.getOffset();
    this.c = (this.b + paramIRegion.getLength());
  }

  public char first()
  {
    this.d = this.b;
    return current();
  }

  public char last()
  {
    this.d = (this.b < this.c ? this.c - 1 : this.c);
    return current();
  }

  public char current()
  {
    if ((this.b <= this.d) && (this.d < this.c))
      try
      {
        return this.a.getChar(this.d);
      }
      catch (BadLocationException localBadLocationException)
      {
      }
    return 65535;
  }

  public char next()
  {
    this.d += 1;
    int i = getEndIndex();
    if (this.d >= i)
    {
      this.d = i;
      return 65535;
    }
    return current();
  }

  public char previous()
  {
    if (this.d == this.b)
      return 65535;
    if (this.d > this.b)
      this.d -= 1;
    return current();
  }

  public char setIndex(int paramInt)
  {
    this.d = paramInt;
    return current();
  }

  public int getBeginIndex()
  {
    return this.b;
  }

  public int getEndIndex()
  {
    return this.c;
  }

  public int getIndex()
  {
    return this.d;
  }

  public Object clone()
  {
    b localb = new b();
    localb.a = this.a;
    localb.d = this.d;
    localb.b = this.b;
    localb.c = this.c;
    return localb;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.d.b
 * JD-Core Version:    0.6.0
 */
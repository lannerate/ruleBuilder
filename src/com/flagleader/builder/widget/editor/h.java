package com.flagleader.builder.widget.editor;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.text.presentation.IPresentationDamager;
import org.eclipse.jface.text.presentation.IPresentationRepairer;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.custom.StyleRange;

public class h
  implements IPresentationDamager, IPresentationRepairer
{
  protected IDocument a;
  protected ITokenScanner b;
  protected TextAttribute c;
  m d;

  public h(ITokenScanner paramITokenScanner, m paramm)
  {
    Assert.isNotNull(paramITokenScanner);
    this.b = paramITokenScanner;
    this.d = paramm;
    this.c = new TextAttribute(null);
  }

  public void setDocument(IDocument paramIDocument)
  {
    this.a = paramIDocument;
  }

  protected int a(int paramInt)
  {
    IRegion localIRegion = this.a.getLineInformationOfOffset(paramInt);
    if (paramInt <= localIRegion.getOffset() + localIRegion.getLength())
      return localIRegion.getOffset() + localIRegion.getLength();
    int i = this.a.getLineOfOffset(paramInt);
    try
    {
      localIRegion = this.a.getLineInformation(i + 1);
      return localIRegion.getOffset() + localIRegion.getLength();
    }
    catch (BadLocationException localBadLocationException)
    {
    }
    return this.a.getLength();
  }

  public IRegion getDamageRegion(ITypedRegion paramITypedRegion, DocumentEvent paramDocumentEvent, boolean paramBoolean)
  {
    if (!paramBoolean)
      try
      {
        IRegion localIRegion = this.a.getLineInformationOfOffset(paramDocumentEvent.getOffset());
        int i = Math.max(paramITypedRegion.getOffset(), localIRegion.getOffset());
        int j = paramDocumentEvent.getOffset() + (paramDocumentEvent.getText() == null ? paramDocumentEvent.getLength() : paramDocumentEvent.getText().length());
        if ((localIRegion.getOffset() <= j) && (j <= localIRegion.getOffset() + localIRegion.getLength()))
          j = localIRegion.getOffset() + localIRegion.getLength();
        else
          j = a(j);
        j = Math.min(paramITypedRegion.getOffset() + paramITypedRegion.getLength(), j);
        return new Region(i, j - i);
      }
      catch (BadLocationException localBadLocationException)
      {
      }
    return paramITypedRegion;
  }

  public void createPresentation(TextPresentation paramTextPresentation, ITypedRegion paramITypedRegion)
  {
    if (this.b == null)
    {
      a(paramTextPresentation, paramITypedRegion.getOffset(), paramITypedRegion.getLength(), this.c);
      return;
    }
    int i = paramITypedRegion.getOffset();
    int j = 0;
    int k = 1;
    Object localObject1 = Token.UNDEFINED;
    Object localObject2 = a((IToken)localObject1);
    this.b.setRange(this.a, i, paramITypedRegion.getLength());
    while (true)
    {
      IToken localIToken = this.b.nextToken();
      if (localIToken.isEOF())
        break;
      TextAttribute localTextAttribute = a(localIToken);
      if ((localObject2 != null) && (((TextAttribute)localObject2).equals(localTextAttribute)))
      {
        j += this.b.getTokenLength();
        k = 0;
        continue;
      }
      if (k == 0)
        a(paramTextPresentation, i, j, (TextAttribute)localObject2);
      k = 0;
      localObject1 = localIToken;
      localObject2 = localTextAttribute;
      i = this.b.getTokenOffset();
      j = this.b.getTokenLength();
    }
    if (j > 0)
      a(paramTextPresentation, i, j, (TextAttribute)localObject2);
  }

  protected TextAttribute a(IToken paramIToken)
  {
    Object localObject = paramIToken.getData();
    if ((localObject instanceof TextAttribute))
      return (TextAttribute)localObject;
    return this.c;
  }

  protected void a(TextPresentation paramTextPresentation, int paramInt1, int paramInt2, TextAttribute paramTextAttribute)
  {
    if (paramInt2 < 0)
      return;
    if (paramTextAttribute != null)
    {
      int i = paramTextAttribute.getStyle();
      int j = i & 0x3;
      StyleRange localStyleRange = new StyleRange(paramInt1, paramInt2, paramTextAttribute.getForeground(), paramTextAttribute.getBackground(), j);
      localStyleRange.strikeout = ((i & 0x20000000) != 0);
      localStyleRange.underline = ((i & 0x40000000) != 0);
      paramTextPresentation.addStyleRange(localStyleRange);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.h
 * JD-Core Version:    0.6.0
 */
package com.flagleader.builder.widget.editor.d;

import com.flagleader.builder.widget.editor.m;
import com.ibm.icu.text.BreakIterator;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.swt.graphics.Point;

public class a
  implements ITextDoubleClickStrategy
{
  private b a = new b();

  public void doubleClicked(ITextViewer paramITextViewer)
  {
    int i = paramITextViewer.getSelectedRange().x;
    if (i < 0)
      return;
    try
    {
      IDocument localIDocument = paramITextViewer.getDocument();
      if ((localIDocument instanceof m))
      {
        if (!((m)localIDocument).b(i))
        {
          if (localIDocument.getChar(i - 1) == '{')
          {
            j = i;
            k = j;
            try
            {
              k = a(j, 0, paramITextViewer.getDocument().getLength(), localIDocument);
              paramITextViewer.setSelectedRange(j, k - j);
              return;
            }
            catch (Throwable localThrowable1)
            {
              localThrowable1.printStackTrace();
            }
          }
          else if (localIDocument.getChar(i - 1) == '}')
          {
            try
            {
              k = i;
              j = k;
              j = a(k - 2, 0, localIDocument);
              paramITextViewer.setSelectedRange(j, k - j);
              return;
            }
            catch (Throwable localThrowable2)
            {
              localThrowable2.printStackTrace();
            }
          }
        }
        else if ((((m)localIDocument).a(i)) && (localIDocument.getChar(i - 1) == '<') && (localIDocument.getChar(i) != ' '))
        {
          StringBuffer localStringBuffer = new StringBuffer(localIDocument.get());
          int m = localStringBuffer.indexOf(" ", i);
          if (localStringBuffer.indexOf(">", i) < m)
            m = localStringBuffer.indexOf(">", i);
          if (m > i)
          {
            String str1 = localStringBuffer.substring(i, m);
            int n = 1;
            while (n > 0)
            {
              int i1 = localStringBuffer.indexOf("/" + str1 + ">", m);
              if (i1 > 0)
              {
                n--;
                String str2 = localStringBuffer.substring(m, i1);
                n += a(str2, "<" + str1);
                m = i1 + str1.length() + 2;
              }
              else
              {
                return;
              }
            }
            paramITextViewer.setSelectedRange(i, m - i);
            return;
          }
        }
        if (localIDocument.getChar(i - 1) == '(')
        {
          j = i;
          k = j;
          try
          {
            k = b(j, 0, paramITextViewer.getDocument().getLength(), localIDocument);
            paramITextViewer.setSelectedRange(j, k - j);
            return;
          }
          catch (Throwable localThrowable3)
          {
            localThrowable3.printStackTrace();
          }
        }
        else if (localIDocument.getChar(i - 1) == ')')
        {
          try
          {
            k = i;
            j = k;
            j = b(k - 2, 0, localIDocument);
            paramITextViewer.setSelectedRange(j, k - j);
            return;
          }
          catch (Throwable localThrowable4)
          {
            localThrowable4.printStackTrace();
          }
        }
      }
      IRegion localIRegion = localIDocument.getLineInformationOfOffset(i);
      if (i == localIRegion.getOffset() + localIRegion.getLength())
        return;
      this.a.a(localIDocument, localIRegion);
      BreakIterator localBreakIterator = BreakIterator.getWordInstance();
      localBreakIterator.setText(this.a);
      int j = localBreakIterator.preceding(i);
      if (j == -1)
        j = localIRegion.getOffset();
      int k = localBreakIterator.following(i);
      if (k == -1)
        k = localIRegion.getOffset() + localIRegion.getLength();
      if (localBreakIterator.isBoundary(i))
        if (k - i > i - j)
          j = i;
        else
          k = i;
      if (j != k)
        paramITextViewer.setSelectedRange(j, k - j);
      paramITextViewer.getDocument().setDocumentPartitioner(null);
    }
    catch (BadLocationException localBadLocationException)
    {
    }
  }

  private int a(String paramString1, String paramString2)
  {
    int i = paramString1.indexOf(paramString2);
    int j = 0;
    while (i >= 0)
    {
      j++;
      i = paramString1.indexOf(paramString2, i + paramString2.length());
    }
    return j;
  }

  private int a(int paramInt1, int paramInt2, int paramInt3, IDocument paramIDocument)
  {
    if (paramInt1 >= paramInt3 - 1)
      return paramInt3 - 1;
    if (!((m)paramIDocument).b(paramInt1))
    {
      int i;
      if (paramIDocument.getChar(paramInt1) == '{')
      {
        paramInt1++;
        for (i = paramIDocument.getChar(paramInt1); (i != 123) && (i != 125) && (paramInt1 <= paramInt3 - 1); i = paramIDocument.getChar(paramInt1))
          paramInt1++;
        return a(paramInt1, paramInt2 + 1, paramInt3, paramIDocument);
      }
      if (paramIDocument.getChar(paramInt1) == '}')
      {
        if (paramInt2 < 1)
          return paramInt1;
        paramInt1++;
        for (i = paramIDocument.getChar(paramInt1); (i != 123) && (i != 125) && (paramInt1 <= paramInt3 - 1); i = paramIDocument.getChar(paramInt1))
          paramInt1++;
        return a(paramInt1, paramInt2 - 1, paramInt3, paramIDocument);
      }
    }
    else
    {
      do
      {
        if (paramInt1 > paramInt3 - 1)
          break;
        paramInt1++;
      }
      while (((m)paramIDocument).b(paramInt1));
      paramInt1--;
    }
    return a(paramInt1 + 1, paramInt2, paramInt3, paramIDocument);
  }

  private int a(int paramInt1, int paramInt2, IDocument paramIDocument)
  {
    if (paramInt1 <= 0)
      return paramInt1;
    if (!((m)paramIDocument).b(paramInt1))
    {
      int i;
      if (paramIDocument.getChar(paramInt1) == '}')
      {
        paramInt1--;
        for (i = paramIDocument.getChar(paramInt1); (i != 123) && (i != 125) && (paramInt1 >= 0); i = paramIDocument.getChar(paramInt1))
          paramInt1--;
        return a(paramInt1, paramInt2 + 1, paramIDocument);
      }
      if (paramIDocument.getChar(paramInt1) == '{')
      {
        if (paramInt2 < 1)
          return paramInt1;
        paramInt1--;
        for (i = paramIDocument.getChar(paramInt1); (i != 123) && (i != 125) && (paramInt1 >= 0); i = paramIDocument.getChar(paramInt1))
          paramInt1--;
        return a(paramInt1, paramInt2 - 1, paramIDocument);
      }
    }
    else
    {
      do
      {
        if (paramInt1 <= 0)
          break;
        paramInt1--;
      }
      while (((m)paramIDocument).b(paramInt1));
      paramInt1++;
    }
    return a(paramInt1 - 1, paramInt2, paramIDocument);
  }

  private int b(int paramInt1, int paramInt2, int paramInt3, IDocument paramIDocument)
  {
    if (paramInt1 >= paramInt3 - 1)
      return paramInt3 - 1;
    int i;
    if (paramIDocument.getChar(paramInt1) == '(')
    {
      paramInt1++;
      for (i = paramIDocument.getChar(paramInt1); (i != 40) && (i != 41) && (paramInt1 <= paramInt3 - 1); i = paramIDocument.getChar(paramInt1))
        paramInt1++;
      return b(paramInt1, paramInt2 + 1, paramInt3, paramIDocument);
    }
    if (paramIDocument.getChar(paramInt1) == ')')
    {
      if (paramInt2 < 1)
        return paramInt1;
      paramInt1++;
      for (i = paramIDocument.getChar(paramInt1); (i != 40) && (i != 41) && (paramInt1 <= paramInt3 - 1); i = paramIDocument.getChar(paramInt1))
        paramInt1++;
      return b(paramInt1, paramInt2 - 1, paramInt3, paramIDocument);
    }
    return b(paramInt1 + 1, paramInt2, paramInt3, paramIDocument);
  }

  private int b(int paramInt1, int paramInt2, IDocument paramIDocument)
  {
    if (paramInt1 <= 0)
      return paramInt1;
    int i;
    if (paramIDocument.getChar(paramInt1) == ')')
    {
      paramInt1--;
      for (i = paramIDocument.getChar(paramInt1); (i != 40) && (i != 41) && (paramInt1 >= 0); i = paramIDocument.getChar(paramInt1))
        paramInt1--;
      return b(paramInt1, paramInt2 + 1, paramIDocument);
    }
    if (paramIDocument.getChar(paramInt1) == '(')
    {
      if (paramInt2 < 1)
        return paramInt1;
      paramInt1--;
      for (i = paramIDocument.getChar(paramInt1); (i != 40) && (i != 41) && (paramInt1 >= 0); i = paramIDocument.getChar(paramInt1))
        paramInt1--;
      return b(paramInt1, paramInt2 - 1, paramIDocument);
    }
    return b(paramInt1 - 1, paramInt2, paramIDocument);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.d.a
 * JD-Core Version:    0.6.0
 */
package com.flagleader.builder.widget.editor.g;

import com.flagleader.builder.widget.editor.m;
import com.flagleader.builder.widget.editor.r;
import com.flagleader.builder.widget.editor.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

public class a extends r
{
  public a(s params)
  {
    super(params);
  }

  public char[] getCompletionProposalAutoActivationCharacters()
  {
    return new char[] { '.', '=' };
  }

  public String a(IDocument paramIDocument, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramInt--;
    try
    {
      while (true)
      {
        char c = paramIDocument.getChar(paramInt--);
        if ((Character.isWhitespace(c)) || (d.a(c)))
          break;
        localStringBuffer.append(c);
      }
    }
    catch (BadLocationException localBadLocationException)
    {
    }
    return localStringBuffer.reverse().toString();
  }

  public ICompletionProposal[] computeCompletionProposals(ITextViewer paramITextViewer, int paramInt)
  {
    IDocument localIDocument = paramITextViewer.getDocument();
    List localList = a(a(localIDocument, paramInt), paramInt);
    return (CompletionProposal[])localList.toArray(new CompletionProposal[localList.size()]);
  }

  public List a(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (!this.a.b(paramInt))
    {
      Object localObject1;
      String str1;
      Object localObject2;
      if (paramString.indexOf(".") > 0)
      {
        if (paramString.endsWith("."))
        {
          paramString = paramString.substring(0, paramString.length() - 1);
          localObject1 = this.b.t().a(paramString);
          if (localObject1 != null)
            while (((Iterator)localObject1).hasNext())
            {
              str1 = (String)((Iterator)localObject1).next();
              localObject2 = new CompletionProposal(str1, paramInt, 0, str1.length(), null, null, null, "aaa");
              localArrayList.add(localObject2);
            }
        }
        else
        {
          localObject1 = paramString.substring(0, paramString.lastIndexOf("."));
          str1 = paramString.substring(paramString.lastIndexOf(".") + 1);
          localObject2 = this.b.t().a((String)localObject1);
          if (localObject2 != null)
            while (((Iterator)localObject2).hasNext())
            {
              String str2 = (String)((Iterator)localObject2).next();
              String str3 = str2;
              CompletionProposal localCompletionProposal = new CompletionProposal(str3, paramInt - str1.length(), str1.length(), str3.length(), null, null, null, "aaa");
              if (!str2.toLowerCase().startsWith(str1.toLowerCase()))
                continue;
              localArrayList.add(localCompletionProposal);
            }
        }
      }
      else if (paramString.length() == 0)
      {
        localObject1 = this.b.t().a();
        if (localObject1 != null)
          while (((Iterator)localObject1).hasNext())
          {
            str1 = (String)((Iterator)localObject1).next();
            localObject2 = new CompletionProposal(str1, paramInt - paramString.length(), paramString.length(), str1.length(), null, null, null, "aaa");
            localArrayList.add(localObject2);
          }
      }
      else
      {
        localObject1 = this.b.t().a();
        if (localObject1 != null)
          while (((Iterator)localObject1).hasNext())
          {
            str1 = (String)((Iterator)localObject1).next();
            if (!str1.toLowerCase().startsWith(paramString.toLowerCase()))
              continue;
            localObject2 = new CompletionProposal(str1, paramInt - paramString.length(), paramString.length(), str1.length(), null, null, null, "aaa");
            localArrayList.add(localObject2);
          }
      }
    }
    return (List)(List)localArrayList;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.g.a
 * JD-Core Version:    0.6.0
 */
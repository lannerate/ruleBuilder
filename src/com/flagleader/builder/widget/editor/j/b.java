package com.flagleader.builder.widget.editor.j;

import com.flagleader.builder.widget.editor.r;
import com.flagleader.builder.widget.editor.s;
import com.flagleader.manager.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

public class b extends r
{
  public static final char[] c = { '.', '_', ' ', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

  public b(s params)
  {
    super(params);
  }

  public char[] getCompletionProposalAutoActivationCharacters()
  {
    return new char[] { '<', '/', ' ' };
  }

  public String a(IDocument paramIDocument, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramInt--;
    try
    {
      if (paramIDocument.getChar(paramInt) == ' ')
      {
        while (paramInt >= 0)
          try
          {
            char c1 = paramIDocument.getChar(paramInt--);
            if ((c1 == '\n') || (c1 == '\r'))
              break;
            localStringBuffer.append(c1);
          }
          catch (BadLocationException localBadLocationException1)
          {
            break;
          }
      }
      else
      {
        do
          try
          {
            char c2 = paramIDocument.getChar(paramInt--);
            if ((Character.isWhitespace(c2)) || (c2 == '/') || ((c2 != '<') && (!Character.isJavaIdentifierPart(c2))))
              break;
            localStringBuffer.append(c2);
          }
          catch (BadLocationException localBadLocationException2)
          {
            break;
          }
        while (paramInt >= 0);
        if ((localStringBuffer.indexOf("<") == -1) && (localStringBuffer.indexOf("/") == -1))
        {
          paramInt++;
          while (paramInt >= 0)
            try
            {
              char c3 = paramIDocument.getChar(paramInt--);
              if ((c3 == '\n') || (c3 == '\r'))
                break;
              localStringBuffer.append(c3);
            }
            catch (BadLocationException localBadLocationException3)
            {
              break;
            }
        }
      }
    }
    catch (Exception localException)
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
    Object localObject1;
    String str1;
    Object localObject2;
    String str2;
    Object localObject3;
    if (paramString.indexOf("<") > 0)
    {
      if (paramString.endsWith(" "))
      {
        localObject1 = this.b.t().a_(paramString);
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
        localObject1 = paramString.substring(0, paramString.lastIndexOf(" "));
        str1 = paramString.substring(paramString.lastIndexOf(" ") + 1);
        localObject2 = this.b.t().a_((String)localObject1);
        if (localObject2 != null)
          while (((Iterator)localObject2).hasNext())
          {
            str2 = (String)((Iterator)localObject2).next();
            localObject3 = new CompletionProposal(str2, paramInt - str1.length(), str1.length(), str2.length(), null, null, null, "aaa");
            if (!str2.toLowerCase().startsWith(str1.toLowerCase()))
              continue;
            localArrayList.add(localObject3);
          }
      }
    }
    else if (paramString.indexOf(" ") > 0)
    {
      if (paramString.endsWith(" "))
      {
        paramString = paramString.substring(0, paramString.length() - 1);
        localObject1 = this.b.t().a(paramString);
        if (localObject1 != null)
          while (((Iterator)localObject1).hasNext())
          {
            str1 = ((Iterator)localObject1).next().toString();
            localObject2 = new CompletionProposal(str1, paramInt - paramString.length() - 1, paramString.length() + 1, str1.length(), null, null, null, "aaa");
            localArrayList.add(localObject2);
          }
      }
      else
      {
        localObject1 = paramString.substring(0, paramString.lastIndexOf(" "));
        str1 = paramString.substring(paramString.lastIndexOf(" ") + 1);
        localObject2 = this.b.t().a((String)localObject1);
        if (localObject2 != null)
          while (((Iterator)localObject2).hasNext())
          {
            str2 = (String)((Iterator)localObject2).next();
            localObject3 = str2;
            CompletionProposal localCompletionProposal = new CompletionProposal((String)localObject3, paramInt - paramString.length(), paramString.length(), ((String)localObject3).length(), null, null, null, "aaa");
            if (!str2.toLowerCase().startsWith(str1.toLowerCase()))
              continue;
            localArrayList.add(localCompletionProposal);
          }
      }
    }
    else if (paramString.indexOf("/") > 0)
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
    return (List)(List)(List)localArrayList;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.j.b
 * JD-Core Version:    0.6.0
 */
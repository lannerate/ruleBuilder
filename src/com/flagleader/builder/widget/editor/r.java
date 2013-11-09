package com.flagleader.builder.widget.editor;

import com.flagleader.manager.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

public class r
  implements IContentAssistProcessor
{
  protected m a;
  protected s b;

  public r(s params)
  {
    this.b = params;
    this.a = params.m();
  }

  public ICompletionProposal[] computeCompletionProposals(ITextViewer paramITextViewer, int paramInt)
  {
    IDocument localIDocument = paramITextViewer.getDocument();
    List localList = a(a(localIDocument, paramInt), paramInt);
    return (CompletionProposal[])localList.toArray(new CompletionProposal[localList.size()]);
  }

  public IContextInformation[] computeContextInformation(ITextViewer paramITextViewer, int paramInt)
  {
    return null;
  }

  public char[] getCompletionProposalAutoActivationCharacters()
  {
    return new char[] { '.' };
  }

  public char[] getContextInformationAutoActivationCharacters()
  {
    return null;
  }

  public String getErrorMessage()
  {
    return null;
  }

  public IContextInformationValidator getContextInformationValidator()
  {
    return null;
  }

  public String a(IDocument paramIDocument, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramInt--;
    try
    {
      while (true)
      {
        paramInt--;
        char c = paramIDocument.getChar(paramInt);
        if ((Character.isWhitespace(c)) || ((c != '.') && (!Character.isJavaIdentifierPart(c))))
          break;
        localStringBuffer.append(c);
      }
    }
    catch (BadLocationException localBadLocationException)
    {
    }
    return localStringBuffer.reverse().toString();
  }

  public List a(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (!this.a.b(paramInt))
    {
      Iterator localIterator = this.b.t().a();
      String str;
      if (localIterator != null)
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if (!paramString.equals(str))
            continue;
          i = 1;
          break;
        }
      if (i != 0)
      {
        localIterator = this.b.t().a(paramString);
        while (localIterator.hasNext())
        {
          str = paramString + "." + localIterator.next();
          CompletionProposal localCompletionProposal = new CompletionProposal(str, paramInt - paramString.length() - 1, paramString.length() + 1, str.length(), null, null, null, "aaa");
          localArrayList.add(localCompletionProposal);
        }
      }
    }
    return localArrayList;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.r
 * JD-Core Version:    0.6.0
 */
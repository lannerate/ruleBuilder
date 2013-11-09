package com.flagleader.builder.widget.editor;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPositionCategoryException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.DocumentPartitioningChangedEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IDocumentPartitioningListener;
import org.eclipse.jface.text.IDocumentPartitioningListenerExtension;
import org.eclipse.jface.text.IDocumentPartitioningListenerExtension2;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextInputListener;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.ITextViewerExtension5;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.TypedPosition;

class l
  implements IDocumentListener, IDocumentPartitioningListener, IDocumentPartitioningListenerExtension, IDocumentPartitioningListenerExtension2, ITextInputListener, ITextListener
{
  private boolean b = false;
  private boolean c = true;

  l(k paramk)
  {
  }

  public void inputDocumentAboutToBeChanged(IDocument paramIDocument1, IDocument paramIDocument2)
  {
    if (paramIDocument1 != null)
      try
      {
        k.a(this.a).removeTextListener(this);
        paramIDocument1.removeDocumentListener(this);
        paramIDocument1.removeDocumentPartitioningListener(this);
        paramIDocument1.removePositionUpdater(k.b(this.a));
        paramIDocument1.removePositionCategory(k.c(this.a));
      }
      catch (BadPositionCategoryException localBadPositionCategoryException)
      {
      }
  }

  public void inputDocumentChanged(IDocument paramIDocument1, IDocument paramIDocument2)
  {
    this.b = false;
    this.c = true;
    if (paramIDocument2 != null)
    {
      paramIDocument2.addPositionCategory(k.c(this.a));
      paramIDocument2.addPositionUpdater(k.b(this.a));
      paramIDocument2.addDocumentPartitioningListener(this);
      paramIDocument2.addDocumentListener(this);
      k.a(this.a).addTextListener(this);
      this.a.a(paramIDocument2);
      this.a.b(paramIDocument2);
      k.a(this.a, new Region(0, paramIDocument2.getLength()), paramIDocument2);
    }
  }

  public void documentPartitioningChanged(IDocument paramIDocument)
  {
    if ((!this.b) && (this.c))
      k.a(this.a, new Region(0, paramIDocument.getLength()), paramIDocument);
    else
      k.a(this.a, true);
  }

  public void documentPartitioningChanged(IDocument paramIDocument, IRegion paramIRegion)
  {
    if ((!this.b) && (this.c))
    {
      k.a(this.a, new Region(paramIRegion.getOffset(), paramIRegion.getLength()), paramIDocument);
    }
    else
    {
      k.a(this.a, true);
      k.a(this.a, paramIRegion);
    }
  }

  public void documentPartitioningChanged(DocumentPartitioningChangedEvent paramDocumentPartitioningChangedEvent)
  {
    IRegion localIRegion = paramDocumentPartitioningChangedEvent.getChangedRegion(this.a.getDocumentPartitioning());
    if (localIRegion != null)
      documentPartitioningChanged(paramDocumentPartitioningChangedEvent.getDocument(), localIRegion);
  }

  public void documentAboutToBeChanged(DocumentEvent paramDocumentEvent)
  {
    this.b = true;
    if (this.c)
      try
      {
        int i = paramDocumentEvent.getOffset() + paramDocumentEvent.getLength();
        ITypedRegion localITypedRegion = k.a(this.a, paramDocumentEvent.getDocument(), i);
        k.a(this.a, new TypedPosition(localITypedRegion));
        paramDocumentEvent.getDocument().addPosition(k.c(this.a), k.d(this.a));
      }
      catch (BadLocationException localBadLocationException)
      {
      }
      catch (BadPositionCategoryException localBadPositionCategoryException)
      {
      }
  }

  public void documentChanged(DocumentEvent paramDocumentEvent)
  {
    if (this.c)
      try
      {
        paramDocumentEvent.getDocument().removePosition(k.c(this.a), k.d(this.a));
      }
      catch (BadPositionCategoryException localBadPositionCategoryException)
      {
      }
    this.b = false;
  }

  public void textChanged(TextEvent paramTextEvent)
  {
    this.c = paramTextEvent.getViewerRedrawState();
    if (!this.c)
      return;
    Object localObject1 = null;
    IDocument localIDocument = null;
    Object localObject2;
    if (paramTextEvent.getDocumentEvent() == null)
    {
      localIDocument = k.a(this.a).getDocument();
      if (localIDocument != null)
        if ((paramTextEvent.getOffset() == 0) && (paramTextEvent.getLength() == 0) && (paramTextEvent.getText() == null))
        {
          localObject1 = new Region(0, localIDocument.getLength());
        }
        else
        {
          localObject2 = a(paramTextEvent);
          try
          {
            String str = localIDocument.get(((IRegion)localObject2).getOffset(), ((IRegion)localObject2).getLength());
            DocumentEvent localDocumentEvent = new DocumentEvent(localIDocument, ((IRegion)localObject2).getOffset(), ((IRegion)localObject2).getLength(), str);
            localObject1 = k.a(this.a, localDocumentEvent, false);
          }
          catch (BadLocationException localBadLocationException)
          {
          }
        }
    }
    else
    {
      localObject2 = paramTextEvent.getDocumentEvent();
      localIDocument = ((DocumentEvent)localObject2).getDocument();
      localObject1 = k.a(this.a, (DocumentEvent)localObject2, true);
    }
    if ((localObject1 != null) && (localIDocument != null))
      k.a(this.a, (IRegion)localObject1, localIDocument);
    k.a(this.a, false);
    k.a(this.a, null);
  }

  protected IRegion a(TextEvent paramTextEvent)
  {
    String str = paramTextEvent.getText();
    int i = str == null ? 0 : str.length();
    if ((k.a(this.a) instanceof ITextViewerExtension5))
    {
      localObject = (ITextViewerExtension5)k.a(this.a);
      return ((ITextViewerExtension5)localObject).widgetRange2ModelRange(new Region(paramTextEvent.getOffset(), i));
    }
    Object localObject = k.a(this.a).getVisibleRegion();
    Region localRegion = new Region(paramTextEvent.getOffset() + ((IRegion)localObject).getOffset(), i);
    return (IRegion)localRegion;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.l
 * JD-Core Version:    0.6.0
 */
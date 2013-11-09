package com.flagleader.builder.widget.editor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DefaultPositionUpdater;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IPositionUpdater;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.jface.text.TypedPosition;
import org.eclipse.jface.text.presentation.IPresentationDamager;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.IPresentationReconcilerExtension;
import org.eclipse.jface.text.presentation.IPresentationRepairer;
import org.eclipse.swt.custom.StyleRange;

public class k
  implements IPresentationReconciler, IPresentationReconcilerExtension
{
  protected static final String a = "__reconciler_tracked_partition";
  private Map b;
  private Map c;
  private ITextViewer d;
  private l e = new l(this);
  private String f = "__reconciler_tracked_partition" + hashCode();
  private IPositionUpdater g = new DefaultPositionUpdater(this.f);
  private TypedPosition h;
  private boolean i = false;
  private IRegion j = null;
  private String k = "__dftl_partitioning";

  public void a(String paramString)
  {
    Assert.isNotNull(paramString);
    this.k = paramString;
  }

  public String getDocumentPartitioning()
  {
    return this.k;
  }

  public void a(IPresentationDamager paramIPresentationDamager, String paramString)
  {
    Assert.isNotNull(paramString);
    if (this.b == null)
      this.b = new HashMap();
    if (paramIPresentationDamager == null)
      this.b.remove(paramString);
    else
      this.b.put(paramString, paramIPresentationDamager);
  }

  public void a(IPresentationRepairer paramIPresentationRepairer, String paramString)
  {
    Assert.isNotNull(paramString);
    if (this.c == null)
      this.c = new HashMap();
    if (paramIPresentationRepairer == null)
      this.c.remove(paramString);
    else
      this.c.put(paramString, paramIPresentationRepairer);
  }

  public void install(ITextViewer paramITextViewer)
  {
    Assert.isNotNull(paramITextViewer);
    this.d = paramITextViewer;
    this.d.addTextInputListener(this.e);
    IDocument localIDocument = paramITextViewer.getDocument();
    if (localIDocument != null)
      this.e.inputDocumentChanged(null, localIDocument);
  }

  public void uninstall()
  {
    this.d.removeTextInputListener(this.e);
    this.e.inputDocumentAboutToBeChanged(this.d.getDocument(), null);
  }

  public IPresentationDamager getDamager(String paramString)
  {
    if (this.b == null)
      return null;
    return (IPresentationDamager)this.b.get(paramString);
  }

  public IPresentationRepairer getRepairer(String paramString)
  {
    if (this.c == null)
      return null;
    return (IPresentationRepairer)this.c.get(paramString);
  }

  protected void a(IDocument paramIDocument)
  {
    if (this.b != null)
    {
      Iterator localIterator = this.b.values().iterator();
      while (localIterator.hasNext())
      {
        IPresentationDamager localIPresentationDamager = (IPresentationDamager)localIterator.next();
        localIPresentationDamager.setDocument(paramIDocument);
      }
    }
  }

  protected void b(IDocument paramIDocument)
  {
    if (this.c != null)
    {
      Iterator localIterator = this.c.values().iterator();
      while (localIterator.hasNext())
      {
        IPresentationRepairer localIPresentationRepairer = (IPresentationRepairer)localIterator.next();
        localIPresentationRepairer.setDocument(paramIDocument);
      }
    }
  }

  protected TextPresentation a(IRegion paramIRegion, IDocument paramIDocument)
  {
    try
    {
      if ((this.c == null) || (this.c.isEmpty()))
      {
        localTextPresentation = new TextPresentation(paramIRegion, 1);
        localTextPresentation.setDefaultStyleRange(new StyleRange(paramIRegion.getOffset(), paramIRegion.getLength(), null, null));
        return localTextPresentation;
      }
      TextPresentation localTextPresentation = new TextPresentation(paramIRegion, 1000);
      ITypedRegion[] arrayOfITypedRegion = TextUtilities.computePartitioning(paramIDocument, getDocumentPartitioning(), paramIRegion.getOffset(), paramIRegion.getLength(), false);
      for (int m = 0; m < arrayOfITypedRegion.length; m++)
      {
        ITypedRegion localITypedRegion = arrayOfITypedRegion[m];
        IPresentationRepairer localIPresentationRepairer = getRepairer(localITypedRegion.getType());
        if (localIPresentationRepairer == null)
          continue;
        localIPresentationRepairer.createPresentation(localTextPresentation, localITypedRegion);
      }
      return localTextPresentation;
    }
    catch (BadLocationException localBadLocationException)
    {
    }
    return null;
  }

  private IRegion a(DocumentEvent paramDocumentEvent, boolean paramBoolean)
  {
    int m = paramDocumentEvent.getText() == null ? 0 : paramDocumentEvent.getText().length();
    if ((this.b == null) || (this.b.isEmpty()))
    {
      m = Math.max(paramDocumentEvent.getLength(), m);
      m = Math.min(paramDocumentEvent.getDocument().getLength() - paramDocumentEvent.getOffset(), m);
      return new Region(paramDocumentEvent.getOffset(), m);
    }
    int n = m == 0 ? 1 : 0;
    Object localObject = null;
    try
    {
      int i1 = paramDocumentEvent.getOffset();
      if (n != 0)
        i1 = Math.max(0, i1 - 1);
      ITypedRegion localITypedRegion = a(paramDocumentEvent.getDocument(), i1);
      IPresentationDamager localIPresentationDamager = getDamager(localITypedRegion.getType());
      if (localIPresentationDamager == null)
        return null;
      IRegion localIRegion = localIPresentationDamager.getDamageRegion(localITypedRegion, paramDocumentEvent, this.i);
      if ((!this.i) && (paramBoolean) && (n == 0))
      {
        localObject = localIRegion;
      }
      else
      {
        int i2 = a(paramDocumentEvent);
        int i3 = -1;
        if (this.j != null)
          i3 = this.j.getOffset() + this.j.getLength();
        int i4 = Math.max(i2, i3);
        localObject = i4 == -1 ? localIRegion : new Region(localIRegion.getOffset(), i4 - localIRegion.getOffset());
      }
    }
    catch (BadLocationException localBadLocationException)
    {
    }
    return (IRegion)localObject;
  }

  private int a(DocumentEvent paramDocumentEvent)
  {
    IDocument localIDocument = paramDocumentEvent.getDocument();
    int m = 0;
    if (paramDocumentEvent.getText() != null)
    {
      m = paramDocumentEvent.getText().length();
      if (m > 0)
        m--;
    }
    ITypedRegion localITypedRegion = a(localIDocument, paramDocumentEvent.getOffset() + m);
    int n = localITypedRegion.getOffset() + localITypedRegion.getLength();
    if (n == paramDocumentEvent.getOffset())
      return -1;
    int i1 = this.h == null ? -1 : this.h.getOffset() + this.h.getLength();
    if ((n < i1) && (i1 < localIDocument.getLength()))
      localITypedRegion = a(localIDocument, i1);
    IPresentationDamager localIPresentationDamager = getDamager(localITypedRegion.getType());
    if (localIPresentationDamager == null)
      return -1;
    IRegion localIRegion = localIPresentationDamager.getDamageRegion(localITypedRegion, paramDocumentEvent, this.i);
    return localIRegion.getOffset() + localIRegion.getLength();
  }

  private void b(IRegion paramIRegion, IDocument paramIDocument)
  {
    if ((paramIRegion != null) && (paramIRegion.getLength() > 0))
    {
      TextPresentation localTextPresentation = a(paramIRegion, paramIDocument);
      if (localTextPresentation != null)
        a(localTextPresentation);
    }
  }

  private void a(TextPresentation paramTextPresentation)
  {
    this.d.changeTextPresentation(paramTextPresentation, false);
  }

  private ITypedRegion a(IDocument paramIDocument, int paramInt)
  {
    return TextUtilities.getPartition(paramIDocument, getDocumentPartitioning(), paramInt, false);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.k
 * JD-Core Version:    0.6.0
 */
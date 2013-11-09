package com.flagleader.builder.widget.editor;

import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class g extends SourceViewerConfiguration
{
  private s a;
  private k b = new k();
  private e c;

  public g(s params)
  {
    this.a = params;
    this.c = params.i();
  }

  public IPresentationReconciler getPresentationReconciler(ISourceViewer paramISourceViewer)
  {
    h localh = new h(this.c, this.a.m());
    this.b.a(localh, "__dftl_partition_content_type");
    this.b.a(localh, "__dftl_partition_content_type");
    return this.b;
  }

  public IContentAssistant getContentAssistant(ISourceViewer paramISourceViewer)
  {
    ContentAssistant localContentAssistant = new ContentAssistant();
    localContentAssistant.setContentAssistProcessor(this.a.j(), "__dftl_partition_content_type");
    localContentAssistant.enableAutoActivation(true);
    localContentAssistant.setAutoActivationDelay(100);
    return localContentAssistant;
  }

  public ITextDoubleClickStrategy getDoubleClickStrategy(ISourceViewer paramISourceViewer, String paramString)
  {
    return this.a.k();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.g
 * JD-Core Version:    0.6.0
 */
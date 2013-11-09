package com.flagleader.builder.a.a;

import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.db.ViewModel;
import org.eclipse.swt.widgets.Composite;

public class ax extends B
  implements IElementViewer
{
  private static final String q = "columns.ViewFieldView";

  public ax(ViewModel paramViewModel, Composite paramComposite, bu parambu)
  {
    super(paramViewModel, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new ax((ViewModel)this.c, paramComposite, this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.ax
 * JD-Core Version:    0.6.0
 */
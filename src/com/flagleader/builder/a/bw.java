package com.flagleader.builder.a;

import com.flagleader.repository.IElementViewer;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Control;

class bw extends SelectionAdapter
{
  bw(bu parambu)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (bu.e(this.a).getSelectionIndex() == 0)
    {
      if ((bu.f(this.a) != null) && (!bu.f(this.a).isDisposed()) && (bu.f(this.a).getControl() != null) && ((bu.f(this.a).getControl().getData() instanceof IElementViewer)))
        ((IElementViewer)bu.f(this.a).getControl().getData()).update();
    }
    else if (bu.e(this.a).getSelectionIndex() == 1)
    {
      if ((bu.g(this.a) != null) && (!bu.g(this.a).isDisposed()) && (bu.g(this.a).getControl() != null) && ((bu.g(this.a).getControl().getData() instanceof IElementViewer)))
        ((IElementViewer)bu.g(this.a).getControl().getData()).update();
    }
    else if ((bu.e(this.a).getSelectionIndex() == 2) && (bu.h(this.a) != null) && (!bu.h(this.a).isDisposed()) && (bu.h(this.a).getControl() != null) && ((bu.h(this.a).getControl().getData() instanceof IElementViewer)))
      ((IElementViewer)bu.h(this.a).getControl().getData()).update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.bw
 * JD-Core Version:    0.6.0
 */
package com.flagleader.builder.a;

import com.flagleader.repository.IElementViewer;
import java.util.HashMap;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Control;

class bv extends SelectionAdapter
{
  bv(bu parambu)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if ((bu.a(this.a) == null) || (bu.a(this.a).getSelection() == null) || (bu.a(this.a).getSelection().getControl() == null) || (bu.a(this.a).getSelection().getControl().isDisposed()) || (bu.b(this.a)))
      return;
    Object localObject = bu.a(this.a).getSelection().getControl().getData();
    int i;
    try
    {
      if ((localObject != null) && ((localObject instanceof IElementViewer)) && (((IElementViewer)localObject).needUpdate()))
        ((IElementViewer)localObject).update();
      bu.c(this.a).put(bu.a(this.a).getSelection().getData(), new Integer(bu.a(this.a).getSelectionIndex()));
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      i = 0;
    }
    do
    {
      this.a.f();
      i++;
    }
    while (i < 20);
    bu.d(this.a);
    this.a.notifyObservers();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.bv
 * JD-Core Version:    0.6.0
 */
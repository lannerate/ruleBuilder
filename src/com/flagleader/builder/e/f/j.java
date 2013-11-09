package com.flagleader.builder.e.f;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.TableItem;

class j extends FocusAdapter
{
  j(h paramh, CCombo paramCCombo, TableItem paramTableItem)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    if (this.b.getSelectionIndex() >= 0)
    {
      Object localObject = this.c.getData();
      h.c(this.a).put(h.d(this.a).get(this.b.getSelectionIndex()), localObject);
      this.a.a.put(localObject, h.d(this.a).get(this.b.getSelectionIndex()));
      this.c.setText(3, h.a(this.a, h.d(this.a).get(this.b.getSelectionIndex())));
    }
    this.b.dispose();
    h.e(this.a).setEditor(null, null, -1);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.f.j
 * JD-Core Version:    0.6.0
 */
package com.flagleader.builder.dialogs;

import com.flagleader.manager.d.b;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;

class G extends SelectionAdapter
{
  G(z paramz)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (z.f(this.a).getSelection())
      b.a().h(true);
    else
      b.a().h(false);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.G
 * JD-Core Version:    0.6.0
 */
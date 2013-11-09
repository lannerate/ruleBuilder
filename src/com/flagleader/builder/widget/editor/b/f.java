package com.flagleader.builder.widget.editor.b;

import com.flagleader.builder.widget.editor.j;
import com.flagleader.builder.widget.editor.s;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;

class f extends SelectionAdapter
{
  f(b paramb, Text paramText)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    b.a(this.a).o().a(b.b(this.a), this.b.getText());
    b.a(this.a, false);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.b.f
 * JD-Core Version:    0.6.0
 */
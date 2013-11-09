package com.flagleader.builder.widget.editor.b;

import com.flagleader.builder.widget.editor.j;
import com.flagleader.builder.widget.editor.s;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

class e extends SelectionAdapter
{
  e(b paramb, Text paramText, Button paramButton1, Button paramButton2, Button paramButton3, Button paramButton4)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    boolean bool = b.a(this.a).o().a(b.b(this.a), this.b.getText(), this.c.getSelection(), this.d.getSelection(), this.e.getSelection(), this.f.getSelection());
    b.a(this.a, bool);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.b.e
 * JD-Core Version:    0.6.0
 */
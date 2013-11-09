package com.flagleader.builder.widget.editor.b;

import com.flagleader.builder.widget.editor.j;
import com.flagleader.builder.widget.editor.s;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

class g extends SelectionAdapter
{
  g(b paramb, Text paramText1, Text paramText2, Button paramButton1, Button paramButton2, Button paramButton3, Button paramButton4)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    b.a(this.a).o().a(b.b(this.a), this.b.getText());
    boolean bool = b.a(this.a).o().a(b.b(this.a), this.c.getText(), this.d.getSelection(), this.e.getSelection(), this.f.getSelection(), this.g.getSelection());
    b.a(this.a, bool);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.b.g
 * JD-Core Version:    0.6.0
 */
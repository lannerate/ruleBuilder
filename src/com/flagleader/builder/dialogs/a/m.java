package com.flagleader.builder.dialogs.a;

import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class m extends KeyAdapter
{
  m(l paraml)
  {
  }

  public void keyPressed(KeyEvent paramKeyEvent)
  {
    if (!Character.isDefined(paramKeyEvent.character))
      paramKeyEvent.doit = false;
    if ((paramKeyEvent.keyCode == 16777218) && (l.a(this.a).getSelectionIndex() < l.a(this.a).getItemCount() - 1))
    {
      l.a(this.a).select(l.a(this.a).getSelectionIndex() + 1);
      l.a(this.a).forceFocus();
      l.b(this.a).setText(l.a(this.a).getSelection()[0].getText(0));
    }
    if ((paramKeyEvent.keyCode == 16777217) && (l.a(this.a).getSelectionIndex() > 1))
    {
      l.a(this.a).select(l.a(this.a).getSelectionIndex() - 1);
      l.a(this.a).forceFocus();
      l.b(this.a).setText(l.a(this.a).getSelection()[0].getText(0));
    }
    super.keyPressed(paramKeyEvent);
  }

  public void keyReleased(KeyEvent paramKeyEvent)
  {
    if (Character.isDefined(paramKeyEvent.character))
      l.a(this.a, l.b(this.a).getText());
    super.keyReleased(paramKeyEvent);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.a.m
 * JD-Core Version:    0.6.0
 */
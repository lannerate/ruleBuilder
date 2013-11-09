package com.flagleader.builder.actions;

import com.flagleader.builder.widget.d;
import com.flagleader.repository.IElement;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;

class aw extends SelectionAdapter
{
  aw(av paramav, IElement paramIElement)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    new Clipboard(Display.getCurrent()).setContents(new Object[] { this.b }, new Transfer[] { d.a() });
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.aw
 * JD-Core Version:    0.6.0
 */
package com.flagleader.builder.a;

import com.flagleader.builder.widget.editor.p;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;

class aQ extends FocusAdapter
{
  aQ(aP paramaP)
  {
  }

  public void focusGained(FocusEvent paramFocusEvent)
  {
    this.a.setChanged();
    this.a.notifyObservers();
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    this.a.a(this.a.e.a().getText());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.aQ
 * JD-Core Version:    0.6.0
 */
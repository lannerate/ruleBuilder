package com.flagleader.builder.a.f;

import com.flagleader.repository.tree.DecisionRule;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class aP extends FocusAdapter
{
  aP(aO paramaO, TableItem paramTableItem, int paramInt)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    if ((!this.b.isDisposed()) && (!aN.e(aO.a(this.a)).isDisposed()) && (!this.b.getText(this.c).equals(aN.e(aO.a(this.a)).getText())) && (this.b.getData("y") != null))
    {
      aN.b(aO.a(this.a)).addDecisionValue(this.c - 1, ((Integer)this.b.getData("y")).intValue(), aN.e(aO.a(this.a)).getText());
      this.b.setText(this.c, aN.e(aO.a(this.a)).getText());
    }
    aN.g(aO.a(this.a));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.aP
 * JD-Core Version:    0.6.0
 */
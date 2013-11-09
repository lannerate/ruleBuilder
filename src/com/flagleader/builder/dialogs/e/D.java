package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISelectRulePackageEditen;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.Text;

class D extends FocusAdapter
{
  D(C paramC)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    if (!C.a(this.a).getExeRuleName().equals(C.b(this.a).getText()))
    {
      C.a(this.a).setExeRuleName(C.b(this.a).getText());
      C.a(this.a).setSourceSheet(null);
      C.a(this.a, true);
      C.a(this.a, false);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.D
 * JD-Core Version:    0.6.0
 */
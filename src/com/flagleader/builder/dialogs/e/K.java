package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.r;
import com.flagleader.repository.rlm.editen.ISelectRulePackageEditen;
import com.flagleader.repository.tree.IRuleClass;
import java.util.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;

class K extends SelectionAdapter
{
  K(C paramC)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    X localX = new X(C.c(this.a), C.a(this.a).getSourceSheet(), C.c(this.a).getRulesManager().d());
    if (localX.open() == 0)
    {
      List localList = localX.a();
      if (localList.size() > 0)
      {
        C.a(this.a).setSourceSheet((IRuleClass)localList.get(0));
        C.b(this.a).setText(C.a(this.a).getExeRuleName());
        C.d(this.a).setText(C.a(this.a).getExeRuleDisplay());
        C.a(this.a, true);
        C.a(this.a, false);
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.K
 * JD-Core Version:    0.6.0
 */
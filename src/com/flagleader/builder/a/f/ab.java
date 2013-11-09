package com.flagleader.builder.a.f;

import com.flagleader.repository.tree.DecisionRelateRule;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.util.List;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class ab extends FocusAdapter
{
  ab(Y paramY, TableItem paramTableItem, String paramString, int paramInt)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    if ((!this.b.isDisposed()) && (!X.e(Y.a(this.a)).isDisposed()))
    {
      String str = X.e(Y.a(this.a)).getText();
      str = StringUtil.replace(FileUtil.newline, "\\n", str);
      if (str.trim().length() > 0)
        str = str.trim();
      if (str.endsWith("\\n"))
        str = str.substring(0, str.length() - 2);
      if ((!this.c.equals(str)) && (this.b.getData("conditions") != null) && (X.b(Y.a(this.a)).addDecisionValue((List)this.b.getData("conditions"), this.d - X.b(Y.a(this.a)).getConditionNum(), str)))
      {
        this.b.setText(this.d, str);
        X.b(Y.a(this.a)).setModified(true);
      }
    }
    X.g(Y.a(this.a));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.ab
 * JD-Core Version:    0.6.0
 */
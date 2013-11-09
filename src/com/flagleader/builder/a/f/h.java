package com.flagleader.builder.a.f;

import com.flagleader.repository.tree.DecisionMultiRule;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.util.List;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class h
  implements TraverseListener
{
  h(a parama, TableItem paramTableItem, String paramString, int paramInt)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((paramTraverseEvent.detail == 16) || (paramTraverseEvent.detail == 4))
    {
      if ((!this.b.isDisposed()) && (!a.e(this.a).isDisposed()))
      {
        String str = a.e(this.a).getText();
        str = StringUtil.replace(FileUtil.newline, "\\n", str);
        if (str.trim().length() > 0)
          str = str.trim();
        if (str.endsWith("\\n"))
          str = str.substring(0, str.length() - 2);
        if ((!this.c.equals(str)) && (this.b.getData("conditions") != null) && (a.b(this.a).addDecisionValue((List)this.b.getData("conditions"), this.d - a.b(this.a).getConditionNum(), str)))
        {
          this.b.setText(this.d, str);
          a.b(this.a).setModified(true);
        }
      }
      a.g(this.a);
    }
    if (paramTraverseEvent.detail == 2)
      a.g(this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.h
 * JD-Core Version:    0.6.0
 */
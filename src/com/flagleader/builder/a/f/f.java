package com.flagleader.builder.a.f;

import com.flagleader.repository.rlm.value.ConstantToken;
import com.flagleader.repository.tree.DecisionMultiRule;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class f
  implements TraverseListener
{
  f(b paramb, TableItem paramTableItem, ConstantToken paramConstantToken, int paramInt)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((paramTraverseEvent.detail == 16) || (paramTraverseEvent.detail == 4))
    {
      if ((!this.b.isDisposed()) && (!a.e(b.a(this.a)).isDisposed()))
      {
        String str = a.e(b.a(this.a)).getText();
        str = StringUtil.replace(FileUtil.newline, "\\n", str);
        if (str.trim().length() > 0)
          str = str.trim();
        if (str.endsWith("\\n"))
          str = str.substring(0, str.length() - 2);
        if ((!this.c.getValue().equals(str)) && (this.b.getData(this.d) != null) && (this.c.checkValue(str)))
        {
          this.c.setValue(str);
          a.b(b.a(this.a)).setModified(true);
          b.a(this.a).update();
        }
      }
      a.g(b.a(this.a));
    }
    if (paramTraverseEvent.detail == 2)
      a.g(b.a(this.a));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.f
 * JD-Core Version:    0.6.0
 */
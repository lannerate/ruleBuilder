package com.flagleader.builder.shell;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.M;
import com.flagleader.builder.dialogs.n;
import com.flagleader.engine.IRuleLog;
import com.flagleader.manager.builder.d;
import java.util.ArrayList;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

class eL extends MouseAdapter
{
  eL(RuleTraceViewer paramRuleTraceViewer)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    TreeItem localTreeItem = RuleTraceViewer.f(this.a).getItem(localPoint);
    if (localTreeItem == null)
      return;
    int i = -1;
    for (int j = 0; j < RuleTraceViewer.f(this.a).getColumnCount() + 1; j++)
    {
      if (!localTreeItem.getBounds(j).contains(localPoint))
        continue;
      i = j;
    }
    if ((i == 0) && (RuleTraceViewer.d(this.a) != null) && ((localTreeItem.getData() instanceof IRuleLog)))
    {
      RuleTraceViewer.d(this.a).getProjectTree().b(((IRuleLog)localTreeItem.getData()).getRuleName());
    }
    else
    {
      Object localObject1;
      Object localObject2;
      if (i == 1)
      {
        localObject1 = localTreeItem.getText(i);
        if ((localObject1 != null) && (((String)localObject1).length() > 0))
        {
          localObject2 = new M((String)localObject1, 0, 1);
          ((M)localObject2).open();
        }
      }
      else if ((localTreeItem.getData() instanceof IRuleLog))
      {
        localObject1 = (IRuleLog)localTreeItem.getData();
        localObject2 = ((IRuleLog)localObject1).getFieldNames();
        if (localObject2.length > 0)
        {
          ArrayList localArrayList1 = new ArrayList();
          for (int k = 0; (localObject2 != null) && (k < localObject2.length); k++)
          {
            ArrayList localArrayList2 = new ArrayList(1);
            localArrayList2.add(localObject2[k]);
            localArrayList2.add(((IRuleLog)localObject1).getInitValue(localObject2[k]));
            localArrayList2.add(((IRuleLog)localObject1).getResultValue(localObject2[k]));
            localArrayList1.add(localArrayList2);
          }
          n localn = new n(localArrayList1, 0, 1);
          localn.open();
        }
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.eL
 * JD-Core Version:    0.6.0
 */
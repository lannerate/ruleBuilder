package com.flagleader.builder.a.f;

import com.flagleader.repository.tree.RuleFlowActivitie;
import com.flagleader.repository.tree.RuleTreeFlow;
import java.util.List;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphNode;

class cH extends FocusAdapter
{
  cH(cG paramcG)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    for (int i = 0; i < cG.b(this.a).getNodes().size(); i++)
    {
      Object localObject = cG.b(this.a).getNodes().get(i);
      if ((!(localObject instanceof GraphNode)) || (((GraphNode)localObject).getData() == null))
        continue;
      RuleFlowActivitie localRuleFlowActivitie = (RuleFlowActivitie)((GraphNode)localObject).getData();
      if ((localRuleFlowActivitie.getX() == ((GraphNode)localObject).getLocation().x) && (localRuleFlowActivitie.getY() == ((GraphNode)localObject).getLocation().y))
        continue;
      localRuleFlowActivitie.setX(((GraphNode)localObject).getLocation().x);
      localRuleFlowActivitie.setY(((GraphNode)localObject).getLocation().y);
      cG.c(this.a).setModified(true);
    }
    super.focusLost(paramFocusEvent);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.cH
 * JD-Core Version:    0.6.0
 */
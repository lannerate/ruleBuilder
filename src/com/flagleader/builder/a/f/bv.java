package com.flagleader.builder.a.f;

import com.flagleader.repository.flow.RulePoolFlow;
import com.flagleader.repository.flow.RulePoolNode;
import java.util.List;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphNode;

class bv extends FocusAdapter
{
  bv(bu parambu)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    for (int i = 0; i < bu.b(this.a).getNodes().size(); i++)
    {
      Object localObject = bu.b(this.a).getNodes().get(i);
      if ((!(localObject instanceof GraphNode)) || (((GraphNode)localObject).getData() == null))
        continue;
      RulePoolNode localRulePoolNode = (RulePoolNode)((GraphNode)localObject).getData();
      if ((localRulePoolNode.getX() == ((GraphNode)localObject).getLocation().x) && (localRulePoolNode.getY() == ((GraphNode)localObject).getLocation().y))
        continue;
      localRulePoolNode.setX(((GraphNode)localObject).getLocation().x);
      localRulePoolNode.setY(((GraphNode)localObject).getLocation().y);
      bu.c(this.a).setModified(true);
    }
    super.focusLost(paramFocusEvent);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.bv
 * JD-Core Version:    0.6.0
 */
package com.flagleader.builder.a.f;

import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.RuleFlowActivitie;
import com.flagleader.repository.tree.RuleFlowTransition;
import com.flagleader.repository.tree.RuleTreeFlow;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;

class cV
  implements Listener
{
  cV(cK paramcK, int paramInt1, int paramInt2, GraphConnection paramGraphConnection)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    RuleFlowActivitie localRuleFlowActivitie = cG.c(cK.a(this.a)).addNode("POINT_NODE", this.b, this.c);
    GraphNode localGraphNode = cG.a(cK.a(this.a), localRuleFlowActivitie);
    String str1 = ((RuleFlowTransition)this.d.getData()).getFromUuid();
    String str2 = ((RuleFlowTransition)this.d.getData()).getToUuid();
    IElement localIElement = cG.c(cK.a(this.a)).addTrans(str1, localRuleFlowActivitie.getFlowUuid());
    GraphConnection localGraphConnection;
    if ((localIElement instanceof RuleFlowTransition))
    {
      localGraphConnection = new GraphConnection(cG.b(cK.a(this.a)), 0, this.d.getSource(), localGraphNode);
      localGraphConnection.setData(localIElement);
    }
    localIElement = cG.c(cK.a(this.a)).addTrans(localRuleFlowActivitie.getFlowUuid(), str2);
    if ((localIElement instanceof RuleFlowTransition))
    {
      localGraphConnection = new GraphConnection(cG.b(cK.a(this.a)), 0, localGraphNode, this.d.getDestination());
      localGraphConnection.setData(localIElement);
    }
    ((RuleFlowTransition)this.d.getData()).dispose();
    this.d.dispose();
    cG.c(cK.a(this.a)).setModified(true);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.cV
 * JD-Core Version:    0.6.0
 */
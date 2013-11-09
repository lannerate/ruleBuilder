package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.b.G;
import com.flagleader.builder.widget.h;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.tree.RuleFlowActivitie;
import com.flagleader.repository.tree.RuleFlowTransition;
import com.flagleader.repository.tree.RuleTreeFlow;
import org.eclipse.draw2d.IFigure;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;

class cK
  implements MouseListener
{
  cK(cG paramcG)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    IFigure localIFigure = cG.b(this.a).getFigureAt(paramMouseEvent.x, paramMouseEvent.y);
    if ((localIFigure != null) && (!cG.c(this.a).isLocked()))
    {
      GraphConnection localGraphConnection = cG.b(this.a, localIFigure);
      if (localGraphConnection != null)
      {
        localObject = new G(cG.e(this.a).getShell(), cG.e(this.a), (RuleFlowTransition)localGraphConnection.getData());
        if (((G)localObject).open() == 0)
        {
          String str = ((RuleFlowTransition)localGraphConnection.getData()).getInfo();
          localGraphConnection.setText(str);
          cG.c(this.a).setModified(true);
        }
      }
      Object localObject = cG.a(this.a, localIFigure);
      if (localObject != null)
        cG.e(this.a).getProjectTree().c(((RuleFlowActivitie)((GraphNode)localObject).getData()).getRuleUuid());
    }
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    int i = paramMouseEvent.x;
    int j = paramMouseEvent.y;
    if (paramMouseEvent.button == 3)
    {
      IFigure localIFigure = cG.b(this.a).getFigureAt(paramMouseEvent.x, paramMouseEvent.y);
      Object localObject1;
      if (localIFigure != null)
      {
        localObject1 = cG.a(this.a, localIFigure);
        if ((localObject1 != null) && (!cG.c(this.a).isLocked()))
        {
          if ((!((RuleFlowActivitie)((GraphNode)localObject1).getData()).isStartNode()) || (((RuleFlowActivitie)((GraphNode)localObject1).getData()).isEndNode()))
          {
            cG.a(this.a, h.a());
            if (!((RuleFlowActivitie)((GraphNode)localObject1).getData()).isConditionNode())
            {
              localObject2 = new MenuItem(cG.f(this.a), 8);
              ((MenuItem)localObject2).setText(ResourceTools.getMessage("properties.popup", "properties"));
              ((MenuItem)localObject2).addListener(13, new cL(this, (GraphNode)localObject1));
              localObject2 = new MenuItem(cG.f(this.a), 8);
              ((MenuItem)localObject2).setText(ResourceTools.getMessage("edit.popup", "edit"));
              ((MenuItem)localObject2).addListener(13, new cR(this, (GraphNode)localObject1));
            }
            localObject2 = new MenuItem(cG.f(this.a), 8);
            ((MenuItem)localObject2).setText(ResourceTools.getMessage("delete.popup", "delete"));
            ((MenuItem)localObject2).addListener(13, new cS(this, (GraphNode)localObject1));
            cG.f(this.a).setEnabled(true);
            cG.f(this.a).setVisible(true);
          }
          return;
        }
        Object localObject2 = cG.b(this.a, localIFigure);
        if ((localObject2 != null) && (!cG.c(this.a).isLocked()))
        {
          cG.a(this.a, h.a());
          MenuItem localMenuItem = new MenuItem(cG.f(this.a), 8);
          localMenuItem.setText(ResourceTools.getMessage("edit.popup", "edit"));
          localMenuItem.addListener(13, new cT(this, (GraphConnection)localObject2));
          localMenuItem = new MenuItem(cG.f(this.a), 8);
          localMenuItem.setText(ResourceTools.getMessage("delete.popup", "delete"));
          localMenuItem.addListener(13, new cU(this, (GraphConnection)localObject2));
          localMenuItem = new MenuItem(cG.f(this.a), 2);
          localMenuItem = new MenuItem(cG.f(this.a), 8);
          localMenuItem.setText(ResourceTools.getMessage("newpointnode.popup", "new point node"));
          localMenuItem.setImage(ResourceTools.getImage("RulePoolFlow.icon"));
          localMenuItem.addListener(13, new cV(this, i, j, (GraphConnection)localObject2));
          cG.f(this.a).setEnabled(true);
          cG.f(this.a).setVisible(true);
          return;
        }
      }
      else if (!cG.c(this.a).isLocked())
      {
        cG.a(this.a, h.a());
        localObject1 = new MenuItem(cG.f(this.a), 8);
        ((MenuItem)localObject1).setText(ResourceTools.getMessage("popup_menu_newruleset", "new rule set"));
        ((MenuItem)localObject1).setImage(ResourceTools.getImage("RuleSet.icon"));
        ((MenuItem)localObject1).addListener(13, new cW(this, i, j));
        localObject1 = new MenuItem(cG.f(this.a), 8);
        ((MenuItem)localObject1).setText(ResourceTools.getMessage("popup_menu_newrule", "new rule"));
        ((MenuItem)localObject1).setImage(ResourceTools.getImage("Rule.icon"));
        ((MenuItem)localObject1).addListener(13, new cX(this, i, j));
        localObject1 = new MenuItem(cG.f(this.a), 8);
        ((MenuItem)localObject1).setText(ResourceTools.getMessage("popup_menu_newdecisionmulti", "new decisionmulti"));
        ((MenuItem)localObject1).setImage(ResourceTools.getImage("DecisionMultiRule.icon"));
        ((MenuItem)localObject1).addListener(13, new cY(this, i, j));
        localObject1 = new MenuItem(cG.f(this.a), 8);
        ((MenuItem)localObject1).setText(ResourceTools.getMessage("popup_menu_newdecisionrelate", "new decisionrelate"));
        ((MenuItem)localObject1).setImage(ResourceTools.getImage("DecisionRelateRule.icon"));
        ((MenuItem)localObject1).addListener(13, new cM(this, i, j));
        localObject1 = new MenuItem(cG.f(this.a), 8);
        ((MenuItem)localObject1).setText(ResourceTools.getMessage("popup_menu_newruletreeflow", "new rule flow"));
        ((MenuItem)localObject1).setImage(ResourceTools.getImage("RuleTreeFlow.icon"));
        ((MenuItem)localObject1).addListener(13, new cN(this, i, j));
        localObject1 = new MenuItem(cG.f(this.a), 8);
        ((MenuItem)localObject1).setText(ResourceTools.getMessage("popup_menu_newrulepoolflow", "new rule pool"));
        ((MenuItem)localObject1).setImage(ResourceTools.getImage("RulePoolFlow.icon"));
        ((MenuItem)localObject1).addListener(13, new cO(this, i, j));
        localObject1 = new MenuItem(cG.f(this.a), 2);
        localObject1 = new MenuItem(cG.f(this.a), 8);
        ((MenuItem)localObject1).setText(ResourceTools.getMessage("newtestnode.popup", "new condition node"));
        ((MenuItem)localObject1).setImage(ResourceTools.getImage("RulePoolFlow.icon"));
        ((MenuItem)localObject1).addListener(13, new cP(this, i, j));
        localObject1 = new MenuItem(cG.f(this.a), 2);
        localObject1 = new MenuItem(cG.f(this.a), 8);
        ((MenuItem)localObject1).setText(ResourceTools.getMessage("update.popup", "update"));
        ((MenuItem)localObject1).setImage(ResourceTools.getImage("update.icon"));
        ((MenuItem)localObject1).addListener(13, new cQ(this));
        cG.f(this.a).setEnabled(true);
        cG.f(this.a).setVisible(true);
        return;
      }
    }
  }

  public void mouseUp(MouseEvent paramMouseEvent)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.cK
 * JD-Core Version:    0.6.0
 */
package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.h;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.flow.RulePoolFlow;
import com.flagleader.repository.flow.RulePoolNode;
import org.eclipse.draw2d.IFigure;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphNode;

class bx
  implements MouseListener
{
  bx(bu parambu)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    IFigure localIFigure = bu.b(this.a).getFigureAt(paramMouseEvent.x, paramMouseEvent.y);
    if ((localIFigure != null) && (!bu.c(this.a).isLocked()))
    {
      GraphNode localGraphNode = bu.a(this.a, localIFigure);
      if (localGraphNode != null)
        bu.d(this.a).getProjectTree().c(((RulePoolNode)localGraphNode.getData()).getRuleUuid());
    }
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    int i = paramMouseEvent.x;
    int j = paramMouseEvent.y;
    if (paramMouseEvent.button == 3)
    {
      IFigure localIFigure = bu.b(this.a).getFigureAt(paramMouseEvent.x, paramMouseEvent.y);
      Object localObject;
      if ((localIFigure != null) && (!bu.c(this.a).isLocked()))
      {
        localObject = bu.a(this.a, localIFigure);
        if ((localObject != null) && (!bu.c(this.a).isLocked()))
        {
          MenuItem localMenuItem;
          if (((RulePoolNode)((GraphNode)localObject).getData()).isStartNode())
          {
            bu.a(this.a, h.a());
            localMenuItem = new MenuItem(bu.e(this.a), 8);
            localMenuItem.setText(ResourceTools.getMessage("edit.popup", "edit"));
            localMenuItem.addListener(13, new by(this));
            bu.e(this.a).setEnabled(true);
            bu.e(this.a).setVisible(true);
          }
          else if (!((RulePoolNode)((GraphNode)localObject).getData()).isEndNode())
          {
            bu.a(this.a, h.a());
            localMenuItem = new MenuItem(bu.e(this.a), 8);
            localMenuItem.setText(ResourceTools.getMessage("properties.popup", "properties"));
            localMenuItem.addListener(13, new bB(this, (GraphNode)localObject));
            localMenuItem = new MenuItem(bu.e(this.a), 8);
            localMenuItem.setText(ResourceTools.getMessage("edit.popup", "edit"));
            localMenuItem.addListener(13, new bC(this, (GraphNode)localObject));
            localMenuItem = new MenuItem(bu.e(this.a), 8);
            localMenuItem.setText(ResourceTools.getMessage("delete.popup", "delete"));
            localMenuItem.addListener(13, new bD(this, (GraphNode)localObject));
            bu.e(this.a).setEnabled(true);
            bu.e(this.a).setVisible(true);
          }
          return;
        }
      }
      else if (!bu.c(this.a).isLocked())
      {
        bu.a(this.a, h.a());
        localObject = new MenuItem(bu.e(this.a), 8);
        ((MenuItem)localObject).setText(ResourceTools.getMessage("popup_menu_newruleset", "new rule set"));
        ((MenuItem)localObject).setImage(ResourceTools.getImage("RuleSet.icon"));
        ((MenuItem)localObject).addListener(13, new bE(this, i, j));
        localObject = new MenuItem(bu.e(this.a), 8);
        ((MenuItem)localObject).setText(ResourceTools.getMessage("popup_menu_newrule", "new rule"));
        ((MenuItem)localObject).setImage(ResourceTools.getImage("Rule.icon"));
        ((MenuItem)localObject).addListener(13, new bF(this, i, j));
        localObject = new MenuItem(bu.e(this.a), 8);
        ((MenuItem)localObject).setText(ResourceTools.getMessage("popup_menu_newdecisionmulti", "new decisionmulti"));
        ((MenuItem)localObject).setImage(ResourceTools.getImage("DecisionMultiRule.icon"));
        ((MenuItem)localObject).addListener(13, new bG(this, i, j));
        localObject = new MenuItem(bu.e(this.a), 8);
        ((MenuItem)localObject).setText(ResourceTools.getMessage("popup_menu_newdecisionrelate", "new decisionrelate"));
        ((MenuItem)localObject).setImage(ResourceTools.getImage("DecisionRelateRule.icon"));
        ((MenuItem)localObject).addListener(13, new bH(this, i, j));
        localObject = new MenuItem(bu.e(this.a), 8);
        ((MenuItem)localObject).setText(ResourceTools.getMessage("popup_menu_newruletreeflow", "new rule flow"));
        ((MenuItem)localObject).setImage(ResourceTools.getImage("RuleTreeFlow.icon"));
        ((MenuItem)localObject).addListener(13, new bI(this, i, j));
        localObject = new MenuItem(bu.e(this.a), 8);
        ((MenuItem)localObject).setText(ResourceTools.getMessage("popup_menu_newrulepoolflow", "new rule pool"));
        ((MenuItem)localObject).setImage(ResourceTools.getImage("RulePoolFlow.icon"));
        ((MenuItem)localObject).addListener(13, new bz(this, i, j));
        localObject = new MenuItem(bu.e(this.a), 2);
        localObject = new MenuItem(bu.e(this.a), 8);
        ((MenuItem)localObject).setText(ResourceTools.getMessage("update.popup", "update"));
        ((MenuItem)localObject).setImage(ResourceTools.getImage("update.icon"));
        ((MenuItem)localObject).addListener(13, new bA(this));
        bu.e(this.a).setEnabled(true);
        bu.e(this.a).setVisible(true);
        return;
      }
    }
  }

  public void mouseUp(MouseEvent paramMouseEvent)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.bx
 * JD-Core Version:    0.6.0
 */
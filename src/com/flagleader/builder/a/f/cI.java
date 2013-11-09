package com.flagleader.builder.a.f;

import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.RuleFlowActivitie;
import com.flagleader.repository.tree.RuleFlowTransition;
import com.flagleader.repository.tree.RuleTreeFlow;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.SWTEventDispatcher;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;

class cI extends SWTEventDispatcher
{
  cI(cG paramcG)
  {
  }

  public void dispatchMouseMoved(MouseEvent paramMouseEvent)
  {
    if (((paramMouseEvent.stateMask & SWT.MOD3) != 0) && (cG.d(this.a) != null))
    {
      IFigure localIFigure = cG.b(this.a).getFigureAt(paramMouseEvent.x, paramMouseEvent.y);
      int i = 0;
      if (localIFigure != null)
      {
        GraphNode localGraphNode = cG.a(this.a, localIFigure);
        if ((localGraphNode != null) && (!localGraphNode.equals(cG.d(this.a))) && (!((RuleFlowActivitie)localGraphNode.getData()).isStartNode()))
        {
          String str1 = ((RuleFlowActivitie)cG.d(this.a).getData()).getFlowUuid();
          String str2 = ((RuleFlowActivitie)localGraphNode.getData()).getFlowUuid();
          if (!cG.c(this.a).exitsTransition(str1, str2))
          {
            cG.b(this.a).setCursor(cG.b(this.a).getShell().getDisplay().getSystemCursor(2));
            return;
          }
        }
      }
      cG.b(this.a).setCursor(cG.b(this.a).getShell().getDisplay().getSystemCursor(21));
    }
    else
    {
      super.dispatchMouseMoved(paramMouseEvent);
    }
  }

  public void dispatchMousePressed(MouseEvent paramMouseEvent)
  {
    if ((paramMouseEvent.button == 1) && ((paramMouseEvent.stateMask & SWT.MOD3) != 0))
    {
      IFigure localIFigure = cG.b(this.a).getFigureAt(paramMouseEvent.x, paramMouseEvent.y);
      if (localIFigure != null)
      {
        GraphNode localGraphNode = cG.a(this.a, localIFigure);
        if ((localGraphNode != null) && (!((RuleFlowActivitie)localGraphNode.getData()).isEndNode()))
        {
          cG.a(this.a, localGraphNode);
          cG.b(this.a).setCursor(cG.b(this.a).getShell().getDisplay().getSystemCursor(21));
        }
      }
    }
    else
    {
      super.dispatchMousePressed(paramMouseEvent);
    }
  }

  public void dispatchMouseReleased(MouseEvent paramMouseEvent)
  {
    if ((paramMouseEvent.button == 1) && ((paramMouseEvent.stateMask & SWT.MOD3) != 0) && (cG.d(this.a) != null))
    {
      IFigure localIFigure = cG.b(this.a).getFigureAt(paramMouseEvent.x, paramMouseEvent.y);
      if (localIFigure != null)
      {
        GraphNode localGraphNode = cG.a(this.a, localIFigure);
        if ((localGraphNode != null) && (!localGraphNode.equals(cG.d(this.a))) && (!((RuleFlowActivitie)localGraphNode.getData()).isStartNode()))
        {
          String str1 = ((RuleFlowActivitie)cG.d(this.a).getData()).getFlowUuid();
          String str2 = ((RuleFlowActivitie)localGraphNode.getData()).getFlowUuid();
          if (!cG.c(this.a).exitsTransition(str1, str2))
          {
            IElement localIElement = cG.c(this.a).addTrans(str1, str2);
            if ((localIElement instanceof RuleFlowTransition))
            {
              GraphConnection localGraphConnection = new GraphConnection(cG.b(this.a), 0, cG.d(this.a), localGraphNode);
              localGraphConnection.setData(localIElement);
              cG.c(this.a).setModified(true);
            }
          }
        }
      }
    }
    else
    {
      super.dispatchMouseReleased(paramMouseEvent);
    }
    cG.a(this.a, null);
    cG.b(this.a).setCursor(null);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.cI
 * JD-Core Version:    0.6.0
 */
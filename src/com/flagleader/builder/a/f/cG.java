package com.flagleader.builder.a.f;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.d;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.RuleFlowActivitie;
import com.flagleader.repository.tree.RuleFlowTransition;
import com.flagleader.repository.tree.RuleTreeFlow;
import java.util.List;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.PolylineShape;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.zest.core.widgets.CGraphNode;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;

public class cG extends aS
  implements IElementViewer
{
  private RuleTreeFlow f;
  private Graph g;
  boolean e = false;
  private boolean q = false;
  private Menu r;
  private String s = "";
  private int t = 0;
  private GraphNode u;

  public cG(RuleTreeFlow paramRuleTreeFlow, Composite paramComposite, bu parambu)
  {
    super(paramRuleTreeFlow, paramComposite, parambu);
    this.f = paramRuleTreeFlow;
  }

  protected aS e(Composite paramComposite)
  {
    return new cG((RuleTreeFlow)this.c, paramComposite, this.a);
  }

  protected void a(ToolBar paramToolBar)
  {
    super.a(paramToolBar);
  }

  protected void h()
  {
    super.h();
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    this.g = new Graph(localComposite, 0);
    this.g.setLayoutData(new GridData(1808));
    this.g.setConnectionStyle(2);
    this.g.addFocusListener(new cH(this));
    this.g.getLightweightSystem().setEventDispatcher(new cI(this));
    DropTarget localDropTarget = new DropTarget(this.g, 19);
    localDropTarget.setTransfer(new Transfer[] { TextTransfer.getInstance(), d.a() });
    localDropTarget.addDropListener(new cJ(this));
    this.g.addMouseListener(new cK(this));
    return localComposite;
  }

  private GraphNode a(IFigure paramIFigure)
  {
    List localList = this.g.getNodes();
    for (int i = localList.size() - 1; i >= 0; i--)
    {
      GraphNode localGraphNode = (GraphNode)localList.get(i);
      if (localGraphNode.getNodeFigure().equals(paramIFigure))
        return localGraphNode;
    }
    return null;
  }

  private GraphConnection b(IFigure paramIFigure)
  {
    List localList = this.g.getConnections();
    for (int i = localList.size() - 1; i >= 0; i--)
    {
      GraphConnection localGraphConnection = (GraphConnection)localList.get(i);
      if (localGraphConnection.getConnectionFigure().equals(paramIFigure))
        return localGraphConnection;
    }
    return null;
  }

  private GraphNode a(RuleFlowActivitie paramRuleFlowActivitie)
  {
    if (paramRuleFlowActivitie.isConditionNode())
    {
      localObject = new CGraphNode(this.g, 0, a(40, 40));
      ((CGraphNode)localObject).setLocation(paramRuleFlowActivitie.getX(), paramRuleFlowActivitie.getY());
      ((CGraphNode)localObject).setData(paramRuleFlowActivitie);
      paramRuleFlowActivitie.setWidth(((CGraphNode)localObject).getSize().width);
      paramRuleFlowActivitie.setHeight(((CGraphNode)localObject).getSize().height);
      return localObject;
    }
    if (paramRuleFlowActivitie.isPointNode())
    {
      localObject = new GraphNode(this.g, 0, "");
      ((GraphNode)localObject).setSize(5.0D, 5.0D);
      ((GraphNode)localObject).setLocation(paramRuleFlowActivitie.getX(), paramRuleFlowActivitie.getY());
      ((GraphNode)localObject).setData(paramRuleFlowActivitie);
      paramRuleFlowActivitie.setWidth(((GraphNode)localObject).getSize().width);
      paramRuleFlowActivitie.setHeight(((GraphNode)localObject).getSize().height);
      return localObject;
    }
    Object localObject = new GraphNode(this.g, 0, paramRuleFlowActivitie.getDisplayName(), b(paramRuleFlowActivitie));
    ((GraphNode)localObject).setLocation(paramRuleFlowActivitie.getX(), paramRuleFlowActivitie.getY());
    ((GraphNode)localObject).setData(paramRuleFlowActivitie);
    paramRuleFlowActivitie.setWidth(((GraphNode)localObject).getSize().width);
    paramRuleFlowActivitie.setHeight(((GraphNode)localObject).getSize().height);
    return (GraphNode)localObject;
  }

  private Image b(RuleFlowActivitie paramRuleFlowActivitie)
  {
    return ResourceTools.getImage(paramRuleFlowActivitie.getImageName() + ".icon");
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    List localList1 = this.g.getNodes();
    for (int i = localList1.size() - 1; i >= 0; i--)
    {
      GraphNode localGraphNode1 = (GraphNode)localList1.get(i);
      if (localGraphNode1.isDisposed())
        continue;
      localGraphNode1.dispose();
    }
    List localList2 = this.f.getChildrenList();
    Object localObject1;
    for (int j = 0; j < localList2.size(); j++)
    {
      if (!(localList2.get(j) instanceof RuleFlowActivitie))
        continue;
      localObject1 = (RuleFlowActivitie)localList2.get(j);
      a((RuleFlowActivitie)localObject1);
    }
    for (j = 0; j < localList2.size(); j++)
    {
      if (!(localList2.get(j) instanceof RuleFlowTransition))
        continue;
      localObject1 = (RuleFlowTransition)localList2.get(j);
      Object localObject2 = null;
      Object localObject3 = null;
      List localList3 = this.g.getNodes();
      for (int k = 0; k < localList3.size(); k++)
      {
        GraphNode localGraphNode2 = (GraphNode)localList3.get(k);
        if ((localGraphNode2.getData() != null) && (((RuleFlowActivitie)localGraphNode2.getData()).getFlowUuid().equals(((RuleFlowTransition)localObject1).getFromUuid())))
        {
          localObject2 = localGraphNode2;
        }
        else
        {
          if ((localGraphNode2.getData() == null) || ((!((RuleFlowActivitie)localGraphNode2.getData()).getFlowUuid().equals(((RuleFlowTransition)localObject1).getToUuid())) && (!((RuleFlowActivitie)localGraphNode2.getData()).getUuid().equals(((RuleFlowTransition)localObject1).getToUuid()))))
            continue;
          localObject3 = localGraphNode2;
        }
      }
      if ((localObject2 == null) || (localObject3 == null))
        continue;
      GraphConnection localGraphConnection = new GraphConnection(this.g, 0, localObject2, localObject3);
      localGraphConnection.setText(((RuleFlowTransition)localObject1).getInfo());
      localGraphConnection.setData(localObject1);
    }
    this.g.redraw();
    super.update();
  }

  public boolean needUpdate()
  {
    return (this.d == 0L) || (this.d < this.f.getMaxModifyTime()) || (this.d < this.f.getEnvionment().getMaxModifyTime());
  }

  private static org.eclipse.swt.graphics.Point b(Control paramControl)
  {
    int i = paramControl.getLocation().x;
    int j = paramControl.getLocation().y;
    while (paramControl.getParent() != null)
    {
      paramControl = paramControl.getParent();
      i += paramControl.getLocation().x;
      j += paramControl.getLocation().y;
    }
    return new org.eclipse.swt.graphics.Point(i, j);
  }

  public String getCompositeUuid()
  {
    return this.f.getEditUuid() + "tree";
  }

  public static IFigure a(int paramInt1, int paramInt2)
  {
    Figure localFigure = new Figure();
    localFigure.setLayoutManager(new FreeformLayout());
    PolylineShape localPolylineShape1 = new PolylineShape();
    localPolylineShape1.setLineWidth(1);
    localPolylineShape1.setStart(new org.eclipse.draw2d.geometry.Point(0, paramInt2 / 2));
    localPolylineShape1.setEnd(new org.eclipse.draw2d.geometry.Point(paramInt1 / 2, 0));
    localPolylineShape1.setBounds(new Rectangle(0, 0, paramInt1 / 2, paramInt2 / 2));
    PolylineShape localPolylineShape2 = new PolylineShape();
    localPolylineShape2.setLineWidth(1);
    localPolylineShape2.setStart(new org.eclipse.draw2d.geometry.Point(0, paramInt2 / 2));
    localPolylineShape2.setEnd(new org.eclipse.draw2d.geometry.Point(paramInt1 / 2, paramInt2));
    localPolylineShape2.setBounds(new Rectangle(0, 0, paramInt1 / 2, paramInt2));
    PolylineShape localPolylineShape3 = new PolylineShape();
    localPolylineShape3.setLineWidth(1);
    localPolylineShape3.setStart(new org.eclipse.draw2d.geometry.Point(paramInt1 / 2, 0));
    localPolylineShape3.setEnd(new org.eclipse.draw2d.geometry.Point(paramInt1, paramInt2 / 2));
    localPolylineShape3.setBounds(new Rectangle(0, 0, paramInt1, paramInt2 / 2));
    PolylineShape localPolylineShape4 = new PolylineShape();
    localPolylineShape4.setLineWidth(1);
    localPolylineShape4.setStart(new org.eclipse.draw2d.geometry.Point(paramInt1 / 2, paramInt2));
    localPolylineShape4.setEnd(new org.eclipse.draw2d.geometry.Point(paramInt1, paramInt2 / 2));
    localPolylineShape4.setBounds(new Rectangle(0, 0, paramInt1, paramInt2));
    localFigure.add(localPolylineShape1);
    localFigure.add(localPolylineShape2);
    localFigure.add(localPolylineShape3);
    localFigure.add(localPolylineShape4);
    localFigure.setSize(paramInt1, paramInt2);
    return localFigure;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.cG
 * JD-Core Version:    0.6.0
 */